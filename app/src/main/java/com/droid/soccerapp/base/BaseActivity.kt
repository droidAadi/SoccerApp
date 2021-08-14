package com.droid.soccerapp.base

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * @author adityakhullar on 09/07/21.
 */
abstract class BaseActivity<D : ViewDataBinding>(private val layoutContainerId: Int) :
    AppCompatActivity() {

    protected abstract val viewModel: BaseViewModel
    protected lateinit var dataBinding: D


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, layoutContainerId)
        dataBinding.lifecycleOwner = this
    }

    protected fun setToolbar(toolbar: Toolbar, title: String = "") {
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.title = title
        }
    }
}