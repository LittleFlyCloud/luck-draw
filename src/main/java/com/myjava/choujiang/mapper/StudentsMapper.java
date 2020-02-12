package com.myjava.choujiang.mapper;

import com.myjava.choujiang.Bean.Sheet1;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentsMapper {
    @Select("SELECT * FROM useStudentsToDoLuckDraw ORDER BY RAND() limit 1")
    public Sheet1 getStudent();

    @Insert("INSERT INTO useStudentsToDoLuckDraw(sid, sname) VALUES(#{sid}, #{sname})")
    int insert(@Param("sid") String sid, @Param("sname") String sname);
}
