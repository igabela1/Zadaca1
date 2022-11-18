package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionEvaluatorTest{

    @Test
   void evaluate_additionn1() {
        assertEquals(ExpressionEvaluator.evaluate("( 2 + 3 )"), 5D);
    }

    @Test
    void evaluate_multiplicationn1(){
        assertEquals(100.0, ExpressionEvaluator.evaluate("( ( 2 * 0 ) + ( ( 2 * 100 ) / 2 ) )"));
    }

    @Test
    void evaluate_subtractionn1() {
        assertEquals(54D, ExpressionEvaluator.evaluate("( ( ( 5 + 8 ) * 5 ) - 11 )"));
    }


    @Test
    void evaluate_sqrtt1() {
        assertEquals(5D, ExpressionEvaluator.evaluate("( sqrt ( ( ( 2 + 3 ) * 3 ) + 10 ) )"));
    }


    @Test
    void evaluate_nonexistent_operator() {
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("( 5 ^ 2)"));
    }


    @Test
    void evaluate_unnecessary_space() {
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("(  2 + 3 )"));
    }



    @Test
    void evaluate_advantage_parenthesess() {
        assertEquals(10D, ExpressionEvaluator.evaluate("( ( 2 + 3 ) * ( 4 - 2 ) )"));
    }

    @Test
    void evaluate_missing_brackets() {
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.evaluate("11 + 3 )"));
    }
}

    /*@Test
    void evaluate_division_by_zero(){

        try{
            ExpressionEvaluator.evaluate("( 2 + ( 2 / 0 ) )");
        }
        catch(RuntimeException err)
        {
            assertEquals("Cannot divide by zero", err.getMessage());
        }
        }
    }
*/




