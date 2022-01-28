
package com.redhat;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.ImportResource;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
// @ImportResource({ "classpath:spring/camel-context.xml" })
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    public ServletRegistrationBean cxfServletRegistrationBean(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new CXFServlet(), "/services/*");
        registrationBean.setLoadOnStartup(1);
        registrationBean.setName("CXFServlet");
        return registrationBean;
    }
    @Bean
    public SpringBus cxf() {        
        return new SpringBus();
    }
}
