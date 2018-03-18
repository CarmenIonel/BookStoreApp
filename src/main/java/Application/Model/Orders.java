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
@XmlRootElement(name="Orders")
public class Orders
{

    private List<Order> orders=null;

    public List<Order> getOrders() {return orders;}

    @XmlElement(name="Order")
    public void setOrders(List<Order> orders) {this.orders = orders;}

    public List<Order> findAllName(String name)
    {
        List<Order> list=new ArrayList<Order>();
        for(int i=0; i<orders.size(); i++)
            if(orders.get(i).getName().equals(name))
                list.add(orders.get(i));
        if(list.isEmpty())
            return null;
        else
            return list;
    }

    public Order findAByName(String name)
    {
        for(int i=0; i<orders.size(); i++)
            if(orders.get(i).getName().equals(name))
                return orders.get(i);
        return null;
    }
}
