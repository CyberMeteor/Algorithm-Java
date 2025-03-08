package com.alex.sort;

public class SortTemplate {
    // Quick Sort
    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;

        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    public int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low + 1,  j = high;
        while (i <= j) {
            if (nums[i] > pivot && nums[j] < pivot) {
                swap(nums, i, j);
            }
            if (nums[i] <= pivot) i++;
            if (nums[j] > pivot) j--;
        }
        swap(nums, low, j);
        return j;
    }


    /*-------------------------------- common -------------------------------------------*/

    //swap
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
