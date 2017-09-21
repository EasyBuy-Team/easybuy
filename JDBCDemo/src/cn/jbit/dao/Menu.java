package cn.jbit.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import cn.jbit.entity.Master;

public class Menu {
		Scanner input=new Scanner(System.in);
		MasterDao md=new MasterDao();
	public void showLogin() throws ClassNotFoundException, SQLException{
		System.out.println("*******欢迎进入数据管理系统******");
		System.out.println("1.登录系统");
		System.out.println("2.退出系统");
		System.out.println("****************************");
		System.out.println("请选择：");
		int option=input.nextInt();
		switch(option){
			case 1:
				showMain();
				break;
			case 2:
				System.out.println("退出系统");
				System.exit(0);
		}
	}
	
	public void showMain() throws ClassNotFoundException, SQLException{
		do{
			System.out.println("*******欢迎进入数据管理系统主菜单******");
			System.out.println("1.增加数据");
			System.out.println("2.删除数据");
			System.out.println("3.更新数据");
			System.out.println("4.查询数据");
			System.out.println("5.返回上一级");
			System.out.println("****************************");
			System.out.println("请选择：");
			int option=input.nextInt();
			switch(option){
				case 1:
					System.out.println("----增加数据----");
					System.out.println("请输入编号：");
					int id=input.nextInt();
					System.out.println("请输入姓名：");
					String name=input.next();
					System.out.println("请输入密码：");
					String password=input.next();
					System.out.println("请输入元宝数：");
					int money=input.nextInt();
					int result=md.add(id, name, password, money);
					if(result>0){
						System.out.println("增加数据成功！");
					}else{
						System.out.println("增加数据失败！");
					}
					break;
				case 2:
					System.out.println("----删除数据----");
				
					System.out.println("请输入编号：");
					id=input.nextInt();
					result=md.del(id);
					if(result>0){
						System.out.println("删除数据成功！");
					}else{
						System.out.println("删除数据失败！");
					}
					break;
				case 3:
					System.out.println("----更新数据----");
					System.out.println("请输入元宝数：");
					money=input.nextInt();
					System.out.println("请输入编号：");
					id=input.nextInt();
					result=md.upDate(money, id);
					if(result>0){
						System.out.println("更新数据成功！");
					}else{
						System.out.println("更新数据失败！");
					}
					break;
				case 4:
					System.out.println("----查询数据----");
					System.out.println("编号\t\t姓名\t\t密码\t\t元宝数");
					List<Master> list=md.look();
					for(Master lis:list){
						System.out.println(lis.getId()+"\t\t"+lis.getName()+"\t\t"+lis.getPassword()+"\t\t"+lis.getMoney());
					}
					break;
				case 5:
					showLogin();
			}
		}while(true);
	}
}
