package yhd.java.java8;

/**
 * @author: yang
 * @date: 2018/12/6
 */

@FunctionalInterface
public interface MyInterface {
    void test();

    //  覆写Object类里面的方法，不计入该接口的抽象方法个数
    String toString();

    // default关键字可以使该方法有实现体，且不计入该接口抽象方法个数
    default void test1(){
        System.out.println("----");
    }
}
