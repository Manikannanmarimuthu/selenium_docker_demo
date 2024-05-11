package com.mvi.constants;

import java.io.File;
import java.time.Duration;

public final class BIZOPSUIConstants {

	private static final String UI_TESTDATA_BASE_DIR = System.getProperty("user.dir") + File.separator
			+ "src/test/resources/test-data/cimb" + File.separator;
	
	private static final String UI_RUNTIME_TESTDATA_LOC = System.getProperty("user.dir") + File.separator
			+ "target/testdata/bizopsui" + File.separator;

	private static final Duration EXPLICITWAIT = Duration.ofSeconds(30);

	public static String getUiTestdataBaseDir() {
		return UI_TESTDATA_BASE_DIR;
	}

	public static Duration getExplicitwait() {
		return EXPLICITWAIT;
	}
	public static String getUiRuntimeTestdataLoc() {
		return UI_RUNTIME_TESTDATA_LOC;
	}

}
