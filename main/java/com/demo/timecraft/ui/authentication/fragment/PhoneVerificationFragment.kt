package com.demo.timecraft.ui.authentication.fragment


import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.demo.timecraft.R
import com.demo.timecraft.model.Validation
import com.demo.timecraft.ui.base.BaseFragment
import kotlinx.android.synthetic.main.authentication_fragment_phone_verification.*


class PhoneVerificationFragment : BaseFragment(), TextWatcher {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.authentication_fragment_phone_verification,
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imageButtonNextScreen.setOnClickListener {
            if (validation()) {
                replaceFragment(SignUpFragment(), true)
            }
        }

        buttonImageClose.setOnClickListener {
            requireActivity().onBackPressed()
        }

        editTextOtpOne.addTextChangedListener(this)
        editTextOtpTwo.addTextChangedListener(this)
        editTextOtpThree.addTextChangedListener(this)
        editTextOtpFour.addTextChangedListener(this)
    }

    private fun validation(): Boolean {
        val validation = Validation(requireContext())
        return try {
            validation.validateOtp(editTextOtpOne.text.toString())
            validation.validateOtp(editTextOtpTwo.text.toString())
            validation.validateOtp(editTextOtpThree.text.toString())
            validation.validateOtp(editTextOtpFour.text.toString())
            true
        } catch (e: Exception) {
            Toast.makeText(requireContext(), e.message, Toast.LENGTH_SHORT).show()
            false
        }
    }

    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (editTextOtpOne.text.toString().length == 1) {
            editTextOtpTwo.requestFocus()
            if (editTextOtpTwo.text.toString().length == 1) {
                editTextOtpThree.requestFocus()
                if (editTextOtpThree.text.toString().length == 1) {
                    editTextOtpFour.requestFocus()
                    if (editTextOtpFour.text.toString().length == 1) {
                        val inputKeyboard =
                            requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                        val view = requireActivity().currentFocus
                        inputKeyboard.hideSoftInputFromWindow(view?.windowToken, 0)

                    }
                }
            }
        }

    }
}
