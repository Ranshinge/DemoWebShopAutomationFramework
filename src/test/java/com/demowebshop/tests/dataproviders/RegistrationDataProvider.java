package com.demowebshop.tests.dataproviders;

import org.testng.annotations.DataProvider;

public class RegistrationDataProvider {
	
	@DataProvider(name="genderData")
	public Object[][] getGenderData()
	{
		return new Object[][]
				{
					{"Male"},
					{"Female"}
				};
	}
	
	@DataProvider(name="validRegistrationData")
	public Object[][] getValidRegistrationData()
		{
			return new Object[][]
				{
					{"Male","Rohit", "Ranshinge","ahin@gmail.com","Rahul@3451","Rahul@3451"},
				};
		};
		
		@DataProvider(name="invalidregistrationData")
		public Object[][] getInvalidRegistrationData()
		{
			return new Object [][]
					{
						{"Male","","","rte","roh","rohit"},
					};
		};
		
		@DataProvider(name="alreadyRegisteredEmailData")
		public Object[][] getAlreadyRegisteredEmailData()
				{
					return new Object [][]
							{
								{"Male","Rohit", "Ranshinge","rohitranshinge@gmail.com","Rahul@3451","Rahul@3451"},
							};
				};
}
	
