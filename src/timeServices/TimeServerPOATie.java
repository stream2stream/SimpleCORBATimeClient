package timeServices;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "TimeServer".
 *
 * @author JacORB IDL compiler V 3.6.1
 * @version generated at 30-Oct-2015 17:18:23
 */

public class TimeServerPOATie
	extends TimeServerPOA
{
	private TimeServerOperations _delegate;

	private POA _poa;
	public TimeServerPOATie(TimeServerOperations delegate)
	{
		_delegate = delegate;
	}
	public TimeServerPOATie(TimeServerOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
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
	public TimeServerOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(TimeServerOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		return super._default_POA();
	}
	public java.lang.String getJavaDateAndTime()
	{
		return _delegate.getJavaDateAndTime();
	}

}
