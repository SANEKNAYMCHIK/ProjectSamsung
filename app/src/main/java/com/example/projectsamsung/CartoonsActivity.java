package com.example.projectsamsung;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.projectsamsung.db.DbManager;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class CartoonsActivity extends YouTubeBaseActivity {
    private static final String YOUTUBE_API = "AIzaSyBMwQLLpLj3EifKbCt7TATRxZY79pY8gEs";
    TextView editText;
    YouTubePlayerView youTubePlayerView;
    Button cartoon_button;
    int video_state = 0;
    DbManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartoons);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        dbManager = new DbManager(this);
        youTubePlayerView = findViewById(R.id.youtube_player_view);
        cartoon_button = findViewById(R.id.btn);


        YouTubePlayer.OnInitializedListener listener = new YouTubePlayer.OnInitializedListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onInitializationSuccess(Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                cartoon_button.setOnClickListener(v -> {
                    if (video_state == 0) {
                        dbManager.openDb();
                        for (String id : dbManager.get().keySet()) {
                            if ((dbManager.get().get(id) == 0 && !(id.contains("star"))) &&
                                    (dbManager.get().get("star1") >= 5 && dbManager.get().get("star1") >= 5)) {
                                dbManager.update(id, 0);
                                dbManager.update("star1", -5);
                                dbManager.update("star2", -5);
                                dbManager.close();
                                youTubePlayer.loadVideo(id);
                                youTubePlayer.play();
                                video_state = 1;
                                break;
                            }
                        }
                    }
                });
            }

            @Override
            public void onInitializationFailure(Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(getApplicationContext(), "Ошибка!", Toast.LENGTH_SHORT).show();
            }
        };
        youTubePlayerView.initialize(YOUTUBE_API, listener);
    }

}




