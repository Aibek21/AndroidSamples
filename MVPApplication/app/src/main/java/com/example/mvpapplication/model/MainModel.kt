package com.example.mvpapplication.model

import com.example.mvpapplication.contract.ContractInterface

class MainModel : ContractInterface.Model {
    private var mCounter = 0

    override fun getCounter(): Int {
        return mCounter
    }

    override fun incrementCounter() {
        mCounter++
    }
}