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

    // Merge Sort
    public void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else  {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= end) temp[k++] = nums[j++];

        for (int p = 0; p < temp.length; p++) {
            nums[start + p] = temp[p];
        }
    }

    // Heap Sort
    public void heapSort(int[] nums) {
        int n = nums.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
    }

    private void heapify(int[] nums, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && nums[left] > nums[largest]) largest = left;
        if (right < n && nums[right] > nums[largest]) largest = right;

        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, n, largest);
        }
    }

    // Three-way Quick Sort
    public void threeWayQuickSort(int[] array, int low, int high) {
        if (low < high) {
            int[] pivotIndices = partition2(array, low, high);
            threeWayQuickSort(array, low, pivotIndices[0] - 1);
            threeWayQuickSort(array, pivotIndices[1] + 1, high);
        }
    }

    private int[] partition2(int[] array, int low, int high) {
        int pivot = array[low];
        int lt = low;
        int gt = high;
        int i = low + 1;

        while (i <= gt) {
            if (array[i] < pivot) {
                swap(array, lt++, i++);
                continue;
            }
            if (array[i] > pivot) {
                swap(array, i, gt--);
                continue;
            }
            i++;
        }
        return new int[]{lt, gt};
    }


    /*-------------------------------- common -------------------------------------------*/

    //swap
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
