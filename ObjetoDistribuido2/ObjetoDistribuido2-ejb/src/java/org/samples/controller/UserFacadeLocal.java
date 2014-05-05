package org.samples.controller;

import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import org.samples.entities.User;

@Local
public interface UserFacadeLocal {

    public EntityManager getEntityManager();
    public void salvar(User user);
    public void editar(User user);
    public void excluir(User user);
    public List<User> findUserEntities();
    public List<User> findUserEntities(int maxResults, int firstResult);          
}
