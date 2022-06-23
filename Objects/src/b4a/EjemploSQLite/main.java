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
	public static final boolean fullScreen = false;
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
public anywheresoftware.b4a.objects.LabelWrapper _label_main = null;
public static String _name_db = "";
public anywheresoftware.b4a.objects.collections.List _tables_db = null;
public static String _table_cars = "";
public anywheresoftware.b4a.objects.LabelWrapper _customer_label_patent = null;
public anywheresoftware.b4a.objects.LabelWrapper _customer_background = null;
public anywheresoftware.b4a.objects.EditTextWrapper _customer_text_patent = null;
public anywheresoftware.b4a.objects.ButtonWrapper _customer_button_patent = null;
public anywheresoftware.b4a.objects.ButtonWrapper _customer_delete_table = null;
public anywheresoftware.b4a.objects.EditTextWrapper _label_hour = null;
public anywheresoftware.b4a.objects.LabelWrapper _labe_ = null;
public anywheresoftware.b4a.objects.EditTextWrapper _label_minute = null;
public anywheresoftware.b4a.objects.ListViewWrapper _parked_listview = null;
public anywheresoftware.b4a.objects.ButtonWrapper _parked_button = null;
public anywheresoftware.b4a.objects.ButtonWrapper _parked_today = null;
public anywheresoftware.b4a.objects.ButtonWrapper _parked_leave = null;
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
public anywheresoftware.b4a.objects.LabelWrapper _label_id = null;
public anywheresoftware.b4a.objects.ButtonWrapper _info_button_pay = null;
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
RDebugUtils.currentLine=131093;
 //BA.debugLineNum = 131093;BA.debugLine="label_main.Text = \"Enter car patent\"";
mostCurrent._label_main.setText(BA.ObjectToCharSequence("Enter car patent"));
RDebugUtils.currentLine=131095;
 //BA.debugLineNum = 131095;BA.debugLine="End Sub";
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
anywheresoftware.b4a.keywords.Common.LogImpl("5196617","Table creation failed:"+_table+", "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
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
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="If customer_text_patent.Text = \"\" Then";
if ((mostCurrent._customer_text_patent.getText()).equals("")) { 
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="xui.MsgboxAsync(\"The patent does not exist, plea";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("The patent does not exist, please enter a patent."),BA.ObjectToCharSequence("Patent Error!"));
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="Dim col,patent,date,hour,time As String";
_col = "";
_patent = "";
_date = "";
_hour = "";
_time = "";
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="col = \"(patent, date, hour, end, time, payment)\"";
_col = "(patent, date, hour, end, time, payment)";
RDebugUtils.currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="time = DateTime.Now";
_time = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=393225;
 //BA.debugLineNum = 393225;BA.debugLine="patent = customer_text_patent.Text";
_patent = mostCurrent._customer_text_patent.getText();
RDebugUtils.currentLine=393226;
 //BA.debugLineNum = 393226;BA.debugLine="date = DateTime.GetYear(time)&\"/\"&DateTime.GetMon";
_date = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetYear((long)(Double.parseDouble(_time))))+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMonth((long)(Double.parseDouble(_time))))+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfMonth((long)(Double.parseDouble(_time))));
RDebugUtils.currentLine=393227;
 //BA.debugLineNum = 393227;BA.debugLine="If label_hour.Text = \"\" Then";
if ((mostCurrent._label_hour.getText()).equals("")) { 
RDebugUtils.currentLine=393228;
 //BA.debugLineNum = 393228;BA.debugLine="If DateTime.GetMinute(time).As(Int) <= 9 Then";
if ((anywheresoftware.b4a.keywords.Common.DateTime.GetMinute((long)(Double.parseDouble(_time))))<=9) { 
RDebugUtils.currentLine=393229;
 //BA.debugLineNum = 393229;BA.debugLine="If DateTime.GetHour(time).As(Int) <= 9 Then";
if ((anywheresoftware.b4a.keywords.Common.DateTime.GetHour((long)(Double.parseDouble(_time))))<=9) { 
RDebugUtils.currentLine=393230;
 //BA.debugLineNum = 393230;BA.debugLine="hour = \"0\"&DateTime.GetHour(time)&\":0\"&DateTim";
_hour = "0"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetHour((long)(Double.parseDouble(_time))))+":0"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMinute((long)(Double.parseDouble(_time))));
 }else {
RDebugUtils.currentLine=393232;
 //BA.debugLineNum = 393232;BA.debugLine="hour = DateTime.GetHour(time)&\":0\"&DateTime.Ge";
_hour = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetHour((long)(Double.parseDouble(_time))))+":0"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMinute((long)(Double.parseDouble(_time))));
 };
 }else {
RDebugUtils.currentLine=393235;
 //BA.debugLineNum = 393235;BA.debugLine="If DateTime.GetHour(time).As(Int) <= 9 Then";
if ((anywheresoftware.b4a.keywords.Common.DateTime.GetHour((long)(Double.parseDouble(_time))))<=9) { 
RDebugUtils.currentLine=393236;
 //BA.debugLineNum = 393236;BA.debugLine="hour = \"0\"&DateTime.GetHour(time)&\":\"&DateTime";
_hour = "0"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetHour((long)(Double.parseDouble(_time))))+":"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMinute((long)(Double.parseDouble(_time))));
 }else {
RDebugUtils.currentLine=393238;
 //BA.debugLineNum = 393238;BA.debugLine="hour = DateTime.GetHour(time)&\":\"&DateTime.Get";
_hour = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetHour((long)(Double.parseDouble(_time))))+":"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMinute((long)(Double.parseDouble(_time))));
 };
 };
 }else {
RDebugUtils.currentLine=393242;
 //BA.debugLineNum = 393242;BA.debugLine="If label_minute.Text = \"\" Or label_minute.Text.A";
if ((mostCurrent._label_minute.getText()).equals("") || ((int)(Double.parseDouble(mostCurrent._label_minute.getText())))<0 || ((int)(Double.parseDouble(mostCurrent._label_minute.getText())))>59) { 
RDebugUtils.currentLine=393243;
 //BA.debugLineNum = 393243;BA.debugLine="xui.MsgboxAsync(\"The minutes does not correct,";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("The minutes does not correct, please enter a valid minutes."),BA.ObjectToCharSequence("Minute Error!"));
RDebugUtils.currentLine=393244;
 //BA.debugLineNum = 393244;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=393247;
 //BA.debugLineNum = 393247;BA.debugLine="If label_hour.Text.As(Int) < 0 Or label_hour.Tex";
if (((int)(Double.parseDouble(mostCurrent._label_hour.getText())))<0 || ((int)(Double.parseDouble(mostCurrent._label_hour.getText())))>=24) { 
RDebugUtils.currentLine=393248;
 //BA.debugLineNum = 393248;BA.debugLine="xui.MsgboxAsync(\"The hour does not correct, ple";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("The hour does not correct, please enter a valid hour."),BA.ObjectToCharSequence("Hour Error!"));
RDebugUtils.currentLine=393249;
 //BA.debugLineNum = 393249;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=393252;
 //BA.debugLineNum = 393252;BA.debugLine="If label_hour.Text.As(Int) <= 9 Then";
if (((int)(Double.parseDouble(mostCurrent._label_hour.getText())))<=9) { 
RDebugUtils.currentLine=393253;
 //BA.debugLineNum = 393253;BA.debugLine="If label_minute.Text.As(Int) <=9 Then";
if (((int)(Double.parseDouble(mostCurrent._label_minute.getText())))<=9) { 
RDebugUtils.currentLine=393254;
 //BA.debugLineNum = 393254;BA.debugLine="hour = \"0\"&label_hour.Text.as(Int)&\":0\"&label_";
_hour = "0"+BA.NumberToString(((int)(Double.parseDouble(mostCurrent._label_hour.getText()))))+":0"+BA.NumberToString(((int)(Double.parseDouble(mostCurrent._label_minute.getText()))));
 }else {
RDebugUtils.currentLine=393256;
 //BA.debugLineNum = 393256;BA.debugLine="hour = \"0\"&label_hour.Text.as(Int)&\":\"&label_m";
_hour = "0"+BA.NumberToString(((int)(Double.parseDouble(mostCurrent._label_hour.getText()))))+":"+BA.NumberToString(((int)(Double.parseDouble(mostCurrent._label_minute.getText()))));
 };
 }else {
RDebugUtils.currentLine=393259;
 //BA.debugLineNum = 393259;BA.debugLine="If label_minute.Text.As(Int) <=9 Then";
if (((int)(Double.parseDouble(mostCurrent._label_minute.getText())))<=9) { 
RDebugUtils.currentLine=393260;
 //BA.debugLineNum = 393260;BA.debugLine="hour = label_hour.Text.as(Int)&\":0\"&label_minu";
_hour = BA.NumberToString(((int)(Double.parseDouble(mostCurrent._label_hour.getText()))))+":0"+BA.NumberToString(((int)(Double.parseDouble(mostCurrent._label_minute.getText()))));
 }else {
RDebugUtils.currentLine=393262;
 //BA.debugLineNum = 393262;BA.debugLine="hour = label_hour.Text.as(Int)&\":\"&label_minut";
_hour = BA.NumberToString(((int)(Double.parseDouble(mostCurrent._label_hour.getText()))))+":"+BA.NumberToString(((int)(Double.parseDouble(mostCurrent._label_minute.getText()))));
 };
 };
 };
RDebugUtils.currentLine=393266;
 //BA.debugLineNum = 393266;BA.debugLine="insert_into_table(name_db,tables_db.Get(0),col,pa";
_insert_into_table(mostCurrent._name_db,BA.ObjectToString(mostCurrent._tables_db.Get((int) (0))),_col,_patent,_date,_hour,"","",BA.NumberToString(0));
RDebugUtils.currentLine=393267;
 //BA.debugLineNum = 393267;BA.debugLine="customer_text_patent.Text = \"\"";
mostCurrent._customer_text_patent.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=393268;
 //BA.debugLineNum = 393268;BA.debugLine="label_hour.Text = \"\"";
mostCurrent._label_hour.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=393269;
 //BA.debugLineNum = 393269;BA.debugLine="label_minute.Text = \"\"";
mostCurrent._label_minute.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=393271;
 //BA.debugLineNum = 393271;BA.debugLine="End Sub";
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
anywheresoftware.b4a.keywords.Common.LogImpl("5458762","Insert into failedd:"+_table+", "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
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
anywheresoftware.b4a.keywords.Common.LogImpl("5655375","ERROR al elminar tabla: "+BA.ObjectToString(parent.mostCurrent._tables_db.Get((int) (0)))+" ,"+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
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
public static String  _info_button_pay_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "info_button_pay_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "info_button_pay_click", null));}
String _pat = "";
String _dat = "";
String _sta = "";
String _en = "";
String _tim = "";
String _pay = "";
String _id = "";
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Private Sub info_button_pay_Click";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="If label_patent.Text = \"\" Then";
if ((mostCurrent._label_patent.getText()).equals("")) { 
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="xui.MsgboxAsync(\"The patent does not exist, plea";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("The patent does not exist, please enter a patent."),BA.ObjectToCharSequence("Patent Error!"));
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="Dim pat,dat,sta,en,tim,pay,id As String";
_pat = "";
_dat = "";
_sta = "";
_en = "";
_tim = "";
_pay = "";
_id = "";
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="id = label_id.Text";
_id = mostCurrent._label_id.getText();
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="pat = label_patent.Text";
_pat = mostCurrent._label_patent.getText();
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="dat = label_date.Text";
_dat = mostCurrent._label_date.getText();
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="sta = label_start.Text";
_sta = mostCurrent._label_start.getText();
RDebugUtils.currentLine=720906;
 //BA.debugLineNum = 720906;BA.debugLine="en = label_end.Text";
_en = mostCurrent._label_end.getText();
RDebugUtils.currentLine=720907;
 //BA.debugLineNum = 720907;BA.debugLine="tim = label_time.Tag";
_tim = BA.ObjectToString(mostCurrent._label_time.getTag());
RDebugUtils.currentLine=720908;
 //BA.debugLineNum = 720908;BA.debugLine="pay = label_pay.Tag.As(Float)";
_pay = BA.NumberToString(((float)(BA.ObjectToNumber(mostCurrent._label_pay.getTag()))));
RDebugUtils.currentLine=720909;
 //BA.debugLineNum = 720909;BA.debugLine="update_record(name_db,tables_db.Get(0),en,tim,pay";
_update_record(mostCurrent._name_db,BA.ObjectToString(mostCurrent._tables_db.Get((int) (0))),_en,_tim,(float)(Double.parseDouble(_pay)),_id);
RDebugUtils.currentLine=720910;
 //BA.debugLineNum = 720910;BA.debugLine="label_id.Text = \"\"";
mostCurrent._label_id.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=720911;
 //BA.debugLineNum = 720911;BA.debugLine="label_patent.Text = \"\"";
mostCurrent._label_patent.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=720912;
 //BA.debugLineNum = 720912;BA.debugLine="label_date.Text = \"\"";
mostCurrent._label_date.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=720913;
 //BA.debugLineNum = 720913;BA.debugLine="label_start.Text = \"\"";
mostCurrent._label_start.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=720914;
 //BA.debugLineNum = 720914;BA.debugLine="label_end.Text = \"\"";
mostCurrent._label_end.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=720915;
 //BA.debugLineNum = 720915;BA.debugLine="label_time.Tag = \"\"";
mostCurrent._label_time.setTag((Object)(""));
RDebugUtils.currentLine=720916;
 //BA.debugLineNum = 720916;BA.debugLine="label_time.Text = \"0 minutes\"";
mostCurrent._label_time.setText(BA.ObjectToCharSequence("0 minutes"));
RDebugUtils.currentLine=720917;
 //BA.debugLineNum = 720917;BA.debugLine="label_pay.Tag = \"\"";
mostCurrent._label_pay.setTag((Object)(""));
RDebugUtils.currentLine=720918;
 //BA.debugLineNum = 720918;BA.debugLine="label_pay.Text = \"$ 0\"";
mostCurrent._label_pay.setText(BA.ObjectToCharSequence("$ 0"));
RDebugUtils.currentLine=720920;
 //BA.debugLineNum = 720920;BA.debugLine="End Sub";
return "";
}
public static String  _update_record(String _name,String _table,String _en,String _ti,float _pay,String _id) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "update_record", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "update_record", new Object[] {_name,_table,_en,_ti,_pay,_id}));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub update_record (name As String,table As String,";
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="SQLite.Initialize(File.DirInternal,name,True)";
_sqlite.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_name,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="SQLite.BeginTransaction";
_sqlite.BeginTransaction();
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="Try";
try {RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="SQLite.ExecNonQuery(\"UPDATE \"&table&\" SET end =";
_sqlite.ExecNonQuery("UPDATE "+_table+" SET end = '"+_en+"', time = "+_ti+", payment = "+BA.NumberToString(_pay)+" where id = "+_id);
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="SQLite.TransactionSuccessful";
_sqlite.TransactionSuccessful();
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="xui.MsgboxAsync(\"Update to id= \"&id, \"successful";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Update to id= "+_id),BA.ObjectToCharSequence("successfully"));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=786441;
 //BA.debugLineNum = 786441;BA.debugLine="ToastMessageShow(\"Update into failed: \"&table,Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Update into failed: "+_table),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786442;
 //BA.debugLineNum = 786442;BA.debugLine="Log(\"Update into failedd:\"&table&\", \"&LastExcept";
anywheresoftware.b4a.keywords.Common.LogImpl("5786442","Update into failedd:"+_table+", "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 };
RDebugUtils.currentLine=786444;
 //BA.debugLineNum = 786444;BA.debugLine="SQLite.EndTransaction";
_sqlite.EndTransaction();
RDebugUtils.currentLine=786445;
 //BA.debugLineNum = 786445;BA.debugLine="End Sub";
return "";
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
 //BA.debugLineNum = 524302;BA.debugLine="label_main.Text = \"List of cars parked\"";
mostCurrent._label_main.setText(BA.ObjectToCharSequence("List of cars parked"));
RDebugUtils.currentLine=524303;
 //BA.debugLineNum = 524303;BA.debugLine="End Sub";
return "";
}
public static String  _parked_leave_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "parked_leave_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "parked_leave_click", null));}
String _time = "";
String _da = "";
int _i = 0;
String _p = "";
String _d = "";
String _h = "";
String _pay = "";
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Private Sub parked_leave_Click";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="Dim time,da As String";
_time = "";
_da = "";
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="time = DateTime.Now";
_time = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="da = DateTime.GetYear(time)&\"/\"&DateTime.GetMonth";
_da = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetYear((long)(Double.parseDouble(_time))))+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMonth((long)(Double.parseDouble(_time))))+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfMonth((long)(Double.parseDouble(_time))));
RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="query_selector=SQLite.ExecQuery(\"SELECT * FROM \"&";
mostCurrent._query_selector = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sqlite.ExecQuery("SELECT * FROM "+BA.ObjectToString(mostCurrent._tables_db.Get((int) (0)))+" WHERE date='"+_da+"' and payment > 0 ORDER BY patent ASC")));
RDebugUtils.currentLine=917511;
 //BA.debugLineNum = 917511;BA.debugLine="parked_listview.clear";
mostCurrent._parked_listview.Clear();
RDebugUtils.currentLine=917512;
 //BA.debugLineNum = 917512;BA.debugLine="If query_selector.RowCount>0 Then";
if (mostCurrent._query_selector.getRowCount()>0) { 
RDebugUtils.currentLine=917513;
 //BA.debugLineNum = 917513;BA.debugLine="For i=0 To query_selector.RowCount-1";
{
final int step7 = 1;
final int limit7 = (int) (mostCurrent._query_selector.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
RDebugUtils.currentLine=917514;
 //BA.debugLineNum = 917514;BA.debugLine="query_selector.Position=i";
mostCurrent._query_selector.setPosition(_i);
RDebugUtils.currentLine=917515;
 //BA.debugLineNum = 917515;BA.debugLine="Dim p,d,h,pay As String";
_p = "";
_d = "";
_h = "";
_pay = "";
RDebugUtils.currentLine=917516;
 //BA.debugLineNum = 917516;BA.debugLine="p=query_selector.GetString(\"patent\")";
_p = mostCurrent._query_selector.GetString("patent");
RDebugUtils.currentLine=917519;
 //BA.debugLineNum = 917519;BA.debugLine="pay=query_selector.GetString(\"payment\")";
_pay = mostCurrent._query_selector.GetString("payment");
RDebugUtils.currentLine=917521;
 //BA.debugLineNum = 917521;BA.debugLine="parked_listview.AddSingleLine(p&\" | \"&pay)";
mostCurrent._parked_listview.AddSingleLine(BA.ObjectToCharSequence(_p+" | "+_pay));
 }
};
 };
RDebugUtils.currentLine=917524;
 //BA.debugLineNum = 917524;BA.debugLine="label_main.Text = \"List of cars leave parked toda";
mostCurrent._label_main.setText(BA.ObjectToCharSequence("List of cars leave parked today"));
RDebugUtils.currentLine=917525;
 //BA.debugLineNum = 917525;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 589826;BA.debugLine="query_selector.Position=Position";
parent.mostCurrent._query_selector.setPosition(_position);
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="If query_selector.GetString(\"payment\") <> 0 And q";
if (true) break;

case 1:
//if
this.state = 4;
if ((parent.mostCurrent._query_selector.GetString("payment")).equals(BA.NumberToString(0)) == false && (parent.mostCurrent._query_selector.GetString("payment")).equals("") == false) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 4:
//C
this.state = 5;
;
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="Dim sf As Object = Msgbox2Async(\"Press YES to ace";
_sf = anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Press YES to acept or NO to decline"),BA.ObjectToCharSequence("Do you want to pay?"),"YES","CANCEL","NO",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="Wait For (sf) Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "parked_listview_itemclick"), _sf);
this.state = 39;
return;
case 39:
//C
this.state = 5;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=589833;
 //BA.debugLineNum = 589833;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 5:
//if
this.state = 38;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 7;
}if (true) break;

case 7:
//C
this.state = 8;
RDebugUtils.currentLine=589834;
 //BA.debugLineNum = 589834;BA.debugLine="TabHost1.CurrentTab = (TabHost1.CurrentTab + 1)";
parent.mostCurrent._tabhost1.setCurrentTab((int) ((parent.mostCurrent._tabhost1.getCurrentTab()+1)%parent.mostCurrent._tabhost1.getTabCount()));
RDebugUtils.currentLine=589835;
 //BA.debugLineNum = 589835;BA.debugLine="query_selector.Position=Position";
parent.mostCurrent._query_selector.setPosition(_position);
RDebugUtils.currentLine=589836;
 //BA.debugLineNum = 589836;BA.debugLine="Dim time As String";
_time = "";
RDebugUtils.currentLine=589837;
 //BA.debugLineNum = 589837;BA.debugLine="time = DateTime.Now";
_time = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=589838;
 //BA.debugLineNum = 589838;BA.debugLine="Dim mi,ho,ti As Int";
_mi = 0;
_ho = 0;
_ti = 0;
RDebugUtils.currentLine=589839;
 //BA.debugLineNum = 589839;BA.debugLine="Dim da As String";
_da = "";
RDebugUtils.currentLine=589841;
 //BA.debugLineNum = 589841;BA.debugLine="label_id.Text = query_selector.GetString(\"id\")";
parent.mostCurrent._label_id.setText(BA.ObjectToCharSequence(parent.mostCurrent._query_selector.GetString("id")));
RDebugUtils.currentLine=589842;
 //BA.debugLineNum = 589842;BA.debugLine="label_patent.Text = query_selector.GetString(\"pa";
parent.mostCurrent._label_patent.setText(BA.ObjectToCharSequence(parent.mostCurrent._query_selector.GetString("patent")));
RDebugUtils.currentLine=589843;
 //BA.debugLineNum = 589843;BA.debugLine="label_date.Text = query_selector.GetString(\"date";
parent.mostCurrent._label_date.setText(BA.ObjectToCharSequence(parent.mostCurrent._query_selector.GetString("date")));
RDebugUtils.currentLine=589844;
 //BA.debugLineNum = 589844;BA.debugLine="label_start.Text = query_selector.GetString(\"hou";
parent.mostCurrent._label_start.setText(BA.ObjectToCharSequence(parent.mostCurrent._query_selector.GetString("hour")));
RDebugUtils.currentLine=589846;
 //BA.debugLineNum = 589846;BA.debugLine="da = DateTime.GetYear(time)&\"/\"&DateTime.GetMont";
_da = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetYear((long)(Double.parseDouble(_time))))+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMonth((long)(Double.parseDouble(_time))))+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfMonth((long)(Double.parseDouble(_time))));
RDebugUtils.currentLine=589847;
 //BA.debugLineNum = 589847;BA.debugLine="If da <> query_selector.GetString(\"date\") Then";
if (true) break;

case 8:
//if
this.state = 19;
if ((_da).equals(parent.mostCurrent._query_selector.GetString("date")) == false) { 
this.state = 10;
}else {
this.state = 12;
}if (true) break;

case 10:
//C
this.state = 19;
RDebugUtils.currentLine=589848;
 //BA.debugLineNum = 589848;BA.debugLine="Log(\"distintos dias\")";
anywheresoftware.b4a.keywords.Common.LogImpl("5589848","distintos dias",0);
RDebugUtils.currentLine=589849;
 //BA.debugLineNum = 589849;BA.debugLine="label_end.Text = \"23:59\"";
parent.mostCurrent._label_end.setText(BA.ObjectToCharSequence("23:59"));
 if (true) break;

case 12:
//C
this.state = 13;
RDebugUtils.currentLine=589851;
 //BA.debugLineNum = 589851;BA.debugLine="If DateTime.GetMinute(time).As(Int) <= 9 Then";
if (true) break;

case 13:
//if
this.state = 18;
if ((anywheresoftware.b4a.keywords.Common.DateTime.GetMinute((long)(Double.parseDouble(_time))))<=9) { 
this.state = 15;
}else {
this.state = 17;
}if (true) break;

case 15:
//C
this.state = 18;
RDebugUtils.currentLine=589852;
 //BA.debugLineNum = 589852;BA.debugLine="label_end.Text = DateTime.GetHour(time).As(Str";
parent.mostCurrent._label_end.setText(BA.ObjectToCharSequence((BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetHour((long)(Double.parseDouble(_time)))))+":0"+(BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMinute((long)(Double.parseDouble(_time)))))));
 if (true) break;

case 17:
//C
this.state = 18;
RDebugUtils.currentLine=589854;
 //BA.debugLineNum = 589854;BA.debugLine="label_end.Text = DateTime.GetHour(time).As(Str";
parent.mostCurrent._label_end.setText(BA.ObjectToCharSequence((BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetHour((long)(Double.parseDouble(_time)))))+":"+(BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMinute((long)(Double.parseDouble(_time)))))));
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
RDebugUtils.currentLine=589858;
 //BA.debugLineNum = 589858;BA.debugLine="ho = (label_end.Text.SubString2(0,2)).As(Int)-(l";
_ho = (int) (((int)(Double.parseDouble((parent.mostCurrent._label_end.getText().substring((int) (0),(int) (2))))))-((int)(Double.parseDouble((parent.mostCurrent._label_start.getText().substring((int) (0),(int) (2)))))));
RDebugUtils.currentLine=589859;
 //BA.debugLineNum = 589859;BA.debugLine="mi = (label_end.Text.SubString2(3,5)).As(Int)-(l";
_mi = (int) (((int)(Double.parseDouble((parent.mostCurrent._label_end.getText().substring((int) (3),(int) (5))))))-((int)(Double.parseDouble((parent.mostCurrent._label_start.getText().substring((int) (3),(int) (5)))))));
RDebugUtils.currentLine=589860;
 //BA.debugLineNum = 589860;BA.debugLine="If ho = 0 Then";
if (true) break;

case 20:
//if
this.state = 31;
if (_ho==0) { 
this.state = 22;
}else {
this.state = 24;
}if (true) break;

case 22:
//C
this.state = 31;
RDebugUtils.currentLine=589861;
 //BA.debugLineNum = 589861;BA.debugLine="ti = mi";
_ti = _mi;
 if (true) break;

case 24:
//C
this.state = 25;
RDebugUtils.currentLine=589863;
 //BA.debugLineNum = 589863;BA.debugLine="If mi >= 0 Then";
if (true) break;

case 25:
//if
this.state = 30;
if (_mi>=0) { 
this.state = 27;
}else {
this.state = 29;
}if (true) break;

case 27:
//C
this.state = 30;
RDebugUtils.currentLine=589864;
 //BA.debugLineNum = 589864;BA.debugLine="ti = ho*60 + mi";
_ti = (int) (_ho*60+_mi);
 if (true) break;

case 29:
//C
this.state = 30;
RDebugUtils.currentLine=589866;
 //BA.debugLineNum = 589866;BA.debugLine="ho = ho - 1";
_ho = (int) (_ho-1);
RDebugUtils.currentLine=589867;
 //BA.debugLineNum = 589867;BA.debugLine="mi = mi + 60";
_mi = (int) (_mi+60);
RDebugUtils.currentLine=589868;
 //BA.debugLineNum = 589868;BA.debugLine="ti = ho*60 + mi";
_ti = (int) (_ho*60+_mi);
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
RDebugUtils.currentLine=589871;
 //BA.debugLineNum = 589871;BA.debugLine="label_time.Text = ti&\" minutes\"";
parent.mostCurrent._label_time.setText(BA.ObjectToCharSequence(BA.NumberToString(_ti)+" minutes"));
RDebugUtils.currentLine=589872;
 //BA.debugLineNum = 589872;BA.debugLine="label_time.Tag = ti";
parent.mostCurrent._label_time.setTag((Object)(_ti));
RDebugUtils.currentLine=589873;
 //BA.debugLineNum = 589873;BA.debugLine="If ti < 15 Then";
if (true) break;

case 32:
//if
this.state = 37;
if (_ti<15) { 
this.state = 34;
}else {
this.state = 36;
}if (true) break;

case 34:
//C
this.state = 37;
RDebugUtils.currentLine=589874;
 //BA.debugLineNum = 589874;BA.debugLine="label_pay.Text = \"$ 500 pesos\"";
parent.mostCurrent._label_pay.setText(BA.ObjectToCharSequence("$ 500 pesos"));
RDebugUtils.currentLine=589875;
 //BA.debugLineNum = 589875;BA.debugLine="label_pay.Tag = \"500\"";
parent.mostCurrent._label_pay.setTag((Object)("500"));
 if (true) break;

case 36:
//C
this.state = 37;
RDebugUtils.currentLine=589877;
 //BA.debugLineNum = 589877;BA.debugLine="label_pay.Text =\"$500 + \"&(ti-15)&\" * $30\"&\" =";
parent.mostCurrent._label_pay.setText(BA.ObjectToCharSequence("$500 + "+BA.NumberToString((_ti-15))+" * $30"+" = $"+(BA.NumberToString((500+(_ti-15)*30)))+" pesos"));
RDebugUtils.currentLine=589878;
 //BA.debugLineNum = 589878;BA.debugLine="label_pay.Tag = (500 +(ti-15)*30).As(String)";
parent.mostCurrent._label_pay.setTag((Object)((BA.NumberToString((500+(_ti-15)*30)))));
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
RDebugUtils.currentLine=589881;
 //BA.debugLineNum = 589881;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _parked_today_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "parked_today_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "parked_today_click", null));}
String _time = "";
String _da = "";
int _i = 0;
String _p = "";
String _d = "";
String _h = "";
String _pay = "";
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Private Sub parked_today_Click";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="Dim time,da As String";
_time = "";
_da = "";
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="time = DateTime.Now";
_time = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="da = DateTime.GetYear(time)&\"/\"&DateTime.GetMonth";
_da = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetYear((long)(Double.parseDouble(_time))))+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMonth((long)(Double.parseDouble(_time))))+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfMonth((long)(Double.parseDouble(_time))));
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="query_selector=SQLite.ExecQuery(\"SELECT * FROM \"&";
mostCurrent._query_selector = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sqlite.ExecQuery("SELECT * FROM "+BA.ObjectToString(mostCurrent._tables_db.Get((int) (0)))+" WHERE date='"+_da+"' ORDER BY patent ASC")));
RDebugUtils.currentLine=983047;
 //BA.debugLineNum = 983047;BA.debugLine="parked_listview.clear";
mostCurrent._parked_listview.Clear();
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="If query_selector.RowCount>0 Then";
if (mostCurrent._query_selector.getRowCount()>0) { 
RDebugUtils.currentLine=983050;
 //BA.debugLineNum = 983050;BA.debugLine="For i=0 To query_selector.RowCount-1";
{
final int step7 = 1;
final int limit7 = (int) (mostCurrent._query_selector.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
RDebugUtils.currentLine=983051;
 //BA.debugLineNum = 983051;BA.debugLine="query_selector.Position=i";
mostCurrent._query_selector.setPosition(_i);
RDebugUtils.currentLine=983052;
 //BA.debugLineNum = 983052;BA.debugLine="Dim p,d,h,pay As String";
_p = "";
_d = "";
_h = "";
_pay = "";
RDebugUtils.currentLine=983053;
 //BA.debugLineNum = 983053;BA.debugLine="p=query_selector.GetString(\"patent\")";
_p = mostCurrent._query_selector.GetString("patent");
RDebugUtils.currentLine=983054;
 //BA.debugLineNum = 983054;BA.debugLine="d=query_selector.GetString(\"date\")";
_d = mostCurrent._query_selector.GetString("date");
RDebugUtils.currentLine=983055;
 //BA.debugLineNum = 983055;BA.debugLine="h=query_selector.GetString(\"hour\")";
_h = mostCurrent._query_selector.GetString("hour");
RDebugUtils.currentLine=983056;
 //BA.debugLineNum = 983056;BA.debugLine="pay=query_selector.GetString(\"payment\")";
_pay = mostCurrent._query_selector.GetString("payment");
RDebugUtils.currentLine=983057;
 //BA.debugLineNum = 983057;BA.debugLine="parked_listview.AddSingleLine(p&\" \"&d&\" \"&h&\" \"";
mostCurrent._parked_listview.AddSingleLine(BA.ObjectToCharSequence(_p+" "+_d+" "+_h+" "+_pay));
 }
};
 };
RDebugUtils.currentLine=983061;
 //BA.debugLineNum = 983061;BA.debugLine="label_main.Text = \"List of cars parked today\"";
mostCurrent._label_main.setText(BA.ObjectToCharSequence("List of cars parked today"));
RDebugUtils.currentLine=983064;
 //BA.debugLineNum = 983064;BA.debugLine="End Sub";
return "";
}
public static String  _tabhost1_tabchanged() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tabhost1_tabchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tabhost1_tabchanged", null));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Private Sub TabHost1_TabChanged";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="If TabHost1.CurrentTab = 0 Then";
if (mostCurrent._tabhost1.getCurrentTab()==0) { 
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="label_main.Text = \"Enter car patent\"";
mostCurrent._label_main.setText(BA.ObjectToCharSequence("Enter car patent"));
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="parked_listview.Clear";
mostCurrent._parked_listview.Clear();
 };
RDebugUtils.currentLine=851974;
 //BA.debugLineNum = 851974;BA.debugLine="If TabHost1.CurrentTab = 1 Then";
if (mostCurrent._tabhost1.getCurrentTab()==1) { 
RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="label_main.Text = \"List cars\"";
mostCurrent._label_main.setText(BA.ObjectToCharSequence("List cars"));
RDebugUtils.currentLine=851976;
 //BA.debugLineNum = 851976;BA.debugLine="parked_listview.Clear";
mostCurrent._parked_listview.Clear();
RDebugUtils.currentLine=851977;
 //BA.debugLineNum = 851977;BA.debugLine="label_id.Text = \"\"";
mostCurrent._label_id.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=851978;
 //BA.debugLineNum = 851978;BA.debugLine="label_patent.Text = \"\"";
mostCurrent._label_patent.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=851979;
 //BA.debugLineNum = 851979;BA.debugLine="label_date.Text = \"\"";
mostCurrent._label_date.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=851980;
 //BA.debugLineNum = 851980;BA.debugLine="label_start.Text = \"\"";
mostCurrent._label_start.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=851981;
 //BA.debugLineNum = 851981;BA.debugLine="label_end.Text = \"\"";
mostCurrent._label_end.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=851982;
 //BA.debugLineNum = 851982;BA.debugLine="label_time.Text = \"0 minutes\"";
mostCurrent._label_time.setText(BA.ObjectToCharSequence("0 minutes"));
RDebugUtils.currentLine=851983;
 //BA.debugLineNum = 851983;BA.debugLine="label_time.Tag = \"\"";
mostCurrent._label_time.setTag((Object)(""));
RDebugUtils.currentLine=851984;
 //BA.debugLineNum = 851984;BA.debugLine="label_pay.Text = \"$ 0 pesos\"";
mostCurrent._label_pay.setText(BA.ObjectToCharSequence("$ 0 pesos"));
RDebugUtils.currentLine=851985;
 //BA.debugLineNum = 851985;BA.debugLine="label_pay.Tag = \"\"";
mostCurrent._label_pay.setTag((Object)(""));
 };
RDebugUtils.currentLine=851988;
 //BA.debugLineNum = 851988;BA.debugLine="If TabHost1.CurrentTab = 2 Then";
if (mostCurrent._tabhost1.getCurrentTab()==2) { 
RDebugUtils.currentLine=851989;
 //BA.debugLineNum = 851989;BA.debugLine="label_main.Text = \"Payment details\"";
mostCurrent._label_main.setText(BA.ObjectToCharSequence("Payment details"));
RDebugUtils.currentLine=851990;
 //BA.debugLineNum = 851990;BA.debugLine="parked_listview.Clear";
mostCurrent._parked_listview.Clear();
 };
RDebugUtils.currentLine=851992;
 //BA.debugLineNum = 851992;BA.debugLine="End Sub";
return "";
}
}