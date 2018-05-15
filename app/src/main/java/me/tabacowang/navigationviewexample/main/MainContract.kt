package me.tabacowang.navigationviewexample.main

import me.tabacowang.navigationviewexample.BasePresenter
import me.tabacowang.navigationviewexample.BaseView

interface MainContract {

    interface View : BaseView<Presenter> {

    }

    interface Presenter : BasePresenter {

    }
}