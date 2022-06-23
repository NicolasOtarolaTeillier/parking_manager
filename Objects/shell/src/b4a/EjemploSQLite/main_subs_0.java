package b4a.EjemploSQLite;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,64);
if (RapidSub.canDelegate("activity_create")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 64;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 66;BA.debugLine="Activity.LoadLayout(\"Main\")";
Debug.ShouldStop(2);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Main")),main.mostCurrent.activityBA);
 BA.debugLineNum = 69;BA.debugLine="TabHost1.AddTab(\"Customer\",\"page_customer.bal\")";
Debug.ShouldStop(16);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Customer")),(Object)(RemoteObject.createImmutable("page_customer.bal")));
 BA.debugLineNum = 70;BA.debugLine="TabHost1.AddTab(\"Parked\",\"page_parked.bal\")";
Debug.ShouldStop(32);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Parked")),(Object)(RemoteObject.createImmutable("page_parked.bal")));
 BA.debugLineNum = 71;BA.debugLine="TabHost1.AddTab(\"Info\",\"page_info.bal\")";
Debug.ShouldStop(64);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Info")),(Object)(RemoteObject.createImmutable("page_info.bal")));
 BA.debugLineNum = 74;BA.debugLine="name_db = \"parking_manager4.db\"";
Debug.ShouldStop(512);
main.mostCurrent._name_db = BA.ObjectToString("parking_manager4.db");
 BA.debugLineNum = 77;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(4096);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 78;BA.debugLine="tables_db.Initialize";
Debug.ShouldStop(8192);
main.mostCurrent._tables_db.runVoidMethod ("Initialize");
 BA.debugLineNum = 79;BA.debugLine="tables_db.AddAll(Array As String (\"cars\"))";
Debug.ShouldStop(16384);
main.mostCurrent._tables_db.runVoidMethod ("AddAll",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.createImmutable("cars")})))));
 BA.debugLineNum = 80;BA.debugLine="table_cars = \"(id INTEGER PRIMARY KEY AUTOINCREM";
Debug.ShouldStop(32768);
main.mostCurrent._table_cars = BA.ObjectToString("(id INTEGER PRIMARY KEY AUTOINCREMENT, patent TEXT, date TEXT, hour TEXT, end TEXT, time TEXT, payment FLOAT)");
 BA.debugLineNum = 81;BA.debugLine="create_db(name_db,tables_db.Get(0), table_cars)";
Debug.ShouldStop(65536);
_create_db(main.mostCurrent._name_db,BA.ObjectToString(main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),main.mostCurrent._table_cars);
 };
 BA.debugLineNum = 85;BA.debugLine="label_main.Text = \"Enter car patent\"";
Debug.ShouldStop(1048576);
main.mostCurrent._label_main.runMethod(true,"setText",BA.ObjectToCharSequence("Enter car patent"));
 BA.debugLineNum = 87;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,107);
if (RapidSub.canDelegate("activity_pause")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 107;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,103);
if (RapidSub.canDelegate("activity_resume")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 103;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(64);
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("create_db (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,89);
if (RapidSub.canDelegate("create_db")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","create_db", _name, _table, _col);}
Debug.locals.put("name", _name);
Debug.locals.put("table", _table);
Debug.locals.put("col", _col);
 BA.debugLineNum = 89;BA.debugLine="Sub create_db (name As String, table As String, co";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 90;BA.debugLine="SQLite.Initialize(File.DirInternal,name,True)";
Debug.ShouldStop(33554432);
main._sqlite.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_name),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 91;BA.debugLine="SQLite.BeginTransaction";
Debug.ShouldStop(67108864);
main._sqlite.runVoidMethod ("BeginTransaction");
 BA.debugLineNum = 92;BA.debugLine="Try";
Debug.ShouldStop(134217728);
try { BA.debugLineNum = 93;BA.debugLine="SQLite.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS";
Debug.ShouldStop(268435456);
main._sqlite.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("CREATE TABLE IF NOT EXISTS "),_table,RemoteObject.createImmutable(" "),_col)));
 BA.debugLineNum = 94;BA.debugLine="SQLite.TransactionSuccessful";
Debug.ShouldStop(536870912);
main._sqlite.runVoidMethod ("TransactionSuccessful");
 BA.debugLineNum = 95;BA.debugLine="ToastMessageShow(\"Successfully created '\"&table&";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Successfully created '"),_table,RemoteObject.createImmutable("' table")))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 97;BA.debugLine="ToastMessageShow(\"Table creation failed: \"&table";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Table creation failed: "),_table))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 98;BA.debugLine="Log(\"Table creation failed:\"&table&\", \"&LastExce";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("LogImpl","7196617",RemoteObject.concat(RemoteObject.createImmutable("Table creation failed:"),_table,RemoteObject.createImmutable(", "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 };
 BA.debugLineNum = 100;BA.debugLine="SQLite.EndTransaction";
Debug.ShouldStop(8);
main._sqlite.runVoidMethod ("EndTransaction");
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("customer_button_patent_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,111);
if (RapidSub.canDelegate("customer_button_patent_click")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","customer_button_patent_click");}
RemoteObject _col = RemoteObject.createImmutable("");
RemoteObject _patent = RemoteObject.createImmutable("");
RemoteObject _date = RemoteObject.createImmutable("");
RemoteObject _hour = RemoteObject.createImmutable("");
RemoteObject _time = RemoteObject.createImmutable("");
 BA.debugLineNum = 111;BA.debugLine="Private Sub customer_button_patent_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 112;BA.debugLine="If customer_text_patent.Text = \"\" Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",main.mostCurrent._customer_text_patent.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 113;BA.debugLine="xui.MsgboxAsync(\"The patent does not exist, plea";
Debug.ShouldStop(65536);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("The patent does not exist, please enter a patent.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Patent Error!"))));
 BA.debugLineNum = 114;BA.debugLine="Return";
Debug.ShouldStop(131072);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 116;BA.debugLine="Dim col,patent,date,hour,time As String";
Debug.ShouldStop(524288);
_col = RemoteObject.createImmutable("");Debug.locals.put("col", _col);
_patent = RemoteObject.createImmutable("");Debug.locals.put("patent", _patent);
_date = RemoteObject.createImmutable("");Debug.locals.put("date", _date);
_hour = RemoteObject.createImmutable("");Debug.locals.put("hour", _hour);
_time = RemoteObject.createImmutable("");Debug.locals.put("time", _time);
 BA.debugLineNum = 117;BA.debugLine="col = \"(patent, date, hour, end, time, payment)\"";
Debug.ShouldStop(1048576);
_col = BA.ObjectToString("(patent, date, hour, end, time, payment)");Debug.locals.put("col", _col);
 BA.debugLineNum = 118;BA.debugLine="time = DateTime.Now";
Debug.ShouldStop(2097152);
_time = BA.NumberToString(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));Debug.locals.put("time", _time);
 BA.debugLineNum = 119;BA.debugLine="patent = customer_text_patent.Text";
Debug.ShouldStop(4194304);
_patent = main.mostCurrent._customer_text_patent.runMethod(true,"getText");Debug.locals.put("patent", _patent);
 BA.debugLineNum = 120;BA.debugLine="date = DateTime.GetYear(time)&\"/\"&DateTime.GetMon";
Debug.ShouldStop(8388608);
_date = RemoteObject.concat(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("date", _date);
 BA.debugLineNum = 122;BA.debugLine="If DateTime.GetMinute(time).As(Int) <= 9 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("k",(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time)))),BA.numberCast(double.class, 9))) { 
 BA.debugLineNum = 123;BA.debugLine="hour = DateTime.GetHour(time)&\":0\"&DateTime.GetM";
Debug.ShouldStop(67108864);
_hour = RemoteObject.concat(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable(":0"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("hour", _hour);
 }else {
 BA.debugLineNum = 125;BA.debugLine="hour = DateTime.GetHour(time)&\":\"&DateTime.GetMi";
Debug.ShouldStop(268435456);
_hour = RemoteObject.concat(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable(":"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("hour", _hour);
 };
 BA.debugLineNum = 127;BA.debugLine="insert_into_table(name_db,tables_db.Get(0),col,pa";
Debug.ShouldStop(1073741824);
_insert_into_table(main.mostCurrent._name_db,BA.ObjectToString(main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),_col,_patent,_date,_hour,BA.ObjectToString(""),BA.ObjectToString(""),BA.NumberToString(0));
 BA.debugLineNum = 128;BA.debugLine="customer_text_patent.Text = \"\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._customer_text_patent.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 130;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _customer_delete_table_click() throws Exception{
try {
		Debug.PushSubsStack("customer_delete_table_click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,224);
if (RapidSub.canDelegate("customer_delete_table_click")) { b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","customer_delete_table_click"); return;}
ResumableSub_customer_delete_table_click rsub = new ResumableSub_customer_delete_table_click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_customer_delete_table_click extends BA.ResumableSub {
public ResumableSub_customer_delete_table_click(b4a.EjemploSQLite.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.EjemploSQLite.main parent;
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("customer_delete_table_click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,224);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 225;BA.debugLine="Msgbox2Async(\"¿Desea borrar la tabla \"&tables_db.";
Debug.ShouldStop(1);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("¿Desea borrar la tabla "),parent.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable("?")))),(Object)(BA.ObjectToCharSequence("Atención!")),(Object)(BA.ObjectToString("Si")),(Object)(BA.ObjectToString("Cancelar")),(Object)(BA.ObjectToString("No")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 226;BA.debugLine="Wait For Msgbox_Result(Result As Int)";
Debug.ShouldStop(2);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "customer_delete_table_click"), null);
this.state = 11;
return;
case 11:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 227;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(4);
if (true) break;

case 1:
//if
this.state = 10;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 229;BA.debugLine="SQLite.Initialize(File.DirInternal,name_db,True)";
Debug.ShouldStop(16);
parent._sqlite.runVoidMethod ("Initialize",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(parent.mostCurrent._name_db),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 232;BA.debugLine="SQLite.BeginTransaction";
Debug.ShouldStop(128);
parent._sqlite.runVoidMethod ("BeginTransaction");
 BA.debugLineNum = 233;BA.debugLine="Try";
Debug.ShouldStop(256);
if (true) break;

case 4:
//try
this.state = 9;
this.catchState = 8;
this.state = 6;
if (true) break;

case 6:
//C
this.state = 9;
this.catchState = 8;
 BA.debugLineNum = 234;BA.debugLine="SQLite.ExecNonQuery(\"DELETE FROM \"&tables_db.Ge";
Debug.ShouldStop(512);
parent._sqlite.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("DELETE FROM "),parent.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))));
 BA.debugLineNum = 236;BA.debugLine="ToastMessageShow(\"Registros de la tabla: \"&tabl";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Registros de la tabla: "),parent.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(", eliminados")))),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 237;BA.debugLine="SQLite.TransactionSuccessful";
Debug.ShouldStop(4096);
parent._sqlite.runVoidMethod ("TransactionSuccessful");
 Debug.CheckDeviceExceptions();
if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 0;
 BA.debugLineNum = 239;BA.debugLine="Log(\"ERROR al elminar tabla: \"&tables_db.Get(0)";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","7655375",RemoteObject.concat(RemoteObject.createImmutable("ERROR al elminar tabla: "),parent.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" ,"),parent.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 if (true) break;
if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 0;
;
 BA.debugLineNum = 241;BA.debugLine="SQLite.EndTransaction";
Debug.ShouldStop(65536);
parent._sqlite.runVoidMethod ("EndTransaction");
 if (true) break;

case 10:
//C
this.state = -1;
;
 BA.debugLineNum = 247;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e0.toString());}
            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _msgbox_result(RemoteObject _result) throws Exception{
}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private TabHost1 As TabHost";
main.mostCurrent._tabhost1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.TabHostWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private label_main As Label";
main.mostCurrent._label_main = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private name_db As String";
main.mostCurrent._name_db = RemoteObject.createImmutable("");
 //BA.debugLineNum = 28;BA.debugLine="Private tables_db  As List";
main.mostCurrent._tables_db = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 29;BA.debugLine="Private table_cars As String";
main.mostCurrent._table_cars = RemoteObject.createImmutable("");
 //BA.debugLineNum = 32;BA.debugLine="Private customer_label_patent As Label";
main.mostCurrent._customer_label_patent = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private customer_background As Label";
main.mostCurrent._customer_background = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private customer_text_patent As EditText";
main.mostCurrent._customer_text_patent = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private customer_button_patent As Button";
main.mostCurrent._customer_button_patent = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private customer_delete_table As Button";
main.mostCurrent._customer_delete_table = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private parked_listview As ListView";
main.mostCurrent._parked_listview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private parked_button As Button";
main.mostCurrent._parked_button = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private parked_today As Button";
main.mostCurrent._parked_today = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private parked_leave As Button";
main.mostCurrent._parked_leave = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private query_selector As Cursor";
main.mostCurrent._query_selector = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private info_background As Label";
main.mostCurrent._info_background = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private info_label_pay As Label";
main.mostCurrent._info_label_pay = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private info_label_time As Label";
main.mostCurrent._info_label_time = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private info_label_end As Label";
main.mostCurrent._info_label_end = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private info_label_start As Label";
main.mostCurrent._info_label_start = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private info_label_date As Label";
main.mostCurrent._info_label_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private info_label_patent As Label";
main.mostCurrent._info_label_patent = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private label_patent As Label";
main.mostCurrent._label_patent = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private label_date As Label";
main.mostCurrent._label_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private label_start As Label";
main.mostCurrent._label_start = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private label_end As Label";
main.mostCurrent._label_end = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private label_time As Label";
main.mostCurrent._label_time = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private label_pay As Label";
main.mostCurrent._label_pay = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private label_id As Label";
main.mostCurrent._label_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private info_button_pay As Button";
main.mostCurrent._info_button_pay = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _info_button_pay_click() throws Exception{
try {
		Debug.PushSubsStack("info_button_pay_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,249);
if (RapidSub.canDelegate("info_button_pay_click")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","info_button_pay_click");}
RemoteObject _pat = RemoteObject.createImmutable("");
RemoteObject _dat = RemoteObject.createImmutable("");
RemoteObject _sta = RemoteObject.createImmutable("");
RemoteObject _en = RemoteObject.createImmutable("");
RemoteObject _tim = RemoteObject.createImmutable("");
RemoteObject _pay = RemoteObject.createImmutable("");
RemoteObject _id = RemoteObject.createImmutable("");
 BA.debugLineNum = 249;BA.debugLine="Private Sub info_button_pay_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 250;BA.debugLine="If label_patent.Text = \"\" Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",main.mostCurrent._label_patent.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 251;BA.debugLine="xui.MsgboxAsync(\"The patent does not exist, plea";
Debug.ShouldStop(67108864);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("The patent does not exist, please enter a patent.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Patent Error!"))));
 BA.debugLineNum = 252;BA.debugLine="Return";
Debug.ShouldStop(134217728);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 254;BA.debugLine="Dim pat,dat,sta,en,tim,pay,id As String";
Debug.ShouldStop(536870912);
_pat = RemoteObject.createImmutable("");Debug.locals.put("pat", _pat);
_dat = RemoteObject.createImmutable("");Debug.locals.put("dat", _dat);
_sta = RemoteObject.createImmutable("");Debug.locals.put("sta", _sta);
_en = RemoteObject.createImmutable("");Debug.locals.put("en", _en);
_tim = RemoteObject.createImmutable("");Debug.locals.put("tim", _tim);
_pay = RemoteObject.createImmutable("");Debug.locals.put("pay", _pay);
_id = RemoteObject.createImmutable("");Debug.locals.put("id", _id);
 BA.debugLineNum = 255;BA.debugLine="id = label_id.Text";
Debug.ShouldStop(1073741824);
_id = main.mostCurrent._label_id.runMethod(true,"getText");Debug.locals.put("id", _id);
 BA.debugLineNum = 256;BA.debugLine="pat = label_patent.Text";
Debug.ShouldStop(-2147483648);
_pat = main.mostCurrent._label_patent.runMethod(true,"getText");Debug.locals.put("pat", _pat);
 BA.debugLineNum = 257;BA.debugLine="dat = label_date.Text";
Debug.ShouldStop(1);
_dat = main.mostCurrent._label_date.runMethod(true,"getText");Debug.locals.put("dat", _dat);
 BA.debugLineNum = 258;BA.debugLine="sta = label_start.Text";
Debug.ShouldStop(2);
_sta = main.mostCurrent._label_start.runMethod(true,"getText");Debug.locals.put("sta", _sta);
 BA.debugLineNum = 259;BA.debugLine="en = label_end.Text";
Debug.ShouldStop(4);
_en = main.mostCurrent._label_end.runMethod(true,"getText");Debug.locals.put("en", _en);
 BA.debugLineNum = 260;BA.debugLine="tim = label_time.Tag";
Debug.ShouldStop(8);
_tim = BA.ObjectToString(main.mostCurrent._label_time.runMethod(false,"getTag"));Debug.locals.put("tim", _tim);
 BA.debugLineNum = 261;BA.debugLine="pay = label_pay.Tag.As(Float)";
Debug.ShouldStop(16);
_pay = BA.NumberToString((BA.numberCast(float.class, main.mostCurrent._label_pay.runMethod(false,"getTag"))));Debug.locals.put("pay", _pay);
 BA.debugLineNum = 262;BA.debugLine="update_record(name_db,tables_db.Get(0),en,tim,pay";
Debug.ShouldStop(32);
_update_record(main.mostCurrent._name_db,BA.ObjectToString(main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),_en,_tim,BA.numberCast(float.class, _pay),_id);
 BA.debugLineNum = 263;BA.debugLine="label_id.Text = \"\"";
Debug.ShouldStop(64);
main.mostCurrent._label_id.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 264;BA.debugLine="label_patent.Text = \"\"";
Debug.ShouldStop(128);
main.mostCurrent._label_patent.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 265;BA.debugLine="label_date.Text = \"\"";
Debug.ShouldStop(256);
main.mostCurrent._label_date.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 266;BA.debugLine="label_start.Text = \"\"";
Debug.ShouldStop(512);
main.mostCurrent._label_start.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 267;BA.debugLine="label_end.Text = \"\"";
Debug.ShouldStop(1024);
main.mostCurrent._label_end.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 268;BA.debugLine="label_time.Tag = \"\"";
Debug.ShouldStop(2048);
main.mostCurrent._label_time.runMethod(false,"setTag",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 269;BA.debugLine="label_time.Text = \"0 minutes\"";
Debug.ShouldStop(4096);
main.mostCurrent._label_time.runMethod(true,"setText",BA.ObjectToCharSequence("0 minutes"));
 BA.debugLineNum = 270;BA.debugLine="label_pay.Tag = \"\"";
Debug.ShouldStop(8192);
main.mostCurrent._label_pay.runMethod(false,"setTag",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 271;BA.debugLine="label_pay.Text = \"$ 0\"";
Debug.ShouldStop(16384);
main.mostCurrent._label_pay.runMethod(true,"setText",BA.ObjectToCharSequence("$ 0"));
 BA.debugLineNum = 273;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _insert_into_table(RemoteObject _name,RemoteObject _table,RemoteObject _col,RemoteObject _i1,RemoteObject _i2,RemoteObject _i3,RemoteObject _i4,RemoteObject _i5,RemoteObject _i6) throws Exception{
try {
		Debug.PushSubsStack("insert_into_table (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,132);
if (RapidSub.canDelegate("insert_into_table")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","insert_into_table", _name, _table, _col, _i1, _i2, _i3, _i4, _i5, _i6);}
Debug.locals.put("name", _name);
Debug.locals.put("table", _table);
Debug.locals.put("col", _col);
Debug.locals.put("i1", _i1);
Debug.locals.put("i2", _i2);
Debug.locals.put("i3", _i3);
Debug.locals.put("i4", _i4);
Debug.locals.put("i5", _i5);
Debug.locals.put("i6", _i6);
 BA.debugLineNum = 132;BA.debugLine="Sub insert_into_table (name As String,table As Str";
Debug.ShouldStop(8);
 BA.debugLineNum = 134;BA.debugLine="SQLite.Initialize(File.DirInternal,name,True)";
Debug.ShouldStop(32);
main._sqlite.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_name),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 135;BA.debugLine="SQLite.BeginTransaction";
Debug.ShouldStop(64);
main._sqlite.runVoidMethod ("BeginTransaction");
 BA.debugLineNum = 136;BA.debugLine="Try";
Debug.ShouldStop(128);
try { BA.debugLineNum = 137;BA.debugLine="SQLite.ExecNonQuery2(\"INSERT INTO \"&table&\" \"&co";
Debug.ShouldStop(256);
main._sqlite.runVoidMethod ("ExecNonQuery2",(Object)(RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO "),_table,RemoteObject.createImmutable(" "),_col,RemoteObject.createImmutable(" VALUES (?,?,?,?,?,?)"))),(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {6},new Object[] {(_i1.runMethod(true,"toUpperCase")),(_i2),(_i3),(_i4),(_i5),(_i6)})))));
 BA.debugLineNum = 138;BA.debugLine="SQLite.TransactionSuccessful";
Debug.ShouldStop(512);
main._sqlite.runVoidMethod ("TransactionSuccessful");
 BA.debugLineNum = 139;BA.debugLine="xui.MsgboxAsync(\"Patent: \"&i1.ToUpperCase&CRLF&\"";
Debug.ShouldStop(1024);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Patent: "),_i1.runMethod(true,"toUpperCase"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Date: "),_i2,main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Hour: "),_i3,main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("End: "),_i4,main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Time: "),_i5,main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Payment: "),_i6))),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Insert into: "),_table,RemoteObject.createImmutable(", successfully")))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 141;BA.debugLine="ToastMessageShow(\"Insert into failed: \"&table,Tr";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Insert into failed: "),_table))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 142;BA.debugLine="Log(\"Insert into failedd:\"&table&\", \"&LastExcept";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("LogImpl","7458762",RemoteObject.concat(RemoteObject.createImmutable("Insert into failedd:"),_table,RemoteObject.createImmutable(", "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 };
 BA.debugLineNum = 144;BA.debugLine="SQLite.EndTransaction";
Debug.ShouldStop(32768);
main._sqlite.runVoidMethod ("EndTransaction");
 BA.debugLineNum = 145;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("parked_button_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,148);
if (RapidSub.canDelegate("parked_button_click")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","parked_button_click");}
int _i = 0;
RemoteObject _p = RemoteObject.createImmutable("");
RemoteObject _d = RemoteObject.createImmutable("");
RemoteObject _h = RemoteObject.createImmutable("");
 BA.debugLineNum = 148;BA.debugLine="Private Sub parked_button_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 149;BA.debugLine="query_selector=SQLite.ExecQuery(\"SELECT * FROM \"&";
Debug.ShouldStop(1048576);
main.mostCurrent._query_selector = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sqlite.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM "),main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" WHERE payment=0 ORDER BY patent ASC")))));
 BA.debugLineNum = 150;BA.debugLine="parked_listview.clear";
Debug.ShouldStop(2097152);
main.mostCurrent._parked_listview.runVoidMethod ("Clear");
 BA.debugLineNum = 151;BA.debugLine="If query_selector.RowCount>0 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean(">",main.mostCurrent._query_selector.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 153;BA.debugLine="For i=0 To query_selector.RowCount-1";
Debug.ShouldStop(16777216);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._query_selector.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 154;BA.debugLine="query_selector.Position=i";
Debug.ShouldStop(33554432);
main.mostCurrent._query_selector.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 155;BA.debugLine="Dim p,d,h As String";
Debug.ShouldStop(67108864);
_p = RemoteObject.createImmutable("");Debug.locals.put("p", _p);
_d = RemoteObject.createImmutable("");Debug.locals.put("d", _d);
_h = RemoteObject.createImmutable("");Debug.locals.put("h", _h);
 BA.debugLineNum = 156;BA.debugLine="p=query_selector.GetString(\"patent\")";
Debug.ShouldStop(134217728);
_p = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("patent")));Debug.locals.put("p", _p);
 BA.debugLineNum = 157;BA.debugLine="d=query_selector.GetString(\"date\")";
Debug.ShouldStop(268435456);
_d = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date")));Debug.locals.put("d", _d);
 BA.debugLineNum = 158;BA.debugLine="h=query_selector.GetString(\"hour\")";
Debug.ShouldStop(536870912);
_h = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("hour")));Debug.locals.put("h", _h);
 BA.debugLineNum = 159;BA.debugLine="parked_listview.AddSingleLine(p&\" \"&d&\" \"&h)";
Debug.ShouldStop(1073741824);
main.mostCurrent._parked_listview.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(_p,RemoteObject.createImmutable(" "),_d,RemoteObject.createImmutable(" "),_h))));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 162;BA.debugLine="label_main.Text = \"List of cars parked\"";
Debug.ShouldStop(2);
main.mostCurrent._label_main.runMethod(true,"setText",BA.ObjectToCharSequence("List of cars parked"));
 BA.debugLineNum = 163;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _parked_leave_click() throws Exception{
try {
		Debug.PushSubsStack("parked_leave_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,307);
if (RapidSub.canDelegate("parked_leave_click")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","parked_leave_click");}
RemoteObject _time = RemoteObject.createImmutable("");
RemoteObject _da = RemoteObject.createImmutable("");
int _i = 0;
RemoteObject _p = RemoteObject.createImmutable("");
RemoteObject _d = RemoteObject.createImmutable("");
RemoteObject _h = RemoteObject.createImmutable("");
RemoteObject _pay = RemoteObject.createImmutable("");
 BA.debugLineNum = 307;BA.debugLine="Private Sub parked_leave_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 308;BA.debugLine="Dim time,da As String";
Debug.ShouldStop(524288);
_time = RemoteObject.createImmutable("");Debug.locals.put("time", _time);
_da = RemoteObject.createImmutable("");Debug.locals.put("da", _da);
 BA.debugLineNum = 309;BA.debugLine="time = DateTime.Now";
Debug.ShouldStop(1048576);
_time = BA.NumberToString(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));Debug.locals.put("time", _time);
 BA.debugLineNum = 310;BA.debugLine="da = DateTime.GetYear(time)&\"/\"&DateTime.GetMonth";
Debug.ShouldStop(2097152);
_da = RemoteObject.concat(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("da", _da);
 BA.debugLineNum = 313;BA.debugLine="query_selector=SQLite.ExecQuery(\"SELECT * FROM \"&";
Debug.ShouldStop(16777216);
main.mostCurrent._query_selector = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sqlite.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM "),main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" WHERE date='"),_da,RemoteObject.createImmutable("' and payment > 0 ORDER BY patent ASC")))));
 BA.debugLineNum = 314;BA.debugLine="parked_listview.clear";
Debug.ShouldStop(33554432);
main.mostCurrent._parked_listview.runVoidMethod ("Clear");
 BA.debugLineNum = 315;BA.debugLine="If query_selector.RowCount>0 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean(">",main.mostCurrent._query_selector.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 317;BA.debugLine="For i=0 To query_selector.RowCount-1";
Debug.ShouldStop(268435456);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._query_selector.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 318;BA.debugLine="query_selector.Position=i";
Debug.ShouldStop(536870912);
main.mostCurrent._query_selector.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 319;BA.debugLine="Dim p,d,h,pay As String";
Debug.ShouldStop(1073741824);
_p = RemoteObject.createImmutable("");Debug.locals.put("p", _p);
_d = RemoteObject.createImmutable("");Debug.locals.put("d", _d);
_h = RemoteObject.createImmutable("");Debug.locals.put("h", _h);
_pay = RemoteObject.createImmutable("");Debug.locals.put("pay", _pay);
 BA.debugLineNum = 320;BA.debugLine="p=query_selector.GetString(\"patent\")";
Debug.ShouldStop(-2147483648);
_p = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("patent")));Debug.locals.put("p", _p);
 BA.debugLineNum = 321;BA.debugLine="d=query_selector.GetString(\"date\")";
Debug.ShouldStop(1);
_d = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date")));Debug.locals.put("d", _d);
 BA.debugLineNum = 322;BA.debugLine="h=query_selector.GetString(\"hour\")";
Debug.ShouldStop(2);
_h = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("hour")));Debug.locals.put("h", _h);
 BA.debugLineNum = 323;BA.debugLine="pay=query_selector.GetString(\"payment\")";
Debug.ShouldStop(4);
_pay = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("payment")));Debug.locals.put("pay", _pay);
 BA.debugLineNum = 324;BA.debugLine="parked_listview.AddSingleLine(p&\" \"&d&\" \"&h&\" \"";
Debug.ShouldStop(8);
main.mostCurrent._parked_listview.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(_p,RemoteObject.createImmutable(" "),_d,RemoteObject.createImmutable(" "),_h,RemoteObject.createImmutable(" "),_pay))));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 327;BA.debugLine="label_main.Text = \"List of cars leave parked toda";
Debug.ShouldStop(64);
main.mostCurrent._label_main.runMethod(true,"setText",BA.ObjectToCharSequence("List of cars leave parked today"));
 BA.debugLineNum = 328;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _parked_listview_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("parked_listview_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,165);
if (RapidSub.canDelegate("parked_listview_itemclick")) { b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","parked_listview_itemclick", _position, _value); return;}
ResumableSub_parked_listview_ItemClick rsub = new ResumableSub_parked_listview_ItemClick(null,_position,_value);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_parked_listview_ItemClick extends BA.ResumableSub {
public ResumableSub_parked_listview_ItemClick(b4a.EjemploSQLite.main parent,RemoteObject _position,RemoteObject _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.EjemploSQLite.main parent;
RemoteObject _position;
RemoteObject _value;
RemoteObject _sf = RemoteObject.declareNull("Object");
RemoteObject _result = RemoteObject.createImmutable(0);
RemoteObject _time = RemoteObject.createImmutable("");
RemoteObject _mi = RemoteObject.createImmutable(0);
RemoteObject _ho = RemoteObject.createImmutable(0);
RemoteObject _ti = RemoteObject.createImmutable(0);
RemoteObject _da = RemoteObject.createImmutable("");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("parked_listview_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,165);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 167;BA.debugLine="query_selector.Position=Position";
Debug.ShouldStop(64);
parent.mostCurrent._query_selector.runMethod(true,"setPosition",_position);
 BA.debugLineNum = 168;BA.debugLine="If query_selector.GetString(\"payment\") <> 0 Then";
Debug.ShouldStop(128);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("!",parent.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("payment"))),BA.NumberToString(0))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 169;BA.debugLine="Return";
Debug.ShouldStop(256);
if (true) return ;
 if (true) break;

case 4:
//C
this.state = 5;
;
 BA.debugLineNum = 172;BA.debugLine="Dim sf As Object = Msgbox2Async(\"Press YES to ace";
Debug.ShouldStop(2048);
_sf = parent.mostCurrent.__c.runMethod(false,"Msgbox2Async",(Object)(BA.ObjectToCharSequence("Press YES to acept or NO to decline")),(Object)(BA.ObjectToCharSequence("Do you want to pay?")),(Object)(BA.ObjectToString("YES")),(Object)(BA.ObjectToString("CANCEL")),(Object)(BA.ObjectToString("NO")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(parent.mostCurrent.__c.getField(true,"True")));Debug.locals.put("sf", _sf);Debug.locals.put("sf", _sf);
 BA.debugLineNum = 173;BA.debugLine="Wait For (sf) Msgbox_Result (Result As Int)";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "parked_listview_itemclick"), _sf);
this.state = 39;
return;
case 39:
//C
this.state = 5;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 174;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
Debug.ShouldStop(8192);
if (true) break;

case 5:
//if
this.state = 38;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent._xui.getField(true,"DialogResponse_Positive")))) { 
this.state = 7;
}if (true) break;

case 7:
//C
this.state = 8;
 BA.debugLineNum = 175;BA.debugLine="TabHost1.CurrentTab = (TabHost1.CurrentTab + 1)";
Debug.ShouldStop(16384);
parent.mostCurrent._tabhost1.runMethodAndSync(true,"setCurrentTab",RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),RemoteObject.createImmutable(1)}, "+",1, 1)),parent.mostCurrent._tabhost1.runMethod(true,"getTabCount")}, "%",0, 1));
 BA.debugLineNum = 176;BA.debugLine="query_selector.Position=Position";
Debug.ShouldStop(32768);
parent.mostCurrent._query_selector.runMethod(true,"setPosition",_position);
 BA.debugLineNum = 177;BA.debugLine="Dim time As String";
Debug.ShouldStop(65536);
_time = RemoteObject.createImmutable("");Debug.locals.put("time", _time);
 BA.debugLineNum = 178;BA.debugLine="time = DateTime.Now";
Debug.ShouldStop(131072);
_time = BA.NumberToString(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));Debug.locals.put("time", _time);
 BA.debugLineNum = 179;BA.debugLine="Dim mi,ho,ti As Int";
Debug.ShouldStop(262144);
_mi = RemoteObject.createImmutable(0);Debug.locals.put("mi", _mi);
_ho = RemoteObject.createImmutable(0);Debug.locals.put("ho", _ho);
_ti = RemoteObject.createImmutable(0);Debug.locals.put("ti", _ti);
 BA.debugLineNum = 180;BA.debugLine="Dim da As String";
Debug.ShouldStop(524288);
_da = RemoteObject.createImmutable("");Debug.locals.put("da", _da);
 BA.debugLineNum = 182;BA.debugLine="label_id.Text = query_selector.GetString(\"id\")";
Debug.ShouldStop(2097152);
parent.mostCurrent._label_id.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 183;BA.debugLine="label_patent.Text = query_selector.GetString(\"pa";
Debug.ShouldStop(4194304);
parent.mostCurrent._label_patent.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("patent")))));
 BA.debugLineNum = 184;BA.debugLine="label_date.Text = query_selector.GetString(\"date";
Debug.ShouldStop(8388608);
parent.mostCurrent._label_date.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date")))));
 BA.debugLineNum = 185;BA.debugLine="label_start.Text = query_selector.GetString(\"hou";
Debug.ShouldStop(16777216);
parent.mostCurrent._label_start.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("hour")))));
 BA.debugLineNum = 187;BA.debugLine="da = DateTime.GetYear(time)&\"/\"&DateTime.GetMont";
Debug.ShouldStop(67108864);
_da = RemoteObject.concat(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("da", _da);
 BA.debugLineNum = 188;BA.debugLine="If da <> query_selector.GetString(\"date\") Then";
Debug.ShouldStop(134217728);
if (true) break;

case 8:
//if
this.state = 19;
if (RemoteObject.solveBoolean("!",_da,parent.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date"))))) { 
this.state = 10;
}else {
this.state = 12;
}if (true) break;

case 10:
//C
this.state = 19;
 BA.debugLineNum = 189;BA.debugLine="Log(\"distintos dias\")";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","7589848",RemoteObject.createImmutable("distintos dias"),0);
 BA.debugLineNum = 190;BA.debugLine="label_end.Text = \"23:59\"";
Debug.ShouldStop(536870912);
parent.mostCurrent._label_end.runMethod(true,"setText",BA.ObjectToCharSequence("23:59"));
 if (true) break;

case 12:
//C
this.state = 13;
 BA.debugLineNum = 192;BA.debugLine="If DateTime.GetMinute(time).As(Int) <= 9 Then";
Debug.ShouldStop(-2147483648);
if (true) break;

case 13:
//if
this.state = 18;
if (RemoteObject.solveBoolean("k",(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time)))),BA.numberCast(double.class, 9))) { 
this.state = 15;
}else {
this.state = 17;
}if (true) break;

case 15:
//C
this.state = 18;
 BA.debugLineNum = 193;BA.debugLine="label_end.Text = DateTime.GetHour(time).As(Str";
Debug.ShouldStop(1);
parent.mostCurrent._label_end.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat((BA.NumberToString(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(BA.numberCast(long.class, _time))))),RemoteObject.createImmutable(":0"),(BA.NumberToString(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time))))))));
 if (true) break;

case 17:
//C
this.state = 18;
 BA.debugLineNum = 195;BA.debugLine="label_end.Text = DateTime.GetHour(time).As(Str";
Debug.ShouldStop(4);
parent.mostCurrent._label_end.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat((BA.NumberToString(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(BA.numberCast(long.class, _time))))),RemoteObject.createImmutable(":"),(BA.NumberToString(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time))))))));
 if (true) break;

case 18:
//C
this.state = 19;
;
 if (true) break;

case 19:
//C
this.state = 20;
;
 BA.debugLineNum = 199;BA.debugLine="ho = (label_end.Text.SubString2(0,2)).As(Int)-(l";
Debug.ShouldStop(64);
_ho = RemoteObject.solve(new RemoteObject[] {(BA.numberCast(int.class, (parent.mostCurrent._label_end.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2)))))),(BA.numberCast(int.class, (parent.mostCurrent._label_start.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))))))}, "-",1, 1);Debug.locals.put("ho", _ho);
 BA.debugLineNum = 200;BA.debugLine="mi = (label_end.Text.SubString2(3,5)).As(Int)-(l";
Debug.ShouldStop(128);
_mi = RemoteObject.solve(new RemoteObject[] {(BA.numberCast(int.class, (parent.mostCurrent._label_end.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 5)))))),(BA.numberCast(int.class, (parent.mostCurrent._label_start.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 5))))))}, "-",1, 1);Debug.locals.put("mi", _mi);
 BA.debugLineNum = 201;BA.debugLine="If ho = 0 Then";
Debug.ShouldStop(256);
if (true) break;

case 20:
//if
this.state = 31;
if (RemoteObject.solveBoolean("=",_ho,BA.numberCast(double.class, 0))) { 
this.state = 22;
}else {
this.state = 24;
}if (true) break;

case 22:
//C
this.state = 31;
 BA.debugLineNum = 202;BA.debugLine="ti = mi";
Debug.ShouldStop(512);
_ti = _mi;Debug.locals.put("ti", _ti);
 if (true) break;

case 24:
//C
this.state = 25;
 BA.debugLineNum = 204;BA.debugLine="If mi >= 0 Then";
Debug.ShouldStop(2048);
if (true) break;

case 25:
//if
this.state = 30;
if (RemoteObject.solveBoolean("g",_mi,BA.numberCast(double.class, 0))) { 
this.state = 27;
}else {
this.state = 29;
}if (true) break;

case 27:
//C
this.state = 30;
 BA.debugLineNum = 205;BA.debugLine="ti = ho*60 + mi";
Debug.ShouldStop(4096);
_ti = RemoteObject.solve(new RemoteObject[] {_ho,RemoteObject.createImmutable(60),_mi}, "*+",1, 1);Debug.locals.put("ti", _ti);
 if (true) break;

case 29:
//C
this.state = 30;
 BA.debugLineNum = 207;BA.debugLine="ho = ho - 1";
Debug.ShouldStop(16384);
_ho = RemoteObject.solve(new RemoteObject[] {_ho,RemoteObject.createImmutable(1)}, "-",1, 1);Debug.locals.put("ho", _ho);
 BA.debugLineNum = 208;BA.debugLine="mi = mi + 60";
Debug.ShouldStop(32768);
_mi = RemoteObject.solve(new RemoteObject[] {_mi,RemoteObject.createImmutable(60)}, "+",1, 1);Debug.locals.put("mi", _mi);
 BA.debugLineNum = 209;BA.debugLine="ti = ho*60 + mi";
Debug.ShouldStop(65536);
_ti = RemoteObject.solve(new RemoteObject[] {_ho,RemoteObject.createImmutable(60),_mi}, "*+",1, 1);Debug.locals.put("ti", _ti);
 if (true) break;

case 30:
//C
this.state = 31;
;
 if (true) break;

case 31:
//C
this.state = 32;
;
 BA.debugLineNum = 212;BA.debugLine="label_time.Text = ti&\"minutes\"";
Debug.ShouldStop(524288);
parent.mostCurrent._label_time.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_ti,RemoteObject.createImmutable("minutes"))));
 BA.debugLineNum = 213;BA.debugLine="label_time.Tag = ti";
Debug.ShouldStop(1048576);
parent.mostCurrent._label_time.runMethod(false,"setTag",(_ti));
 BA.debugLineNum = 214;BA.debugLine="If ti < 15 Then";
Debug.ShouldStop(2097152);
if (true) break;

case 32:
//if
this.state = 37;
if (RemoteObject.solveBoolean("<",_ti,BA.numberCast(double.class, 15))) { 
this.state = 34;
}else {
this.state = 36;
}if (true) break;

case 34:
//C
this.state = 37;
 BA.debugLineNum = 215;BA.debugLine="label_pay.Text = \"500\"";
Debug.ShouldStop(4194304);
parent.mostCurrent._label_pay.runMethod(true,"setText",BA.ObjectToCharSequence("500"));
 BA.debugLineNum = 216;BA.debugLine="label_pay.Tag = \"500\"";
Debug.ShouldStop(8388608);
parent.mostCurrent._label_pay.runMethod(false,"setTag",RemoteObject.createImmutable(("500")));
 if (true) break;

case 36:
//C
this.state = 37;
 BA.debugLineNum = 218;BA.debugLine="label_pay.Text =\"$500 + \"&(ti-15)&\" * $30\"&\" =";
Debug.ShouldStop(33554432);
parent.mostCurrent._label_pay.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("$500 + "),(RemoteObject.solve(new RemoteObject[] {_ti,RemoteObject.createImmutable(15)}, "-",1, 1)),RemoteObject.createImmutable(" * $30"),RemoteObject.createImmutable(" = $"),(BA.NumberToString((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(500),(RemoteObject.solve(new RemoteObject[] {_ti,RemoteObject.createImmutable(15)}, "-",1, 1)),RemoteObject.createImmutable(30)}, "+*",1, 1)))))));
 BA.debugLineNum = 219;BA.debugLine="label_pay.Tag = (500 +(ti-15)*30).As(String)";
Debug.ShouldStop(67108864);
parent.mostCurrent._label_pay.runMethod(false,"setTag",((BA.NumberToString((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(500),(RemoteObject.solve(new RemoteObject[] {_ti,RemoteObject.createImmutable(15)}, "-",1, 1)),RemoteObject.createImmutable(30)}, "+*",1, 1))))));
 if (true) break;

case 37:
//C
this.state = 38;
;
 if (true) break;

case 38:
//C
this.state = -1;
;
 BA.debugLineNum = 222;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _parked_today_click() throws Exception{
try {
		Debug.PushSubsStack("parked_today_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,330);
if (RapidSub.canDelegate("parked_today_click")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","parked_today_click");}
RemoteObject _time = RemoteObject.createImmutable("");
RemoteObject _da = RemoteObject.createImmutable("");
int _i = 0;
RemoteObject _p = RemoteObject.createImmutable("");
RemoteObject _d = RemoteObject.createImmutable("");
RemoteObject _h = RemoteObject.createImmutable("");
RemoteObject _pay = RemoteObject.createImmutable("");
 BA.debugLineNum = 330;BA.debugLine="Private Sub parked_today_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 331;BA.debugLine="Dim time,da As String";
Debug.ShouldStop(1024);
_time = RemoteObject.createImmutable("");Debug.locals.put("time", _time);
_da = RemoteObject.createImmutable("");Debug.locals.put("da", _da);
 BA.debugLineNum = 332;BA.debugLine="time = DateTime.Now";
Debug.ShouldStop(2048);
_time = BA.NumberToString(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));Debug.locals.put("time", _time);
 BA.debugLineNum = 333;BA.debugLine="da = DateTime.GetYear(time)&\"/\"&DateTime.GetMonth";
Debug.ShouldStop(4096);
_da = RemoteObject.concat(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("da", _da);
 BA.debugLineNum = 336;BA.debugLine="query_selector=SQLite.ExecQuery(\"SELECT * FROM \"&";
Debug.ShouldStop(32768);
main.mostCurrent._query_selector = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sqlite.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM "),main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" WHERE date='"),_da,RemoteObject.createImmutable("' ORDER BY patent ASC")))));
 BA.debugLineNum = 337;BA.debugLine="parked_listview.clear";
Debug.ShouldStop(65536);
main.mostCurrent._parked_listview.runVoidMethod ("Clear");
 BA.debugLineNum = 338;BA.debugLine="If query_selector.RowCount>0 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean(">",main.mostCurrent._query_selector.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 340;BA.debugLine="For i=0 To query_selector.RowCount-1";
Debug.ShouldStop(524288);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._query_selector.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 341;BA.debugLine="query_selector.Position=i";
Debug.ShouldStop(1048576);
main.mostCurrent._query_selector.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 342;BA.debugLine="Dim p,d,h,pay As String";
Debug.ShouldStop(2097152);
_p = RemoteObject.createImmutable("");Debug.locals.put("p", _p);
_d = RemoteObject.createImmutable("");Debug.locals.put("d", _d);
_h = RemoteObject.createImmutable("");Debug.locals.put("h", _h);
_pay = RemoteObject.createImmutable("");Debug.locals.put("pay", _pay);
 BA.debugLineNum = 343;BA.debugLine="p=query_selector.GetString(\"patent\")";
Debug.ShouldStop(4194304);
_p = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("patent")));Debug.locals.put("p", _p);
 BA.debugLineNum = 344;BA.debugLine="d=query_selector.GetString(\"date\")";
Debug.ShouldStop(8388608);
_d = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date")));Debug.locals.put("d", _d);
 BA.debugLineNum = 345;BA.debugLine="h=query_selector.GetString(\"hour\")";
Debug.ShouldStop(16777216);
_h = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("hour")));Debug.locals.put("h", _h);
 BA.debugLineNum = 346;BA.debugLine="pay=query_selector.GetString(\"payment\")";
Debug.ShouldStop(33554432);
_pay = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("payment")));Debug.locals.put("pay", _pay);
 BA.debugLineNum = 347;BA.debugLine="parked_listview.AddSingleLine(p&\" \"&d&\" \"&h&\" \"";
Debug.ShouldStop(67108864);
main.mostCurrent._parked_listview.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(_p,RemoteObject.createImmutable(" "),_d,RemoteObject.createImmutable(" "),_h,RemoteObject.createImmutable(" "),_pay))));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 351;BA.debugLine="label_main.Text = \"List of cars parked today\"";
Debug.ShouldStop(1073741824);
main.mostCurrent._label_main.runMethod(true,"setText",BA.ObjectToCharSequence("List of cars parked today"));
 BA.debugLineNum = 354;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
public static RemoteObject  _tabhost1_tabchanged() throws Exception{
try {
		Debug.PushSubsStack("TabHost1_TabChanged (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,290);
if (RapidSub.canDelegate("tabhost1_tabchanged")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","tabhost1_tabchanged");}
 BA.debugLineNum = 290;BA.debugLine="Private Sub TabHost1_TabChanged";
Debug.ShouldStop(2);
 BA.debugLineNum = 291;BA.debugLine="If TabHost1.CurrentTab = 0 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 292;BA.debugLine="label_main.Text = \"Enter car patent\"";
Debug.ShouldStop(8);
main.mostCurrent._label_main.runMethod(true,"setText",BA.ObjectToCharSequence("Enter car patent"));
 BA.debugLineNum = 293;BA.debugLine="parked_listview.Clear";
Debug.ShouldStop(16);
main.mostCurrent._parked_listview.runVoidMethod ("Clear");
 };
 BA.debugLineNum = 296;BA.debugLine="If TabHost1.CurrentTab = 1 Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 297;BA.debugLine="label_main.Text = \"List cars\"";
Debug.ShouldStop(256);
main.mostCurrent._label_main.runMethod(true,"setText",BA.ObjectToCharSequence("List cars"));
 BA.debugLineNum = 298;BA.debugLine="parked_listview.Clear";
Debug.ShouldStop(512);
main.mostCurrent._parked_listview.runVoidMethod ("Clear");
 };
 BA.debugLineNum = 301;BA.debugLine="If TabHost1.CurrentTab = 2 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 302;BA.debugLine="label_main.Text = \"Payment details\"";
Debug.ShouldStop(8192);
main.mostCurrent._label_main.runMethod(true,"setText",BA.ObjectToCharSequence("Payment details"));
 BA.debugLineNum = 303;BA.debugLine="parked_listview.Clear";
Debug.ShouldStop(16384);
main.mostCurrent._parked_listview.runVoidMethod ("Clear");
 };
 BA.debugLineNum = 305;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _update_record(RemoteObject _name,RemoteObject _table,RemoteObject _en,RemoteObject _ti,RemoteObject _pay,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("update_record (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,275);
if (RapidSub.canDelegate("update_record")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","update_record", _name, _table, _en, _ti, _pay, _id);}
Debug.locals.put("name", _name);
Debug.locals.put("table", _table);
Debug.locals.put("en", _en);
Debug.locals.put("ti", _ti);
Debug.locals.put("pay", _pay);
Debug.locals.put("id", _id);
 BA.debugLineNum = 275;BA.debugLine="Sub update_record (name As String,table As String,";
Debug.ShouldStop(262144);
 BA.debugLineNum = 277;BA.debugLine="SQLite.Initialize(File.DirInternal,name,True)";
Debug.ShouldStop(1048576);
main._sqlite.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_name),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 278;BA.debugLine="SQLite.BeginTransaction";
Debug.ShouldStop(2097152);
main._sqlite.runVoidMethod ("BeginTransaction");
 BA.debugLineNum = 279;BA.debugLine="Try";
Debug.ShouldStop(4194304);
try { BA.debugLineNum = 280;BA.debugLine="SQLite.ExecNonQuery(\"UPDATE \"&table&\" SET end =";
Debug.ShouldStop(8388608);
main._sqlite.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE "),_table,RemoteObject.createImmutable(" SET end = '"),_en,RemoteObject.createImmutable("', time = "),_ti,RemoteObject.createImmutable(", payment = "),_pay,RemoteObject.createImmutable(" where id = "),_id)));
 BA.debugLineNum = 281;BA.debugLine="SQLite.TransactionSuccessful";
Debug.ShouldStop(16777216);
main._sqlite.runVoidMethod ("TransactionSuccessful");
 BA.debugLineNum = 282;BA.debugLine="xui.MsgboxAsync(\"Update to id= \"&id, \"successful";
Debug.ShouldStop(33554432);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Update to id= "),_id))),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("successfully"))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 284;BA.debugLine="ToastMessageShow(\"Update into failed: \"&table,Tr";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Update into failed: "),_table))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 285;BA.debugLine="Log(\"Update into failedd:\"&table&\", \"&LastExcept";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("LogImpl","7786442",RemoteObject.concat(RemoteObject.createImmutable("Update into failedd:"),_table,RemoteObject.createImmutable(", "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 };
 BA.debugLineNum = 287;BA.debugLine="SQLite.EndTransaction";
Debug.ShouldStop(1073741824);
main._sqlite.runVoidMethod ("EndTransaction");
 BA.debugLineNum = 288;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}