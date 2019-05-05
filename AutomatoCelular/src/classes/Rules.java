package classes;

public class Rules 
{
	public Rules() {
		// TODO Auto-generated constructor stub
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
		if(	(left==1 && mid==1 && right == 1) ||
		    (left==1 && mid==0 && right == 1) ||
		    (left==0 && mid==0 && right == 1)) {
			return 0;
		}
		// Position 6, 4, 3, 2 and 0 returns 1
		return 1;
	}
	
	private int rule50 (int left, int mid, int right) {
		//Position 7, 6, 3, 2 and 0 returns 0
		if(	(left==1 && mid==1 && right == 1) ||
		    (left==1 && mid==1 && right == 0) ||
		    (left==0 && mid==1 && right == 1) ||
		    (left==0 && mid==1 && right == 0) ||
		    (left==0 && mid==0 && right == 0) ) {
			return 0;
		}
		// Position 6, 4, 3, 2 and 0 returns 1
		return 1;
	}
	
	private int rule226(int left, int mid, int right) {
		//Position 4, 3, 2 and 0 returns 0
		if(	(left==1 && mid==0 && right == 0) ||
		    (left==0 && mid==1 && right == 1) ||
		    (left==0 && mid==1 && right == 0) ||
		    (left==0 && mid==0 && right == 0) ) {
			return 0;
		}
		// Position 7, 6, 5 and 1 returns 1
		return 1;
	}
}
