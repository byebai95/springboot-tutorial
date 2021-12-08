package app.util;

import app.model.People;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;


/**
 * @Author: bai
 * @Date: 2021/12/7 17:17
 */
@Slf4j
public class XmlUtils {

    public static void createXml(List<People> dataList,String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = factory.newDocumentBuilder();
            Document document = db.newDocument();

            document.setXmlStandalone(false);
            document.setDocumentURI("www.baidu.com");

            //生成根节点
            Element group = document.createElement("group");


            for (People item : dataList) {
                Element people = document.createElement("people");
                Element id = document.createElement("id");
                Element name = document.createElement("name");
                Element sex = document.createElement("sex");
                Element address = document.createElement("address");
                Element country = document.createElement("country");

                id.setTextContent(String.valueOf(item.getId()));
                people.appendChild(id);

                name.setTextContent(item.getName());
                people.appendChild(name);

                sex.setTextContent(String.valueOf(item.getSex()));
                people.appendChild(sex);

                address.setTextContent(item.getAddress());
                people.appendChild(address);

                country.setTextContent(item.getCountry());
                people.appendChild(country);

                group.appendChild(people);
            }

            document.appendChild(group);
            // 创建TransformerFactory对象
            TransformerFactory tff = TransformerFactory.newInstance();
            // 创建 Transformer对象
            Transformer tf = tff.newTransformer();

            // 输出内容是否使用换行
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            // 创建xml文件并写入内容
            tf.transform(new DOMSource(document), new StreamResult(new File(fileName)));
            log.info("生成 xml 成功");
        }catch (Exception e){
            log.info("生成 xml 失败");
        }

    }
}
