import java.util.LinkedList;

public class Mark {
	public static final LinkedList<Mark> NOTENLISTE = new LinkedList<Mark>();
	public double vlmark;
	public int vlects;
	public String vlname;
	public boolean vlweight;

	public Mark(double mark, int ects, String name, boolean weight) {
		vlmark = mark;
		vlects = ects;
		vlname = name;
		vlweight = weight;
	}
	
	public static void printList(){
		for(Mark entry: NOTENLISTE){
			System.out.println("" + entry.getVlname());
			System.out.println("" + entry.getVlmark());
			System.out.println("" + entry.getVlects());
		}
	}

	public static double comuteMark() {
		double result = 0, sumEcts = 0, sumEctsTimesMark = 0;
		boolean weight = false;
		for (Mark entry : NOTENLISTE) {
			weight = entry.isVlweight();
			if(weight){
				sumEcts += entry.getVlects() * 0.5;
				sumEctsTimesMark += (entry.getVlmark() * entry.getVlects()) * 0.5;
			}
			else{
				sumEcts += entry.getVlects();
				sumEctsTimesMark += entry.getVlmark() * entry.getVlects();
			}
		}
		System.out.println(sumEcts + " " + sumEctsTimesMark);
		result = sumEctsTimesMark / sumEcts;
		return result;
	}

	public double getVlmark() {
		return vlmark;
	}

	public void setVlmark(double vlmark) {
		this.vlmark = vlmark;
	}

	public int getVlects() {
		return vlects;
	}

	public void setVlects(int vlects) {
		this.vlects = vlects;
	}

	public String getVlname() {
		return vlname;
	}

	public void setVlname(String vlname) {
		this.vlname = vlname;
	}

	public boolean isVlweight() {
		return vlweight;
	}

	public void setVlweight(boolean vlweight) {
		this.vlweight = vlweight;
	}
}
