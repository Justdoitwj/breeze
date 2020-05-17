package com.app.demo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo
 * @ClassName: Test
 * @Description:
 * @author: wangjie
 * @date: 2020/4/12  18:31
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数据组数：");
        int T = input.nextInt();

        for(int testcase=1;testcase<=T;testcase++){
            int birdY = input.nextInt();
            int birdM = input.nextInt();
            int birdD = input.nextInt();
            LocalDate start = LocalDate.of(birdY, birdM, birdD);

            int todayY = input.nextInt();
            int todayM = input.nextInt();
            int todayD = input.nextInt();
            LocalDate end = LocalDate.of(todayY, todayM, todayD);
            System.out.println(end.toEpochDay() - start.toEpochDay());
        }
        input.close();

        LocalDate start = LocalDate.of(1996, 5, 11);
        LocalDate end = LocalDate.of(2018, 1, 1);
        System.out.println(end.toEpochDay() - start.toEpochDay());
    }
}
