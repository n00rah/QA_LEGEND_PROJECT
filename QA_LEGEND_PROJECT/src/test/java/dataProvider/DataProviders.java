package dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	@DataProvider(name="InvalidLogincredentials")
	public Object userCredentialsdata()
	{
		Object data[][]= new Object[3][2];
		data[0][0]="admin";		
		data[0][1]="1234";		
		data[1][0]="admi";		
		data[1][1]="123456";		
		data[2][0]="admi";		
		data[2][1]="1234";
		return data;
	}


}
