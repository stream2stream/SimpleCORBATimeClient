package timeServices;


/**
 * Generated from IDL interface "TimeServer".
 *
 * @author JacORB IDL compiler V 3.6.1
 * @version generated at 30-Oct-2015 17:18:23
 */

public abstract class TimeServerPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, timeServices.TimeServerOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "getJavaDateAndTime", Integer.valueOf(0));
	}
	private String[] ids = {"IDL:timeServices/TimeServer:1.0"};
	public timeServices.TimeServer _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		timeServices.TimeServer __r = timeServices.TimeServerHelper.narrow(__o);
		return __r;
	}
	public timeServices.TimeServer _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		timeServices.TimeServer __r = timeServices.TimeServerHelper.narrow(__o);
		return __r;
	}
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // getJavaDateAndTime
			{
				_out = handler.createReply();
				java.lang.String tmpResult0 = getJavaDateAndTime();
_out.write_string( tmpResult0 );
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
