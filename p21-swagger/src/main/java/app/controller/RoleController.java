package app.controller;

import app.model.bo.RoleBO;
import app.model.vo.RoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "角色管理")
@RestController
public class RoleController {

    @ApiOperation("查询角色信息")
    @GetMapping("/roles")
    public RoleVO getRoles(@RequestParam @ApiParam("角色信息") RoleBO roleBO){
        return new RoleVO();
    }
}
