package com.example.shishi.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shishi.mapper.BookMapper;
import com.example.shishi.pojo.Book;
import com.example.shishi.pojo.serivce.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookServiceimpl implements BookService {


    @Resource
    BookMapper mapper;
    @Override
    public List<Book> one() {
        List<Book> bookList = mapper.selectList(null);

        return bookList;
    }

    @Override
    public List<Book> xwfl(String name) {

        QueryWrapper<Book> queryWrapper= new QueryWrapper<>();
        queryWrapper.lambda().eq(Book::getXwflcx, name);

        return mapper.selectList(queryWrapper);
    }
    @Override
    public  List<Book> idcx(Integer id) {
        QueryWrapper<Book> queryWrapper= new QueryWrapper<>();
        queryWrapper.lambda().eq(Book::getId, id);

        return mapper.selectList(queryWrapper);
    }

    @Override
    public List<Book> btcz(String btbh) {

        QueryWrapper<Book> queryWrapper= new QueryWrapper<>();
        queryWrapper.lambda().eq(Book::getBiaoTi, btbh);

        return mapper.selectList(queryWrapper);
    }



    //实现根据数据库里面的biao_ti字段的模糊查询
    @Override
    public List<Book> mhcx(String mohu){
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.like("biao_ti", mohu);
        List<Book> users = mapper.selectList(wrapper);
        return  users;
    }

    @Override
    public Book insert(Book book){
        mapper.insert(book);

        return book;
    }

    @Override
    public List<Book> selectNewsByType(String type) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        if (!Objects.equals(type, "")){
            queryWrapper.lambda().eq(Book::getType,type);
        }
        return mapper.selectList(queryWrapper);
    }

    @Override
    public List<String> selectAllType() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().groupBy(Book::getType);
        List<Book> bookList = mapper.selectList(queryWrapper);
        List<String> typeList = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++) {
            typeList.add(bookList.get(i).getType());
        }

        return typeList;
    }
}
