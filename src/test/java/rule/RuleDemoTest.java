package rule;

import org.junit.Rule;
import org.junit.Test;
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
                    base.evaluate();// 调用测试方法
                    System.out.println(">>>>>>>>");
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
}
