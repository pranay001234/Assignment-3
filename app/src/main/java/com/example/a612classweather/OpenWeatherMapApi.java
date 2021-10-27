package com.example.a612classweather;


import android.content.Context;
        import android.util.Log;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

public class OpenWeatherMapApi implements WeatherApi {
    Context _context;
    RequestQueue queue;


    public OpenWeatherMapApi(Context context) {
        _context = context;
        queue = Volley.newRequestQueue(context);
    }

    public void getWeatherForZipCode(String city, Callback callback) {
       // String weather_api_url = _context.getString(R.string.weather_api_url);
        String weather_api_url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=b4c6fdbade25a761cfcb811a1d586910";
        String weather_api_key = _context.getString(R.string.weather_api_key);
        String url = String.format(weather_api_url, city, weather_api_key);
        StringRequest stringRequest =
                new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("example.com response", response);
                                try {
                                    JSONObject jsoneWeather = new JSONObject(response);
                                    JSONObject main = jsoneWeather.getJSONObject("main");
                                    Double dbltemperature = main.getDouble("temp");
                                    Log.d("temperature", dbltemperature.toString());
                                    Weather weather = new Weather();
                                    Temperature temperature = new Temperature(dbltemperature,TemperatureScale.KELVIN);
                                    weather.setTemperature(temperature);

                                    JSONArray weatherArray =
                                            jsoneWeather.getJSONArray("weather");
                                    JSONObject weatherObject=
                                            weatherArray.getJSONObject(0);
                                    String condition = weatherObject.getString("main");
                                    weather.setCondition(condition);



                                    callback.success(weather);
                                    // tvTemperature.setText(temperature + "");
                                } catch (JSONException e) {
                                    callback.error(ErrorType.JSON);
                                    Log.d("weatherrequestexception", e.toString());
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.error(ErrorType.NETWORK);
                    }
                });
        queue.add(stringRequest);
    }

}