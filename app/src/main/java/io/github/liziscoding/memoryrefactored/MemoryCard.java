package io.github.liziscoding.memoryrefactored;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MemoryCard {
    private static final String TAG = "MemoryCard";

    int imageResource;
    int soundResource;

    public MemoryCard(int imageResource, int soundResource) {
        this.imageResource = imageResource;
        this.soundResource = soundResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public int getSoundResource() {
        return soundResource;
    }


    public static ArrayList<MemoryCard> createSetOfMemoryCards(int numberOfCards, int cardSet){
        ArrayList<MemoryCard> result = new ArrayList<>();
        Random rand = new Random();
        ArrayList<Integer> indexArray = new ArrayList<>();
        for (int i = 0; i < imageAssetList.get(cardSet).size(); i++){
            indexArray.add(i);
        }
        // --> indexArray = 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14 (example)

        ArrayList<Integer> randomIndexArray = new ArrayList<>();
        for (int i = 0; i < numberOfCards/2; i++){
            int newRandomNumber = rand.nextInt(indexArray.size());
            randomIndexArray.add(indexArray.get(newRandomNumber));
            randomIndexArray.add(indexArray.get(newRandomNumber));
            indexArray.remove(newRandomNumber);
        }
        // --> randomIndexArray = 2,2,9,9,0,0,4,4,3,3,5,5,1,1,7,7

        Collections.shuffle(randomIndexArray);
        Collections.shuffle(randomIndexArray);
        Collections.shuffle(randomIndexArray);

        for (int i = 0; i < randomIndexArray.size(); i++){
            result.add(new MemoryCard(imageAssetList.get(cardSet).get(randomIndexArray.get(i)),soundAssetList.get(cardSet).get(randomIndexArray.get(i))));
        }

        return result;
    }

    private static ArrayList<Integer> animalsImageResourcesList = new ArrayList<>(Arrays.asList(R.drawable.cow_600_620, R.drawable.owl_600_610,
            R.drawable.frog_600_639, R.drawable.horse_600_602, R.drawable.dog_600_610, R.drawable.pig_600_600,
            R.drawable.lion_600_622, R.drawable.kangaroo_600_608, R.drawable.giraffe_600_609, R.drawable.duck, R.drawable.bear, R.drawable.chicken, R.drawable.cat, R.drawable.mouse,
            R.drawable.hamster, R.drawable.sheep, R.drawable.spider));

    private static ArrayList<Integer>  vegetablesImageResourcesList = new ArrayList<>(Arrays.asList(R.drawable.apple, R.drawable.banana, R.drawable.broccoli, R.drawable.carrot, R.drawable.cucumber,
            R.drawable.potato, R.drawable.kiwi, R.drawable.mango, R.drawable.pepper, R.drawable.strawberry));

    private static ArrayList<Integer> animalsSoundResourcesList = new ArrayList<>(Arrays.asList(R.raw.cow, R.raw.owl, R.raw.frog,
            R.raw.horse, R.raw.dog, R.raw.pig, R.raw.lion, R.raw.kangaroo, R.raw.giraffe, R.raw.duck, R.raw.bear, R.raw.chicken, R.raw.cat, R.raw.mouse, R.raw.hamster,
            R.raw.sheep, R.raw.spider));

    private static ArrayList<Integer> vegetablesSoundResourcesList = new ArrayList<>(Arrays.asList(R.raw.apple, R.raw.banana, R.raw.broccoli, R.raw.carrot, R.raw.cucumber,
            R.raw.potato, R.raw.kiwi, R.raw.mango, R.raw.pepper, R.raw.strawberry));

    private static ArrayList<ArrayList<Integer>> imageAssetList =
            new ArrayList<>(Arrays.asList(animalsImageResourcesList, vegetablesImageResourcesList));
    private static ArrayList<ArrayList<Integer>> soundAssetList =
            new ArrayList<>(Arrays.asList(animalsSoundResourcesList, vegetablesSoundResourcesList));
}
