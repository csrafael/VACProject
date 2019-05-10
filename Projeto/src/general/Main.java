package general;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

import ac.Rules;
import fractal.Sierpinski;

public class Main 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int selecao;
		
		System.out.println("   Selecione o que deseja executar (Automato Celular = 1, Pirâmide de Sierpinski = 2):");
		selecao = scn.nextInt();
		if(selecao == 1) {
			startAC();
		}else if (selecao == 2) {
			startFractal();
		}
		scn.close();
	}
	
	private static void startAC() 
	{
		Scanner scn = new Scanner(System.in);
		Rules rule = new Rules();
		Random r = new Random();
		
		int interactions = 0;
		int tamanho = 1000; //comprimento do automato celular
		int ruleNumber = 0;
		int[][] acInicial = new int[1000][1000];
		
		System.out.println("    Apresentação de regras de automato de Wolfram."
				+"\n    Os valores iniciais são aleatórios e a ordem de apresentação é crescente."
				+"\n    Isto é, a primeira interação é a primeira linha."
				+"\n    Automato limitado a 999 interações e de tamanho 999");
		System.out.println("\nQuantas tamanho: ");
		tamanho = scn.nextInt();
		System.out.println("\nQuantas Interações: ");
		interactions = scn.nextInt();
		
		System.out.println("Qual Regra(50,93,226)? ");
		ruleNumber = scn.nextInt();
		
		scn.close();
		
		for(int i=0;i<tamanho;i++) {
			acInicial[0][i] = r.nextInt(2);
		}
				
		acInicial = rule.executeRules(ruleNumber, acInicial, tamanho, interactions);
		
		printAC(acInicial, tamanho, interactions);

	}
	
	private static void printAC(int[][] ac, int size, int interactions) 
	{
		for (int i=0;i<interactions;i++) {
			String texto = new String();
			
			texto = "";
			
			for(int j = 0; j<size;j++) {
				texto += ac[i][j]==1?"*":" ";
			}
			
			System.out.println(texto);
		}
	   /* JFrame frame = new JFrame();
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(screenSize.width, screenSize.height);
	    frame.setPreferredSize(frame.getSize());
	    frame.setLayout(new BorderLayout());
	    frame.setBackground(Color.LIGHT_GRAY);
	    frame.add(new Rules(ac, size, interactions));
	    frame.pack();
	    frame.setVisible(true);*/
	    
	}
	
	private static void startFractal() 
	{
		Scanner scn = new Scanner(System.in);
	    JFrame frame = new JFrame();
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    
	    //Limite de recursão = 18
	    int recursion;
	    
		System.out.println("    Selecione quantas recursões(Limite próximo de 18):");
		recursion = scn.nextInt();
		scn.close();

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(screenSize.width, screenSize.height);
	    frame.setPreferredSize(frame.getSize());
	    frame.setLayout(new BorderLayout());
	    frame.add(new Sierpinski(frame.getSize(),recursion));
	    frame.pack();
	    frame.setVisible(true);
	}
}
