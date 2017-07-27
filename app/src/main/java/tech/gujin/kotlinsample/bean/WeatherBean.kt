package tech.gujin.kotlinsample.bean

data class WeatherBean(val HeWeather5: List<HeWeather5Bean>) {
    companion object {
        data class HeWeather5Bean(val now: NowBean, val suggestion: SuggestionBean) {
            companion object {
                data class NowBean(val cond: CondBean, val fl: String, val hum: String, val pcpn: String, val pres: String, val tmp: String, val vis: String, val wind: WindBean) {
                    companion object {
                        data class CondBean(val code: String, val txt: String)
                        data class WindBean(val deg: String, val dir: String, val sc: String, val spd: String)
                    }
                }
            }

            data class SuggestionBean(val comf: ComfBean, val cw: CwBean, val drsg: DrsgBean, val flu: FluBean, val sport: SportBean, val trav: TravBean, val uv: UvBean) {
                companion object {
                    data class ComfBean(val brf: String, val txt: String)
                    data class CwBean(val brf: String, val txt: String)
                    data class DrsgBean(val brf: String, val txt: String)
                    data class FluBean(val brf: String, val txt: String)
                    data class SportBean(val brf: String, val txt: String)
                    data class TravBean(val brf: String, val txt: String)
                    data class UvBean(val brf: String, val txt: String)
                }
            }
        }
    }
}