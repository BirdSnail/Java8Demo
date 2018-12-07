package yhd.java.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author: yang
 * @date: 2018/12/6
 */
public class Java8Demo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
       // list.forEach(i -> System.out.println(i));
        list.forEach(new ListConsumer());
        List<String> stringList = Arrays.asList("spark","kafka","hadoop","hbase");
        stringList.stream().map(str -> str.toUpperCase()).forEach(str -> System.out.println(str));

    }
}

class ListConsumer implements Consumer<Integer> {

    @Override
    public void accept(Integer o) {
        System.out.println(o);
    }
}