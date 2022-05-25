package weather;

import org.junit.jupiter.api.Test;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CurrentWeatherFrameTest {

    @Test
    public void onSubmitClicked() {
        // given
        CurrentWeatherPresenter presenter = mock(CurrentWeatherPresenter.class);
        CurrentWeatherFrame frame = new CurrentWeatherFrame(presenter);

        // when
        frame.onSubmitClicked(mock(ActionEvent.class));

        // then
        verify(presenter).loadWeatherFromZipcode("00011");
    }


}