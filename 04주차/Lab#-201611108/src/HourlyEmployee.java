
public class HourlyEmployee extends Employee {
	private double basicPay;
	private double payRate;
	private int hoursWorked;
	public HourlyEmployee(String name, String address, String department, String contractexpdate, double basicPay, double payRate) //계약만료날짜에 대해선 따로 말이 없으므로 구현하지 않겠습니다.
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
		String str=String.format("이름 : "+name+"\n주소 : " + address+"\n소속부서 : "+department+"\n시간당 임금 : "+payRate+"\n근무 시간 : "+hoursWorked);
		return str;
	}
	public void addHours(int hours)
	{
		hoursWorked+=hours;
	}
}
