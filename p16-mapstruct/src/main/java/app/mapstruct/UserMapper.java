package app.mapstruct;

import app.VO.UserVO;
import app.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface UserMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.name", target = "userName")
    UserVO toVO(User user);
}
