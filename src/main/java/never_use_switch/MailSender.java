package never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */
@Service
public class MailSender {

    @Autowired
    private Map<String, MailGenerator> map;

    public void sendMail(int mailCode) {
        String code = String.valueOf(mailCode);
        MailGenerator mailGenerator = map.get(code);

        if (mailGenerator == null) {
            throw new UnsupportedOperationException(code + " not supported yet");
        }

        String html = mailGenerator.generateMail();
        send(html);


    }

    private void send(String html) {
        System.out.println("html = " + html);
    }
}
