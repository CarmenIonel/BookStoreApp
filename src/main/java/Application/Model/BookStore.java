package Application.Model;

import org.springframework.stereotype.Repository;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ionel Carmen on 4/10/2017.
 */
@Repository
@XmlRootElement(name="BookStore")
public class BookStore
{

    private List<Book> books=null;

    public List<Book> getBooks() {return books;}

    @XmlElement(name="Book")
    public void setBooks(List<Book> books) {this.books = books;}

    public Book findByTitle(String title)
    {
        for(int i=0; i<books.size();i++)
            if(books.get(i).getTitle().equals(title))
                return books.get(i);
        return null;
    }

    public Book findByAuthor(String author)
    {
        for(int i=0; i<books.size();i++)
            if(books.get(i).getAuthor().equals(author))
                return books.get(i);
        return null;
    }

    public Book findByGenre(String genre)
    {
        for(int i=0; i<books.size();i++)
            if(books.get(i).getGenre().equals(genre))
                return books.get(i);
        return null;
    }
    //pentru employee
    public List<Book> findAllTitle(String title)
    {
        List<Book> list=new ArrayList<Book>();
        for(int i=0; i<books.size();i++)
            if(books.get(i).getTitle().equals(title))
                list.add(books.get(i));
        if(list.isEmpty())
            return null;
        else
            return list;
    }

    public List<Book> findAllAuthor(String author)
    {
        List<Book> list=new ArrayList<Book>();
        for(int i=0; i<books.size();i++)
            if(books.get(i).getAuthor().equals(author))
                list.add(books.get(i));
        if(list.isEmpty())
            return null;
        else
            return list;
    }

    public List<Book> findAllGenre(String genre)
    {
        List<Book> list=new ArrayList<Book>();
        for(int i=0; i<books.size();i++)
            if(books.get(i).getGenre().equals(genre))
                list.add(books.get(i));
        if(list.isEmpty())
            return null;
        else
            return list;
    }
}
