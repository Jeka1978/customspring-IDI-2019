package never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Evgeny Borisov
 */
public interface MailGenerator {
//    @Autowired
//    default void registerMyself(MailSender mailSender) {
//        mailSender.map.put(myCode(), this);
//    }
    String generateMail();
    int myCode();
}
