package Test_Cases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileNotFoundException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import Functional_Library.Common_Methods;

public class Login_TC extends Common_Methods implements CommonInterface {

	String ScenrioName = "Login";
	String Username;
	String Password;
	String UsrDir;
	String PwdDir;
	String btnLogin;

	@BeforeClass
	public void Initializesetup() {
		this.setDriver();
	}

	public void getInputValue() {
		try {
			this.Username = this.getExcelValue(this.ScenrioName, 3, 4);
			this.Password = this.getExcelValue(this.ScenrioName, 4, 4);
			this.UsrDir = this.getExcelValue(this.ScenrioName, 2, 3);
			this.PwdDir = this.getExcelValue(this.ScenrioName, 3, 3);
			this.btnLogin = this.getExcelValue(this.ScenrioName, 4, 3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}

	}

	public void setAttribute() {
		// TODO Auto-generated method stub
		this.goInputByEx(UsrDir, Username);
		this.goInputByEx(PwdDir, Password);
	}

	public void verifyTitle() {
		// TODO Auto-generated method stub

	}

	@Test
	public void f() {
		
		System.out.println("Starting Login Scenerio");
		this.getInputValue();
		this.setAttribute();
		this.goSubmitByEx(btnLogin);
		this.ImplicitWait(3000);
		this.CloseBrowser();
		System.out.println("Browser Closed");
	}
}
