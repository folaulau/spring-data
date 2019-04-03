package com.lovemesomecoding.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.time.DateUtils;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lovemesomecoding.address.Address;
import com.lovemesomecoding.customer.Customer;
import com.lovemesomecoding.employee.Employee;
import com.lovemesomecoding.loader.EntityLimit;
import com.lovemesomecoding.office.Office;
import com.lovemesomecoding.order.Order;
import com.lovemesomecoding.order.OrderDetail;
import com.lovemesomecoding.product.Product;

public final class ConstantUtils {
	
	private static final List<String> firstnames = Arrays.asList("Taylor","Bailey","Josiah","Clay"
			,"Archie","Nicolas","Lucero","Davin","Odell",
			"Princeton","Garcia","Amando","Ernesto","Lorena",
			"Maya","Osborn","Sancho","Ruben",
			"Nick","Jorge","Dominique","Elvis","Kendra","Cristian","Jayden",
			"Lisa","Regan","Jabari","Emma","Ryann","Luna","Janelle"
			,"Kelsey","Briana","Richard","Gracelyn","Willie","Sidney","Sean","Skyler"
			,"Rolando","Stephanie","Terrell","Karla","Javier","Kimberly","Macy","Irene");
	
	private static final List<String> lastnames = Arrays.asList("Edwards","Campbell","Young","Morgan","Evans",
			"Murray","Jenkins","Ross","Mccarthy","Brown","Robinson","Johnson","Smith"
			,"Thomas","Wilson","Jones","Lee","Thompson","Walker","Jackson","James","Turner");
	
	private static final List<String> employeeTitles = Arrays.asList("Supervisor","Employee","Manager","CEO");
	
	private static final List<String> employeeOffice = Arrays.asList("Lion","Tiger","Eagle","Dove");
	
	private static final List<String> productNames = Arrays.asList("Trek 820 - 2016","Ritchey Timberwolf Frameset - 2016","Surly Wednesday Frameset - 2016","Trek Fuel EX 8 29 - 2016","Heller Shagamaw Frame - 2016","Surly Ice Cream Truck Frameset - 2016","Trek Slash 8 27.5 - 2016","Trek Remedy 29 Carbon Frameset - 2016","Trek Conduit+ - 2016","Surly Straggler - 2016","Surly Straggler 650b - 2016","Electra Townie Original 21D - 2016","Electra Cruiser 1 (24-Inch) - 2016","Electra Girl","Electra Moto 1 - 2016","Electra Townie Original 7D EQ - 2016","Pure Cycles Vine 8-Speed - 2016","Pure Cycles Western 3-Speed - Women","Pure Cycles William 3-Speed - 2016","Electra Townie Original 7D EQ - Women","Electra Cruiser 1 (24-Inch) - 2016","Electra Girl","Electra Girl","Electra Townie Original 21D - 2016","Electra Townie Original 7D - 2015/2016","Electra Townie Original 7D EQ - 2016","Surly Big Dummy Frameset - 2017","Surly Karate Monkey 27.5+ Frameset - 2017","Trek X-Caliber 8 - 2017","Surly Ice Cream Truck Frameset - 2017","Surly Wednesday - 2017","Trek Farley Alloy Frameset - 2017","Surly Wednesday Frameset - 2017","Trek Session DH 27.5 Carbon Frameset - 2017","Sun Bicycles Spider 3i - 2017","Surly Troll Frameset - 2017","Haro Flightline One ST - 2017","Haro Flightline Two 26 Plus - 2017","Trek Stache 5 - 2017","Trek Fuel EX 9.8 29 - 2017","Haro Shift R3 - 2017","Trek Fuel EX 5 27.5 Plus - 2017","Trek Fuel EX 9.8 27.5 Plus - 2017","Haro SR 1.1 - 2017","Haro SR 1.2 - 2017","Haro SR 1.3 - 2017","Trek Remedy 9.8 - 2017","Trek Emonda S 4 - 2017","Trek Domane SL 6 - 2017","Trek Silque SLR 7 Women","Trek Silque SLR 8 Women","Surly Steamroller - 2017","Surly Ogre Frameset - 2017","Trek Domane SL Disc Frameset - 2017","Trek Domane S 6 - 2017","Trek Domane SLR 6 Disc - 2017","Trek Emonda S 5 - 2017","Trek Madone 9.2 - 2017","Trek Domane S 5 Disc - 2017","Sun Bicycles ElectroLite - 2017","Trek Powerfly 8 FS Plus - 2017","Trek Boone 7 - 2017","Trek Boone Race Shop Limited - 2017","Electra Townie Original 7D - 2017","Sun Bicycles Lil Bolt Type-R - 2017","Sun Bicycles Revolutions 24 - 2017","Sun Bicycles Revolutions 24 - Girl","Sun Bicycles Cruz 3 - 2017","Sun Bicycles Cruz 7 - 2017","Electra Amsterdam Original 3i - 2015/2017","Sun Bicycles Atlas X-Type - 2017","Sun Bicycles Biscayne Tandem 7 - 2017","Sun Bicycles Brickell Tandem 7 - 2017","Electra Cruiser Lux 1 - 2017","Electra Cruiser Lux Fat Tire 1 Ladies - 2017","Electra Girl","Electra Glam Punk 3i Ladies","Sun Bicycles Biscayne Tandem CB - 2017","Sun Bicycles Boardwalk (24-inch Wheels) - 2017","Sun Bicycles Brickell Tandem CB - 2017","Electra Amsterdam Fashion 7i Ladies","Electra Amsterdam Original 3i Ladies","Trek Boy","Sun Bicycles Lil Kitt","Haro Downtown 16 - 2017","Trek Girl","Trek Precaliber 12 Boys - 2017","Trek Precaliber 12 Girls - 2017","Trek Precaliber 16 Boys - 2017","Trek Precaliber 16 Girls - 2017","Trek Precaliber 24 (21-Speed) - Girls - 2017","Haro Shredder 20 - 2017","Haro Shredder 20 Girls - 2017","Haro Shredder Pro 20 - 2017","Electra Girl","Electra Moto 3i (20-inch) - Boy","Electra Savannah 3i (20-inch) - Girl","Electra Straight 8 3i (20-inch) - Boy","Electra Sugar Skulls 1 (20-inch) - Girl","Electra Townie 3i EQ (20-inch) - Boys","Electra Townie 7D (20-inch) - Boys","Electra Townie Original 7D - 2017","Sun Bicycles Streamway 3 - 2017","Sun Bicycles Streamway - 2017","Sun Bicycles Streamway 7 - 2017","Sun Bicycles Cruz 3 - 2017","Sun Bicycles Cruz 7 - 2017","Sun Bicycles Cruz 3 - Women","Sun Bicycles Cruz 7 - Women","Sun Bicycles Drifter 7 - 2017","Sun Bicycles Drifter 7 - Women","Trek 820 - 2018","Trek Marlin 5 - 2018","Trek Marlin 6 - 2018","Trek Fuel EX 8 29 - 2018","Trek Marlin 7 - 2017/2018","Trek Ticket S Frame - 2018","Trek X-Caliber 8 - 2018","Trek Kids","Trek Fuel EX 7 29 - 2018","Surly Krampus Frameset - 2018","Surly Troll Frameset - 2018","Trek Farley Carbon Frameset - 2018","Surly Krampus - 2018","Trek Kids","Surly Big Fat Dummy Frameset - 2018","Surly Pack Rat Frameset - 2018","Surly ECR 27.5 - 2018","Trek X-Caliber 7 - 2018","Trek Stache Carbon Frameset - 2018","Heller Bloodhound Trail - 2018","Trek Procal AL Frameset - 2018","Trek Procaliber Frameset - 2018","Trek Remedy 27.5 C Frameset - 2018","Trek X-Caliber Frameset - 2018","Trek Procaliber 6 - 2018","Heller Shagamaw GX1 - 2018","Trek Fuel EX 5 Plus - 2018","Trek Remedy 7 27.5 - 2018","Trek Remedy 9.8 27.5 - 2018","Trek Stache 5 - 2018","Trek Fuel EX 8 29 XT - 2018","Trek Domane ALR 3 - 2018","Trek Domane ALR 4 Disc - 2018","Trek Domane ALR 5 Disc - 2018","Trek Domane SLR 6 - 2018","Trek Domane ALR 5 Gravel - 2018","Trek Domane SL 8 Disc - 2018","Trek Domane SLR 8 Disc - 2018","Trek Emonda SL 7 - 2018","Trek Domane ALR 4 Disc Women","Trek Domane SL 5 Disc Women","Trek Domane SL 7 Women","Trek Domane SLR 6 Disc Women","Trek Domane SLR 9 Disc - 2018","Trek Domane SL Frameset - 2018","Trek Domane SL Frameset Women","Trek CrossRip 1 - 2018","Trek Emonda ALR 6 - 2018","Trek Emonda SLR 6 - 2018","Surly ECR - 2018","Trek Emonda SL 6 Disc - 2018","Surly Pack Rat - 2018","Surly Straggler 650b - 2018","Trek 1120 - 2018","Trek Domane AL 2 Women","Surly ECR Frameset - 2018","Surly Straggler - 2018","Trek Emonda SLR 8 - 2018","Trek CrossRip 2 - 2018","Trek Domane SL 6 - 2018","Trek Domane ALR Disc Frameset - 2018","Trek Domane ALR Frameset - 2018","Trek Domane SLR Disc Frameset - 2018","Trek Domane SLR Frameset - 2018","Trek Madone 9 Frameset - 2018","Trek Domane SLR 6 Disc - 2018","Trek Domane AL 2 - 2018","Trek Domane AL 3 - 2018","Trek Domane AL 3 Women","Trek Domane SL 5 - 2018","Trek Domane SL 5 Disc - 2018","Trek Domane SL 5 Women","Trek Domane SL 6 Disc - 2018","Trek Conduit+ - 2018","Trek CrossRip+ - 2018","Trek Neko+ - 2018","Trek XM700+ Lowstep - 2018","Trek Lift+ Lowstep - 2018","Trek Dual Sport+ - 2018","Electra Loft Go! 8i - 2018","Electra Townie Go! 8i - 2017/2018","Trek Lift+ - 2018","Trek XM700+ - 2018","Electra Townie Go! 8i Ladies","Trek Verve+ - 2018","Trek Verve+ Lowstep - 2018","Electra Townie Commute Go! - 2018","Electra Townie Commute Go! Ladies","Trek Powerfly 5 - 2018","Trek Powerfly 5 FS - 2018","Trek Powerfly 5 Women","Trek Powerfly 7 FS - 2018","Trek Super Commuter+ 7 - 2018","Trek Super Commuter+ 8S - 2018","Trek Boone 5 Disc - 2018","Trek Boone 7 Disc - 2018","Trek Crockett 5 Disc - 2018","Trek Crockett 7 Disc - 2018","Surly Straggler - 2018","Surly Straggler 650b - 2018","Electra Townie Original 21D - 2018","Electra Cruiser 1 - 2016/2017/2018","Electra Tiger Shark 3i - 2018","Electra Queen of Hearts 3i - 2018","Electra Super Moto 8i - 2018","Electra Straight 8 3i - 2018","Electra Cruiser 7D - 2016/2017/2018","Electra Moto 3i - 2018","Electra Cruiser 1 Ladies","Electra Cruiser 7D Ladies","Electra Cruiser 1 Tall - 2016/2018","Electra Cruiser Lux 3i - 2018","Electra Cruiser Lux 7D - 2018","Electra Delivery 3i - 2016/2017/2018","Electra Townie Original 21D EQ - 2017/2018","Electra Cruiser 7D (24-Inch) Ladies","Electra Cruiser 7D Tall - 2016/2018","Electra Cruiser Lux 1 - 2016/2018","Electra Cruiser Lux 1 Ladies","Electra Cruiser Lux 3i Ladies","Electra Cruiser Lux 7D Ladies","Electra Cruiser Lux Fat Tire 7D - 2018","Electra Daydreamer 3i Ladies","Electra Koa 3i Ladies","Electra Morningstar 3i Ladies","Electra Relic 3i - 2018","Electra Townie Balloon 8D EQ - 2016/2017/2018","Electra Townie Balloon 8D EQ Ladies","Electra Townie Commute 27D Ladies - 2018","Electra Townie Commute 8D - 2018","Electra Townie Commute 8D Ladies","Electra Townie Original 21D EQ Ladies","Electra Townie Original 21D Ladies","Electra Townie Original 3i EQ - 2017/2018","Electra Townie Original 3i EQ Ladies","Electra Townie Original 7D EQ - 2018","Electra Townie Original 7D EQ Ladies","Electra White Water 3i - 2018","Electra Townie Go! 8i - 2017/2018","Electra Townie Commute Go! - 2018","Electra Townie Commute Go! Ladies","Electra Townie Go! 8i Ladies","Electra Townie Balloon 3i EQ - 2017/2018","Electra Townie Balloon 7i EQ Ladies","Electra Townie Commute 27D - 2018","Electra Amsterdam Fashion 3i Ladies","Electra Amsterdam Royal 8i - 2017/2018","Electra Amsterdam Royal 8i Ladies - 2018","Electra Townie Balloon 3i EQ Ladies","Electra Townie Balloon 7i EQ - 2018","Trek MT 201 - 2018","Strider Classic 12 Balance Bike - 2018","Strider Sport 16 - 2018","Strider Strider 20 Sport - 2018","Trek Superfly 20 - 2018","Trek Precaliber 12 Girl","Trek Kickster - 2018","Trek Precaliber 12 Boy","Trek Precaliber 16 Boy","Trek Precaliber 16 Girl","Trek Precaliber 20 6-speed Boy","Trek Precaliber 20 6-speed Girl","Trek Precaliber 20 Boy","Trek Precaliber 20 Girl","Trek Precaliber 24 (7-Speed) - Boys - 2018","Trek Precaliber 24 21-speed Boy","Trek Precaliber 24 21-speed Girl","Trek Precaliber 24 7-speed Girl","Trek Superfly 24 - 2017/2018","Electra Cruiser 7D (24-Inch) Ladies","Electra Cyclosaurus 1 (16-inch) - Boy","Electra Heartchya 1 (20-inch) - Girl","Electra Savannah 1 (20-inch) - Girl","Electra Soft Serve 1 (16-inch) - Girl","Electra Straight 8 1 (16-inch) - Boy","Electra Straight 8 1 (20-inch) - Boy","Electra Sweet Ride 1 (20-inch) - Girl","Electra Sweet Ride 3i (20-inch) - Girls","Electra Tiger Shark 1 (20-inch) - Boys","Electra Tiger Shark 3i (20-inch) - Boys","Electra Water Lily 1 (16-inch) - Girl","Electra Townie Original 21D - 2018","Electra Townie Balloon 3i EQ Ladies","Electra Townie Balloon 7i EQ - 2018","Electra Townie Original 1 - 2018","Electra Townie Go! 8i - 2017/2018","Electra Townie Original 21D EQ - 2017/2018","Electra Townie Balloon 3i EQ - 2017/2018","Electra Townie Balloon 7i EQ Ladies","Electra Townie Balloon 8D EQ - 2016/2017/2018","Electra Townie Balloon 8D EQ Ladies","Electra Townie Commute 27D - 2018","Electra Townie Commute 27D Ladies - 2018","Electra Townie Commute 8D - 2018","Electra Townie Commute 8D Ladies","Electra Townie Original 1 Ladies","Electra Townie Original 21D EQ Ladies","Electra Townie Original 21D Ladies","Trek Checkpoint ALR 4 Women","Trek Checkpoint ALR 5 - 2019","Trek Checkpoint ALR 5 Women","Trek Checkpoint SL 5 Women","Trek Checkpoint SL 6 - 2019","Trek Checkpoint ALR Frameset - 2019");
	
	private static final List<Double> productPrices = Arrays.asList(379.99, 749.99, 999.99, 2899.99, 1320.99, 469.99, 3999.99, 1799.99, 2999.99, 15.49, 1680.99, 549.99, 269.99, 269.99, 529.99, 599.99, 4.29, 4.49, 4.49, 599.99, 269.99, 269.99, 299.99, 549.99, 499.99, 599.99, 999.99, 2499.99, 999.99, 999.99, 1632.99, 469.99, 469.99, 469.99, 832.99, 832.99, 379.99, 549.99, 1499.99, 4999.99, 1469.99, 2299.99, 5299.99, 539.99, 869.99, 1409.99, 5299.99, 1499.99, 3499.99, 5999.99, 6499.99, 875.99, 749.99, 3199.99, 2699.99, 5499.99, 1999.99, 4999.99, 2599.99, 1559.99, 4999.99, 3499.99, 3499.99, 489.99, 346.99, 250.99, 250.99, 449.99, 416.99, 659.99, 416.99, 619.99, 749.99, 439.99, 599.99, 299.99, 799.99, 647.99, 402.99, 761.99, 1099.99, 659.99, 149.99, 109.99, 329.99, 149.99, 189.99, 189.99, 209.99, 209.99, 349.99, 209.99, 209.99, 249.99, 299.99, 349.99, 349.99, 489.99, 299.99, 489.99, 339.99, 489.99, 551.99, 481.99, 533.99, 449.99, 416.99, 449.99, 416.99, 470.99, 470.99, 379.99, 489.99, 579.99, 3199.99, 749.99, 1469.99, 999.99, 469.99, 2499.99, 2499.99, 2499.99, 999.99, 14.99, 469.99, 469.99, 469.99, 18.99, 919.99, 919.99, 25.99, 1499.99, 1499.99, 1499.99, 1499.99, 1799.99, 25.99, 2249.99, 2999.99, 4999.99, 1599.99, 3199.99, 1099.99, 1549.99, 1799.99, 4999.99, 1799.99, 5499.99, 7499.99, 4499.99, 1549.99, 2499.99, 4999.99, 5499.99, 11999.99, 6499.99, 6499.99, 959.99, 2299.99, 4499.99, 18.99, 2999.99, 13.49, 15.49, 2499.99, 749.99, 749.99, 15.49, 6499.99, 1299.99, 3199.99, 3199.99, 3199.99, 3199.99, 3199.99, 3199.99, 5499.99, 749.99, 919.99, 919.99, 2199.99, 2499.99, 2199.99, 3499.99, 2799.99, 4499.99, 2799.99, 3499.99, 2799.99, 2799.99, 2799.99, 2599.99, 2799.99, 3499.99, 2599.99, 2299.99, 2299.99, 2999.99, 2999.99, 3499.99, 4499.99, 3499.99, 4999.99, 3599.99, 4999.99, 3299.99, 3999.99, 1799.99, 2999.99, 15.49, 15.49, 559.99, 269.99, 899.99, 749.99, 899.99, 909.99, 319.99, 639.99, 269.99, 319.99, 269.99, 529.99, 479.99, 959.99, 679.99, 319.99, 319.99, 429.99, 429.99, 529.99, 479.99, 639.99, 899.99, 899.99, 749.99, 849.99, 749.99, 749.99, 899.99, 749.99, 699.99, 679.99, 559.99, 659.99, 639.99, 599.99, 599.99, 749.99, 2599.99, 2999.99, 2999.99, 2599.99, 749.99, 899.99, 899.99, 899.99, 125.99, 1199.99, 799.99, 899.99, 249.99, 89.99, 249.99, 289.99, 399.99, 199.99, 159.99, 199.99, 209.99, 209.99, 289.99, 289.99, 229.99, 229.99, 319.99, 369.99, 369.99, 319.99, 489.99, 319.99, 279.99, 319.99, 319.99, 279.99, 279.99, 389.99, 319.99, 369.99, 319.99, 369.99, 279.99, 559.99, 799.99, 899.99, 449.99, 2599.99, 679.99, 749.99, 899.99, 749.99, 749.99, 899.99, 899.99, 749.99, 699.99, 449.99, 679.99, 559.99, 1699.99, 1999.99, 1999.99, 2799.99, 3799.99, 3199.99);

	private static final List<String> productVendors = Arrays.asList("Nike","Amazon","Addidas","Lol","Fubu","Ebay");
	
	public static List<ObjectNode> texasAddresses = null;
	
	public static List<ObjectNode> nonTexasAddresses = null;
	
	public static final String password = "Test1234!";
	
	// can add as payment method but can't charge
	public static String badCard = "4000000000000341";
	
	private ConstantUtils() {
	}
	
	
	public static String getRandomFirstname() {
		return firstnames.get(RandomGeneratorUtils.getIntegerWithin(0, firstnames.size()-1));
	}
	
	public static String getRandomLastname() {
		return lastnames.get(RandomGeneratorUtils.getIntegerWithin(0, lastnames.size()-1));
	}
	
	public static Employee getEmployee() {
		Employee employee = new Employee();
		employee.setFirstName(getRandomFirstname());
		employee.setLastName(getRandomLastname());
		employee.setAge(RandomGeneratorUtils.getIntegerWithin(16, 61));
		String email = employee.getFirstName()+employee.getLastName()+"@gmail.com";
		employee.setEmail(email.toLowerCase());
		employee.setTitle(employeeTitles.get(RandomGeneratorUtils.getIntegerWithin(0, employeeTitles.size()-1)));
		employee.setOffice(getOffice());

		return employee;
	}
	
	public static Customer getCustomer() {
		Customer customer = new Customer();
		customer.setAddress(getAddress());
		customer.setCreditLimit(RandomGeneratorUtils.getDoubleWithin(250, 300000));
		customer.setFirstName(getRandomFirstname());
		customer.setLastName(getRandomLastname());
		customer.setPhone("310"+RandomGeneratorUtils.getIntegerWithin(1000000, 9999999));
		
		return customer;
	}
	
	public static Product getProduct() {
		int productIndex = RandomGeneratorUtils.getIntegerWithin(0, productPrices.size());
		return getProduct(productIndex);
	}
	
	public static Order getOrder() {
		Set<Product> products = new HashSet<>();
		
		for(int i=0;i<EntityLimit.ORDER;i++) {
			products.add(new Product(RandomGeneratorUtils.getLongWithin(0, EntityLimit.PRODUCT)));
		}
		
		return getOrder(products);
	}
	
	public static Order getOrder(Set<Product> products) {
		Order order = new Order();
		List<String> orderStatuses = Arrays.asList("Packaged","Shipped","Delivered");
		order.setCreatedAt(DateUtils.addDays(new Date(), -RandomGeneratorUtils.getIntegerWithin(0, 20)));
		order.setShippedAt(DateUtils.addDays(order.getCreatedAt(), RandomGeneratorUtils.getIntegerWithin(0, 5)));
		order.setStatus(orderStatuses.get(RandomGeneratorUtils.getIntegerWithin(0, orderStatuses.size())));
		
		OrderDetail orderDetail = new OrderDetail();
		
		
		if(products!=null && products.size()>0) {
			orderDetail.setProducts(products);
			double totalPrice = 0.0;
			int count = 0;
			for(Product prod: orderDetail.getProducts()) {
				totalPrice += prod.getPrice();
				count++;
			}
			orderDetail.setTotalPrice(totalPrice);
			orderDetail.setTotalProductCount(count);
		}
		
		order.setOrderDetail(orderDetail);
		orderDetail.setOrder(order);
		return order;
	}
	
	public static Product getProduct(int productIndex) {
		Product product = new Product();
		product.setName(productNames.get(productIndex));
		product.setPrice(productPrices.get(productIndex));
		product.setVendor(productVendors.get(RandomGeneratorUtils.getIntegerWithin(0, productVendors.size())));
		product.setDescription("very cool product");
		return product;
	}
	
	public static Office getOffice() {
		Office office = new Office();
		office.setName(employeeOffice.get(RandomGeneratorUtils.getIntegerWithin(0, employeeOffice.size()-1)));
		Address address =  getAddress();
		office.setAddress(address);
		
		return office;
	}
	
	public static Address getAddress() {
		ObjectNode add = getRandomTexasAddress();
		Address address = ObjectUtils.fromJsonString(ObjectUtils.toJson(add), Address.class);
		return address;
	}
	
	public static String getSSN() {
		String ssn = RandomGeneratorUtils.getIntegerWithin(100, 1000) + "-"
				+ RandomGeneratorUtils.getIntegerWithin(10, 100) + "-"
				+ RandomGeneratorUtils.getIntegerWithin(1000, 10000);
		return ssn;
	}
	
	public static int getDeductible() {
		List<Integer> ductibleOptions = Arrays.asList(0, 200, 300, 400, 500, 600, 700, 800, 900, 1000);

		return ductibleOptions.get(RandomGeneratorUtils.getIntegerWithin(0, ductibleOptions.size()));
	}
	
	public static int getMaxAllowance() {
		List<Integer> maxAllownceOptions = Arrays.asList(5000, 15000, 25000, 35000, 45000, 2000000);

		return maxAllownceOptions.get(RandomGeneratorUtils.getIntegerWithin(0, maxAllownceOptions.size()));

	}
	
	public static double getSidecarPercentage() {
		List<Double> sidecarPercentageOptions = Arrays.asList(0.5, 0.55, 0.6, 0.65, 0.7, 0.75, 0.8);

		return sidecarPercentageOptions
				.get(RandomGeneratorUtils.getIntegerWithin(0, sidecarPercentageOptions.size()));
		
	}
	
	public static void generateRandomNonTexasAddress() {
		nonTexasAddresses = new ArrayList<>();
		ObjectNode address = ObjectUtils.getObjectNode();
		address.put("street", "205 Glen Oaks Dr");
		address.put("city", "Bakersfield");
		address.put("state", "CA");
		address.put("zip", "93309");
		address.put("lon", -119.064368);
		address.put("lat", 35.352681);
		
		nonTexasAddresses.add(address);
		
		address = ObjectUtils.getObjectNode();
		address.put("street", "2216 E South Redwood Dr");
		address.put("city", "Anaheim");
		address.put("state", "CA");
		address.put("zip", "92806");
		address.put("lon", -117.885865);
		address.put("lat", 33.844734);
		
		nonTexasAddresses.add(address);
		
		address = ObjectUtils.getObjectNode();
		address.put("street", "4859 Premiere Ave");
		address.put("city", "Long Beach");
		address.put("state", "CA");
		address.put("zip", "90808");
		address.put("lon",  -118.130971);
		address.put("lat",33.846600);
		
		nonTexasAddresses.add(address);
		
		address = ObjectUtils.getObjectNode();
		address.put("street", "901 Inlet Dr");
		address.put("city", "Oxnard");
		address.put("state", "CA");
		address.put("zip", "93030");
		address.put("lon", -119.190989);
		address.put("lat",34.192374);
		
		nonTexasAddresses.add(address);
		
		address = ObjectUtils.getObjectNode();
		address.put("street", "3635 W 225th St");
		address.put("city", "Torrance");
		address.put("state", "CA");
		address.put("zip", "90505");
		address.put("lon", -118.349399);
		address.put("lat", 33.823964);
		
		nonTexasAddresses.add(address);
		
		address = ObjectUtils.getObjectNode();
		address.put("street", "1601 Cloverfield Blvd");
		address.put("city", "Santa Monica");
		address.put("state", "CA");
		address.put("zip", "90404");
		address.put("lon", -118.470195);
		address.put("lat", 34.010624);
		
		nonTexasAddresses.add(address);
		
		address = ObjectUtils.getObjectNode();
		address.put("street", "1416 Marine Ave");
		address.put("city", "Manhattan Beach");
		address.put("state", "CA");
		address.put("zip", "90266");
		address.put("lon", -118.389389);
		address.put("lat", 33.894411);
		
		nonTexasAddresses.add(address);
		
	}
	
	public static ObjectNode getRandomNonTexasAddress(String street, String zip) {
		generateRandomNonTexasAddress();
		ObjectNode chosenAddress = null;
		while(true) {
			chosenAddress = nonTexasAddresses.get(RandomGeneratorUtils.getIntegerWithin(0, nonTexasAddresses.size()-1));
			if(chosenAddress.get("street").asText().equals(street)==false && chosenAddress.get("zip").asText().equals(zip)==false) {
				break;
			}
		}
		return chosenAddress;
	}
	
	public static ObjectNode getRandomNonTexasAddress() {
		generateRandomNonTexasAddress();
		return nonTexasAddresses.get(RandomGeneratorUtils.getIntegerWithin(0, nonTexasAddresses.size()-1));
	}
	
	public static void generateRandomTexasAddress() {
		texasAddresses = new ArrayList<>();
		ObjectNode address = ObjectUtils.getObjectNode();
		address.put("street", "500 Powell Cir");
		address.put("city", "Austin");
		address.put("state", "TX");
		address.put("zip", "78704");
		address.put("lon", -97.762114);
		address.put("lat", 30.234650);
		
		texasAddresses.add(address);
		
		address = ObjectUtils.getObjectNode();
		address.put("street", "2000-2010 S 3rd St");
		address.put("city", "Austin");
		address.put("state", "TX");
		address.put("zip", "78704");
		address.put("lon", -97.760261);
		address.put("lat", 30.246034);
		
		texasAddresses.add(address);
		
		address = ObjectUtils.getObjectNode();
		address.put("street", "2603 Baxter Dr");
		address.put("city", "Austin");
		address.put("state", "TX");
		address.put("zip", "78745");
		address.put("lon", -97.810232);
		address.put("lat", 30.213646);
		
		texasAddresses.add(address);
		
		address = ObjectUtils.getObjectNode();
		address.put("street", "507 Terrell Rd");
		address.put("city", "San Antonio");
		address.put("state", "TX");
		address.put("zip", "78209");
		address.put("lon", -98.449531);
		address.put("lat", 29.471719);
		
		texasAddresses.add(address);
		
		address = ObjectUtils.getObjectNode();
		address.put("street", "13420 Hempstead Rd");
		address.put("city", "Houston");
		address.put("state", "TX");
		address.put("zip", "77040");
		address.put("lon", -95.516854);
		address.put("lat", 29.845941);
		
		texasAddresses.add(address);
		
		address = ObjectUtils.getObjectNode();
		address.put("street", "146 Goodhue Ave");
		address.put("city", "San Antonio");
		address.put("state", "TX");
		address.put("zip", "78218");
		address.put("lon", -98.411778);
		address.put("lat", 29.498875);
		
		texasAddresses.add(address);
		
		address = ObjectUtils.getObjectNode();
		address.put("street", "8202 Ivan Reid Dr");
		address.put("city", "Houston");
		address.put("state", "TX");
		address.put("zip", "77040");
		address.put("lon", -95.528506);
		address.put("lat",29.891536);
		
		texasAddresses.add(address);
	}
	
	public static ObjectNode getRandomTexasAddress() {
		generateRandomTexasAddress();
		return texasAddresses.get(RandomGeneratorUtils.getIntegerWithin(0, texasAddresses.size()-1));
	}
	
	public static ObjectNode getRandomTexasAddress(String street, String zip) {
		generateRandomTexasAddress();
		ObjectNode chosenAddress = null;
		while(true) {
			chosenAddress = texasAddresses.get(RandomGeneratorUtils.getIntegerWithin(0, texasAddresses.size()-1));
			if(chosenAddress.get("street").asText().equals(street)==false && chosenAddress.get("zip").asText().equals(zip)==false) {
				break;
			}
		}
		return chosenAddress;
	}
}
