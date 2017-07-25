package tech.gujin.kotlinsample.net.weather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import tech.gujin.kotlinsample.bean.WeatherBean

interface WeatherService {
    @GET("weather")
    fun queryAll(@Query("city") city: String?, @Query("key") key: String): Call<WeatherBean>
}