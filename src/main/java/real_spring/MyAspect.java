package real_spring;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
//@Component
//@Aspect
public class MyAspect {


    @AfterThrowing(value = "execution(* real_spring..*.say*(..))",throwing = "ex")
    public void handleSayMethods(SybaseExcetption ex){
        System.out.println("This is quote:");
        //send mail to Andrey
    }
}
