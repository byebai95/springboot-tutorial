package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: bai
 * @Date: 2021/12/1 17:35
 */
@AllArgsConstructor
@Data
public class People {

    private Integer id;

    private String name;

    private Integer sex;

    private String address;

    private String country;
}
