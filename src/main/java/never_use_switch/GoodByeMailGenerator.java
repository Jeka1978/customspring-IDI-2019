package never_use_switch;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component("3")
public class GoodByeMailGenerator implements MailGenerator {
    @Override
    public String generateMail() {
        return "goodbye";
    }
}
