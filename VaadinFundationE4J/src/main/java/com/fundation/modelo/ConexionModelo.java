/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fundation.modelo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ricardo
 */
public class ConexionModelo {
    
    private static ConexionModelo conexion;
    private final EntityManagerFactory fabricaConexion;
    
    private ConexionModelo() {
        fabricaConexion = Persistence.createEntityManagerFactory("UnidadPersistenciaDemo");
    }
    
    public static ConexionModelo getConexion () {
        
        if (conexion == null){
            conexion = new ConexionModelo ();
        }
        
       return conexion; 
    }
    
    public EntityManagerFactory getEntityManagerFactory(){
        return fabricaConexion;
    }
    
    public static String Ver (String value){
        return value;
    }
    
}
