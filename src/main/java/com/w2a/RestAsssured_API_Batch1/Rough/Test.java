package com.w2a.RestAsssured_API_Batch1.Rough;

import com.w2a.RestAsssured_API_Batch1.Utils.ExcelReader;

public class Test {

	public static void main(String[] args) {
		 ExcelReader excel = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\simple.xlsx");

		System.out.println(excel.getRowCount("retriveAllCustomers1"));
		System.out.println(excel.getColumnCount("retriveAllCustomers1"));
	}
}
