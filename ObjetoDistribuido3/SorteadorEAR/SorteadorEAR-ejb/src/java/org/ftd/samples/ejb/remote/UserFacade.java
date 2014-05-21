package org.ftd.samples.ejb.remote;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ftd.samples.ejb.entities.User;

@Stateless
@Remote(UserFacadeRemote.class)
public class UserFacade extends AbstractFacade<User> implements UserFacadeRemote {
    @PersistenceContext(unitName = "SorteadorEAR-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
}
