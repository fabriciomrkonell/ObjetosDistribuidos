package teste;

import com.fabricioronchi.entities.User;
import com.fabricioronchi.interfaces.UserFacadeRemote;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Teste {
    
       private static final String JNDI_NAME
            = "java:global/ObjetoDistribuido3/ObjetoDistribuido3-ejb/UserFacade";

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
            
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

            ctx = new InitialContext(props);
            UserFacadeRemote userRemote = (UserFacadeRemote) ctx.lookup(JNDI_NAME);           
            List<User> listUser = userRemote.findAll();             
        } catch (NamingException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
