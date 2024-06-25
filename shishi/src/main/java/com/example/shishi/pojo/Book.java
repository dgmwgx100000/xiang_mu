package com.example.shishi.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book{
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String xwflcx;

    private String biaoTi;

    private String urlFirst;

    private String urlSecond;

    private String nrxq;

    private Date updateTime;

    private Boolean deleteFlag;

    //新闻类别
    private String type;


}
