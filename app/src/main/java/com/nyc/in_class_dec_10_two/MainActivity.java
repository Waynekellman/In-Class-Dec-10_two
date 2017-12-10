package com.nyc.in_class_dec_10_two;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            logMessageListFromJson(Constants.json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void logMessageListFromJson(String json) throws JSONException {

        JSONObject jsonArray = new JSONObject(json);
        String status = jsonArray.get("status").toString();
        String message = jsonArray.get("message").toString();
        JSONObject messageObject = new JSONObject(message);
        List<String> messagekeys = new ArrayList<>();
        for (Iterator<String> it = messageObject.keys(); it.hasNext(); ) {
            String s = it.next();
            messagekeys.add(s);
        }
        Log.d(TAG,status);
//        Log.d(TAG,message);
        JSONObject dogs = new JSONObject(message);
        for (int i = 0; i < messagekeys.size(); i++) {
            Log.d(TAG,"Dog Species: " + messagekeys.get(i));
            if (!dogs.get(messagekeys.get(i)).toString().equals("[]")){
                JSONArray dogg = new JSONArray(dogs.get(messagekeys.get(i)).toString());
                for (int j = 0; j < dogg.length(); j++) {
                    Log.d(TAG,messagekeys.get(i) + " subSpecies: " + dogg.get(j).toString());
                }
            }
        }

    }
}
