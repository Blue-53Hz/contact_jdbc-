package gz.itcast.contactSys_web.web;

import com.sun.net.httpserver.HttpServer;
import gz.itcast.contactSys_web.dao.impl.ContactDaoImpl;
import gz.itcast.contactSys_web.entity.Contact;
import gz.itcast.contactSys_web.service.ContactService;
import gz.itcast.contactSys_web.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author huoyueyang
 * @date 2019/7/31 20:01
 * @email mataszhang@163.com
 */
public class ContactListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1)读取所有联系人数据
        ContactService service = new ContactServiceImpl();
        List<Contact> conList = service.findAll();
        //2)把数据放入域对象中
        req.setAttribute("conList", conList);
        System.out.println(conList.size());
      req.getRequestDispatcher("/JSP/listALL.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}