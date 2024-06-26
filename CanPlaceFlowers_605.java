class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length;) {
            if (flowerbed[i] == 1) {
                i = i + 2;
            } else if (flowerbed[i] == 0 && i == flowerbed.length - 1) {
                // we reached last element, and it is 0
                flowerbed[i] = 1;
                count++;
                i = i + 2;
            } else if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                count++;
                i = i + 2;
            } else {
                i++;
            }
            if (n == count) {
                return true;
            }
        }
        return false;
    }
}
