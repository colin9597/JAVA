/* EmployeeDriver.java
 Employee, RegEmployee, TempEmployee, HourlyEmployee와 Intern 클래스를 시험하는
드라이버 프로그램이다.*/
class EmployeeDriver
{
	Employee[] employeeList;
	//-----------------------------------------------------------------
	// 직원들의 목록을 만든다
	//-----------------------------------------------------------------
	public EmployeeDriver()
	{
		employeeList = new Employee[4];
		employeeList[0] = new RegEmployee ("선미", "서소문 123", "마케팅", 9352345, "이사", 7000.0, 1.4);
		employeeList[1] = new RegEmployee ("종미", "대치 456", "인사", 9874321, "과장", 4000.0, 1.2);
		employeeList[2] = new HourlyEmployee ("단형", "유성 678", "기획", "07-07-31", 2000.0, 10.0);
		employeeList[3] = new HourlyEmployee ("범수", "신사 987", "총무", "08-12-31", 1600.0, 5.0);
		((HourlyEmployee)employeeList[2]).addHours (30);
		((HourlyEmployee)employeeList[3]).addHours (40);
		((HourlyEmployee)employeeList[2]).addHours (50);
		((HourlyEmployee)employeeList[3]).addHours (60);
		((HourlyEmployee)employeeList[2]).addHours (20);
		((HourlyEmployee)employeeList[3]).addHours (30);
	}
	//-----------------------------------------------------------------
	// 모든 직원들에게 봉급을 지불한다
	//-----------------------------------------------------------------
	public void payday ()
	{
		double amount;
		for (int count=0; count < employeeList.length; count++)
		{
			System.out.println (employeeList[count]);
			amount = employeeList[count].pay(); // polymorphic
			System.out.println ("지급액: " + amount);
			System.out.println ("-----------------------------------");
		}
	}
	//-----------------------------------------------------------------
	// 회사의 직원들을 만들고 그들에게 봉급을 지불한다.
	//-----------------------------------------------------------------
	public static void main (String[] args)
	{
		EmployeeDriver personnel = new EmployeeDriver();
		personnel.payday();
	}
	}