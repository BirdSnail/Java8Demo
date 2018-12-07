package yhd.java.java8;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * compose方法的返回值是一个Function实例，该实例的apply方法是使用lambda表达式方式标示的
 *
 * @author: yang
 * @date: 2018/12/7
 */
public class FunctionTest2 {

    public static void main(String[] args) {
        FunctionTest2 test2 = new FunctionTest2();

//        System.out.println(test2.compute(2, val -> val * 3, val -> val * val));
//        System.out.println(test2.compute2(2, val -> val * 3, val -> val * val));
        System.out.println(test2.compute3(2,3,(value1,value2) -> value1 + value2));
        System.out.println(test2.compute3(2,3,(value1,value2) -> value1 - value2));
        System.out.println(test2.compute3(2,3,(value1,value2) -> value1 * value2));
        System.out.println(test2.compute3(2,3,(value1,value2) -> value1 / value2));

        System.out.println(test2.compute4(2, 3, (value1, value2) -> value1 + value2, value -> value * value)); //25

    }


    public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        /**
         * compose方法返回的是一个新的Function（可以看成是一个匿名类），该Function的apply方法体是
         *  (V v) -> apply(before.apply(v))
         *  注意：新的apply里面是调用另外两个函数的apply
         *
         *  new Function（）{
         *      apply(V v) {
         *          function1.apply(before.apply(v));
         *      }
         *  }
         *
         *  即 新的Function调用apply方法时 ，就会调用 --》 apply(before.apply(v))
         *  --》 先调用before函数的apply实现方法
         *  --》 再调用执行compose的函数实例的apply
         *
         *  注意：第一次执行compose时并没有执行计算，采用的是惰性求值。
         *  在执行apply后在开始执行apply的实现方法体 --> val*val,val*3
         *
         */
        Function<Integer, Integer> function = function1.compose(function2);
        return function.apply(a);
        // return result;
    }

    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        /**
         * 新函数的apply方法体是 --》  (T t) -> after.apply(apply(t))
         *
         *  new Function(){
         *      apply(V v){
         *          function2.apply(function1.apply(v));
         *      }
         *  }
         */
        int result = function1.andThen(function2).apply(a);

        return result;
    }

    /**
     *  BiFunction函数接口，它的apply方法接受两个参数，返回一个值
     * @param a
     * @param b
     * @param biFunction
     * @return
     */
    public int compute3(int a,int b,BiFunction<Integer, Integer, Integer> biFunction) {
        int result = biFunction.apply(a, b);
        return result;
    }
    /**
     * 先执行调用andThen() 函数实例的apply方法，
     * 再执行作为参数传进来的function的apply方法
     *
     * @param a
     * @param b
     * @param biFun BiFunction函数接口
     * @param fun   Function函数接口
     * @return
     */
    public int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFun, Function<Integer, Integer> fun) {
        /**
         * 因为BiFunction函数接口apply返回值只有一个，所以andThen方法的参数是Function类型就可以
         */
        Integer result = biFun.andThen(fun).apply(a, b);
        return result;
    }
}
