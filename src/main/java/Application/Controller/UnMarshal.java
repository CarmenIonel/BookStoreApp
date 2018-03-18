package Application.Controller;

import Application.Model.BookStore;
import Application.Model.Orders;
import Application.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Ionel Carmen on 4/10/2017.
 */
public class UnMarshal
{
    @Autowired
    private BookStore b;

    @Autowired
    private Orders o;

    @Autowired
    private Users u;

    public BookStore getBooks () throws JAXBException
    {
        File file = new File( "E:\\SemII\\PS\\Assignemnt2\\src\\main\\resources\\books.xml" );
        JAXBContext jaxbContext = JAXBContext.newInstance( BookStore.class );
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        b=((BookStore)jaxbUnmarshaller.unmarshal( file ));
        return b;
    }

    public void setBooks(BookStore b)throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(BookStore.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(b, System.out);
        jaxbMarshaller.marshal(b, new File("E:\\SemII\\PS\\Assignemnt2\\src\\main\\resources\\books.xml"));
    }

    public Orders getOrders () throws JAXBException
    {
        File file = new File( "E:\\SemII\\PS\\Assignemnt2\\src\\main\\resources\\orders.xml" );
        JAXBContext jaxbContext = JAXBContext.newInstance( Orders.class );
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        o=((Orders)jaxbUnmarshaller.unmarshal( file ));
        return o;
    }

    public void setOrders(Orders o) throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(Orders.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(o, System.out);
        jaxbMarshaller.marshal(o, new File("E:\\SemII\\PS\\Assignemnt2\\src\\main\\resources\\orders.xml"));
    }

    public Users getUsers () throws JAXBException
    {
        File file = new File( "E:\\SemII\\PS\\Assignemnt2\\src\\main\\resources\\users.xml" );
        JAXBContext jaxbContext = JAXBContext.newInstance( Users.class );
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        u=((Users)jaxbUnmarshaller.unmarshal( file ));
        return u;
    }

    public void setUsers(Users u) throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(u, System.out);
        jaxbMarshaller.marshal(u, new File("E:\\SemII\\PS\\Assignemnt2\\src\\main\\resources\\users.xml"));
    }
    public BookStore getCos () throws JAXBException
    {
        File file = new File( "E:\\SemII\\PS\\Assignemnt2\\src\\main\\resources\\cos.xml" );
        JAXBContext jaxbContext = JAXBContext.newInstance( BookStore.class );
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        b=((BookStore)jaxbUnmarshaller.unmarshal( file ));
        return b;
    }

    public void setCos(BookStore b)throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(BookStore.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(b, System.out);
        jaxbMarshaller.marshal(b, new File("E:\\SemII\\PS\\Assignemnt2\\src\\main\\resources\\cos.xml"));
    }
}
