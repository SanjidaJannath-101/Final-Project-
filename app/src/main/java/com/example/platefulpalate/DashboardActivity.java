package com.example.platefulpalate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Find the Explore button from the layout
        Button exploreButton = findViewById(R.id.exploreButton);

        // Set an OnClickListener to navigate to RecipePageActivity
        exploreButton.setOnClickListener(v -> {
            // Navigate to the Recipe Page (RecipePageActivity)
            Intent intent = new Intent(DashboardActivity.this, RecipePageActivity.class);
            startActivity(intent);
        });
    }
}
