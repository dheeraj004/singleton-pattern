package com.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testbase.TestBase;

public class TestDemo {
	
	@BeforeMethod
	public void setUP()
	{
		
		TestBase.initialization();
	}
	
	@Test(priority = 1)
	public void validateLoginPageTile()
	{
		Assert.assertEquals(TestBase.driver.getTitle(), "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority = 2)
	public void validateCRMlogo()
	{
		Assert.assertTrue(TestBase.driver.findElement(By.xpath("//img[@class='img-responsive' and @src='https://classic.freecrm.com/img/logo.png']")).isDisplayed());
	}
	
	@AfterMethod
	public void tearDown()
	{
		TestBase.quit();
	}

}
