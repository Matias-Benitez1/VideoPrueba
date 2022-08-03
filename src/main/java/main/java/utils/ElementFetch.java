package main.java.main.java.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import main.java.main.base.BaseClass;

public class ElementFetch {

	public WebElement getWebElement(String identifierType, String identifierValue) {
        switch (identifierType) {
            case "ID":
                return BaseClass.driver.findElement(By.id(identifierValue));
            case "CSS":
                return BaseClass.driver.findElement(By.cssSelector(identifierValue));
            case "TAGNAME":
                return BaseClass.driver.findElement(By.tagName(identifierValue));
            case "XPATH":
                return BaseClass.driver.findElement(By.xpath(identifierValue));
            case "LINK TEXT":
                return BaseClass.driver.findElement(By.linkText(identifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> getListWebElements(String identifierType, String identifierValue) {
        switch (identifierType) {
            case "ID":
                return BaseClass.driver.findElements(By.id(identifierValue));
            case "CSS":
                return BaseClass.driver.findElements(By.cssSelector(identifierValue));
            case "TAGNAME":
                return BaseClass.driver.findElements(By.tagName(identifierValue));
            case "XPATH":
                return BaseClass.driver.findElements(By.xpath(identifierValue));
            case "LINK TEXT":
                return BaseClass.driver.findElements(By.linkText(identifierValue));
            default:
                return null;
        }
    }
}
