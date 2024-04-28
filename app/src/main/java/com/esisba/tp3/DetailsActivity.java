package com.esisba.tp3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Get data from the Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name", "");
            String image = extras.getString("image", "");
            String description = extras.getString("description", "");

            // Set values to the corresponding elements in the layout
            TextView nameTextView = findViewById(R.id.name);
            ImageView imageView = findViewById(R.id.image);
            TextView descriptionTextView = findViewById(R.id.description);

            nameTextView.setText(name);
            // Assuming you have images in the 'drawable' folder, use the resource identifier
            int imageResource = getResources().getIdentifier(image, "drawable", getPackageName());
            imageView.setImageResource(imageResource);
            descriptionTextView.setText(description);
        }
    }
}
