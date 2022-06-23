
package b4a.EjemploSQLite;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "b4a.EjemploSQLite.main");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _sqlite = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL");
public static RemoteObject _tabhost1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.TabHostWrapper");
public static RemoteObject _name_db = RemoteObject.createImmutable("");
public static RemoteObject _tables_db = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _table_cars = RemoteObject.createImmutable("");
public static RemoteObject _customer_label_patent = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _customer_background = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _customer_text_patent = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _customer_button_patent = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _parked_listview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _parked_button = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _query_selector = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"customer_background",main.mostCurrent._customer_background,"customer_button_patent",main.mostCurrent._customer_button_patent,"customer_label_patent",main.mostCurrent._customer_label_patent,"customer_text_patent",main.mostCurrent._customer_text_patent,"name_db",main.mostCurrent._name_db,"parked_button",main.mostCurrent._parked_button,"parked_listview",main.mostCurrent._parked_listview,"query_selector",main.mostCurrent._query_selector,"SQLite",main._sqlite,"TabHost1",main.mostCurrent._tabhost1,"table_cars",main.mostCurrent._table_cars,"tables_db",main.mostCurrent._tables_db,"xui",main._xui};
}
}