package com.leo.myweather.bean

import com.google.gson.annotations.SerializedName

data class Weather(
    /*
      {"basic":{"cid":"CN101170501","location":"中卫","parent_city":"中卫","admin_area":"宁夏","cnty":"中国","lat":"43.79281616","lon":"87.61772919","tz":"+8.00","city":"中卫","id":"CN101170501","update":{"loc":"2024-04-21 08:12","utc":"2024-04-21 08:12"}},
      "update":{"loc":"2024-04-21 08:12","utc":"2024-04-21 08:12"},
      "status":"ok",
      "now":{"cloud":"91","cond_code":"100","cond_txt":"晴","fl":"11","hum":"22","pcpn":"0.0","pres":"1020","tmp":"14","vis":"16","wind_deg":"33","wind_dir":"东北风","wind_sc":"2","wind_spd":"6","cond":{"code":"100","txt":"晴"}},
      "daily_forecast":[{"date":"2024-04-22","cond":{"txt_d":"晴"},"tmp":{"max":"17","min":"4"}},{"date":"2024-04-23","cond":{"txt_d":"晴"},"tmp":{"max":"18","min":"6"}},{"date":"2024-04-24","cond":{"txt_d":"晴"},"tmp":{"max":"16","min":"6"}},{"date":"2024-04-25","cond":{"txt_d":"阴"},"tmp":{"max":"15","min":"4"}},{"date":"2024-04-26","cond":{"txt_d":"阵雨"},"tmp":{"max":"18","min":"6"}},{"date":"2024-04-27","cond":{"txt_d":"晴"},"tmp":{"max":"20","min":"8"}}],
      "aqi":{"city":{"aqi":"55","pm25":"23","qlty":"良"}},
      "suggestion":{"comf":{"type":"comf","brf":"舒适","txt":"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"},"sport":{"type":"sport","brf":"适宜","txt":"天气较好，赶快投身大自然参与户外运动，尽情感受运动的快乐吧。"},"cw":{"type":"cw","brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}},
      "msg":"所有天气数据均为模拟数据，仅用作学习目的使用，请勿当作真实的天气预报软件来使用。"}
     */
    val basic:BasicBean,
    val update:Update,
    val status:String,
    val now:NowBean,
    val forecastList:List<ForecastBean>,
    val aqi:AqiBean,
    val suggestion: Suggestion
)

data class BasicBean(
    val cid:String,
    val city:String,
    val location: String,
    val parent_city:String,
    val admin_area:String,
    val cnty:String,
    val id:String
)

data class Update(
    val loc:String,
    val utc:String
)
data class NowBean(
    val cloud:String,
    @SerializedName("cond_code")
    val condCode:String,
    @SerializedName("cond_txt")
    val condTxt:String,
)
data class ForecastBean(
    val date:String,
    val cond:CondBean,
    val tmp:TmpBean
)
data class CondBean(
    @SerializedName("txt_d")
    val txt:String
)
data class TmpBean(
    val max:String,
    val min:String
)
data class AqiBean(
    @SerializedName("city")
    val data:CityBean
)
data class CityBean(
    val aqi:String,
    val pm25:String,
    val qlty:String
)
data class Suggestion(
    val comf:SuggestionBean,
    val sport:SuggestionBean,
    val cw:SuggestionBean
)

data class SuggestionBean (
    val type:String,
    val brf:String,
    val txt:String
)

