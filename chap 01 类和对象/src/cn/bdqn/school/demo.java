package cn.bdqn.school;

import java.util.Scanner;

public class demo {
	public static void main(String[] args) {
		String yname="qqq";
		String ypwd="www";
		boolean tag=true;
		Scanner input=new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name=input.next();
		System.out.println("请输入密码：");
		String pwd=input.next();
		while(tag=true){
			if(yname.equals(name) && ypwd.equals(pwd)){
				System.out.println("用户名密码正确");
				tag=false;
			
			}else{
				System.out.println("用户名或密码不正确");
				
			}
			System.out.println("请输入用户名：");
			name=input.next();
			System.out.println("请输入密码：");
			pwd=input.next();
		}
		
	}
}
