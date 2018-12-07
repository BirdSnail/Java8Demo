package yhd.java.java8;

import java.util.function.Function;

/**
 * @author: yang
 * @date: 2018/12/6
 */
public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        int a = 2;
        // expression 表达式的写法
        System.out.println(test.compute(a, val -> 2 * val));
        // statement 语句块的写法
        System.out.println(test.compute(a, val -> {
            return val * 2;
        }));


    }

    /**
     * 将Function作为一个参数，传递的是一个行为
     * @param a
     * @param function
     * @return
     */
    public int compute(int a, Function<Integer, Integer> function) {
        int result = function.apply(a);

        return result;
    }
}
