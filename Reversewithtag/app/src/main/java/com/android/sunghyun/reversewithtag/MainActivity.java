package com.android.sunghyun.reversewithtag;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);

        String original = "The quick <font color=\"brown\">brown</font> fox jumps over the lazy dog";
        String test = "abc def <font color=\"brown\">yellow brown</font> ghi jkl <size color=\"brown\">apple red</size> mnop qrx";
        String test2 = "<font color=\"brown\">yellow brown</font> abc def";

        String result = reverseWithTag(test2);

        Log.e(TAG, "결과 : " + result);

        textView.setText(result);
    }

    public String reverseWithTag(String original) {

        List<String> lists = new ArrayList<>();

        Log.d(TAG, "원문 : " + original);
        // 1. 태그와 일반 문자들을 나누고
        // 2. 나눈것들을 reverse 시켜서 list에 add
        // 3. list를 반대로 출력

        while(true) {
            int start_index = original.indexOf("<");

            if (start_index == -1) { // 못찾았을때
                lists.add(reverse(original));
                break;
            } else {
                String words = original.substring(0, start_index);

                lists.add(reverse(words));

                original = original.substring(start_index);

                String tag = original.substring(1, original.indexOf(" "));
                String endTag = "</" + tag + ">";
                String tags = original.substring(0, original.indexOf(endTag) + endTag.length());

                lists.add(reverseWordsInTag(tags));
                original = original.substring(original.indexOf(endTag) + endTag.length());
            }
        }


        // 반대로 출력
        StringBuffer stringBuffer = new StringBuffer();

        for(int i = lists.size()-1; i>-1; i--) {
            stringBuffer.append(lists.get(i));
        }

        return stringBuffer.toString();
    }

    public String reverse(String words) {
        StringBuffer buffer = new StringBuffer(words);
        return buffer.reverse().toString();
    }

    public String reverseWordsInTag(String tags) {
        String words = tags.substring(tags.indexOf(">") + 1, tags.indexOf("</"));
        return tags.replace(words, reverse(words));
    }

}
