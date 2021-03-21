package de.fachinformatik.elias;

import java.util.Locale;

public enum Rank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    private String temp;
    private String result;

    public String toString() {
        temp = "";
        result = "";
        temp = this.name();
        temp = temp.toLowerCase(Locale.ROOT);
        String[] tempArr = temp.split("");
        tempArr[0] = tempArr[0].toUpperCase(Locale.ROOT);
        for (String s : tempArr) result += s;
        return result;
    }
}