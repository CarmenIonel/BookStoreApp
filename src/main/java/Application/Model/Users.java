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
@XmlRootElement(name="Users")
public class Users
{

    private  List<User> users=new ArrayList<User>();

    public List<User> getUsers() {return users;}

    @XmlElement(name="User")
    public void setUsers(List<User> users) {this.users = users;}

    public User findByName(String name)
    {
        for(int i=0; i<users.size(); i++)
            if(users.get(i).getName().equals(name))
                return users.get(i);
        return null;
    }

    public User findByUserame(String username)
    {
        for(int i=0; i<users.size(); i++)
            if(users.get(i).getUsername().equals(username))
                return users.get(i);
        return null;
    }
}
