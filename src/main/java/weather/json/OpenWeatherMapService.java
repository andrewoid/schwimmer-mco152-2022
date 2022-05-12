package weather.json;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherMapService {

    String appId = "c65f21012c4876d2dc360667ec9a4a1b";

    @GET("data/2.5/weather?appid=" + appId + "&units=imperial")
    Single<CurrentWeather> getCurrentWeather(@Query("q") String zipcode);
}
