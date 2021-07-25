package cn.wing.kid.hottr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * >> 1 Tomcat启动时, 会完成DispatcherServlet的初始化：
 * -1)，完成web.xml参数加载;
 * -2)，建立WebApplicationContext(SpringMVC中的ioc);
 * -3)，组件的初始化.
 *
 * >> 2 本工程使用Java将DispatcherServlet配置到Servlet容器中. 根配置定义在RootConfig中，DispatcherServlet的配置 声明在WebConfig中。
 *
 * >> 3 DispatcherServlet启动的原理:
 * - 扩展AbstractAnnotationConfigDispatcherServletInitializer的任意类都会自动地配置Dispatcher-Servlet和Spring应用上下文，
 * - Spring的应用上下文会位于应用程序的Servlet上下文之中。
 *
 * >> 4 当部署到Servlet3.0中时，容器会自动发现WebApplicationInitializer的实现类
 * (即AbstractAnnotationConfigDispatcherServletInitializer),
 * 并用该实现类配置Servlet上下文.
 *
 * Created by WangSai on 2021/7/18
 */
public class HottrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 将一个或者多个路径映射到DispatcherServlet上. 这里映射的路径是"/"，表示它是应用默认的Servlet.
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    /**
     * 当DispatcherServlet启动的时候，我们要求其使用WebConfig配置类，去完成Spring应用上下文的创建.
     * 该应用上下文用于创建Web组件的bean，如控制器、视图解析器以及处理器映射.
     *
     * @return 返回带有@Configuration注解的类，用来定义DispatcherServlet应用上下文中的bean
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * AbstractAnnotationConfigDispatcherServletInitializer会同时创建DispatcherServlet和ContextLoaderListener
     * (其中，ContextLoaderListener创建另外一个应用上下文).
     * 该应用上下文用于加载应用中的其他bean.
     *
     * @return 返回的带有@Configuration注解的类, 用来配置ContextLoaderListener创建的应用上下文中的bean
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }


}