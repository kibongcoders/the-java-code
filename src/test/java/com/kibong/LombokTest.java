package com.kibong;

import com.kibong.Lombok.Books;
import com.kibong.Lombok.ReadBook;
import org.junit.Test;

public class LombokTest {

    @Test
    public void lombokTest(){
        Books books = new ReadBook();
        System.out.println(books.read("Hello"));
    }
}
