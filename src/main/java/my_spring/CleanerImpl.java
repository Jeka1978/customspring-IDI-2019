package my_spring;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */
public class CleanerImpl implements Cleaner {
    @InjectRandomInt(min = 3, max = 6)
    private int repeat;


    public void init() {
        System.out.println("repeat = " + repeat);
    }

    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("VVVVVVVVVVVVvvvvvvvvvvvvvvv");
        }
    }
}
