package com.work.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import org.springframework.boot.rsocket.context.LocalRSocketServerPort;

@Data
public class Book {

    private int id;
    private String name;
    private double price;
    private String book_adress;
    private String author;
    //逻辑删除字段，标记当前记录是否删除
//    @TableLogic(value = "0",delval = "1")可以进行全局配置
    //@TableField(value = "delete",select = true,exist = true)
    private Integer deleteds;

//    乐观锁
    @Version
    private Integer versions;
}
