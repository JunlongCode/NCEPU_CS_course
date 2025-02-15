/*
	正确的程序
*/

import java.io.*;
import java.net.*;

public class TServer_4
{
	public static void main(String[] args)
	{
		ServerSocket ss = null;  
		Socket s = null;   
		DataInputStream dis = null;  			
		
		try
		{
			ss = new ServerSocket(8888);
			s = null;
			dis = null;		
			
			while (true)
			{
				s = ss.accept();
				dis = new DataInputStream(s.getInputStream());
				String str = dis.readUTF();
				System.out.println("对方说的是: " + str);
			}
		}
		catch (SocketException e)
		{
			System.out.println("网络连接出错，程序终止");
			System.exit(-1);
		}
		catch (IOException e)
		{
			System.out.println("读写数据出错，程序终止");
			System.exit(-1);
		}
		finally
		{
			try
			{
				dis.close();   
				s.close();     
				ss.close();   
			}
			catch (Exception e)
			{
			}
		}
	}
}