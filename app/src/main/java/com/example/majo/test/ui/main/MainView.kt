package com.example.majo.test.ui.main

import com.example.majo.test.base.BaseView
import com.example.majo.test.data.api.model.Data

interface MainView : BaseView {
    fun onGetResult(data: Data)
}

