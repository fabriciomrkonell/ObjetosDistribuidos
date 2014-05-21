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
import org.ftd.samples.ejb.entities.Role;

/**
 *
 * @author fabricio.konell
 */
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
