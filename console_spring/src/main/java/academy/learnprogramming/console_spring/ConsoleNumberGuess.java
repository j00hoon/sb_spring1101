package academy.learnprogramming.console_spring;

import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess
{
    // constants
    //private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // fields
    private final Game game;
    private final MessageGenerator messageGenerator;

    // constructor
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator)
    {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // events
    @EventListener(ContextRefreshedEvent.class)
    public void start()
    {
        log.info("............................. ConsoleNumberGuess.java... Container ready for use. Start method !!! ");

        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("----------------------------------------- START -------------------------------------------------");
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost())
            {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again? y/n ?");

                String playAgain = scanner.nextLine().trim();
                if(!playAgain.equalsIgnoreCase("y"))
                {
                    break;
                }// if

                game.reset();
            }// if
        }// while
    }


}
