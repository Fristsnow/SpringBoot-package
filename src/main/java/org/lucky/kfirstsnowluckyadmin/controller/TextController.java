package org.lucky.kfirstsnowluckyadmin.controller;

import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicResponseParameters;
import org.lucky.kfirstsnowluckyadmin.exception.BaseException;
import org.lucky.kfirstsnowluckyadmin.model.Book;
import org.lucky.kfirstsnowluckyadmin.model.User;
import org.lucky.kfirstsnowluckyadmin.service.BookService;
import org.lucky.kfirstsnowluckyadmin.utils.core.page.TableDataInfo;
import org.lucky.kfirstsnowluckyadmin.utils.snow.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TextController extends PageHelper {

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
//    @ApiOperation("查询生产采样单列表")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "total", value = "总记录数"),
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "rows", value = "返回业务数据（数组类型）", dataTypeClass = Book.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    public TableDataInfo getText() {
//        if (!"小王".equals(name)) throw new BaseException(422, "参数异常");
        startPage();
        // 数据列表
        List<User> list = bookService.selectAll();
        return getDataTable(list);
    }
}
