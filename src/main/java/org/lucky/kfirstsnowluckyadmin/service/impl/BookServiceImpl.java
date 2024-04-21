package org.lucky.kfirstsnowluckyadmin.service.impl;

import org.lucky.kfirstsnowluckyadmin.mapper.BookMapper;
import org.lucky.kfirstsnowluckyadmin.model.User;
import org.lucky.kfirstsnowluckyadmin.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<User> selectAll() {
        return bookMapper.selectAll();
    }
}
