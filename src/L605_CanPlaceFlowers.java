// 605. Can Place Flowers

public class L605_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 1, result = 0;
        for (int value : flowerbed) {
            if (value == 0) {
                count++;
            } else {
                result += (count - 1) / 2;
                count = 0;
            }
        }
        if (count != 0) result += count / 2;
        return result >= n;
    }
}
