package com.qa.utils;

import org.testng.annotations.DataProvider;

public class TestUtil {
	
	public final static int RESPONSE_CODE_200=200;
	public final static int RESPONSE_CODE_201=201;
	public final static int RESPONSE_CODE_400=400;
	public final static int RESPONSE_CODE_401=401;
	public final static String WEATHERINFO_SHEET="weatherinfo";
	
	@DataProvider
	public static Object[][] getData(){
		
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\testdata\\WeatherSuite.xlsx");
		int rows = xls.getRowCount(WEATHERINFO_SHEET);
		int cols = xls.getColumnCount(WEATHERINFO_SHEET);
		Object[][] data = new Object[rows-1][cols];
		int ci=0;
		for(int row=2;row<=rows;row++){
			int cj=0;
			for(int col=0;col<cols;col++){
				data[ci][cj]= xls.getCellData(WEATHERINFO_SHEET, col, row);
				cj++;
			}
			ci++;
		}
		
		return data;
		
	}

}
