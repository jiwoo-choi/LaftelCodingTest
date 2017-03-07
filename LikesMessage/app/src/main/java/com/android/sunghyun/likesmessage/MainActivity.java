package com.android.sunghyun.likesmessage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.textView);

        String[] likes0 = {};
        String[] likes1 = {"Rafy"};
        String[] likes2 = {"Rafy", "Ryan"};
        String[] likes3 = {"Rafy", "Ryan", "Curian"};
        String[] likes4 = {"Rafy", "Ryan", "Curian", "Billy"};
        String[] likes5 = {"Rafy", "Ryan", "Curian", "Billy", "Green"};

        String result = "";

        result = makeLikeMessage(likes0);
        Log.d(TAG, result);

        result = makeLikeMessage(likes1);
        Log.d(TAG, result);

        result = makeLikeMessage(likes2);
        Log.d(TAG, result);

        result = makeLikeMessage(likes3);
        Log.d(TAG, result);

        result = makeLikeMessage(likes4);
        Log.d(TAG, result);

        result = makeLikeMessage(likes5);
        Log.d(TAG, result);

        textView.setText(result);
    }

    public String makeLikeMessage(String[] peoples) {

        int size = peoples.length;

        Log.i(TAG, "Size = " + size + ", Peoples = " + Arrays.toString(peoples));

        String result = "";

        switch(size) {
            case 0: {
                result = "no one likes this";
                break;
            }

            case 1: {
                result = peoples[0] + " likes this";
                break;
            }

            case 2: {
                result = peoples[0] + " and " + peoples[1] + " likes this";
                break;
            }

            case 3: {
                result = peoples[0] + ", " + peoples[1] + " and " + peoples[2] + " like this";
                break;
            }

            default: {
                int others = size - 2;
                result = peoples[0] + ", " + peoples[1] + " and " + others + " others " + "like this";
            }
        }

        return result;
    }
}
