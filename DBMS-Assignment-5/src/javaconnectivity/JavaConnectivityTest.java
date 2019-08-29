package javaconnectivity;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for JDBC connectivity
 * @author Mahendar Singh
 *
 */
public class JavaConnectivityTest {

	DataLayer dl=new DataLayer();
	BusinessLayer bl=new BusinessLayer();

	@Before
	public void setConnection(){	
		dl.setDriver("com.mysql.jdbc.Driver") ;
		dl.setConnection("jdbc:mysql://localhost:3306/store_front","root","admin");

	}

	/**
	 * test for fetching order details
	 * @throws SQLException
	 */
	@Test
	public void fetchOrderLineItemsTest() throws SQLException
	{
		List<Orders> expected = new ArrayList<>();
		List<Orders> orderList = new ArrayList<>();
		orderList = bl.fetchOrderDetails(dl,2);
		expected.add(new Orders(1 , "2019-08-01 09:20:36.0" , 2500));

		assertEquals(expected.get(0).getOrderId(), orderList.get(0).getOrderId());

	}

	/**
	 * test for image insertion
	 * @throws SQLException
	 */
	@Test
	public void insertIntoImageTest() throws SQLException 
	{        
		dl.setStatement("INSERT INTO images VALUES(2,'secondImage')");
		dl.getStatement().execute();
		dl.setStatement("SELECT product_id,image_src FROM images WHERE image_src = 'secondImage'");
		ResultSet rset = dl.getStatement().executeQuery();
		assert(rset.next());
	}


	/**
	 * test for getting top category and number of child
	 * @throws SQLException
	 */
	@Test
	public void getTopCategoryTest() throws SQLException
	{
		List<Category> result = bl.getTopCategory(dl);
		List<Category> expected = new ArrayList<Category>();
		expected.add(new Category("electronics" ,3));

		assertEquals(expected.get(0).getNumberOfChildren(), result.get(0).getNumberOfChildren());

	}
}

