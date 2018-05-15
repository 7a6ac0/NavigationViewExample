package me.tabacowang.navigationviewexample.main

class MainPresenter(private val mainView: MainContract.View)
    : MainContract.Presenter {

    init {
        mainView.presenter = this
    }

    override fun start() {
    }
}