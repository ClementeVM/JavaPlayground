package CalculatorJava;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private CalculatorLogic calculatorLogic;

    @BeforeEach
    void setUp(){
        calculatorLogic = new CalculatorLogic();
    }

    @Test
    void addFive(){
        calculatorLogic.add(5.0);
        assertEquals(5.0, calculatorLogic.getTotal());
    }

    @Test
    void twoPlusThreeEqualFive(){
        calculatorLogic.add(2.0);
        calculatorLogic.add(3.0);
        assertEquals(5.0, calculatorLogic.getTotal());
    }

    @Test
    void sevenRestFiveEqualTwo(){
        calculatorLogic.add(7.0);
        calculatorLogic.subtract(5.0);
        assertEquals(2.0, calculatorLogic.getTotal());
    }

    @Test
    void sevenTimesFiveEqualThirtyFive(){
        calculatorLogic.add(7.0);
        calculatorLogic.multiply(5.0);
        assertEquals(35.0, calculatorLogic.getTotal());
    }

    @Test
    void twelveDivideThreeEqualFour(){
        calculatorLogic.add(12.0);
        calculatorLogic.divide(3.0);
        assertEquals(4.0, calculatorLogic.getTotal());
    }

    @Test
    void acClickEqualZero(){
        calculatorLogic.add(55.0);
        calculatorLogic.reset();
        assertEquals(0.0, calculatorLogic.getTotal());

    }

}