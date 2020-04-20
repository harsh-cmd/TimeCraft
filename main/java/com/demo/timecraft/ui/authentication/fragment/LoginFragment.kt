package com.demo.timecraft.ui.authentication.fragment


import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.demo.timecraft.R
import com.demo.timecraft.model.Validation
import com.demo.timecraft.ui.authentication.adapter.SpinnerAdapter
import com.demo.timecraft.ui.base.BaseFragment
import kotlinx.android.synthetic.main.authentication_fragment_login.*

class LoginFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.authentication_fragment_login, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        spinnerCountryCode.adapter =
            SpinnerAdapter(requireContext(), android.R.layout.simple_list_item_1, contryCodeList())

        imageButtonNextScreen.setOnClickListener {
            if (validation()) {
                replaceFragment(PhoneVerificationFragment())
            }
        }
        var number: String = ""

        editTextMobile.addTextChangedListener(PhoneNumberFormattingTextWatcher("US"))

    }

    private fun contryCodeList(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("+00")
        list.add("+01")
        list.add("+02")
        list.add("+03")
        list.add("+04")
        list.add("+05")
        return list
    }

    private fun validation(): Boolean {
        val validation = Validation(requireContext())
        return try {
            validation.validateMobileNumber(editTextMobile.text.toString())
            validation.validateCountryCode(spinnerCountryCode.selectedItem.toString())
            true
        } catch (e: Exception) {
            Toast.makeText(requireContext(), e.message, Toast.LENGTH_SHORT).show()
            false
        }
    }
}
