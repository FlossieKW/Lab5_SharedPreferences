package com.example.lab5_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.lab5_sharedpreferences", Context.MODE_PRIVATE);
        if (!sharedPreferences.getString("username", "").equals("")) {
            String username = sharedPreferences.getString("username", "");
            Intent intent = new Intent(this, NotesActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    public void loginFunction(View view) {
        EditText usernameText = (EditText) findViewById(R.id.usernameEdit);
        String username = usernameText.getText().toString();
        EditText passwordText = (EditText) findViewById(R.id.passwordView);
        String password = passwordText.getText().toString();

        // Authentication
        if (!username.isEmpty()) {
            SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.lab5_sharedpreferences", Context.MODE_PRIVATE);
            sharedPreferences.edit().putString("username", username).apply();
            goToNotes(username, password);
        }
    }

    public void goToNotes(String username, String password) {
        Intent intent = new Intent(this, NotesActivity.class);
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        startActivity(intent);
    }

}