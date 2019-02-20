package com.example.bairestest.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.bairestest.R
import kotlinx.android.synthetic.main.fragment_buttons.*


class ButtonsFragment : androidx.fragment.app.Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonToast.setOnClickListener { Toast.makeText(activity, "Showing toast...", Toast.LENGTH_SHORT).show() }
        buttonAlert.setOnClickListener {
            AlertDialog.Builder(activity).apply {
                setTitle("Alert")
                setMessage("Showing alert dialog...")
                setNeutralButton("OK") { _, _ -> Unit }
                show()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ButtonsFragment()
    }
}
