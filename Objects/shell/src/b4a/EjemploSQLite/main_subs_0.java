package b4a.EjemploSQLite;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,47);
if (RapidSub.canDelegate("activity_create")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 47;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 49;BA.debugLine="Activity.LoadLayout(\"Main\")";
Debug.ShouldStop(65536);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Main")),main.mostCurrent.activityBA);
 BA.debugLineNum = 52;BA.debugLine="TabHost1.AddTab(\"Customer\",\"page_customer.bal\")";
Debug.ShouldStop(524288);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Customer")),(Object)(RemoteObject.createImmutable("page_customer.bal")));
 BA.debugLineNum = 53;BA.debugLine="TabHost1.AddTab(\"Parked\",\"page_parked.bal\")";
Debug.ShouldStop(1048576);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Parked")),(Object)(RemoteObject.createImmutable("page_parked.bal")));
 BA.debugLineNum = 54;BA.debugLine="TabHost1.AddTab(\"Info\",\"page_info.bal\")";
Debug.ShouldStop(2097152);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Info")),(Object)(RemoteObject.createImmutable("page_info.bal")));
 BA.debugLineNum = 57;BA.debugLine="name_db = \"parking_manager2.db\"";
Debug.ShouldStop(16777216);
main.mostCurrent._name_db = BA.ObjectToString("parking_manager2.db");
 BA.debugLineNum = 60;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(134217728);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 61;BA.debugLine="tables_db.Initialize";
Debug.ShouldStop(268435456);
main.mostCurrent._tables_db.runVoidMethod ("Initialize");
 BA.debugLineNum = 62;BA.debugLine="tables_db.AddAll(Array As String (\"cars\"))";
Debug.ShouldStop(536870912);
main.mostCurrent._tables_db.runVoidMethod ("AddAll",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.createImmutable("cars")})))));
 BA.debugLineNum = 63;BA.debugLine="table_cars = \"(id INTEGER PRIMARY KEY AUTOINCREM";
Debug.ShouldStop(1073741824);
main.mostCurrent._table_cars = BA.ObjectToString("(id INTEGER PRIMARY KEY AUTOINCREMENT, patent TEXT, date TEXT, hour TEXT, payment FLOAT)");
 BA.debugLineNum = 64;BA.debugLine="create_db(name_db,tables_db.Get(0), table_cars)";
Debug.ShouldStop(-2147483648);
_create_db(main.mostCurrent._name_db,BA.ObjectToString(main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),main.mostCurrent._table_cars);
 };
 BA.debugLineNum = 67;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,87);
if (RapidSub.canDelegate("activity_pause")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 87;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 89;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,83);
if (RapidSub.canDelegate("activity_resume")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 83;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(262144);
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("create_db (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,69);
if (RapidSub.canDelegate("create_db")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","create_db", _name, _table, _col);}
Debug.locals.put("name", _name);
Debug.locals.put("table", _table);
Debug.locals.put("col", _col);
 BA.debugLineNum = 69;BA.debugLine="Sub create_db (name As String, table As String, co";
Debug.ShouldStop(16);
 BA.debugLineNum = 70;BA.debugLine="SQLite.Initialize(File.DirInternal,name,True)";
Debug.ShouldStop(32);
main._sqlite.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_name),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 71;BA.debugLine="SQLite.BeginTransaction";
Debug.ShouldStop(64);
main._sqlite.runVoidMethod ("BeginTransaction");
 BA.debugLineNum = 72;BA.debugLine="Try";
Debug.ShouldStop(128);
try { BA.debugLineNum = 73;BA.debugLine="SQLite.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS";
Debug.ShouldStop(256);
main._sqlite.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("CREATE TABLE IF NOT EXISTS "),_table,RemoteObject.createImmutable(" "),_col)));
 BA.debugLineNum = 74;BA.debugLine="SQLite.TransactionSuccessful";
Debug.ShouldStop(512);
main._sqlite.runVoidMethod ("TransactionSuccessful");
 BA.debugLineNum = 75;BA.debugLine="ToastMessageShow(\"Successfully created '\"&table&";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Successfully created '"),_table,RemoteObject.createImmutable("' table")))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 77;BA.debugLine="ToastMessageShow(\"Table creation failed: \"&table";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Table creation failed: "),_table))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 78;BA.debugLine="Log(\"Table creation failed:\"&table&\", \"&LastExce";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2196617",RemoteObject.concat(RemoteObject.createImmutable("Table creation failed:"),_table,RemoteObject.createImmutable(", "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 };
 BA.debugLineNum = 80;BA.debugLine="SQLite.EndTransaction";
Debug.ShouldStop(32768);
main._sqlite.runVoidMethod ("EndTransaction");
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _customer_button_patent_click() throws Exception{
try {
		Debug.PushSubsStack("customer_button_patent_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,91);
if (RapidSub.canDelegate("customer_button_patent_click")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","customer_button_patent_click");}
RemoteObject _col = RemoteObject.createImmutable("");
RemoteObject _patent = RemoteObject.createImmutable("");
RemoteObject _date = RemoteObject.createImmutable("");
RemoteObject _hour = RemoteObject.createImmutable("");
RemoteObject _time = RemoteObject.createImmutable("");
 BA.debugLineNum = 91;BA.debugLine="Private Sub customer_button_patent_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 92;BA.debugLine="If customer_text_patent.Text = \"\" Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",main.mostCurrent._customer_text_patent.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 93;BA.debugLine="xui.MsgboxAsync(\"The patent does not exist, plea";
Debug.ShouldStop(268435456);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("The patent does not exist, please enter a patent.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Patent Error!"))));
 BA.debugLineNum = 94;BA.debugLine="Return";
Debug.ShouldStop(536870912);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 96;BA.debugLine="Dim col,patent,date,hour,time As String";
Debug.ShouldStop(-2147483648);
_col = RemoteObject.createImmutable("");Debug.locals.put("col", _col);
_patent = RemoteObject.createImmutable("");Debug.locals.put("patent", _patent);
_date = RemoteObject.createImmutable("");Debug.locals.put("date", _date);
_hour = RemoteObject.createImmutable("");Debug.locals.put("hour", _hour);
_time = RemoteObject.createImmutable("");Debug.locals.put("time", _time);
 BA.debugLineNum = 97;BA.debugLine="col = \"(patent, date, hour, payment)\"";
Debug.ShouldStop(1);
_col = BA.ObjectToString("(patent, date, hour, payment)");Debug.locals.put("col", _col);
 BA.debugLineNum = 98;BA.debugLine="time = DateTime.Now";
Debug.ShouldStop(2);
_time = BA.NumberToString(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));Debug.locals.put("time", _time);
 BA.debugLineNum = 99;BA.debugLine="patent = customer_text_patent.Text";
Debug.ShouldStop(4);
_patent = main.mostCurrent._customer_text_patent.runMethod(true,"getText");Debug.locals.put("patent", _patent);
 BA.debugLineNum = 100;BA.debugLine="date = DateTime.GetYear(time)&\"/\"&DateTime.GetMon";
Debug.ShouldStop(8);
_date = RemoteObject.concat(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("date", _date);
 BA.debugLineNum = 101;BA.debugLine="hour = DateTime.GetHour(time)&\":\"&DateTime.GetMin";
Debug.ShouldStop(16);
_hour = RemoteObject.concat(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable(":"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("hour", _hour);
 BA.debugLineNum = 102;BA.debugLine="insert_into_table(name_db,tables_db.Get(0),col,pa";
Debug.ShouldStop(32);
_insert_into_table(main.mostCurrent._name_db,BA.ObjectToString(main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),_col,_patent,_date,_hour,BA.NumberToString(0));
 BA.debugLineNum = 103;BA.debugLine="customer_text_patent.Text = \"\"";
Debug.ShouldStop(64);
main.mostCurrent._customer_text_patent.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 106;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
 //BA.debugLineNum = 31;BA.debugLine="Private customer_label_patent As Label";
main.mostCurrent._customer_label_patent = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private customer_background As Label";
main.mostCurrent._customer_background = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private customer_text_patent As EditText";
main.mostCurrent._customer_text_patent = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private customer_button_patent As Button";
main.mostCurrent._customer_button_patent = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private parked_listview As ListView";
main.mostCurrent._parked_listview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private parked_button As Button";
main.mostCurrent._parked_button = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private query_selector As Cursor";
main.mostCurrent._query_selector = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _insert_into_table(RemoteObject _name,RemoteObject _table,RemoteObject _col,RemoteObject _i1,RemoteObject _i2,RemoteObject _i3,RemoteObject _i4) throws Exception{
try {
		Debug.PushSubsStack("insert_into_table (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,108);
if (RapidSub.canDelegate("insert_into_table")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","insert_into_table", _name, _table, _col, _i1, _i2, _i3, _i4);}
Debug.locals.put("name", _name);
Debug.locals.put("table", _table);
Debug.locals.put("col", _col);
Debug.locals.put("i1", _i1);
Debug.locals.put("i2", _i2);
Debug.locals.put("i3", _i3);
Debug.locals.put("i4", _i4);
 BA.debugLineNum = 108;BA.debugLine="Sub insert_into_table (name As String,table As Str";
Debug.ShouldStop(2048);
 BA.debugLineNum = 110;BA.debugLine="SQLite.Initialize(File.DirInternal,name,True)";
Debug.ShouldStop(8192);
main._sqlite.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_name),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 111;BA.debugLine="SQLite.BeginTransaction";
Debug.ShouldStop(16384);
main._sqlite.runVoidMethod ("BeginTransaction");
 BA.debugLineNum = 112;BA.debugLine="Try";
Debug.ShouldStop(32768);
try { BA.debugLineNum = 113;BA.debugLine="SQLite.ExecNonQuery2(\"INSERT INTO \"&table&\" \"&co";
Debug.ShouldStop(65536);
main._sqlite.runVoidMethod ("ExecNonQuery2",(Object)(RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO "),_table,RemoteObject.createImmutable(" "),_col,RemoteObject.createImmutable(" VALUES (?,?,?,?)"))),(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {(_i1),(_i2),(_i3),(_i4)})))));
 BA.debugLineNum = 114;BA.debugLine="SQLite.TransactionSuccessful";
Debug.ShouldStop(131072);
main._sqlite.runVoidMethod ("TransactionSuccessful");
 BA.debugLineNum = 115;BA.debugLine="xui.MsgboxAsync(\"Patent: \"&i1&CRLF&\"Date: \"&i2&C";
Debug.ShouldStop(262144);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Patent: "),_i1,main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Date: "),_i2,main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Hour: "),_i3,main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Payment: "),_i4))),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Insert into: "),_table,RemoteObject.createImmutable(", successfully")))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 117;BA.debugLine="ToastMessageShow(\"Insert into failed: \"&table,Tr";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Insert into failed: "),_table))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 118;BA.debugLine="Log(\"Insert into failedd:\"&table&\", \"&LastExcept";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("LogImpl","21835018",RemoteObject.concat(RemoteObject.createImmutable("Insert into failedd:"),_table,RemoteObject.createImmutable(", "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 };
 BA.debugLineNum = 120;BA.debugLine="SQLite.EndTransaction";
Debug.ShouldStop(8388608);
main._sqlite.runVoidMethod ("EndTransaction");
 BA.debugLineNum = 121;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _parked_button_click() throws Exception{
try {
		Debug.PushSubsStack("parked_button_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,124);
if (RapidSub.canDelegate("parked_button_click")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","parked_button_click");}
int _i = 0;
RemoteObject _p = RemoteObject.createImmutable("");
RemoteObject _d = RemoteObject.createImmutable("");
RemoteObject _h = RemoteObject.createImmutable("");
 BA.debugLineNum = 124;BA.debugLine="Private Sub parked_button_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 125;BA.debugLine="query_selector=SQLite.ExecQuery(\"SELECT * FROM \"&";
Debug.ShouldStop(268435456);
main.mostCurrent._query_selector = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sqlite.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM "),main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" WHERE payment=0 ORDER BY id ASC")))));
 BA.debugLineNum = 126;BA.debugLine="parked_listview.clear";
Debug.ShouldStop(536870912);
main.mostCurrent._parked_listview.runVoidMethod ("Clear");
 BA.debugLineNum = 128;BA.debugLine="If query_selector.RowCount>0 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean(">",main.mostCurrent._query_selector.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 130;BA.debugLine="For i=0 To query_selector.RowCount-1";
Debug.ShouldStop(2);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._query_selector.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 131;BA.debugLine="query_selector.Position=i";
Debug.ShouldStop(4);
main.mostCurrent._query_selector.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 132;BA.debugLine="Dim p,d,h As String";
Debug.ShouldStop(8);
_p = RemoteObject.createImmutable("");Debug.locals.put("p", _p);
_d = RemoteObject.createImmutable("");Debug.locals.put("d", _d);
_h = RemoteObject.createImmutable("");Debug.locals.put("h", _h);
 BA.debugLineNum = 133;BA.debugLine="p=query_selector.GetString(\"patent\")";
Debug.ShouldStop(16);
_p = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("patent")));Debug.locals.put("p", _p);
 BA.debugLineNum = 134;BA.debugLine="d=query_selector.GetString(\"date\")";
Debug.ShouldStop(32);
_d = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date")));Debug.locals.put("d", _d);
 BA.debugLineNum = 135;BA.debugLine="h=query_selector.GetString(\"hour\")";
Debug.ShouldStop(64);
_h = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("hour")));Debug.locals.put("h", _h);
 BA.debugLineNum = 136;BA.debugLine="parked_listview.AddSingleLine(p&\"    \"&d&\"    \"";
Debug.ShouldStop(128);
main.mostCurrent._parked_listview.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(_p,RemoteObject.createImmutable("    "),_d,RemoteObject.createImmutable("    "),_h))));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 139;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

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
 //BA.debugLineNum = 17;BA.debugLine="Private SQLite As SQL";
main._sqlite = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}