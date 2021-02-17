package app.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicCalculator {

    private static final Logger logger = LoggerFactory.getLogger(BasicCalculator.class);

    public Long sum(Long number1, Long number2) {
        logger.info( "Summing {} + {}", number1, number2 );
        return number1 + number2;
    }

    public Long subs(Long number1, Long number2) {
        logger.info( "Subtracting {} - {}", number1, number2);
        return number1 - number2;
    }

    public Long mult(Long number1, Long number2) {
        logger.info( "Multiplying {} - {}", number1, number2);
        return number1 * number2;
    }

    public long div(Long number1, Long number2) {
        try {
            logger.info( "Dividing {} - {}", number1, number2);
            return number1 / number2;
        } catch (ArithmeticException ex) {
            return 0;
        }
    }
}
