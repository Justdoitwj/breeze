package com.app.test.huaweiod;

import java.util.Scanner;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.test.huaweiod
 * @ClassName: test4
 * @Description:
 * @author: wangjie
 * @date: 2020/5/5  18:15
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class test4 {
    /**
     * 任给一个数组，其中只有一个元素是单独出现，其他是成对出现，输出单独的元素。
     * 例如： 输入： {2，2，1，1，4，4，7}
     * 输出：7
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String arrStr= sc.next();
        String[] arr= arrStr.split("，");
        String[][] arr2=new String[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            if(null!=arr[i]&&arr[i].length()>0){
            }
        }
    }
}
