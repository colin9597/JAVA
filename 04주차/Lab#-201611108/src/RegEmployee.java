
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
		String str=String.format("이름 : "+name+"\n주소 : " + address+"\n소속부서 : "+department+"\n직원번호 : "+empNumber+"\n직급 : "+rank+"\n연봉 : "+yearlySalary+"\n보너스 지급율 : "+bonusRate);
		return str;
	}
	
}
