package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;

public class HomePage {

	private WebDriver driver;

	WaitHelper waitHelper;
	
	@FindBy(xpath = "//*[@id='gh-ac-box2']")
	WebElement search;
	
	@FindBy(xpath = "//*[@id='srp-river-results-listing2']")
	WebElement item;
	
	@FindBy(xpath = "//*[@id='srp-river-results-listing2']//h3")
	WebElement bookName;
	
	@FindBy(xpath = "//*[@id='atcRedesignId_btn']")
	WebElement addToCart;
	
	@FindBy(xpath = "//*[span='Go to cart']")
	WebElement goToCart;
	
	@FindBy(xpath = "//*[contains(text(),'Remove')]")
	WebElement remove;
	
	@FindBy(xpath = "//*[contains(text(),'Home')]")
	WebElement homePage; 


	@FindBy(xpath = "//span[contains(text(),' Administrator')]")
	public WebElement administrator;

	@FindBy(xpath = "//table[@class='hdrTabBg']/tbody/tr//td/a[text()='Leads']")
	WebElement leadsLink;

	@FindBy(xpath = "//table[@class='hdrTabBg']/tbody/tr//td/a[text()='Organizations']")
	WebElement organizationsLink;

	@FindBy(xpath = "//table[@class='hdrTabBg']/tbody/tr//td/a[text()='Contacts']")
	WebElement contactsLink;

	@FindBy(xpath = "//table[@class='hdrTabBg']/tbody/tr//td/a[text()='Opportunities']")
	WebElement opportunitiesLInk;

	@FindBy(xpath = "//img[@alt='Create Lead...']")
	WebElement leadsButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

	public LeadsCreationPage navigateToLeads() {
		leadsLink.click();
		return new LeadsCreationPage(driver);
	}

	public Organizations navigateToOrganizations() {
		organizationsLink.click();
		return new Organizations(driver);
	}

	public void navigateToContacts() {
		contactsLink.click();
	}

	public void navigateToOpportunities() {
		opportunitiesLInk.click();
	}
	
	public WebElement getHomePage() {
		waitHelper.WaitForElement(homePage, Constants.getExplicitwait());
		return homePage;
	}


}
