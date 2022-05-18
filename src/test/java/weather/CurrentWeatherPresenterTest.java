package weather;

import io.reactivex.Single;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weather.json.CurrentWeather;
import weather.json.OpenWeatherMapService;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CurrentWeatherPresenterTest {

    @BeforeAll
    static void beforeAllTests() {
        // this will run one time before all tests in this class
        RxJavaPlugins.setIoSchedulerHandler((scheduler) -> Schedulers.trampoline());
        RxJavaPlugins.setNewThreadSchedulerHandler((scheduler) -> Schedulers.trampoline());
    }

    @BeforeEach
    public void beforeEachTest() {
        // this will get run before each test
    }

    @Test
    void loadWeatherFromZipcode() {
        // given
        CurrentWeatherFrame view = mock(CurrentWeatherFrame.class);
        OpenWeatherMapService model = mock(OpenWeatherMapService.class);
        CurrentWeatherPresenter presenter = new CurrentWeatherPresenter(view, model);
        CurrentWeather currentWeather = mock(CurrentWeather.class);
        doReturn(100.0).when(currentWeather).getTemperature();
        doReturn(Single.just(currentWeather))
                .when(model).getCurrentWeather("00000");

        // when
        presenter.loadWeatherFromZipcode("00000");

        // then
        verify(view).setTemperature(100.0);
    }
}