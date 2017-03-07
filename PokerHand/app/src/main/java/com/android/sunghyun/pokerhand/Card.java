package com.android.sunghyun.pokerhand;

/**
 * Created by YKC on 2017. 3. 7..
 */

public class Card {

    int value; // 2~10, J(11), Q(12) , K(13) , A(14)
    int shape; // s(0) , d(1) , c(2), h(3)

    public Card(String card) {

        char num = card.charAt(0);
        switch (num) {
            case 'J':
                value = 11;
                break;
            case 'Q':
                value = 12;
                break;
            case 'K':
                value = 13;
                break;
            case 'A':
                value = 14;
                break;
            default:
                value = Character.getNumericValue(num);
        }

        char temp = card.charAt(1);
        switch (temp) {
            case 's':
                shape = 0;
                break;
            case 'd':
                shape = 1;
                break;
            case 'c':
                shape = 2;
                break;
            case 'h':
                shape = 3;
                break;
        }

    }
}
