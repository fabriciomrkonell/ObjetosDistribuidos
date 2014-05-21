package org.ftd.samples.ejb.remote;

import java.util.List;
import javax.ejb.Remote;
import org.ftd.samples.ejb.entities.User;

@Remote
public interface UserFacadeRemote {

    void create(User user);

    void edit(User user);

    void remove(User user);

    User find(Object id);

    List<User> findAll();

    List<User> findRange(int[] range);

    int count();
    
}
