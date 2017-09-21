package cn.bdqn.school;

public class Test_Teacher {
	public static void main(String [] args){
		Teacher tea=new Teacher();
		tea.tname="王老师";
		tea.major="计算机";
		tea.courses="使用Java语言理解程序逻辑";
		tea.schoolAge=10;
		
		tea.showTea();
	}
}
