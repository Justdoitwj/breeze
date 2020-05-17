package com.app.test.huaweiod;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.test.huaweiod
 * @ClassName: Main16TO10
 * @Description:
 * @author: wangjie
 * @date: 2020/5/10  15:51
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class Main16TO10 {
    public static void main(String[] args) {
        String s = "0xA";
        int b = Integer.parseInt(s.replaceAll("^0[x|X]", ""), 16);
        System.out.println(b);
    }
}
