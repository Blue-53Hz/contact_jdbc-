package gz.itcast.contactSys_web.dao;

import gz.itcast.contactSys_web.dao.impl.ContactDaoImpl;
import gz.itcast.contactSys_web.entity.Contact;
import gz.itcast.contactSys_web.util.JdbcUtil;
import gz.itcast.contactSys_web.util.XMLUtil;
import org.dom4j.Document;
import org.dom4j.Element;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author huoyueyang
 * @date 2019/8/1 11:14
 * @email mataszhang@163.com
 */
public class test {


    public static void main(String[] args) {
//        ContactDao dao=new ContactDaoImpl();
//       Contact contact= dao.findById("47b047b3-c54b-4773-a5bd-f23ff07e89c1");
//       System.out.println(contact);
        //1)读取原来的xml
        //Document doc= XMLUtil.getDocument();
        //2)删除contact标签
        //2.1 根据id查询对应的contact标签
//        String id="47b047b3-c54b-4773-a5bd-f23ff07e89c1";
//        Element conElem= (Element) doc.selectSingleNode("//concat[@id='"+id+"']");
//
//        System.out.println(conElem.attributeValue("id"));

        Properties prop = new Properties();
        //使用类路径方式读取配置文件
        InputStream in = JdbcUtil.class.getResourceAsStream("/jdbc.properties");
        //加载文件
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读取配置文件的内容
      String   url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String  password = prop.getProperty("password");
        String  driverClass = prop.getProperty("driverClass");
        System.out.println( url);


    }
}