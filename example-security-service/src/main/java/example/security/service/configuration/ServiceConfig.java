package example.security.service.configuration;

import example.security.browser.configuration.SecurityBrowserConfig;
import example.security.core.configuration.RedisConfig;
import example.security.core.configuration.SecurityCoreConfig;
import example.security.dao.configuration.DbConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan("example.security.dao.mapper")
@Import({DbConfig.class,SecurityBrowserConfig.class,
        SecurityCoreConfig.class,RedisConfig.class})
@ComponentScan(basePackages = {"example.security.dao",
        "example.security.thirdservice",
        "example.security.service",
        "example.security.core"})
public class ServiceConfig {
}
