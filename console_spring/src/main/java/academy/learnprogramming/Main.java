package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Main
{
    //private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args)
    {
        log.info("............................................... Main method in console_spring ...............................................");

        // For changing from Spring MVC to Spring boot, we need to add the above.
        SpringApplication.run(Main.class, args);







        // create context (container)
        // For changing from Spring MVC to Spring boot, we need to delete the above.
        // ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

        // get number generator bean from context (container)
        //NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);


        // call method next() to get a random number
        //int number = numberGenerator.next();

        // log generated number
        //log.info("............................................... from Main.java - ........... Number : " + number);

        // get game bean from context (container)
        //Game game = context.getBean(Game.class);

        // get Message Generator bean from context (container)
        //MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        //log.info("........................................... from Main.java - messageGenerator.java ............. Main Message " + messageGenerator.getMainMessage());
        //log.info("........................................... from Main.java - messageGenerator.java ............. Result Message " + messageGenerator.getResultMessage());

        // call reset method
        // game.reset();




        // close context (container)
        // For changing from Spring MVC to Spring boot, we need to delete the above.
        // context.close();


    }
}
