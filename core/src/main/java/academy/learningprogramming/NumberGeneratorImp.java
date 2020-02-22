package academy.learningprogramming;

import java.util.Random;

public class NumberGeneratorImp implements NumberGenerator
{

    // fields
    private final Random random = new Random();
    private int maxNumber = 1000;

    // public methods
    @Override
    public int next()
    {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber()
    {
        return maxNumber;
    }

}