package com.lovemesomecoding.springdatadatagenerator;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.springframework.util.ResourceUtils;

public class FileReader {

	@Test
	public void readProductFile() {
		
		List<String> productNames = Arrays.asList("Trek 820 - 2016","Ritchey Timberwolf Frameset - 2016","Surly Wednesday Frameset - 2016","Trek Fuel EX 8 29 - 2016","Heller Shagamaw Frame - 2016","Surly Ice Cream Truck Frameset - 2016","Trek Slash 8 27.5 - 2016","Trek Remedy 29 Carbon Frameset - 2016","Trek Conduit+ - 2016","Surly Straggler - 2016","Surly Straggler 650b - 2016","Electra Townie Original 21D - 2016","Electra Cruiser 1 (24-Inch) - 2016","Electra Girl","Electra Moto 1 - 2016","Electra Townie Original 7D EQ - 2016","Pure Cycles Vine 8-Speed - 2016","Pure Cycles Western 3-Speed - Women","Pure Cycles William 3-Speed - 2016","Electra Townie Original 7D EQ - Women","Electra Cruiser 1 (24-Inch) - 2016","Electra Girl","Electra Girl","Electra Townie Original 21D - 2016","Electra Townie Original 7D - 2015/2016","Electra Townie Original 7D EQ - 2016","Surly Big Dummy Frameset - 2017","Surly Karate Monkey 27.5+ Frameset - 2017","Trek X-Caliber 8 - 2017","Surly Ice Cream Truck Frameset - 2017","Surly Wednesday - 2017","Trek Farley Alloy Frameset - 2017","Surly Wednesday Frameset - 2017","Trek Session DH 27.5 Carbon Frameset - 2017","Sun Bicycles Spider 3i - 2017","Surly Troll Frameset - 2017","Haro Flightline One ST - 2017","Haro Flightline Two 26 Plus - 2017","Trek Stache 5 - 2017","Trek Fuel EX 9.8 29 - 2017","Haro Shift R3 - 2017","Trek Fuel EX 5 27.5 Plus - 2017","Trek Fuel EX 9.8 27.5 Plus - 2017","Haro SR 1.1 - 2017","Haro SR 1.2 - 2017","Haro SR 1.3 - 2017","Trek Remedy 9.8 - 2017","Trek Emonda S 4 - 2017","Trek Domane SL 6 - 2017","Trek Silque SLR 7 Women","Trek Silque SLR 8 Women","Surly Steamroller - 2017","Surly Ogre Frameset - 2017","Trek Domane SL Disc Frameset - 2017","Trek Domane S 6 - 2017","Trek Domane SLR 6 Disc - 2017","Trek Emonda S 5 - 2017","Trek Madone 9.2 - 2017","Trek Domane S 5 Disc - 2017","Sun Bicycles ElectroLite - 2017","Trek Powerfly 8 FS Plus - 2017","Trek Boone 7 - 2017","Trek Boone Race Shop Limited - 2017","Electra Townie Original 7D - 2017","Sun Bicycles Lil Bolt Type-R - 2017","Sun Bicycles Revolutions 24 - 2017","Sun Bicycles Revolutions 24 - Girl","Sun Bicycles Cruz 3 - 2017","Sun Bicycles Cruz 7 - 2017","Electra Amsterdam Original 3i - 2015/2017","Sun Bicycles Atlas X-Type - 2017","Sun Bicycles Biscayne Tandem 7 - 2017","Sun Bicycles Brickell Tandem 7 - 2017","Electra Cruiser Lux 1 - 2017","Electra Cruiser Lux Fat Tire 1 Ladies - 2017","Electra Girl","Electra Glam Punk 3i Ladies","Sun Bicycles Biscayne Tandem CB - 2017","Sun Bicycles Boardwalk (24-inch Wheels) - 2017","Sun Bicycles Brickell Tandem CB - 2017","Electra Amsterdam Fashion 7i Ladies","Electra Amsterdam Original 3i Ladies","Trek Boy","Sun Bicycles Lil Kitt","Haro Downtown 16 - 2017","Trek Girl","Trek Precaliber 12 Boys - 2017","Trek Precaliber 12 Girls - 2017","Trek Precaliber 16 Boys - 2017","Trek Precaliber 16 Girls - 2017","Trek Precaliber 24 (21-Speed) - Girls - 2017","Haro Shredder 20 - 2017","Haro Shredder 20 Girls - 2017","Haro Shredder Pro 20 - 2017","Electra Girl","Electra Moto 3i (20-inch) - Boy","Electra Savannah 3i (20-inch) - Girl","Electra Straight 8 3i (20-inch) - Boy","Electra Sugar Skulls 1 (20-inch) - Girl","Electra Townie 3i EQ (20-inch) - Boys","Electra Townie 7D (20-inch) - Boys","Electra Townie Original 7D - 2017","Sun Bicycles Streamway 3 - 2017","Sun Bicycles Streamway - 2017","Sun Bicycles Streamway 7 - 2017","Sun Bicycles Cruz 3 - 2017","Sun Bicycles Cruz 7 - 2017","Sun Bicycles Cruz 3 - Women","Sun Bicycles Cruz 7 - Women","Sun Bicycles Drifter 7 - 2017","Sun Bicycles Drifter 7 - Women","Trek 820 - 2018","Trek Marlin 5 - 2018","Trek Marlin 6 - 2018","Trek Fuel EX 8 29 - 2018","Trek Marlin 7 - 2017/2018","Trek Ticket S Frame - 2018","Trek X-Caliber 8 - 2018","Trek Kids","Trek Fuel EX 7 29 - 2018","Surly Krampus Frameset - 2018","Surly Troll Frameset - 2018","Trek Farley Carbon Frameset - 2018","Surly Krampus - 2018","Trek Kids","Surly Big Fat Dummy Frameset - 2018","Surly Pack Rat Frameset - 2018","Surly ECR 27.5 - 2018","Trek X-Caliber 7 - 2018","Trek Stache Carbon Frameset - 2018","Heller Bloodhound Trail - 2018","Trek Procal AL Frameset - 2018","Trek Procaliber Frameset - 2018","Trek Remedy 27.5 C Frameset - 2018","Trek X-Caliber Frameset - 2018","Trek Procaliber 6 - 2018","Heller Shagamaw GX1 - 2018","Trek Fuel EX 5 Plus - 2018","Trek Remedy 7 27.5 - 2018","Trek Remedy 9.8 27.5 - 2018","Trek Stache 5 - 2018","Trek Fuel EX 8 29 XT - 2018","Trek Domane ALR 3 - 2018","Trek Domane ALR 4 Disc - 2018","Trek Domane ALR 5 Disc - 2018","Trek Domane SLR 6 - 2018","Trek Domane ALR 5 Gravel - 2018","Trek Domane SL 8 Disc - 2018","Trek Domane SLR 8 Disc - 2018","Trek Emonda SL 7 - 2018","Trek Domane ALR 4 Disc Women","Trek Domane SL 5 Disc Women","Trek Domane SL 7 Women","Trek Domane SLR 6 Disc Women","Trek Domane SLR 9 Disc - 2018","Trek Domane SL Frameset - 2018","Trek Domane SL Frameset Women","Trek CrossRip 1 - 2018","Trek Emonda ALR 6 - 2018","Trek Emonda SLR 6 - 2018","Surly ECR - 2018","Trek Emonda SL 6 Disc - 2018","Surly Pack Rat - 2018","Surly Straggler 650b - 2018","Trek 1120 - 2018","Trek Domane AL 2 Women","Surly ECR Frameset - 2018","Surly Straggler - 2018","Trek Emonda SLR 8 - 2018","Trek CrossRip 2 - 2018","Trek Domane SL 6 - 2018","Trek Domane ALR Disc Frameset - 2018","Trek Domane ALR Frameset - 2018","Trek Domane SLR Disc Frameset - 2018","Trek Domane SLR Frameset - 2018","Trek Madone 9 Frameset - 2018","Trek Domane SLR 6 Disc - 2018","Trek Domane AL 2 - 2018","Trek Domane AL 3 - 2018","Trek Domane AL 3 Women","Trek Domane SL 5 - 2018","Trek Domane SL 5 Disc - 2018","Trek Domane SL 5 Women","Trek Domane SL 6 Disc - 2018","Trek Conduit+ - 2018","Trek CrossRip+ - 2018","Trek Neko+ - 2018","Trek XM700+ Lowstep - 2018","Trek Lift+ Lowstep - 2018","Trek Dual Sport+ - 2018","Electra Loft Go! 8i - 2018","Electra Townie Go! 8i - 2017/2018","Trek Lift+ - 2018","Trek XM700+ - 2018","Electra Townie Go! 8i Ladies","Trek Verve+ - 2018","Trek Verve+ Lowstep - 2018","Electra Townie Commute Go! - 2018","Electra Townie Commute Go! Ladies","Trek Powerfly 5 - 2018","Trek Powerfly 5 FS - 2018","Trek Powerfly 5 Women","Trek Powerfly 7 FS - 2018","Trek Super Commuter+ 7 - 2018","Trek Super Commuter+ 8S - 2018","Trek Boone 5 Disc - 2018","Trek Boone 7 Disc - 2018","Trek Crockett 5 Disc - 2018","Trek Crockett 7 Disc - 2018","Surly Straggler - 2018","Surly Straggler 650b - 2018","Electra Townie Original 21D - 2018","Electra Cruiser 1 - 2016/2017/2018","Electra Tiger Shark 3i - 2018","Electra Queen of Hearts 3i - 2018","Electra Super Moto 8i - 2018","Electra Straight 8 3i - 2018","Electra Cruiser 7D - 2016/2017/2018","Electra Moto 3i - 2018","Electra Cruiser 1 Ladies","Electra Cruiser 7D Ladies","Electra Cruiser 1 Tall - 2016/2018","Electra Cruiser Lux 3i - 2018","Electra Cruiser Lux 7D - 2018","Electra Delivery 3i - 2016/2017/2018","Electra Townie Original 21D EQ - 2017/2018","Electra Cruiser 7D (24-Inch) Ladies","Electra Cruiser 7D Tall - 2016/2018","Electra Cruiser Lux 1 - 2016/2018","Electra Cruiser Lux 1 Ladies","Electra Cruiser Lux 3i Ladies","Electra Cruiser Lux 7D Ladies","Electra Cruiser Lux Fat Tire 7D - 2018","Electra Daydreamer 3i Ladies","Electra Koa 3i Ladies","Electra Morningstar 3i Ladies","Electra Relic 3i - 2018","Electra Townie Balloon 8D EQ - 2016/2017/2018","Electra Townie Balloon 8D EQ Ladies","Electra Townie Commute 27D Ladies - 2018","Electra Townie Commute 8D - 2018","Electra Townie Commute 8D Ladies","Electra Townie Original 21D EQ Ladies","Electra Townie Original 21D Ladies","Electra Townie Original 3i EQ - 2017/2018","Electra Townie Original 3i EQ Ladies","Electra Townie Original 7D EQ - 2018","Electra Townie Original 7D EQ Ladies","Electra White Water 3i - 2018","Electra Townie Go! 8i - 2017/2018","Electra Townie Commute Go! - 2018","Electra Townie Commute Go! Ladies","Electra Townie Go! 8i Ladies","Electra Townie Balloon 3i EQ - 2017/2018","Electra Townie Balloon 7i EQ Ladies","Electra Townie Commute 27D - 2018","Electra Amsterdam Fashion 3i Ladies","Electra Amsterdam Royal 8i - 2017/2018","Electra Amsterdam Royal 8i Ladies - 2018","Electra Townie Balloon 3i EQ Ladies","Electra Townie Balloon 7i EQ - 2018","Trek MT 201 - 2018","Strider Classic 12 Balance Bike - 2018","Strider Sport 16 - 2018","Strider Strider 20 Sport - 2018","Trek Superfly 20 - 2018","Trek Precaliber 12 Girl","Trek Kickster - 2018","Trek Precaliber 12 Boy","Trek Precaliber 16 Boy","Trek Precaliber 16 Girl","Trek Precaliber 20 6-speed Boy","Trek Precaliber 20 6-speed Girl","Trek Precaliber 20 Boy","Trek Precaliber 20 Girl","Trek Precaliber 24 (7-Speed) - Boys - 2018","Trek Precaliber 24 21-speed Boy","Trek Precaliber 24 21-speed Girl","Trek Precaliber 24 7-speed Girl","Trek Superfly 24 - 2017/2018","Electra Cruiser 7D (24-Inch) Ladies","Electra Cyclosaurus 1 (16-inch) - Boy","Electra Heartchya 1 (20-inch) - Girl","Electra Savannah 1 (20-inch) - Girl","Electra Soft Serve 1 (16-inch) - Girl","Electra Straight 8 1 (16-inch) - Boy","Electra Straight 8 1 (20-inch) - Boy","Electra Sweet Ride 1 (20-inch) - Girl","Electra Sweet Ride 3i (20-inch) - Girls","Electra Tiger Shark 1 (20-inch) - Boys","Electra Tiger Shark 3i (20-inch) - Boys","Electra Water Lily 1 (16-inch) - Girl","Electra Townie Original 21D - 2018","Electra Townie Balloon 3i EQ Ladies","Electra Townie Balloon 7i EQ - 2018","Electra Townie Original 1 - 2018","Electra Townie Go! 8i - 2017/2018","Electra Townie Original 21D EQ - 2017/2018","Electra Townie Balloon 3i EQ - 2017/2018","Electra Townie Balloon 7i EQ Ladies","Electra Townie Balloon 8D EQ - 2016/2017/2018","Electra Townie Balloon 8D EQ Ladies","Electra Townie Commute 27D - 2018","Electra Townie Commute 27D Ladies - 2018","Electra Townie Commute 8D - 2018","Electra Townie Commute 8D Ladies","Electra Townie Original 1 Ladies","Electra Townie Original 21D EQ Ladies","Electra Townie Original 21D Ladies","Trek Checkpoint ALR 4 Women","Trek Checkpoint ALR 5 - 2019","Trek Checkpoint ALR 5 Women","Trek Checkpoint SL 5 Women","Trek Checkpoint SL 6 - 2019","Trek Checkpoint ALR Frameset - 2019");
		int prudsixe = productNames.size();
		
		Scanner scanner = null;
		// file in resources folder
		List<Double> prices = new ArrayList<>();
		
		List<String> names = new ArrayList<>();
		
		try{
			scanner = new Scanner(new File("products.txt"));
			
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String name = line.split("'")[1];
				if(name.contains("\"")||name.contains("[")||name.contains("]")) {
					continue;
				}else {
					//System.out.print("\""+name+"\",");
					names.add(name);
				}
				
				double price = Double.parseDouble(line.split(",")[10].replaceAll("[^0-9]", ""))/100;
				
				//System.out.println("price: "+price/100);
				prices.add(price);
				
				if(prudsixe==prices.size()) {
					break;
				}
			}
			
		} catch (IOException e) {
			System.err.println("IOException, msg: {}"+e.getMessage());
		}finally {
			if(scanner!=null) {
				scanner.close();
			}
		}
		System.out.println(names.toString());
		System.out.println("\n\n\n");
		System.out.println(prices.toString());
	}

}
