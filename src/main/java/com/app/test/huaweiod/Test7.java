package com.app.test.huaweiod;

import java.util.Arrays;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.test.huaweiod
 * @ClassName: Test7
 * @Description:
 * @author: wangjie
 * @date: 2020/5/5  21:04
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class Test7 {
    public static void main(String[] args) {
//        int[] array = new int[]{3, 4, 5, 2, 8, 1};
//        System.out.println(minNumberInRotateArray(array));
    }

    public static int minNumberInRotateArray(int[] array) {

        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            } else {

                if (i == array.length - 2) {
                    return array[0];
                }


            }
        }
        return 0;
    }
}
