package com.omnify.hire;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

import static android.R.attr.max;


public class GenerateRandomNumbersFragment extends Fragment {

    TextView mTextViewGenerateNumbers,mTextViewSortNumbers,mTextViewRandomNumbers;
    ArrayList<Integer> mArrayListRandomNumbers;


    @Override
    public View onCreateView(LayoutInflater inflater,final ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_generate_random_numbers, container, false);
        initializeScreen(rootView);


        mTextViewGenerateNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mArrayListRandomNumbers.clear();
                mTextViewRandomNumbers.setText("");

                Random rand = new Random();
                while (mArrayListRandomNumbers.size() < 20){
                    mArrayListRandomNumbers.add(rand.nextInt((99 - 10) + 1) + 10 );
                }

                String allRandomNumbers = "";
                for (Integer eachRandomNumber :mArrayListRandomNumbers ) {
                    allRandomNumbers = allRandomNumbers + eachRandomNumber + "\n" ;
                }

                mTextViewRandomNumbers.setText(allRandomNumbers);

            }
        });

        mTextViewSortNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mArrayListRandomNumbers == null || mArrayListRandomNumbers.size() <= 0)
                {
                    Toast.makeText(getActivity(),"Please generate Random numbers",Toast.LENGTH_SHORT).show();
                    return;
                }

                Fragment fragment = new DisplaySortedNumbersFragment().newInstance(mArrayListRandomNumbers);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_activity_layout, fragment);
                fragmentTransaction.commit();

            }
        });

        return rootView;
    }

    private void initializeScreen(View rootView) {
        mTextViewGenerateNumbers = (TextView) rootView.findViewById(R.id.text_view_generate_numbers);
        mTextViewSortNumbers = (TextView) rootView.findViewById(R.id.text_view_sort_numbers);
        mTextViewRandomNumbers = (TextView) rootView.findViewById(R.id.text_view_random_numbers);

        mArrayListRandomNumbers = new ArrayList<>();
    }

}
