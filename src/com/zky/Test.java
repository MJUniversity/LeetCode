package com.zky;

public class Test {
    /**
     *
     * @author: yuan
     * @date: 2023/1/4
     * Description:  测试算法
     */
    public static void main(String[] args) {
        int[] nums1 = {1,2,6,7,9};
        int[] nums2 = {3,5,8,10};
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        double d = findMedianSortedArrays.findMedianSortedArrays(nums1,nums2);
        System.out.println(d);
    }
}
