package academy.learningprogramming.console_spring;

import academy.learningprogramming.AppConfig;
import academy.learningprogramming.MessageGenerator;
import academy.learningprogramming.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args)
    {
        log.info("...............................................Fuck...............................................");

        // create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // get number generator bean from context (container)
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);


        // call method next() to get a random number
        int number = numberGenerator.next();

        // log generated number
        log.info("............................................... from Main.java - ........... Number : " + number);

        // get game bean from context (container)
        //Game game = context.getBean(Game.class);

        // get Message Generator bean from context (container)
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        log.info("........................................... from Main.java - messageGenerator.java ............. Main Message " + messageGenerator.getMainMessage());
        log.info("........................................... from Main.java - messageGenerator.java ............. Result Message " + messageGenerator.getResultMessage());

        // call reset method
//        game.reset();

        // close context (container)
        context.close();


    }
}
