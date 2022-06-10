package weather;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import weather.json.CurrentWeather;
import weather.json.OpenWeatherMapService;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class CurrentWeatherPresenter {

    private final Provider<CurrentWeatherFrame> viewProvider;
    private final OpenWeatherMapService model;
    private Disposable disposable;

    @Inject
    public CurrentWeatherPresenter(
            Provider<CurrentWeatherFrame> viewProvider,
            OpenWeatherMapService model
    ) {
        this.viewProvider = viewProvider;
        this.model = model;
    }

    public void loadWeatherFromZipcode(String zipcode) {
        // disposable is used to cancel the request.
        disposable = model.getCurrentWeather(zipcode)
                // do this request in the background
                .subscribeOn(Schedulers.io())
                // run onNext in a new Thread
                .observeOn(Schedulers.newThread())
                .subscribe(this::onNext, this::onError);
    }

    public void cancel() {
        if (disposable != null) {
            disposable.dispose();
        }
    }

    private void onNext(CurrentWeather currentWeather) {
        double farenheight = currentWeather.getTemperature();
        viewProvider.get().setTemperature(farenheight);
    }

    private void onError(Throwable throwable) {
        throwable.printStackTrace();
        viewProvider.get().showError();
    }

}
