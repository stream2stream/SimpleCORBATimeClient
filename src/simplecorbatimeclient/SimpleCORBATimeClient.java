/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecorbatimeclient;

import java.util.Properties;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Policy;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.*;
import timeServices.TimeServer;
import timeServices.TimeServerHelper;

/**
 *
 * @author Selvyn
 */
public class SimpleCORBATimeClient
{
    static private String  itsServerIdCommand = "-serverid:";
    static private String  itsServerId = "TimeServer";

    private String[] itsArgs;
    
    public  SimpleCORBATimeClient(String[] args)
    {
        itsArgs = args;
    }
    
    public  org.omg.CORBA.Object getService( String serviceName )
    {
        org.omg.CORBA.Object result = null;
        
        try
        {
            org.omg.CORBA.ORB its_ORB = null;

            Properties props = System.getProperties();
            props.put("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
            props.put("org.omg.CORBA.ORBSingletonClass", "org.jacorb.orb.ORBSingleton");
            System.setProperties(props);
            
            its_ORB = ORB.init(itsArgs, props); //props);
            
            POA its_rootPOA = POAHelper.narrow(its_ORB.resolve_initial_references("RootPOA"));

            // Going to try and use the TAO naming service...
            org.omg.CORBA.Object obj = its_ORB.resolve_initial_references( "NameService" );
            NamingContextExt its_NamingServer = NamingContextExtHelper.narrow( obj );

            if( its_NamingServer == null )
                System.out.println(" Can't bind to the Naming Service");
            else
                System.out.println(" Found Naming Service");

            NameComponent nc1 = new NameComponent(serviceName, "kernel object");
            NameComponent[] name1 = {nc1};
            result = its_NamingServer.resolve( name1 );

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return result;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        String str = "-ORBInitRef.NameService=corbaloc::localhost:2089/StandardNS/NameServer-POA/_root";
        String[] argStr = {str};
        
        for( int argv = 0; argv < args.length; argv++ )
        {
            int idx = args[argv].indexOf(itsServerIdCommand);
            if( idx > -1 )
            {
                String tempServerId = args[argv].substring(idx + itsServerIdCommand.length());
                if( tempServerId.length() > 0 )
                    itsServerId = tempServerId;
            }
        }

        SimpleCORBATimeClient client = new SimpleCORBATimeClient( args );
        
        TimeServer ts = TimeServerHelper.narrow( client.getService(itsServerId) );

        if( ts == null )
            System.out.println(" Can't bind to the Time Service");
        else
            System.out.println(" Found Time Service");

        System.out.println( ts.getJavaDateAndTime() );
        
    }
}
