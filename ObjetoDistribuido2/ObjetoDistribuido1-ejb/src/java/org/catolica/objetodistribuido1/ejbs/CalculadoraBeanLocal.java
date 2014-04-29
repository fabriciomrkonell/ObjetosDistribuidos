package org.catolica.objetodistribuido1.ejbs;

import javax.ejb.Local;

/**
 *
 * @author Fabrício Ronchi
 */
@Local
public interface CalculadoraBeanLocal {
    
    double somar(double a, double b); 
  
}
