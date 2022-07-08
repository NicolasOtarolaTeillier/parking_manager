
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
public static RemoteObject _label_main = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _name_db = RemoteObject.createImmutable("");
public static RemoteObject _tables_db = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _table_cars = RemoteObject.createImmutable("");
public static RemoteObject _customer_label_patent = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _customer_background = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _customer_text_patent = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _customer_button_patent = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _customer_delete_table = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _label_hour = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _labe_ = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label_minute = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _parked_listview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _parked_button = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _parked_today = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _parked_leave = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _parked_list = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _query_selector = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
public static RemoteObject _info_background = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _info_label_pay = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _info_label_time = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _info_label_end = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _info_label_start = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _info_label_date = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _info_label_patent = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label_patent = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label_date = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label_start = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label_end = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label_time = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label_pay = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label_id = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _info_button_pay = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _flag = RemoteObject.createImmutable(false);
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"customer_background",main.mostCurrent._customer_background,"customer_button_patent",main.mostCurrent._customer_button_patent,"customer_delete_table",main.mostCurrent._customer_delete_table,"customer_label_patent",main.mostCurrent._customer_label_patent,"customer_text_patent",main.mostCurrent._customer_text_patent,"flag",main._flag,"info_background",main.mostCurrent._info_background,"info_button_pay",main.mostCurrent._info_button_pay,"info_label_date",main.mostCurrent._info_label_date,"info_label_end",main.mostCurrent._info_label_end,"info_label_patent",main.mostCurrent._info_label_patent,"info_label_pay",main.mostCurrent._info_label_pay,"info_label_start",main.mostCurrent._info_label_start,"info_label_time",main.mostCurrent._info_label_time,"labe_",main.mostCurrent._labe_,"label_date",main.mostCurrent._label_date,"label_end",main.mostCurrent._label_end,"label_hour",main.mostCurrent._label_hour,"label_id",main.mostCurrent._label_id,"label_main",main.mostCurrent._label_main,"label_minute",main.mostCurrent._label_minute,"label_patent",main.mostCurrent._label_patent,"label_pay",main.mostCurrent._label_pay,"label_start",main.mostCurrent._label_start,"label_time",main.mostCurrent._label_time,"name_db",main.mostCurrent._name_db,"parked_button",main.mostCurrent._parked_button,"parked_leave",main.mostCurrent._parked_leave,"parked_list",main.mostCurrent._parked_list,"parked_listview",main.mostCurrent._parked_listview,"parked_today",main.mostCurrent._parked_today,"query_selector",main.mostCurrent._query_selector,"SQLite",main._sqlite,"TabHost1",main.mostCurrent._tabhost1,"table_cars",main.mostCurrent._table_cars,"tables_db",main.mostCurrent._tables_db,"xui",main._xui};
}
}