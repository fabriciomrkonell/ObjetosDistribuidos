package org.samples.controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import org.samples.entities.UserRole;
import org.samples.exceptions.NoneexistentEntityException;

@Stateless
public class UserRoleFacade extends AbstractFacade<UserRole> implements UserRoleFacadeLocal  {
    
  @PersistenceContext(unitName = "ObjetoDistribuido2-ejbPU")
    private EntityManager em;
    
   @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public UserRoleFacade() {
        super(UserRole.class);
    }


    @Override
    public void salvar(UserRole userrole) {
        super.salvar(userrole);
    }

    @Override
    public void editar(UserRole userrole)  {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            userrole = em.merge(userrole);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = userrole.getId();                
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void excluir(Long user, Long role) throws NoneexistentEntityException.NonexistentEntityException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ObjetoDistribuido2-ejbPU");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        UserRole userrole = (UserRole) em.createQuery("SELECT o FROM UserRole o WHERE o.userId = " + user + " and o.roleId = " + role).getSingleResult();
        em.remove(userrole);
        em.getTransaction().commit();
        em.close();        
    }
    
   @Override
    public List<UserRole> findUserRoleEntities() {
        return findUserRoleEntities(true, -1, -1);
    }

    @Override
    public List<UserRole> findUserRoleEntities(int maxResults, int firstResult) {
        return findUserRoleEntities(false, maxResults, firstResult);
    }

    private List<UserRole> findUserRoleEntities(boolean all, int maxResults, int firstResult) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ObjetoDistribuido2-ejbPU");
        EntityManager em = factory.createEntityManager(); 
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UserRole.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    } 
}
