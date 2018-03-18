package Application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by Ionel Carmen on 4/11/2017.
 */
@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter
{
    @Bean
    public InternalResourceViewResolver viewResolver()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/Pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry reg)
    {
        //login
       reg.addViewController("/login").setViewName("/login");
       reg.addViewController("/").setViewName("/login");

//        //admin
        reg.addViewController("/adminMeniu").setViewName("adminMeniu");
        reg.addViewController("/createEmployee").setViewName("createEmployee");
        reg.addViewController("/updateEmployee").setViewName("updateEmployee");
        reg.addViewController("/deleteEmployee").setViewName("deleteEmployee");
        reg.addViewController("/viewEmployee").setViewName("viewEmployee");
        reg.addViewController("/createBook").setViewName("createBook");
        reg.addViewController("/updateBook").setViewName("updateBook");
        reg.addViewController("/deleteBook").setViewName("deleteBook");
        reg.addViewController("/viewBook").setViewName("viewBook");
//
//        //employee
        reg.addViewController("/employeeMeniu").setViewName("employeeMeniu");
        reg.addViewController("/searchAuthor").setViewName("searchAuthor");
        reg.addViewController("/searchTitle").setViewName("searchTitle");
        reg.addViewController("/searchGenre").setViewName("searchGenre");
        reg.addViewController("/createOrder").setViewName("createOrder");
        reg.addViewController("/deleteOrder").setViewName("deleteOrder");
        reg.addViewController("/updateOrder").setViewName("updateOrder");
        reg.addViewController("/viewOrder").setViewName("viewOrder");
        reg.addViewController("/addBooks").setViewName("addBooks");

        reg.addViewController("/pass").setViewName("pass");
    }
}
