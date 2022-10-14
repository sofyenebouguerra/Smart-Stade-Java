/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7.service;

import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author RafedDz
 * @param <T>
 */
public interface IServicetournoi<T> {
    public void ajouter(T t);
    public List<T> afficher()throws SQLException;
}
