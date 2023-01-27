package com.kibong;

import static org.junit.Assert.assertNotNull;

import com.kibong.Reflection.ContainerService;
import org.junit.Test;

public class ContainerServiceTest {

    @Test
    public void getObject(){
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        assertNotNull(bookRepository);
    }

    @Test
    public void getObjectInject(){
        BookService bookService = ContainerService.getObject(BookService.class);
        assertNotNull(bookService);
        assertNotNull(bookService.bookRepository);
    }
}