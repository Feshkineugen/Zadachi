package com.example.zadachi;





import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CounterFragment extends Fragment {
    private int counter = 1;
    private int incrementValue = 0; // Initial increment value

    public CounterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_counter, container, false);

        TextView counterView = view.findViewById(R.id.txt_counter);

        Button incrementButton = view.findViewById(R.id.button);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBtnAddDex(counterView);
            }
        });

        Button decrementButton = view.findViewById(R.id.button2);
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBtn2AddDex(counterView);
            }
        });

        return view;
    }

    private void onClickBtnAddDex(TextView counterView) {
        counter += incrementValue + counter ;
        counterView.setText(String.valueOf(counter));
        incrementValue = 0 ; // Reset the increment value after adding

        // Enable the decrement button once the counter reaches 10
        if (counter >= 10) {
            enableDecrementButton();
        }
    }

    private void onClickBtn2AddDex(TextView counterView) {
        if (counter >= 10) {
            counter -= 10;
            counterView.setText(String.valueOf(counter));
            incrementValue++; // Increment the increment value by 1 each time
        }

        // Disable the decrement button if the counter is less than 10
        if (counter < 10) {
            disableDecrementButton();
        }
    }

    private void enableDecrementButton() {
        Button decrementButton = getView().findViewById(R.id.button2);
        decrementButton.setEnabled(true);
    }

    private void disableDecrementButton() {
        Button decrementButton = getView().findViewById(R.id.button2);
        decrementButton.setEnabled(false);
    }
}