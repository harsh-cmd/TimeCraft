package com.demo.timecraft.ui.authentication.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.demo.timecraft.R
import com.demo.timecraft.model.Validation
import com.demo.timecraft.ui.base.BaseFragment
import com.demo.timecraft.ui.home.HomeActivity
import kotlinx.android.synthetic.main.authentication_fragment_sign_up.*


class SignUpFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.authentication_fragment_sign_up, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imageViewRight.setOnClickListener {
            if (validation()) {
                requireActivity().startActivity(
                    Intent(
                        requireContext(),
                        HomeActivity()::class.java
                    )
                )
                requireActivity().finishAffinity()
            }
        }

        buttonImageClose.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun validation(): Boolean {
        val valid = Validation(requireContext())
        return try {
            valid.validateFirstName(editTextFirstName.text.toString())
            valid.validateLastName(editTextLastName.text.toString())
            true
        } catch (e: Exception) {
            Toast.makeText(requireContext(), e.message, Toast.LENGTH_SHORT).show()
            false
        }
    }
}
