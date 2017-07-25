package tech.gujin.kotlinsample.bean

import retrofit2.Call

data class CallWeather(val call: Call<WeatherBean>, val weather: WeatherBean)