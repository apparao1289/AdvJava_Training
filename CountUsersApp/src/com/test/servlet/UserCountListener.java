package com.test.servlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class UserCountListener implements HttpSessionListener {

	private static int numberOfUsersOnline = 0;

	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		System.out.println("Session is created with id:" + hse.getSession().getId());
		synchronized (this) {
			numberOfUsersOnline++;
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		System.out.println("Session is destroyed for id:" + hse.getSession().getId());
		synchronized (this) {
			numberOfUsersOnline--;
		}
	}

	public static int getNumberOfUsersOnline() {
		return numberOfUsersOnline;
	}

}
