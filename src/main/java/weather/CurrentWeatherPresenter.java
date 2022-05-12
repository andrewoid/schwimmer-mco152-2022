package weather;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import weather.json.CurrentWeather;
import weather.json.OpenWeatherMapService;

public class CurrentWeatherPresenter {

    private final CurrentWeatherFrame view;
    private final OpenWeatherMapService Model;
    private Disposable disposable;

    public CurrentWeatherPresenter(
            CurrentWeatherFrame view,
            OpenWeatherMapService model
    ) {
        this.view = view;
        this.Model = model;
    }

    public void loadWeatherFromZipcode(String zipcode) {
        // disposable is used to cancel the request.
        disposable = Model.getCurrentWeather(zipcode)
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
        view.setTemperature(farenheight);
    }

    private void onError(Throwable throwable) {
        throwable.printStackTrace();
        view.showError();
    }

}
