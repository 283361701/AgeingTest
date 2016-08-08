package com.sumavision.cu;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.sumavision.cu.UiAutomatorHelper;


public class AgeingCURun extends UiAutomatorTestCase {	
	private static String jar_name="AgeingCURun";
	private static String test_class="com.sumavision.cu.AgeingCURun";
	private static String test_nane="testCuTbleByCount";
	private static String android_id="1";
	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	SimpleDateFormat dataFileNmae = new SimpleDateFormat("yyyyMMddHHmmss");
	/**
	 * 需求：直播切台；
	 * @param args
	 */
	public static void main(String[] args) {
		new UiAutomatorHelper(jar_name,test_class,test_nane,android_id);
	}
	public void setUp(){
		String packageName = "com.sumavision.iptv";
		String path = "/storage/external_storage/sda1/";
		String fileName=dataFileNmae.format(date)+".log";
		initApp(packageName);
		Base catchLog = new Base();
		catchLog.adbLine("logcat -c;logcat -vtime > "+path+fileName+" &");
		System.out.println("-----------切台开始:"+dateFormat.format(date));
	}
	public void tearDown(){
		System.err.println("-----------IPTV闪退:"+dateFormat.format(date));
		Base killLog = new Base();
		killLog.adbLine("sync;killall logcat");
	}
	//通过按频道+循环切台
	public void testCutTable() {
		UiObject checkElement = new UiObject(new UiSelector()
				.packageName("com.sumavision.iptv"));
		while(checkElement.exists()){
			//频道+的Android键值166
			UiDevice.getInstance().pressKeyCode(166); 
			sleep(4000);
		}
	}
	//循环次数切台
	public void testCuTbleByCount() {
		UiObject checkElement = new UiObject(new UiSelector()
				.packageName("com.sumavision.iptv"));
		while (checkElement.exists()) {
			int count = 0;
			if(count < 60){
				UiDevice.getInstance().pressKeyCode(166); 
				sleep(4000);
				count++;
			}
			//数字键1->Android键值8
			UiDevice.getInstance().pressKeyCode(8);			
		}
	}
	//上下页进行时移/直播切换
	public void testLiveToSeekByUpDown(){
		UiObject checkElement = new UiObject(new UiSelector()
				.packageName("com.sumavision.iptv"));
		while(checkElement.exists()){
			UiDevice.getInstance().pressKeyCode(92);
			sleep(8000);
			UiDevice.getInstance().pressKeyCode(93);
			sleep(8000);
		}
	}
	private void initApp(String packageName) {
		Base startApp = new Base();
		startApp.adbLine("monkey -p "+packageName+" 1");
		sleep(6000);
		UiDevice.getInstance().pressBack();	
		sleep(2000);
	}

}
