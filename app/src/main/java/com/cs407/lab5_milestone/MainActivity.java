package com.cs407.lab5_milestone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
            String storedUsername = sharedPreferences.getString("username", "");

            if (!storedUsername.isEmpty()) {
                // If username exists in SharedPreferences, directly navigate to NotesActivity
                Intent intent = new Intent(MainActivity.this, NotesActivity.class);
                startActivity(intent);
                finish();
            }

            Button loginButton = findViewById(R.id.button);
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText usernameEditText = findViewById(R.id.editTextText);
                    String username = usernameEditText.getText().toString();

                    // Save username in SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", username);
                    editor.apply();

                    Intent intent = new Intent(MainActivity.this, NotesActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
