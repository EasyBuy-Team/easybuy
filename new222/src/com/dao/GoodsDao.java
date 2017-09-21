package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.entity.Product;

public class GoodsDao {
	public static List<Product> getAllProducts(){
		List<Product> products=new ArrayList<Product>();
		
		products.add(new Product("联想笔记本","北京",4399));
		products.add(new Product("联想商用电脑","北京",8399));
		products.add(new Product("惠普打印机","北京",1399));
		products.add(new Product("惠普商用笔记本","北京",7399));
		products.add(new Product("惠普商用台式机","北京",5399));
		products.add(new Product("DELL笔记本","北京",4399));
		products.add(new Product("DELL家用台式机","北京",4399));
		products.add(new Product("索尼笔记本","北京",13399));
		products.add(new Product("东芝笔记本","北京",12499));
		return products;
	}
}
