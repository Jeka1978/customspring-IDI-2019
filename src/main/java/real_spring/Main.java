package real_spring;

import com.sun.org.apache.xpath.internal.operations.Quo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Conf.class);
    }
}
