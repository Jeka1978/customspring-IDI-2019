package my_spring;

import javafx.scene.effect.Reflection;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private List<ObjectConfigurator> configurators = new ArrayList<>();



    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        Reflections scanner = new Reflections("my_spring");
        Set<Class<? extends ObjectConfigurator>> set = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> aClass : set) {
            configurators.add(aClass.newInstance());
        }
    }



    @SneakyThrows
    public <T> T createObject(Class<T> type) throws IllegalAccessException, InstantiationException {
        type = resolveImple(type);

        T t = type.newInstance();

        configurators.forEach(configurator -> configurator.configure(t));

        runInitMethod(type, t);



        return t;
    }

    private <T> void runInitMethod(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }

    private <T> Class<T> resolveImple(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImplClass(type);
        }
        return type;
    }


}
