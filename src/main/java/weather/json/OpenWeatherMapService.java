package weather.json;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherMapService {
    String APPID = "c65f21012c4876d2dc360667ec9a4a1b";

    @GET("data/2.5/weather?appid=" + APPID + "&units=imperial")
    Observable<CurrentWeather> getCurrentWeather(@Query("q") String zipcode);

}
