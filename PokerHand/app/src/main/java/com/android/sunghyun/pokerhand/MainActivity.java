package com.android.sunghyun.pokerhand;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Poker game = new Poker();

        String test1 = "Ad Kh Ac 7h 7d";
        String test2 = "Ah Kh Ac 7h 7d";

        Log.e(TAG, "플레이어1 = " + test1);
        Log.e(TAG, "플레이어2 = " + test2);

        Player player1 = new Player(test1);
        Player player2 = new Player(test2);

        String result = game.compareHand(player1, player2);

        Log.e(TAG, "게임 결과 : " + result);


    }
}
