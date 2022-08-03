package main.java.main.pageLocators;

public interface openCartLocators {
	
	// Username && Password
	String inputEmail = "input[id='input-email']";
	String inputPassword = "input[id='input-password']";
	
	
	// Localizador botones
	String btnDropdown = "li[class='dropdown']>a[title='My Account']";
	String btnLogin = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]";
	String btnLoginSesion = "input[type='submit']";
	String btnMonitor = "//*[@id=\"menu\"]/div[2]/ul/li[3]/div/div/ul/li[2]";
	//String btnMonitor = "div>ul>li>a[href='http://opencart.abstracta.us:80/index.php?route=product/category&path=25_28']";
	String btnAddCart = "button[onclick=\"cart.add('33', '1');\"]";
	String btnCarrito = "span[id='cart-total']";
	//String btnCarrito = "/html/body/header/div/div/div[3]/div/button/span";
	//String btnCarrito = "//*[@id=\"cart-total\"]";
	//*[@id=\"cart\"]/button
	
	
	//label
	String lbtextPage = "//*[@id=\"content\"]/h2[1]";

	// LIST
	String listProducts = "//*[@id=\"content\"]/div[3]";
	

}
