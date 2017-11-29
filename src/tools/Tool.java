package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Tool {
	private String[] Team;
	private int Nbteam;
	private int[] NbVic;
	private int[][] MatchLeft;
	public Tool(String fileName)
	{
		try {
			   File file 		= new File(fileName);
			   Scanner scanner 	= new Scanner(file);
			   scanner.useDelimiter(" |\\n");
			   Integer nbteam 	= Integer.parseInt(scanner.next());
			   this.Nbteam		= nbteam;
			   this.MatchLeft 	= new int[nbteam][nbteam+1];
			   this.NbVic		= new int[nbteam];
			   this.Team		= new String[nbteam];
			   
			   
			   System.out.println("Nb team :"+nbteam);
			   for(int i = 0; i<nbteam;i++)
			   {
				   scanner.next();
				   this.Team[i] = scanner.next();
				   this.NbVic[i] = Integer.parseInt(scanner.next());
				   System.out.println(this.Team[i] + " have "+this.NbVic[i]);
				   for(int j = 0; j<nbteam+1;j++)
				   {
					   this.MatchLeft[i][j] = Integer.parseInt(scanner.next());
				   }
			   }
			   scanner.close();
			  } catch (FileNotFoundException e) {
			   e.printStackTrace();
			  } 
	}
	public Integer getNbteam() {
		return Nbteam;
	}
	@Override
	public String toString() {
		return "Tool [Team=" + Arrays.toString(Team) + ", NbVic="
				+ Arrays.toString(NbVic) + ", MatchLeft="
				+ Arrays.toString(MatchLeft) + "]";
	}
	public String[] getTeam() {
		return Team;
	}
	
	public int[] getNbVic() {
		return NbVic;
	}
	
	public int[][] getMatchLeft() {
		return MatchLeft;
	}
	public int getNbVic(Integer i) {
		return NbVic[i];
	}
}
