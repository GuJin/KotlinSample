package tech.gujin.kotlinsample.activity

import android.annotation.SuppressLint
import android.app.LoaderManager
import android.content.Loader
import android.os.Bundle
import kotlinx.android.synthetic.main.include_now.*
import kotlinx.android.synthetic.main.include_suggestion.*
import tech.gujin.kotlinsample.R
import tech.gujin.kotlinsample.base.BaseActivity
import tech.gujin.kotlinsample.bean.WeatherBean
import tech.gujin.kotlinsample.loader.MainLoader
import tech.gujin.toast.ToastUtil

class MainActivity : BaseActivity(), LoaderManager.LoaderCallbacks<WeatherBean> {
    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun initView() {}

    override fun initData() {
        loaderManager.initLoader(1, null, this).forceLoad()
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<WeatherBean> {
        return MainLoader(mContext)
    }

    override fun onLoaderReset(loader: Loader<WeatherBean>?) {}

    override fun onLoadFinished(loader: Loader<WeatherBean>?, weatherBean: WeatherBean?) {
        if (weatherBean == null) {
            ToastUtil.show("失败 请重试")
            return
        }
        setInfo(weatherBean)
    }

    @SuppressLint("SetTextI18n")
    private fun setInfo(weatherBean: WeatherBean) {
        val heWeather5Bean = weatherBean.HeWeather5[0]
        now_cond.text = heWeather5Bean.now.cond.txt

        // 为保证文字对齐 使用了全角空格
        now_tmp.text = "温度　　　" + heWeather5Bean.now.tmp
        now_fl.text = "体感温度　" + heWeather5Bean.now.fl
        now_hum.text = "相对湿度　" + heWeather5Bean.now.hum
        now_pcpn.text = "降水量　　" + heWeather5Bean.now.pcpn
        now_pres.text = "气压　　　" + heWeather5Bean.now.pres
        now_vis.text = "能见度　　" + heWeather5Bean.now.vis
        now_wind_dir.text = "风向　　　" + heWeather5Bean.now.wind.dir
        now_wind_sc.text = "风力　　　" + heWeather5Bean.now.wind.sc
        now_wind_spd.text = "风速　　　" + heWeather5Bean.now.wind.spd

        sug_comf_brf.text = heWeather5Bean.suggestion.comf.brf
        sug_comf_txt.text = heWeather5Bean.suggestion.comf.txt
        sug_cw_brf.text = heWeather5Bean.suggestion.cw.brf
        sug_cw_txt.text = heWeather5Bean.suggestion.cw.txt
        sug_drsg_brf.text = heWeather5Bean.suggestion.drsg.brf
        sug_drsg_txt.text = heWeather5Bean.suggestion.drsg.txt
        sug_flu_brf.text = heWeather5Bean.suggestion.flu.brf
        sug_flu_txt.text = heWeather5Bean.suggestion.flu.txt
        sug_sport_brf.text = heWeather5Bean.suggestion.sport.brf
        sug_sport_txt.text = heWeather5Bean.suggestion.sport.txt
        sug_trav_brf.text = heWeather5Bean.suggestion.trav.brf
        sug_trav_txt.text = heWeather5Bean.suggestion.trav.txt
        sug_uv_brf.text = heWeather5Bean.suggestion.uv.brf
        sug_uv_txt.text = heWeather5Bean.suggestion.uv.txt
    }
}