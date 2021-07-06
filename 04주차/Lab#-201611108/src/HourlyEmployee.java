
public class HourlyEmployee extends Employee {
	private double basicPay;
	private double payRate;
	private int hoursWorked;
	public HourlyEmployee(String name, String address, String department, String contractexpdate, double basicPay, double payRate) //��ุ�ᳯ¥�� ���ؼ� ���� ���� �����Ƿ� �������� �ʰڽ��ϴ�.
	{
		super(name, address, department);
		this.basicPay=basicPay;
		this.payRate=payRate;
	}
	public double pay()
	{
		return basicPay+hoursWorked*payRate;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str=String.format("�̸� : "+name+"\n�ּ� : " + address+"\n�ҼӺμ� : "+department+"\n�ð��� �ӱ� : "+payRate+"\n�ٹ� �ð� : "+hoursWorked);
		return str;
	}
	public void addHours(int hours)
	{
		hoursWorked+=hours;
	}
}
