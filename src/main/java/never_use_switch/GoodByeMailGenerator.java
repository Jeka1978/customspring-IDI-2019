package never_use_switch;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class GoodByeMailGenerator implements MailGenerator {
    @Override
    public String generateMail() {
        return "goodbye";
    }

    @Override
    public int myCode() {
        return 3;
    }
}
