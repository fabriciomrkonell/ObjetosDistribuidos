package org.catolica.objetodistribuido1.ejbs;

import javax.ejb.Stateless;

/**
 *
 * @author Fabrício Ronchi
 */
@Stateless
public class CalculadoraBean implements CalculadoraBeanLocal {
    
   @Override
   public double somar(double a, double b){
       return (a + b);       
   }
}
