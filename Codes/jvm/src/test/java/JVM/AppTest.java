package JVM;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Optional;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    @Test
    void testOptional(){
        int[] nums = new int[10];
        Arrays.fill(nums, 10);
        Optional<Integer> sum = Arrays.stream(nums).boxed().reduce((x,y) -> x + y);
        System.out.println(sum.get());
    }
}
