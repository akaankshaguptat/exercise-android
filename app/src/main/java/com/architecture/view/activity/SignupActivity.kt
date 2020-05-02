package com.architecture.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.architecture.R
import com.architecture.util.showToast
import com.architecture.viewmodel.MyViewModelFactory
import com.architecture.viewmodel.SigninViewModel
import com.architecture.viewmodel.SignupViewModel
import kotlinx.android.synthetic.main.a_signin.*
import kotlinx.android.synthetic.main.a_signup.*
import kotlinx.android.synthetic.main.a_signup.edit_email
import kotlinx.android.synthetic.main.a_signup.edit_pwd

class SignupActivity : BaseActivity(),View.OnClickListener{

    // Init view model lazy
    private val mViewModel by lazy {
        ViewModelProvider(this, MyViewModelFactory()).get(SignupViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_signup)

        setListeners()
        setObservers()
    }

    /**
     * Observe live data in viewmodel
     */
    private fun setObservers() {
        // Observer error message
        mViewModel.getErrMessage().observe(this, Observer {
            showToast(it)
        })


        // Observe login state
        mViewModel.getSignupState().observe(this, Observer {
            when(it) {
                SignupViewModel.SignupState.SHOW_PROGRESS ->
                    showProgress()
                SignupViewModel.SignupState.HIDE_PROGRESS ->
                    hideProgress()
                SignupViewModel.SignupState.GO_TO_HOME_SCREEN ->
                    goToHomeScreen()
            }
        })
    }

    private fun goToHomeScreen() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }


    private fun setListeners() {
        btn_signup.setOnClickListener(this)
        txt_singin.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if(view==btn_signup){
            onSignUpClicked()
        }else if(view==txt_singin){
            goToSigninScreen()
        }
    }

    /**
     * Go to signin screen
     */
    private fun goToSigninScreen() {
        val intent = Intent(this, SigninActivity::class.java)
        startActivity(intent)
    }

    private fun onSignUpClicked() {
        mViewModel.onSignupClicked(edit_email.text.toString(), edit_pwd.text.toString())

    }
}