package academy;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Getter
@Component
public class NumberGeneratorImpl implements NumberGenerator {

    @Getter(AccessLevel.NONE)
    private final Random random = new Random();


    private final int maxNumber;


    private final int minNumber;

    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }


    public int next() {
        return random.nextInt((maxNumber - minNumber)) + minNumber;
    }

}
