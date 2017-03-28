package com.knoldus

/**
  * Created by knoldus on 27/3/17.
  */

import java.util.concurrent.TimeUnit

import org.openqa.selenium.By
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.{ExpectedConditions, Select}
import org.scalatest.FlatSpec

class MyntraTest extends FlatSpec with Myntra {

  "A user" should "visit on amazon.in" in {

    driver.manage().window().maximize()
    driver.get(BASE_URL)
    val title = driver.getTitle()
    val page_source = driver.getPageSource().length
    if (driver.getCurrentUrl == BASE_URL) {
      println("WELCOME TO AMAZON.in with title : " + title)
      println("the lenght of the pagesource is: " + page_source)
    } else {
      println("something went wrong")
    }
  }

  "user" should "logged in " in {

    driver.manage().window().maximize()
    driver.get(BASE_URL)

    val dropDown = driver.findElementByCssSelector("div.desktop-user")
    val mouseHover = new Actions(driver)
    mouseHover.moveToElement(dropDown)
    mouseHover.build().perform()

    driver.findElementByCssSelector("div.desktop-getUserInLinks.desktop-getInLinks a:nth-child(2)").click()

    driver.findElementByCssSelector("input.login-user-input-email.login-user-input").sendKeys(EMAIl)

    driver.findElementByCssSelector("input.login-user-input-password.login-user-input").sendKeys(password)

    driver.findElementByCssSelector("button.login-login-button").click()
  }

  "user" should "select a T-shirt category" in {

    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.navi-base  a.navi-link.navi-pad")))

    driver.findElementByCssSelector("li.navi-base  a.navi-link.navi-pad ").click()
  }

  //  "user" should "select a T-shirt" in{
  //
  //    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.results-base li.product-base a:nth-child(2)")))
  //
  //    driver.findElementByCssSelector("li.product-base a:nth-child(2)").click()
  //  }

  "user" should "select a T-shirt" in {

    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.results-base li.product-base a:nth-child(2)")))

    driver.findElementByCssSelector("li.product-base a:nth-child(2)").click()
  }

  "user" should "be able to choose the desired size of the selected t-shirt and then add it to the cart" in {

    driver.findElementByCssSelector("button.size-buttons-size-button.size-buttons-size-button-default").click()

    driver.findElementByCssSelector("button.pdp-add-to-bag.pdp-button").click()
  }

  "user" should "be able to checkout" in {

    driver.findElementByCssSelector("a.desktop-cart").click()
  }

}