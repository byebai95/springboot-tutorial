package app.mapper;

import app.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT id, name, address FROM t_users WHERE id = #{id}")
    User selectById(Long id);
}

