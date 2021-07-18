package cn.wsai.hammer.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by WangSai on 2021/7/19
 */
@Configuration
@EnableWebMvc //用于启用SpringMVC
@ComponentScan() //启用组件扫描
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 它会查找JSP文件，在查找的时候， 它会在视图名称上加一个特定的前缀和后缀（例如，名为home的视图将 会解析为/WEB-INF/views/home.jsp）
     *
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * 重写了父类的WebMvcConfigurerAdapter.configureDefaultServletHandling()方法.
     * 通过调用DefaultServlet-HandlerConfigurer的enable()方法，DispatcherServlet将对静态资源的请求转发到Servlet容器中默认的
     * Servlet上，而不是使用DispatcherServlet本身来处理此类请求.
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
