/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fundation.modelo;

/**
 *
 * @author Ricardo
 */
public class DataService {
    
     ConexionModelo conexion = ConexionModelo.getConexion(); 
	
	
	//Declaración de Servicios de Acceso a Datos//
    private UsuariosDao usuariosService;
	
	//Mapeo de Controllers//
     public UsuariosDao usuariosService(){
                usuariosService = new  UsuariosDao(conexion.getEntityManagerFactory());
		return usuariosService ;
	}
	
	
	}
    
    

