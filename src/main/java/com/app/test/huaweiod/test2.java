package com.app.test.huaweiod;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.test.huaweiod
 * @ClassName: test2
 * @Description:
 * @author: wangjie
 * @date: 2020/5/5  16:29
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class test2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String val=sc.next();
        //字母去重
        char[] chars=val.toCharArray();
        int len= val.length();
        for(int i=0;i<chars.length;i++){
            for(int j=i+1;j<chars.length;j++){
                if(chars[i]==chars[j]){
                    len--;
                    break;
                }
            }
        }
        BigInteger res=new BigInteger(String.valueOf(len));
        for(int i=len;i>0;i--){
            res=res.multiply(new BigInteger(String.valueOf(i)));
        }
//        res=res.divide(new BigInteger("2"));
        System.out.println(res.longValue());
    }
}
