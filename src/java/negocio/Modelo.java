/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.ClienteDAO;
import datos.RepresentanteDAO;
import datos.SistemaVDAO;

/**
 *
 * @author Alejandro
 */
public class Modelo {
    private Modelo(){}
    private static Modelo instance = null;
    
    public static Modelo getInstance() {
        if (instance == null) {
            instance = new Modelo();
        }

        return instance;
    }
    private RepresentanteDAO rdao;
    private ClienteDAO cdao;
    private SistemaVDAO sistemaVDAO;
     
    public RepresentanteDAO getRdao(){
		if(rdao==null){   
        rdao = new RepresentanteDAO();
         }
		return rdao;
	} 
   
     public ClienteDAO getCdao(){
		if(cdao==null){
			cdao= new ClienteDAO();
		}
		return cdao;
	}
      public SistemaVDAO getSistemaVDAO(){
		if(sistemaVDAO==null){
			sistemaVDAO= new SistemaVDAO();
		}
		return sistemaVDAO;
	} 
}
