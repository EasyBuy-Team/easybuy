package cn.bdqn.integral;

public class Test {

	public static void main(String[] args) {
		Integral inte=new Integral();
		inte.integral=3050;
		inte.idType="金卡";
		inte.show();
		if(inte.integral>1000){
			
			System.out.println("回馈积分500分");
		}else{
			System.out.println("抱歉，积分未达到1000分，无法回馈 继续加油！");
		}
		
		Integral inte2=new Integral();
		inte2.integral=4000;
		inte2.idType="普卡";
		inte2.show();
		if(inte2.integral>5000){
			System.out.println("回馈积分500分");
		}else{
			System.out.println("抱歉，积分未达到5000分，无法回馈，请继续加油!");
		}
	}

}
