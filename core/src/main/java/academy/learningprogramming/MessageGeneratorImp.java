package academy.learningprogramming;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImp implements MessageGenerator
{
    // constants
    //private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImp.class);

    // fields
    private final Game game;

    // constructor
    public MessageGeneratorImp(Game game)
    {
        this.game = game;
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
        return ".......................... from MessageGeneratorImp.java .......... Number is between " + game.getSmallest() + " and " + game.getLargest() + ". Can you guess it? U fucker?";
    }

    @PostConstruct
    @Override
    public String getResultMessage()
    {
        if(game.isGameWon())
        {
            return ".......................... from MessageGeneratorImp.java .......... YOU WON !!! " + game.getNumber();
        }// if
        else if(game.isGameLost())
        {
            return ".......................... from MessageGeneratorImp.java .......... YOU LOST !!! " + game.getNumber();
        }// else if
        else if(!game.isValidNumberRange())
        {
            return ".......................... from MessageGeneratorImp.java .......... INVALID NUMBER RANGE !!! ";
        }// else if
        else if(game.getRemainingGuesses() == game.getGuessCount())
        {
            return ".......................... from MessageGeneratorImp.java .......... What is your fuckin first guess???";
        }// else if
        else
        {
            String direction = "LOWER";
            if(game.getGuess() < game.getNumber())
            {
                direction = "HIGHER";
            }// if

            return ".......................... from MessageGeneratorImp.java .......... " + direction + " YOU HAVE " + game.getRemainingGuesses() + " GUESSES LEFT !!!";
        }// else

    }

}
