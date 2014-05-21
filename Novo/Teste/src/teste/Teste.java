package teste;

import DAO.UserFacadeRemote;
import entities.User;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Teste {

    private static final String JNDI_NAME = "java:global/EJB/EJB-ejb/UserFacade";
    
    public static void main(String[] args) throws NamingException {
        InitialContext ctx;
        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial",
                "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("java.naming.factory.url.pkgs",
                "com.sun.enterprise.naming");
        props.setProperty("java.naming.factory.state",
                "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
        ctx = new InitialContext(props);
        UserFacadeRemote userRemote = (UserFacadeRemote) ctx.lookup(JNDI_NAME);
        userRemote.falar();
    }
    
}
