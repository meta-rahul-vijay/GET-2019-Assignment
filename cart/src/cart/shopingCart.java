package cart;

import java.util.*;

public class shopingCart {
	static ArrayList<Item> itemCart = new ArrayList<Item>();

	/**
	 * Add item to cart
	 * @param item i to be added to cart
	 */
	static void addToCart(Item i) {
		itemCart.add(i);
		System.out.println("Item added successfully...\n");
	}

	/** Update the quantity of a item in cart
	 * @param i item which need to be updated
	 * @param q new quantity of item i
	 */
	static void updateCart(Item i, int q) {
		i.itemQuantity = q;
		if (q == 0) 
		{
			itemCart.remove(i);
		}
		System.out.println("Item updated successfully...\n");
    }

	/**
	 * Display the items in cart
	 */
	static void displayCart() {
		System.out.println("welcome\nfollowing items are available in cart..");
		System.out.println("Item code\t Item name\t item price\t item Quantity");
		for (int i = 0; i < itemCart.size(); i++) {
			System.out.println(itemCart.get(i).itemCode + "\t\t"+ itemCart.get(i).itemName + "\t\t"+ itemCart.get(i).itemPrice + "\t\t"+ itemCart.get(i).itemQuantity);
		}
	}

	/**
	 * Generate the bill of the items in cart
	 */
	static void generateBill() {
		System.out.println("Item code\t Item name\t item price\t item Quantity\t item total cost");
		for (int i = 0; i < itemCart.size(); i++) 
		{
			System.out.println(itemCart.get(i).itemCode + "\t\t"+ itemCart.get(i).itemName + "\t\t"+ itemCart.get(i).itemPrice + "\t\t"+ itemCart.get(i).itemQuantity + "\t\t"+ itemCart.get(i).itemPrice * itemCart.get(i).itemQuantity);
		}

		double totalAmount = 0;

		for (int i = 0; i < itemCart.size(); i++) {
			totalAmount += itemCart.get(i).itemPrice
					* itemCart.get(i).itemQuantity;
		}
		System.out.println("Toatl amount to be paid : " + totalAmount);
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		ArrayList<Item> itemList = new ArrayList<Item>();
		Item bat = new Item(1, "bat", 700);
		itemList.add(bat);
		Item ball = new Item(2, "ball", 220);
		itemList.add(ball);
		Item gloves = new Item(3, "gloves", 250);
		itemList.add(gloves);
		Item helmet = new Item(4, "helmet", 1200);
		itemList.add(helmet);
		Item shoes = new Item(5, "shoes", 1500);
		itemList.add(shoes);
		Item wickets = new Item(6, "wickets", 120);
		itemList.add(wickets);

		System.out.println("welcome\nfollowing items are available..");
		System.out.println("Item code\t Item name\t item price");
		for (int i = 0; i < itemList.size(); i++) 
		{
			System.out.println(itemList.get(i).itemCode + "\t\t"+ itemList.get(i).itemName + "\t\t"+ itemList.get(i).itemPrice);
		}

		int choice=0;

		do {
			System.out.println("Select the preferred choice:\n1.add item in cart\n2.update item in cart\n3.display item in cart\n4.generate bill\n5.Exit");
			try
			{
			    choice = in.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("Invalid choice.. try again");
			}
			switch (choice) {
			case 1:
				int aCode,
				aQuantity;
				System.out.println("enter item code..");
				aCode = in.nextInt();
				System.out.println("enter item quantity..");
				aQuantity = in.nextInt();
				if (aQuantity <= 0) 
				{
					System.out.println("please enter correct quantity..\n");
					break;
				}
				int i;
				for (i = 0; i < itemList.size(); i++) 
				{
					if (itemList.get(i).itemCode == aCode) 
					{
						if (itemCart.contains(itemList.get(i))) 
						{
							System.out.println("Item already present in cart, please update quantity in cart..");
							break;
						} 
						else 
						{
							itemList.get(i).itemQuantity = aQuantity;
							addToCart(itemList.get(i));
							break;
						}
					}

				}
				if (i == itemList.size())
					System.out.println("Wrong input .. try again..\n");
				break;

			case 2:
				int uCode,
				uQuantity;
				System.out.println("enter item code to update..");
				uCode = in.nextInt();

				int j;
				for (j = 0; j < itemCart.size(); j++) 
				{
					if (itemCart.get(j).itemCode == uCode) 
					{
						System.out.println("enter new quantity..");
						uQuantity = in.nextInt();
						if (uQuantity < 0) {
							System.out.println("please enter correct quantity..\n");
							break;
						}
						updateCart(itemCart.get(j), uQuantity);
						break;
					}
				}
				if (j == itemCart.size())
					System.out.println("Wrong input .. try again..\n");
				break;

			case 3:
				displayCart();
				break;

			case 4:
				generateBill();
				break;

			case 5:
				System.exit(0);
				break;

			default:
				System.out.println("Wrong input , Try again..");

			}
		} while (true);
	}
}
