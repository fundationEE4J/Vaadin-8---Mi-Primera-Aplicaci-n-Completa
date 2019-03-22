package com.fundation.ui;

import com.fundation.modelo.DataService;
import com.fundation.modelo.Usuarios;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;

import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;

import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.HtmlRenderer;

import com.vaadin.ui.renderers.ProgressBarRenderer;




@Theme("demo")
public class MyUI extends UI {

    DataService repo = new DataService();
        
    Grid<Usuarios> grid = new Grid<>(Usuarios.class);
    
    
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        final UsuariosForm form = new UsuariosForm(this);
        
        //Utilizar mis métodos, JDBC, JPA, EJB, REST.......
        
        
               
        actualizarLista();
        
        grid.removeAllColumns();
        
        grid.addColumn(Usuarios::getDocumento).setCaption("Documento");
        grid.addColumn(Usuarios::getNombre, new HtmlRenderer()).
                setCaption("Nombre de Usuario");
        grid.addColumn(Usuarios::getCupo, new ProgressBarRenderer())
                .setCaption("Cupo")
                ;
        
        //
        
                            
                                           
        
        
        grid.addItemClickListener((Grid.ItemClick<Usuarios> event)-> {
             
            if (event.getItem() != null){
                
                        form.setUsuario(event.getItem() );
            }
            
            
            
        });

     
        
           
        //nuevo Layout
        HorizontalLayout hl = new HorizontalLayout();
        
        hl.addComponents(grid,form);
        
        hl.setComponentAlignment(form, Alignment.MIDDLE_RIGHT);
        hl.setComponentAlignment(grid, Alignment.MIDDLE_RIGHT);
        
        
        
        layout.addComponents( hl);
        
       
        setContent(layout);
        
        
        
    }

    public void actualizarLista() {
        grid.setItems( repo.usuariosService().findAll() );
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
