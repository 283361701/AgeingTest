package com.sumavision.ctc;

import com.sumavision.cu.UiAutomatorHelper;

public class AgeingCTCRun {
	private static String jar_name="AgeingCTCRun";
	private static String test_class="com.sumavision.ctc.AgeingCURun";
	private static String test_nane="";
	private static String android_id="1";
	public static void main(String[] args) {
		new UiAutomatorHelper(jar_name,test_class,test_nane,android_id);
	}
	public void setUp(){
		
	}
	public void tearDown() {
		
	}
}
