package academy.learningprogramming;

public interface Game
{
    int getNumber();

    int getGuess();

    void setGuess(int guess);

    int getSmallest();

    int getLargest();

    int getRemainingGuesses();

    void reset();

    void check();

    boolean isValidNumber();

    boolean isGameWon();

    boolean isGameLost();
}
