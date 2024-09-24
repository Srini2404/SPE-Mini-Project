import org.example.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAdd() {
        Assertions.assertEquals(5.0, Calculator.add(2.0, 3.0), 0.0001);
        assertEquals(0.0, Calculator.add(0.0, 0.0), 0.0001);
        assertEquals(-1.0, Calculator.add(2.0, -3.0), 0.0001);
    }

    @Test
    void testMultiply() {
        assertEquals(6.0, Calculator.multiply(2.0, 3.0), 0.0001);
        assertEquals(0.0, Calculator.multiply(0.0, 3.0), 0.0001);
        assertEquals(-6.0, Calculator.multiply(2.0, -3.0), 0.0001);
    }

    @Test
    void testFactorial() {
        assertEquals(120, Calculator.factorial(5));
        assertEquals(1, Calculator.factorial(0)); // 0! = 1
        assertEquals(1, Calculator.factorial(1));

        // Test negative input
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.factorial(-1);
        });
        assertEquals("Factorial is not defined for negative numbers.", exception.getMessage());
    }

    @Test
    void testSquareRoot() {
        assertEquals(4.0, Calculator.squareRoot(16.0), 0.0001);
        assertEquals(0.0, Calculator.squareRoot(0.0), 0.0001);

        // Test negative input
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.squareRoot(-16.0);
        });
        assertEquals("Square root of negative number is not defined.", exception.getMessage());
    }

    @Test
    void testNaturalLog() {
        assertEquals(0.0, Calculator.naturalLog(1.0), 0.0001); // ln(1) = 0
        assertEquals(Math.log(10.0), Calculator.naturalLog(10.0), 0.0001);

        // Test zero and negative input
        Exception zeroException = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.naturalLog(0);
        });
        assertEquals("Natural logarithm is only defined for positive numbers.", zeroException.getMessage());

        Exception negativeException = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.naturalLog(-1);
        });
        assertEquals("Natural logarithm is only defined for positive numbers.", negativeException.getMessage());
    }

    @Test
    void testPower() {
        assertEquals(8.0, Calculator.power(2.0, 3.0), 0.0001); // 2^3 = 8
        assertEquals(1.0, Calculator.power(5.0, 0.0), 0.0001); // Any number raised to 0 is 1
        assertEquals(0.25, Calculator.power(2.0, -2.0), 0.0001); // 2^-2 = 1/4
    }
}
