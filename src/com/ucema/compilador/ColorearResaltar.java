package com.ucema.compilador;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class ColorearResaltar extends DefaultTableCellRenderer {
	private Component componente;
	 
	@Override
    public Component getTableCellRendererComponent(JTable table, Object data, boolean isSelected, boolean hasFocus, int row, int column) {


		String componenteLex = data.toString();
    	setForeground(new Color(153, 153, 153));
    	
    	if( column != 0 ) {
    		componenteLex = table.getValueAt(row, 0).toString();
    	} 
    	else {
        	setForeground(new Color(102, 102, 102));
    	}
		componente = super.getTableCellRendererComponent(table, data, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    		
	    if (componenteLex == "ERROR"){
	        setForeground(Color.red);
	        componente.setFont(componente.getFont().deriveFont(Font.BOLD));
	    }
	    
	    
	    return componente;
	 
    }

}
