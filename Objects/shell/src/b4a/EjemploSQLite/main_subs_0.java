package b4a.EjemploSQLite;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,72);
if (RapidSub.canDelegate("activity_create")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 72;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 74;BA.debugLine="Activity.LoadLayout(\"Main\")";
Debug.ShouldStop(512);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Main")),main.mostCurrent.activityBA);
 BA.debugLineNum = 77;BA.debugLine="TabHost1.AddTab(\"Customer\",\"page_customer.bal\")";
Debug.ShouldStop(4096);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Customer")),(Object)(RemoteObject.createImmutable("page_customer.bal")));
 BA.debugLineNum = 78;BA.debugLine="TabHost1.AddTab(\"Parked\",\"page_parked.bal\")";
Debug.ShouldStop(8192);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Parked")),(Object)(RemoteObject.createImmutable("page_parked.bal")));
 BA.debugLineNum = 79;BA.debugLine="TabHost1.AddTab(\"Info\",\"page_info.bal\")";
Debug.ShouldStop(16384);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Info")),(Object)(RemoteObject.createImmutable("page_info.bal")));
 BA.debugLineNum = 82;BA.debugLine="name_db = \"parking_manager4.db\"";
Debug.ShouldStop(131072);
main.mostCurrent._name_db = BA.ObjectToString("parking_manager4.db");
 BA.debugLineNum = 85;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(1048576);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 86;BA.debugLine="tables_db.Initialize";
Debug.ShouldStop(2097152);
main.mostCurrent._tables_db.runVoidMethod ("Initialize");
 BA.debugLineNum = 87;BA.debugLine="tables_db.AddAll(Array As String (\"cars\"))";
Debug.ShouldStop(4194304);
main.mostCurrent._tables_db.runVoidMethod ("AddAll",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.createImmutable("cars")})))));
 BA.debugLineNum = 88;BA.debugLine="table_cars = \"(id INTEGER PRIMARY KEY AUTOINCREM";
Debug.ShouldStop(8388608);
main.mostCurrent._table_cars = BA.ObjectToString("(id INTEGER PRIMARY KEY AUTOINCREMENT, patent TEXT, date TEXT, hour TEXT, end TEXT, time TEXT, payment FLOAT)");
 BA.debugLineNum = 89;BA.debugLine="create_db(name_db,tables_db.Get(0), table_cars)";
Debug.ShouldStop(16777216);
_create_db(main.mostCurrent._name_db,BA.ObjectToString(main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),main.mostCurrent._table_cars);
 };
 BA.debugLineNum = 93;BA.debugLine="label_main.Text = \"Enter car patent\"";
Debug.ShouldStop(268435456);
main.mostCurrent._label_main.runMethod(true,"setText",BA.ObjectToCharSequence("Enter car patent"));
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,115);
if (RapidSub.canDelegate("activity_pause")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 115;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 117;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,111);
if (RapidSub.canDelegate("activity_resume")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 111;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16384);
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("create_db (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,97);
if (RapidSub.canDelegate("create_db")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","create_db", _name, _table, _col);}
Debug.locals.put("name", _name);
Debug.locals.put("table", _table);
Debug.locals.put("col", _col);
 BA.debugLineNum = 97;BA.debugLine="Sub create_db (name As String, table As String, co";
Debug.ShouldStop(1);
 BA.debugLineNum = 98;BA.debugLine="SQLite.Initialize(File.DirInternal,name,True)";
Debug.ShouldStop(2);
main._sqlite.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_name),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 99;BA.debugLine="SQLite.BeginTransaction";
Debug.ShouldStop(4);
main._sqlite.runVoidMethod ("BeginTransaction");
 BA.debugLineNum = 100;BA.debugLine="Try";
Debug.ShouldStop(8);
try { BA.debugLineNum = 101;BA.debugLine="SQLite.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS";
Debug.ShouldStop(16);
main._sqlite.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("CREATE TABLE IF NOT EXISTS "),_table,RemoteObject.createImmutable(" "),_col)));
 BA.debugLineNum = 102;BA.debugLine="SQLite.TransactionSuccessful";
Debug.ShouldStop(32);
main._sqlite.runVoidMethod ("TransactionSuccessful");
 BA.debugLineNum = 103;BA.debugLine="ToastMessageShow(\"Successfully created '\"&table&";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Successfully created '"),_table,RemoteObject.createImmutable("' table")))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 105;BA.debugLine="ToastMessageShow(\"Table creation failed: \"&table";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Table creation failed: "),_table))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 106;BA.debugLine="Log(\"Table creation failed:\"&table&\", \"&LastExce";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2196617",RemoteObject.concat(RemoteObject.createImmutable("Table creation failed:"),_table,RemoteObject.createImmutable(", "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 };
 BA.debugLineNum = 108;BA.debugLine="SQLite.EndTransaction";
Debug.ShouldStop(2048);
main._sqlite.runVoidMethod ("EndTransaction");
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
public static RemoteObject  _customer_button_patent_click() throws Exception{
try {
		Debug.PushSubsStack("customer_button_patent_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,119);
if (RapidSub.canDelegate("customer_button_patent_click")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","customer_button_patent_click");}
RemoteObject _col = RemoteObject.createImmutable("");
RemoteObject _patent = RemoteObject.createImmutable("");
RemoteObject _date = RemoteObject.createImmutable("");
RemoteObject _hour = RemoteObject.createImmutable("");
RemoteObject _time = RemoteObject.createImmutable("");
 BA.debugLineNum = 119;BA.debugLine="Private Sub customer_button_patent_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 121;BA.debugLine="If customer_text_patent.Text = \"\" Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",main.mostCurrent._customer_text_patent.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 122;BA.debugLine="xui.MsgboxAsync(\"The patent does not exist, plea";
Debug.ShouldStop(33554432);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("The patent does not exist, please enter a patent.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Patent Error!"))));
 BA.debugLineNum = 123;BA.debugLine="Return";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 125;BA.debugLine="Dim col,patent,date,hour,time As String";
Debug.ShouldStop(268435456);
_col = RemoteObject.createImmutable("");Debug.locals.put("col", _col);
_patent = RemoteObject.createImmutable("");Debug.locals.put("patent", _patent);
_date = RemoteObject.createImmutable("");Debug.locals.put("date", _date);
_hour = RemoteObject.createImmutable("");Debug.locals.put("hour", _hour);
_time = RemoteObject.createImmutable("");Debug.locals.put("time", _time);
 BA.debugLineNum = 126;BA.debugLine="col = \"(patent, date, hour, end, time, payment)\"";
Debug.ShouldStop(536870912);
_col = BA.ObjectToString("(patent, date, hour, end, time, payment)");Debug.locals.put("col", _col);
 BA.debugLineNum = 127;BA.debugLine="time = DateTime.Now";
Debug.ShouldStop(1073741824);
_time = BA.NumberToString(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));Debug.locals.put("time", _time);
 BA.debugLineNum = 128;BA.debugLine="patent = customer_text_patent.Text";
Debug.ShouldStop(-2147483648);
_patent = main.mostCurrent._customer_text_patent.runMethod(true,"getText");Debug.locals.put("patent", _patent);
 BA.debugLineNum = 129;BA.debugLine="date = DateTime.GetYear(time)&\"/\"&DateTime.GetMon";
Debug.ShouldStop(1);
_date = RemoteObject.concat(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("date", _date);
 BA.debugLineNum = 130;BA.debugLine="If label_hour.Text = \"\" Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",main.mostCurrent._label_hour.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 131;BA.debugLine="If DateTime.GetMinute(time).As(Int) <= 9 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("k",(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time)))),BA.numberCast(double.class, 9))) { 
 BA.debugLineNum = 132;BA.debugLine="If DateTime.GetHour(time).As(Int) <= 9 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("k",(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(BA.numberCast(long.class, _time)))),BA.numberCast(double.class, 9))) { 
 BA.debugLineNum = 133;BA.debugLine="hour = \"0\"&DateTime.GetHour(time)&\":0\"&DateTim";
Debug.ShouldStop(16);
_hour = RemoteObject.concat(RemoteObject.createImmutable("0"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable(":0"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("hour", _hour);
 }else {
 BA.debugLineNum = 135;BA.debugLine="hour = DateTime.GetHour(time)&\":0\"&DateTime.Ge";
Debug.ShouldStop(64);
_hour = RemoteObject.concat(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable(":0"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("hour", _hour);
 };
 }else {
 BA.debugLineNum = 138;BA.debugLine="If DateTime.GetHour(time).As(Int) <= 9 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("k",(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(BA.numberCast(long.class, _time)))),BA.numberCast(double.class, 9))) { 
 BA.debugLineNum = 139;BA.debugLine="hour = \"0\"&DateTime.GetHour(time)&\":\"&DateTime";
Debug.ShouldStop(1024);
_hour = RemoteObject.concat(RemoteObject.createImmutable("0"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable(":"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("hour", _hour);
 }else {
 BA.debugLineNum = 141;BA.debugLine="hour = DateTime.GetHour(time)&\":\"&DateTime.Get";
Debug.ShouldStop(4096);
_hour = RemoteObject.concat(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable(":"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("hour", _hour);
 };
 };
 }else {
 BA.debugLineNum = 145;BA.debugLine="If label_minute.Text = \"\" Or label_minute.Text.A";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",main.mostCurrent._label_minute.runMethod(true,"getText"),BA.ObjectToString("")) || RemoteObject.solveBoolean("<",(BA.numberCast(int.class, main.mostCurrent._label_minute.runMethod(true,"getText"))),BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean(">",(BA.numberCast(int.class, main.mostCurrent._label_minute.runMethod(true,"getText"))),BA.numberCast(double.class, 59))) { 
 BA.debugLineNum = 146;BA.debugLine="xui.MsgboxAsync(\"The minutes does not correct,";
Debug.ShouldStop(131072);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("The minutes does not correct, please enter a valid minutes.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Minute Error!"))));
 BA.debugLineNum = 147;BA.debugLine="Return";
Debug.ShouldStop(262144);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 150;BA.debugLine="If label_hour.Text.As(Int) < 0 Or label_hour.Tex";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("<",(BA.numberCast(int.class, main.mostCurrent._label_hour.runMethod(true,"getText"))),BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("g",(BA.numberCast(int.class, main.mostCurrent._label_hour.runMethod(true,"getText"))),BA.numberCast(double.class, 24))) { 
 BA.debugLineNum = 151;BA.debugLine="xui.MsgboxAsync(\"The hour does not correct, ple";
Debug.ShouldStop(4194304);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("The hour does not correct, please enter a valid hour.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Hour Error!"))));
 BA.debugLineNum = 152;BA.debugLine="Return";
Debug.ShouldStop(8388608);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 155;BA.debugLine="If label_hour.Text.As(Int) <= 9 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("k",(BA.numberCast(int.class, main.mostCurrent._label_hour.runMethod(true,"getText"))),BA.numberCast(double.class, 9))) { 
 BA.debugLineNum = 156;BA.debugLine="If label_minute.Text.As(Int) <=9 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("k",(BA.numberCast(int.class, main.mostCurrent._label_minute.runMethod(true,"getText"))),BA.numberCast(double.class, 9))) { 
 BA.debugLineNum = 157;BA.debugLine="hour = \"0\"&label_hour.Text.as(Int)&\":0\"&label_";
Debug.ShouldStop(268435456);
_hour = RemoteObject.concat(RemoteObject.createImmutable("0"),(BA.numberCast(int.class, main.mostCurrent._label_hour.runMethod(true,"getText"))),RemoteObject.createImmutable(":0"),(BA.numberCast(int.class, main.mostCurrent._label_minute.runMethod(true,"getText"))));Debug.locals.put("hour", _hour);
 }else {
 BA.debugLineNum = 159;BA.debugLine="hour = \"0\"&label_hour.Text.as(Int)&\":\"&label_m";
Debug.ShouldStop(1073741824);
_hour = RemoteObject.concat(RemoteObject.createImmutable("0"),(BA.numberCast(int.class, main.mostCurrent._label_hour.runMethod(true,"getText"))),RemoteObject.createImmutable(":"),(BA.numberCast(int.class, main.mostCurrent._label_minute.runMethod(true,"getText"))));Debug.locals.put("hour", _hour);
 };
 }else {
 BA.debugLineNum = 162;BA.debugLine="If label_minute.Text.As(Int) <=9 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("k",(BA.numberCast(int.class, main.mostCurrent._label_minute.runMethod(true,"getText"))),BA.numberCast(double.class, 9))) { 
 BA.debugLineNum = 163;BA.debugLine="hour = label_hour.Text.as(Int)&\":0\"&label_minu";
Debug.ShouldStop(4);
_hour = RemoteObject.concat((BA.numberCast(int.class, main.mostCurrent._label_hour.runMethod(true,"getText"))),RemoteObject.createImmutable(":0"),(BA.numberCast(int.class, main.mostCurrent._label_minute.runMethod(true,"getText"))));Debug.locals.put("hour", _hour);
 }else {
 BA.debugLineNum = 165;BA.debugLine="hour = label_hour.Text.as(Int)&\":\"&label_minut";
Debug.ShouldStop(16);
_hour = RemoteObject.concat((BA.numberCast(int.class, main.mostCurrent._label_hour.runMethod(true,"getText"))),RemoteObject.createImmutable(":"),(BA.numberCast(int.class, main.mostCurrent._label_minute.runMethod(true,"getText"))));Debug.locals.put("hour", _hour);
 };
 };
 };
 BA.debugLineNum = 169;BA.debugLine="insert_into_table(name_db,tables_db.Get(0),col,pa";
Debug.ShouldStop(256);
_insert_into_table(main.mostCurrent._name_db,BA.ObjectToString(main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),_col,_patent,_date,_hour,BA.ObjectToString(""),BA.ObjectToString(""),BA.NumberToString(0));
 BA.debugLineNum = 170;BA.debugLine="customer_text_patent.Text = \"\"";
Debug.ShouldStop(512);
main.mostCurrent._customer_text_patent.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 171;BA.debugLine="label_hour.Text = \"\"";
Debug.ShouldStop(1024);
main.mostCurrent._label_hour.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 172;BA.debugLine="label_minute.Text = \"\"";
Debug.ShouldStop(2048);
main.mostCurrent._label_minute.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 174;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("customer_delete_table_click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,271);
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
		Debug.PushSubsStack("customer_delete_table_click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,271);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 272;BA.debugLine="Msgbox2Async(\"¿Desea borrar la tabla \"&tables_db.";
Debug.ShouldStop(32768);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("¿Desea borrar la tabla "),parent.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable("?")))),(Object)(BA.ObjectToCharSequence("Atención!")),(Object)(BA.ObjectToString("Si")),(Object)(BA.ObjectToString("Cancelar")),(Object)(BA.ObjectToString("No")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 273;BA.debugLine="Wait For Msgbox_Result(Result As Int)";
Debug.ShouldStop(65536);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "customer_delete_table_click"), null);
this.state = 11;
return;
case 11:
//C
this.state = 1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 274;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
Debug.ShouldStop(131072);
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
 BA.debugLineNum = 276;BA.debugLine="SQLite.Initialize(File.DirInternal,name_db,True)";
Debug.ShouldStop(524288);
parent._sqlite.runVoidMethod ("Initialize",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(parent.mostCurrent._name_db),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 279;BA.debugLine="SQLite.BeginTransaction";
Debug.ShouldStop(4194304);
parent._sqlite.runVoidMethod ("BeginTransaction");
 BA.debugLineNum = 280;BA.debugLine="Try";
Debug.ShouldStop(8388608);
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
 BA.debugLineNum = 281;BA.debugLine="SQLite.ExecNonQuery(\"DELETE FROM \"&tables_db.Ge";
Debug.ShouldStop(16777216);
parent._sqlite.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("DELETE FROM "),parent.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))));
 BA.debugLineNum = 283;BA.debugLine="ToastMessageShow(\"Registros de la tabla: \"&tabl";
Debug.ShouldStop(67108864);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Registros de la tabla: "),parent.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(", eliminados")))),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 284;BA.debugLine="SQLite.TransactionSuccessful";
Debug.ShouldStop(134217728);
parent._sqlite.runVoidMethod ("TransactionSuccessful");
 Debug.CheckDeviceExceptions();
if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 0;
 BA.debugLineNum = 286;BA.debugLine="Log(\"ERROR al elminar tabla: \"&tables_db.Get(0)";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","2655375",RemoteObject.concat(RemoteObject.createImmutable("ERROR al elminar tabla: "),parent.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" ,"),parent.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 if (true) break;
if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 0;
;
 BA.debugLineNum = 288;BA.debugLine="SQLite.EndTransaction";
Debug.ShouldStop(-2147483648);
parent._sqlite.runVoidMethod ("EndTransaction");
 if (true) break;

case 10:
//C
this.state = -1;
;
 BA.debugLineNum = 294;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
 //BA.debugLineNum = 37;BA.debugLine="Private label_hour As EditText";
main.mostCurrent._label_hour = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private labe_ As Label";
main.mostCurrent._labe_ = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private label_minute As EditText";
main.mostCurrent._label_minute = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private parked_listview As ListView";
main.mostCurrent._parked_listview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private parked_button As Button";
main.mostCurrent._parked_button = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private parked_today As Button";
main.mostCurrent._parked_today = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private parked_leave As Button";
main.mostCurrent._parked_leave = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private parked_list As Button";
main.mostCurrent._parked_list = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private query_selector As Cursor";
main.mostCurrent._query_selector = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private info_background As Label";
main.mostCurrent._info_background = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private info_label_pay As Label";
main.mostCurrent._info_label_pay = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private info_label_time As Label";
main.mostCurrent._info_label_time = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private info_label_end As Label";
main.mostCurrent._info_label_end = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private info_label_start As Label";
main.mostCurrent._info_label_start = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private info_label_date As Label";
main.mostCurrent._info_label_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private info_label_patent As Label";
main.mostCurrent._info_label_patent = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private label_patent As Label";
main.mostCurrent._label_patent = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private label_date As Label";
main.mostCurrent._label_date = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private label_start As Label";
main.mostCurrent._label_start = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private label_end As Label";
main.mostCurrent._label_end = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private label_time As Label";
main.mostCurrent._label_time = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 62;BA.debugLine="Private label_pay As Label";
main.mostCurrent._label_pay = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 63;BA.debugLine="Private label_id As Label";
main.mostCurrent._label_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 64;BA.debugLine="Private info_button_pay As Button";
main.mostCurrent._info_button_pay = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 66;BA.debugLine="Private flag as Boolean";
main._flag = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _info_button_pay_click() throws Exception{
try {
		Debug.PushSubsStack("info_button_pay_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,296);
if (RapidSub.canDelegate("info_button_pay_click")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","info_button_pay_click");}
RemoteObject _pat = RemoteObject.createImmutable("");
RemoteObject _dat = RemoteObject.createImmutable("");
RemoteObject _sta = RemoteObject.createImmutable("");
RemoteObject _en = RemoteObject.createImmutable("");
RemoteObject _tim = RemoteObject.createImmutable("");
RemoteObject _pay = RemoteObject.createImmutable("");
RemoteObject _id = RemoteObject.createImmutable("");
 BA.debugLineNum = 296;BA.debugLine="Private Sub info_button_pay_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 297;BA.debugLine="If label_patent.Text = \"\" Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",main.mostCurrent._label_patent.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 298;BA.debugLine="xui.MsgboxAsync(\"The patent does not exist, plea";
Debug.ShouldStop(512);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("The patent does not exist, please enter a patent.")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Patent Error!"))));
 BA.debugLineNum = 299;BA.debugLine="Return";
Debug.ShouldStop(1024);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 301;BA.debugLine="Dim pat,dat,sta,en,tim,pay,id As String";
Debug.ShouldStop(4096);
_pat = RemoteObject.createImmutable("");Debug.locals.put("pat", _pat);
_dat = RemoteObject.createImmutable("");Debug.locals.put("dat", _dat);
_sta = RemoteObject.createImmutable("");Debug.locals.put("sta", _sta);
_en = RemoteObject.createImmutable("");Debug.locals.put("en", _en);
_tim = RemoteObject.createImmutable("");Debug.locals.put("tim", _tim);
_pay = RemoteObject.createImmutable("");Debug.locals.put("pay", _pay);
_id = RemoteObject.createImmutable("");Debug.locals.put("id", _id);
 BA.debugLineNum = 302;BA.debugLine="id = label_id.Text";
Debug.ShouldStop(8192);
_id = main.mostCurrent._label_id.runMethod(true,"getText");Debug.locals.put("id", _id);
 BA.debugLineNum = 303;BA.debugLine="pat = label_patent.Text";
Debug.ShouldStop(16384);
_pat = main.mostCurrent._label_patent.runMethod(true,"getText");Debug.locals.put("pat", _pat);
 BA.debugLineNum = 304;BA.debugLine="dat = label_date.Text";
Debug.ShouldStop(32768);
_dat = main.mostCurrent._label_date.runMethod(true,"getText");Debug.locals.put("dat", _dat);
 BA.debugLineNum = 305;BA.debugLine="sta = label_start.Text";
Debug.ShouldStop(65536);
_sta = main.mostCurrent._label_start.runMethod(true,"getText");Debug.locals.put("sta", _sta);
 BA.debugLineNum = 306;BA.debugLine="en = label_end.Text";
Debug.ShouldStop(131072);
_en = main.mostCurrent._label_end.runMethod(true,"getText");Debug.locals.put("en", _en);
 BA.debugLineNum = 307;BA.debugLine="tim = label_time.Tag";
Debug.ShouldStop(262144);
_tim = BA.ObjectToString(main.mostCurrent._label_time.runMethod(false,"getTag"));Debug.locals.put("tim", _tim);
 BA.debugLineNum = 308;BA.debugLine="pay = label_pay.Tag.As(Float)";
Debug.ShouldStop(524288);
_pay = BA.NumberToString((BA.numberCast(float.class, main.mostCurrent._label_pay.runMethod(false,"getTag"))));Debug.locals.put("pay", _pay);
 BA.debugLineNum = 309;BA.debugLine="update_record(name_db,tables_db.Get(0),en,tim,pay";
Debug.ShouldStop(1048576);
_update_record(main.mostCurrent._name_db,BA.ObjectToString(main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),_en,_tim,BA.numberCast(float.class, _pay),_id);
 BA.debugLineNum = 310;BA.debugLine="label_id.Text = \"\"";
Debug.ShouldStop(2097152);
main.mostCurrent._label_id.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 311;BA.debugLine="label_patent.Text = \"\"";
Debug.ShouldStop(4194304);
main.mostCurrent._label_patent.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 312;BA.debugLine="label_date.Text = \"\"";
Debug.ShouldStop(8388608);
main.mostCurrent._label_date.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 313;BA.debugLine="label_start.Text = \"\"";
Debug.ShouldStop(16777216);
main.mostCurrent._label_start.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 314;BA.debugLine="label_end.Text = \"\"";
Debug.ShouldStop(33554432);
main.mostCurrent._label_end.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 315;BA.debugLine="label_time.Tag = \"\"";
Debug.ShouldStop(67108864);
main.mostCurrent._label_time.runMethod(false,"setTag",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 316;BA.debugLine="label_time.Text = \"0 minutes\"";
Debug.ShouldStop(134217728);
main.mostCurrent._label_time.runMethod(true,"setText",BA.ObjectToCharSequence("0 minutes"));
 BA.debugLineNum = 317;BA.debugLine="label_pay.Tag = \"\"";
Debug.ShouldStop(268435456);
main.mostCurrent._label_pay.runMethod(false,"setTag",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 318;BA.debugLine="label_pay.Text = \"$ 0\"";
Debug.ShouldStop(536870912);
main.mostCurrent._label_pay.runMethod(true,"setText",BA.ObjectToCharSequence("$ 0"));
 BA.debugLineNum = 320;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("insert_into_table (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,176);
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
 BA.debugLineNum = 176;BA.debugLine="Sub insert_into_table (name As String,table As Str";
Debug.ShouldStop(32768);
 BA.debugLineNum = 178;BA.debugLine="SQLite.Initialize(File.DirInternal,name,True)";
Debug.ShouldStop(131072);
main._sqlite.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_name),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 179;BA.debugLine="SQLite.BeginTransaction";
Debug.ShouldStop(262144);
main._sqlite.runVoidMethod ("BeginTransaction");
 BA.debugLineNum = 180;BA.debugLine="Try";
Debug.ShouldStop(524288);
try { BA.debugLineNum = 181;BA.debugLine="SQLite.ExecNonQuery2(\"INSERT INTO \"&table&\" \"&co";
Debug.ShouldStop(1048576);
main._sqlite.runVoidMethod ("ExecNonQuery2",(Object)(RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO "),_table,RemoteObject.createImmutable(" "),_col,RemoteObject.createImmutable(" VALUES (?,?,?,?,?,?)"))),(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {6},new Object[] {(_i1.runMethod(true,"toUpperCase")),(_i2),(_i3),(_i4),(_i5),(_i6)})))));
 BA.debugLineNum = 182;BA.debugLine="SQLite.TransactionSuccessful";
Debug.ShouldStop(2097152);
main._sqlite.runVoidMethod ("TransactionSuccessful");
 BA.debugLineNum = 183;BA.debugLine="xui.MsgboxAsync(\"Patent: \"&i1.ToUpperCase&CRLF&\"";
Debug.ShouldStop(4194304);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Patent: "),_i1.runMethod(true,"toUpperCase"),main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Date: "),_i2,main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Hour: "),_i3,main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("End: "),_i4,main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Time: "),_i5,main.mostCurrent.__c.getField(true,"CRLF"),RemoteObject.createImmutable("Payment: "),_i6))),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Insert into: "),_table,RemoteObject.createImmutable(", successfully")))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 185;BA.debugLine="ToastMessageShow(\"Insert into failed: \"&table,Tr";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Insert into failed: "),_table))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 186;BA.debugLine="Log(\"Insert into failedd:\"&table&\", \"&LastExcept";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2458762",RemoteObject.concat(RemoteObject.createImmutable("Insert into failedd:"),_table,RemoteObject.createImmutable(", "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 };
 BA.debugLineNum = 188;BA.debugLine="SQLite.EndTransaction";
Debug.ShouldStop(134217728);
main._sqlite.runVoidMethod ("EndTransaction");
 BA.debugLineNum = 189;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("parked_button_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,191);
if (RapidSub.canDelegate("parked_button_click")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","parked_button_click");}
int _i = 0;
RemoteObject _p = RemoteObject.createImmutable("");
RemoteObject _d = RemoteObject.createImmutable("");
RemoteObject _h = RemoteObject.createImmutable("");
 BA.debugLineNum = 191;BA.debugLine="Private Sub parked_button_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 192;BA.debugLine="query_selector=SQLite.ExecQuery(\"SELECT * FROM \"&";
Debug.ShouldStop(-2147483648);
main.mostCurrent._query_selector = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sqlite.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM "),main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" WHERE payment=0 ORDER BY patent ASC")))));
 BA.debugLineNum = 193;BA.debugLine="parked_listview.clear";
Debug.ShouldStop(1);
main.mostCurrent._parked_listview.runVoidMethod ("Clear");
 BA.debugLineNum = 194;BA.debugLine="If query_selector.RowCount>0 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean(">",main.mostCurrent._query_selector.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 196;BA.debugLine="For i=0 To query_selector.RowCount-1";
Debug.ShouldStop(8);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._query_selector.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 197;BA.debugLine="query_selector.Position=i";
Debug.ShouldStop(16);
main.mostCurrent._query_selector.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 198;BA.debugLine="Dim p,d,h As String";
Debug.ShouldStop(32);
_p = RemoteObject.createImmutable("");Debug.locals.put("p", _p);
_d = RemoteObject.createImmutable("");Debug.locals.put("d", _d);
_h = RemoteObject.createImmutable("");Debug.locals.put("h", _h);
 BA.debugLineNum = 199;BA.debugLine="p=query_selector.GetString(\"patent\")";
Debug.ShouldStop(64);
_p = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("patent")));Debug.locals.put("p", _p);
 BA.debugLineNum = 200;BA.debugLine="d=query_selector.GetString(\"date\")";
Debug.ShouldStop(128);
_d = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date")));Debug.locals.put("d", _d);
 BA.debugLineNum = 201;BA.debugLine="h=query_selector.GetString(\"hour\")";
Debug.ShouldStop(256);
_h = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("hour")));Debug.locals.put("h", _h);
 BA.debugLineNum = 202;BA.debugLine="parked_listview.AddSingleLine(p&\" \"&d&\" \"&h)";
Debug.ShouldStop(512);
main.mostCurrent._parked_listview.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(_p,RemoteObject.createImmutable(" "),_d,RemoteObject.createImmutable(" "),_h))));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 205;BA.debugLine="label_main.Text = \"List of cars parked\"";
Debug.ShouldStop(4096);
main.mostCurrent._label_main.runMethod(true,"setText",BA.ObjectToCharSequence("List of cars parked"));
 BA.debugLineNum = 206;BA.debugLine="flag = False";
Debug.ShouldStop(8192);
main._flag = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 207;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("parked_leave_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,363);
if (RapidSub.canDelegate("parked_leave_click")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","parked_leave_click");}
RemoteObject _time = RemoteObject.createImmutable("");
RemoteObject _da = RemoteObject.createImmutable("");
int _i = 0;
RemoteObject _p = RemoteObject.createImmutable("");
RemoteObject _d = RemoteObject.createImmutable("");
RemoteObject _h = RemoteObject.createImmutable("");
RemoteObject _pay = RemoteObject.createImmutable("");
 BA.debugLineNum = 363;BA.debugLine="Private Sub parked_leave_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 364;BA.debugLine="Dim time,da As String";
Debug.ShouldStop(2048);
_time = RemoteObject.createImmutable("");Debug.locals.put("time", _time);
_da = RemoteObject.createImmutable("");Debug.locals.put("da", _da);
 BA.debugLineNum = 365;BA.debugLine="time = DateTime.Now";
Debug.ShouldStop(4096);
_time = BA.NumberToString(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));Debug.locals.put("time", _time);
 BA.debugLineNum = 366;BA.debugLine="da = DateTime.GetYear(time)&\"/\"&DateTime.GetMonth";
Debug.ShouldStop(8192);
_da = RemoteObject.concat(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("da", _da);
 BA.debugLineNum = 369;BA.debugLine="query_selector=SQLite.ExecQuery(\"SELECT * FROM \"&";
Debug.ShouldStop(65536);
main.mostCurrent._query_selector = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sqlite.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM "),main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" WHERE date='"),_da,RemoteObject.createImmutable("' and payment > 0 ORDER BY patent ASC")))));
 BA.debugLineNum = 370;BA.debugLine="parked_listview.clear";
Debug.ShouldStop(131072);
main.mostCurrent._parked_listview.runVoidMethod ("Clear");
 BA.debugLineNum = 371;BA.debugLine="If query_selector.RowCount>0 Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean(">",main.mostCurrent._query_selector.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 372;BA.debugLine="For i=0 To query_selector.RowCount-1";
Debug.ShouldStop(524288);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._query_selector.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 373;BA.debugLine="query_selector.Position=i";
Debug.ShouldStop(1048576);
main.mostCurrent._query_selector.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 374;BA.debugLine="Dim p,d,h,pay As String";
Debug.ShouldStop(2097152);
_p = RemoteObject.createImmutable("");Debug.locals.put("p", _p);
_d = RemoteObject.createImmutable("");Debug.locals.put("d", _d);
_h = RemoteObject.createImmutable("");Debug.locals.put("h", _h);
_pay = RemoteObject.createImmutable("");Debug.locals.put("pay", _pay);
 BA.debugLineNum = 375;BA.debugLine="p=query_selector.GetString(\"patent\")";
Debug.ShouldStop(4194304);
_p = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("patent")));Debug.locals.put("p", _p);
 BA.debugLineNum = 378;BA.debugLine="pay=query_selector.GetString(\"payment\")";
Debug.ShouldStop(33554432);
_pay = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("payment")));Debug.locals.put("pay", _pay);
 BA.debugLineNum = 380;BA.debugLine="parked_listview.AddSingleLine(p&\" | \"&pay)";
Debug.ShouldStop(134217728);
main.mostCurrent._parked_listview.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(_p,RemoteObject.createImmutable(" | "),_pay))));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 383;BA.debugLine="label_main.Text = \"List of cars leave parked toda";
Debug.ShouldStop(1073741824);
main.mostCurrent._label_main.runMethod(true,"setText",BA.ObjectToCharSequence("List of cars leave parked today"));
 BA.debugLineNum = 384;BA.debugLine="flag = False";
Debug.ShouldStop(-2147483648);
main._flag = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 385;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _parked_list_click() throws Exception{
try {
		Debug.PushSubsStack("parked_list_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,413);
if (RapidSub.canDelegate("parked_list_click")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","parked_list_click");}
int _i = 0;
RemoteObject _p = RemoteObject.createImmutable("");
RemoteObject _c = RemoteObject.createImmutable("");
RemoteObject _t = RemoteObject.createImmutable("");
 BA.debugLineNum = 413;BA.debugLine="Private Sub parked_list_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 415;BA.debugLine="query_selector=SQLite.ExecQuery(\"SELECT patent,CO";
Debug.ShouldStop(1073741824);
main.mostCurrent._query_selector = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sqlite.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT patent,COUNT(payment) AS cantidad, SUM(payment) AS total FROM "),main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" WHERE payment > 0 GROUP BY patent")))));
 BA.debugLineNum = 416;BA.debugLine="parked_listview.clear";
Debug.ShouldStop(-2147483648);
main.mostCurrent._parked_listview.runVoidMethod ("Clear");
 BA.debugLineNum = 417;BA.debugLine="If query_selector.RowCount>0 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean(">",main.mostCurrent._query_selector.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 419;BA.debugLine="For i=0 To query_selector.RowCount-1";
Debug.ShouldStop(4);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._query_selector.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 420;BA.debugLine="query_selector.Position=i";
Debug.ShouldStop(8);
main.mostCurrent._query_selector.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 421;BA.debugLine="Dim p,c,t As String";
Debug.ShouldStop(16);
_p = RemoteObject.createImmutable("");Debug.locals.put("p", _p);
_c = RemoteObject.createImmutable("");Debug.locals.put("c", _c);
_t = RemoteObject.createImmutable("");Debug.locals.put("t", _t);
 BA.debugLineNum = 422;BA.debugLine="p=query_selector.GetString(\"patent\")";
Debug.ShouldStop(32);
_p = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("patent")));Debug.locals.put("p", _p);
 BA.debugLineNum = 423;BA.debugLine="c=query_selector.GetString(\"cantidad\")";
Debug.ShouldStop(64);
_c = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("cantidad")));Debug.locals.put("c", _c);
 BA.debugLineNum = 424;BA.debugLine="t=query_selector.GetString(\"total\")";
Debug.ShouldStop(128);
_t = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("total")));Debug.locals.put("t", _t);
 BA.debugLineNum = 425;BA.debugLine="parked_listview.AddSingleLine(p&\", Count:\"&c&\",";
Debug.ShouldStop(256);
main.mostCurrent._parked_listview.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(_p,RemoteObject.createImmutable(", Count:"),_c,RemoteObject.createImmutable(", Total:"),_t))));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 429;BA.debugLine="label_main.Text = \"List of patent\"";
Debug.ShouldStop(4096);
main.mostCurrent._label_main.runMethod(true,"setText",BA.ObjectToCharSequence("List of patent"));
 BA.debugLineNum = 430;BA.debugLine="flag = True";
Debug.ShouldStop(8192);
main._flag = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 433;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("parked_listview_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,209);
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
		Debug.PushSubsStack("parked_listview_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,209);
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
 BA.debugLineNum = 211;BA.debugLine="If flag = True Then";
Debug.ShouldStop(262144);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",parent._flag,parent.mostCurrent.__c.getField(true,"True"))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 212;BA.debugLine="Return";
Debug.ShouldStop(524288);
if (true) return ;
 if (true) break;

case 4:
//C
this.state = 5;
;
 BA.debugLineNum = 214;BA.debugLine="query_selector.Position=Position";
Debug.ShouldStop(2097152);
parent.mostCurrent._query_selector.runMethod(true,"setPosition",_position);
 BA.debugLineNum = 215;BA.debugLine="If query_selector.GetString(\"payment\") <> 0 And q";
Debug.ShouldStop(4194304);
if (true) break;

case 5:
//if
this.state = 8;
if (RemoteObject.solveBoolean("!",parent.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("payment"))),BA.NumberToString(0)) && RemoteObject.solveBoolean("!",parent.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("payment"))),BA.ObjectToString(""))) { 
this.state = 7;
}if (true) break;

case 7:
//C
this.state = 8;
 BA.debugLineNum = 216;BA.debugLine="Return";
Debug.ShouldStop(8388608);
if (true) return ;
 if (true) break;

case 8:
//C
this.state = 9;
;
 BA.debugLineNum = 219;BA.debugLine="Dim sf As Object = Msgbox2Async(\"Press YES to ace";
Debug.ShouldStop(67108864);
_sf = parent.mostCurrent.__c.runMethod(false,"Msgbox2Async",(Object)(BA.ObjectToCharSequence("Press YES to acept or NO to decline")),(Object)(BA.ObjectToCharSequence("Do you want to pay?")),(Object)(BA.ObjectToString("YES")),(Object)(BA.ObjectToString("CANCEL")),(Object)(BA.ObjectToString("NO")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(parent.mostCurrent.__c.getField(true,"True")));Debug.locals.put("sf", _sf);Debug.locals.put("sf", _sf);
 BA.debugLineNum = 220;BA.debugLine="Wait For (sf) Msgbox_Result (Result As Int)";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","msgbox_result", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "parked_listview_itemclick"), _sf);
this.state = 43;
return;
case 43:
//C
this.state = 9;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 221;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
Debug.ShouldStop(268435456);
if (true) break;

case 9:
//if
this.state = 42;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent._xui.getField(true,"DialogResponse_Positive")))) { 
this.state = 11;
}if (true) break;

case 11:
//C
this.state = 12;
 BA.debugLineNum = 222;BA.debugLine="TabHost1.CurrentTab = (TabHost1.CurrentTab + 1)";
Debug.ShouldStop(536870912);
parent.mostCurrent._tabhost1.runMethodAndSync(true,"setCurrentTab",RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),RemoteObject.createImmutable(1)}, "+",1, 1)),parent.mostCurrent._tabhost1.runMethod(true,"getTabCount")}, "%",0, 1));
 BA.debugLineNum = 223;BA.debugLine="query_selector.Position=Position";
Debug.ShouldStop(1073741824);
parent.mostCurrent._query_selector.runMethod(true,"setPosition",_position);
 BA.debugLineNum = 224;BA.debugLine="Dim time As String";
Debug.ShouldStop(-2147483648);
_time = RemoteObject.createImmutable("");Debug.locals.put("time", _time);
 BA.debugLineNum = 225;BA.debugLine="time = DateTime.Now";
Debug.ShouldStop(1);
_time = BA.NumberToString(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));Debug.locals.put("time", _time);
 BA.debugLineNum = 226;BA.debugLine="Dim mi,ho,ti As Int";
Debug.ShouldStop(2);
_mi = RemoteObject.createImmutable(0);Debug.locals.put("mi", _mi);
_ho = RemoteObject.createImmutable(0);Debug.locals.put("ho", _ho);
_ti = RemoteObject.createImmutable(0);Debug.locals.put("ti", _ti);
 BA.debugLineNum = 227;BA.debugLine="Dim da As String";
Debug.ShouldStop(4);
_da = RemoteObject.createImmutable("");Debug.locals.put("da", _da);
 BA.debugLineNum = 229;BA.debugLine="label_id.Text = query_selector.GetString(\"id\")";
Debug.ShouldStop(16);
parent.mostCurrent._label_id.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("id")))));
 BA.debugLineNum = 230;BA.debugLine="label_patent.Text = query_selector.GetString(\"pa";
Debug.ShouldStop(32);
parent.mostCurrent._label_patent.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("patent")))));
 BA.debugLineNum = 231;BA.debugLine="label_date.Text = query_selector.GetString(\"date";
Debug.ShouldStop(64);
parent.mostCurrent._label_date.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date")))));
 BA.debugLineNum = 232;BA.debugLine="label_start.Text = query_selector.GetString(\"hou";
Debug.ShouldStop(128);
parent.mostCurrent._label_start.runMethod(true,"setText",BA.ObjectToCharSequence(parent.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("hour")))));
 BA.debugLineNum = 234;BA.debugLine="da = DateTime.GetYear(time)&\"/\"&DateTime.GetMont";
Debug.ShouldStop(512);
_da = RemoteObject.concat(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("da", _da);
 BA.debugLineNum = 235;BA.debugLine="If da <> query_selector.GetString(\"date\") Then";
Debug.ShouldStop(1024);
if (true) break;

case 12:
//if
this.state = 23;
if (RemoteObject.solveBoolean("!",_da,parent.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date"))))) { 
this.state = 14;
}else {
this.state = 16;
}if (true) break;

case 14:
//C
this.state = 23;
 BA.debugLineNum = 236;BA.debugLine="Log(\"distintos dias\")";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","2589851",RemoteObject.createImmutable("distintos dias"),0);
 BA.debugLineNum = 237;BA.debugLine="label_end.Text = \"23:59\"";
Debug.ShouldStop(4096);
parent.mostCurrent._label_end.runMethod(true,"setText",BA.ObjectToCharSequence("23:59"));
 if (true) break;

case 16:
//C
this.state = 17;
 BA.debugLineNum = 239;BA.debugLine="If DateTime.GetMinute(time).As(Int) <= 9 Then";
Debug.ShouldStop(16384);
if (true) break;

case 17:
//if
this.state = 22;
if (RemoteObject.solveBoolean("k",(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time)))),BA.numberCast(double.class, 9))) { 
this.state = 19;
}else {
this.state = 21;
}if (true) break;

case 19:
//C
this.state = 22;
 BA.debugLineNum = 240;BA.debugLine="label_end.Text = DateTime.GetHour(time).As(Str";
Debug.ShouldStop(32768);
parent.mostCurrent._label_end.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat((BA.NumberToString(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(BA.numberCast(long.class, _time))))),RemoteObject.createImmutable(":0"),(BA.NumberToString(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time))))))));
 if (true) break;

case 21:
//C
this.state = 22;
 BA.debugLineNum = 242;BA.debugLine="label_end.Text = DateTime.GetHour(time).As(Str";
Debug.ShouldStop(131072);
parent.mostCurrent._label_end.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat((BA.NumberToString(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetHour",(Object)(BA.numberCast(long.class, _time))))),RemoteObject.createImmutable(":"),(BA.NumberToString(parent.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMinute",(Object)(BA.numberCast(long.class, _time))))))));
 if (true) break;

case 22:
//C
this.state = 23;
;
 if (true) break;

case 23:
//C
this.state = 24;
;
 BA.debugLineNum = 246;BA.debugLine="ho = (label_end.Text.SubString2(0,2)).As(Int)-(l";
Debug.ShouldStop(2097152);
_ho = RemoteObject.solve(new RemoteObject[] {(BA.numberCast(int.class, (parent.mostCurrent._label_end.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2)))))),(BA.numberCast(int.class, (parent.mostCurrent._label_start.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))))))}, "-",1, 1);Debug.locals.put("ho", _ho);
 BA.debugLineNum = 247;BA.debugLine="mi = (label_end.Text.SubString2(3,5)).As(Int)-(l";
Debug.ShouldStop(4194304);
_mi = RemoteObject.solve(new RemoteObject[] {(BA.numberCast(int.class, (parent.mostCurrent._label_end.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 5)))))),(BA.numberCast(int.class, (parent.mostCurrent._label_start.runMethod(true,"getText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 5))))))}, "-",1, 1);Debug.locals.put("mi", _mi);
 BA.debugLineNum = 248;BA.debugLine="If ho = 0 Then";
Debug.ShouldStop(8388608);
if (true) break;

case 24:
//if
this.state = 35;
if (RemoteObject.solveBoolean("=",_ho,BA.numberCast(double.class, 0))) { 
this.state = 26;
}else {
this.state = 28;
}if (true) break;

case 26:
//C
this.state = 35;
 BA.debugLineNum = 249;BA.debugLine="ti = mi";
Debug.ShouldStop(16777216);
_ti = _mi;Debug.locals.put("ti", _ti);
 if (true) break;

case 28:
//C
this.state = 29;
 BA.debugLineNum = 251;BA.debugLine="If mi >= 0 Then";
Debug.ShouldStop(67108864);
if (true) break;

case 29:
//if
this.state = 34;
if (RemoteObject.solveBoolean("g",_mi,BA.numberCast(double.class, 0))) { 
this.state = 31;
}else {
this.state = 33;
}if (true) break;

case 31:
//C
this.state = 34;
 BA.debugLineNum = 252;BA.debugLine="ti = ho*60 + mi";
Debug.ShouldStop(134217728);
_ti = RemoteObject.solve(new RemoteObject[] {_ho,RemoteObject.createImmutable(60),_mi}, "*+",1, 1);Debug.locals.put("ti", _ti);
 if (true) break;

case 33:
//C
this.state = 34;
 BA.debugLineNum = 254;BA.debugLine="ho = ho - 1";
Debug.ShouldStop(536870912);
_ho = RemoteObject.solve(new RemoteObject[] {_ho,RemoteObject.createImmutable(1)}, "-",1, 1);Debug.locals.put("ho", _ho);
 BA.debugLineNum = 255;BA.debugLine="mi = mi + 60";
Debug.ShouldStop(1073741824);
_mi = RemoteObject.solve(new RemoteObject[] {_mi,RemoteObject.createImmutable(60)}, "+",1, 1);Debug.locals.put("mi", _mi);
 BA.debugLineNum = 256;BA.debugLine="ti = ho*60 + mi";
Debug.ShouldStop(-2147483648);
_ti = RemoteObject.solve(new RemoteObject[] {_ho,RemoteObject.createImmutable(60),_mi}, "*+",1, 1);Debug.locals.put("ti", _ti);
 if (true) break;

case 34:
//C
this.state = 35;
;
 if (true) break;

case 35:
//C
this.state = 36;
;
 BA.debugLineNum = 259;BA.debugLine="label_time.Text = ti&\" minutes\"";
Debug.ShouldStop(4);
parent.mostCurrent._label_time.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(_ti,RemoteObject.createImmutable(" minutes"))));
 BA.debugLineNum = 260;BA.debugLine="label_time.Tag = ti";
Debug.ShouldStop(8);
parent.mostCurrent._label_time.runMethod(false,"setTag",(_ti));
 BA.debugLineNum = 261;BA.debugLine="If ti < 15 Then";
Debug.ShouldStop(16);
if (true) break;

case 36:
//if
this.state = 41;
if (RemoteObject.solveBoolean("<",_ti,BA.numberCast(double.class, 15))) { 
this.state = 38;
}else {
this.state = 40;
}if (true) break;

case 38:
//C
this.state = 41;
 BA.debugLineNum = 262;BA.debugLine="label_pay.Text = \"$ 500 pesos\"";
Debug.ShouldStop(32);
parent.mostCurrent._label_pay.runMethod(true,"setText",BA.ObjectToCharSequence("$ 500 pesos"));
 BA.debugLineNum = 263;BA.debugLine="label_pay.Tag = \"500\"";
Debug.ShouldStop(64);
parent.mostCurrent._label_pay.runMethod(false,"setTag",RemoteObject.createImmutable(("500")));
 if (true) break;

case 40:
//C
this.state = 41;
 BA.debugLineNum = 265;BA.debugLine="label_pay.Text =\"$500 + \"&(ti-15)&\" * $30\"&\" =";
Debug.ShouldStop(256);
parent.mostCurrent._label_pay.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("$500 + "),(RemoteObject.solve(new RemoteObject[] {_ti,RemoteObject.createImmutable(15)}, "-",1, 1)),RemoteObject.createImmutable(" * $30"),RemoteObject.createImmutable(" = $"),(BA.NumberToString((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(500),(RemoteObject.solve(new RemoteObject[] {_ti,RemoteObject.createImmutable(15)}, "-",1, 1)),RemoteObject.createImmutable(30)}, "+*",1, 1)))),RemoteObject.createImmutable(" pesos"))));
 BA.debugLineNum = 266;BA.debugLine="label_pay.Tag = (500 +(ti-15)*30).As(String)";
Debug.ShouldStop(512);
parent.mostCurrent._label_pay.runMethod(false,"setTag",((BA.NumberToString((RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(500),(RemoteObject.solve(new RemoteObject[] {_ti,RemoteObject.createImmutable(15)}, "-",1, 1)),RemoteObject.createImmutable(30)}, "+*",1, 1))))));
 if (true) break;

case 41:
//C
this.state = 42;
;
 if (true) break;

case 42:
//C
this.state = -1;
;
 BA.debugLineNum = 269;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("parked_today_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,387);
if (RapidSub.canDelegate("parked_today_click")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","parked_today_click");}
RemoteObject _time = RemoteObject.createImmutable("");
RemoteObject _da = RemoteObject.createImmutable("");
int _i = 0;
RemoteObject _p = RemoteObject.createImmutable("");
RemoteObject _d = RemoteObject.createImmutable("");
RemoteObject _h = RemoteObject.createImmutable("");
RemoteObject _pay = RemoteObject.createImmutable("");
 BA.debugLineNum = 387;BA.debugLine="Private Sub parked_today_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 388;BA.debugLine="Dim time,da As String";
Debug.ShouldStop(8);
_time = RemoteObject.createImmutable("");Debug.locals.put("time", _time);
_da = RemoteObject.createImmutable("");Debug.locals.put("da", _da);
 BA.debugLineNum = 389;BA.debugLine="time = DateTime.Now";
Debug.ShouldStop(16);
_time = BA.NumberToString(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));Debug.locals.put("time", _time);
 BA.debugLineNum = 390;BA.debugLine="da = DateTime.GetYear(time)&\"/\"&DateTime.GetMonth";
Debug.ShouldStop(32);
_da = RemoteObject.concat(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(BA.numberCast(long.class, _time))),RemoteObject.createImmutable("/"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(BA.numberCast(long.class, _time))));Debug.locals.put("da", _da);
 BA.debugLineNum = 393;BA.debugLine="query_selector=SQLite.ExecQuery(\"SELECT * FROM \"&";
Debug.ShouldStop(256);
main.mostCurrent._query_selector = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main._sqlite.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM "),main.mostCurrent._tables_db.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" WHERE date='"),_da,RemoteObject.createImmutable("' ORDER BY patent ASC")))));
 BA.debugLineNum = 394;BA.debugLine="parked_listview.clear";
Debug.ShouldStop(512);
main.mostCurrent._parked_listview.runVoidMethod ("Clear");
 BA.debugLineNum = 395;BA.debugLine="If query_selector.RowCount>0 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean(">",main.mostCurrent._query_selector.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 397;BA.debugLine="For i=0 To query_selector.RowCount-1";
Debug.ShouldStop(4096);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._query_selector.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 398;BA.debugLine="query_selector.Position=i";
Debug.ShouldStop(8192);
main.mostCurrent._query_selector.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 399;BA.debugLine="Dim p,d,h,pay As String";
Debug.ShouldStop(16384);
_p = RemoteObject.createImmutable("");Debug.locals.put("p", _p);
_d = RemoteObject.createImmutable("");Debug.locals.put("d", _d);
_h = RemoteObject.createImmutable("");Debug.locals.put("h", _h);
_pay = RemoteObject.createImmutable("");Debug.locals.put("pay", _pay);
 BA.debugLineNum = 400;BA.debugLine="p=query_selector.GetString(\"patent\")";
Debug.ShouldStop(32768);
_p = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("patent")));Debug.locals.put("p", _p);
 BA.debugLineNum = 401;BA.debugLine="d=query_selector.GetString(\"date\")";
Debug.ShouldStop(65536);
_d = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("date")));Debug.locals.put("d", _d);
 BA.debugLineNum = 402;BA.debugLine="h=query_selector.GetString(\"hour\")";
Debug.ShouldStop(131072);
_h = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("hour")));Debug.locals.put("h", _h);
 BA.debugLineNum = 403;BA.debugLine="pay=query_selector.GetString(\"payment\")";
Debug.ShouldStop(262144);
_pay = main.mostCurrent._query_selector.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("payment")));Debug.locals.put("pay", _pay);
 BA.debugLineNum = 404;BA.debugLine="parked_listview.AddSingleLine(p&\" \"&d&\" \"&h&\" \"";
Debug.ShouldStop(524288);
main.mostCurrent._parked_listview.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(_p,RemoteObject.createImmutable(" "),_d,RemoteObject.createImmutable(" "),_h,RemoteObject.createImmutable(" "),_pay))));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 408;BA.debugLine="label_main.Text = \"List of cars parked today\"";
Debug.ShouldStop(8388608);
main.mostCurrent._label_main.runMethod(true,"setText",BA.ObjectToCharSequence("List of cars parked today"));
 BA.debugLineNum = 409;BA.debugLine="flag = False";
Debug.ShouldStop(16777216);
main._flag = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 411;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("TabHost1_TabChanged (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,337);
if (RapidSub.canDelegate("tabhost1_tabchanged")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","tabhost1_tabchanged");}
 BA.debugLineNum = 337;BA.debugLine="Private Sub TabHost1_TabChanged";
Debug.ShouldStop(65536);
 BA.debugLineNum = 338;BA.debugLine="If TabHost1.CurrentTab = 0 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 339;BA.debugLine="label_main.Text = \"Enter car patent\"";
Debug.ShouldStop(262144);
main.mostCurrent._label_main.runMethod(true,"setText",BA.ObjectToCharSequence("Enter car patent"));
 BA.debugLineNum = 340;BA.debugLine="parked_listview.Clear";
Debug.ShouldStop(524288);
main.mostCurrent._parked_listview.runVoidMethod ("Clear");
 };
 BA.debugLineNum = 343;BA.debugLine="If TabHost1.CurrentTab = 1 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 344;BA.debugLine="label_main.Text = \"List cars\"";
Debug.ShouldStop(8388608);
main.mostCurrent._label_main.runMethod(true,"setText",BA.ObjectToCharSequence("List cars"));
 BA.debugLineNum = 345;BA.debugLine="parked_listview.Clear";
Debug.ShouldStop(16777216);
main.mostCurrent._parked_listview.runVoidMethod ("Clear");
 BA.debugLineNum = 346;BA.debugLine="label_id.Text = \"\"";
Debug.ShouldStop(33554432);
main.mostCurrent._label_id.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 347;BA.debugLine="label_patent.Text = \"\"";
Debug.ShouldStop(67108864);
main.mostCurrent._label_patent.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 348;BA.debugLine="label_date.Text = \"\"";
Debug.ShouldStop(134217728);
main.mostCurrent._label_date.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 349;BA.debugLine="label_start.Text = \"\"";
Debug.ShouldStop(268435456);
main.mostCurrent._label_start.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 350;BA.debugLine="label_end.Text = \"\"";
Debug.ShouldStop(536870912);
main.mostCurrent._label_end.runMethod(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 351;BA.debugLine="label_time.Text = \"0 minutes\"";
Debug.ShouldStop(1073741824);
main.mostCurrent._label_time.runMethod(true,"setText",BA.ObjectToCharSequence("0 minutes"));
 BA.debugLineNum = 352;BA.debugLine="label_time.Tag = \"\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._label_time.runMethod(false,"setTag",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 353;BA.debugLine="label_pay.Text = \"$ 0 pesos\"";
Debug.ShouldStop(1);
main.mostCurrent._label_pay.runMethod(true,"setText",BA.ObjectToCharSequence("$ 0 pesos"));
 BA.debugLineNum = 354;BA.debugLine="label_pay.Tag = \"\"";
Debug.ShouldStop(2);
main.mostCurrent._label_pay.runMethod(false,"setTag",RemoteObject.createImmutable(("")));
 };
 BA.debugLineNum = 357;BA.debugLine="If TabHost1.CurrentTab = 2 Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab"),BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 358;BA.debugLine="label_main.Text = \"Payment details\"";
Debug.ShouldStop(32);
main.mostCurrent._label_main.runMethod(true,"setText",BA.ObjectToCharSequence("Payment details"));
 BA.debugLineNum = 359;BA.debugLine="parked_listview.Clear";
Debug.ShouldStop(64);
main.mostCurrent._parked_listview.runVoidMethod ("Clear");
 };
 BA.debugLineNum = 361;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("update_record (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,322);
if (RapidSub.canDelegate("update_record")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","update_record", _name, _table, _en, _ti, _pay, _id);}
Debug.locals.put("name", _name);
Debug.locals.put("table", _table);
Debug.locals.put("en", _en);
Debug.locals.put("ti", _ti);
Debug.locals.put("pay", _pay);
Debug.locals.put("id", _id);
 BA.debugLineNum = 322;BA.debugLine="Sub update_record (name As String,table As String,";
Debug.ShouldStop(2);
 BA.debugLineNum = 324;BA.debugLine="SQLite.Initialize(File.DirInternal,name,True)";
Debug.ShouldStop(8);
main._sqlite.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_name),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 325;BA.debugLine="SQLite.BeginTransaction";
Debug.ShouldStop(16);
main._sqlite.runVoidMethod ("BeginTransaction");
 BA.debugLineNum = 326;BA.debugLine="Try";
Debug.ShouldStop(32);
try { BA.debugLineNum = 327;BA.debugLine="SQLite.ExecNonQuery(\"UPDATE \"&table&\" SET end =";
Debug.ShouldStop(64);
main._sqlite.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE "),_table,RemoteObject.createImmutable(" SET end = '"),_en,RemoteObject.createImmutable("', time = "),_ti,RemoteObject.createImmutable(", payment = "),_pay,RemoteObject.createImmutable(" where id = "),_id)));
 BA.debugLineNum = 328;BA.debugLine="SQLite.TransactionSuccessful";
Debug.ShouldStop(128);
main._sqlite.runVoidMethod ("TransactionSuccessful");
 BA.debugLineNum = 329;BA.debugLine="xui.MsgboxAsync(\"Update to id= \"&id, \"successful";
Debug.ShouldStop(256);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Update to id= "),_id))),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("successfully"))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e8) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e8.toString()); BA.debugLineNum = 331;BA.debugLine="ToastMessageShow(\"Update into failed: \"&table,Tr";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Update into failed: "),_table))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 332;BA.debugLine="Log(\"Update into failedd:\"&table&\", \"&LastExcept";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2786442",RemoteObject.concat(RemoteObject.createImmutable("Update into failedd:"),_table,RemoteObject.createImmutable(", "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")),0);
 };
 BA.debugLineNum = 334;BA.debugLine="SQLite.EndTransaction";
Debug.ShouldStop(8192);
main._sqlite.runVoidMethod ("EndTransaction");
 BA.debugLineNum = 335;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}