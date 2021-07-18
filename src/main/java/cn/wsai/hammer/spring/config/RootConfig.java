package cn.wsai.hammer.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 因为本章聚焦于Web开发， 而Web相关的配置通过DispatcherServlet创建的应用上下文都已经 配置好了, 因此现在的RootConfig相对很简单.
 * <p>
 * Created by WangSai on 2021/7/19
 */
@Configuration
@ComponentScan(
        basePackages = {"cn.wsai.hammer.spring.hammer"},
        excludeFilters = {@ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                value = EnableWebMvc.class)})
public class RootConfig {
}