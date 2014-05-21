package DAO;

import entities.User;
import java.util.List;
import javax.ejb.Remote;


@Remote
public interface UserFacadeRemote {

    void create(User user);

    void edit(User user);

    void remove(User user);

    User find(Object id);

    List<User> findAll();
    
    void falar();     
    
    List<User> findRange(int[] range);

    int count();
    
}
