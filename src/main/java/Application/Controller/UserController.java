package Application.Controller;

import Application.Model.Exceptions.EmployeeNotFound;
import Application.Model.GenerateReport;
import Application.Model.ReportFactory;
import Application.Model.User;
import Application.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ReportAsSingleViolation;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ionel Carmen on 4/10/2017.
 */
@Controller
public class UserController
{
    @Autowired
    private Users u;

    UnMarshal um=new UnMarshal();

    //create employee
    @RequestMapping(path="/createEmployee", method= RequestMethod.GET)
    public String c(HttpServletRequest ht)
    {
        return "/createEmployee";
    }

    @RequestMapping(value="/createEmployee", method= RequestMethod.POST)
    public String addUser(HttpServletRequest ht)throws Exception
    {
        u=um.getUsers();

        User user = new User(ht.getParameter("name"), ht.getParameter("address"),ht.getParameter("phone"), ht.getParameter("email"),
                    ht.getParameter("username"), ht.getParameter("password"));

        if(u.findByUserame(ht.getParameter("username")) !=null)
            throw new Exception();
        else
        {
            u.getUsers().add(user);
            um.setUsers(u);
        }
        return "/adminMeniu";
    }

    //update employee
    @RequestMapping(path="/updateEmployee", method= RequestMethod.GET)
    public String u(HttpServletRequest ht)
    {
        return "/updateEmployee";
    }

    @RequestMapping(value="/updateEmployee", method= RequestMethod.POST)
    public String upUser(HttpServletRequest ht)throws Exception
    {
        User user=null;
        u=um.getUsers();
        if(ht.getParameter("name")!="")
            user=u.findByName(ht.getParameter("name"));
        else
            if(ht.getParameter("username")!="")
                user=u.findByUserame(ht.getParameter("username"));
        if(user==null)
            throw new EmployeeNotFound();
        else
        {
            u.getUsers().remove(user);
            if(ht.getParameter("name1")!="")
                user.setName(ht.getParameter("name1"));
            if(ht.getParameter("address")!="")
                user.setAddress(ht.getParameter("address"));
            if(ht.getParameter("email")!="")
                user.setEmail(ht.getParameter("email"));
            if(ht.getParameter("phone")!="")
                user.setPhone(ht.getParameter("phone"));
            if(ht.getParameter("username1")!="")
                user.setUsername(ht.getParameter("username1"));
            if(ht.getParameter("username1")!="")
                user.setPassword(ht.getParameter("username1"));

            u.getUsers().add(user);
            um.setUsers(u);
        }
        return "/adminMeniu";
    }
    //delete employee
    @RequestMapping(path="/deleteEmployee", method= RequestMethod.GET)
    public String d(HttpServletRequest ht)
    {
        return "/deleteEmployee";
    }

    @RequestMapping(value="/deleteEmployee", method= RequestMethod.POST)
    public String delUser(HttpServletRequest ht)throws Exception {
        User user = null;
        u = um.getUsers();
        if (ht.getParameter("name") != "")
            user = u.findByName(ht.getParameter("name"));
        else if (ht.getParameter("username") != "")
            user = u.findByUserame(ht.getParameter("username"));
        if (user == null)
            throw new EmployeeNotFound();
        else
        {
            u.getUsers().remove(user);
            um.setUsers(u);
        }
        return "/adminMeniu";
    }

    //view employee
    @RequestMapping(path="/{name}/viewEmployee", method= RequestMethod.GET)
    public String e(@PathVariable String name, Model m)
    {
        User user=u.findByName(name);
        if(user==null)
            user=u.findByUserame(name);
        List<User> list=new ArrayList<User>();
        list.add(user);
        m.addAttribute("employee1", list);
        return "/viewEmployee";
    }

    @RequestMapping(value="/viewEmployee", method= RequestMethod.GET)
    public String em(HttpServletRequest ht)
    {
        return "/viewEmployee";
    }

    @RequestMapping(value = "/viewEmployee", method= RequestMethod.POST)
    public String emp(HttpServletRequest ht) throws Exception
    {
        User user = null;
        u = um.getUsers();
        if (ht.getParameter("name") != "")
        {
            user = u.findByName(ht.getParameter("name"));
            if (user == null)
                throw new EmployeeNotFound();
            else
                return "redirect:/"+user.getName()+"/viewEmployee";
        }
        else if (ht.getParameter("username") != "")
        {
            user = u.findByUserame(ht.getParameter("username"));
            if (user == null)
                throw new EmployeeNotFound();
            else
                return "redirect:/"+user.getUsername()+"/viewEmployee";
        }
        return null;
    }

    //generare raport
    @RequestMapping(path="/getReport", method= RequestMethod.GET)
    public String gg(HttpServletRequest ht)
    {
        return "/getReport";
    }

    @RequestMapping(value="/getReport", method= RequestMethod.POST)
    public String get(HttpServletRequest ht)throws Exception
    {
        if (ht.getParameter("type")!="")
        {
            ReportFactory rf=new ReportFactory();
            GenerateReport report=rf.getType(ht.getParameter("type"));
            report.generateRaport();
        }
        else
            throw new Exception();
        return "/adminMeniu";
    }

    @RequestMapping(path="/pass", method= RequestMethod.GET)
    public String pp(HttpServletRequest ht)
    {
        return "/pass";
    }
    @RequestMapping(value="/pass", method= RequestMethod.POST)
    public String gst(HttpServletRequest ht)throws Exception
    {
        User user=null;
        String username=ht.getRemoteUser();
        u=um.getUsers();
        user=u.findByUserame(username);
        if(user==null)
            throw new Exception();
        else
        {
            if(user.getRole().equalsIgnoreCase("ROLE_EMPLOYEE"))
                return "/employeeMeniu";
            if(user.getRole().equalsIgnoreCase("ROLE_ADMIN"))
                return "/adminMeniu";
        }
        return null;
    }

    //exceptii
    @ExceptionHandler(EmployeeNotFound.class)
    public String handleClientNot(HttpServletRequest request, Exception ex, Model m)
    {
        String x="Employee not founded!";
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
