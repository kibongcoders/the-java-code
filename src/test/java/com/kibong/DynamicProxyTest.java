package com.kibong;


import com.kibong.Proxy.DefaultProxyBookService;
import com.kibong.Proxy.ProxyBook;
import com.kibong.Proxy.ProxyBookService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.junit.Test;

public class DynamicProxyTest {

    ProxyBookService proxyBookService = (ProxyBookService) Proxy.newProxyInstance(ProxyBookService.class.getClassLoader(), new Class[]{ProxyBookService.class}, new InvocationHandler() {
        final ProxyBookService proxyBookService = new DefaultProxyBookService();

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if (method.getName().equals("rent")) {
                System.out.println("dynamic proxy start");
                Object invoke = method.invoke(proxyBookService, args);
                System.out.println("dynamic proxy end");
                return invoke;
            }

            return method.invoke(proxyBookService, args);
        }
    });

    @Test
    public void di() {
        ProxyBook proxyBook = new ProxyBook();
        proxyBook.setTitle("kibong");
        proxyBookService.rent(proxyBook);
        proxyBookService.returnBook(proxyBook);
    }
}
