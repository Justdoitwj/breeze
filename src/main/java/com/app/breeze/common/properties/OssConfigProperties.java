package com.app.breeze.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;


/**
 * @ProjectName: breeze
 * @PackageName: com.app.breeze.common.properties
 * @ClassName: OssConfigProperties
 * @Description:
 * @author: wangjie
 * @date: 2020/1/4  22:13
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2020
 * 如果我们希望配置参数在传入到应用中时有效的，
 *  * 我们可以通过在字段上添加 bean validation 注解，同时在类上添加 @Validated 注解
 *  * 并在参数对应字段上加上对应的校验注解如：@NotNull、@Email等
 *  * 优点：
 *  * 1.可在项目启动过程中校验并发现配置文件中的参数
 *
 *  ignoreInvalidFields 默认为 false .
 *  * 是否忽略类型错误的字段（或无法强制转换为正确类型的字段），如果为false,配置的参数和实体类的字段类型不匹配会抛异常，项目启动失败。
 */

@Data
@Component
@Validated
@ConfigurationProperties(prefix = "aliyun.oss")
public class OssConfigProperties {
    @NotNull
    private String endpoint;
    @NotNull
    private String accessKeyId;
    @NotNull
    private String accessKeySecret;
    private String bucketName;
    /**
     * ynl文件命名不支持驼峰，用“-”对多个单词进行分割，在实体类进行装载时可用驼峰去接受“-”类型字段
     */
    private Boolean testBoolean = Boolean.TRUE;
}
