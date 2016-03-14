package timeServices;

/**
 * Generated from IDL interface "TimeServer".
 *
 * @author JacORB IDL compiler V 3.6.1
 * @version generated at 30-Oct-2015 17:18:23
 */

public final class TimeServerHolder	implements org.omg.CORBA.portable.Streamable{
	 public TimeServer value;
	public TimeServerHolder()
	{
	}
	public TimeServerHolder (final TimeServer initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return TimeServerHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = TimeServerHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		TimeServerHelper.write (_out,value);
	}
}
