package day1_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class Check_Dashboard_Button {

	public static void main(String[] args) throws InterruptedException {

		
		 // Selenium Manager handles driver setup automatically in 2026
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        DataFormatter formatter = new DataFormatter();

		// Give Path from File of Excel is save then Paste in FileInputStream ("  ")
        try (FileInputStream fis = new FileInputStream("//Login_ID.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {

        	
			
//			Thread.sleep(3000);
        	driver.get("https://surveyxan.com/Cloudapp/app18/Login.aspx?qqmcml_1115_a3055");		
            driver.manage().window().maximize();

            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String user = formatter.formatCellValue(row.getCell(0));
                String pass = formatter.formatCellValue(row.getCell(1));

                driver.navigate().to("https://surveyxan.com/Cloudapp/app18/Login.aspx?qqmcml_1115_a3055");
                
                // Locate and fill fields
                WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt_LoginID")));
                Thread.sleep(2000);
                WebElement passField = driver.findElement(By.id("txt_LoginPswrd"));
                
                userField.clear();
                userField.sendKeys(user);
                passField.clear();
                passField.sendKeys(pass);

                driver.findElement(By.id("btnLogin")).click();

                // Check for failure: DemoQA shows error text "Invalid username or password!" in a p element with id 'name'
                try {
                    // Short wait to see if error message appears
                    WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
                    WebElement errorMsg = shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
                    
                    if (errorMsg.getText().contains("Invalid")) {
                        System.out.println("Row " + i + ": Login failed for " + user + ". Trying next...");
                        continue; // Go to next row in Excel
                    }
                } catch (Exception e) {
                    // If no error message appears, check if we reached the Profile page
                    if (driver.getCurrentUrl().contains("profile")) {
                        System.out.println("Login Successful with: " + user);
                        break; // Exit loop on success
                    }
              
        
        
        
		// TODO Auto-generated method stub

	
//		System.setProperty("Webdriver.chrome.driver", "D:\\new_winit\\chromedriver-win64 (1).zip\\chromedriver-win64.exc");

//			WebDriver driver = new ChromeDriver();
			
//			driver.get("https://surveyxan.com/Cloudapp/app18/Login.aspx?ft25w4_1112_T7887");
			
			
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			
//			Thread.sleep(2000);
//			driver.findElement(By.id("txt_LoginID")).sendKeys("VKS");
//			
//			Thread.sleep(1000);
//			driver.findElement(By.id("txt_LoginPswrd")).sendKeys("VKS");
			
//			Thread.sleep(3000);
//			WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(4));
//			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#btnLogin"))).click();
			
			
//			quota 	kpi
		
//			Thread.sleep(2000);
			  driver.findElement(By.className("dropbtn")).click();
				
//			Thread.sleep(1000);
			driver.findElement(By.id("MyLinks1_btnKPI")).click();
			
			
			
			Thread.sleep(2000);
			driver.findElement(By.id("btnexpand")).click();
			
			
			// Initialize JavascriptExecutor
			JavascriptExecutor kpi = (JavascriptExecutor) driver;
			Thread.sleep(1000); 
			
			kpi.executeScript("window.scrollTo({top: document.body.scollHeight , behavior : 'smooth'});");
//			

            // Execute JavaScript to scroll smoothly to the bottom
            // This script uses the modern scrollTo method with a smooth behavior option
            String smoothScrollScript = "window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });";
            kpi.executeScript(smoothScrollScript);
			
			
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#myBtn")).click();
			
		
//			trriger
			
			Thread.sleep(2000);
			driver.findElement(By.className("dropbtn")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#MyLinks1_btnAlertNotification")).click();
			
			JavascriptExecutor trriger = (JavascriptExecutor) driver;
			Thread.sleep(1000); 
			trriger.executeScript("window.scrollTo({top: 4000,behavior : 'smooth'});");
			
			/*
//			respodent wise status
			
			Thread.sleep(2000);
			driver.findElement(By.className("dropbtn")).click();
			
			Thread.sleep(1000);
			driver.findElement(By.id("MyLinks1_btnStatus")).click();			
			JavascriptExecutor respodentwise = (JavascriptExecutor) driver;
			Thread.sleep(1000);
			respodentwise.executeScript("window.scrollTo({top: 2500,behavior : 'smooth'});");
			
			
			
//			Download tab 
			
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("#myTopnav > div:nth-child(3) > button")).click();
				
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#MyLinks1_btnDownloaddata")).click();	
			
//			select type for successful
			Thread.sleep(2000);
			driver.findElement(By.id("ContentPlaceHolder1_Ddl_Type")).click();
			
			Thread.sleep(2000);
		    driver.findElement(By.cssSelector("#ContentPlaceHolder1_Ddl_Type > option:nth-child(1)")).click();
		    	
		    
//		    Select Template:	
		    Thread.sleep(2000);
		    driver.findElement(By.id("ContentPlaceHolder1_ddlTemplate")).click();
		    
//		    Select Date Type:
		    Thread.sleep(2000);
		    driver.findElement(By.cssSelector(" #ContentPlaceHolder1_ddldateType")).click();
		    
		    Thread.sleep(2000);
			JavascriptExecutor Date = (JavascriptExecutor) driver;
			Date.executeScript("window.scrollBy(0,500)");
			
//		    select city
		    Thread.sleep(2000);
		    driver.findElement(By.id("ContentPlaceHolder1_chkAll")).click();
		    
//		    with Heading
		    Thread.sleep(2000);
		    driver.findElement(By.id("ContentPlaceHolder1_chkSHeading")).click();
		    
//		    With Value Label
		    Thread.sleep(2000);
		    driver.findElement(By.id("ContentPlaceHolder1_CheckBox2")).click();
		    
//		    download data
		    driver.findElement(By.className("btnexcel"));
		   		  
		    
//			select type for unsuccessful
						
			Thread.sleep(4000);
		    driver.findElement(By.cssSelector("#ContentPlaceHolder1_Ddl_Type > option:nth-child(2)")).click();
		    
		    
//		    download data
		    Thread.sleep(3000);
		     driver.findElement(By.className("btnexcel"));
		  
		    
//			select type for both
		
			
			Thread.sleep(3000);
		    driver.findElement(By.cssSelector("#ContentPlaceHolder1_Ddl_Type > option:nth-child(3)"));
		   
		    
//		    download data
		    driver.findElement(By.className("btnexcel")).click();
		    
		    
		    
//			QC 
		    
//		    respondent Status
		    Thread.sleep(1000);
		    driver.findElement(By.cssSelector("#myTopnav > div:nth-child(6) > button")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("MyLinks1_btnNewRespondentStatus")).click();
//		    driver.findElement(By.className("clicked")).click();
		    
		//  successful btn
		  driver.findElement(By.id("ContentPlaceHolder1_btnSuccessful")).click();
		  Thread.sleep(1000);
		
			
		//  unsuccessful btn
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_btnUnSuccessful\"]")).click();
		    
		    Thread.sleep(2000);
//		    JavascriptExecutor unsuccessful = (JavascriptExecutor) driver;
//		    unsuccessful.executeScript("window.scrollTo({top: 2000,behavior : 'smooth'});");
		    
		    //drop btn
		    Thread.sleep(1000);
		  driver.findElement(By.id("ContentPlaceHolder1_btnDrop")).click();
		  Thread.sleep(1000);
		  JavascriptExecutor drop = (JavascriptExecutor) driver;
		  drop.executeScript("window.scrollTo({top: 1000,behavior : 'smooth'});");
		    


		//all btn
		Thread.sleep(1000);
		driver.findElement(By.id("ContentPlaceHolder1_btnAll")).click();
		Thread.sleep(1000);
		JavascriptExecutor respondentStatus = (JavascriptExecutor) driver;

		respondentStatus.executeScript("window.scrollTo({top: 2000,behavior : 'smooth'});");
		*/
/*
		//Auto_Resp_Id

		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlVal > option:nth-child(1)")).click();
		driver.findElement(By.id("ContentPlaceHolder1_ddlVal")).click();

		//input of auto resp
		Thread.sleep(2000);
		driver.findElement(By.id("ContentPlaceHolder1_txtfnd")).sendKeys("26,25");
		
		//apply btn
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_Button1\"]")).click();

		//Select all
		Thread.sleep(1000);
		driver.findElement(By.id("ContentPlaceHolder1_GridView2_CheckBox2")).click();

		//download
		Thread.sleep(2000);
		driver.findElement(By.id("ContentPlaceHolder1_Downloadbtn")).click();

		//successful btn
		driver.findElement(By.id("ContentPlaceHolder1_btnSuccessful")).click();
		Thread.sleep(1000);
		
		//Auto_Resp_Id

		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlVal > option:nth-child(1)")).click();

		//apply btn
		driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_Button1\"]")).click();
		
		driver.findElement(By.id("ContentPlaceHolder1_GridView2_CheckBox2")).click();
		

		//reason
		Thread.sleep(2000);
		driver.findElement(By.id("ContentPlaceHolder1_Rtxtbox")).sendKeys("Drop for Testing");

		//drop btn
		Thread.sleep(2000);
		driver.findElement(By.id("ContentPlaceHolder1_DropBtn")).click();
		
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		
		
		 //tab drop btn
	    Thread.sleep(1000);
	  driver.findElement(By.id("ContentPlaceHolder1_btnDrop")).click();
	  
	  
//		 //drop tb
	  
	    Thread.sleep(1000);
	  driver.findElement(By.cssSelector("#ContentPlaceHolder1_btnDrop")).click();
	  driver.findElement(By.id("ContentPlaceHolder1_GridView2_CheckBox2")).click(); 
	  
//	  recall
	  Thread.sleep(1000);
	  driver.findElement(By.id("ContentPlaceHolder1_Recallbtn")).click(); 
	  
	  driver.switchTo().alert().accept();
	  Thread.sleep(1000);
	  driver.switchTo().alert().accept();
	  
	  
	//all btn
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#ContentPlaceHolder1_btnAll")).click();
			
			
			//apply btn
		
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlVal > option:nth-child(1)")).click();
			driver.findElement(By.id("ContentPlaceHolder1_ddlVal")).click();

			
			//apply btn
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_Button1\"]")).click();
			
	*/
		
		/*
//		    Alert
		    Thread.sleep(3000);
		    driver.findElement(By.cssSelector("#myTopnav > div:nth-child(6) > button")).click();
		    driver.findElement(By.id("MyLinks1_btnAlerts")).click();
		    
		    Thread.sleep(2000);
			JavascriptExecutor Alert = (JavascriptExecutor) driver;
			Alert.executeScript("window.scrollTo({top: 800,behavior : 'smooth'});");
		    
//		    Dropout
		    
		    Thread.sleep(2000);
		    driver.findElement(By.cssSelector("#myTopnav > div:nth-child(6) > button")).click();
		    driver.findElement(By.id("MyLinks1_btnDropout")).click();
		    
		    JavascriptExecutor Dropout = (JavascriptExecutor) driver;
		    Thread.sleep(2000);
		    Dropout.executeScript("window.scrollTo({top: 800,behavior : 'smooth'});");
			
			
//		    Device Registration
		    
		    Thread.sleep(2000);
		    driver.findElement(By.cssSelector("#MyLinks1_btnDeviceRegistration")).click();
		    
		    JavascriptExecutor Registration = (JavascriptExecutor) driver;
		    Thread.sleep(2000);
		    Registration.executeScript("window.scrollTo({top: 1000,behavior : 'smooth'});");
		    
		    */
		    
//		    syncing status
		    
		    Thread.sleep(2000);
		    driver.findElement(By.cssSelector("#myTopnav > div:nth-child(5) > button")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("MyLinks1_btnsyncstatus")).click();
		    JavascriptExecutor syncing = (JavascriptExecutor) driver;
		    syncing.executeScript("window.scrollTo({top: 800,behavior : 'smooth'});");
		    
//		    Sync Emailed data
		    Thread.sleep(2000);
		    driver.findElement(By.cssSelector("#myTopnav > div:nth-child(5) > button")).click();
		    
		    driver.findElement(By.id("MyLinks1_btnSyncdata")).click();
		    Thread.sleep(2000);
		    JavascriptExecutor Emailed = (JavascriptExecutor) driver;
		    Emailed.executeScript("window.scrollTo({top: 800,behavior : 'smooth'});");
		    
		    
//		    Status on uploads
		    
		    Thread.sleep(3000);
		    driver.findElement(By.cssSelector("#myTopnav > div:nth-child(5) > button")).click();
		    driver.findElement(By.id("MyLinks1_btnUploadDetails")).click();
		    JavascriptExecutor uploads = (JavascriptExecutor) driver;
		    uploads.executeScript("window.scrollTo({top: 1000,behavior : 'smooth'});");
		    
//		all    Device Id :
		    Thread.sleep(2000);
		    driver.findElement(By.cssSelector("#ContentPlaceHolder1_ddldeviceid > option:nth-child(2)")).click();
	
		    
//		  all   Upload Date :	
		    Thread.sleep(2000);
		    driver.findElement(By.id("ContentPlaceHolder1_ddluploaddate")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.cssSelector("#ContentPlaceHolder1_ddluploaddate > option:nth-child(2)")).click();
		    JavascriptExecutor Upload = (JavascriptExecutor) driver;
		    Upload.executeScript("window.scrollTo({top: 1000,behavior : 'smooth'});");
		  
		
//		    Center 
		    Thread.sleep(3000);
		     driver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlcenter > option:nth-child(3)")).click();
		 
		  
//		  single   Device Id :	
		     Thread.sleep(2000);
		     driver.findElement(By.cssSelector("#ContentPlaceHolder1_ddldeviceid > option:nth-child(5)")).click();
		   
			 
		     
//		   single  Upload Date :	
				    Thread.sleep(1000);
				    driver.findElement(By.id("ContentPlaceHolder1_ddluploaddate")).click();
				    Thread.sleep(2000);
				    driver.findElement(By.cssSelector("#ContentPlaceHolder1_ddluploaddate > option:nth-child(3)")).click();
				    Upload.executeScript("window.scrollTo({top: 1000,behavior : 'smooth'});");
				    
				    
				    
				    Thread.sleep(5000);
				    
//		     driver.close();

		     
			}
        
    }
} catch (Exception e) {
    e.printStackTrace();
} 
	}
}
//finally {
//    driver.quit();
//}

