package com.example.platefulpalate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        EditText nameEditText = findViewById(R.id.name);
        EditText emailEditText = findViewById(R.id.email);
        EditText passwordEditText = findViewById(R.id.password);
        EditText confirmPasswordEditText = findViewById(R.id.confirmPassword);
        Button signupButton = findViewById(R.id.signupButton);
        TextView loginRedirect = findViewById(R.id.loginRedirect);

        signupButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString();
            String confirmPassword = confirmPasswordEditText.getText().toString();

            // Regex for name validation (allows alphabets and spaces only, min length 2)
            if (name.isEmpty() || !name.matches("^[A-Za-z ]{2,}$")) {
                nameEditText.setError("Enter a valid name (letters and spaces only, min 2 characters)");
                return;
            }

            // Regex for email validation
            if (email.isEmpty() || !email.matches("^[a-zA-Z0-9._-]+@[gmailyahoo]+\\.+[com]+")) {
                emailEditText.setError("Enter a valid email address (e.g., example@gmail.com)");
                return;
            }

            // Regex for password validation (min 6 characters, at least one uppercase, one lowercase, one number, one special character)
            if (password.isEmpty() || !password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{6,}$")) {
                passwordEditText.setError("Password must be at least 6 characters, include uppercase, lowercase, number, and special character");
                return;
            }

            // Confirm password validation
            if (!password.equals(confirmPassword)) {
                confirmPasswordEditText.setError("Passwords do not match");
                return;
            }


            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                            finish();
                        } else {
                            Toast.makeText(SignUpActivity.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        });

        loginRedirect.setOnClickListener(v -> startActivity(new Intent(SignUpActivity.this, LoginActivity.class)));
    }
}

