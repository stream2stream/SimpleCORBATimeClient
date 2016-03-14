package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.Servant;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class IORStore
{
	private ORB itsORB;
	private POA itsPOA;

	public IORStore(ORB orb, POA poa) // must use if using bind()
	{
		itsORB = orb;
		itsPOA = poa;
	}

	public IORStore(ORB orb) // use only if using fetch()
	{
		itsORB = orb;
	}

	public void bind(Servant servant, String iorName)
	{
		// IOR will be written to file
		String ior;
		try
		{
			ior = itsORB.object_to_string(itsPOA.servant_to_reference(servant));
			FileWriter file = new java.io.FileWriter(iorName);
			PrintWriter pfile = new java.io.PrintWriter(file);
			pfile.println(ior);
			pfile.flush();
			pfile.close();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public org.omg.CORBA.Object fetch(String iorName)
	{
		String ior = null;
		try
		{
			// IOR will be read from file
			FileReader file = new java.io.FileReader(iorName);
			BufferedReader input = new java.io.BufferedReader(file);
			ior = input.readLine();
			input.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return itsORB.string_to_object(ior);
	}
}
