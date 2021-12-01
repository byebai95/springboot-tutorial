package app.controller;

import app.utils.ExcelData;
import app.utils.ExcelExportUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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
        data.setName("hello");
        List<String> titles = new ArrayList();
        titles.add("a1");
        titles.add("a2");
        titles.add("a3");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList();
        List<Object> row = new ArrayList();
        row.add("11111111111");
        row.add("22222222222");
        row.add("3333333333");
        rows.add(row);

        data.setRows(rows);


        //生成本地
        /*File f = new File("c:/test.xlsx");
        FileOutputStream out = new FileOutputStream(f);
        ExportExcelUtils.exportExcel(data, out);
        out.close();*/
        ExcelExportUtil.exportExcel(response,"hello.xlsx",data);
    }
}
