package com.codedchai.designpatterns.strategy;

public class ShoppingCartTest {

	public static void main(String[] args){
		ShoppingCart cart = new ShoppingCart();
		Item laptop = new Item("Laptop", 1000);
		Item headphones = new Item("HD598", 200);

		cart.addItem( laptop );
		cart.addItem( laptop );
		cart.addItem( headphones );

		cart.pay( new PaypalStrategy( "Connor@Hasting.com" ) );

		cart.pay( new CreditCardStrategy( "Connor Hasting", "I promise I'm a card number", "000", "11/15" ) );
	}

}
