package academy.learningprogramming.config;

import academy.learningprogramming.GuessCount;
import academy.learningprogramming.MaxNumber;
import academy.learningprogramming.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
@ComponentScan(basePackages = "academy.learningprogramming")
public class GameConfig
{
    // fields
    @Value("${game.maxNumber:50}")
    private int maxNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    @Value("${game.minNumber:5}")
    private int minNumber;



    // bean methods
    @Bean
    @MaxNumber
    public int maxNumber()
    {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount()
    {
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber()
    {
        return minNumber;
    }

}
