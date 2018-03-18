package Application.Model;

import Application.Controller.UnMarshal;
import Application.Model.Exceptions.BookNotFound;
import Application.Model.Exceptions.Insuficient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ionel Carmen on 4/10/2017.
 */
@XmlType(propOrder={"name", "price", "books"})
@XmlRootElement(name="Order")
public class Order
{
    @Autowired
    private BookStore bs;

    private UnMarshal um=new UnMarshal();
    private double price;
    private List<Book> books;
    private String name;

    public Order(){}
    public Order(String name)
    {
        this.price=0;
        this.books=new ArrayList<Book>();
        this.name=name;
    }

    public double getPrice() {return price;}
    @XmlElement( name = "Price", required = true )
    public void setPrice(double price) {this.price = price;}

    public List<Book> getBooks() {return books;}
    @XmlElement( name = "Books", required = true )
    public void setBooks(List<Book> books) {this.books = books;}

    public String getName() {return name;}
    @XmlElement( name = "Name", required = true )
    public void setName(String name) {this.name=name;}

    public void addBook(Book b, int nr) throws Exception
    {
        bs=um.getBooks();

        if(b.getStock()<nr)
            throw new Insuficient();
        b.setStock(nr);
        books.add(b);

        Book aux=bs.findByAuthor(b.getAuthor());
        Book aux1=bs.findByTitle(b.getTitle());
        if(aux==aux1)
            aux.setStock(aux.getStock()-nr);

        bs.getBooks().remove(aux);
        bs.getBooks().add(aux);

        um.setBooks(bs);

        this.price=this.price+nr*b.getPrice();
    }

    public void deleteBook(Book b) throws Exception
    {
        bs=um.getBooks();
        if(!(books.contains(b)))
            throw new BookNotFound();
        books.remove(b);

        Book aux=bs.findByAuthor(b.getAuthor());
        Book aux1=bs.findByTitle(b.getTitle());
        if(aux==aux1)
            aux.setStock(aux.getStock()+b.getStock());
        bs.getBooks().remove(aux);
        bs.getBooks().add(aux);
        um.setBooks(bs);

        this.price=this.price-b.getStock()*b.getPrice();
    }

    public Book getTitle(String title)
    {
        for(int i=0; i<books.size(); i++)
            if(books.get(i).getTitle().equals(title))
                return books.get(i);
        return null;
    }

    public Book getAuthor(String author)
    {
        for(int i=0; i<books.size(); i++)
            if(books.get(i).getAuthor().equals(author))
                return books.get(i);
        return null;
    }
}
