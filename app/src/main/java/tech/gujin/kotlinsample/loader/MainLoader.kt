package tech.gujin.kotlinsample.loader

import android.content.AsyncTaskLoader
import android.content.Context
import tech.gujin.kotlinsample.bean.WeatherBean
import tech.gujin.kotlinsample.net.weather.WeatherApi

class MainLoader(context: Context) : AsyncTaskLoader<WeatherBean>(context) {
    override fun loadInBackground(): WeatherBean? {
        val call = WeatherApi.query("beijing")
        val wBean = WeatherApi.run(call)
        return wBean
    }
}