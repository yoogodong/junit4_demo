package parameterized;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParamDemoTest {

    private int expected;
    private int in;

    public ParamDemoTest(int expected, int in) {
        this.expected = expected;
        this.in = in;
    }

    @Parameterized.Parameters
    public static List<Integer[]> parameters() {
        return Arrays.asList(new Integer[][]{{10, 1}, {100, 10}, {1000, 100}});
    }

    @Test
    public void name() {
        assertEquals(expected, 10 * in);
    }
}
