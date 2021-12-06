package app.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author: bai
 * @Date: 2021/12/3 17:37
 */
@Data
public class JobInfo implements Serializable {
    private static final long serialVersionUID = 8875898434339827863L;

    private String jobGroup;

    private String jobName;

    private String cronExpression;

    private Map<String,Object> params;

}
