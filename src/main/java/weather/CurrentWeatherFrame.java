package weather;

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
public class CurrentWeatherFrame extends JFrame {

    private final JTextField zipcodeField;
    private final JLabel temperatureLabel;
    private final CurrentWeatherPresenter presenter;

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

        presenter = new CurrentWeatherPresenter(this, new GetCurrentWeather());
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
        CurrentWeatherFrame frame = new CurrentWeatherFrame();
        frame.setVisible(true);
    }
}
