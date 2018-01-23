package com.omnify.hire;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;



public class DisplaySortedNumbersFragment extends Fragment {

    TextView mTextViewQuickSortNumbers,mTextViewMergeSortNumbers,mTextViewTryAgain;
    public static ArrayList<Integer> mArrayListRandomNumbers;


    public static DisplaySortedNumbersFragment newInstance(ArrayList<Integer> arrayListRandomNumbers) {
        DisplaySortedNumbersFragment fragment = new DisplaySortedNumbersFragment();
        Bundle args = new Bundle();
        mArrayListRandomNumbers = arrayListRandomNumbers;
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_display_sorted_numbers, container, false);
        initializeScreen(rootView);

        mTextViewTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new GenerateRandomNumbersFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_activity_layout, fragment);
                fragmentTransaction.commit();
            }
        });

        if (mArrayListRandomNumbers != null && mArrayListRandomNumbers.size() > 0)
        {
            performQuickSort();
            performMergeSort();
        }

        return rootView;

    }


    private void initializeScreen(View rootView) {
        mTextViewQuickSortNumbers = (TextView) rootView.findViewById(R.id.text_view_quick_sort_numbers);
        mTextViewMergeSortNumbers = (TextView) rootView.findViewById(R.id.text_view_merge_sort_numbers);
        mTextViewTryAgain = (TextView) rootView.findViewById(R.id.text_view_try_again);
    }

    public void performQuickSort()
    {
        SortRandomNumbers obj = new SortRandomNumbers(mArrayListRandomNumbers);
        ArrayList<Integer> arrayListQuickSortedArray = obj.getQuickSortedArray();

        String sortedNumbers = "";
        for (Integer eachNumber :arrayListQuickSortedArray ) {
            sortedNumbers = sortedNumbers + eachNumber + "\n";
        }

        mTextViewQuickSortNumbers.setText(sortedNumbers);
    }

    public void performMergeSort()
    {
        SortRandomNumbers obj = new SortRandomNumbers(mArrayListRandomNumbers);
        ArrayList<Integer> arrayListMergeSortedArray = obj.getMergeSortedArray();

        String sortedNumbers = "";
        for (Integer eachNumber :arrayListMergeSortedArray ) {
            sortedNumbers = sortedNumbers + eachNumber + "\n";
        }

        mTextViewMergeSortNumbers.setText(sortedNumbers);
    }


}
