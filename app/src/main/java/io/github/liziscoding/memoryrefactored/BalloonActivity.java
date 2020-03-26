package io.github.liziscoding.memoryrefactored;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class BalloonActivity extends AppCompatActivity {

    ConstraintLayout balloonLayout;
    int cardNumber;
    int cardImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balloon);

        cardNumber = getIntent().getIntExtra(GameActivity.CARD_NUMBER, 0);
        cardImages = getIntent().getIntExtra(GameActivity.CARD_IMAGES, 0);

        balloonLayout = findViewById(R.id.balloonLayout);
        MediaPlayer mediaPlayer = new MediaPlayer();
        if (mediaPlayer != null){
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this,R.raw.yeah);
        mediaPlayer.start();
        balloonLayout.animate().translationY(-3000).setDuration(12000).withEndAction(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra(GameActivity.CARD_NUMBER, cardNumber);
                intent.putExtra(GameActivity.CARD_IMAGES, cardImages);
                startActivity(intent);
                finish();
            }
        });
    }


    public void onBalloonClick(View view){
        ImageView balloon = (ImageView) view;
        balloon.animate().alpha(0).setDuration(200);
    }
}
