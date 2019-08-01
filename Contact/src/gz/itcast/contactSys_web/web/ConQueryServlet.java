package gz.itcast.contactSys_web.web;

import gz.itcast.contactSys_web.entity.Contact;
import gz.itcast.contactSys_web.service.ContactService;
import gz.itcast.contactSys_web.service.impl.ContactServiceImpl;
import jdk.internal.org.objectweb.asm.Handle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huoyueyang
 * @date 2019/8/1 10:25
 * @email mataszhang@163.com
 */
public class ConQueryServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1)接收需要修改的id
        String id = req.getParameter("id");
        //2)查询对应的联系人
        System.out.println("id"+id);
        ContactService service = new ContactServiceImpl();
        Contact contact = service.findById(id);
       System.out.println(contact);
        //3)把数据转发到jsp页面
        req.setAttribute("contact", contact);
        req.getRequestDispatcher("/JSP/editCon.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}