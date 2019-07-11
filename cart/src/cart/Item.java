package cart;

public class Item {

	int itemCode;
	String itemName;
	double itemPrice;
	int itemQuantity;

	Item(int code, String name, double price) 
	{
		itemCode = code;
		itemName = name;
		itemPrice = price;
		itemQuantity = 0;
	}

}
