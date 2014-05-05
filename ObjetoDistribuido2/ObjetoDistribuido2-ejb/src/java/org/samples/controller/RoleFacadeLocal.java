package org.samples.controller;

import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import org.samples.entities.Role;

@Local
public interface RoleFacadeLocal {
    
    public EntityManager getEntityManager();
    public void salvar(Role role);
    public void editar(Role role);
    public void excluir(Role role);
    public List<Role> findRoleEntities();
    public List<Role> findRoleEntities(int maxResults, int firstResult);      
}

