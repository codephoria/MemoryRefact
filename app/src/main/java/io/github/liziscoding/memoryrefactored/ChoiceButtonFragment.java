package io.github.liziscoding.memoryrefactored;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChoiceButtonFragment extends Fragment {

    SwitchCompat cardNumberSwitch;
    SwitchCompat cardImageSwitch;


    public ChoiceButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choice_button, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null){
            cardNumberSwitch = view.findViewById(R.id.cardNumberSwitch);
            cardNumberSwitch.setTextOff("12");
            cardNumberSwitch.setTextOn("18");
            cardNumberSwitch.setThumbTextPadding(5);
            cardImageSwitch = view.findViewById(R.id.cardImageSwitch);
            cardImageSwitch.setTextOff(new String(Character.toChars(0x1F981	)));
            cardImageSwitch.setTextOn(new String(Character.toChars(0x1F352	)));
            cardImageSwitch.setThumbTextPadding(5);
        }
    }
}
