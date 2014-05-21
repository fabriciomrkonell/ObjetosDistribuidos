package org.ftd.samples.ejb.testes;

import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.ftd.samples.ejb.entities.Role;
import org.ftd.samples.ejb.entities.User;
import org.ftd.samples.ejb.remote.RoleFacadeRemote;
import org.ftd.samples.ejb.remote.UserFacadeRemote;

public class TestarRMI {

    private static final String JNDI_NAME
            = "java:global/SorteadorEAR/SorteadorEAR-ejb/";

    public static void main(String[] args) {

        InitialContext ctx;
        Properties props = new Properties();
        try {
            props.setProperty("java.naming.factory.initial",
                    "com.sun.enterprise.naming.SerialInitContextFactory");

            props.setProperty("java.naming.factory.url.pkgs",
                    "com.sun.enterprise.naming");

            props.setProperty("java.naming.factory.state",
                    "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

            // optional.  Defaults to localhost.  Only needed if web server is running 
            // on a different host than the appserver    
            props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");

            // optional.  Defaults to 3700.  Only needed if target orb port is not 3700.
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

            ctx = new InitialContext(props);            
            
            UserFacadeRemote user = (UserFacadeRemote) ctx.lookup(JNDI_NAME + "UserFacade");    
            List<User> listuser = user.findAll();
            
            User u;
            System.out.println("---Imprimindo Usuários---");
            for (int i = 0; i < listuser.size(); i++) {
                u = (User) listuser.get(i);
                System.out.println("ID: " + u.getId() + " - Nome: " + u.getName());                
            }  
            System.out.println("Total de Usuários: " + user.count());
            
            System.out.println("");
            System.out.println("------");
            System.out.println("");
            
            RoleFacadeRemote role = (RoleFacadeRemote) ctx.lookup(JNDI_NAME + "RoleFacade");    
            List<Role> listrole = role.findAll();
            
            Role r;
            System.out.println("---Imprimindo Regras---");
            for (int i = 0; i < listrole.size(); i++) {
                r = (Role) listrole.get(i);
                System.out.println("ID: " + r.getId() + " - Nome: " + r.getName());                
            }  
            System.out.println("Total de Regras: " + role.count());
            
        } catch (NamingException ex) {
            Logger.getLogger(TestarRMI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
