package Application.Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Ionel Carmen on 4/10/2017.
 */
@XmlType(propOrder={"title","author","genre", "price", "stock"})
@XmlRootElement(name="Book")
public class Book
{
    private String title,author,genre;
    private double price;
    private int stock;

    public Book()
    {

    }

    public Book( String title, String author, String genre, double price, int stock)
    {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.stock=stock;
    }

    @XmlElement( name = "Title", required = true )
    public void setTitle(String title) {this.title = title;}
    @XmlElement( name = "Author", required = true )
    public void setAuthor(String author) {this.author = author;}
    @XmlElement( name = "Genre", required = true )
    public void setGenre(String genre) {this.genre = genre;}
    @XmlElement( name = "Price", required = true )
    public void setPrice(double price) {this.price = price;}
    @XmlElement( name = "Stock", required = true )
    public void setStock(int stock) {this.stock = stock;}

    public String getTitle() {return title;}

    public String getAuthor() {return author;}

    public String getGenre() {return genre;}

    public double getPrice() {return price;}

    public int getStock() {return stock;}
}
