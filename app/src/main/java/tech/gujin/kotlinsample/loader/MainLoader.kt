package tech.gujin.kotlinsample.loader

import android.content.AsyncTaskLoader
import android.content.Context
import android.util.Log
import tech.gujin.kotlinsample.bean.WeatherBean
import tech.gujin.kotlinsample.net.weather.WeatherApi
import tech.gujin.kotlinsample.util.LocationUtil

class MainLoader(context: Context) : AsyncTaskLoader<WeatherBean>(context) {
    override fun loadInBackground(): WeatherBean? {
        val latLng = LocationUtil.getLocation() ?: return null

        val call = WeatherApi.query(latLng[0].toString() + "," + latLng[1].toString())
        val response = call.execute()
        val weatherBean: WeatherBean
        if (response.isSuccessful) {
            weatherBean = response.body() ?: return null
        } else {
            Log.w("get weather failure", response.toString())
            return null
        }
        return weatherBean
    }
}