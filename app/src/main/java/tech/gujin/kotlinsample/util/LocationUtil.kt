package tech.gujin.kotlinsample.util

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.support.annotation.WorkerThread
import tech.gujin.kotlinsample.application.MyApplication


class LocationUtil {

    companion object {

        private val lock = java.lang.Object()

        @WorkerThread
        fun getLocation(): DoubleArray? {
            val locationManager = MyApplication.sContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            if (location != null) {
                return doubleArrayOf(location.latitude, location.longitude)
            }

            synchronized(lock) {
                var latLng: DoubleArray? = null
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0F, object : LocationListener {
                    override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}

                    override fun onProviderEnabled(provider: String) {}

                    override fun onProviderDisabled(provider: String) {}

                    override fun onLocationChanged(location: Location) {
                        latLng = doubleArrayOf(location.latitude, location.longitude)
                        lock.notify()

                    }
                })
                lock.wait()
                return latLng
            }

        }
    }

}