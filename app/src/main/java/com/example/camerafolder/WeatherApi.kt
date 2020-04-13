package com.example.camerafolder

import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL


class WeatherApi {

    companion object {
        fun getWeather(): String {
            //APIキー
            val API_KEY = "b7c2a42332f758ce8ccd3e8284774ab3"
            //都市のID(横浜)
            val CITY_ID = 1848354
            //アクセスする際のURL
            val API_URL = "http://api.openweathermap.org/data/2.5/forecast?" +
                    "id=" + CITY_ID + "&" +
                    "APPID=" + API_KEY
            var url = URL(API_URL)

            //APIから情報を取得する.
            var br = BufferedReader(InputStreamReader(url.openStream()))

            var line: String? = ""
            var builder = StringBuilder()
            while (br.readLine().also({ line = it }) != null) {
                builder.append(line)
            }
            System.out.println(builder)

            //json形式のデータとして識別
            var json = JSONObject(builder.toString())
            println(json.get("city"))

            return json.get("city") as String
        }

    }


}