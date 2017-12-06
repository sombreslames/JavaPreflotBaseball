package Algorithm;

import java.util.Iterator;
import java.util.LinkedList;

import Structures.Network;
import Structures.Vertex;

public class PreflotAlgorithm {
	private Network net;
	private int it;
	
public PreflotAlgorithm(Network net) {
		this.net = net;
		this.it = 0;
	}

public void RiseTheLevel(LinkedList<Vertex>  l) {
	int Min = 2*this.net.getNbVertex();
	Vertex Temp;
	Iterator<Vertex> Journey;
	Journey = l.iterator();
	
	while (Journey.hasNext()) {
		Temp = Journey.next();
		if(Temp.getAltitude() > Min) {
			Min=Temp.getAltitude();
		}
	}	
	l.getFirst().setAltitude(Min+1);
	return;
}
public void PoorDaWater() {
	
}
public int HowHighAreyou(){
	return 0;
	
}
public int HowMuchCanYouDrink() {
	return 0;
	
}
}