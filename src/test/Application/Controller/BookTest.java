package Application.Controller;

import Application.Model.Book;
import Application.Model.BookStore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;
import java.util.List;

/**
 * Created by Ionel Carmen on 4/21/2017.
 */
public class BookTest
{
    File f=new File("E:\\SemII\\PS\\Assignemnt2\\src\\main\\resources\\books.xml");

    @Autowired
    private BookStore users;

    private UnMarshal um=new UnMarshal();
    private List<Book> u;

    @Test
    public void read()
    {
        String title="The theory of everything ";
        String authr="Stephen Hawking";
        try
        {
            users = um.getBooks();
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        JAXBContext jb = null;
        try
        {
            jb = JAXBContext.newInstance(BookStore.class);
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
        u=users.getBooks();
        Book u1=null;
        for(int i=0;i<u.size();i++)
        {
            if (u.get(i).getAuthor().equalsIgnoreCase(authr))
                u1=u.get(i);
        }
        assert(u1.getAuthor().equalsIgnoreCase(authr));
    }

    @Test
    public void create(){

        Book b1=new Book("Book1","book1","nuconteaza",44.6,5);
        try
        {
            users = um.getBooks();
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        JAXBContext jb = null;
        try
        {
            jb = JAXBContext.newInstance(BookStore.class);
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
        u=users.getBooks();
        u.add(b1);
        Book u2=null;
        users.setBooks(u);
        try
        {
            marshaller.marshal(users, f);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        try
        {
            users=um.getBooks();
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        u=users.getBooks();
        for(int i=0;i<u.size();i++)
        {
            if(u.get(i).getAuthor().equals("book1")&&u.get(i).getTitle().equals("Book1"))
            {
                u2=u.get(i);
            }
        }
        assert (b1.getTitle().equalsIgnoreCase(u2.getTitle()) && b1.getAuthor().equalsIgnoreCase(u2.getAuthor()));
    }
    @Test
    public void delete()
    {
        Book b1=new Book("Book1","book1","romance",44.6,5);
        try
        {
            users = um.getBooks();
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        JAXBContext jb = null;
        try
        {
            jb = JAXBContext.newInstance(BookStore.class);
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
        u=users.getBooks();
        for(int i=0;i<u.size();i++)
            if (u.get(i).getAuthor().equalsIgnoreCase(b1.getAuthor()) &&u.get(i).getTitle().equalsIgnoreCase(b1.getTitle()) )
            {
                Book aux=u.get(i);
                u.remove(aux);
            }
        users.setBooks(u);
        try
        {
            marshaller.marshal(users, f);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        u=users.getBooks();
        Book aux2=null;
        for(int i=0;i<u.size();i++)
        {
            if (u.get(i).getTitle().equalsIgnoreCase(b1.getTitle()) &&
                    u.get(i).getAuthor().equalsIgnoreCase(b1.getAuthor()) ){
                Book aux=u.get(i);
                aux2=u.get(i);

            }
        }
        assert (aux2==null);
    }
    @Test
    public void update()
    {
        try
        {
            users = um.getBooks();
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        JAXBContext jb = null;
        try
        {
            jb = JAXBContext.newInstance(BookStore.class);
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
        u=users.getBooks();
        String title="Universe in a nutshell ";
        String auth="Stephen Hawking";
        Book ultim=null;
        for(int i=0;i<u.size();i++)
        {
            if(u.get(i).getAuthor().equalsIgnoreCase(auth))
            {
                Book lala=u.get(i);
                lala.setPrice(33.7);

            }
        }
        users.setBooks(u);
        try
        {
            marshaller.marshal(users, f);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        u=users.getBooks();
        for(int j=0;j<u.size();j++)
        {
            if(u.get(j).getAuthor().equalsIgnoreCase(auth))
            {
                ultim=u.get(j);
            }
        }
        assert(ultim.getPrice()==33.7);
    }
}
