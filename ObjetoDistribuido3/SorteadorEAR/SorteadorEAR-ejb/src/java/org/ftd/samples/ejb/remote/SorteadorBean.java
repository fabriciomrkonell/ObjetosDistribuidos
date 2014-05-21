package org.ftd.samples.ejb.remote;

import java.util.Random;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Fabio Tavares Dippold
 *
 */
@Stateless
@Remote(SorteadorBeanRemote.class)
public class SorteadorBean implements SorteadorBeanRemote {

    private final Random gerador = new Random();

    @Override
    public int sortear() {
        System.out.println("SorteadorBean:sortear() foi invocado...");
        return this.gerador.nextInt(6) + 1;
    }
    
    @PostConstruct
    public void inicializando() {
        System.out.println("Mais uma SorteadorBean criado...");
    }

    @PreDestroy
    public void destruindo() {
        System.out.println("Mais uma SorteadorBean será destruído...");
    }    
    
}
