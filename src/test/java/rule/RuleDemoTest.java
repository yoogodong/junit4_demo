package rule;

import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RuleDemoTest {


    @Rule
    public TestRule around = new TestRule() {
        @Override
        public Statement apply(Statement base, Description description) {
            return new Statement() {
                /*如同一个 Around Adviser, 可以决定测试要不要执行*/
                @Override
                public void evaluate() throws Throwable {
                    System.out.println("<<<<<<<");
                    base.evaluate();// 调用@Before + 测试方法 + @After
                    System.out.println(">>>>>>>>");
                }
            };
        }
    };

    @ClassRule
    public static TestRule aroundClass = new TestRule() {
        @Override
        public Statement apply(Statement base, Description description) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    System.out.println("before class rule ");
                    base.evaluate();
                    ;
                    System.out.println("after class rule");
                }
            };
        }
    };

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @BeforeClass
    public static void setUp3() throws Exception {
        System.out.println("beforeClass1");
    }

    @BeforeClass
    public static void setUp4() throws Exception {
        System.out.println("beforeClass2");
    }

    @AfterClass
    public static void setUp5() throws Exception {
        System.out.println("afterClass1");
    }

    @AfterClass
    public static void setUp6() throws Exception {
        System.out.println("afterClass2");
    }

    @Before
    public void setUp1() throws Exception {
        System.out.println("before1");
    }

    @Before
    public void setUp2() throws Exception {
        System.out.println("before2");
    }

    @After
    public void tearDown1() throws Exception {
        System.out.println("after1");
    }

    @After
    public void tearDown2() throws Exception {
        System.out.println("after2");
    }
}
