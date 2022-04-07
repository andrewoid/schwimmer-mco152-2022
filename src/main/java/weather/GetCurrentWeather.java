package weather;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import weather.json.CurrentWeather;
import weather.json.OpenWeatherMapService;

import java.io.IOException;

public class GetCurrentWeather {

    /**
     * @return the current temperature in Kelvin
     */
    public CurrentWeather getCurrentWeather(String zipcode) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OpenWeatherMapService service = retrofit.create(OpenWeatherMapService.class);

        CurrentWeather currentWeather = service.getCurrentWeather(zipcode)
                .execute()
                .body();

        return currentWeather;
    }


}
