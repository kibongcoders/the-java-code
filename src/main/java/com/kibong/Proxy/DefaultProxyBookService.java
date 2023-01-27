package com.kibong.Proxy;


public class DefaultProxyBookService implements ProxyBookService {

    @Override
    public void rent(ProxyBook proxyBook) {
        System.out.println("rent Book -> " + proxyBook.getTitle());
    }

    @Override
    public void returnBook(ProxyBook proxyBook) {
        System.out.println("return Book -> " + proxyBook.getTitle());
    }
}
