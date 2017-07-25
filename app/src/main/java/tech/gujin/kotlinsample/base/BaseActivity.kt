package tech.gujin.kotlinsample.base

import android.app.Activity
import android.content.Context
import android.os.Bundle

abstract class BaseActivity : Activity() {
    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        mContext = this
        initView()
        initData()
    }

    abstract fun getContentView(): Int

    abstract fun initView()

    abstract fun initData()
}