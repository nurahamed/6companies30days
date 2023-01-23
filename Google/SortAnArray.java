    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    private int[] mergeSort(int[] nums, int left, int right) {
        
        if (right - left == 0) {
            return new int[] {nums[left]};
        }
        
        int mid = left + (right - left) / 2;
        int[] leftHalfSorted = mergeSort(nums, left, mid);
        int[] rightHalfSorted = mergeSort(nums, mid + 1, right);
        
        return combine(leftHalfSorted, rightHalfSorted);
    }
    
    private int[] combine(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int idxLeft = 0, idxRight = 0, idx = 0;
        while (idxLeft < left.length && idxRight < right.length) {
            if (left[idxLeft] <= right[idxRight]) {
                res[idx++] = left[idxLeft++];
            } else {
                res[idx++] = right[idxRight++];
            }
        }
        
        if (idxLeft < left.length) {
            for (int i = idx; i < res.length; i++)
                res[i] = left[idxLeft++];
        } else {
            for (int i = idx; i < res.length; i++)
                res[i] = right[idxRight++];
        }      
        return res;
    }
