package io.github.liziscoding.memoryrefactored;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    public static final String CARD_NUMBER = "card_number";
    public static final String CARD_IMAGES = "card_images";

    int cardNumber;
    int cardImages;
    MediaPlayer mediaPlayer;
    private ArrayList<MemoryCard> allCards;

    RecyclerView memoryRecycler;
    GridLayoutManager layoutManager;

    boolean clickable = true;
    boolean secondDraw = false;
    int firstCard;
    int storedPosition;

    private ArrayList<Boolean> gameState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        cardNumber = getIntent().getIntExtra(CARD_NUMBER, 0);
        cardImages = getIntent().getIntExtra(CARD_IMAGES, 0);

        allCards = MemoryCard.createSetOfMemoryCards(cardNumber, cardImages);
        gameState = new ArrayList<>();
        for (int i = 0; i < allCards.size(); i++) {
            gameState.add(false);
        }

        memoryRecycler = (RecyclerView) findViewById(R.id.memory_recycler);
        MemoryAdapter adapter = new MemoryAdapter(allCards);
        memoryRecycler.setAdapter(adapter);
        if (cardNumber == 12){
            layoutManager = new GridLayoutManager(this, 4);
        } else {
            layoutManager = new GridLayoutManager(this, 6);
        }
        memoryRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new MemoryAdapter.Listener() {
            @Override
            public void onClick(final int position) {
                MemoryCard currentCard = allCards.get(position);
                if (clickable == true) {
                    clickable = false;
                    playSound(currentCard.getSoundResource());

                    if (gameState.get(position) == false) {
                        gameState.set(position, true);

                        CardView clickedCardView = (CardView) layoutManager.findViewByPosition(position);
                        ImageView clickedImageView = (ImageView) clickedCardView.getChildAt(0);
                        clickedImageView.animate().alpha(1).setDuration(500);


                        if (secondDraw == false) {
                            firstCard = currentCard.getImageResource();
                            storedPosition = position;

                            secondDraw = true;
                            clickable = true;
                        } else {
                            // if identical
                            if (firstCard == currentCard.getImageResource()) {
                                clickable = true;
                                if (!gameState.contains(Boolean.FALSE)){
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            Intent intent = new Intent(getApplicationContext(), BalloonActivity.class);
                                            intent.putExtra(GameActivity.CARD_NUMBER, cardNumber);
                                            intent.putExtra(GameActivity.CARD_IMAGES, cardImages);
                                            startActivity(intent);
                                            finish();
                                        }
                                    }, 900);


                                }
                            } else {
                                // if different
                                gameState.set(position, false);
                                gameState.set(storedPosition, false);
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        CardView clickedCardView = (CardView) layoutManager.findViewByPosition(position);
                                        ImageView clickedImageView = (ImageView) clickedCardView.getChildAt(0);
                                        clickedImageView.animate().alpha(0).setDuration(700);
                                        CardView oldClickedCardView = (CardView) layoutManager.findViewByPosition(storedPosition);
                                        ImageView oldClickedImageView = (ImageView) oldClickedCardView.getChildAt(0);
                                        oldClickedImageView.animate().alpha(0).setDuration(700);
                                        clickable = true;
                                    }
                                }, 900);

                            }
                            secondDraw = false;
                        }


                    } else {
                        clickable = true;
                    }

                }
            }
        });
    }

    public void playSound(int sound){
        if (mediaPlayer != null){
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, sound);
        mediaPlayer.start();
    }


}
