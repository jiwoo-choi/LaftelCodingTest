package com.android.sunghyun.pokerhand;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YKC on 2017. 3. 7..
 */

public class Poker {

    static final String TAG = Poker.class.getSimpleName();

    public enum Rank{HIGHCARD, ONEPAIR, TWOPAIR, TRIPLE, STRAIGHT, FLUSH, FULLHOUSE, FOURCARDS, STRAIGHTFLUSH, ROYALFLUSH};



    public Poker() {

    }

    public String compareHand(Player player1, Player player2) {

        int rank1 = evaluate(player1);
        int rank2 = evaluate(player2);

        Log.e(TAG, "Player1 = " + Rank.values()[rank1].toString());
        Log.e(TAG, player1.keysets.toString());
        Log.e(TAG, "Player2 = " + Rank.values()[rank2].toString());
        Log.e(TAG, player2.keysets.toString());

        if (rank1 > rank2) {
            return "Player1 Win";
        } else if (rank1 < rank2) {
            return "Player2 Win";
        } else if (rank1 == rank2) {
            for(int i = 0; i<player1.keysets.size(); i++) {
                if(player1.keysets.get(i) == player2.keysets.get(i)) {
                    continue;
                } else if(player1.keysets.get(i) > player2.keysets.get(i)) {
                    return "Player1 Win";
                } else if(player1.keysets.get(i) < player2.keysets.get(i)) {
                    return "Player2 Win";
                }
            }
        }

        return "Draw";
    }

    public int evaluate(Player player) {

        int result = -1;
        boolean flush = false;
        boolean straight = false;

        List<Card> cards = player.cards;

        final Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0;i < cards.size(); i++) {
            if (map.containsKey(cards.get(i).value)) { // 이미 같은 키가 있으면
                map.put(cards.get(i).value, map.get(cards.get(i).value)+1); // 기존 value에 +1을 더해서 넣음
            } else { // 없으면 새로 입력하는거라 value 를 1로
                map.put(cards.get(i).value, 1);
            }
        }

        // 키셋을 map value의 내림차순으로 정렬해서 리스트에 넣어줌
        List<Integer> keyLists = player.keysets;
        keyLists.addAll(map.keySet());
        Collections.sort(keyLists, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                Integer n1 = map.get(i1);
                Integer n2 = map.get(i2);
                return n2.compareTo(n1);
            }
        });

//        Log.e(TAG, "Keyset : " + keyLists.get(0) + "," + keyLists.get(1));
//        Log.e(TAG, map.get(keyLists.get(0))+"");

        // 플레시 체크
        if(cards.get(0).shape == cards.get(1).shape &&
                cards.get(0).shape == cards.get(2).shape &&
                cards.get(0).shape == cards.get(3).shape &&
                cards.get(0).shape == cards.get(4).shape) {
            flush = true;
        }

        // (4, 1) 포카드   // 중복갯수 4개 크기 2
        // (3, 2) 풀하우스 // 중복갯수 3개 크기 2
        // (3, 1, 1) 트리플  // 중복갯수 3개 크기 3
        // (2, 2, 1) 투페어 // 중복갯수 2개 크기 3
        // (2, 1, 1, 1) 원페어 // 중복갯수 2개 크기 4
        // (1, 1, 1, 1, 1) 하이 -> 스트레이트 체크

        switch (keyLists.size()) {
            case 2: {
                if(map.get(keyLists.get(0)) == 4) { // 포카드
                    result = Rank.FOURCARDS.ordinal();
                } else {  // 풀하우스
                    result = Rank.FULLHOUSE.ordinal();
                }
                break;
            }
            case 3: {
                if(map.get(keyLists.get(0)) == 3) { // 트리플
                    result = Rank.TRIPLE.ordinal();
                } else {   // 투페어
                    result = Rank.TWOPAIR.ordinal();
                    if(player.keysets.get(0) < player.keysets.get(1)) { // 키리스트을 값으로 정렬해서 투페어일때 오름차순으로 정렬 안되는걸 처리
                        int temp = player.keysets.get(0);
                        player.keysets.set(0, player.keysets.get(1));
                        player.keysets.set(1, temp);
                    }
                }
                break;
            }
            case 4: { // 원페어
                result = Rank.ONEPAIR.ordinal();
                break;
            }
            case 5: { // 하이 일때 스트레이트 체크
                if(cards.get(4).value - cards.get(0).value == 4) { // 하이카드 && 마지막꺼에서 첫번째꺼 뺀게 4면 스트레이트
                    straight = true;
                    result = Rank.STRAIGHT.ordinal();
                } else if(cards.get(4).value == 14 && cards.get(0).value == 2) {// 2345A에 대한 처리
                    straight = true;
                    result = Rank.STRAIGHT.ordinal();
                    player.keysets = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
                } else { // 하이
                    result = Rank.HIGHCARD.ordinal();
                }
                break;
            }
        }

        if(straight && flush) { // 로플 , 스플 체크
            if(cards.get(0).value == 10) {
                result = Rank.ROYALFLUSH.ordinal();
            } else {
                result = Rank.STRAIGHTFLUSH.ordinal();
            }
        }

        if (flush && result <= Rank.FLUSH.ordinal()) { // 플러시가 트루이고 여기까지온 result 가 플러시보다 같거나 낮으면
            result = Rank.FLUSH.ordinal();
        }

        return result;
    }

}
