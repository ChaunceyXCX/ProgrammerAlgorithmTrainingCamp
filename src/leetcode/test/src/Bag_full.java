package src;

import java.util.Arrays;

public class Bag_full {

    public static void main(String[] args) {
        //int[] weight = new int[]{1, 3, 4};
        //int[] value = new int[]{15, 20, 30};
        //int bag = 4;
        //weightFirst(weight,value,bag);
        //bagFirst(weight,value,bag);
        int mid = 1073697800;
        System.out.println(mid*mid);
        System.out.println((long)mid*mid);
        System.out.println((long)mid*mid>mid);
    }

    public static void weightFirst(int[] weight, int[] value, int bag){
        int[] dp = new int[bag+1];

        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bag ; j++) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i] );
            }
        }

        System.out.println(Arrays.toString(dp));

    }

    public static void bagFirst(int[] weight, int[] value, int bag) {
        int[] dp = new int[bag+1];

        for (int j = 0; j <= bag; j++) {
            for (int i = 0; i < weight.length; i++) {
                if (j-weight[i]>=0) dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }

        System.out.println(Arrays.toString(dp));
    }
}
