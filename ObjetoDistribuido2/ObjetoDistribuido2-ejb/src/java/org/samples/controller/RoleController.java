package org.samples.controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import org.samples.entities.Role;

@Stateless
public class RoleController extends AbstractFacade<Role> implements RoleFacadeLocal {

    @PersistenceContext(unitName = "ObjetoDistribuido2-ejbPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public RoleController() {
        super(Role.class);
    }

    @Override
    public void salvar(Role role) {
        super.salvar(role);
    }

    @Override
    public void editar(Role role){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            role = em.merge(role);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = role.getId();
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void excluir(Role role) {
        super.excluir(role);
    }

    @Override
    public List<Role> findRoleEntities() {
        return findRoleEntities(true, -1, -1);
    }

    @Override
    public List<Role> findRoleEntities(int maxResults, int firstResult) {
        return findRoleEntities(false, maxResults, firstResult);
    }

    private List<Role> findRoleEntities(boolean all, int maxResults, int firstResult) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ObjetoDistribuido2-ejbPU");
        EntityManager em = factory.createEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Role.class));
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