package com.example.demo.hw;

/**
 * @author: sunzhinan
 * @create: 2022-04-17 00:29
 * @description: 牛客网华为笔试第六题
 */
public class Test024 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int k = scanner.nextInt();
//        scanner.close();

        int k = 180;
        getAns(k);
    }

    public static void getAns(int num){
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sb.append(i).append(" ");
                num = num / i;
                i--;
            }
        }
        sb.append(num).append(" ");
        System.out.println(sb.toString());
    }
}
