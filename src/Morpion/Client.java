import java.net.*;
import java.io.*;

public class Client
{
	private Socket toServer;

	public Client( String host)
	{		
		try
		{
			this.toServer = new Socket( host, 4660 );
		}
		catch( IOException e )
		{
			System.out.println("Erreur");
		}

	}
}
