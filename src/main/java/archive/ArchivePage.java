package archive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ArchivePage {

    WebDriver driver;



    @FindBy (xpath = "//app-icon-button[@class='close-btn'][1]")
	WebElement closeButton;

	@FindBy(xpath="//*[@id=\"form-validate\"]/div[2]/div/button")
	WebElement save;

	@FindBy(xpath="//div[2]/div[1]/div/app-icon-button/span/app-icon/span")
	WebElement roleMenu;

	@FindBy(xpath="//span[@class='hidden'][contains(.,'Архив')]")
	WebElement menuArchive;

	@FindBy(xpath = "//a[@routerlink='/projects'][contains(.,'Проекты')]")
	WebElement menuProjects;

	@FindBy(xpath = "//span[@class='m_label'][contains(.,'Проект')]")
	WebElement dropdownProjectGIP;

	@FindBy(xpath = "//button[@type='primary-outline'][contains(.,'Все проекты')]")
	WebElement dropdownProjectArch;

	@FindBy(xpath = "//button[@class='dropdown-item'][contains(.,'AQA123 AQA Проект')]")
	WebElement testProject;

	@FindBy(xpath = "(//button[@class='dropdown-item'][contains(.,'AQA123 AQA Проект')])[2]")
	WebElement testProjectModal;

	@FindBy(xpath = "//button[@type='button'][contains(.,'Версия')]")
	WebElement btnAddVersion;

	@FindBy(xpath = "//button[@type='primary-outline'][contains(.,'Выберите проект')]")
	WebElement dropdownProjectModal;

	@FindBy(xpath = "//button[@type='primary-outline'][contains(.,'Выберите шифр')]")
	WebElement dropdownCode;

	@FindBy(xpath = "//button[@class='dropdown-item'][contains(.,'ТОМ 1-AQA')]")
	WebElement testCode;

	@FindBy(xpath = "(//button[@class='primary'][contains(.,'ЗАГРУЗИТЬ')])[2]")
	WebElement btnUploadVersion;



	// constructor method
	public ArchivePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void closeButton () {
		closeButton.click();
	}
	public void clickRoleMenu () {
		roleMenu.click();
	}
	public void accessArchive () {
		menuArchive.click();
	}
	public void accessProjectModule () {
		menuProjects.click();
	}

	public void selectTestProject () {
		dropdownProjectGIP.click();
		testProject.click();
	}
	public void selectTestProjectArch () {
		dropdownProjectArch.click();
		testProject.click();
	}

	public void addDocVersion () {
		btnAddVersion.click();
		dropdownProjectModal.click();
		testProjectModal.click();
		dropdownCode.click();
		testCode.click();
		uploadFile();
		btnUploadVersion.click();
	}

	public void uploadFile () {
		File uploadFile = new File("src/test/resources/Акт_списания.pdf");
		WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
		fileInput.sendKeys(uploadFile.getAbsolutePath());
	}
	public void addEmployees() {

	}
//	public void search(final String query) {
//		searchField.sendKeys(query);
//		searchButton.click();
//	}




//	public WebElement getTextField() {
//		return textField;
//	}


	public WebElement saveButtonPath() {
		return save;
	}

}

