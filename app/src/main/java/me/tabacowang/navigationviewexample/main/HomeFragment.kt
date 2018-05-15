package me.tabacowang.navigationviewexample.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.tabacowang.navigationviewexample.R

class HomeFragment : Fragment(), MainContract.View {
    override lateinit var presenter: MainContract.Presenter

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        setHasOptionsMenu(true)
        return root
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

}