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
public anywheresoftware.b4a.objects.ListViewWrapper _parked_listview = null;
public anywheresoftware.b4a.objects.ButtonWrapper _parked_button = null;
public anywheresoftware.b4a.sql.SQL.CursorWrapper _query_selector = null;
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
 //BA.debugLineNum = 131082;BA.debugLine="name_db = \"parking_manager2.db\"";
mostCurrent._name_db = "parking_manager2.db";
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
mostCurrent._table_cars = "(id INTEGER PRIMARY KEY AUTOINCREMENT, patent TEXT, date TEXT, hour TEXT, payment FLOAT)";
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
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Private Sub customer_button_patent_Click";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="If customer_text_patent.Text = \"\" Then";
if ((mostCurrent._customer_text_patent.getText()).equals("")) { 
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="xui.MsgboxAsync(\"The patent does not exist, plea";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("The patent does not exist, please enter a patent."),BA.ObjectToCharSequence("Patent Error!"));
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="Dim col,patent,date,hour,time As String";
_col = "";
_patent = "";
_date = "";
_hour = "";
_time = "";
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="col = \"(patent, date, hour, payment)\"";
_col = "(patent, date, hour, payment)";
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="time = DateTime.Now";
_time = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="patent = customer_text_patent.Text";
_patent = mostCurrent._customer_text_patent.getText();
RDebugUtils.currentLine=458761;
 //BA.debugLineNum = 458761;BA.debugLine="date = DateTime.GetYear(time)&\"/\"&DateTime.GetMon";
_date = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetYear((long)(Double.parseDouble(_time))))+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMonth((long)(Double.parseDouble(_time))))+"/"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfMonth((long)(Double.parseDouble(_time))));
RDebugUtils.currentLine=458762;
 //BA.debugLineNum = 458762;BA.debugLine="hour = DateTime.GetHour(time)&\":\"&DateTime.GetMin";
_hour = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetHour((long)(Double.parseDouble(_time))))+":"+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.GetMinute((long)(Double.parseDouble(_time))));
RDebugUtils.currentLine=458763;
 //BA.debugLineNum = 458763;BA.debugLine="insert_into_table(name_db,tables_db.Get(0),col,pa";
_insert_into_table(mostCurrent._name_db,BA.ObjectToString(mostCurrent._tables_db.Get((int) (0))),_col,_patent,_date,_hour,BA.NumberToString(0));
RDebugUtils.currentLine=458764;
 //BA.debugLineNum = 458764;BA.debugLine="customer_text_patent.Text = \"\"";
mostCurrent._customer_text_patent.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=458767;
 //BA.debugLineNum = 458767;BA.debugLine="End Sub";
return "";
}
public static String  _insert_into_table(String _name,String _table,String _col,String _i1,String _i2,String _i3,String _i4) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "insert_into_table", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "insert_into_table", new Object[] {_name,_table,_col,_i1,_i2,_i3,_i4}));}
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub insert_into_table (name As String,table As Str";
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="SQLite.Initialize(File.DirInternal,name,True)";
_sqlite.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_name,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1835011;
 //BA.debugLineNum = 1835011;BA.debugLine="SQLite.BeginTransaction";
_sqlite.BeginTransaction();
RDebugUtils.currentLine=1835012;
 //BA.debugLineNum = 1835012;BA.debugLine="Try";
try {RDebugUtils.currentLine=1835013;
 //BA.debugLineNum = 1835013;BA.debugLine="SQLite.ExecNonQuery2(\"INSERT INTO \"&table&\" \"&co";
_sqlite.ExecNonQuery2("INSERT INTO "+_table+" "+_col+" VALUES (?,?,?,?)",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_i1),(Object)(_i2),(Object)(_i3),(Object)(_i4)}));
RDebugUtils.currentLine=1835014;
 //BA.debugLineNum = 1835014;BA.debugLine="SQLite.TransactionSuccessful";
_sqlite.TransactionSuccessful();
RDebugUtils.currentLine=1835015;
 //BA.debugLineNum = 1835015;BA.debugLine="xui.MsgboxAsync(\"Patent: \"&i1&CRLF&\"Date: \"&i2&C";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Patent: "+_i1+anywheresoftware.b4a.keywords.Common.CRLF+"Date: "+_i2+anywheresoftware.b4a.keywords.Common.CRLF+"Hour: "+_i3+anywheresoftware.b4a.keywords.Common.CRLF+"Payment: "+_i4),BA.ObjectToCharSequence("Insert into: "+_table+", successfully"));
 } 
       catch (Exception e8) {
			processBA.setLastException(e8);RDebugUtils.currentLine=1835017;
 //BA.debugLineNum = 1835017;BA.debugLine="ToastMessageShow(\"Insert into failed: \"&table,Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Insert into failed: "+_table),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1835018;
 //BA.debugLineNum = 1835018;BA.debugLine="Log(\"Insert into failedd:\"&table&\", \"&LastExcept";
anywheresoftware.b4a.keywords.Common.LogImpl("21835018","Insert into failedd:"+_table+", "+anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 };
RDebugUtils.currentLine=1835020;
 //BA.debugLineNum = 1835020;BA.debugLine="SQLite.EndTransaction";
_sqlite.EndTransaction();
RDebugUtils.currentLine=1835021;
 //BA.debugLineNum = 1835021;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Private Sub parked_button_Click";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="query_selector=SQLite.ExecQuery(\"SELECT * FROM \"&";
mostCurrent._query_selector = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(_sqlite.ExecQuery("SELECT * FROM "+BA.ObjectToString(mostCurrent._tables_db.Get((int) (0)))+" WHERE payment=0 ORDER BY id ASC")));
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="parked_listview.clear";
mostCurrent._parked_listview.Clear();
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="If query_selector.RowCount>0 Then";
if (mostCurrent._query_selector.getRowCount()>0) { 
RDebugUtils.currentLine=1900550;
 //BA.debugLineNum = 1900550;BA.debugLine="For i=0 To query_selector.RowCount-1";
{
final int step4 = 1;
final int limit4 = (int) (mostCurrent._query_selector.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=1900551;
 //BA.debugLineNum = 1900551;BA.debugLine="query_selector.Position=i";
mostCurrent._query_selector.setPosition(_i);
RDebugUtils.currentLine=1900552;
 //BA.debugLineNum = 1900552;BA.debugLine="Dim p,d,h As String";
_p = "";
_d = "";
_h = "";
RDebugUtils.currentLine=1900553;
 //BA.debugLineNum = 1900553;BA.debugLine="p=query_selector.GetString(\"patent\")";
_p = mostCurrent._query_selector.GetString("patent");
RDebugUtils.currentLine=1900554;
 //BA.debugLineNum = 1900554;BA.debugLine="d=query_selector.GetString(\"date\")";
_d = mostCurrent._query_selector.GetString("date");
RDebugUtils.currentLine=1900555;
 //BA.debugLineNum = 1900555;BA.debugLine="h=query_selector.GetString(\"hour\")";
_h = mostCurrent._query_selector.GetString("hour");
RDebugUtils.currentLine=1900556;
 //BA.debugLineNum = 1900556;BA.debugLine="parked_listview.AddSingleLine(p&\"    \"&d&\"    \"";
mostCurrent._parked_listview.AddSingleLine(BA.ObjectToCharSequence(_p+"    "+_d+"    "+_h));
 }
};
 };
RDebugUtils.currentLine=1900559;
 //BA.debugLineNum = 1900559;BA.debugLine="End Sub";
return "";
}
}