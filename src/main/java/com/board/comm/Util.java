package com.board.comm;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.RequestFacade;

public class Util {

	public static void prtParams(HttpServletRequest request) {
		Enumeration params = request.getParameterNames();
		while(params.hasMoreElements()) {
		  String name = (String) params.nextElement();
		  System.out.print(name + " : " + request.getParameter(name) + "     "); 
		}
		System.out.println();
	}
}
