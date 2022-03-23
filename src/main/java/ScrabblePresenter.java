/**
 * The presenter acts upon the model and the view. It retrieves data from the model and formats it for display in the view.
 */
public class ScrabblePresenter {

    private ScrabbleFrame view;
    private ScrabbleGame model;
    private int score;

    public ScrabblePresenter(ScrabbleFrame view, ScrabbleGame model) {
        this.view = view;
        this.model = model;
    }

    public void playWord(String word) {
        if (model.playWord(word)) {
            score++;
            view.setScore(String.valueOf(score));
            view.setTiles(model.getTiles());
        } else {
            // view.setErrorMessage(...)
        }
    }

    public void fillTiles() {
        view.setTiles(model.getTiles());
    }
}
