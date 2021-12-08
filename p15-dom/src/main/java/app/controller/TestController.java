package app.controller;

import app.model.People;
import app.util.XmlUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletResponse;
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

    @GetMapping("/xml")
    public void excel(HttpServletResponse response) throws Exception{
        List<People> data = peopleList();
        XmlUtils.createXml(data,"用户信息.xml");
    }


    public List<People> peopleList(){
         return Arrays.asList(
                new People(1,"zhangsna",1,"北京","中国"),
                new People(2,"lisi",2,"上海","中国"),
                new People(3,"wangwu",1,"山西","中国"),
                new People(4,"zhaoliu",2,"北京","中国"),
                new People(5,"liqi",1,"广东","中国")
        );

    }
}
