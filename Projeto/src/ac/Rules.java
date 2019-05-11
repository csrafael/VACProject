package ac;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rules extends JPanel
{
	private int[][] ac;
	private int acSize;
	private int interactions;
	
	public Rules() {
		// TODO Auto-generated constructor stub
	}
	
	public Rules(int[][] ac, int acSize, int interactions ) {
		// TODO Auto-generated constructor stub
		this.ac = ac;
		this.acSize = acSize;
		this.interactions = interactions;
	}
	
    @Override
    public void paintComponent(Graphics g) {
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	//Alterar a numeração do incremento para facilitar a visualização (Regra 90: i=j=2)
    	for(int i = 0; i <= acSize; i+=2){
            for(int j = 0; j <= interactions; j+=2){
                if(ac[j][i]==0) {                	
                	g.clearRect(i, j, 2, 2);
                }
                else {
                	g.setColor(Color.black);
                	g.fillRect(i, j, 2, 2);
                }
            }
        }
        
    }
	
	public int[][] executeRules (int ruleNumber, int[][] ac, int acSize, int interactions ) {
		if (ruleNumber==50) {
			for(int j=0;j<interactions;j++) {
				for(int i = 0; i < acSize; i++ ) {
					if(i==0) {
						ac[j+1][i] = rule50(ac[j][acSize-1], ac[j][i], ac[j][i+1]);
					}else if(i==acSize-1) {
						ac[j+1][i] = rule50(ac[j][i-1], ac[j][i], ac[j][0]);
					}
					else{
						ac[j+1][i] = rule50(ac[j][i-1], ac[j][i], ac[j][i+1]);
					}
				}
			}
		}else if(ruleNumber==90) {
			for(int j=0;j<interactions;j++) {
				for(int i = 0; i < acSize; i++ ) {
					if(i==0) {
						ac[j+1][i] = rule90(ac[j][acSize-1], ac[j][i], ac[j][i+1]);
					}else if(i==acSize-1) {
						ac[j+1][i] = rule90(ac[j][i-1], ac[j][i], ac[j][0]);
					}
					else{
						ac[j+1][i] = rule90(ac[j][i-1], ac[j][i], ac[j][i+1]);
					}
				}
			}
		}
		else if(ruleNumber==93) {
			for(int j=0;j<interactions;j++) {
				for(int i = 0; i < acSize; i++ ) {
					if(i==0) {
						ac[j+1][i] = rule93(ac[j][acSize-1], ac[j][i], ac[j][i+1]);
					}else if(i==acSize-1) {
						ac[j+1][i] = rule93(ac[j][i-1], ac[j][i], ac[j][0]);
					}
					else{
						ac[j+1][i] = rule93(ac[j][i-1], ac[j][i], ac[j][i+1]);
					}
				}
			}
		}
		else if(ruleNumber==226) {
			for(int j=0;j<interactions;j++) {
				for(int i = 0; i < acSize; i++ ) {
					if(i==0) {
						ac[j+1][i] = rule226(ac[j][acSize-1], ac[j][i], ac[j][i+1]);
					}else if(i==acSize-1) {
						ac[j+1][i] = rule226(ac[j][i-1], ac[j][i], ac[j][0]);
					}
					else{
						ac[j+1][i] = rule226(ac[j][i-1], ac[j][i], ac[j][i+1]);
					}
				}
			}
		}
		
		return ac;
	}
	
	private int rule93 (int left, int mid, int right) {
		//Position 7, 5 and 1 returns 0
		if	(left==1 && mid==1 && right == 1)
			return 0;
		if	(left==1 && mid==1 && right == 0)
			return 1;
		if	(left==1 && mid==0 && right == 1)
			return 0;
		if   (left==1 && mid==0 && right == 0)
			return 1;
		if   (left==0 && mid==1 && right == 1)
			return 1;
		if   (left==0 && mid==1 && right == 0)		
			return 1;
		if   (left==0 && mid==0 && right == 1)
			return 0;
		
		// Position 6, 4, 3, 2 and 0 returns 1
		return 1;
	}
	
	private int rule50 (int left, int mid, int right) {
				
		if	(left==1 && mid==1 && right == 1)
			return 0;
		if	(left==1 && mid==1 && right == 0)
			return 0;
		if	(left==1 && mid==0 && right == 1)
			return 1;
		if   (left==1 && mid==0 && right == 0)
			return 1;
		if   (left==0 && mid==1 && right == 1)
			return 0;
		if   (left==0 && mid==1 && right == 0)		
			return 0;
		if   (left==0 && mid==0 && right == 1)
			return 1;
		
		return 0;
	}
	
	private int rule226(int left, int mid, int right) {
		if	(left==1 && mid==1 && right == 1)
			return 1;
		if	(left==1 && mid==1 && right == 0)
			return 1;
		if	(left==1 && mid==0 && right == 1)
			return 1;
		if   (left==1 && mid==0 && right == 0)
			return 0;
		if   (left==0 && mid==1 && right == 1)
			return 0;
		if   (left==0 && mid==1 && right == 0)		
			return 0;
		if   (left==0 && mid==0 && right == 1)
			return 1;
		
		return 0;
	}
	private int rule90(int left, int mid, int right) {
		if	(left==1 && mid==1 && right == 1)
			return 0;
		if	(left==1 && mid==1 && right == 0)
			return 1;
		if	(left==1 && mid==0 && right == 1)
			return 0;
		if   (left==1 && mid==0 && right == 0)
			return 1;
		if   (left==0 && mid==1 && right == 1)
			return 1;
		if   (left==0 && mid==1 && right == 0)		
			return 0;
		if   (left==0 && mid==0 && right == 1)
			return 1;
		
		return 0;
	}
}
