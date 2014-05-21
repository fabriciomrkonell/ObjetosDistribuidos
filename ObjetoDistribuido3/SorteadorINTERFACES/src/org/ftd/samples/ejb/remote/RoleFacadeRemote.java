/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftd.samples.ejb.remote;

import java.util.List;
import javax.ejb.Remote;
import org.ftd.samples.ejb.entities.Role;

/**
 *
 * @author fabricio.konell
 */
@Remote
public interface RoleFacadeRemote {

    void create(Role role);

    void edit(Role role);

    void remove(Role role);

    Role find(Object id);

    List<Role> findAll();

    List<Role> findRange(int[] range);

    int count();
    
}
