package org.samples.controller;

import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import org.samples.entities.UserRole;
import org.samples.exceptions.NoneexistentEntityException.NonexistentEntityException;

@Local
public interface UserRoleFacadeLocal {

    public EntityManager getEntityManager();
    public void salvar(UserRole userrole);
    public void editar(UserRole userrole);
    public void excluir(Long user, Long role) throws NonexistentEntityException;
    public List<UserRole> findUserRoleEntities();
    public List<UserRole> findUserRoleEntities(int maxResults, int firstResult);      
    
}
