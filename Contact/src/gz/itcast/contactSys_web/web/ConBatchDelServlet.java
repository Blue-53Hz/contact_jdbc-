package gz.itcast.contactSys_web.web;

import gz.itcast.contactSys_web.service.ContactService;
import gz.itcast.contactSys_web.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huoyueyang
 * @date 2019/8/1 14:39
 * @email mataszhang@163.com
 */
public class ConBatchDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1)得到需要删除的联系人
        String[] ids = req.getParameterValues("item");

        ContactService service = new ContactServiceImpl();
        //2)批量删除
        for(String id:ids){
            service.deleteContact(id);
        }

        //3)跳转列表页面
        resp.sendRedirect(req.getContextPath()+"/listALLContact");




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}