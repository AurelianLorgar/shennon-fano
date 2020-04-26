package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {

    private ShennonFano shennonFano = new ShennonFano();

    @FXML
    private TextField textFieldOriginalText;
    @FXML
    private TextArea textAreaCode;

    @FXML
    private void calculate() {

        String str = "";

        char[] charOriginalText = textFieldOriginalText.getText().toCharArray();
        shennonFano.shennonFano(charOriginalText, ' ', "", 0, charOriginalText.length);

        ArrayList<String> resultString = new ArrayList<>(shennonFano.resultString);
        ArrayList<Character> resultChar = new ArrayList<>(shennonFano.resultChar);

        for (char aCharOriginalText : charOriginalText) {
            for (int j = 0; j < resultChar.size(); j++) {
                if (aCharOriginalText == resultChar.get(j)) {
                    str = str.concat(resultString.get(j));
                }
            }
        }
        textAreaCode.setText(str);
    }
}