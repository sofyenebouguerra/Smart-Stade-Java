/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionusers.services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hajje
 */
public interface Iservice<T> {
public void ajouter(T t);
public List<T> afficher()throws SQLException;
public void supprimer(int id) throws SQLException;
public void modifier(int id, T t) throws SQLException;

    
}
