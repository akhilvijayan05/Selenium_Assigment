package com.knoldus

/**
  * Created by knoldus on 27/3/17.
  */
import org.openqa.selenium.chrome.ChromeDriver
//import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.WebDriverWait

trait Myntra {

  val BASE_URL = "http://www.myntra.com/"
  val EMAIl = "avinvisible@gmail.com"
  val password = "akhil123"
  System.setProperty("webdriver.chrome.driver", "/home/knoldus/chrome_driver/chromedriver")
  val capabilities = DesiredCapabilities.chrome()
  val driver = new ChromeDriver(capabilities)
  val webdriverwait = new WebDriverWait(driver, 20)



}
