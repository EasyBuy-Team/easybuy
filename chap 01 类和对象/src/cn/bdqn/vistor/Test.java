package cn.bdqn.vistor;

import java.util.Scanner;

public class Test {
	public static void main(String [] args){
		Vistor vis=new Vistor();
		Scanner input=new Scanner(System.in);
		System.out.println("请输入姓名：");
		vis.name=input.next();
		if(!"n".equals(vis.name)){
			System.out.println("请输入年龄：");
			vis.age=input.nextInt();
			vis.show();
		}else{
			System.out.println("退出程序!");
		}
	}
}
