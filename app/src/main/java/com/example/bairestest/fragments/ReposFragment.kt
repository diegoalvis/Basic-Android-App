package com.example.bairestest.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bairestest.R


class ReposFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_repos, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance() = ReposFragment()
    }
}
