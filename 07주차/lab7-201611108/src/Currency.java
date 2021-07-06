
public abstract class Currency {
	private double money;
	public Currency() {this.money=0;}
	public Currency(double money) {this.money=money;}
	public double getMoney() {return money;}
	public abstract void setMoney(double _money);
}
