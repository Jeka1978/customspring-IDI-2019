package never_use_switch;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateMail() {
        // 50 lines of code
        return "Welcome new Client";
    }

    @Override
    public int myCode() {
        return 1;
    }
}
