package com.jerry.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/3/24
 * Time: 18:23
 * Description:
 */
public class FilterApple {

    /**
     * 定义一个筛选苹果的过滤器接口
     */
    public interface AppleFilter {
        boolean filter(Apple apple);
    }

    /**
     * 一个实现了接口的过滤器，过滤出绿色的大于150重量的苹果
     */
    static class GreenAnd150Filter implements AppleFilter {

        @Override
        public boolean filter(Apple apple) {
            return "green".equals(apple.getColor())
                    && apple.getWeight() >= 150;
        }
    }

    /**
     * 过滤苹果的方法
     * @param apples
     * @param appleFilter
     * @return
     */
    static List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if (appleFilter.filter(apple)) {
                list.add(apple);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("green", 100),
                new Apple("yellow", 105),
                new Apple("green", 160),
                new Apple("red", 75));
        // 两种过滤的方式
        List<Apple> list1 = findApple(apples, new GreenAnd150Filter());
        List<Apple> list2 = findApple(apples, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return apple.getColor().equals("red")
                        && apple.getWeight() <= 100;
            }
        });
        System.out.println(list1);
        System.out.println(list2);
    }
}
