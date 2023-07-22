package app.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "角色响应对象")
public class RoleVO {

    @Schema(title = "记录数量")
    private Long count;

    @Schema(title = "记录")
    private String data;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
