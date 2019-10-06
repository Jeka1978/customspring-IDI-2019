package never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * @author Evgeny Borisov
 */
@Service
public class MailSender {


    private Map<Integer, MailGenerator> map;

    @Autowired
    public MailSender(List<MailGenerator> mailGenerators) {
        map = mailGenerators.stream().collect(toMap(MailGenerator::myCode, Function.identity()));
    }

    public void sendMail(int mailCode) {

        MailGenerator mailGenerator = map.get(mailCode);

        if (mailGenerator == null) {
            throw new UnsupportedOperationException(mailCode + " not supported yet");
        }

        String html = mailGenerator.generateMail();
        send(html);


    }

    private void send(String html) {
        System.out.println("html = " + html);
    }
}
