package real_spring;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Book
public class TrumpeldorQuoter implements Quoter {
    @Override
    public void sayQuote() {
        System.out.println("Good to die for our country");
    }
}
