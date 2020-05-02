package com.architecture.viewmodel

import android.accounts.AuthenticatorException
import android.content.Context
import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.architecture.R
import com.architecture.model.exception.ServerNotResponding
import com.architecture.model.repo.Repository
import com.architecture.util.ValidationUtils
import com.architecture.util.isNetworkAvailable
import java.lang.Exception

class SignupViewModel(private val context: Context, private val repository: Repository) : ViewModel() {
    private var errMessage = MutableLiveData<String>()
    private var signupState = MediatorLiveData<SignupState>()
    init {
        checkIsAlreadySignup()
    }


    private fun checkIsAlreadySignup() {
        signupState.addSource(repository.isLoggedIn(), Observer {
            if(it) {
                signupState.value = SignupState.GO_TO_HOME_SCREEN
            }
        })
    }

    fun getErrMessage(): LiveData<String> {
        return errMessage
    }
    fun getSignupState(): LiveData<SignupViewModel.SignupState> {
        return signupState
    }

    fun onSignupClicked(email: String, pwd: String) {

        // Check validations
        if(TextUtils.isEmpty(email)) {
            // Email field is blank
            errMessage.value = context.getString(R.string.err_blank_email)
            return
        } else if(!ValidationUtils.isValidEmail(email)) {
            // Invalid email id
            errMessage.value = context.getString(R.string.err_invalid_email)
            return
        } else if(TextUtils.isEmpty(pwd)) {
            // Empty password
            errMessage.value = context.getString(R.string.err_blank_pwd)
            return
        }

        // Check internet connection
        if(!context.isNetworkAvailable()) {
            // No internet
            errMessage.value = context.getString(R.string.err_no_internet)
            return
        }

        // Hit api
        signupState.value = SignupState.SHOW_PROGRESS
        signupState.addSource(repository.signUp(email, pwd), Observer {
            it.onSuccess {
                signupState.value = SignupState.HIDE_PROGRESS
                signupState.value = SignupState.GO_TO_HOME_SCREEN
            }
            it.onFailure {
                signupState.value =SignupState.HIDE_PROGRESS
                when(it){
                    is AuthenticatorException ->{
                        errMessage.value = it.message
                    }
                    is ServerNotResponding ->{
                        errMessage.value = it.message
                    }
                    is Exception -> {
                        errMessage.value = it.message
                    }
                }
            }
        })


    }

    enum class SignupState {
        SHOW_PROGRESS,
        HIDE_PROGRESS,
        GO_TO_HOME_SCREEN
    }

}