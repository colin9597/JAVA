import java.util.Scanner;

public class ExchangeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exchangeable change=(a,b)->(a>b)?a:b;
		System.out.println(change.exchange(2,8));
		//Scanner input = new Scanner(System.in);
		/*while(true) {
			System.out.println("Choose Currency");
			System.out.println("1. KRW  2. USD");
			try{
				int choice=input.nextInt();
				ConditionCheck con = new ConditionCheck();
				con.setCondition(choice);
				if (choice==1) {
					System.out.println("Enter the amount");
					int money=input.nextInt();
					KRW k= new KRW(money);
					Exchangeable change=(m,i)->(int)m*1162;
					k.setMoney(change.exchange(k.getMoney(), choice));
					System.out.println("Exchange money : "+k);
				}
				else if (choice==2) {
					System.out.println("Enter the amount");
					int money=input.nextInt();
					USD u= new USD(money);
					Exchangeable change=(m,i)->(int)(m*0.00086);
					u.setMoney(change.exchange(u.getMoney(), choice));
					System.out.println("Exchange money : "+u);
				}
			}catch(ConditionException e) {
				System.out.println(e);
				break;
			}
		}*/
	}
}
