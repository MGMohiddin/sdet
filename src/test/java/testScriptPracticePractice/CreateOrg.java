package testScriptPracticePractice;


import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateOrg {
	
	@Test(retryAnalyzer= com.crme.vtiger.Genericutils.Retryanalyzer.class)
	public void createorg() {
		
		System.out.println("org is created...");
		Assert.fail();	
	}

}
