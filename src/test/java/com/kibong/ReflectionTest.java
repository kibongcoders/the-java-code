package com.kibong;

import com.kibong.Reflection.MyBook;
import com.kibong.Reflection.ReflectionBook;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.junit.Test;

public class ReflectionTest {

    @Test
    public void reflectionBookTest() {

        Class<ReflectionBook> bookClass = ReflectionBook.class; //클래스 인스턴스 가져오기

        //인스턴스가 있을 경우 getClass 으로도 클래스 인스턴스를 가져올 수 있다.
        ReflectionBook book = new ReflectionBook();

        //FQCN(Fully Qualified Class Name) 으로 가져오기

        //필드 정보 가져오기
        //getFields public 한것만 가져옴
        System.out.println("getFields() Start");
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);
        System.out.println(" ");

        //getDeclaredFields 선언된 모든것 가져옴
        System.out.println("getDeclaredFields() Start");
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);
        System.out.println(" ");

        //값 가져오기
        System.out.println("getDeclaredFields() value Start");
        Arrays.stream(bookClass.getDeclaredFields()).forEach(field -> {
            try {
                field.setAccessible(true); //private도 가져올 수 있도록 함
                System.out.printf("%s %s \n", field, field.get(book));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(" ");

        //메소드 가져오기
        System.out.println("getMethods() Start");
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println); //Object에서 상속 받은 것도 가져옴
        System.out.println(" ");

        //선언된 메소드만 가져오기
        System.out.println("getMethods() Start");
        Arrays.stream(bookClass.getDeclaredMethods()).forEach(System.out::println);
        System.out.println(" ");

        //생성자 가져오기
        System.out.println("getConstructors() Start");
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);
        System.out.println(" ");

        //부모 클래스 가져오기
        System.out.println("getSuperclass() Start");
        Class<? super MyBook> superclass = MyBook.class.getSuperclass();
        System.out.println(superclass);
        System.out.println(" ");

        //인터페이스 정보 가져오기
        System.out.println("getInterfaces() Start");
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);
        System.out.println(" ");

        //modifiers 정보 가져오기
        System.out.println("modifiers() Start");
        Arrays.stream(bookClass.getDeclaredFields()).forEach(field -> {
            int modifiers = field.getModifiers();
            System.out.println(field);
            System.out.println(modifiers);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
        });
        System.out.println(" ");


    }
}
