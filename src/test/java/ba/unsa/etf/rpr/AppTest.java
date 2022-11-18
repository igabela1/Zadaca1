package ba.unsa.etf.rpr;


import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void app() {
        String[] el = new String[] {"(", "5", "+", "11", ")"};
        App.main(el);
    }


    @Test
    public void gresk() {
        String[] el = new String[] {"((", "5", "+", "", ")"};
        App.main(el);
    }

}
