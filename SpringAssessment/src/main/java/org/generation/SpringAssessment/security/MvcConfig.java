package org.generation.SpringAssessment.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    @Configuration
    public class MvcConfig implements WebMvcConfigurer {

        //Because we have implemented webMvcConfigurer. So we can do our own implementation
        //of the method on the WebMvc Configure interface


        public void addViewControllers(ViewControllerRegistry registry) {
            //Map the browser's URL to a specific View(HTML) inside
            //resources
            registry.addViewController("/").setViewName("ToDoList");
            registry.addViewController("/ToDoList").setViewName("ToDoList");
            registry.addViewController("/ToDoForm").setViewName("ToDoForm");


        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {

            //expose the  js, css resources to the client(browser) so that they can access the
            // necessary files to display
            registry.addResourceHandler("/static")
                    .addResourceLocations("classpath:/static/")
                    .setCachePeriod(0);


        }
    }
