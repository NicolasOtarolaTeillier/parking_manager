package b4a.EjemploSQLite;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,32);
if (RapidSub.canDelegate("activity_create")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"Main\")";
Debug.ShouldStop(1);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Main")),main.mostCurrent.activityBA);
 BA.debugLineNum = 36;BA.debugLine="TabHost1.AddTab(\"Customer\",\"page_customer.bal\")";
Debug.ShouldStop(8);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Customer")),(Object)(RemoteObject.createImmutable("page_customer.bal")));
 BA.debugLineNum = 37;BA.debugLine="TabHost1.AddTab(\"Parked\",\"page_parked.bal\")";
Debug.ShouldStop(16);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Parked")),(Object)(RemoteObject.createImmutable("page_parked.bal")));
 BA.debugLineNum = 39;BA.debugLine="TabHost1.AddTab(\"Info\",\"page_info.bal\")";
Debug.ShouldStop(64);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Info")),(Object)(RemoteObject.createImmutable("page_info.bal")));
 BA.debugLineNum = 42;BA.debugLine="name_db = \"parking_manager.db\"";
Debug.ShouldStop(512);
main.mostCurrent._name_db = BA.ObjectToString("parking_manager.db");
 BA.debugLineNum = 45;BA.debugLine="tables_db.Initialize";
Debug.ShouldStop(4096);
main.mostCurrent._tables_db.runVoidMethod ("Initialize");
 BA.debugLineNum = 46;BA.debugLine="tables_db.AddAll(Array As String (\"cars\"))";
Debug.ShouldStop(8192);
main.mostCurrent._tables_db.runVoidMethod ("AddAll",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.createImmutable("cars")})))));
 BA.debugLineNum = 47;BA.debugLine="table_cars = \"(id INTEGER PRIMARY KEY AUTOINCREME";
Debug.ShouldStop(16384);
main.mostCurrent._table_cars = BA.ObjectToString("(id INTEGER PRIMARY KEY AUTOINCREMENT, patente TEXT, fecha TEXT, hora TEXT)");
 BA.debugLineNum = 48;BA.debugLine="create_db(name_db,tables_db.Get(0), table_cars)";
Debug.ShouldStop(32768);
_create_db(main.mostCurrent._name_db,BA.ObjectToString(main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),main.mostCurrent._table_cars);
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,72);
if (RapidSub.canDelegate("activity_pause")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 72;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,68);
if (RapidSub.canDelegate("activity_resume")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 68;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8);
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _create_db(RemoteObject _name,RemoteObject _table,RemoteObject _col) throws Exception{
try {
		Debug.PushSubsStack("create_db (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,51);
if (RapidSub.canDelegate("create_db")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","create_db", _name, _table, _col);}
Debug.locals.put("name", _name);
Debug.locals.put("table", _table);
Debug.locals.put("col", _col);
 BA.debugLineNum = 51;BA.debugLine="Sub create_db (name As String, table As String, co";
Debug.ShouldStop(262144);
 BA.debugLineNum = 52;BA.debugLine="Log(name)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2196609",_name,0);
 BA.debugLineNum = 53;BA.debugLine="Log(table)";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2196610",_table,0);
 BA.debugLineNum = 54;BA.debugLine="Log(col)";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2196611",_col,0);
 BA.debugLineNum = 55;BA.debugLine="DB.Initialize(File.DirInternal,name,True)";
Debug.ShouldStop(4194304);
main._db.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_name),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 56;BA.debugLine="DB.BeginTransaction";
Debug.ShouldStop(8388608);
main._db.runVoidMethod ("BeginTransaction");
 BA.debugLineNum = 57;BA.debugLine="Try";
Debug.ShouldStop(16777216);
try { BA.debugLineNum = 58;BA.debugLine="DB.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS \"&ta";
Debug.ShouldStop(33554432);
main._db.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("CREATE TABLE IF NOT EXISTS "),_table,RemoteObject.createImmutable(" "),_col)));
 BA.debugLineNum = 59;BA.debugLine="DB.TransactionSuccessful";
Debug.ShouldStop(67108864);
main._db.runVoidMethod ("TransactionSuccessful");
 BA.debugLineNum = 60;BA.debugLine="ToastMessageShow(\"Tabla: \"&table&\", creada\",Fals";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Tabla: "),_table,RemoteObject.createImmutable(", creada")))),(Object)(main.mostCurrent.__c.getField(true,"False")));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e11) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e11.toString()); BA.debugLineNum = 62;BA.debugLine="ToastMessageShow(\"Error en la creación de la Tab";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error en la creación de la Tabla: "),_table))),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 63;BA.debugLine="Log(\"ERROR en la creación de la tabla:\"&table&\",";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2196620",RemoteObject.concat(RemoteObject.createImmutable("ERROR en la creación de la tabla:"),_table,RemoteObject.createImmutable(", "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 };
 BA.debugLineNum = 65;BA.debugLine="DB.EndTransaction";
Debug.ShouldStop(1);
main._db.runVoidMethod ("EndTransaction");
 BA.debugLineNum = 66;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private TabHost1 As TabHost";
main.mostCurrent._tabhost1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.TabHostWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private name_db As String";
main.mostCurrent._name_db = RemoteObject.createImmutable("");
 //BA.debugLineNum = 27;BA.debugLine="Private tables_db  As List";
main.mostCurrent._tables_db = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 28;BA.debugLine="Private table_cars As String";
main.mostCurrent._table_cars = RemoteObject.createImmutable("");
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.EjemploSQLite.main");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 17;BA.debugLine="Private DB As SQL";
main._db = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}