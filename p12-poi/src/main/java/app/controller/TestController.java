package app.controller;

import app.model.People;
import app.utils.ExcelData;
import app.utils.ExcelExportUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: bai
 * @Date: 2021/12/1 17:06
 */

@Controller
public class TestController {

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/excel")
    public void excel(HttpServletResponse response) throws Exception{
        ExcelData data = new ExcelData();
        data.setName("人口信息");
        data.setTitles(Arrays.asList(
                "id","姓名","性别","地址","国籍"
        ));
        data.setRows(peopleList());

        ExcelExportUtil.exportExcel(response,"excel.xlsx",data);
    }

    public List<List<Object>> peopleList(){
         List<List<Object>> list = new ArrayList<>();
         List<People> peopleList = Arrays.asList(
                new People(1,"zhangsna",1,"北京","中国"),
                new People(2,"lisi",2,"上海","中国"),
                new People(3,"wangwu",1,"山西","中国"),
                new People(4,"zhaoliu",2,"北京","中国"),
                new People(5,"liqi",1,"广东","中国")
        );
         for(People people : peopleList){
             List<Object> objects = new ArrayList<>();
             objects.add(people.getId());
             objects.add(people.getName());
             objects.add(people.getSex());
             objects.add(people.getAddress());
             objects.add(people.getCountry());
             list.add(objects);
         }
         return list;
    }
}
