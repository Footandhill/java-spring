package com.wms.untils;

import lombok.Data;

import java.util.HashMap;

@Data
public class SeparatePageParam {

    private static int PAGE_SIZE=10;
    private static int PAGE_NUM=1;

    private int pageSize=PAGE_SIZE;
    private int pageNum=PAGE_NUM;

    private HashMap param;

}
