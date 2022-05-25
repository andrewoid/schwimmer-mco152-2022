package weather;

import weather.dagger.CurrentWeatherComponent;
import weather.dagger.DaggerCurrentWeatherComponent;
import weather.json.OpenWeatherMapService;
import weather.json.OpenWeatherMapServiceFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

/**
 * A JTextField for the zipcode
 * A JButton to Submit
 * A JLabel for temperature in F
 */
@Singleton
public class CurrentWeatherFrame extends JFrame {

    private final JTextField zipcodeField;
    private final JLabel temperatureLabel;
    private final CurrentWeatherPresenter presenter;

    @Inject
    public CurrentWeatherFrame(CurrentWeatherPresenter presenter) {
        this.presenter = presenter;

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
        presenter.loadWeatherFromZipcode(zipcodeField.getText());
    }

    public void setTemperature(double farenheight) {
        temperatureLabel.setText(String.valueOf(farenheight));
    }

    public void showError() {

    }

    public static void main(String[] args) {
        CurrentWeatherFrame frame = DaggerCurrentWeatherComponent.create()
                .getCurrentWeatherFrame();

        frame.setVisible(true);
    }
}
