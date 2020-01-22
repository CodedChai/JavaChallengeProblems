package com.codedchai.designpatterns.strategy;

import java.util.HashMap;
import java.util.Set;

public class ShoppingCart {

	HashMap<Item, Integer> itemCountMap;

	public ShoppingCart(){
		this.itemCountMap = new HashMap <>(  );
	}

	public void addItem(Item item){
		if(itemCountMap.containsKey( item  )){
			itemCountMap.put( item, itemCountMap.get( item ) + 1 );
		} else {
			itemCountMap.put( item, 1 );
		}
	}

	public void removeItem(Item item){
		if(itemCountMap.containsKey( item  )){
			itemCountMap.put( item, itemCountMap.get( item ) - 1 );
			int numItems = itemCountMap.get( item );
			if(numItems <= 0){
				itemCountMap.remove( item );
			}
		}
	}

	public int calculateTotal(){
		Set <Item> keys = itemCountMap.keySet();

		return keys.stream().mapToInt( key -> itemCountMap.get( key ) * key.getPrice() ).sum();
	}

	public void pay(PaymentStrategy paymentMethod){
		int amount = calculateTotal();
		paymentMethod.pay(amount);
	}

}
