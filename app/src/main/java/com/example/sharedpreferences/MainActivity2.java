package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    EditText editText3, editText4;
    Button button;
    SharedPreferences preferences;
    private static final String name = "name";
    private static final String lastName = "lastName";
    private static final String data = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText3 = findViewById(R.id.editTextTextPersonName3);
        editText4 = findViewById(R.id.editTextTextPersonName4);
        button = findViewById(R.id.button2);

        preferences = getSharedPreferences(data, Context.MODE_PRIVATE);
        editText3.setText(preferences.getString(name, ""));
        editText4.setText(preferences.getString(lastName, ""));
    }

    public void setData(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(name, editText3.getText().toString());
        editor.putString(lastName, editText4.getText().toString());
        editor.apply();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}