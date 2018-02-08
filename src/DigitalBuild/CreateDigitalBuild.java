package DigitalBuild;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Helper.OasisBrowser;

public class CreateDigitalBuild extends OasisBrowser 
{
	@Test 
	public static void Build() throws InterruptedException, IOException  
	{
		bot.mouseMove(210, 120);
		bot.mouseClick("left", 210, 120);
		Thread.sleep(500);
		bot.mouseMove(210, 205);
		Thread.sleep(500);
		bot.mouseMove(410, 205);
		Thread.sleep(500);		
		bot.mouseClick("left", 410, 205);
		Thread.sleep(1500);	
		
		Path BuildDataFile = Paths.get("C://DB//DigitalBuild.csv");
		//List<String> BuildInfo= new ArrayList<>();
		BufferedReader br = Files.newBufferedReader(BuildDataFile,StandardCharsets.US_ASCII);
		
		String line;
		while ((line = br.readLine()) != null) 
		{
		    String[] build = line.split(",");		    
		    submitAdshelLiveFSU(build); 
		}	
	
		}	
		
	public static void submitAdshelLiveFSU(String[] line) throws InterruptedException
	{
		//Enter Data
				bot.mouseMove(425, 185);
				bot.mouseClick("left", 425, 185);				
				Thread.sleep(1000);
				bot.mouseMove(850, 245);
				bot.mouseClick("left", 850, 245);
				bot.mouseClick("left", 850, 245);
				Thread.sleep(500);
				
				bot.mouseMove(650, 185);
				bot.mouseClick("left", 650, 185);
				bot.send(line[0]);
				Thread.sleep(500);
				
				bot.mouseMove(300, 210);
				bot.mouseClick("left", 300, 210);
				bot.send(line[1]);
				Thread.sleep(500);
				
				bot.mouseMove(545, 205);
				bot.mouseClick("left", 545, 205);
				bot.send("Roadside");
				Thread.sleep(500);
				
				bot.mouseMove(735, 205);
				bot.mouseClick("left", 735, 205);
				Thread.sleep(500);
				bot.mouseClick("left", 735, 250);
				Thread.sleep(500);
				
				bot.mouseMove(310, 235);
				bot.mouseClick("left", 310, 235);
				bot.send(line[2]);
				Thread.sleep(500);
				
				bot.mouseMove(695, 235);
				bot.mouseClick("left", 695, 235);
				bot.send(line[3]);
				Thread.sleep(500);
				
				bot.mouseMove(825, 235);
				bot.mouseClick("left", 825, 235);
				Thread.sleep(500);
				bot.mouseClick("left", 850, 150);
				Thread.sleep(500);
				
				bot.mouseMove(310,275);
				bot.mouseClick("left", 310,275);
				bot.send(line[4]);
				Thread.sleep(500);
				
				bot.mouseMove(310,295);
				bot.mouseClick("left", 310,295);
				bot.send(line[5]);
				Thread.sleep(500);
				
				bot.mouseMove(725,295);
				bot.mouseClick("left", 725,295);
				bot.send(line[6]);
				Thread.sleep(500);
				
				bot.mouseMove(610,405);
				bot.mouseClick("left", 610,405);				
				Thread.sleep(2000);
				
				bot.mouseMove(950,650);
				bot.mouseClick("left", 950,650);				
				Thread.sleep(4000);				
					
				Assert.assertTrue(bot.winGetTitle("Information").contains("Information"));
				
				bot.mouseMove(960,550);
				bot.mouseClick("left", 960,550);				
				Thread.sleep(4000);
				
				Reporter.log("Digital Build Created for"+"---"+line[0]+"---"+line[1]+"---"+line[2]+"---"+line[3]+"---"+line[4]+"---"+line[5]+"---"+line[6]);				
				//Assert.assertTrue(bot.winGetTitle("[active]").contains("Information")); 
				
	}
	

}
