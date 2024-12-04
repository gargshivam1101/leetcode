class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }
        // a cycle is formed and slow and fast have colided
        // again start from beginning and move both at same speed
        fast = nums[0];

        while (slow != fast) {
            // answer is the point where they colide: Floyd's Tortoise and Hare algorithm
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
