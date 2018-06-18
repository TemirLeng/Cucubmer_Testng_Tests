package com.app.stepDefs;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.app.beans.ContactBean;
import com.app.pages.SuiteCRM_ContactCreate;
import com.app.utilities.GenericMethods;

import cucumber.api.java.en.When;

public class CreateContact_UsingBean_StepDefs {
	@When("^I save a new contact:$")
	public void i_save_a_new_contact(List<ContactBean> cont) throws Exception {
		SuiteCRM_ContactCreate contactCreate = new SuiteCRM_ContactCreate();
		SuiteCRM_ContactCreate contactCr=new SuiteCRM_ContactCreate();
		
		contactCr.createContact();
		ContactBean contactBean = cont.get(0);
		contactCreate.sendData("Prof.", contactBean.getFirstName(), contactBean.getLastName(),
				contactBean.getCellPhone(), contactBean.getOfficePhone());

	}
}
