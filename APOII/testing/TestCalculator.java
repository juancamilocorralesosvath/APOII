import model.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCalculator {

    private Calculator calculator;
    public void setUp1(){
        calculator = new Calculator();
    }
    @Test
    public void testFactorialOfZeroValue(){
        // inicializacion - setup de la prueba
        setUp1();
        // accion _ acto
        int result = calculator.factorial(0);
        // asercion / assert
        assertEquals(1, result);
    }
    /*
    * Positive test
    * */
    @Test
    public void testFactorialOfFiveValue(){
        // inicializacion - setup de la prueba
        setUp1();
        // accion _ acto
        int result = calculator.factorial(5);
        // asercion / assert
        assertEquals(120, result);
    }

    // prueba negativa
    @Test
    public void testFactorialNegativeCase(){
        // inicializacion - setup de la prueba
        setUp1();
        // accion _ acto
        int result = calculator.factorial(4);
        // asercion / assert
        assertNotEquals(120, result);
    }

}
