package com.android.sunghyun.pokerhand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by YKC on 2017. 3. 7..
 */

public class Player {

    static final String TAG = Player.class.getSimpleName();

    public List<Card> cards;
    public List<Integer> keysets; // 동일 랭크시 카드 순위 비교하는데쓸 키셋

    public Player(String hands) {

        keysets = new ArrayList<>();
        cards = new ArrayList<>();

        String[] strings = hands.split(" ");
        for(int i = 0; i<strings.length; i++) {
            Card card = new Card(strings[i]);
            cards.add(card);
        }

        sortCards();

    }

    public void sortCards() {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card card1, Card card2) {
                return (card1.value > card2.value) ? 1 : -1;
            }
        });
    }

}

