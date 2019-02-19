package com.example.bairestest.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bairestest.R
import kotlinx.android.synthetic.main.fragment_google.*


class GoogleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_google, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView.loadUrl("http://www.google.com")
    }

    companion object {
        @JvmStatic
        fun newInstance() = GoogleFragment()
    }
}
