package com.example.bairestest

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_google.*


class GoogleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        webView.loadUrl("http://www.google.com")
        return inflater.inflate(R.layout.fragment_google, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = GoogleFragment()
    }
}
