package academy;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess {



    //==pola==

    private final Game game;


    private final MessageGenerator messageGenerator;

    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    //==zdarzenia==
    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("startr() --> Container ready for use");

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Cchesz zagrać ponownie? t/n");

                String playAgainString = scanner.nextLine().trim();
                if(!playAgainString.equalsIgnoreCase("t")){
                    break;
                }
                game.reset();
            }
        }
    }
}
