package com.walters.bb.utils;

/**
 * 
 * @author Gavin Walters
 *
 */

public class NavigatorFactory {
	private static Navigation navigator = null;
	
	public static synchronized Navigation getNavigator(){
		if(navigator == null){
			navigator = new Navigation();
		}
		return navigator;
	}
}