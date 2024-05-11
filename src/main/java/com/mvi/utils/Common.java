package com.mvi.utils;

public final class Common {
    private Common() {
    }
 
    public static void wait(int waitTime) {
		try {
			Thread.sleep(waitTime * 1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
    
}
