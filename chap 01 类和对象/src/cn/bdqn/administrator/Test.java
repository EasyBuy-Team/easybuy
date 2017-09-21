package cn.bdqn.administrator;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		boolean tag=false;
		Scanner input=new Scanner(System.in);
		Administrator ad=new Administrator();
		ad.userName="jiangqin";
		ad.passWord="19961101";
		String name="";
		String pwd="";
		while(!tag){
		System.out.println("请输入用户名：");
		name=input.next();
		System.out.println("请输入密码：");
		pwd=input.next();
			if(name.equals(ad.userName) && pwd.equals(ad.passWord)){
				System.out.println("请输入新密码：");
				name=input.next();
				System.out.println("修改密码成功，您的新密码为："+name);
				tag=true;
			}else{
				
				System.out.println("用户名或密码不匹配！您没有权限更新管理员信息！");
				
			}
		}
	}

}
