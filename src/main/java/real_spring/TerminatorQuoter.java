package real_spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Component("t1")
@Film
public class TerminatorQuoter implements Quoter {

    private List<String> messages;

    @Value("${terminator}")
    public void setMessages(String[] messages) {
        this.messages = Arrays.asList(messages);
    }

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
}





