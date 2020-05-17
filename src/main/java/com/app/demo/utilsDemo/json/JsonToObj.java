package com.app.demo.utilsDemo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.app.breeze.common.pojo.response.CommResponse;
import com.app.breeze.domain.dto.UserDTO;
import com.google.common.collect.Lists;

import java.util.Date;
import java.util.List;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.demo.utilsDemo.json
 * @ClassName: JsonToObj
 * @Description:
 * @author: wangjie
 * @date: 2020/3/2  10:32
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */

public class JsonToObj {
    public static void main(String[] args) {
        testJsonToObj();

    }
    public static void testJsonToObj(){
        List<UserDTO> list= Lists.newArrayList();
        UserDTO user=new UserDTO();
        user.setCreateTime(new Date());
        user.setDoctorCode("123123123");
        list.add(user);
        CommResponse<List<UserDTO>> data=CommResponse.success().setData(list);
        String res=JSON.toJSONString(data);
        System.out.println(res);
        CommResponse<List<UserDTO>> resultModel=JSON.parseObject(res,CommResponse.class);
        System.out.println("直接转换"+resultModel.toString());
        CommResponse<List<UserDTO>> resultModel1 = JSON.parseObject(res, new
                TypeReference<CommResponse<List<UserDTO>>>() {});

        System.out.println(resultModel1.toString());
    }

}
