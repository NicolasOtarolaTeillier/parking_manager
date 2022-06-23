package b4a.EjemploSQLite;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,63);
if (RapidSub.canDelegate("activity_create")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 63;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 65;BA.debugLine="Activity.LoadLayout(\"Main\")";
Debug.ShouldStop(1);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Main")),main.mostCurrent.activityBA);
 BA.debugLineNum = 68;BA.debugLine="TabHost1.AddTab(\"Customer\",\"page_customer.bal\")";
Debug.ShouldStop(8);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Customer")),(Object)(RemoteObject.createImmutable("page_customer.bal")));
 BA.debugLineNum = 69;BA.debugLine="TabHost1.AddTab(\"Parked\",\"page_parked.bal\")";
Debug.ShouldStop(16);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Parked")),(Object)(RemoteObject.createImmutable("page_parked.bal")));
 BA.debugLineNum = 70;BA.debugLine="TabHost1.AddTab(\"Info\",\"page_info.bal\")";
Debug.ShouldStop(32);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Info")),(Object)(RemoteObject.createImmutable("page_info.bal")));
 BA.debugLineNum = 73;BA.debugLine="name_db = \"parking_manager2.db\"";
Debug.ShouldStop(256);
main.mostCurrent._name_db = BA.ObjectToString("parking_manager2.db");
 BA.debugLineNum = 76;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(2048);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 77;BA.debugLine="tables_db.Initialize";
Debug.ShouldStop(4096);
main.mostCurrent._tables_db.runVoidMethod ("Initialize");
 BA.debugLineNum = 78;BA.debugLine="tables_db.AddAll(Array As String (\"cars\"))";
Debug.ShouldStop(8192);
main.mostCurrent._tables_db.runVoidMethod ("AddAll",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.createImmutable("cars")})))));
 BA.debugLineNum = 79;BA.debugLine="table_cars = \"(id INTEGER PRIMARY KEY AUTOINCREM";
Debug.ShouldStop(16384);
main.mostCurrent._table_cars = BA.ObjectToString("(id INTEGER PRIMARY KEY AUTOINCREMENT, patent TEXT, date TEXT, hour TEXT, payment FLOAT)");
 BA.debugLineNum = 80;BA.debugLine="create_db(name_db,tables_db.Get(0), table_cars)";
Debug.ShouldStop(32768);
_create_db(main.mostCurrent._name_db,BA.ObjectToString(main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),main.mostCurrent._table_cars);
 };
 BA.debugLineNum = 83;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,103);
if (RapidSub.canDelegate("activity_pause")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 103;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,99);
if (RapidSub.canDelegate("activity_resume")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 99;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4);
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
public static RemoteObject  _create_db(RemoteObject _name,RemoteObject _table,RemoteObject _col) throws Exception{
try {
		Debug.PushSubsStack("create_db (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,85);
if (RapidSub.canDelegate("create_db")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","create_db", _name, _table, _col);}
Debug.locals.put("name", _name);
Debug.locals.put("table", _table);
Debug.locals.put("col", _col);
 BA.debugLineNum = 85;BA.debugLine="Sub create_db (name As String, table As String, co";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 86;BA.debugLine="SQLite.Initialize(File.DirInternal,name,True)";
Debug.ShouldStop(2097152);
main._sqlite.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_name),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 87;BA.debugLine="SQLite.BeginTransaction";
Debug.ShouldStop(4194304);
main._sqlite.runVoidMethod ("BeginTransaction");
 BA.debugLineNum = 88;BA.debugLine="Try";
Debug.ShouldStop(8388608);
try { BA.debugLineNum = 89;BA.debugLine="SQLite.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS";
Debug.ShouldStop(16777216);
main._sqlite.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("CREATE TABLE IF NOT EXISTS "),_table,RemoteObject.createImmutable(" "),_col)));
 BA.debugLineNum = 90;BA.debugLine="SQLite.TransactionSuccessful";
Debug.ShouldStop(33554432);
main._sqlite.runVoidMethod ("TransactionSuccessful");
 BA.debugLineNum = 91;BA.debugLine="ToastMessageShow(\"Successfully created '\"&table&";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Successfully created '"),_table,RemoteObject.createImmutable("' table")))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 93;BA.debugLine="ToastMessageShow(\"Table creation failed: \"&table";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Table creation failed: "),_table))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 94;BA.debugLine="Log(\"Table creation failed:\"&table&\", \"&LastExce";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("LogImpl","0196617",RemoteObject.concat(RemoteObject.createImmutable("Table creation failed:"),_table,RemoteObject.createImmutable(", "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 };
 BA.debugLineNum = 96;BA.debugLine="SQLite.EndTransaction";
Debug.ShouldStop(-2147483648);
main._sqlite.runVoidMethod ("EndTransaction");
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("customer_button_patent_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,107);
if (RapidSub.canDelegate("customer_button_patent_click")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","customer_button_patent_click");}
RemoteObject _col = RemoteObject.createImmutable("");
RemoteObject _patent = RemoteObject.createImmutable("");
RemoteObject _date = RemoteObject.createImmutable("");
RemoteObject _hour = RemoteObject.createImmutable("");
RemoteObject _time = RemoteObject.createImmutable("");
 BA.debugLineNum = 107;BA.debugLine="Private Sub customer_button_patent_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 108;BA.debugLine="If customer_text_patent.Text = \"\" Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",main.mostCurrent._customer_text_patent.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 109;BA.debugLine="xui.MsgboxAsync(\"The patent does not exist, plea";
Debug.ShouldStop(4096);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("The patent does not exist, please enter a patent.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Patent Error!"))));
 BA.debugLineNum = 110;BA.debugLine="Return";
Debug.ShouldStop(8192);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 112;BA.debugLine="Dim col,patent,date,hour,time As String";
Debug.ShouldStop(32768);
_col = RemoteObject.createImmutable("");Debug.locals.put("col", _col);
_patent = RemoteObject.createImmutable("");Debug.locals.put("patent", _patent);
_date = RemoteObject.createImmutable("");Debug.locals.put("date", _date);
_hour = RemoteObject.createImmutable("");Debug.locals.put("hour", _hour);
_time = RemoteObject.createImmutable("");Debug.locals.put("time", _time);
 BA.debugLineNum = 113;BA.debugLine="col = \"(patent, date, hour, payment)\"";
Debug.ShouldStop(65536);
_col = BA.ObjectToString("(patent, date, hour, payment)");Debug.locals.put("col", _col);
 BA.debugLineNum = 114;BA.debugLine="time = DateTime.Now";
Debug.ShouldStop(131072);
_time = BA.NumberToString(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));Debug.locals.put("time", _time);
 BA.debugLineNum = 115;BA.debugLine="patent = customer_text_patent.Text";
Debug.ShouldStop(262144);
_patent = main.mostCurrent._customer_text_patent.runMethod(true,"getText");Debug.locals.put("patent", _patent);
 BA.debugLineNum = 116;BA.debugLine="date = DateTime.GetYear(time)&\"/\"&DateTime.GetMon";
Debug.ShouldStop(524288);
_date = RemoteObject.concat(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("date", _date);
 BA.debugLineNum = 117;BA.debugLine="If DateTime.GetMinute(time).As(Int) <= 9 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("k",(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time)))),BA.numberCast(double.class, 9))) { 
 BA.debugLineNum = 118;BA.debugLine="hour = DateTime.GetHour(time)&\":0\"&DateTime.GetM";
Debug.ShouldStop(2097152);
_hour = RemoteObject.concat(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable(":0"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("hour", _hour);
 }else {
 BA.debugLineNum = 120;BA.debugLine="hour = DateTime.GetHour(time)&\":\"&DateTime.GetMi";
Debug.ShouldStop(8388608);
_hour = RemoteObject.concat(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable(":"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("hour", _hour);
 };
 BA.debugLineNum = 122;BA.debugLine="insert_into_table(name_db,tables_db.Get(0),col,pa";
Debug.ShouldStop(33554432);
_insert_into_table(main.mostCurrent._name_db,BA.ObjectToString(main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),_col,_patent,_date,_hour,BA.NumberToString(0));
 BA.debugLineNum = 123;BA.debugLine="customer_text_patent.Text = \"\"";
Debug.ShouldStop(67108864);
main.mostCurrent._customer_text_patent.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 125;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("customer_delete_table_click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,213);
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
		Debug.PushSubsStack("customer_delete_table_click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,213);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 214;BA.debugLine="Msgbox2Async(\"¿Desea borrar la tabla \"&tables_db.";
Debug.ShouldStop(2097152);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("¿Desea borrar la tabla "),parent.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable("?")))),(Object)(BA.ObjectToCharSequence("Atención!")),(Object)(BA.ObjectToString("Si")),(Object)(BA.ObjectToString("Cancelar")),(Object)(BA.ObjectToString("No")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 215;BA.debugLine="Wait For Msgbox_Result(Result As Int)";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "customer_delete_table_click"), null);
this.state = 11;
return;
case 11:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 216;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(8388608);
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
 BA.debugLineNum = 218;BA.debugLine="SQLite.Initialize(File.DirInternal,name_db,True)";
Debug.ShouldStop(33554432);
parent._sqlite.runVoidMethod ("Initialize",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(parent.mostCurrent._name_db),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 221;BA.debugLine="SQLite.BeginTransaction";
Debug.ShouldStop(268435456);
parent._sqlite.runVoidMethod ("BeginTransaction");
 BA.debugLineNum = 222;BA.debugLine="Try";
Debug.ShouldStop(536870912);
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
 BA.debugLineNum = 223;BA.debugLine="SQLite.ExecNonQuery(\"DELETE FROM \"&tables_db.Ge";
Debug.ShouldStop(1073741824);
parent._sqlite.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("DELETE FROM "),parent.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))));
 BA.debugLineNum = 225;BA.debugLine="ToastMessageShow(\"Registros de la tabla: \"&tabl";
Debug.ShouldStop(1);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Registros de la tabla: "),parent.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(", eliminados")))),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 226;BA.debugLine="SQLite.TransactionSuccessful";
Debug.ShouldStop(2);
parent._sqlite.runVoidMethod ("TransactionSuccessful");
 Debug.CheckDeviceExceptions();
if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 0;
 BA.debugLineNum = 228;BA.debugLine="Log(\"ERROR al elminar tabla: \"&tables_db.Get(0)";
Debug.ShouldStop(8);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","0655375",RemoteObject.concat(RemoteObject.createImmutable("ERROR al elminar tabla: "),parent.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" ,"),parent.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 if (true) break;
if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 0;
;
 BA.debugLineNum = 230;BA.debugLine="SQLite.EndTransaction";
Debug.ShouldStop(32);
parent._sqlite.runVoidMethod ("EndTransaction");
 if (true) break;

case 10:
//C
this.state = -1;
;
 BA.debugLineNum = 236;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
 //BA.debugLineNum = 35;BA.debugLine="Private customer_delete_table As Button";
main.mostCurrent._customer_delete_table = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private parked_listview As ListView";
main.mostCurrent._parked_listview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private parked_button As Button";
main.mostCurrent._parked_button = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private query_selector As Cursor";
main.mostCurrent._query_selector = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private info_background As Label";
main.mostCurrent._info_background = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private info_label_pay As Label";
main.mostCurrent._info_label_pay = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private info_label_time As Label";
main.mostCurrent._info_label_time = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private info_label_end As Label";
main.mostCurrent._info_label_end = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private info_label_start As Label";
main.mostCurrent._info_label_start = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private info_label_date As Label";
main.mostCurrent._info_label_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private info_label_patent As Label";
main.mostCurrent._info_label_patent = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private label_patent As Label";
main.mostCurrent._label_patent = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private label_date As Label";
main.mostCurrent._label_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private label_start As Label";
main.mostCurrent._label_start = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private label_end As Label";
main.mostCurrent._label_end = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private label_time As Label";
main.mostCurrent._label_time = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private label_pay As Label";
main.mostCurrent._label_pay = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _insert_into_table(RemoteObject _name,RemoteObject _table,RemoteObject _col,RemoteObject _i1,RemoteObject _i2,RemoteObject _i3,RemoteObject _i4) throws Exception{
try {
		Debug.PushSubsStack("insert_into_table (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,127);
if (RapidSub.canDelegate("insert_into_table")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","insert_into_table", _name, _table, _col, _i1, _i2, _i3, _i4);}
Debug.locals.put("name", _name);
Debug.locals.put("table", _table);
Debug.locals.put("col", _col);
Debug.locals.put("i1", _i1);
Debug.locals.put("i2", _i2);
Debug.locals.put("i3", _i3);
Debug.locals.put("i4", _i4);
 BA.debugLineNum = 127;BA.debugLine="Sub insert_into_table (name As String,table As Str";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 129;BA.debugLine="SQLite.Initialize(File.DirInternal,name,True)";
Debug.ShouldStop(1);
main._sqlite.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_name),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 130;BA.debugLine="SQLite.BeginTransaction";
Debug.ShouldStop(2);
main._sqlite.runVoidMethod ("BeginTransaction");
 BA.debugLineNum = 131;BA.debugLine="Try";
Debug.ShouldStop(4);
try { BA.debugLineNum = 132;BA.debugLine="SQLite.ExecNonQuery2(\"INSERT INTO \"&table&\" \"&co";
Debug.ShouldStop(8);
main._sqlite.runVoidMethod ("ExecNonQuery2",(Object)(RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO "),_table,RemoteObject.createImmutable(" "),_col,RemoteObject.createImmutable(" VALUES (?,?,?,?)"))),(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {(_i1.runMethod(true,"toUpperCase")),(_i2),(_i3),(_i4)})))));
 BA.debugLineNum = 133;BA.debugLine="SQLite.TransactionSuccessful";
Debug.ShouldStop(16);
main._sqlite.runVoidMethod ("TransactionSuccessful");
 BA.debugLineNum = 134;BA.debugLine="xui.MsgboxAsync(\"Patent: \"&i1&CRLF&\"Date: \"&i2&C";
Debug.ShouldStop(32);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Patent: "),_i1,main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Date: "),_i2,main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Hour: "),_i3,main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Payment: "),_i4))),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Insert into: "),_table,RemoteObject.createImmutable(", successfully")))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 136;BA.debugLine="ToastMessageShow(\"Insert into failed: \"&table,Tr";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Insert into failed: "),_table))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 137;BA.debugLine="Log(\"Insert into failedd:\"&table&\", \"&LastExcept";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("LogImpl","0458762",RemoteObject.concat(RemoteObject.createImmutable("Insert into failedd:"),_table,RemoteObject.createImmutable(", "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 };
 BA.debugLineNum = 139;BA.debugLine="SQLite.EndTransaction";
Debug.ShouldStop(1024);
main._sqlite.runVoidMethod ("EndTransaction");
 BA.debugLineNum = 140;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("parked_button_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,143);
if (RapidSub.canDelegate("parked_button_click")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","parked_button_click");}
int _i = 0;
RemoteObject _p = RemoteObject.createImmutable("");
RemoteObject _d = RemoteObject.createImmutable("");
RemoteObject _h = RemoteObject.createImmutable("");
 BA.debugLineNum = 143;BA.debugLine="Private Sub parked_button_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 144;BA.debugLine="query_selector=SQLite.ExecQuery(\"SELECT * FROM \"&";
Debug.ShouldStop(32768);
main.mostCurrent._query_selector = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sqlite.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM "),main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" WHERE payment=0 ORDER BY patent ASC")))));
 BA.debugLineNum = 145;BA.debugLine="parked_listview.clear";
Debug.ShouldStop(65536);
main.mostCurrent._parked_listview.runVoidMethod ("Clear");
 BA.debugLineNum = 146;BA.debugLine="If query_selector.RowCount>0 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean(">",main.mostCurrent._query_selector.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 148;BA.debugLine="For i=0 To query_selector.RowCount-1";
Debug.ShouldStop(524288);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._query_selector.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 149;BA.debugLine="query_selector.Position=i";
Debug.ShouldStop(1048576);
main.mostCurrent._query_selector.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 150;BA.debugLine="Dim p,d,h As String";
Debug.ShouldStop(2097152);
_p = RemoteObject.createImmutable("");Debug.locals.put("p", _p);
_d = RemoteObject.createImmutable("");Debug.locals.put("d", _d);
_h = RemoteObject.createImmutable("");Debug.locals.put("h", _h);
 BA.debugLineNum = 151;BA.debugLine="p=query_selector.GetString(\"patent\")";
Debug.ShouldStop(4194304);
_p = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("patent")));Debug.locals.put("p", _p);
 BA.debugLineNum = 152;BA.debugLine="d=query_selector.GetString(\"date\")";
Debug.ShouldStop(8388608);
_d = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date")));Debug.locals.put("d", _d);
 BA.debugLineNum = 153;BA.debugLine="h=query_selector.GetString(\"hour\")";
Debug.ShouldStop(16777216);
_h = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("hour")));Debug.locals.put("h", _h);
 BA.debugLineNum = 154;BA.debugLine="parked_listview.AddSingleLine(p&\" \"&d&\" \"&h)";
Debug.ShouldStop(33554432);
main.mostCurrent._parked_listview.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(_p,RemoteObject.createImmutable(" "),_d,RemoteObject.createImmutable(" "),_h))));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 157;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("parked_listview_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,159);
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
		Debug.PushSubsStack("parked_listview_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,159);
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
 BA.debugLineNum = 161;BA.debugLine="Dim sf As Object = Msgbox2Async(\"Press YES to ace";
Debug.ShouldStop(1);
_sf = parent.mostCurrent.__c.runMethod(false,"Msgbox2Async",(Object)(BA.ObjectToCharSequence("Press YES to acept or NO to decline")),(Object)(BA.ObjectToCharSequence("Do you want to pay?")),(Object)(BA.ObjectToString("YES")),(Object)(BA.ObjectToString("CANCEL")),(Object)(BA.ObjectToString("NO")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(parent.mostCurrent.__c.getField(true,"True")));Debug.locals.put("sf", _sf);Debug.locals.put("sf", _sf);
 BA.debugLineNum = 162;BA.debugLine="Wait For (sf) Msgbox_Result (Result As Int)";
Debug.ShouldStop(2);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "parked_listview_itemclick"), _sf);
this.state = 29;
return;
case 29:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 163;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
Debug.ShouldStop(4);
if (true) break;

case 1:
//if
this.state = 28;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent._xui.getField(true,"DialogResponse_Positive")))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 164;BA.debugLine="TabHost1.CurrentTab = (TabHost1.CurrentTab + 1)";
Debug.ShouldStop(8);
parent.mostCurrent._tabhost1.runMethodAndSync(true,"setCurrentTab",RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),RemoteObject.createImmutable(1)}, "+",1, 1)),parent.mostCurrent._tabhost1.runMethod(true,"getTabCount")}, "%",0, 1));
 BA.debugLineNum = 165;BA.debugLine="query_selector.Position=Position";
Debug.ShouldStop(16);
parent.mostCurrent._query_selector.runMethod(true,"setPosition",_position);
 BA.debugLineNum = 166;BA.debugLine="Dim time As String";
Debug.ShouldStop(32);
_time = RemoteObject.createImmutable("");Debug.locals.put("time", _time);
 BA.debugLineNum = 167;BA.debugLine="time = DateTime.Now";
Debug.ShouldStop(64);
_time = BA.NumberToString(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));Debug.locals.put("time", _time);
 BA.debugLineNum = 168;BA.debugLine="Dim mi,ho,ti As Int";
Debug.ShouldStop(128);
_mi = RemoteObject.createImmutable(0);Debug.locals.put("mi", _mi);
_ho = RemoteObject.createImmutable(0);Debug.locals.put("ho", _ho);
_ti = RemoteObject.createImmutable(0);Debug.locals.put("ti", _ti);
 BA.debugLineNum = 169;BA.debugLine="Dim da As String";
Debug.ShouldStop(256);
_da = RemoteObject.createImmutable("");Debug.locals.put("da", _da);
 BA.debugLineNum = 172;BA.debugLine="label_patent.Text = query_selector.GetString(\"pa";
Debug.ShouldStop(2048);
parent.mostCurrent._label_patent.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("patent")))));
 BA.debugLineNum = 173;BA.debugLine="label_date.Text = query_selector.GetString(\"date";
Debug.ShouldStop(4096);
parent.mostCurrent._label_date.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date")))));
 BA.debugLineNum = 174;BA.debugLine="label_start.Text = query_selector.GetString(\"hou";
Debug.ShouldStop(8192);
parent.mostCurrent._label_start.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("hour")))));
 BA.debugLineNum = 176;BA.debugLine="da = DateTime.GetYear(time)&\"/\"&DateTime.GetMont";
Debug.ShouldStop(32768);
_da = RemoteObject.concat(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("da", _da);
 BA.debugLineNum = 177;BA.debugLine="If da <> query_selector.GetString(\"date\") Then";
Debug.ShouldStop(65536);
if (true) break;

case 4:
//if
this.state = 9;
if (RemoteObject.solveBoolean("!",_da,parent.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date"))))) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
 BA.debugLineNum = 178;BA.debugLine="Log(\"distintos dias\")";
Debug.ShouldStop(131072);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","0589843",RemoteObject.createImmutable("distintos dias"),0);
 BA.debugLineNum = 179;BA.debugLine="label_end.Text = \"23:59\"";
Debug.ShouldStop(262144);
parent.mostCurrent._label_end.runMethod(true,"setText",BA.ObjectToCharSequence("23:59"));
 if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 181;BA.debugLine="label_end.Text = DateTime.GetHour(time).As(Stri";
Debug.ShouldStop(1048576);
parent.mostCurrent._label_end.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat((BA.NumberToString(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(BA.numberCast(long.class, _time))))),RemoteObject.createImmutable(":"),(BA.NumberToString(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time))))))));
 if (true) break;

case 9:
//C
this.state = 10;
;
 BA.debugLineNum = 183;BA.debugLine="ho = (label_end.Text.SubString2(0,2)).As(Int)-(l";
Debug.ShouldStop(4194304);
_ho = RemoteObject.solve(new RemoteObject[] {(BA.numberCast(int.class, (parent.mostCurrent._label_end.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2)))))),(BA.numberCast(int.class, (parent.mostCurrent._label_start.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))))))}, "-",1, 1);Debug.locals.put("ho", _ho);
 BA.debugLineNum = 184;BA.debugLine="mi = (label_end.Text.SubString2(3,5)).As(Int)-(l";
Debug.ShouldStop(8388608);
_mi = RemoteObject.solve(new RemoteObject[] {(BA.numberCast(int.class, (parent.mostCurrent._label_end.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 5)))))),(BA.numberCast(int.class, (parent.mostCurrent._label_start.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 5))))))}, "-",1, 1);Debug.locals.put("mi", _mi);
 BA.debugLineNum = 191;BA.debugLine="If ho = 0 Then";
Debug.ShouldStop(1073741824);
if (true) break;

case 10:
//if
this.state = 21;
if (RemoteObject.solveBoolean("=",_ho,BA.numberCast(double.class, 0))) { 
this.state = 12;
}else {
this.state = 14;
}if (true) break;

case 12:
//C
this.state = 21;
 BA.debugLineNum = 192;BA.debugLine="ti = ho*60 + mi";
Debug.ShouldStop(-2147483648);
_ti = RemoteObject.solve(new RemoteObject[] {_ho,RemoteObject.createImmutable(60),_mi}, "*+",1, 1);Debug.locals.put("ti", _ti);
 if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 194;BA.debugLine="If mi >= 0 Then";
Debug.ShouldStop(2);
if (true) break;

case 15:
//if
this.state = 20;
if (RemoteObject.solveBoolean("g",_mi,BA.numberCast(double.class, 0))) { 
this.state = 17;
}else {
this.state = 19;
}if (true) break;

case 17:
//C
this.state = 20;
 BA.debugLineNum = 195;BA.debugLine="ti = ho*60 + mi";
Debug.ShouldStop(4);
_ti = RemoteObject.solve(new RemoteObject[] {_ho,RemoteObject.createImmutable(60),_mi}, "*+",1, 1);Debug.locals.put("ti", _ti);
 if (true) break;

case 19:
//C
this.state = 20;
 BA.debugLineNum = 197;BA.debugLine="ho = ho - 1";
Debug.ShouldStop(16);
_ho = RemoteObject.solve(new RemoteObject[] {_ho,RemoteObject.createImmutable(1)}, "-",1, 1);Debug.locals.put("ho", _ho);
 BA.debugLineNum = 198;BA.debugLine="mi = mi + 60";
Debug.ShouldStop(32);
_mi = RemoteObject.solve(new RemoteObject[] {_mi,RemoteObject.createImmutable(60)}, "+",1, 1);Debug.locals.put("mi", _mi);
 BA.debugLineNum = 199;BA.debugLine="ti = ho*60 + mi";
Debug.ShouldStop(64);
_ti = RemoteObject.solve(new RemoteObject[] {_ho,RemoteObject.createImmutable(60),_mi}, "*+",1, 1);Debug.locals.put("ti", _ti);
 if (true) break;

case 20:
//C
this.state = 21;
;
 if (true) break;

case 21:
//C
this.state = 22;
;
 BA.debugLineNum = 202;BA.debugLine="label_time.Text = ti&\" minutes\"";
Debug.ShouldStop(512);
parent.mostCurrent._label_time.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_ti,RemoteObject.createImmutable(" minutes"))));
 BA.debugLineNum = 203;BA.debugLine="If ti < 15 Then";
Debug.ShouldStop(1024);
if (true) break;

case 22:
//if
this.state = 27;
if (RemoteObject.solveBoolean("<",_ti,BA.numberCast(double.class, 15))) { 
this.state = 24;
}else {
this.state = 26;
}if (true) break;

case 24:
//C
this.state = 27;
 BA.debugLineNum = 204;BA.debugLine="label_pay.Text = \"$ 500\"";
Debug.ShouldStop(2048);
parent.mostCurrent._label_pay.runMethod(true,"setText",BA.ObjectToCharSequence("$ 500"));
 if (true) break;

case 26:
//C
this.state = 27;
 BA.debugLineNum = 206;BA.debugLine="label_pay.Text =\"$500 + \"&(ti-15)&\" * $30\"&\" =";
Debug.ShouldStop(8192);
parent.mostCurrent._label_pay.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("$500 + "),(RemoteObject.solve(new RemoteObject[] {_ti,RemoteObject.createImmutable(15)}, "-",1, 1)),RemoteObject.createImmutable(" * $30"),RemoteObject.createImmutable(" = $"),(BA.NumberToString((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(500),(RemoteObject.solve(new RemoteObject[] {_ti,RemoteObject.createImmutable(15)}, "-",1, 1)),RemoteObject.createImmutable(30)}, "+*",1, 1)))))));
 if (true) break;

case 27:
//C
this.state = 28;
;
 if (true) break;

case 28:
//C
this.state = -1;
;
 BA.debugLineNum = 211;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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