package com.app.test.huaweiod;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.test.huaweiod
 * @ClassName: Main4
 * @Description:
 * @author: wangjie
 * @date: 2020/5/14  16:34
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class Main4 {
    public static void main(String[] args) {
        int[] arr=new int[]{5 ,10, 9, 8, 5, 2, 5, 9 ,8, 10, 1, 1, 7,0};
        int[] data=new int[11];
        //去重，数值累计
        for (int i=0;i<arr.length;i++){
            data[arr[i]]+=arr[i];
        }
        //排序，降序
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                if(data[j]<data[j+1]){
                    int tem = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tem;
                }
            }
        }
        //取前三个数字
        System.out.println(data[0]+data[1]+data[2]);
    }
}
