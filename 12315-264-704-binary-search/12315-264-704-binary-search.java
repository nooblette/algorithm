class Solution {
    public int search(int[] nums, int target) {
        return Arrays.binarySearch(nums, target) >= 0 ? Arrays.binarySearch(nums, target) : -1;
    }
}