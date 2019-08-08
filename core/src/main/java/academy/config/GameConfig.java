package academy.config;

import academy.GuessCount;
import academy.MaxNumber;
import academy.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "academy")
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // ==pola ==
    @Value("${game.maxNumber}")//po : można nadać doyślne wartości
    private int maxNumber;

    @Value("${game.minNumber}")
    private int minNumber;

    @Value("${game.guessCount}")
    private int guessCount;

    // == metody beanowe ==
    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }
}
