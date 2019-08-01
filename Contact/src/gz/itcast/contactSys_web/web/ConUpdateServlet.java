package gz.itcast.contactSys_web.web;

import gz.itcast.contactSys_web.entity.Contact;
import gz.itcast.contactSys_web.service.ContactService;
import gz.itcast.contactSys_web.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huoyueyang
 * @date 2019/8/1 14:35
 * @email mataszhang@163.com
 */
public class ConUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        Contact contact=new Contact();

        //1)接收表单的数据
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String id = req.getParameter("id");
        //把数据封装到Contact对象
        contact.setName(name);
        contact.setGender(gender);
        contact.setEmail(email);
        contact.setPhone(phone);
        contact.setAddress(address);
        contact.setId(id);
        ContactService contactService=new ContactServiceImpl();
        contactService.updateContact(contact);
        //3)跳转到查询联系人页面
        resp.sendRedirect(req.getContextPath()+"/listALLContact");
        //req.getRequestDispatcher(req.getContextPath()+"/listALLContact").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}