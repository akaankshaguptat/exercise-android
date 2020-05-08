package com.example.view.gallery1

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gallery1.R
import com.example.gallery1.view.activity.Gallery1Activity
import com.example.gallery1.view.activity.MainActivity.Companion.manager
import com.example.gallery1.viewmodel.LoginViewModel
import com.google.firebase.auth.FirebaseAuth

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mEmail: EditText
    private lateinit var mPassword: EditText
    private lateinit var mSignInBtn: Button


    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_login, container, false)

        var btn_SignUp = view.findViewById<Button>(R.id.btn_SignUp)
        mSignInBtn = view.findViewById(R.id.btn_SignIn)
        mEmail = view.findViewById(R.id.EditText_emaillogin)
        mPassword = view.findViewById(R.id.EditText_passlogin)
        auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            var intent = Intent(activity, Gallery1Activity::class.java)
            startActivity(intent)
        }

        btn_SignUp.setOnClickListener {
            manager.beginTransaction().replace(
                R.id.login_holder,
                SignupFragment.newInstance("1", "2")
            )
                .addToBackStack(null).commit()

        }
        var btn_SignIn = view.findViewById<Button>(R.id.btn_SignIn)
        btn_SignIn.setOnClickListener {
            var email_login: String = mEmail.text.toString().trim()
            var password_login: String = mPassword.text.toString().trim()

            if (TextUtils.isEmpty(email_login)) {
                mEmail.setError("Email is Required")
                mEmail.requestFocus()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(password_login)) {
                mPassword.setError("Password is requied")
                mPassword.requestFocus()
                return@setOnClickListener
            }



            activity?.let { it1 ->
                var loginViewModel: LoginViewModel =
                    ViewModelProvider(this)[LoginViewModel::class.java]
                loginViewModel.loginStatus(email_login, password_login, it1)
                    .observe(activity!!, Observer { it ->

                        if (it) {
                            Toast.makeText(context, "login successful", Toast.LENGTH_SHORT).show()
                            val user = auth.currentUser
                            var intent = Intent(activity, Gallery1Activity::class.java)
                            startActivity(intent)
                        } else {
                            //  Log.w(ContentValues.TAG, "loginUserWithEmail:failure", task.exception)
                            Toast.makeText(context, "login failed.", Toast.LENGTH_SHORT).show()
                        }

                    })

            }


        }


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
