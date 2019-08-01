package gz.itcast.contactSys_web.dao;


import gz.itcast.contactSys_web.entity.Contact;

import java.util.List;

public interface ContactDao {
    public void addContact(Contact contact);
    public void updateContact( Contact contact);
    public List<Contact> findAll();
    public Contact findById(String id);
    public void deleteContact(String id);
    //检查姓名是否重复
    public boolean checkNameExist(String name);


}
