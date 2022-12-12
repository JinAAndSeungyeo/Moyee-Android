package com.github.sseung416.moyee.view.playlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.github.sseung416.moyee.R;
import com.github.sseung416.moyee.databinding.ActivityPlaylistBinding;
import com.github.sseung416.moyee.view.playlist.service.MusicPlayerService;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPlaylistBinding binding = ActivityPlaylistBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button3.setOnClickListener(v -> {
            Log.e("", "onCreate: clicked button");
            Intent intent = new Intent(this, MusicPlayerService.class);
            startService(intent);
        });
    }
}