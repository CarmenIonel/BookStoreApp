package Application.Controller;

import Application.Model.Book;
import Application.Model.BookStore;
import Application.Model.Exceptions.BookNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Ionel Carmen on 4/10/2017.
 */
@Controller
public class BookController
{
    @Autowired
    private BookStore bs;

    UnMarshal um=new UnMarshal();

    //create book
    @RequestMapping(path="/createBook", method= RequestMethod.GET)
    public String cb(HttpServletRequest ht)
    {
        return "/createBook";
    }

    @RequestMapping(value="/createBook", method= RequestMethod.POST)
    public String addBook(HttpServletRequest ht)throws Exception
    {
        bs=um.getBooks();

        Book b=new Book(ht.getParameter("title"), ht.getParameter("author"), ht.getParameter("genre"),
                Double.parseDouble(ht.getParameter("price")), Integer.parseInt(ht.getParameter("stock")));

        if(bs.getBooks().contains(b))
            throw new Exception();
        else
        {
            bs.getBooks().add(b);
            um.setBooks(bs);
        }
        return "/adminMeniu";
    }

    //update book
    @RequestMapping(path="/updateBook", method= RequestMethod.GET)
    public String ub(HttpServletRequest ht)
    {
        return "/updateBook";
    }

    @RequestMapping(value="/updateBook", method= RequestMethod.POST)
    public String upBook(HttpServletRequest ht)throws Exception
    {
        Book b=null;
        Book b1=null;
        bs=um.getBooks();
        if(ht.getParameter("title")!="")
            b=bs.findByTitle(ht.getParameter("title"));
        if(ht.getParameter("author")!="")
            b1=bs.findByAuthor(ht.getParameter("author"));
        if(b==null || b1==null || b!=b1)
            throw new BookNotFound();
        else
        {
            bs.getBooks().remove(b);
            if(ht.getParameter("title1")!="")
                b.setTitle(ht.getParameter("title1"));
            if(ht.getParameter("author1")!="")
                b.setAuthor(ht.getParameter("author1"));
            if(ht.getParameter("genre")!="")
                b.setGenre(ht.getParameter("genre"));
            if(ht.getParameter("price")!="")
                b.setPrice(Double.parseDouble(ht.getParameter("price")));
            if(ht.getParameter("stock")!="")
                b.setStock(Integer.parseInt(ht.getParameter("stock")));

            bs.getBooks().add(b);
            um.setBooks(bs);
        }
        return "/adminMeniu";
    }

    //delete book
    @RequestMapping(path="/deleteBook", method= RequestMethod.GET)
    public String db(HttpServletRequest ht)
    {
        return "/deleteBook";
    }

    @RequestMapping(value="/deleteBook", method= RequestMethod.POST)
    public String delBook(HttpServletRequest ht)throws Exception {
        Book b = null;
        Book b1 = null;
        bs = um.getBooks();
        if (ht.getParameter("title") != "")
            b=bs.findByTitle(ht.getParameter("title"));
        if (ht.getParameter("author") != "")
            b1=bs.findByAuthor(ht.getParameter("author"));
        if (b==null || b1==null || b!=b1)
            throw new BookNotFound();
        else
        {
            bs.getBooks().remove(b);
            um.setBooks(bs);
        }
        return "/adminMeniu";
    }

    //view book
    @RequestMapping(path="/{title}/viewBook", method= RequestMethod.GET)
    public String bk(@PathVariable String title, Model m)
    {
        List<Book> b=bs.findAllTitle(title);
        if(b==null)
            b=bs.findAllAuthor(title);
        m.addAttribute("book1", b);
        return "/viewBook";
    }

    @RequestMapping(value="/viewBook", method= RequestMethod.GET)
    public String boo(HttpServletRequest ht)
    {
        return "/viewBook";
    }

    @RequestMapping(value = "/viewBook", method= RequestMethod.POST)
    public String book(HttpServletRequest ht) throws Exception
    {
        Book b = null;
        bs = um.getBooks();
        if (ht.getParameter("title") != "")
        {
            b = bs.findByTitle(ht.getParameter("title"));
            if (b == null)
                throw new BookNotFound();
            else
                return "redirect:/"+b.getTitle()+"/viewBook";
        }
        else if (ht.getParameter("author") != "")
        {
            b= bs.findByAuthor(ht.getParameter("author"));
            if (b == null)
                throw new BookNotFound();
            else
                return "redirect:/"+b.getAuthor()+"/viewBook";
        }
        return null;
    }

    //employee
    //dupa titlu
    @RequestMapping(path="/{title}/searchTitle", method= RequestMethod.GET)
    public String empb(@PathVariable String title, Model m)
    {
        List<Book> b=bs.findAllTitle(title);
        m.addAttribute("book", b);
        return "/searchTitle";
    }

    @RequestMapping(value="/searchTitle", method= RequestMethod.GET)
    public String bzxz(HttpServletRequest ht)
    {
        return "/searchTitle";
    }

    @RequestMapping(value = "/searchTitle", method= RequestMethod.POST)
    public String bookss(HttpServletRequest ht) throws Exception
    {
        Book b = null;
        bs = um.getBooks();
        if (ht.getParameter("title") != "")
        {
            b = bs.findByTitle(ht.getParameter("title"));
        }
        if (b == null)
            throw new BookNotFound();
        else
            return "redirect:/"+b.getTitle()+"/searchTitle";
    }

    //dupa author
    @RequestMapping(path="/{title}/searchAuthor", method= RequestMethod.GET)
    public String empbx(@PathVariable String title, Model m)
    {
        List<Book> b=bs.findAllAuthor(title);
        m.addAttribute("book", b);
        return "/searchAuthor";
    }

    @RequestMapping(value="/searchAuthor", method= RequestMethod.GET)
    public String bzxzx(HttpServletRequest ht)
    {
        return "/searchAuthor";
    }

    @RequestMapping(value = "/searchAuthor", method= RequestMethod.POST)
    public String booksxs(HttpServletRequest ht) throws Exception
    {
        Book b = null;
        bs = um.getBooks();
        if (ht.getParameter("author") != "")
        {
            b = bs.findByAuthor(ht.getParameter("author"));
        }
        if (b == null)
            throw new BookNotFound();
        else
            return "redirect:/"+b.getAuthor()+"/searchAuthor";
    }


    //dupa gen
    @RequestMapping(path="/{title}/searchGenre", method= RequestMethod.GET)
    public String emxpbx(@PathVariable String title, Model m)
    {
        List<Book> b=bs.findAllGenre(title);
        m.addAttribute("book", b);
        return "/searchGenre";
    }

    @RequestMapping(value="/searchGenre", method= RequestMethod.GET)
    public String bzxaazx(HttpServletRequest ht)
    {
        return "/searchGenre";
    }

    @RequestMapping(value = "/searchGenre", method= RequestMethod.POST)
    public String bookdsxs(HttpServletRequest ht) throws Exception
    {
        Book b = null;
        bs = um.getBooks();
        if (ht.getParameter("genre") != "")
        {
            b = bs.findByGenre(ht.getParameter("genre"));

        }
        if (b == null)
            throw new BookNotFound();
        else
            return "redirect:/"+b.getGenre()+"/searchGenre";
    }
    //exceptii
    @ExceptionHandler(BookNotFound.class)
    public String handleBookNot(HttpServletRequest request, Exception ex, Model m)
    {
        String x="Book not founded!";
        m.addAttribute("text", x);
        return "/error";
    }

    @ExceptionHandler(Exception.class)
    public String handle(HttpServletRequest request, Exception ex, Model m)
    {
        String x="This Object exists!";
        m.addAttribute("text", x);
        return "/error";
    }
}
