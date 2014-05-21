/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fabricioronchi.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.fabricioronchi.entities.User;

/**
 *
 * @author fabricio.konell
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements com.fabricioronchi.interfaces.UserFacadeRemote {
    @PersistenceContext(unitName = "ObjEJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
}
