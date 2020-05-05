package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImp implements MessageGenerator
{
    // constants
    //private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImp.class);
    private static final String MAIN_MESSAGE = "game.main.message";
    private static final String WIN = "game.win";
    private static final String LOSE = "game.lose";
    private static final String INVALID_RANGE = "game.invalid.range";
    private static final String FIRST_GUESS = "game.first.guess";
    private static final String HIGHER = "game.higher";
    private static final String LOWER = "game.lower";
    private static final String REMAINING = "game.remaining";

    // fields
    private final Game game;
    private final MessageSource messageSource;

    // constructor
    public MessageGeneratorImp(Game game, MessageSource messageSource)
    {
        this.game = game;
        this.messageSource = messageSource;
    }

    // init
    public void init()
    {
        log.info("............................... from MessageGeneratorImp.java : ", game);
    }


    // public methods
    @PostConstruct
    @Override
    public String getMainMessage()
    {
        //return ".......................... from MessageGeneratorImp.java .......... Number is between " + game.getSmallest() + " and " + game.getLargest() + ". Can you guess it? U fucker?";
        return getMessage(MAIN_MESSAGE, game.getSmallest(), game.getLargest());
    }

    @PostConstruct
    @Override
    public String getResultMessage()
    {
        if(game.isGameWon())
        {
            //return ".......................... from MessageGeneratorImp.java .......... YOU WON !!! " + game.getNumber();
            return getMessage(WIN, game.getNumber());
        }// if
        else if(game.isGameLost())
        {
            //return ".......................... from MessageGeneratorImp.java .......... YOU LOST !!! " + game.getNumber();
            return getMessage(LOSE, game.getNumber());
        }// else if
        else if(!game.isValidNumberRange())
        {
            //return ".......................... from MessageGeneratorImp.java .......... INVALID NUMBER RANGE !!! ";
            return getMessage(INVALID_RANGE);
        }// else if
        else if(game.getRemainingGuesses() == game.getGuessCount())
        {
            //return ".......................... from MessageGeneratorImp.java .......... What is your fuckin first guess???";
            return getMessage(FIRST_GUESS);
        }// else if
        else
        {
            //String direction = "LOWER";
            String direction = getMessage(LOWER);
            if(game.getGuess() < game.getNumber())
            {
                //direction = "HIGHER";
                direction = getMessage(HIGHER);
            }// if

            //return ".......................... from MessageGeneratorImp.java .......... " + direction + " YOU HAVE " + game.getRemainingGuesses() + " GUESSES LEFT !!!";
            return getMessage(REMAINING, direction, game.getRemainingGuesses());
        }// else

    }

    // private methods
    private String getMessage(String code, Object... args)
    {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

}
