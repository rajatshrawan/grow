package testClasses;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilitypackage.ExcelFile;

public class Test_Case2_LoginDP {
	
	@Test(dataProvider="loginData")
	public void login1(){
		
	}
	@DataProvider(name="logindata")
	String [][] getData() throws IOException{
	String xlfile=System.getProperty("user.dir")+"/src/test/java/testData/Book1.xlsx";
	int rownum=ExcelFile.getRowCount(xlfile, "Sheet1");
	int colcount=ExcelFile.getCellCount(xlfile,"Sheet1",1);
	String logindata[][]=new String[rownum][colcount];
	
	for(int i=1;i<=rownum;i++)
	{
		for(int j=0;j<colcount;j++)
		{
			logindata[i-1][j]=ExcelFile.readData(xlfile,"Sheet1", i,j);//1 0
		}
			
	}
return logindata;
	}
}

