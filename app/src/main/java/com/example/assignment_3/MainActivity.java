package com.example.assignment_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;
    private EditText editTextEmail;
    private Button buttonSubmit;
    private TextView textViewMessage;

    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_]{3,15}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-zA-Z]).{6,}$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        textViewMessage = findViewById(R.id.textViewMessage);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
            }
        });
    }

    private void validateForm() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        textViewMessage.setText("");

        if (!Pattern.matches(USERNAME_PATTERN, username)) {
            textViewMessage.setText("Invalid username. Must be 3-15 characters (letters, numbers, underscores).");
            return;
        }

        if (!Pattern.matches(PASSWORD_PATTERN, password)) {
            textViewMessage.setText("Invalid password. Must be at least 6 characters long and contain at least one letter and one number.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            textViewMessage.setText("Passwords do not match.");
            return;
        }

        if (!Pattern.matches(EMAIL_PATTERN, email)) {
            textViewMessage.setText("Invalid email format.");
            return;
        }

        textViewMessage.setText("Form submitted successfully!");

    }
}
