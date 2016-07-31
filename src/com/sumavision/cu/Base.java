package com.sumavision.cu;

import java.io.IOException;

public class Base {
	/**
	 * 功能：输入adb命令；
	 * @param content
	 */
	public void adbLine(String content) {
		Process process;
		try {
			process=Runtime.getRuntime().exec(content);
			process.waitFor();
			process.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
