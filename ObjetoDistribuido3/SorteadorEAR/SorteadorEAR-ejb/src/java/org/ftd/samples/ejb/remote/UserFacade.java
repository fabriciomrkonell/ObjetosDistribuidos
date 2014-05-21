/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftd.samples.ejb.remote;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ftd.samples.ejb.entities.User;

/**
 *
 * @author fabricio.konell
 */
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
