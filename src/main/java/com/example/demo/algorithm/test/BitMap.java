package com.example.demo.algorithm.test;

/**
 * @author: sunzhinan
 * @create: 2022-04-17 11:40
 * @description: 位图
 */
public class BitMap {
    private long[] bits;

    public BitMap(int max){
        bits = new long[(max + 64) >> 6];
    }

    public void add(int num){
        /**
         * // 先找到在数组中下标的位置
         * int index = num / 64;
         * // 再找到第几位修改成1
         * int k = num % 64;
         * long aus = 1L << k;
         * // 最后 或上原先bits[index]数，就得到结果
         * bits[index] = bits[index] | aus;
         */

         // 上面合并起来就是
        bits[num >> 6] |= (1L << (num & 63));
        /**
         * 说明：
         * num%64 = num&63
         * a |= b 等同于 a = a｜b
         */

        print(bits[num >> 6]);
    }

    public void delete(int num){
        bits[num >> 6] &= ~(1L << (num & 63));
    }

    public boolean contains(int num){
        return (bits[num >> 6] & (1L << (num & 63))) != 0;
    }

    public static void main(String[] args) {
        BitMap map = new BitMap(180);

        map.add(170);
        map.add(191);
        map.delete(170);
        map.add(190);

        System.out.println(map.contains(170));
        System.out.println(map.contains(190));

    }

    private static void print(long mun){
        StringBuilder sb = new StringBuilder("");
        for (int i = 63; i >= 0 ; i--) {
            sb.append((mun&(1L << i)) != 0 ? "1" : "0");
        }

        System.out.println(sb.toString());
    }
}
