package com.huaking;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NullPointerException {
	public static void main(String[] args) {
		String literal = "literal";
//		好的方式
		"literal Hello".equals(literal);
//		不好的方式
		literal.equals("literal Hello");
		
//		valueOf代替toString,如果bd为null，bd.toString有可能空指针异常
		BigDecimal bd = new BigDecimal(50);
		System.out.println(bd.toString());
		System.out.println(String.valueOf(bd));
		
//		避免不必要的装箱，getPrice返回的是Integer，因此可能是null，有可能会抛出异常
//		int price = objet.getPrice();
		
	}
	
	//当返回一个集合的时候，计量返回空的对象，不要返回Null（例如Collections里边有EMPTY_LIST EMPTY_SET EMPTY_MAP）
	public List<Integer> f() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		if(list.isEmpty()) {
			return Collections.emptyList();
		}
		return list;
	}
}
