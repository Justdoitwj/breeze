package com.app.test.huaweiod;


import java.util.Scanner;

public class shangji {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        while (in.hasNextInt()) {
            int index = 0;
            int a = in.nextInt();
            //除了本身和1之外，不能被其他数字整除
           if(a>3){
                for (int i = 2; i <= a; i++) {
                    if (isZhishu(i)) {
                        System.out.println(i);
                        index++;
                    }
                }
            }else{
                if(a==2){
                    index=1;
                }else if(a==3){
                    index=2;
                }
            }
            System.out.println(index);
        }
    }

    private static boolean isZhishu(int num) {
        if(num==2){
            return true;
        }
        if(num%2==0){
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
