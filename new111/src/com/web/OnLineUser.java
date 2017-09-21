package com.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.entity.User;

public class OnLineUser implements HttpSessionBindingListener{
	
	private User user=null;
	
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		ServletContext application=arg0.getSession().getServletContext();
		List<User> userList=(List<User>)application.getAttribute("user");
		if(userList==null){
			userList=new ArrayList<User>();
		}
		userList.add(user);
		application.setAttribute("user",userList);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		ServletContext application=arg0.getSession().getServletContext();
		List<User> userList=(List<User>)application.getAttribute("user");
		if(userList!=null){
			userList.remove(user);
		}
		application.setAttribute("user",userList);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}
