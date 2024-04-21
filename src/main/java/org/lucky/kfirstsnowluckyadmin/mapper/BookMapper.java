package org.lucky.kfirstsnowluckyadmin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lucky.kfirstsnowluckyadmin.model.Book;
import org.lucky.kfirstsnowluckyadmin.model.User;

import java.util.List;

/**
* @author ZH280
* @description 针对表【book】的数据库操作Mapper
* @createDate 2024-04-21 15:57:18
* @Entity generator.domain.Book
*/
@Mapper
public interface BookMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<User> selectAll();
}
