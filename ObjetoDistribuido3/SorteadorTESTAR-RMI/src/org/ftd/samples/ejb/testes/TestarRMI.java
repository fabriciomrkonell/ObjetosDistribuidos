package org.ftd.samples.ejb.testes;

import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.ftd.samples.ejb.entities.User;
import org.ftd.samples.ejb.remote.SorteadorBeanRemote;
import org.ftd.samples.ejb.remote.UserFacadeRemote;

/**
 *
 * @author Fabio Tavares Dippold
 *
 */
public class TestarRMI {

    private static final String JNDI_NAME
            = "java:global/SorteadorEAR/SorteadorEAR-ejb/UserFacade";

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
            //SorteadorBeanRemote sorteadorBean = (SorteadorBeanRemote) ctx.lookup(JNDI_NAME);
            //System.out.println(sorteadorBean.sortear());
            
            UserFacadeRemote user = (UserFacadeRemote) ctx.lookup(JNDI_NAME);    
            List<User> listuser = user.findAll();
            
            User o;
            System.out.println("---Imprimindo Usuários---");
            for (int i = 0; i < listuser.size(); i++) {
                o = (User) listuser.get(i);
                System.out.println("ID: " + o.getId() + " - Nome: " + o.getName());
                
            }                               
            
        } catch (NamingException ex) {
            Logger.getLogger(TestarRMI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
