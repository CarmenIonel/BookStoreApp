package Application.Controller;

import Application.Model.Book;
import Application.Model.BookStore;
import Application.Model.Exceptions.BookNotFound;
import Application.Model.Exceptions.Empty;
import Application.Model.Exceptions.Insuficient;
import Application.Model.Exceptions.OrderNotFound;
import Application.Model.Order;
import Application.Model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;
import java.util.*;

/**
 * Created by Ionel Carmen on 4/10/2017.
 */
@Controller
public class OrderController
{
    @Autowired
    private Orders o;

    @Autowired
    private BookStore bs;

    @Autowired
    private BookStore cos;

    UnMarshal um=new UnMarshal();
    //update
    @RequestMapping(path="/updateOrder", method= RequestMethod.GET)
    public String ub(HttpServletRequest ht)
    {
        return "/updateOrder";
    }

    @RequestMapping(value="/updateOrder", method= RequestMethod.POST)
    public String upOrder(HttpServletRequest ht)throws Exception
    {
        Order order=null;
        Book b=null;
        Book b1=null;
        o=um.getOrders();
        if(ht.getParameter("name")!="")
            order=o.findAByName(ht.getParameter("name"));
        if(order==null)
            throw new OrderNotFound();
        else
        {
            //sterge o carte din order
            if (ht.getParameter("delete") != "")
            {
                o.getOrders().remove(order);
                b = order.getTitle(ht.getParameter("delete"));
                if (b == null)
                    throw new BookNotFound();
                else
                {
                    order.deleteBook(b);
                    o.getOrders().add(order);
                    um.setOrders(o);
                }
            }
            //adauga o carte
            System.out.print(ht.getParameter("title"));
            if (ht.getParameter("title") != "" && ht.getParameter("author") != "" && ht.getParameter("nr") != "")
            {
                o.getOrders().remove(order);
                bs=um.getBooks();
                b = bs.findByTitle(ht.getParameter("title"));
                b1 = bs.findByTitle(ht.getParameter("author"));
                if (b == null || b1 == null || !b1.equals(b))
                    throw new BookNotFound();
                else
                    {
                        order.addBook(b, Integer.parseInt(ht.getParameter("nr")));
                        o.getOrders().add(order);
                        um.setOrders(o);
                    }
            }
        }
        return "/employeeMeniu";
    }

    //delete
    @RequestMapping(path="/deleteOrder", method= RequestMethod.GET)
    public String db(HttpServletRequest ht)
    {
        return "/deleteOrder";
    }

    @RequestMapping(value="/deleteOrder", method= RequestMethod.POST)
    public String delOrder(HttpServletRequest ht)throws Exception {
        Order order=null;
        o=um.getOrders();
        System.out.println(o.getOrders().get(0).getName());
        if(ht.getParameter("name")!="")
        {
            order = o.findAByName(ht.getParameter("name"));
            if(order==null)
            {
                System.out.println("null");
                throw new OrderNotFound();
            }
            else
            {
                o.getOrders().remove(order);
                um.setOrders(o);
            }
        }
        return "/employeeMeniu";
    }


    //view
    @RequestMapping(path="/{name}/viewOrder", method= RequestMethod.GET)
    public String emxpbx(@PathVariable String name, Model m)
    {
        Order order=o.findAByName(name);
        ArrayList<Order> list=new ArrayList<Order>();
        list.add(order);
        m.addAttribute("order", order);
        return "/viewOrder";
    }

    @RequestMapping(path="/viewOrder", method= RequestMethod.GET)
    public String vi(HttpServletRequest ht)
    {
        return "/viewOrder";
    }

    @RequestMapping(value = "/viewOrder", method= RequestMethod.POST)
    public String orders(HttpServletRequest ht) throws Exception
    {
        Order order=null;
        o=um.getOrders();
        if (ht.getParameter("name") != "")
        {
            order=o.findAByName(ht.getParameter("name"));
        }
        if (order == null)
            throw new OrderNotFound();
        else
            return "redirect:/"+order.getName()+"/viewOrder";
    }

    //create

    //adaugare carti la cos
    @RequestMapping(path="/addBooks", method= RequestMethod.GET)
    public String addb(HttpServletRequest ht)
    {
        return "/addBooks";
    }
    @RequestMapping(value="/addBooks", method= RequestMethod.POST)
    public String addBo(HttpServletRequest ht)throws Exception
    {
        bs=um.getBooks();
        Book b=null;
        Book b1=null;
        if(ht.getParameter("title")!="" && ht.getParameter("author")!="" && ht.getParameter("nr")!="")
        {
            b=bs.findByTitle(ht.getParameter("title"));
            b1=bs.findByAuthor(ht.getParameter("author"));
            if(b==null || b1==null || b!=b1)
                throw new BookNotFound();
            else
            {
                b.setStock(Integer.parseInt(ht.getParameter("nr")));
                cos=um.getCos();
                if(cos.getBooks()==null)
                {
                    cos.setBooks(new ArrayList<Book>());
                }
                cos.getBooks().add(b);
                um.setCos(cos);
            }
        }
        return "/addBooks";
    }

    //creare comanda
    @RequestMapping(path="/createOrder", method= RequestMethod.GET)
    public String co(HttpServletRequest ht)
    {
        return "/createOrder";
    }
    @RequestMapping(value="/createOrder", method= RequestMethod.POST)
    public String cor(HttpServletRequest ht)throws Exception
    {
        Order order;
        o=um.getOrders();
        if(ht.getParameter("name")!="")
        {
            if (o.findAByName(ht.getParameter("name")) == null)
            {
                order = new Order(ht.getParameter("name"));
                if (um.getCos() != null) {
                    bs = um.getCos();
                    for (int i = 0; i < bs.getBooks().size(); i++)
                        order.addBook(bs.getBooks().get(i), bs.getBooks().get(i).getStock());
                    bs.setBooks(new ArrayList<Book>());
                    um.setCos(bs);
                    o.getOrders().add(order);
                    um.setOrders(o);
                } else
                    throw new Empty();
            }
            else
                throw new Exception();
        }
        return "/employeeMeniu";
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


    @ExceptionHandler(OrderNotFound.class)
    public String handleOrderNot(HttpServletRequest request, Exception ex, Model m)
    {
        String x="Order not founded!";
        m.addAttribute("text", x);
        return "/error";
    }

    @ExceptionHandler(Empty.class)
    public String hrNot(HttpServletRequest request, Exception ex, Model m)
    {
        String x="Empty cart!";
        m.addAttribute("text", x);
        return "/error";
    }

    @ExceptionHandler(Insuficient.class)
    public String ins(HttpServletRequest request, Exception ex, Model m)
    {
        String x="Stock Insufficient!";
        m.addAttribute("text", x);
        return "/error";
    }
}
