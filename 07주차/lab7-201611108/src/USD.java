
public class USD extends Currency {
	private double dollar;
	public USD(int money) {
		super(money);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = String.format("%.1f dollar",dollar);
		return str;
	}
	public void setMoney(double _money) {
		dollar=_money;
	}
}
