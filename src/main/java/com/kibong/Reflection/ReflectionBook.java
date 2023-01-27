package com.kibong.Reflection;

import lombok.Data;

@MyAnnotation(name = "bong", age = 29)
@Data
public class ReflectionBook {

    public static String A = "A";

    private String B = "BOOK";

    private static final String C = "BOOK";

    @MyAnnotation
    public String d = "d";

    @MyAnnotation(name = "e", age = 100)
    protected String e = "e";

    public ReflectionBook() {
    }

    public ReflectionBook(String b){
        this.B = b;
    }

    public ReflectionBook(String a, String d, String e) {
        A = a;
        this.d = d;
        this.e = e;
    }


    private void f() {
        System.out.println("F");
    }
    @MyAnnotation
    public void g() {
        System.out.println("G");
    }

    public int h() {
        return 100;
    }

    public int sum(int one, int two){
        return one + two;
    }
}
