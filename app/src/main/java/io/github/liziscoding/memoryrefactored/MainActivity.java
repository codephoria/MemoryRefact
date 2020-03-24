package io.github.liziscoding.memoryrefactored;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class MainActivity extends AppCompatActivity {

    SwitchCompat cardNumberSwitch;
    SwitchCompat cardImageSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardNumberSwitch = findViewById(R.id.cardNumberSwitch);
        cardNumberSwitch.setTextOff("12");
        cardNumberSwitch.setTextOn("18");
        cardNumberSwitch.setThumbTextPadding(5);
        cardImageSwitch = findViewById(R.id.cardImageSwitch);
        cardImageSwitch.setTextOff(new String(Character.toChars(0x1F981	)));
        cardImageSwitch.setTextOn(new String(Character.toChars(0x1F352	)));
        cardImageSwitch.setThumbTextPadding(5);
    }
}
