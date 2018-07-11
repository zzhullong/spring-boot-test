package com.yzl.spring.utils;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.ResolvableType;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GenericTest {

    private List<String> forField;

    @Test
    public void testForField() {
        Field field = ReflectionUtils.findField(GenericTest.class, "forField");
        ResolvableType resolvableType = ResolvableType.forField(field);
        Assert.assertEquals(String.class, resolvableType.getGeneric(0).getRawClass());
    }

    @Test
    public void test1() {
        Class<?>[] genericClasses = GenericTypeResolver.resolveTypeArguments(MyMap1.class, HashMap.class);
        System.out.println(Arrays.asList(genericClasses));
    }

    @Test
    public void test2() {
        Class<?>[] genericClasses = GenericTypeResolver.resolveTypeArguments(MyMap2.class, HashMap.class);
        System.out.println(Arrays.asList(genericClasses));
    }

    public static class MyMap1 extends HashMap<String, Integer> {

    }

    public static class MyMap2<V extends List> extends HashMap<String, V> {

    }
}
