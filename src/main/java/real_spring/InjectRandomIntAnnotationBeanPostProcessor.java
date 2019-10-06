package real_spring;

import my_spring.InjectByTypeAnnotationObjectConfigurator;
import my_spring.InjectRandomIntAnnotationObjectConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        InjectRandomIntAnnotationObjectConfigurator configurator = new InjectRandomIntAnnotationObjectConfigurator();
        configurator.configure(bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
