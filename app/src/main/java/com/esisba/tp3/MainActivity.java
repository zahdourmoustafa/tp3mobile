package com.esisba.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MaterialCardView card1, card2, card3, card4, card5, reset;
    List<String> names = new ArrayList<>();
    List<String> images = new ArrayList<>();
    List<String> descriptions = new ArrayList<>();
    public MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        names.add("Subh");
        names.add("Duhr");
        names.add("Asr");
        names.add("Maghreb");
        names.add("Ichaa");
        images.add("sob7");
        images.add("dhour");
        images.add("asr");
        images.add("maghreb");
        images.add("icha");
        descriptions.add("Subh description");
        descriptions.add("Duhr description");
        descriptions.add("Asr description");
        descriptions.add("Maghreb description");
        descriptions.add("Ichaa description");

        setContentView(R.layout.activity_main);
        initialisation();
        onClicks();

        // Initialize MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.music);

        if (savedInstanceState != null) {
            boolean isPlaying = savedInstanceState.getBoolean("is_playing", false);
            if (isPlaying) {
                mediaPlayer.start();
            }
        } else {
            mediaPlayer.start();  // Start music on initial creation
        }
    }

    private void initialisation() {
        card1 = findViewById(R.id.subh);
        card2 = findViewById(R.id.duhr);
        card3 = findViewById(R.id.asr);
        card4 = findViewById(R.id.maghreb);
        card5 = findViewById(R.id.ichaa);
    }

    private void onClicks() {
        card1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                openDetailsActivity(0); // Pass index to identify the clicked card
                return true;
            }
        });

        card2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                openDetailsActivity(1);
                return true;
            }
        });

        card3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                openDetailsActivity(2);
                return true;
            }
        });

        card4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                openDetailsActivity(3);
                return true;
            }
        });

        card5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                openDetailsActivity(4);
                return true;
            }
        });
    }

    private void openDetailsActivity(int index) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("name", names.get(index));
        intent.putExtra("image", images.get(index));
        intent.putExtra("description", descriptions.get(index));
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mediaPlayer != null) {
            outState.putBoolean("is_playing", mediaPlayer.isPlaying());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mediaPlayer != null && mediaPlayer.isPlaying())
            mediaPlayer.pause();

    }
    @Override
    protected void onResume() {
        super.onResume();

        if (mediaPlayer != null)
            mediaPlayer.start();
    }
}