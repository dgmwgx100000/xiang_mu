package com.example.shishi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shishi.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
