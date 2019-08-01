package gz.itcast.contactSys_web.web;

import gz.itcast.contactSys_web.service.ContactService;
import gz.itcast.contactSys_web.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

/**
 * @author huoyueyang
 * @date 2019/8/1 10:30
 * @email mataszhang@163.com
 */
public class ConDelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//1)接收需要删除的id
        String id = req.getParameter("id");
       // System.out.println("id"+"-----------"+id);
        //2)在xml文件中删除联系人
        ContactService service = new ContactServiceImpl();
        service.deleteContact(id);
        //3)跳转到查询联系人页面
        //重定向
        resp.sendRedirect(req.getContextPath()+"/listALLContact");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }

}