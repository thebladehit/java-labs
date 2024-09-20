import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void getPerfectNumber() {
        ArrayList<Integer> result = Main.getPerfectNumber(1000);

        assertEquals(3, result.size(), "List size should be 3");
        assertIterableEquals(List.of(6, 28, 496), result, "List should match the expected values");
    }

    @Test
    void getPerfectNumberEmpty() {
        ArrayList<Integer> result = Main.getPerfectNumber(1);

        assertEquals(0, result.size(), "List size should be 0");
    }
}