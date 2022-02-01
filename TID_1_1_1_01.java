package Acquisition.FactoryOrder.CompareVehicles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import MF.FrameworkCode.BFrameworkQueryObjects;

import tools.TotalView.RC_Global;
import tools.TotalView.RC_Acquisition_OrderPortal;
import tools.TotalView.RC_Acquisition;

public class TID_1_1_1_01 {
	
	public void FactoryOrder_Validate_CompareVehicles_Display(WebDriver driver, BFrameworkQueryObjects queryObjects) throws Exception{
		
		String spinnerSelector = "//div[contains(@class, 'panel-loading-spinner')]/i";
		String vehicleType = "Acura MDX";
		
		RC_Global.login(driver);
		RC_Global.navigateTo(driver,"Acquisition", "Factory Order", "Compare Vehicles");
		
		RC_Global.waitElementVisible(driver, 30, "//select[@id='selectMake']", "'Make' DropDown", true, true);
		RC_Global.selectDropdownOption(driver, "selectMake", "Acura", true, true);
		Thread.sleep(500);
		RC_Global.selectDropdownOption(driver, "selectModel", "MDX", true, true);
		Thread.sleep(500);
		RC_Global.clickUsingXpath(driver, "(//input[@ng-click='trimSelected(trim)'])[1]", "Select Trim Radio Btn", true, true);
		RC_Global.clickButton(driver, "Add", true, true);
		Thread.sleep(500);
		RC_Global.waitElementVisible(driver, 10, "//tr[contains(., '"+vehicleType+"')]", "Selected Compare Vehicle", true, true);
		RC_Global.clickButton(driver, " Add Similar ", true, true);

		
		RC_Global.createNode(driver, "Add Similar modal-dialog-->Select All");
		if(driver.findElements(By.xpath("//div[@class='modal-dialog'][contains(., 'Add Similar')]")).size()>0);
		List<WebElement> similarOptions = driver.findElements(By.xpath("//div[@class='modal-dialog'][contains(., 'Add Similar')]//input"));
		for(WebElement elem:similarOptions) {
			elem.click();
			Thread.sleep(500);
		}
		
		RC_Global.clickButton(driver, "Done", true, true);
	}

}
