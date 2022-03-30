import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * The View
 */
public class ScrabbleFrame extends JFrame {

    private final ScrabblePresenter presenter;

    private JLabel scoreLabel;
    private JLabel tileLabels[];
    private JTextField inputField;
    private JButton submitButton;
    private JLabel outputLabel;
    private JPanel verticalPanel;

    public ScrabbleFrame() {
        setTitle("Touro Scrabble");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        ScrabbleDictionary dictionary = new ScrabbleDictionary();
        LetterPool letterPool = new LetterPool();
        ScrabbleGame scrabbleGame = new ScrabbleGame(dictionary, letterPool);

        presenter = new ScrabblePresenter(this, scrabbleGame);

        verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
        add(verticalPanel);

        addTilesPanel();

        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(120, 60));
        verticalPanel.add(inputField);

        scoreLabel = new JLabel("2000");
        verticalPanel.add(scoreLabel);

        submitButton = new JButton("SUBMIT");
        submitButton.addActionListener(this::onSubmitClicked);
        verticalPanel.add(submitButton);

        outputLabel = new JLabel("Output");
        verticalPanel.add(outputLabel);
    }

    private void addTilesPanel() {
        JPanel tilesPanel = new JPanel();
        tilesPanel.setLayout(new FlowLayout());
        tileLabels = new JLabel[7];
        for (int i = 0; i < tileLabels.length; i++) {
            tileLabels[i] = new JLabel();
            tilesPanel.add(tileLabels[i]);
        }
        verticalPanel.add(tilesPanel);

        presenter.fillTiles();
    }

    public void onSubmitClicked(ActionEvent event) {
        String word = inputField.getText();
        presenter.playWord(word);
    }

    public void setScore(String score) {
        scoreLabel.setText(score);
    }

    public void setTiles(List<Character> tiles) {
        for (int i = 0; i < tiles.size(); i++) {
            tileLabels[i].setText(tiles.get(i).toString());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new ScrabbleFrame();

        frame.setVisible(true);
    }

    public void setErrorMessage(String errorMessage) {

    }
}
