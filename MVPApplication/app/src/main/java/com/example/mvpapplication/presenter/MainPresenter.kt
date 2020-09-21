package com.example.mvpapplication.presenter

import com.example.mvpapplication.contract.ContractInterface
import com.example.mvpapplication.model.MainModel

class MainPresenter(private val _view: ContractInterface.View) : ContractInterface.Presenter {

    private val model: ContractInterface.Model = MainModel()

    init {
        _view.initView()
    }

    override fun incrementValue() {
        model.incrementCounter()
        _view.updateViewData()
    }

    override fun getCounter() = model.getCounter().toString()

}