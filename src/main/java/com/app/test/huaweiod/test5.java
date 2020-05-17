package com.app.test.huaweiod;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.test.huaweiod
 * @ClassName: test5
 * @Description:
 * @author: wangjie
 * @date: 2020/5/5  18:29
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class test5 {


    public String replaceSpace(StringBuffer str) {
        StringBuffer res= new StringBuffer("");
        if(str.length()>0){
            char[] arr= str.toString().toCharArray();
            for(int i=0 ;i<arr.length;i++){
                if(' '==arr[i]){
                    res.append("%20");
                }else{
                    res.append(arr[i]);
                }

            }
        }
        return res.toString();
    }
}
