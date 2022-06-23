package b4a.EjemploSQLite;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.EjemploSQLite", "b4a.EjemploSQLite.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, true))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.EjemploSQLite", "b4a.EjemploSQLite.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.EjemploSQLite.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4a.sql.SQL _sqlite = null;
public anywheresoftware.b4a.objects.TabHostWrapper _tabhost1 = null;
public static String _name_db = "";
public anywheresoftware.b4a.objects.collections.List _tables_db = null;
public static String _table_cars = "";
public anywheresoftware.b4a.objects.LabelWrapper _customer_label_patent = null;
public anywheresoftware.b4a.objects.LabelWrapper _customer_background = null;
public anywheresoftware.b4a.objects.EditTextWrapper _customer_text_patent = null;
public anywheresoftware.b4a.objects.ButtonWrapper _customer_button_patent = null;
public anywheresoftware.b4a.objects.ButtonWrapper _customer_delete_table = null;
public anywheresoftware.b4a.objects.ListViewWrapper _parked_listview = null;
public anywheresoftware.b4a.objects.ButtonWrapper _parked_button = null;
public anywheresoftware.b4a.sql.SQL.CursorWrapper _query_selector = null;
public anywheresoftware.b4a.objects.LabelWrapper _info_background = null;
public anywheresoftware.b4a.objects.LabelWrapper _info_label_pay = null;
public anywheresoftware.b4a.objects.LabelWrapper _info_label_time = null;
public anywheresoftware.b4a.objects.LabelWrapper _info_label_end = null;
public anywheresoftware.b4a.objects.LabelWrapper _info_label_start = null;
public anywheresoftware.b4a.objects.LabelWrapper _info_label_date = null;
public anywheresoftware.b4a.objects.LabelWrapper _info_label_patent = null;
public anywheresoftware.b4a.objects.LabelWrapper _label_patent = null;
public anywheresoftware.b4a.objects.LabelWrapper _label_date = null;
public anywheresoftware.b4a.objects.LabelWrapper _label_start = null;
public anywheresoftware.b4a.objects.LabelWrapper _label_end = null;
public anywheresoftware.b4a.objects.LabelWrapper _label_time = null;
public anywheresoftware.b4a.objects.LabelWrapper _label_pay = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Activity.LoadLayout(\"Main\")";
mostCurrent._activity.LoadLayout("Main",mostCurrent.activityBA);
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="TabHost1.AddTab(\"Customer\",\"page_customer.bal\")";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"Customer","page_customer.bal");
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="TabHost1.AddTab(\"Parked\",\"page_parked.bal\")";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"Parked","page_parked.bal");
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="TabHost1.AddTab(\"Info\",\"page_info.bal\")";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"Info","page_info.bal");
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="name_db = \"parking_manager4.db\"";
mostCurrent._name_db = "parking_manager4.db";
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="tables_db.Initialize";
mostCurrent._tables_db.Initialize();
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="tables_db.AddAll(Array As String (\"cars\"))";
mostCurrent._tables_db.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"cars"}));
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="table_cars = \"(id INTEGER PRIMARY KEY AUTOINCREM";
mostCurrent._table_cars = "(id INTEGER PRIMARY KEY AUTOINCREMENT, patent TEXT, date TEXT, hour TEXT, end TEXT, time TEXT, payment FLOAT)";
RDebugUtils.currentLine=131089;
 //BA.debugLineNum = 131089;BA.debugLine="create_db(name_db,tables_db.Get(0), table_cars)";
_create_db(mostCurrent._name_db,BA.ObjectToString(mostCurrent._tables_db.Get((int) (0))),mostCurrent._table_cars);
 };
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="End Sub";
return "";
}
public static String  _create_db(String _name,String _table,String _col) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "create_db", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "create_db", new Object[] {_name,_table,_col}));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub create_db (name As String, table As String, co";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="SQLite.Initialize(File.DirInternal,name,True)";
_sqlite.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_name,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="SQLite.BeginTransaction";
_sqlite.BeginTransaction();
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="Try";
try {RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="SQLite.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS";
_sqlite.ExecNonQuery("CREATE TABLE IF NOT EXISTS "+_table+" "+_col);
RDebugUtils.currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="SQLite.TransactionSuccessful";
_sqlite.TransactionSuccessful();
RDebugUtils.currentLine=196614;
 //BA.debugLineNum = 196614;BA.debugLine="ToastMessageShow(\"Successfully created '\"&table&";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Successfully created '"+_table+"' table"),anywheresoftware.b4a.keywords.Common.True);
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=196616;
 //BA.debugLineNum = 196616;BA.debugLine="ToastMessageShow(\"Table creation failed: \"&table";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Table creation failed: "+_table),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=196617;
 //BA.debugLineNum = 196617;BA.debugLine="Log(\"Table creation failed:\"&table&\", \"&LastExce";
anywheresoftware.b4a.keywords.Common.LogImpl("2196617","Table creation failed:"+_table+", "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 };
RDebugUtils.currentLine=196619;
 //BA.debugLineNum = 196619;BA.debugLine="SQLite.EndTransaction";
_sqlite.EndTransaction();
RDebugUtils.currentLine=196620;
 //BA.debugLineNum = 196620;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _customer_button_patent_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "customer_button_patent_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "customer_button_patent_click", null));}
String _col = "";
String _patent = "";
String _date = "";
String _hour = "";
String _time = "";
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Private Sub customer_button_patent_Click";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="If customer_text_patent.Text = \"\" Then";
if ((mostCurrent._customer_text_patent.getText()).equals("")) { 
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="xui.MsgboxAsync(\"The patent does not exist, plea";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("The patent does not exist, please enter a patent."),BA.ObjectToCharSequence("Patent Error!"));
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="Dim col,patent,date,hour,time As String";
_col = "";
_patent = "";
_date = "";
_hour = "";
_time = "";
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="col = \"(patent, date, hour, end, time, payment)\"";
_col = "(patent, date, hour, end, time, payment)";
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="time = DateTime.Now";
_time = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="patent = customer_text_patent.Text";
_patent = mostCurrent._customer_text_patent.getText();
RDebugUtils.currentLine=393225;
 //BA.debugLineNum = 393225;BA.debugLine="date = DateTime.GetYear(time)&\"/\"&DateTime.GetMon";
_date = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetYear((long)(Double.parseDouble(_time))))+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMonth((long)(Double.parseDouble(_time))))+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfMonth((long)(Double.parseDouble(_time))));
RDebugUtils.currentLine=393227;
 //BA.debugLineNum = 393227;BA.debugLine="If DateTime.GetMinute(time).As(Int) <= 9 Then";
if ((anywheresoftware.b4a.keywords.Common.DateTime.GetMinute((long)(Double.parseDouble(_time))))<=9) { 
RDebugUtils.currentLine=393228;
 //BA.debugLineNum = 393228;BA.debugLine="hour = DateTime.GetHour(time)&\":0\"&DateTime.GetM";
_hour = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetHour((long)(Double.parseDouble(_time))))+":0"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMinute((long)(Double.parseDouble(_time))));
 }else {
RDebugUtils.currentLine=393230;
 //BA.debugLineNum = 393230;BA.debugLine="hour = DateTime.GetHour(time)&\":\"&DateTime.GetMi";
_hour = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetHour((long)(Double.parseDouble(_time))))+":"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMinute((long)(Double.parseDouble(_time))));
 };
RDebugUtils.currentLine=393232;
 //BA.debugLineNum = 393232;BA.debugLine="Log( DateTime.GetMinute(time).As(Int))";
anywheresoftware.b4a.keywords.Common.LogImpl("2393232",BA.NumberToString((anywheresoftware.b4a.keywords.Common.DateTime.GetMinute((long)(Double.parseDouble(_time))))),0);
RDebugUtils.currentLine=393233;
 //BA.debugLineNum = 393233;BA.debugLine="insert_into_table(name_db,tables_db.Get(0),col,pa";
_insert_into_table(mostCurrent._name_db,BA.ObjectToString(mostCurrent._tables_db.Get((int) (0))),_col,_patent,_date,_hour,"",BA.NumberToString(0),BA.NumberToString(0));
RDebugUtils.currentLine=393234;
 //BA.debugLineNum = 393234;BA.debugLine="customer_text_patent.Text = \"\"";
mostCurrent._customer_text_patent.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=393236;
 //BA.debugLineNum = 393236;BA.debugLine="End Sub";
return "";
}
public static String  _insert_into_table(String _name,String _table,String _col,String _i1,String _i2,String _i3,String _i4,String _i5,String _i6) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "insert_into_table", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "insert_into_table", new Object[] {_name,_table,_col,_i1,_i2,_i3,_i4,_i5,_i6}));}
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub insert_into_table (name As String,table As Str";
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="SQLite.Initialize(File.DirInternal,name,True)";
_sqlite.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_name,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="SQLite.BeginTransaction";
_sqlite.BeginTransaction();
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="Try";
try {RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="SQLite.ExecNonQuery2(\"INSERT INTO \"&table&\" \"&co";
_sqlite.ExecNonQuery2("INSERT INTO "+_table+" "+_col+" VALUES (?,?,?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_i1.toUpperCase()),(Object)(_i2),(Object)(_i3),(Object)(_i4),(Object)(_i5),(Object)(_i6)}));
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="SQLite.TransactionSuccessful";
_sqlite.TransactionSuccessful();
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="xui.MsgboxAsync(\"Patent: \"&i1.ToUpperCase&CRLF&\"";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Patent: "+_i1.toUpperCase()+anywheresoftware.b4a.keywords.Common.CRLF+"Date: "+_i2+anywheresoftware.b4a.keywords.Common.CRLF+"Hour: "+_i3+anywheresoftware.b4a.keywords.Common.CRLF+"End: "+_i4+anywheresoftware.b4a.keywords.Common.CRLF+"Time: "+_i5+anywheresoftware.b4a.keywords.Common.CRLF+"Payment: "+_i6),BA.ObjectToCharSequence("Insert into: "+_table+", successfully"));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=458761;
 //BA.debugLineNum = 458761;BA.debugLine="ToastMessageShow(\"Insert into failed: \"&table,Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Insert into failed: "+_table),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=458762;
 //BA.debugLineNum = 458762;BA.debugLine="Log(\"Insert into failedd:\"&table&\", \"&LastExcept";
anywheresoftware.b4a.keywords.Common.LogImpl("2458762","Insert into failedd:"+_table+", "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 };
RDebugUtils.currentLine=458764;
 //BA.debugLineNum = 458764;BA.debugLine="SQLite.EndTransaction";
_sqlite.EndTransaction();
RDebugUtils.currentLine=458765;
 //BA.debugLineNum = 458765;BA.debugLine="End Sub";
return "";
}
public static void  _customer_delete_table_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "customer_delete_table_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "customer_delete_table_click", null); return;}
ResumableSub_customer_delete_table_click rsub = new ResumableSub_customer_delete_table_click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_customer_delete_table_click extends BA.ResumableSub {
public ResumableSub_customer_delete_table_click(b4a.EjemploSQLite.main parent) {
this.parent = parent;
}
b4a.EjemploSQLite.main parent;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="Msgbox2Async(\"¿Desea borrar la tabla \"&tables_db.";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("¿Desea borrar la tabla "+BA.ObjectToString(parent.mostCurrent._tables_db.Get((int) (0)))+"?"),BA.ObjectToCharSequence("Atención!"),"Si","Cancelar","No",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="Wait For Msgbox_Result(Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "customer_delete_table_click"), null);
this.state = 11;
return;
case 11:
//C
this.state = 1;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 1:
//if
this.state = 10;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="SQLite.Initialize(File.DirInternal,name_db,True)";
parent._sqlite.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),parent.mostCurrent._name_db,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=655368;
 //BA.debugLineNum = 655368;BA.debugLine="SQLite.BeginTransaction";
parent._sqlite.BeginTransaction();
RDebugUtils.currentLine=655369;
 //BA.debugLineNum = 655369;BA.debugLine="Try";
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
RDebugUtils.currentLine=655370;
 //BA.debugLineNum = 655370;BA.debugLine="SQLite.ExecNonQuery(\"DELETE FROM \"&tables_db.Ge";
parent._sqlite.ExecNonQuery("DELETE FROM "+BA.ObjectToString(parent.mostCurrent._tables_db.Get((int) (0))));
RDebugUtils.currentLine=655372;
 //BA.debugLineNum = 655372;BA.debugLine="ToastMessageShow(\"Registros de la tabla: \"&tabl";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Registros de la tabla: "+BA.ObjectToString(parent.mostCurrent._tables_db.Get((int) (0)))+", eliminados"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=655373;
 //BA.debugLineNum = 655373;BA.debugLine="SQLite.TransactionSuccessful";
parent._sqlite.TransactionSuccessful();
 if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 0;
RDebugUtils.currentLine=655375;
 //BA.debugLineNum = 655375;BA.debugLine="Log(\"ERROR al elminar tabla: \"&tables_db.Get(0)";
anywheresoftware.b4a.keywords.Common.LogImpl("2655375","ERROR al elminar tabla: "+BA.ObjectToString(parent.mostCurrent._tables_db.Get((int) (0)))+" ,"+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 if (true) break;
if (true) break;

case 9:
//C
this.state = 10;
this.catchState = 0;
;
RDebugUtils.currentLine=655377;
 //BA.debugLineNum = 655377;BA.debugLine="SQLite.EndTransaction";
parent._sqlite.EndTransaction();
 if (true) break;

case 10:
//C
this.state = -1;
;
RDebugUtils.currentLine=655383;
 //BA.debugLineNum = 655383;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static String  _parked_button_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "parked_button_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "parked_button_click", null));}
int _i = 0;
String _p = "";
String _d = "";
String _h = "";
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub parked_button_Click";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="query_selector=SQLite.ExecQuery(\"SELECT * FROM \"&";
mostCurrent._query_selector = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sqlite.ExecQuery("SELECT * FROM "+BA.ObjectToString(mostCurrent._tables_db.Get((int) (0)))+" WHERE payment=0 ORDER BY patent ASC")));
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="parked_listview.clear";
mostCurrent._parked_listview.Clear();
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="If query_selector.RowCount>0 Then";
if (mostCurrent._query_selector.getRowCount()>0) { 
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="For i=0 To query_selector.RowCount-1";
{
final int step4 = 1;
final int limit4 = (int) (mostCurrent._query_selector.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="query_selector.Position=i";
mostCurrent._query_selector.setPosition(_i);
RDebugUtils.currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="Dim p,d,h As String";
_p = "";
_d = "";
_h = "";
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="p=query_selector.GetString(\"patent\")";
_p = mostCurrent._query_selector.GetString("patent");
RDebugUtils.currentLine=524297;
 //BA.debugLineNum = 524297;BA.debugLine="d=query_selector.GetString(\"date\")";
_d = mostCurrent._query_selector.GetString("date");
RDebugUtils.currentLine=524298;
 //BA.debugLineNum = 524298;BA.debugLine="h=query_selector.GetString(\"hour\")";
_h = mostCurrent._query_selector.GetString("hour");
RDebugUtils.currentLine=524299;
 //BA.debugLineNum = 524299;BA.debugLine="parked_listview.AddSingleLine(p&\" \"&d&\" \"&h)";
mostCurrent._parked_listview.AddSingleLine(BA.ObjectToCharSequence(_p+" "+_d+" "+_h));
 }
};
 };
RDebugUtils.currentLine=524302;
 //BA.debugLineNum = 524302;BA.debugLine="End Sub";
return "";
}
public static void  _parked_listview_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "parked_listview_itemclick", false))
	 {Debug.delegate(mostCurrent.activityBA, "parked_listview_itemclick", new Object[] {_position,_value}); return;}
ResumableSub_parked_listview_ItemClick rsub = new ResumableSub_parked_listview_ItemClick(null,_position,_value);
rsub.resume(processBA, null);
}
public static class ResumableSub_parked_listview_ItemClick extends BA.ResumableSub {
public ResumableSub_parked_listview_ItemClick(b4a.EjemploSQLite.main parent,int _position,Object _value) {
this.parent = parent;
this._position = _position;
this._value = _value;
}
b4a.EjemploSQLite.main parent;
int _position;
Object _value;
Object _sf = null;
int _result = 0;
String _time = "";
int _mi = 0;
int _ho = 0;
int _ti = 0;
String _da = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="Dim sf As Object = Msgbox2Async(\"Press YES to ace";
_sf = anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Press YES to acept or NO to decline"),BA.ObjectToCharSequence("Do you want to pay?"),"YES","CANCEL","NO",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="Wait For (sf) Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "parked_listview_itemclick"), _sf);
this.state = 35;
return;
case 35:
//C
this.state = 1;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 1:
//if
this.state = 34;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="TabHost1.CurrentTab = (TabHost1.CurrentTab + 1)";
parent.mostCurrent._tabhost1.setCurrentTab((int) ((parent.mostCurrent._tabhost1.getCurrentTab()+1)%parent.mostCurrent._tabhost1.getTabCount()));
RDebugUtils.currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="query_selector.Position=Position";
parent.mostCurrent._query_selector.setPosition(_position);
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="Dim time As String";
_time = "";
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="time = DateTime.Now";
_time = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=589833;
 //BA.debugLineNum = 589833;BA.debugLine="Dim mi,ho,ti As Int";
_mi = 0;
_ho = 0;
_ti = 0;
RDebugUtils.currentLine=589834;
 //BA.debugLineNum = 589834;BA.debugLine="Dim da As String";
_da = "";
RDebugUtils.currentLine=589837;
 //BA.debugLineNum = 589837;BA.debugLine="label_patent.Text = query_selector.GetString(\"pa";
parent.mostCurrent._label_patent.setText(BA.ObjectToCharSequence(parent.mostCurrent._query_selector.GetString("patent")));
RDebugUtils.currentLine=589838;
 //BA.debugLineNum = 589838;BA.debugLine="label_date.Text = query_selector.GetString(\"date";
parent.mostCurrent._label_date.setText(BA.ObjectToCharSequence(parent.mostCurrent._query_selector.GetString("date")));
RDebugUtils.currentLine=589839;
 //BA.debugLineNum = 589839;BA.debugLine="label_start.Text = query_selector.GetString(\"hou";
parent.mostCurrent._label_start.setText(BA.ObjectToCharSequence(parent.mostCurrent._query_selector.GetString("hour")));
RDebugUtils.currentLine=589841;
 //BA.debugLineNum = 589841;BA.debugLine="da = DateTime.GetYear(time)&\"/\"&DateTime.GetMont";
_da = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetYear((long)(Double.parseDouble(_time))))+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMonth((long)(Double.parseDouble(_time))))+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfMonth((long)(Double.parseDouble(_time))));
RDebugUtils.currentLine=589842;
 //BA.debugLineNum = 589842;BA.debugLine="If da <> query_selector.GetString(\"date\") Then";
if (true) break;

case 4:
//if
this.state = 15;
if ((_da).equals(parent.mostCurrent._query_selector.GetString("date")) == false) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 15;
RDebugUtils.currentLine=589843;
 //BA.debugLineNum = 589843;BA.debugLine="Log(\"distintos dias\")";
anywheresoftware.b4a.keywords.Common.LogImpl("2589843","distintos dias",0);
RDebugUtils.currentLine=589844;
 //BA.debugLineNum = 589844;BA.debugLine="label_end.Text = \"23:59\"";
parent.mostCurrent._label_end.setText(BA.ObjectToCharSequence("23:59"));
 if (true) break;

case 8:
//C
this.state = 9;
RDebugUtils.currentLine=589846;
 //BA.debugLineNum = 589846;BA.debugLine="If DateTime.GetMinute(time).As(Int) <= 9 Then";
if (true) break;

case 9:
//if
this.state = 14;
if ((anywheresoftware.b4a.keywords.Common.DateTime.GetMinute((long)(Double.parseDouble(_time))))<=9) { 
this.state = 11;
}else {
this.state = 13;
}if (true) break;

case 11:
//C
this.state = 14;
RDebugUtils.currentLine=589847;
 //BA.debugLineNum = 589847;BA.debugLine="label_end.Text = DateTime.GetHour(time).As(Str";
parent.mostCurrent._label_end.setText(BA.ObjectToCharSequence((BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetHour((long)(Double.parseDouble(_time)))))+":0"+(BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMinute((long)(Double.parseDouble(_time)))))));
 if (true) break;

case 13:
//C
this.state = 14;
RDebugUtils.currentLine=589849;
 //BA.debugLineNum = 589849;BA.debugLine="label_end.Text = DateTime.GetHour(time).As(Str";
parent.mostCurrent._label_end.setText(BA.ObjectToCharSequence((BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetHour((long)(Double.parseDouble(_time)))))+":"+(BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMinute((long)(Double.parseDouble(_time)))))));
 if (true) break;

case 14:
//C
this.state = 15;
;
 if (true) break;

case 15:
//C
this.state = 16;
;
RDebugUtils.currentLine=589853;
 //BA.debugLineNum = 589853;BA.debugLine="ho = (label_end.Text.SubString2(0,2)).As(Int)-(l";
_ho = (int) (((int)(Double.parseDouble((parent.mostCurrent._label_end.getText().substring((int) (0),(int) (2))))))-((int)(Double.parseDouble((parent.mostCurrent._label_start.getText().substring((int) (0),(int) (2)))))));
RDebugUtils.currentLine=589854;
 //BA.debugLineNum = 589854;BA.debugLine="mi = (label_end.Text.SubString2(3,5)).As(Int)-(l";
_mi = (int) (((int)(Double.parseDouble((parent.mostCurrent._label_end.getText().substring((int) (3),(int) (5))))))-((int)(Double.parseDouble((parent.mostCurrent._label_start.getText().substring((int) (3),(int) (5)))))));
RDebugUtils.currentLine=589855;
 //BA.debugLineNum = 589855;BA.debugLine="If ho = 0 Then";
if (true) break;

case 16:
//if
this.state = 27;
if (_ho==0) { 
this.state = 18;
}else {
this.state = 20;
}if (true) break;

case 18:
//C
this.state = 27;
RDebugUtils.currentLine=589856;
 //BA.debugLineNum = 589856;BA.debugLine="ti = mi";
_ti = _mi;
 if (true) break;

case 20:
//C
this.state = 21;
RDebugUtils.currentLine=589858;
 //BA.debugLineNum = 589858;BA.debugLine="If mi >= 0 Then";
if (true) break;

case 21:
//if
this.state = 26;
if (_mi>=0) { 
this.state = 23;
}else {
this.state = 25;
}if (true) break;

case 23:
//C
this.state = 26;
RDebugUtils.currentLine=589859;
 //BA.debugLineNum = 589859;BA.debugLine="ti = ho*60 + mi";
_ti = (int) (_ho*60+_mi);
 if (true) break;

case 25:
//C
this.state = 26;
RDebugUtils.currentLine=589861;
 //BA.debugLineNum = 589861;BA.debugLine="ho = ho - 1";
_ho = (int) (_ho-1);
RDebugUtils.currentLine=589862;
 //BA.debugLineNum = 589862;BA.debugLine="mi = mi + 60";
_mi = (int) (_mi+60);
RDebugUtils.currentLine=589863;
 //BA.debugLineNum = 589863;BA.debugLine="ti = ho*60 + mi";
_ti = (int) (_ho*60+_mi);
 if (true) break;

case 26:
//C
this.state = 27;
;
 if (true) break;

case 27:
//C
this.state = 28;
;
RDebugUtils.currentLine=589866;
 //BA.debugLineNum = 589866;BA.debugLine="label_time.Text = ti&\" minutes\"";
parent.mostCurrent._label_time.setText(BA.ObjectToCharSequence(BA.NumberToString(_ti)+" minutes"));
RDebugUtils.currentLine=589867;
 //BA.debugLineNum = 589867;BA.debugLine="If ti < 15 Then";
if (true) break;

case 28:
//if
this.state = 33;
if (_ti<15) { 
this.state = 30;
}else {
this.state = 32;
}if (true) break;

case 30:
//C
this.state = 33;
RDebugUtils.currentLine=589868;
 //BA.debugLineNum = 589868;BA.debugLine="label_pay.Text = \"$ 500\"";
parent.mostCurrent._label_pay.setText(BA.ObjectToCharSequence("$ 500"));
 if (true) break;

case 32:
//C
this.state = 33;
RDebugUtils.currentLine=589870;
 //BA.debugLineNum = 589870;BA.debugLine="label_pay.Text =\"$500 + \"&(ti-15)&\" * $30\"&\" =";
parent.mostCurrent._label_pay.setText(BA.ObjectToCharSequence("$500 + "+BA.NumberToString((_ti-15))+" * $30"+" = $"+(BA.NumberToString((500+(_ti-15)*30)))));
 if (true) break;

case 33:
//C
this.state = 34;
;
 if (true) break;

case 34:
//C
this.state = -1;
;
RDebugUtils.currentLine=589875;
 //BA.debugLineNum = 589875;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
}