package com.app.breeze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ProjectName: breeze
 * @PackageName: com.app
 * @ClassName: BreezeApplication
 * @Description:
 * @author: wangjie
 * @date: 2020/1/1  18:50
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 */
@SpringBootApplication
public class BreezeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BreezeApplication.class, args);
    }

// extends WebMvcConfigurationSupport
// @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        //1、定义一个convert转换消息的对象
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        //2、添加fastjson的配置信息
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//
//        //全局时间配置
//        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
//        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
//        //3、在convert中添加配置信息
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        //4、将convert添加到converters中
//        converters.add(fastConverter);
//        //5、追加默认转换器
//        super.addDefaultHttpMessageConverters(converters);
//    }
}
