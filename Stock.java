/*  Zane Sanchez
	CS 2336
	Stock class
*/
public class Stock {
	String symbol;
	String name;
	double previousClosingPrice;
	double closingPrice;
	
	double getChangePercent(){
		return (((closingPrice-previousClosingPrice)/closingPrice)*100);
	}
	// Getters
	String getSymbol() {
		return symbol;
	}
	String getName() {
		return name;
	}
	double getPreviousClosingPrice(){
		return previousClosingPrice;
	}
	double getClosingPrice() {
		return closingPrice;
	}
	// Setters
	void setSymbol(String s){
		symbol =s;
	}
	void setName(String n ) {
		name = n;
	}
	void setPreviousClosingPrice(double PCP) {
		previousClosingPrice = PCP;
	}
	void setClosingPrice(double CP) {
		closingPrice = CP;
	}
	
	public Stock() {}
	public Stock(String s, String n) {
		symbol = s;
		name = n;
	}
	
	public static void main(String [] args) {
		Stock Oracle = new Stock("ORCL","Oracle Corporation");
		Oracle.setClosingPrice(34.35);
		Oracle.setPreviousClosingPrice(34.5);
		System.out.println(Oracle.getChangePercent()+"%");
	}
}
