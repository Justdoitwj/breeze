package com.app.test.huaweiod;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.test.huaweiod
 * @ClassName: CharRepace
 * @Description:
 * @author: wangjie
 * @date: 2020/5/10  17:20
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class CharRepace {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str= sc.next();
            char[] arr= str.toCharArray();
            Set<String> set=new HashSet<>();
            StringBuffer sb=new StringBuffer();
            for(char c:arr){
                set.add(String.valueOf(c));
                sb.append(String.valueOf(c));
            }
            System.out.println(sb.toString());
        }
    }
}
