package real_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeny Borisov`
 */
@Component
public class TalkingRobot {

    @Book
    private List<Quoter> quoters = Arrays.asList(() -> System.out.println("This is default"));

    public void setQuoters(List<Quoter> quoters) {
        this.quoters = quoters;
    }

    @Value("${m2_home}")
    public void setBla(String msg){
        System.out.println("msg = " + msg);
    }


    @PostConstruct
    public void talk(){
        quoters.forEach(Quoter::sayQuote);
    }











}
