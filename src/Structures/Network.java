package Structures;

import java.util.Iterator;
import java.util.LinkedList;

import tools.Tool;

public class Network {
	private String TeamName;
	private Integer NbTeam;
	

	private Integer NbVertex;
	private LinkedList<Vertex>[] linkedlist ;
	
	public Network(Tool t,String TeamName,Integer index) throws CloneNotSupportedException {
		
		this.TeamName = TeamName;
		int[][] Data1 = t.getMatchLeft();
		this.NbTeam		= t.getNbteam();
		int[] Couple = new int[2];
		int NbCouples = ((NbTeam-1)*(NbTeam-2))/2;
		this.NbVertex	= NbCouples+NbTeam+1;
		this.linkedlist = new LinkedList[this.NbVertex];
		//Creation du tableau de liste chainee
		
		String[] NamesOfTeam = t.getTeam();
		Integer OverFlowSource = 0;
		for(int i = 0; i<t.getNbteam();i++)
		{
			if(!NamesOfTeam[i].equalsIgnoreCase(TeamName))
			{
				for(int j = 0; j<t.getNbteam();j++)
				{
					if(i != j && !NamesOfTeam[j].equalsIgnoreCase(TeamName))
					{
						OverFlowSource += Data1[i][j];
					}
				}
			}
		}
		//Source
		this.linkedlist[0]=new LinkedList<Vertex>();
		Couple[0]=0;
		Couple[1]=0;
		this.linkedlist[0].add(new Vertex(Couple.clone(),OverFlowSource,this.NbVertex,0,0,1));
		//Puits
		Couple[0]=this.NbVertex;
		Couple[1]=this.NbVertex;
		this.linkedlist[this.NbVertex-1]=new LinkedList<Vertex>();
		this.linkedlist[this.NbVertex-1].add(new Vertex(Couple.clone(),0,0,-1,0,1));
		System.out.println(this.NbVertex.toString());
		Integer it = 1;
		Integer it2 = 1;
		Vertex Temp1,Temp2,Source;
		Source =(Vertex) this.linkedlist[0].getFirst().clone();
		Source.setType(2);
		Source.setOverflow(0);
		for(int i = 0; i<this.NbTeam;i++)
		{
			if(!NamesOfTeam[i].equalsIgnoreCase(TeamName))
			{
				for(int j = i+1; j<this.NbTeam;j++)
				{
					Couple[0]=i;
					Couple[1]=j;
					Temp1 = new Vertex(Couple.clone(),0,0,Data1[i][j+1] ,0,2);
					Temp1.setType(3);
					//Devient un successeur pour la liste chainee
					this.linkedlist[0].add((Vertex) Temp1.clone());
					Temp1.setType(1);//DEVIENT UN POINT "ORIGINE"
					//Temp.setOverflow(0);//PAS DE OVERFLOW CAR SOURCE
					this.linkedlist[it]=new LinkedList<Vertex>();
					//Temp1.setCapacity(0);
					this.linkedlist[it].add((Vertex) Temp1.clone());
					Temp1 = (Vertex) Source.clone();
					Temp1.setCapacity(Data1[i][j+1]);
					this.linkedlist[it].add( Temp1 );
					System.out.println(NamesOfTeam[i]+"/"+NamesOfTeam[j]);
					it ++;
				}
				//CREATION DES SOMMETS REPRESENTANTS UNE EQUIPE
				Couple[0]=i;
				Couple[1]=i;
				Temp1=new Vertex(Couple.clone(),0,0,0,0,1);
				this.linkedlist[NbCouples+it2] = new LinkedList<Vertex>();
				this.linkedlist[NbCouples+it2].add((Vertex) Temp1.clone());
				//On recupere le puit pour l'ajouter en successeur
				Temp1 = (Vertex) this.linkedlist[this.NbVertex-1].get(0).clone();
				Temp1.setType(3);
				Temp1.setCapacity(Data1[index][0]+t.getNbVic(index)-t.getNbVic(it2));
				this.linkedlist[NbCouples+it2].add((Vertex) Temp1.clone());
				Temp1.setType(2);
				Temp1.setIndice(Couple.clone());
				this.linkedlist[this.NbVertex-1].add((Vertex) Temp1.clone());
				it2 += 1 ;
			}
			
			
		}
		
		//Parcours des paires
		for(int i = 1 ; i<=NbCouples ; i++) {
			//Pour chaque somme de type "paire" on lui ajoute ses deux successeurs equipes
			Temp1 = this.linkedlist[i].getFirst();
			Couple=Temp1.getIndice();
			
			//Ajout des deux successeurs aux paires
			Temp2=(Vertex) this.linkedlist[NbCouples+Couple[0]].getFirst().clone();
			Temp2.setType(3);
			Temp2.setCapacity(-1);
			this.linkedlist[i].add(Temp2);
			Temp2=(Vertex) this.linkedlist[NbCouples+Couple[1]].getFirst().clone();
			Temp2.setType(3);
			Temp2.setCapacity(-1);
			this.linkedlist[i].add(Temp2);
			
			//Ajout de un predecesseur au deux sommets simple
			Temp1 = (Vertex) Temp1.clone();
			Temp1.setType(2);
			this.linkedlist[NbCouples+Couple[0]].add((Vertex) Temp1.clone());
			this.linkedlist[NbCouples+Couple[1]].add((Vertex) Temp1.clone());
		}
		Iterator<Vertex> printer;
		for(int i = 0 ; i<this.NbVertex;i++) {
			System.out.println(i);
			if(this.linkedlist[i] != null) {
				printer= this.linkedlist[i].iterator();
				
				while(printer.hasNext()) {
					System.out.println(printer.next().toString());
				}
			}
			
		}
		
	}
	public Integer getNbVertex() {
		return NbVertex;
	}
	
}
