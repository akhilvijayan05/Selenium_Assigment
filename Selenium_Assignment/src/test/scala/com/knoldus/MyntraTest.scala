package com.knoldus

/**
  * Created by knoldus on 27/3/17.
  */

import java.util.concurrent.TimeUnit

import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.{ExpectedConditions, Select}
import org.scalatest.FlatSpec

class MyntraTest extends FlatSpec with Myntra {

  "A user" should "visit on amazon.in" in {

    driver.manage().window().maximize()
    driver.get(BASE_URL)
    val title = driver.getTitle()
    val page_source = driver.getPageSource().length
  }

  "user" should "fail to login with invalid credentials" in {

    driver.manage().window().maximize()
    driver.get(BASE_URL)

    val dropDown = driver.findElementByCssSelector("div.desktop-user")
    val mouseHover = new Actions(driver)
    mouseHover.moveToElement(dropDown)
    mouseHover.build().perform()

    driver.findElementByCssSelector("div.desktop-getUserInLinks.desktop-getInLinks a:nth-child(2)").click()

    driver.findElementByCssSelector("input.login-user-input-email.login-user-input").sendKeys("a123@gmail.com")

    driver.findElementByCssSelector("input.login-user-input-password.login-user-input").sendKeys("123456")

    driver.findElementByCssSelector("button.login-login-button").click()
  }

  "user" should "logged in " in {

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

  "user" should "select a T-shirt" in {

    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.results-base li.product-base a:nth-child(2)")))

    driver.findElementByCssSelector("li.product-base a:nth-child(2)").click()
  }



  "user" should "be able to choose the desired size of the selected t-shirt and then add it to the cart" in {

    driver.findElementByCssSelector("button.size-buttons-size-button.size-buttons-size-button-default").click()

    driver.findElementByCssSelector("button.pdp-add-to-bag.pdp-button").click()
  }

  "user" should "search for watches category" in {

    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.desktop-searchBar")))

    val search: WebElement =driver.findElementByCssSelector("input.desktop-searchBar")
    search.sendKeys("watches")
    driver.findElementByCssSelector("a.desktop-submit").click()
  }

  "user" should "select a watch" in {

    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.product-base a:nth-child(2)")))

    driver.findElementByCssSelector("li.product-base a:nth-child(2)").click()
  }

  "user" should "be able to add the watch to the cart" in {

    driver.findElementByCssSelector("button.pdp-add-to-bag.pdp-button").click()

  }
  "user" should "be able to verify the products added to cart" in {

    driver.findElementByCssSelector("a.desktop-cart").click()
  }

  "user" should "be able to checkout" in {

    //webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.place-order.b-white button.btn.primary-btn.btn-continue.m-button.clickable")))

    driver.findElementByCssSelector("div.order-total.footer div.place-order.b-white button.btn.primary-btn.btn-continue.m-button.clickable ").click()

    driver.findElementByCssSelector("input.pincode").sendKeys("110096")

//    val dropDown = driver.findElementByCssSelector("input.locality")
////    val mouseHover = new Actions(driver)
////    mouseHover.moveToElement(dropDown)
////    mouseHover.click().perform()
//    new Actions(driver).moveToElement(dropDown).click().perform()
    driver.findElementByCssSelector("input.locality").click()
    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.suggestions div.bd button")))
    driver.findElementByCssSelector("div.suggestions div.bd button").click()

    driver.findElementByCssSelector("input.name").sendKeys("Akhil Vijayan")

    driver.findElementByCssSelector("textarea.address").sendKeys("Mayur Vihar Phase 3")

    driver.findElementByCssSelector("input.mobile").sendKeys("8899566432")

    driver.findElementByCssSelector("button.green-button.submit.clickable").click()

    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.primary-btn.btn-continue.green-button.clickable")))
    driver.findElementByCssSelector("button.btn.primary-btn.btn-continue.green-button.clickable").click()
  }

}