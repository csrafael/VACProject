package classes;

import java.util.*;

import classes.*;

public class Main 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		startAC();
		
	}
	
	private static void startAC() 
	{
		Scanner scn = new Scanner(System.in);
		Rules rule = new Rules();
		Random r = new Random();
		
		int interactions = 0;
		int ruleNumber = 0;
		int[][] acInicial = new int[1000][100];
		
		System.out.println("    Apresentação de regras de automato de Wolfram."
				+"\n    Os valores iniciais são aleatórios e a ordem de apresentação é crescente."
				+"\n    Isto é, a primeira interação é a primeira linha."
				+"\n    Automato limitado a 1000 interações e de tamanho 100");
		System.out.println("\nQuantas Interações: ");
		interactions = scn.nextInt();
		
		System.out.println("Qual Regra(50,93,226)? ");
		ruleNumber = scn.nextInt();
		
		scn.close();
		
		for(int i=0;i<100;i++) {
			acInicial[0][i] = r.nextInt(2);
		}
		
		
		acInicial = rule.executeRules(ruleNumber, acInicial, 100, 3);
		
		printAC(acInicial, 100, interactions);

	}
	
	private static void printAC(int[][] ac, int size, int interactions) {
		for (int i=0;i<interactions;i++) {
			String texto = new String();
			
			texto = "";
			
			for(int j = 0; j<size;j++) {
				texto += ac[i][j]+" ";
			}
			
			System.out.println(texto);
		}
	}
}
