package com.example.demo.basis.algorithm;

public class Test04 {

    private static int[] nums = {0,0,1,1,1,2,2,3,3,4};

    public static void main(String[] args) {
        if (nums == null || nums.length == 0) {
//            return 0;
            System.out.println(0);
        }
        int left = 0;
        for (int right = 1; right < nums.length; right++){
            //如果左指针和右指针指向的值一样，说明有重复，这个时候，左指针不动，右指针继续往右移。如果他俩指向的值不一样就把右指针指向的值往前挪
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];

            }
        }

//        return ++left;
        System.out.println(++left);
        for (int i = 0; i < nums.length-1; i++) {
            System.out.println(nums[i]);
        }

        System.out.println("----------------");
        System.out.println(nums.length);
    }
}
