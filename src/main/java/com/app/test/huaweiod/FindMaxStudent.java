package com.app.test.huaweiod;

import java.util.Scanner;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.test.huaweiod
 * @ClassName: FindMaxStudent
 * @Description:
 * @author: wangjie
 * @date: 2020/5/10  16:13
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class FindMaxStudent {

    public static void main(String[] args) {
        int[] arr=new int[]{1,5,56,0,545,548,45,33,3};
        maopao(arr);

    }
    /**
     * @Description 冒泡排序
     * 算法思路：
     * 进行len-1次冒泡
     * 第k次冒泡将倒数第k个元素排好序
     * @Author wangjie
     * @Param
     * @Return
     * @throws:
     * @Date 2020/5/10 16:35
     */
    private static  void maopao(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int tem=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tem;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

}
