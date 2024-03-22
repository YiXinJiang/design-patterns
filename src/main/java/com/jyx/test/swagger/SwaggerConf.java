package com.jyx.test.swagger;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * @ClassName: SwaggerConf
// * @Description:
// * @Author: jyx
// * @Date: 2024-03-01 10:59
// **/
//@Configuration
//@EnableSwagger2
//public class SwaggerConf {
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller")) // 指定扫描的包路径
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("API Documentation") // 设置API文档标题
//                .description("API Documentation for My Project") // 设置API文档描述
//                .version("1.0.0") // 设置API文档版本
//                .build();
//    }
//
//}
