package Structures;

public class Vertex implements Cloneable{
	   
	private int []Indice;
    private int Overflow;
    private int Altitude;
    private int Type;//First = 1, predecessor = 2, successor = 3
    private int Flow;
    private int Capacity;

    public Vertex(int []Indice, int Overflow, int Altitude,int Capacity,int Flow,int Successor) {
        this.Indice		= new int[2];
    	this.Indice		= Indice;
        this.Overflow	= Overflow; //nom de l'équipe
        this.Altitude	= Altitude; //nbr de victoires de l'équipe
        this.Type 		= Successor;
        this.Flow 		= Flow;
        this.Capacity	= Capacity;
     }

	public int getOverflow() {
		return Overflow;
	}

	public void setOverflow(int overflow) {
		Overflow = overflow;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public void setIndice(int []indice) {
		Indice = indice;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}

	public int getAltitude() {
		return Altitude;
	}

	public void setAltitude(int altitude) {
		Altitude = altitude;
	}

	public int getFlow() {
		return Flow;
	}

	public void setFlow(int flow) {
		Flow = flow;
	}

	public int[] getIndice() {
		return Indice;
	}

	public int getType() {
		return Type;
	}

	public int getCapacity() {
		return Capacity;
	}
	public void setType(int Type){
		this.Type=Type;
	}
	@Override
	public String toString() {
		String TypeChar;
		String Indices;
		if(this.Type == 3) {
			TypeChar = "Successor";
		}else if (this.Type==2) {
			TypeChar = "Predecessor";
		}else {
			TypeChar = "Source";
		}
		if(this.Indice[0] == this.Indice[1]) {
			Indices = "("+Integer.toString(this.Indice[0])+")";
		}else {
			Indices = "("+Integer.toString(this.Indice[0]) + "," +Integer.toString(this.Indice[1]) +")";
		}
		return "Vertex [Indice=" + Indices + ", Overflow=" + Overflow + ", Altitude=" + Altitude + ", Type=" + TypeChar
				+ ", Flow=" + Flow + ", Capacity=" + Capacity + "]";
	}
}
