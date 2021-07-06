
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
		String str=String.format("捞抚 : "+name+"\n林家 : " + address+"\n家加何辑 : "+department);
		return str;
	}
}
