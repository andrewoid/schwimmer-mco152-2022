package weather;

import org.junit.jupiter.api.Test;
import weather.json.CurrentWeather;
import weather.json.OpenWeatherMapService;
import weather.json.OpenWeatherMapServiceFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OpenWeatherMapServiceTest {

    @Test
    void getCurrentWeather() {
        // given
        OpenWeatherMapServiceFactory factory = new OpenWeatherMapServiceFactory();
        OpenWeatherMapService service = factory.getInstance();

        // when
        CurrentWeather currentWeather = service.getCurrentWeather("10019")
                // only used blocking calls in tests
                .blockingGet();

        // then
        // this test will fail if the temperature in farenheight goes below zero.
        assertTrue(currentWeather.getTemperature() > 0);
        assertTrue(currentWeather.getMaxTemperature() > 0);
        assertTrue(currentWeather.getMinTemperature() > 0);
        assertNotNull(currentWeather.getDescription());
        assertNotNull(currentWeather.getIcon());
    }
}