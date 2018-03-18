package Application.Model;

import Application.Controller.UnMarshal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.List;

/**
 * Created by Ionel Carmen on 4/19/2017.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private Users users;

    @Autowired
    public UserService()
    {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try
        {
            UnMarshal um=new UnMarshal();
            users = um.getUsers();
        }catch (JAXBException e){}

        List<User> usersList = users.getUsers();
        User user = null;
        for (User aux:usersList)
        {
            if(aux.getUsername().equals(username))
                user = aux;
        }

        user.isEnabled();
        User x= new User(user.getName(),user.getAddress(),user.getPhone(),user.getEmail(),user.getUsername(),user.getPassword());
        x.setRole(user.getRole());
        return x;
    }
}