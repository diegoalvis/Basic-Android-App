package com.example.bairestest.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.diegoalvis.android.newsapp.api.ApiClient
import com.example.bairestest.R
import com.example.bairestest.RepoAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_repos.*
import kotlinx.android.synthetic.main.fragment_repos.view.*
import android.content.Intent
import android.net.Uri


class ReposFragment : androidx.fragment.app.Fragment() {

    private val apiInterface by lazy { ApiClient.getInterface() }

    private val adapter = RepoAdapter(this::onRepoClick)

    private fun onRepoClick(pos: Int) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(adapter.data[pos].html_url)))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_repos, container, false)

        view.list.adapter = adapter
        view.list.layoutManager = LinearLayoutManager(activity!!)

        return inflater.inflate(R.layout.fragment_repos, container, false)
    }


    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(activity!!)

        progress.visibility = View.VISIBLE
        apiInterface
            .searchRepos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                progress.visibility = View.GONE
                adapter.data = it.items.subList(0, 10)
                adapter.notifyDataSetChanged()
            }, {
                progress.visibility = View.GONE
                it.printStackTrace()
            })

    }

    companion object {
        @JvmStatic
        fun newInstance() = ReposFragment()
    }
}
