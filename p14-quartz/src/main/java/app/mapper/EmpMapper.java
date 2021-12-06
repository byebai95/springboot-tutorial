package app.mapper;

import app.model.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: bai
 * @Date: 2021/12/6 10:58
 */
@Mapper
public interface EmpMapper {

    List<Emp> list();
}
