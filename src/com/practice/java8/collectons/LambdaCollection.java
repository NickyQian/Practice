package com.practice.java8.collectons;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.practice.java8.fucntionalInterface.Person;

//中间的操作：
//filter  - 排除所有与断言不匹配的元素。
//map     - 通过Function对元素执行一对一的转换。
//flatMap      - 通过FlatMapper将每个元素转变为无或更多的元素。
//peek  - 对每个遇到的元素执行一些操作。主要对调试很有用。
//distinct  - 根据.equals行为排除所有重复的元素。这是一个有状态的操作。
//sorted   - 确保流中的元素在后续的操作中，按照比较器（Comparator）决定的顺序访问。这是一个有状态的操作。
//limit  - 保证后续的操作所能看到的最大数量的元素。这是一个有状态的短路的操作。
//substream   - 确保后续的操作只能看到一个范围的（根据index）元素。像不能用于流的String.substring一样。也有两种形式，一种有一个开始索引，一种有一个结束索引。二者都是有状态的操作，有一个结束索引的形式也是一个短路的操作。

//末端的操作：
//forEach  - 对流中的每个元素执行一些操作。
//toArray   - 将流中的元素倾倒入一个数组。
//reduce    - 通过一个二进制操作将流中的元素合并到一起。
//collect   - 将流中的元素倾倒入某些容器，例如一个Collection或Map.
//min  - 根据一个比较器找到流中元素的最小值。
//max  -根据一个比较器找到流中元素的最大值。
//count  - 计算流中元素的数量。
//anyMatch  - 判断流中是否至少有一个元素匹配断言。这是一个短路的操作。
//allMatch  - 判断流中是否每一个元素都匹配断言。这是一个短路的操作。
//noneMatch  - 判断流中是否没有一个元素匹配断言。这是一个短路的操作。
//findFirst  - 查找流中的第一个元素。这是一个短路的操作。
//findAny  - 查找流中的任意元素，可能对某些流要比findFirst代价低。这是一个短路的操作。
public class LambdaCollection {
    private static final int ARRAY_SIZE = 1000;
    private char CHAR_A = 'A';
    List<String> names = new ArrayList<>();

    @Before
    public void constructCollection() {
        Random ran = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            int firstCharactor = ran.nextInt(26);
            int secondCharactor = ran.nextInt(26);
            String first = String.valueOf((char) (CHAR_A + firstCharactor));
            String second = String.valueOf((char) (CHAR_A + secondCharactor));
            names.add(first + second);
        }
        // names.forEach((s) -> System.out.println(s));
    }

    @Test
    public void testCollectionFilter() {
        // 需要注意的是，排序只创建了一个排列好后的Stream，
        // 而不会影响原有的数据源，排序之后原数据names是不会被修改的
        names.stream().filter((a) -> a.endsWith("A")).sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);
    }

    @Test
    public void testCollectionMap() {
        // 中间操作map会将元素根据指定的Function接口来依次将元素转成另外的对象，
        // 你也可以通过map来讲对象转换成其他类型，
        // map返回的Stream类型是根据你map传递进去的函数的返回值决定的。
        final List<Person> persons = new ArrayList<Person>();
        names.stream().filter((a) -> a.startsWith("N")).map((a) -> {
            return new Person(1, a);
        }).forEach(persons::add);

        List<Person> persons2 = names.stream().filter((a) -> a.startsWith("N")).map((a) -> {
            return new Person(1, a);
        }).collect(Collectors.toList());

        for (int i = 0; i < persons.size(); i++) {
            Assert.assertEquals(persons.get(i).getName(), persons2.get(i).getName());
        }
        persons.forEach((a) -> System.out.println(a.getName()));
        // Match 匹配
        // Stream提供了多种匹配操作，允许检测指定的Predicate是否匹配t整个Stream。所有的匹配操作都是最终操作，并返回一个boolean类型的值。
        persons.add(new Person(2, "Wrong Person"));
        Assert.assertEquals(true, persons.stream().anyMatch((a) -> a.getName().startsWith("N")));
        Assert.assertEquals(false, persons.stream().allMatch((a) -> a.getName().startsWith("N")));
        Assert.assertEquals(true, persons.stream().noneMatch((a) -> a.getName().startsWith("A")));
    }

    @Test
    public void testReduce() {
        String s = names.stream().reduce("1",(a,b)->a+","+b);
        System.out.println(s);
    }
}
