package tech.gujin.kotlinsample.net.weather

import android.support.annotation.WorkerThread
import android.util.Log
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.gujin.kotlinsample.BuildConfig
import tech.gujin.kotlinsample.bean.WeatherBean

class WeatherApi {

    companion object {
        private val sService: WeatherService = Retrofit.Builder()
                .baseUrl("https://free-api.heweather.com/v5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherService::class.java)

        @WorkerThread
        fun query(city: String): Call<WeatherBean> {
            return sService.queryAll(city, BuildConfig.WEATHER_KEY)
        }

        fun run(call: Call<WeatherBean>): WeatherBean? {
            val response = call.execute()
            if (response.isSuccessful) {
                return response.body()
            } else {
                Log.w("get weather failure", response.toString())
                return null
            }
        }
    }
}