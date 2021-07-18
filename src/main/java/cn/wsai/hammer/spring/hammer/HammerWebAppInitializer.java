package cn.wsai.hammer.spring.hammer;

import cn.wsai.hammer.spring.config.RootConfig;
import cn.wsai.hammer.spring.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 当部署到Servlet3.0中时，容器会自动发现WebApplicationInitializer的实现类
 * (即AbstractAnnotationConfigDispatcherServletInitializer),
 * 并用该实现类配置Servlet上下文.
 * <p>
 * <p>
 * Created by WangSai on 2021/7/18
 */
public class HammerWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 将一个或者多个路径映射到DispatcherServlet上.
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
     * @return 带有@Configuration注解的类，用来定义DispatcherServlet应用上下文中的bean
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * AbstractAnnotationConfigDispatcherServletInitializer 会同时创建DispatcherServlet和ContextLoaderListener
     * (其中，ContextLoaderListener创建另外一个应用上下文).
     * 该应用上下文用于加载应用中的其他bean.
     *
     * @return 返回的带有@Configuration注解的类, 用来配置ContextLoaderListenerf创建的应用上下文中的bean
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }


}