package com.example.shishi.controller;

import com.example.shishi.pojo.Book;
import com.example.shishi.pojo.serivce.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@Api(tags = "新闻接口")
@CrossOrigin
@RestController
public class BookController {
    @Resource
    BookService bookService;


    @ApiOperation("根据新闻类型查询数据")
    //http://127.0.0.1:7090/selectNewsByType?type=xxx
    @GetMapping("selectNewsByType")
    public List<Book>selectNewsByType(@RequestParam String type){
        return bookService.selectNewsByType(type);
    }

    @ApiOperation("查询全部")
    //http://127.0.0.1:7090/one
    @GetMapping("one")
    public List<Book> one(){
        return bookService.one();
    }

    @ApiOperation("新闻分类查询")
    //http://127.0.0.1:7090/xwfl?name=tuijian/tiyu/guoji
    @GetMapping("xwfl")
    public List<Book> xwfl(@RequestParam String name){
        return bookService.xwfl(name);
    }

    @ApiOperation("根据ID查询")
   //http://127.0.0.1:7090/idcx?id=1/2/3
    @GetMapping("idcx")
    public List<Book> idcx(@RequestParam Integer id){
        return bookService.idcx(id);
    }

    @ApiOperation("根据新闻标题查询")
    //http://127.0.0.1:7090/btcz?btbh=”曼城“
    @GetMapping("btcz")
    public List<Book> btcz(@RequestParam String btbh) { return bookService.btcz(btbh);}

    @ApiOperation("模糊查询，根据关键字实现查询")
    //http://127.0.0.1:7090/mhcx?mohu=
    @GetMapping("mhcx")
    public List<Book> mhcx(@RequestParam String mohu ){
        return bookService.mhcx(mohu);
    }

    @ApiOperation("追加一条新闻数据")
    //添加数据
    //http://127.0.0.1:7090/insert
    @PostMapping("insert")
    public Book insert(@RequestBody Book book ){
        return bookService.insert(book);
    }

    @ApiOperation("根据type查找新闻")
    @GetMapping("selectAllType")
    public List<String>selectAllType(){

        return bookService.selectAllType();
    }


}
