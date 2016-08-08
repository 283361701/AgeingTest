package com.sumavision.cmcc;

import com.sumavision.cu.UiAutomatorHelper;

public class AgeingCMCCRun {
	private static String jar_name="AgeingCMCCRun";
	private static String test_class="com.sumavision.cmcc.AgeingCURun";
	private static String test_nane="";
	private static String android_id="1";
	public static void main(String[] args) {
		new UiAutomatorHelper(jar_name,test_class,test_nane,android_id);
	}
}
