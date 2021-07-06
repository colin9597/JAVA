
public class KRW extends Currency {
	private double won;
	public KRW(double money) {
		super(money);	
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = String.format("%.1f won",won);
		return str;
	}
	public void setMoney(double _money) {
		won=_money;
	}
}
