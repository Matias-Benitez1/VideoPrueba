package main.java.main.pageEvents;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.main.java.utils.ElementFetch;
import main.java.main.java.utils.Events;
import main.java.main.java.utils.Validaciones;
import main.java.main.java.utils.utils;
import main.java.main.pageLocators.openCartLocators;
//import main.java.pageObjects.CarritoComprasElements;
//import main.java.pageObjects.CarritoComprasElements;
//import main.java.pageObjects.CarritoComprasElements;
import main.java.test.testopenCart.openCartT;
//import main.java.utils.Validations;
//import main.java.utils.Validations;

public class openCartLogin extends openCartT {

	public openCartLogin(WebDriver driver) {
		openCartT.driver = driver;
	}

	public static void login(String usuario, String contrasena) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();
		try {
			utils.outputInfo("Se ha comenzado el evento: "+ currentEvent);
			
			WebDriverWait wait = new WebDriverWait(driver, 50);
			ElementFetch elementFetch = new ElementFetch();
			
			WebElement btnDropdown = elementFetch.getWebElement("CSS",
					openCartLocators.btnDropdown);
			wait.until(ExpectedConditions.visibilityOf(btnDropdown));
			Events.clickButton(btnDropdown);
			
			WebElement btnLogin = elementFetch.getWebElement("XPATH", 
					openCartLocators.btnLogin);
			wait.until(ExpectedConditions.visibilityOf(btnLogin));
			Events.clickButton(btnLogin);
			
			WebElement inputusuario = elementFetch.getWebElement("CSS", 
					openCartLocators.inputEmail);
			wait.until(ExpectedConditions.visibilityOf(inputusuario));
			Events.writeOnInput(inputusuario, usuario);
			
			WebElement inputcontrasena = elementFetch.getWebElement("CSS",
					openCartLocators.inputPassword);
			wait.until(ExpectedConditions.visibilityOf(inputusuario));
			Events.writeOnInput(inputcontrasena, contrasena);
			
			WebElement btnLoginSesion = elementFetch.getWebElement("CSS", 
					openCartLocators.btnLoginSesion);
			wait.until(ExpectedConditions.visibilityOf(btnLoginSesion));
			Events.clickButton(btnLoginSesion);
			
			WebElement labelPaginaProductosElement = elementFetch.getWebElement("XPATH",
					openCartLocators.lbtextPage);
			wait.until(ExpectedConditions.visibilityOf(labelPaginaProductosElement));
			String textoPagina = labelPaginaProductosElement.getText();

			Validaciones.trueBooleanCondition(textoPagina.equalsIgnoreCase("My Account"),
					"Se ha ingresado a la página '" + textoPagina + "' correctamente",
					"No se ha ingresado a la página correcta", currentEvent);
			
		} catch (Exception e) {
			
			utils.eventFailed(currentEvent, e.getMessage());
		}
	}
	
	public static void selectProduct(String producto) {
		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();
		
		try {
			utils.outputInfo("Ha comenzado el evento: " + currentEvent);
			
			WebDriverWait wait = new WebDriverWait(driver, 50);
			ElementFetch elementfetch = new ElementFetch();
			
			WebElement btnMonitor = elementfetch.getWebElement("XPATH", 
					openCartLocators.btnMonitor);
			wait.until(ExpectedConditions.visibilityOf(btnMonitor));
			Events.clickButton(btnMonitor);
			
			List<WebElement> listProduct = elementfetch.getListWebElements("XPATH", 
					openCartLocators.listProducts);
			wait.until(ExpectedConditions.visibilityOfAllElements(listProduct));
			
			for (int i = 0; i < listProduct.size(); i++) {
				String nombreProducto = listProduct.get(i).getText();
				if (nombreProducto.equalsIgnoreCase(producto)) {
					WebElement buttonAgregarElement = elementfetch.getWebElement("CSS", openCartLocators.btnAddCart.replace("0", String.valueOf(i+1)));
					Events.clickButton(buttonAgregarElement);
				}
			}
			
			WebElement spanCarritoElement = elementfetch.getWebElement("CSS", openCartLocators.btnCarrito);
			wait.until(ExpectedConditions.visibilityOf(spanCarritoElement));
			String cantidadCarrito = spanCarritoElement.getText();
			Validaciones.trueBooleanCondition(cantidadCarrito.contains("1"),
					"Se ha agregado el producto al carrito correctamente",
					"No se ha agregado el producto al carrito correctamente", currentEvent);
		} catch (Exception e) {
			utils.eventFailed(currentEvent, e.getMessage());
		}
	}

}
