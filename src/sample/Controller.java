package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    private ShennonFano shennonFano = new ShennonFano();

    @FXML
    private TextField textFieldOriginalText;

    @FXML
    private void calculate() {

        /*long heapSize = Runtime.getRuntime().maxMemory();
        System.out.println("Heap Size = " + heapSize);*/
        char[] charOriginalText = textFieldOriginalText.getText().toCharArray();
        shennonFano.shennonFano(charOriginalText, ' ', " ", 0, charOriginalText.length);
    }
}