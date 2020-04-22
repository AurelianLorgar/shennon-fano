package sample;

import java.util.ArrayList;
import java.util.HashMap;

class ShennonFano {

    HashMap<Character, String> resultMap = new HashMap<>();

    //FIXME рекурсия уходит в бесконечный цикл
    void shennonFano(char[] arrayChar, char branch, String fullBranch, int startPos, int endPos) {

        ArrayList<Character> symbols = new ArrayList<>();
        ArrayList<Integer> amount = new ArrayList<>();
        int sym = 0;
        int amm = 0;
        int counter;

        double middle = 0; //Среднее значение
        int middleLetter; //middleLetter - номер средней буквы в последовательности
        int sumLeftBranch = 0;//  sumLeftBranch - сумма чисел левой ветви
        String branchTurn; //текущая история поворотов по ветви

        HashMap<Character, Integer> charMap = new HashMap<>();

        for (char aCharOriginalText : arrayChar) {
            if (charMap.containsKey(aCharOriginalText)) {
                charMap.put(aCharOriginalText, charMap.get(aCharOriginalText) + 1);
            } else {
                charMap.put(aCharOriginalText, 1);
            }
        }

        for (char symbol : charMap.keySet()) {
            symbols.add(sym, symbol);
            sym++;
        }

        for (int number : charMap.values()) {
            amount.add(amm, number);
            amm++;
        }

        if (!symbols.equals(' ')) {
            branchTurn = fullBranch + branch;
        } else {
            branchTurn = "";
        }

        try {
            if (startPos == endPos) {
                System.out.println(symbols.get(startPos) + "=" + branchTurn);
                return;
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return;
        }


        for (int i = startPos; i < amount.size(); i++) {
            middle = middle + amount.get(i);
        }
        middle = middle / 2;
        counter = startPos;
        middleLetter = counter;
        try {
            while ((sumLeftBranch + amount.get(counter) < middle) && (counter < endPos)) {
                sumLeftBranch = sumLeftBranch + amount.get(counter);
                counter++;
                middleLetter++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }


        shennonFano(arrayChar, '1', branchTurn, startPos, middleLetter);
        shennonFano(arrayChar, '0', branchTurn, middleLetter + 1, endPos);
    }
}