package org.samples.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRole implements Serializable {
     private static final long serialVersionUID = 1L;
    @Id
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private Long userId; // must be initialized by the application
    
    @Column(nullable = false)
    private Long roleId; // must be initialized by the application

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    
      
    public void setUserId(Long id) {
        this.userId = id;
    }
    
    public Long getUserId() {
        return userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }    
    
    
    @Override
    public String toString() {
        return this.getClass().getName() + "[ id= " + id + " userId=" + userId + " roleId=" + roleId + "]";
    } 
    
}
