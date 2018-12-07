package yhd.java.stream;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author: yang
 * @date: 2018/12/7
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person("zhangsan", 20);
        Person p2 = new Person("lisi", 25);
        Person p3 = new Person("wangwu", 28);
        Person p4 = new Person("siniang", 18);

        List<Person> list = Arrays.asList(p1, p2, p3, p4);
        PersonTest test = new PersonTest();
        // 根据姓名过滤
        List<Person> personResult = test.getPersonByname(list, person -> person.getName().equals("siniang"));
        personResult.forEach(p -> System.out.println(p.getName()));
        System.out.println("----------------");
        // 根据年龄过滤
        test.getPersonByname(list, person -> person.getAge() > 20)
                .forEach(p -> System.out.println(p.getName() + "--"+ p.getAge()));
    }

    /**
     * 根据条件过滤person，需要传入一个Predicate，这是一个函数是接口
     * 他的test()会被执行，我们根据需要自己编写需要过滤的逻辑，
     * 要求他的lambda表达式的返回值是一个boolean类型。
     *
     * @param personList {@link Predicate}
     * @param pre
     * @return
     */
    public List<Person> getPersonByname(List<Person> personList, Predicate<Person> pre){
        return  personList.stream().filter(pre).collect(Collectors.toList());
    }

    public List<Person> getPersonByname2(List<Person> personList, Predicate<Person> pre1, Predicate<Person> pre2){
        return  personList.stream().filter(pre1.and(pre2)).collect(Collectors.toList());
    }
}
