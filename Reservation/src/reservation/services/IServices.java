
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.services;


import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author ismail
 * @param <T>
 */
public interface IServices<T> {
    
public void ajouter(T r);
public List<T> afficher()throws SQLException;

    
}
