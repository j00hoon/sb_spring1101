package academy.learningprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class GameImp implements Game
{
    // constants
    private static final Logger log = LoggerFactory.getLogger(GameImp.class);

    // fields
    @Autowired
    private NumberGenerator numberGeneratorSetter;
    private int guessCount = 10;
    private int number;
    private int guess;
    private int smallest;
    private int largest;
    private int remainingGuesses;
    private boolean validNumberRange = true;


    // constructor
//    public GameImp(NumberGenerator numberGenerator)
//    {
//        this.numberGenerator = numberGenerator;
//    }

    // init
    @PostConstruct
    @Override
    public void reset()
    {
        smallest = 0;
        guess = 0;
        remainingGuesses = guessCount;
        largest = numberGeneratorSetter.getMaxNumber();
        number = numberGeneratorSetter.next();
        log.debug("...............................................GameImp.java reset method ... The number is " + number);
    }

    @PreDestroy
    public void preDestroy()
    {
        log.info(".....................................GameImp.java preDestroy method");
    }



    // public methods
//    public void setNumberGeneratorSetter(NumberGenerator numberGenerator)
//    {
//        this.numberGeneratorSetter = numberGenerator;
//    }


    @Override
    public int getNumber()
    {
        return number;
    }

    @Override
    public int getGuess()
    {
        return guess;
    }

    @Override
    public void setGuess(int guess)
    {
        this.guess = guess;
    }

    @Override
    public int getSmallest()
    {
        return smallest;
    }

    @Override
    public int getLargest()
    {
        return largest;
    }

    @Override
    public int getRemainingGuesses()
    {
        return remainingGuesses;
    }

    @Override
    public void check()
    {
        checkValidNumberRange();

        if(validNumberRange)
        {
            if(guess > number)
            {
                largest = guess - 1;
            }// if
            if(guess < number)
            {
                smallest = guess + 1;
            }// if
        }// if

        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange()
    {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon()
    {
        return guess == number;
    }

    @Override
    public boolean isGameLost()
    {
        return !isGameWon() && remainingGuesses <= 0;
    }



    // private methods
    private void checkValidNumberRange()
    {
        validNumberRange = (guess >= smallest) && (guess <= largest);
    }

}
