package com.demo.timecraft.model

import android.content.Context
import android.util.Patterns
import com.demo.timecraft.R

class Validation(val context: Context) {

    fun validateUsername(username: String) {
        require(username.isNotEmpty()) {
            context.getString(R.string.validation_username)
        }
    }

    fun validateMobileNumber(number: String) {
        require(number.isNotEmpty()) {
            context.getString(R.string.validation_mobile_empty)
        }

        require(number.length == 14)
        {
            context.getString(R.string.validation_mobile)
        }
    }

    fun validateEmail(email: String) {
        require(email.isNotEmpty()) {
            context.getString(R.string.validation_email_empty)
        }

        require(Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            context.getString(R.string.validation_email)
        }
    }

    fun validatePassword(password: String) {
        require(password.isNotEmpty()) {
            context.getString(R.string.validation_password_empty)
        }
    }

    fun validateFirstName(firstName: String) {
        require(firstName.isNotEmpty()) {
            context.getString(R.string.validation_first_name)
        }
    }

    fun validateLastName(lastName: String) {
        require(lastName.isNotEmpty()) {
            context.getString(R.string.validation_last_name)
        }
    }
    
    fun validateCountryCode(countryCode:String){
        require(countryCode!="+00")
        {
            context.getString(R.string.validation_country_code)
        }
    }

    fun validateOtp(otp:String){
        require(otp.isNotEmpty())
        {
            context.getString(R.string.validation_otp)
        }
    }
}