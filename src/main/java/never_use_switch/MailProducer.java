package never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Service
public class MailProducer {
    @Autowired
    private MailSender sender;

    @Scheduled(fixedDelay = 500)
    public void doWork(){
        Random random = new Random();
        int mailCode = random.nextInt(3)+1;
        sender.sendMail(mailCode);
    }
}



