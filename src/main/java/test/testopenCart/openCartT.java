package main.java.test.testopenCart;

import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import main.java.main.base.BaseClass;
import main.java.main.java.utils.utils;
import main.java.main.pageEvents.openCartLogin;
import main.java.main.java.utils.openCSV;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class openCartT extends BaseClass {

	@Test(enabled = true, dataProvider = "CarritosCompras")
	public void QAS1(String args[]) throws InterruptedException {
		utils.infoTestCase("Carrito de compras", 
				"Validar la generacion de una compra al agregar un producto");
		openCartLogin.login(args[0], args[1]);
		openCartLogin.selectProduct(args[2]);

	}

	@DataProvider(name = "CarritosCompras")
	public Object[][] dataBrokerAPAlternative() throws CsvValidationException, InterruptedException, IOException {

		Object[][] data = openCSV.getCSVParameters("CarritoCompras.csv", 1, 3);
		return data;
	}

}
