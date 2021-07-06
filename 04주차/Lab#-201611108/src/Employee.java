
public abstract class Employee {
	protected String name;
	protected String address;
	protected String department;
	public Employee(String name, String address, String department)
	{
		this.name=name;
		this.address=address;
		this.department=department;
	}
	public abstract double pay();
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str=String.format("�̸� : "+name+"\n�ּ� : " + address+"\n�ҼӺμ� : "+department);
		return str;
	}
}
