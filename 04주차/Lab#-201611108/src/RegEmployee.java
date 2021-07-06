
public class RegEmployee extends Employee {
	private int empNumber;
	private String rank;
	private double yearlySalary;
	private double bonusRate;
	public RegEmployee(String name, String address, String department, int empNumber, String rank, double yearlySalary, double bonusRate)
	{
		super(name, address, department);
		this.empNumber=empNumber;
		this.rank=rank;
		this.yearlySalary=yearlySalary;
		this.bonusRate=bonusRate;
	}
	public double pay()
	{
		return yearlySalary*bonusRate;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str=String.format("�̸� : "+name+"\n�ּ� : " + address+"\n�ҼӺμ� : "+department+"\n������ȣ : "+empNumber+"\n���� : "+rank+"\n���� : "+yearlySalary+"\n���ʽ� ������ : "+bonusRate);
		return str;
	}
	
}
