package timeServices;


/**
 * Generated from IDL interface "TimeServer".
 *
 * @author JacORB IDL compiler V 3.6.1
 * @version generated at 30-Oct-2015 17:18:23
 */

public abstract class TimeServerHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(TimeServerHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:timeServices/TimeServer:1.0", "TimeServer");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final timeServices.TimeServer s)
	{
			any.insert_Object(s);
	}
	public static timeServices.TimeServer extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:timeServices/TimeServer:1.0";
	}
	public static TimeServer read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(timeServices._TimeServerStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final timeServices.TimeServer s)
	{
		_out.write_Object(s);
	}
	public static timeServices.TimeServer narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof timeServices.TimeServer)
		{
			return (timeServices.TimeServer)obj;
		}
		else if (obj._is_a("IDL:timeServices/TimeServer:1.0"))
		{
			timeServices._TimeServerStub stub;
			stub = new timeServices._TimeServerStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static timeServices.TimeServer unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof timeServices.TimeServer)
		{
			return (timeServices.TimeServer)obj;
		}
		else
		{
			timeServices._TimeServerStub stub;
			stub = new timeServices._TimeServerStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
