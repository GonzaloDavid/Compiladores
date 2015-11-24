//Gonzalo david Proaño
package com.epn;
import java.util.StringTokenizer;
import java.util.regex.*;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class AnalisadorLexico {
	public String Verificar()
	{
			if(this.VCaracterEspecial()==true)
			{
				//System.out.println("caracter especial");
				return "caracter especial";
			}
			if(this.VOperadorCompuestos()==true)
			{
				//System.out.println("operador compuesto");
				return "operador compuesto";
			}
			if(this.VPalabraReservada()==true)
			{
				//System.out.println("palabra reservada");
				return "palabra reservada";
			}

			if(this.VNumeros()==true)
			{
				//System.out.println("int");
				return "int";
			}
			if(this.VDecimal()==true)
			{
				//System.out.println("float");
				return "float";
			}
			if(this.VBoleano()==true)
			{
				//System.out.println("boolean");
				return "boolean";
			}
			if(this.VCharacteres()==true)
			{
				//System.out.println("char");
				return "Char";
			}
			if(this.VComentarios()==true)
			{
				//System.out.println("Comentario");
				return "";
			}
			if(this.VIdentificador()==true)
			{
				//System.out.println("Identificador");
				return "Identificador";
			}else{
			return "error";
			}
			
	}
	public boolean VCaracterEspecial()
	{
		try{
			String direccion="C:\\Users\\DAVID PROAÑO\\Desktop\\CompiladoresAnalisador\\input.txt";
			FileReader abrir=new FileReader(direccion);
			BufferedReader br = new BufferedReader(abrir);
			String cadena=br.readLine();
			StringTokenizer st =new StringTokenizer(cadena);
			
				while (st.hasMoreTokens())
			{

				String s2;
				s2 = st.nextToken();
				Pattern pat = Pattern.compile("[+|;|:|(|)|[|]|{|}|,|-|*|/|>|<|=|!|&|$]");

				Matcher mat = pat.matcher(s2);
				if (mat.matches()==true)
				{
                   System.out.println("caracter especial");
					return true; 
				} 

			}
		}
	
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "HAY UN ERROR EN EL TRY");
		}
		return false;

	}
	public boolean VComentarios()
	{
		try{
			String direccion="C:\\Users\\DAVID PROAÑO\\Desktop\\CompiladoresAnalisador\\input.txt";
			FileReader abrir=new FileReader(direccion);
			BufferedReader br = new BufferedReader(abrir);
			String cadena=br.readLine();
			StringTokenizer st =new StringTokenizer(cadena);
			while (st.hasMoreTokens())
			{
				String s2;
				s2 = st.nextToken();
				Pattern pat = Pattern.compile("^//.*");

				Matcher mat = pat.matcher(s2);
				if (mat.matches()==true)
				{
					 System.out.println("");
					return true; 
				} 

			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "HAY UN ERROR EN EL TRY");
		}
		return false;

	}
	public boolean VIdentificador()
	{
		try{
			String direccion="C:\\Users\\DAVID PROAÑO\\Desktop\\CompiladoresAnalisador\\input.txt";
			FileReader abrir=new FileReader(direccion);
			BufferedReader br = new BufferedReader(abrir);
			String cadena=br.readLine();
			StringTokenizer st =new StringTokenizer(cadena);
			while (st.hasMoreTokens())
			{
				String s2;
				s2 = st.nextToken();
				Pattern pat = Pattern.compile("\\w+(\\d+|_|\\w*)");

				Matcher mat = pat.matcher(s2);
				if (mat.matches()==true)
				{
					 System.out.println("identificador");
					return true; 
				} 

			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "HAY UN ERROR EN EL TRY");
		}
		return false;

	}


	public boolean VOperadorCompuestos()
	{
		try{
			String direccion="C:\\Users\\DAVID PROAÑO\\Desktop\\CompiladoresAnalisador\\input.txt";
			FileReader abrir=new FileReader(direccion);
			BufferedReader br = new BufferedReader(abrir);
			String cadena=br.readLine();
			StringTokenizer st =new StringTokenizer(cadena);
			while (st.hasMoreTokens())
			{
				String s2;
				s2 = st.nextToken();
				Pattern pat = Pattern.compile("&&|==|!=|<=|>=");
				Matcher mat = pat.matcher(s2);

				if (mat.matches()==true) {
					 System.out.println("operador compuesto");

					return true;
				} 


			}
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "HAY UN ERROR EN EL TRY");
		}
		return false;
	}


	public boolean VPalabraReservada()
	{
		try{
			String direccion="C:\\Users\\DAVID PROAÑO\\Desktop\\CompiladoresAnalisador\\input.txt";
			FileReader abrir=new FileReader(direccion);
			BufferedReader br = new BufferedReader(abrir);
			String cadena=br.readLine();
			StringTokenizer st =new StringTokenizer(cadena);
			while (st.hasMoreTokens())
			{
				String s2;
				s2 = st.nextToken();
				Pattern pat = Pattern.compile("int|float|bool|char|string|if|then|else|while|do|input|output|return");
				Matcher mat = pat.matcher(s2);
				if (mat.matches()==true) {
					 System.out.println("palabra reservada");
					return true;
				} else {

				}
			}}catch(Exception ex)
		{
				JOptionPane.showMessageDialog(null, "HAY UN ERROR EN EL TRY");
		}
		return false;

	}
	public boolean VNumeros()
	{
		try{
			String direccion="C:\\Users\\DAVID PROAÑO\\Desktop\\CompiladoresAnalisador\\input.txt";
			FileReader abrir=new FileReader(direccion);
			BufferedReader br = new BufferedReader(abrir);
			String cadena=br.readLine();
			StringTokenizer st =new StringTokenizer(cadena);
			while (st.hasMoreTokens())
			{
				String s2;
				s2 = st.nextToken();
				Pattern pat = Pattern.compile("-*\\d+");
				Matcher mat = pat.matcher(s2);
				if (mat.matches()==true) {
					System.out.println("int");
					return true;
				} else {

				}

			}}catch(Exception ex)
		{
				JOptionPane.showMessageDialog(null, "HAY UN ERROR EN EL TRY");
		}
		return false;

	}
	public boolean VString()
	{
		try{
			String direccion="C:\\Users\\DAVID PROAÑO\\Desktop\\CompiladoresAnalisador\\input.txt";
			FileReader abrir=new FileReader(direccion);
			BufferedReader br = new BufferedReader(abrir);
			String cadena=br.readLine();
			StringTokenizer st =new StringTokenizer(cadena);
			while (st.hasMoreTokens())
			{
				String s2;
				s2 = st.nextToken();
				Pattern pat = Pattern.compile("\\w*");
				Matcher mat = pat.matcher(s2);
				if (mat.matches()==true) {
					System.out.println("String");
					return true;
				} else {

				}

			}}catch(Exception ex)
		{
				JOptionPane.showMessageDialog(null, "HAY UN ERROR EN EL TRY");
		}
		return false;

	}
	public boolean VCharacteres()
	{
		try{
			String direccion="C:\\Users\\DAVID PROAÑO\\Desktop\\CompiladoresAnalisador\\input.txt";
			FileReader abrir=new FileReader(direccion);
			BufferedReader br = new BufferedReader(abrir);
			String cadena=br.readLine();
			StringTokenizer st =new StringTokenizer(cadena);
			while (st.hasMoreTokens())
			{
				String s2;
				s2 = st.nextToken();
				Pattern pat = Pattern.compile("‘.’");
				Matcher mat = pat.matcher(s2);
				if (mat.matches()==true) {
					System.out.println("char");
					return true;
				} else {

				}

			}}catch(Exception ex)
		{
				JOptionPane.showMessageDialog(null, "HAY UN ERROR EN EL TRY");
		}
		return false;

	}


	public boolean VBoleano()
	{try{
		String direccion="C:\\Users\\DAVID PROAÑO\\Desktop\\CompiladoresAnalisador\\input.txt";
		FileReader abrir=new FileReader(direccion);
		BufferedReader br = new BufferedReader(abrir);
		String cadena=br.readLine();
		StringTokenizer st =new StringTokenizer(cadena);
		while (st.hasMoreTokens())
		{
			String s2;

			Pattern pat = Pattern.compile("true|false");
			s2 = st.nextToken();
			Matcher mat = pat.matcher(s2);
			if (mat.matches()==true) {
				System.out.println("boolean");
				return true;
			} else {

			}
		}}catch(Exception ex)
	{
			JOptionPane.showMessageDialog(null, "HAY UN ERROR EN EL TRY");
	}
	return false;

	}
	public boolean VDecimal()
	{
		try{
			String direccion="C:\\Users\\DAVID PROAÑO\\Desktop\\CompiladoresAnalisador\\input.txt";
			FileReader abrir=new FileReader(direccion);
			BufferedReader br = new BufferedReader(abrir);
			String cadena=br.readLine();
			
			StringTokenizer st =new StringTokenizer(cadena);
			
			while (st.hasMoreTokens())
			{
				String s2;
				s2 = st.nextToken();
				Pattern pat = Pattern.compile("-*\\d+,\\d+");
				Matcher mat = pat.matcher(s2);
				if (mat.matches()==true) {
					System.out.println("Decimal");
					return true;
				} else {

				}

			}}catch(Exception ex)
		{
				JOptionPane.showMessageDialog(null, "HAY UN ERROR EN EL TRY");
		}
		return false;

	}
	public void SalidaArchivo(String direccion,String direccion1)
	{String x="";
	try{
		FileReader abrir1=new FileReader(direccion1);
		BufferedReader br = new BufferedReader(abrir1);
		String cadena=" ";
		File abrir=new File (direccion);
		FileWriter  w=new FileWriter(abrir);
		BufferedWriter bw = new BufferedWriter(w);
		PrintWriter wr =new PrintWriter(bw);
		while((cadena=br.readLine())!=null)
		{
			StringTokenizer st =new StringTokenizer(cadena);
			while (st.hasMoreTokens())
			{
			x=this.Verificar();
			String s2;
			s2 = st.nextToken();
			wr.write(""+x+"   ");

			}
		}

		wr.close();
		bw.close();


	}catch(Exception ex)
	{
		JOptionPane.showMessageDialog(null, "La direccion del archivo esta incorrecta");
	}
	}
	public void EntradaArchivo(String direccion)
	{
		try{
			FileReader abrir=new FileReader(direccion);
			BufferedReader br = new BufferedReader(abrir);
			String cadena=" ";
			cadena=br.readLine();
			while((cadena=br.readLine())!=null)
			{
				System.out.println(""+cadena);
			}
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "La direccion del archivo esta incorrecta");
		}
	}
	public int ErrorLinea()
	{
		int A =0;			
				if(this.Verificar().equals("error"))
				{
					A++;

				}
				return A;
	}
}
