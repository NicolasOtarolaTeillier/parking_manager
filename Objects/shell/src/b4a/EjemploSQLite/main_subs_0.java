package b4a.EjemploSQLite;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,24);
if (RapidSub.canDelegate("activity_create")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"Main\")";
Debug.ShouldStop(16777216);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Main")),main.mostCurrent.activityBA);
 BA.debugLineNum = 26;BA.debugLine="TabHost1.AddTab(\"cliente\",\"page_clientes.bal\")";
Debug.ShouldStop(33554432);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("cliente")),(Object)(RemoteObject.createImmutable("page_clientes.bal")));
 BA.debugLineNum = 27;BA.debugLine="TabHost1.AddTab(\"pagos\",\"page_pagos.bal\")";
Debug.ShouldStop(67108864);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("pagos")),(Object)(RemoteObject.createImmutable("page_pagos.bal")));
 BA.debugLineNum = 28;BA.debugLine="TabHost1.AddTab(\"fecha\",\"page_fecha.bal\")";
Debug.ShouldStop(134217728);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("fecha")),(Object)(RemoteObject.createImmutable("page_fecha.bal")));
 BA.debugLineNum = 29;BA.debugLine="TabHost1.AddTab(\"info\",\"page_info.bal\")";
Debug.ShouldStop(268435456);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("info")),(Object)(RemoteObject.createImmutable("page_info.bal")));
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,36);
if (RapidSub.canDelegate("activity_pause")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 36;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8);
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,32);
if (RapidSub.canDelegate("activity_resume")) { return b4a.EjemploSQLite.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 34;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 18;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 20;BA.debugLine="Private TabHost1 As TabHost";
main.mostCurrent._tabhost1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.TabHostWrapper");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}