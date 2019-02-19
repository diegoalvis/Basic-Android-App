package com.example.bairestest

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_buttons.*


class ButtonsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        buttonToast.setOnClickListener { Toast.makeText(activity, "Showing toast...", Toast.LENGTH_SHORT).show() }
        buttonAlert.setOnClickListener {
            AlertDialog.Builder(activity).apply {
                setTitle("Alert")
                setMessage("Showing alert dialog...")
                setNeutralButton("OK") { _, _ -> Unit }
            }
        }


        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance() = ReposFragment()
    }
}
