/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;

/**
 *
 * @author Josué Dik
 */
public interface ModelDao <T>{
    public int Enregistrer (T object);
    public int Modifier (T object);
    public int Supprimer (T object);
}
