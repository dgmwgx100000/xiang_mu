package com.example.shishi.pojo.serivce;

import com.example.shishi.pojo.Book;

import java.util.List;

public interface BookService {


    List<Book> one();

    List<Book> xwfl(String name);

    List<Book> idcx(Integer id);

    List<Book> btcz(String btbh);

    List<Book> mhcx(String mohu);



    Book insert(Book book);

    List<Book> selectNewsByType(String type);

    List<String> selectAllType();

//    List<String> selectAllType();
}

