package remote;

import entities.User;
import java.util.List;
import javax.ejb.Remote;
import javax.persistence.EntityManager;

@Remote
public interface UserBeanRemote {  
    
    public EntityManager getEntityManager();
    public void salvar(User user);
    public void editar(User user);
    public void excluir(User user);
    public List<User> findUserEntities();
    public List<User> findUserEntities(int maxResults, int firstResult);  
    
}

