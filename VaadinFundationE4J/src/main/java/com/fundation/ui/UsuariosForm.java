/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fundation.ui;

import com.fundation.modelo.DataService;
import com.fundation.modelo.Usuarios;
import com.github.appreciated.material.MaterialTheme;
import com.vaadin.data.Binder;
import com.vaadin.ui.Button;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;

import com.vaadin.ui.Panel;
import com.vaadin.ui.RichTextArea;

import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
public class UsuariosForm extends FormLayout {

   
   private final TextField documento = new TextField("Documento");
   private final RichTextArea nombre = new RichTextArea("Nombre");
  
   
   private final Button aceptar = new Button("Grabar");
   private final Button cancelar = new Button("Eliminar");
   
   private final DataService repo = new DataService();
   private Usuarios usuario ;
   private final MyUI myUI;
   private final Panel panel = new Panel("Datos de Usuarios");
   
   Binder<Usuarios> binder = new Binder<>(Usuarios.class);
   
    public UsuariosForm(MyUI myUI) {
        this.myUI = myUI;
        
        VerticalLayout vl = new VerticalLayout();
        vl.addComponents(documento,nombre);
        panel.setContent(vl);
       
        HorizontalLayout barraBotones = new HorizontalLayout();
        
        aceptar.addStyleName(MaterialTheme.BUTTON_PRIMARY);
        cancelar.addStyleName(MaterialTheme.BUTTON_ROUND);
        cancelar.addStyleName(MaterialTheme.BUTTON_DANGER);
        
        aceptar.addClickListener(e-> {
            try {
                aceptar();
            } catch (Exception ex) {
                Logger.getLogger(UsuariosForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        cancelar.addClickListener(e-> {
            try {
                cancelar();
            } catch (Exception ex) {
                Logger.getLogger(UsuariosForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        barraBotones.addComponents(aceptar,cancelar);
        
        
        //Form Principal
        addComponents(panel,barraBotones);
        
        
    }
    
    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
        binder.bindInstanceFields(this);
        binder.setBean(usuario);
    }
    
    public void aceptar () throws Exception{
       repo.usuariosService().edit(usuario);
       myUI.actualizarLista();   
        
        
    }

    
    public void cancelar () throws Exception{
         repo.usuariosService().delete(usuario.getIdUsuario());
         myUI.actualizarLista();
    }

   
   
   
   
    
    
    
}
