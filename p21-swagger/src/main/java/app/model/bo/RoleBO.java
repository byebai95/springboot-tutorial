package app.model.bo;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "角色业务实体")
public class RoleBO {

    @Schema(title = "角色ID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
