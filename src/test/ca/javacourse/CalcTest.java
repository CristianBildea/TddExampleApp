package ca.javacourse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    Calc calculatorObject;  // Assemble

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        calculatorObject = new Calc(); //Assemble
    }

    @org.junit.jupiter.api.Test
    void addNumbers() {

        //Assemble
        int num1 = 2;
        int num2 = 3;
        int expectedResult = 5;

        //Act
        int result = calculatorObject.addNumbers(num1, num2);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @org.junit.jupiter.api.Test
    void divideNumbers() {

        //Assemble
        double num1 = 10;
        double num2 = 5;
        double expectedResult = 2;

        //Act
        double result = calculatorObject.divideNumbers(num1, num2);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @org.junit.jupiter.api.Test
    void divideByZeroExceptionTest()
    {
        Exception e = assertThrows(ArithmeticException.class, () -> {
            calculatorObject.divideNumbers(10, 0);


        });

        assertEquals("/ by zero", e.getMessage());
    }


    @org.junit.jupiter.api.Test
    void addNumbersPerformance ()
    {

        int expectedResult = 5;
        int actualResult = assertTimeout(Duration.ofMillis(200), () -> {

            TimeUnit.MILLISECONDS.sleep(150);
            return calculatorObject.addNumbers(2, 3);
        });

        Assertions.assertEquals(expectedResult, actualResult);

    }

    }
