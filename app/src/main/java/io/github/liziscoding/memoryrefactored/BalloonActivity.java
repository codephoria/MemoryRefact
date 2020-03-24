package io.github.liziscoding.memoryrefactored;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class BalloonActivity extends AppCompatActivity {

    ConstraintLayout balloonLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balloon);
        balloonLayout = findViewById(R.id.balloonLayout);
        balloonLayout.animate().translationY(-3000).setDuration(15000).withEndAction(new Runnable() {
            @Override
            public void run() {
                
                finish();
            }
        });
    }


    public void onBalloonClick(View view){
        ImageView balloon = (ImageView) view;
        balloon.animate().alpha(0).setDuration(200);
    }
}
