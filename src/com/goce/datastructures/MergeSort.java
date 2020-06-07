package com.goce.datastructures;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = { 5, 1, 6, 2, 3, 4 };
        mergeSortRecursion(a);
        /*
        mergeSort(a, a.length);
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);

         */
    }


    public static void mergeSortRecursion(int[] a) {
        int[] temp = new int[a.length];

        mergeSortRecursion(a, temp, 0, a.length - 1);

        for (int i = 0; i < temp.length; i++)
            System.out.println(temp[i]);
    }

    public static void mergeSortRecursion(int[] a, int[] temp, int leftStart, int rightEnd){

        if(leftStart >= rightEnd)
            return;

        int middle = (leftStart + rightEnd) / 2;
        mergeSortRecursion(a, temp, leftStart, middle);
        mergeSortRecursion(a, temp, leftStart +1, rightEnd);
        mergeHalvesRecursion(a, temp, leftStart, rightEnd);
    }

    public static void mergeHalvesRecursion(int[] a, int[] temp, int leftStart, int rightEnd){
        int leftEnd =(rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while(left <= leftEnd && right <= rightEnd){
            if(a[left] <= a[right]){
                temp[index] = a[left];
                left++;
            }else {
                temp[index] = a[right];
                right++;
            }
            index++;
        }

        System.arraycopy(a, left, temp, index, leftEnd - left + 1);
        System.arraycopy(a, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, a, leftStart, size);
    }


    public static void mergeSort(int[] a, int n) {
        if (n < 2)
            return;
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {

            if (l[i] <= r[j])
                a[k++] = l[i++];
            else
                a[k++] = r[j++];

        }

        while (i < left)
            a[k++] = l[i++];

        while (j < right)
            a[k++] = r[j++];
    }
}