package academy.learningprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameImp implements Game
{
    // constants
    private static final Logger log = LoggerFactory.getLogger(GameImp.class);

    // fields
    private NumberGenerator numberGenerator;
    private int guessCount = 10;
    private int number;
    private int guess;
    private int smallest;
    private int largest;
    private int remainingGuesses;
    private boolean validNumberRange = true;



    // public methods
    @Override
    public void reset()
    {
        smallest = 0;
        guess = 0;
        remainingGuesses = guessCount;
        largest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("The number is " + number);
    }
    
    @Override
    public int getNumber()
    {
        return 0;
    }

    @Override
    public int getGuess()
    {
        return 0;
    }

    @Override
    public void setGuess(int guess)
    {

    }

    @Override
    public int getSmallest()
    {
        return 0;
    }

    @Override
    public int getLargest()
    {
        return 0;
    }

    @Override
    public int getRemainingGuesses()
    {
        return 0;
    }



    @Override
    public void check()
    {

    }

    @Override
    public boolean isValidNumber()
    {
        return false;
    }

    @Override
    public boolean isGameWon()
    {
        return false;
    }

    @Override
    public boolean isGameLost()
    {
        return false;
    }
}
