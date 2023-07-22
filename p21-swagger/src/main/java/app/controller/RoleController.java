package app.controller;

import app.model.bo.RoleBO;
import app.model.vo.RoleVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "role-tag")
@RestController
public class RoleController {


    @Operation(summary = "查询角色信息")
    @GetMapping("/roles")
    public RoleVO getRoles(@RequestParam @Parameter RoleBO roleBO){
        return new RoleVO();
    }
}
