package com.example.majo.test.ui.main

import android.graphics.PorterDuff
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Patterns
import android.view.Menu
import com.example.majo.test.R
import com.example.majo.test.base.AbstractBaseActivity
import com.example.majo.test.data.api.model.Data
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AbstractBaseActivity<MainView, MainPresenter>(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        setToolbarWithBackButton(mainToolbar)
        supportActionBar?.title = getString(R.string.toolbar_title)
        mainToolbar.getNavigationIcon()?.setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP)

        mainSignInBtn.setOnClickListener {
            if (isInputValid()){
                presenter.signIn(mainEmailEt.text.toString(), mainPasswordEt.text.toString())
            }
        }
    }

    private fun isInputValid(): Boolean{
        var isValid = true

        val patten = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+\$")

        val email = mainEmailEt.text.toString()
        val password = mainPasswordEt.text.toString()

        mainEmailTil.error = null
        mainPasswordTil.error = null

        if (email.isEmpty()){
            isValid = false
            mainEmailTil.error = getString(R.string.error_empty_email)
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            isValid = false
            mainEmailTil.error = getString(R.string.error_email_not_valid)
        }

        if (password.isEmpty()){
            isValid = false
            mainPasswordTil.error = getString(R.string.error_password_empty)
        } else if (password.length < 6){
            isValid = false
            mainPasswordTil.error = getString(R.string.error_password_length)
        } else if (!patten.matcher(password).matches()) {
            isValid = false
            mainPasswordTil.error = getString(R.string.error_password_pattern)
        }

        return isValid
    }

    override fun onGetResult(data: Data) {
        Snackbar.make(mainLayout, getString(R.string.weather_result, data.main.temp), Snackbar.LENGTH_LONG)
                .show();
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


}
