package weather;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import weather.json.CurrentWeather;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A JTextField for the zipcode
 * A JButton to Submit
 * A JLabel for temperature in F
 */
public class CurrentWeatherFrame extends JFrame {

    private JTextField zipcodeField;
    private JLabel temperatureLabel;
    private GetCurrentWeather getCurrentWeather = new GetCurrentWeather();

    public CurrentWeatherFrame() {

        setTitle("Current Weather");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        zipcodeField = new JTextField("00011");
        JButton button = new JButton("Submit");

        button.addActionListener(this::onSubmitClicked);

        temperatureLabel = new JLabel("temp");

        add(zipcodeField);
        add(button);
        add(temperatureLabel);
    }

    public void onSubmitClicked(ActionEvent event) {
        Observable<CurrentWeather> observable = getCurrentWeather.getCurrentWeather(zipcodeField.getText());

        Disposable disposable = observable
                // do this request in the background
                .subscribeOn(Schedulers.io())
                // run onNext in a new Thread
                .observeOn(Schedulers.newThread())
                .subscribe(this::onNext, this::onError);
    }

    public void onNext(CurrentWeather currentWeather) {
        double farenheight = currentWeather.getTemperature();
        temperatureLabel.setText(String.valueOf(farenheight));
    }

    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    public static void main(String[] args) {
        CurrentWeatherFrame frame = new CurrentWeatherFrame();
        frame.setVisible(true);
    }


}
