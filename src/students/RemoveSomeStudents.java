package students;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class RemoveSomeStudents {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\DELL\\Desktop\\Ehab(QA)\\MyEdgeWebDriver\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:5500/index.html");

		List<WebElement> myOption = driver.findElements(By.tagName("Option"));
		System.out.println("The Student of number before remove = " + myOption.size());
		for (int i = 0; i < myOption.size(); i++) {
			if (i % 2 == 0) {
				myOption.get(i).click();
				System.err.println("I will remove " + myOption.get(i).getText());
				driver.findElement(By.id("remove")).click();

			} else {
				System.out.println("I will keep " + myOption.get(i).getText());
			}

		}
		List<WebElement> myOptionNew = driver.findElements(By.tagName("Option"));
		System.out.println("The Student of number after remove = " + myOptionNew.size());
		
		Date currentDate = new Date();
		String actualDate = currentDate.toString().replace(":", "-");
	    
		TakesScreenshot scrShot =((TakesScreenshot) driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(".//pictures//"+actualDate+".png");
        FileUtils.copyFile(SrcFile, DestFile);
	}

}
