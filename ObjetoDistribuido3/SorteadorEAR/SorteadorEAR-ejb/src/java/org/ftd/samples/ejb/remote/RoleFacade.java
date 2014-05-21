package org.ftd.samples.ejb.remote;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ftd.samples.ejb.entities.Role;

@Stateless
@Remote(RoleFacadeRemote.class)
public class RoleFacade extends AbstractFacade<Role> implements RoleFacadeRemote {
    @PersistenceContext(unitName = "SorteadorEAR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RoleFacade() {
        super(Role.class);
    }
    
}
