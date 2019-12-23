import java.util.*;
class Days
{
	public static void main(String args[])
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the day number");
	int i=sc.nextInt();
	String[] day={"","sunday","monday","tuesday","wednesday","thursday","friday","saturday"};
	System.out.println("Day of the week is " +day[i]);
	}
}