package com.crm.qa.util;

public class TestNaveensXls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestNaveensXls objTestNaveensXls = new TestNaveensXls();
		Object[][] data = objTestNaveensXls.getCRMTestData();
		System.out.println(data[0][1]);
		System.out.println(data[1][1]);
		System.out.println(data[1][2]);
	}
	public Object[][] getCRMTestData() {
		Object[][] data = TestUtil.getTestData("contacts");
		return data;
	}

}
