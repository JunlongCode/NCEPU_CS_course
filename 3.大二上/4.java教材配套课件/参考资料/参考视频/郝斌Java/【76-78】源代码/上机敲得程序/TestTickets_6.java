/*
	2009年6月22日9:28:08
	错误的程序:
		只有一个售票点在买票
	
*/

class A implements Runnable
{
	public int tickets = 100;
	String str = new String("哈哈");
		
	public void run()  
	{
		synchronized (str) 
		{
			while (true)
			{
				if (tickets > 0)
				{
					System.out.printf("%s线程正在卖出第%d张票\n",
						Thread.currentThread().getName(), tickets);
					--tickets;	
				}
				else
				{
					break;
				}
			}
		}
	}
}

public class TestTickets_6
{
	public static void main(String[] args)
	{
		A aa = new A();
		Thread t1 = new Thread(aa);
		t1.start();	
		
		Thread t2 = new Thread(aa);
		t2.start();	
			
	}
}