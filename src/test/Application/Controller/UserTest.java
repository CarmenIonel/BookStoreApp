package Application.Controller;

import Application.Model.User;
import Application.Model.Users;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ionel Carmen on 4/19/2017.
 */
public class UserTest
{
    File f=new File("E:\\SemII\\PS\\Assignemnt2\\src\\main\\resources\\users.xml");

    @Autowired
    private Users users;

    private UnMarshal um=new UnMarshal();
    private List<User> u;

    @Test
    public void read(){
        String authr="admin";
        try
        {
            users = um.getUsers();
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        JAXBContext jb = null;
        try
        {
            jb = JAXBContext.newInstance(Users.class);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        Marshaller marshaller = null;
        try
        {
            marshaller = jb.createMarshaller();
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        try
        {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (PropertyException e)
        {
            e.printStackTrace();
        }
        u=users.getUsers();
        User u1=null;
        for(int i=0;i<u.size();i++)
        {
            if (u.get(i).getUsername().equalsIgnoreCase(authr))
                u1=u.get(i);
        }
        assert(u1.getUsername().equalsIgnoreCase(authr));

    }

    @Test
    public void create(){
        User u1=new User("Popa George","Primaverii","0744260322","popa@yahoo.com","popa.george","12345678");
        try
        {
            users = um.getUsers();
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        JAXBContext jb = null;
        try
        {
            jb = JAXBContext.newInstance(Users.class);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        Marshaller marshaller = null;
        try
        {
            marshaller = jb.createMarshaller();
        } catch (JAXBException e)
        {
            e.printStackTrace();
        }
        try
        {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        }
        catch (PropertyException e)
        {
            e.printStackTrace();
        }
        u=users.getUsers();
        u.add(u1);
        User u2=null;
        users.setUsers(u);
        try
        {
            marshaller.marshal(users, f);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        try {
            users=um.getUsers();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        u=users.getUsers();

        for(int i=0;i<u.size();i++)
        {
            if(u.get(i).getUsername().equals("popa.george"))
            {
                u2=u.get(i);
            }
        }

        assert (u1.getUsername().equalsIgnoreCase(u2.getUsername()) && u1.getEmail().equalsIgnoreCase(u2.getEmail()));

    }
    @Test
    public void delete(){
        User u1=new User("Popa George","Primaverii","0744260322","popa@yahoo.com","popa.george","12345678");
        try
        {
            users = um.getUsers();
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        JAXBContext jb = null;
        try
        {
            jb = JAXBContext.newInstance(Users.class);
        } catch (JAXBException e)
        {
            e.printStackTrace();
        }
        Marshaller marshaller = null;
        try
        {
            marshaller = jb.createMarshaller();
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        try
        {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (PropertyException e)
        {
            e.printStackTrace();
        }
        u=users.getUsers();
        for(int i=0;i<u.size();i++)
            if (u.get(i).getUsername().equalsIgnoreCase(u1.getUsername())){User aux=u.get(i);
            u.remove(aux);
        }
        users.setUsers(u);
        try {
            marshaller.marshal(users, f);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        u=users.getUsers();
        User aux2=null;
        for(int i=0;i<u.size();i++)
        {
            if (u.get(i).getUsername().equalsIgnoreCase(u1.getUsername())){User aux=u.get(i);
                aux2=u.get(i);

            }
        }
        assert (aux2==null);
    }
    @Test
    public void update(){
        try
        {
            users = um.getUsers();
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        JAXBContext jb = null;
        try
        {
            jb = JAXBContext.newInstance(Users.class);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        Marshaller marshaller = null;
        try
        {
            marshaller = jb.createMarshaller();
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        try
        {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        }
        catch (PropertyException e)
        {
            e.printStackTrace();
        }
        u=users.getUsers();
        String username="admin";
        User ultim=null;
        for(int i=0;i<u.size();i++)
        {
            if(u.get(i).getUsername().equalsIgnoreCase(username))
            {
                User lala=u.get(i);
                lala.setEmail("admin124@yahoo.com");

            }
        }
        users.setUsers(u);
        try {
            marshaller.marshal(users, f);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        u=users.getUsers();
        for(int j=0;j<u.size();j++)
        {
            if(u.get(j).getUsername().equalsIgnoreCase(username))
            {
                ultim=u.get(j);
            }
        }
        assert(ultim.getEmail().equalsIgnoreCase("admin124@yahoo.com"));
    }

}