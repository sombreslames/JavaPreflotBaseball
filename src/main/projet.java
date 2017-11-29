package main;
import Structures.Network;
import tools.Tool;
public class projet {

	public static void main(String[] args) throws CloneNotSupportedException{
		Tool t= new Tool("data/data1ex.txt");
		Network n = new Network(t,t.getTeam()[0],1);
	}

}
