package com.goce.datastructures;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = { 5, 1, 6, 2, 3, 4 };
        quickSortRecursion(a);
        /*
        mergeSort(a, a.length);
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);

         */
    }


    public static void quickSortRecursion(int[] a) {

        quickSortRecursion(a, 0, a.length - 1);

        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }

    public static void quickSortRecursion(int[] a, int leftStart, int rightEnd){

        if(leftStart >= rightEnd)
            return;

        int pivot = a[(leftStart + rightEnd) / 2];
        int index = partition(a, leftStart, rightEnd, pivot);
        quickSortRecursion(a, leftStart, index-1);
        quickSortRecursion(a, index, rightEnd);
    }

    public static int partition(int[] a, int leftStart, int rightEnd, int pivot){
        while (leftStart <= rightEnd){
            while (a[leftStart] < pivot){
                leftStart++;
            }

            while (a[rightEnd] > pivot){
                rightEnd--;
            }

            if(leftStart <= rightEnd){
                int temp = a[leftStart];
                a[leftStart] = a[rightEnd];
                a[rightEnd] = temp;

                leftStart++;
                rightEnd--;
            }
        }
        return leftStart;

    }


}