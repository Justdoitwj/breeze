package com.app.test.huaweiod;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.test.huaweiod
 * @ClassName: Main3
 * @Description:
 * @author: wangjie
 * @date: 2020/5/9  9:16
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class Main3 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){

            TreeSet<Integer> set=new TreeSet<Integer>();
            int n=sc.nextInt();
            if(n>0){
                for(int i=0;i<n;i++){
                    set.add(sc.nextInt());
                }
            }
            for(Integer i:set){
                System.out.println(i);
            }
        }
    }
}
