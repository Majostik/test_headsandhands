package com.example.majo.test_hah.ui.main

import com.example.majo.test_hah.base.BaseView
import com.example.majo.test_hah.data.api.model.Data

interface MainView : BaseView {
    fun onGetResult(data: Data)
}

