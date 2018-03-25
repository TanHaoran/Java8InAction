package com.jerry.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/3/25
 * Time: 18:41
 * Description:
 */
public class LambdaExpression {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("green", 100),
                new Apple("yellow", 105),
                new Apple("green", 160),
                new Apple("red", 75));

        Comparator<Apple> comparator = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        Comparator<Apple> comparator2 = (o1, o2) -> (o1.getColor().compareTo(o2.getColor()));

        apples.sort(comparator);
        apples.sort(comparator2);

        // 几个合法的Lambda表达式定义
        // () -> {}
        // () -> "hello"
        // () -> { return "Hello"; }
        // (String s) -> { return "Hello Alex"; }

        // 前面的String是入参，后面的Integer是出参
        Function<String, Integer> funLambda = s -> s.length();
        // 这个是用到了入参
        Predicate<Apple> predicate = apple -> apple.getColor().equals("green");
        // new的实现
        Supplier<Apple> supplier = () -> new Apple("red", 100);
    }
}
