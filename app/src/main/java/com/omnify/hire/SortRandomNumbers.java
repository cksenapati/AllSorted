package com.omnify.hire;

import java.util.ArrayList;

import static java.util.Arrays.sort;

/**
 * Created by chandan on 22-01-2018.
 */

public class SortRandomNumbers {
    ArrayList<Integer> arrayListRandomNumbers;

    public SortRandomNumbers() {
    }

    public SortRandomNumbers(ArrayList<Integer> arrayListRandomNumbers) {
        this.arrayListRandomNumbers = arrayListRandomNumbers;
    }

    public ArrayList<Integer> getArrayListRandomNumbers() {
        return arrayListRandomNumbers;
    }

    public void setArrayListRandomNumbers(ArrayList<Integer> arrayListRandomNumbers) {
        this.arrayListRandomNumbers = arrayListRandomNumbers;
    }

    public ArrayList<Integer> getQuickSortedArray()
    {
        ArrayList<Integer> arrayListNumbersAfterQuickSort = arrayListRandomNumbers;
        QuickSort(arrayListNumbersAfterQuickSort,0,arrayListNumbersAfterQuickSort.size()-1);

        return arrayListNumbersAfterQuickSort;
    }

    void QuickSort(ArrayList<Integer> arrayOfIntegers, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arrayOfIntegers, low, high);

            QuickSort(arrayOfIntegers, low, pi-1);
            QuickSort(arrayOfIntegers, pi+1, high);
        }
    }

    int partition(ArrayList<Integer> arrayOfIntegers, int low, int high)
    {
        int pivot = arrayOfIntegers.get(high);
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arrayOfIntegers.get(j)<= pivot)
            {
                i++;
                int temp = arrayOfIntegers.get(i);
                arrayOfIntegers.set(i, arrayOfIntegers.get(j));
                arrayOfIntegers.set(j,temp);
            }
        }

        int temp = arrayOfIntegers.get(i+1);
        arrayOfIntegers.set((i+1), arrayOfIntegers.get(high));
        arrayOfIntegers.set(high ,temp);

        return i+1;
    }


    public ArrayList<Integer> getMergeSortedArray()
    {
        ArrayList<Integer> arrayListNumbersAfterMergeSort = arrayListRandomNumbers;
        MergeSort(arrayListNumbersAfterMergeSort,0,arrayListNumbersAfterMergeSort.size()-1);

        return arrayListNumbersAfterMergeSort;
    }

    void MergeSort(ArrayList<Integer> arrayOfIntegers, int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;

            MergeSort(arrayOfIntegers, l, m);
            MergeSort(arrayOfIntegers , m+1, r);

            merge(arrayOfIntegers, l, m, r);
        }
    }

    void merge(ArrayList<Integer> arrayOfIntegers, int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i)
            L[i] = arrayOfIntegers.get(l + i);
        for (int j=0; j<n2; ++j)
            R[j] = arrayOfIntegers.get(m + 1+ j);


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arrayOfIntegers.set(k , L[i]);
                i++;
            }
            else
            {
                arrayOfIntegers.set(k , R[j]);
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arrayOfIntegers.set(k ,L[i]);
            i++;
            k++;
        }

        while (j < n2)
        {
            arrayOfIntegers.set(k , R[j]);
            j++;
            k++;
        }
    }
}
