package com.example.demo.hw;

/**
 * @author: sunzhinan
 * @create: 2022-04-16 00:46
 * @description: 牛客网华为机试第四题
 */
public class Test022 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        scanner.close();

        String str = "012345678";
        if (str == null || str.trim().length() == 0){
            return;
        }

        int start = 0;
        int end = 8;
        int length = str.length();

        if(length % 8 != 0){
            int k = 8 - (length % 8);
            for (int i = 0; i < k; i++) {
                str = str + "0";
            }

        }
        while (end <= str.length()){
            System.out.println(str.substring(start,end));
            start = end;
            end+=8;
        }

    }

}
