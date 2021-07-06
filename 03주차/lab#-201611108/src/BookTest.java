import java.util.Scanner;

class Book{
	private String author;
	private String title;
	private int id;
	private static int indetification;
	public static int bookCount;
	public Book() {
		this("����", "����");
	}
	public Book(String title) {
		this(title, "��");
	}
	public Book(String title, String author) {
		this.title=title;
		this.author=author;
	}
	public static void decrease() {
		indetification--;
		bookCount--;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public void setAuthor(String author) {
		this.author=author;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getId() {
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof Book)) return false;
		Book b=(Book)obj;
		return author.equals(b.author) && title.equals(b.title);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Book No: "+id+", entitled \""+title+"\", written by "+author);
	}
	static {
		double ran=Math.random();
		indetification=(int)(ran*10000);
		bookCount = 0;
	}
	{
		indetification++;
		bookCount++;
		id=indetification;
	}
}

enum OperationKind {ADD, LIST, FIND, CLEAR, QUIT, INVALID} ;
public class BookTest {
	private static OperationKind getOperation(String operation) {
			OperationKind kind = OperationKind.INVALID ;
			if ( operation.equalsIgnoreCase("ADD"))
				kind = OperationKind.ADD ;
			else if ( operation.equalsIgnoreCase("LIST"))
				kind = OperationKind.LIST ;
			else if ( operation.equalsIgnoreCase("FIND"))
				kind = OperationKind.FIND ;
			else if ( operation.equalsIgnoreCase("CLEAR"))
				kind = OperationKind.CLEAR ;
			else if ( operation.equalsIgnoreCase("QUIT"))
				kind = OperationKind.QUIT ;
			return kind ;
	}
	public static void main(String[] args) {
	 	// TODO Auto-generated method stub
		Book[] Bookes=new Book[5];
		Book aBook;
		String title;
		String author;
		String op;
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<5;) {

			System.out.print("Enter Operation String!(ADD, LIST, FIND, QUIT)");
			op=scan.nextLine();
			OperationKind kind=getOperation(op);
			if(kind==kind.QUIT) break;
			System.out.println("------------------------------------");
			switch(kind)
			{
			case ADD:

				System.out.println("Type the title of the book: ");
				title=scan.nextLine();
				System.out.println("Type the name of thd author: ");
				author=scan.nextLine();
				Bookes[i]=new Book(title,author);
				System.out.println(Bookes[i]+"\nå�� �߰� �Ǿ����ϴ�.");
				i++;

				break;
			case LIST:
				System.out.println("Book List");
				System.out.println("----------------------------------------");
				for(int j=0;j<i;j++)
					System.out.println(Bookes[j]);
				System.out.println("----------------------------------------");
				System.out.println("�� "+ Book.bookCount+"��");
				break;
			case FIND:
				System.out.println("Type the title of the book: ");
				title=scan.nextLine();
				System.out.println("Type the name of thd author: ");
				author=scan.nextLine();
				aBook=new Book(title,author);
				Book.decrease();
				if(!(title.equals("")&&author.equals(""))) {
					boolean find=false;
					for(int j=0;j<i;j++)
					{
						if(Bookes[j].equals(aBook)) {
							System.out.println("�ش��ϴ� å�� �������� �����մϴ�.");
							find=true;
							break;
						}
					}
					if(find==false)
						System.out.println("ã�� å�� �����ϴ�.");
				}
			default:
				break;

			}//switch
		}//for
		System.out.println("----------------------------------------");
		System.out.println("���� ������ å ������ : "+Book.bookCount+"��") ;
		System.out.println("������ ���� å ����Ʈ");
		System.out.println("-----------------------------------------");
		for(int j=0;j<Book.bookCount;j++)
			System.out.println(Bookes[j]);
		System.out.println("----------------------------------------");
		
		int _id;
		System.out.println("���������� ���ϴ� å id�� �Է��ϼ���:");
		_id=scan.nextInt();
		for(int i=0; i<Book.bookCount; i++) {
			if (Bookes[i].getId()==_id) {
				@SuppressWarnings("resource")
				Scanner input=new Scanner(System.in);
				System.out.println("å�̸� : "+Bookes[i].getTitle());
				System.out.println("���� : "+Bookes[i].getAuthor());
				int choice;
				System.out.println("������ �κ��� ����(1: title, 2: author) :");
				choice=scan.nextInt();
				if (choice==1) {
					String ntitle;
					System.out.println("å�̸��Է�");
					ntitle=input.nextLine();
					Bookes[i].setTitle(ntitle);
				}
				else if (choice==2) {
					String nauthor;
					System.out.println("�����Է�");
					nauthor=input.nextLine();
					Bookes[i].setAuthor(nauthor);
				}
				else {System.out.println("�߸� �Է��ϼ̽��ϴ�.");}
				System.out.println(Bookes[i]+" <--������.");
			}
		}
	}
}
