package src;

import java.util.Arrays;

public class Bag_01 {
    public static void main(String[] args) {
        int[] weight = new int[]{1, 3, 4};
        int[] value = new int[]{15, 20, 30};
        int bag = 4;

        bag_01_二维(weight, value, bag);

        bag_01_一维(weight,value,bag);
    }

    public static void bag_01_二维(int[] weight, int[] value, int bag) {
        int[][] dp = new int[weight.length][bag + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int j = 1; j <= bag; j++) {
            dp[0][j] = weight[0] > j ? 0 : value[0];
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bag; j++) {
                if (weight[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i]] + value[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
    }

    public static void bag_01_一维(int[] weight, int[] value, int bag) {
        int[] dp = new int[bag + 1];

        dp[0] = 0;

        for (int i = 0; i < weight.length; i++) {
            for (int j = bag; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j - weight[i]] + value[i], dp[j]);
            }
        }
        System.out.println(Arrays.toString(dp));
    }

}
