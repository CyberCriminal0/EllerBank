package EllerBank;

public class Account {

	private String firstN, lastN;
	private int accntNum;
	private double bal;
	private static int numAccnt;
	
	public Account(){
		numAccnt++;
		firstN="";
		lastN="";
		this.makeAccntNum();
		bal=0.0;
		
	}
	
	public Account(String f, String n){
		numAccnt++;
		firstN=f;
		lastN=n;
		this.makeAccntNum();
		
	}
	private String numAccnt(String f, String n){
		 String num;
		 
		 num=numAccnt+"";
		 
		 return num;
	}
	public void makeAccntNum(){
		int accnt;
		accnt = ((((int)(Math.random()*1000000)))+numAccnt);
		this.accntNum=accnt;
	}
	private String getFirstN() {
		return firstN;
	}

	private void setFirstN(String firstN) {
		this.firstN = firstN;
	}

	private String getLastN() {
		return lastN;
	}

	private void setLastN(String lastN) {
		this.lastN = lastN;
	}

	protected double getBal() {
		return bal;
	}

	private void setBal(double bal) {
		this.bal = bal;
	}

	protected int getAccntNum() {
		return accntNum;
	}

	public String toString(){
		String info;
		info=" First Name: \t"+this.getFirstN()+"\r Last Name: \t"+this.getLastN()+"\r Account Number: \t"+this.accntNum+"\r Balance: \t $"+this.getBal(); 
		return info;
	}
	
}
