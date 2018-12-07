package yhd.java.java8;

import java.util.*;

/**
 * 使用lambda表达式进行字符串比较
 *
 * @author: yang
 * @date: 2018/12/6
 */
public class StringComparator {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");
        Collections.sort(list,(str1, str2) -> str1.compareTo(str2));
        // Collections.sort(list, Comparator.naturalOrder());
        System.out.println(list);
    }
}
