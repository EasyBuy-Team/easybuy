package com.service;

import java.sql.SQLException;

import com.dao.LoginDao;

public class LoginService {

	public int lookUp(String name, String password) throws ClassNotFoundException, SQLException {
		LoginDao ld=new LoginDao();
		return ld.lookUp(name,password);
		
	}

}
