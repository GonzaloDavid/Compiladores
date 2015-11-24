package com.epn;

import javax.swing.JOptionPane;

public class Aplication {

	public static void main(String[] args) {

		AnalisadorLexico analisador=new AnalisadorLexico();
		analisador.EntradaArchivo("C:\\Users\\DAVID PROAÑO\\Desktop\\CompiladoresAnalisador\\input.txt");
		analisador.SalidaArchivo("C:\\Users\\DAVID PROAÑO\\Desktop\\CompiladoresAnalisador\\ouput.txt","C:\\Users\\DAVID PROAÑO\\Desktop\\CompiladoresAnalisador\\input.txt");
		analisador.Verificar();
		
		String salida=" ";
		salida+="hay un error en la linea :"+analisador.ErrorLinea();
		if(analisador.ErrorLinea()==0)
		{
			
		}
		else{
			JOptionPane.showMessageDialog(null,salida );
		
		}
		
	}

}
