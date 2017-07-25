package tech.gujin.kotlinsample.activity

import android.app.LoaderManager
import android.content.Loader
import android.os.Bundle
import android.util.Log
import tech.gujin.kotlinsample.R
import tech.gujin.kotlinsample.base.BaseActivity
import tech.gujin.kotlinsample.bean.WeatherBean
import tech.gujin.kotlinsample.loader.MainLoader

class MainActivity : BaseActivity(), LoaderManager.LoaderCallbacks<WeatherBean> {
    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun initView() {

    }

    override fun initData() {
        loaderManager.initLoader(1, null, this).forceLoad()
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<WeatherBean> {
        return MainLoader(mContext)
    }

    override fun onLoaderReset(loader: Loader<WeatherBean>?) {
    }

    override fun onLoadFinished(loader: Loader<WeatherBean>?, weatherBean: WeatherBean?) {
        weatherBean ?: Log.i("bean", weatherBean.toString())
    }


}