package real_spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Evgeny Borisov
 */
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan
public class Conf {
}
