package io.github.liziscoding.memoryrefactored;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    SwitchCompat cardNumberSwitch;
    SwitchCompat cardImageSwitch;

    private int cardNumber = 12;
    private int cardImages = 0; // 0 = animals; 1 = vegetables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            cardNumber = savedInstanceState.getInt("cardNumber");
            cardImages = savedInstanceState.getInt("cardImages");
        }

        cardNumber = getIntent().getIntExtra(GameActivity.CARD_NUMBER, 0);
        cardImages = getIntent().getIntExtra(GameActivity.CARD_IMAGES, 0);

        cardNumberSwitch = findViewById(R.id.cardNumberSwitch);
        cardNumberSwitch.setTextOff("12");
        cardNumberSwitch.setTextOn("18");
        cardNumberSwitch.setThumbTextPadding(5);
        cardImageSwitch = findViewById(R.id.cardImageSwitch);
        cardImageSwitch.setTextOff(new String(Character.toChars(0x1F981	)));
        cardImageSwitch.setTextOn(new String(Character.toChars(0x1F352	)));
        cardImageSwitch.setThumbTextPadding(5);

        if (cardImages == 1){
            cardImageSwitch.isChecked();
            cardImageSwitch.setChecked(true);
        }

        if (cardNumber == 18){
            cardNumberSwitch.isChecked();
            cardNumberSwitch.setChecked(true);
        }

    }


    public void switchCardNumber (View view){
        boolean on = ((SwitchCompat) view).isChecked();

        if (on){
            cardNumber = 18;
        } else {
            cardNumber = 12;
        }
    }

    public void switchCardImages (View view){
        boolean on = ((SwitchCompat) view).isChecked();

        if (on){
            cardImages = 1;
        } else {
            cardImages = 0;
        }
    }

    public void startGame(View view){
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(GameActivity.CARD_NUMBER, cardNumber);
        intent.putExtra(GameActivity.CARD_IMAGES, cardImages);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("cardNumber", cardNumber);
        outState.putInt("cardImages", cardImages);
    }
}
