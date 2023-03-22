package com.work.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.work.entity.Book;
import com.work.mapper.BookMapper;
import com.work.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
}
