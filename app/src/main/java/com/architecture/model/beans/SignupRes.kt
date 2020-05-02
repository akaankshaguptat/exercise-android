package com.architecture.model.beans

import com.google.gson.annotations.SerializedName

class SignupRes {
    @SerializedName("token")
    lateinit var token: String
}