package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText, editText1;
    Button button;
    SharedPreferences preferences;
    private static final String data = "data";
    private static final String name = "name";
    private static final String lastName = "lastName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.editTextTextPersonName);
        editText1 = findViewById(R.id.editTextTextPersonName2);
        button = findViewById(R.id.button);

        preferences = getSharedPreferences(data, Context.MODE_PRIVATE);
        editText.setText(preferences.getString(name, "" ));
        editText1.setText(preferences.getString(lastName, ""));
    }

    public void addPref(View view){
        preferences = getSharedPreferences(data, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(name, editText.getText().toString());
        editor.putString(lastName, editText1.getText().toString());
        editor.apply();
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}