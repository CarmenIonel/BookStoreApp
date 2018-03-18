package Application.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Collection;

/**
 * Created by Ionel Carmen on 4/10/2017.
 */
@XmlType(propOrder={"name","address","phone", "email","role", "username", "password"})
@XmlRootElement(name="User")
public class User implements UserDetails
{
    private String name, address, phone, email, role, username, password;

    public User()
    {

    }

    public User( String name, String address, String phone, String email, String username, String password)
    {
        this.name=name;
        this.address=address;
        this.phone=phone;
        this.email=email;
        this.username=username;
        this.password=password;
        this.role="ROLE_EMPLOYEE";
    }

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }

    public String getRole()
    {
        return role;
    }

    public String getUsername() {return username;}

    public String getPassword() {return password;}

    @XmlElement( name = "Name", required = true )
    public void setName(String name)
    {
        this.name = name;
    }
    @XmlElement( name = "Address", required = true )
    public void setAddress(String address) {this.address = address;}
    @XmlElement( name = "Phone", required = true )
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @XmlElement( name = "Email", required = true )
    public void setEmail(String email) {
        this.email = email;
    }
    @XmlElement( name = "Role", required = true )
    public void setRole(String role) {
        this.role = role;
    }
    @XmlElement( name = "Username", required = true )
    public void setUsername(String username) {this.username = username;}
    @XmlElement( name = "Password", required = true )
    public void setPassword(String password) {this.password = password;}


    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return AuthorityUtils.createAuthorityList(this.getRole());
    }

}
