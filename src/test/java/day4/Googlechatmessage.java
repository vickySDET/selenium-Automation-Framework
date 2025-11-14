package day4;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public abstract class Googlechatmessage {

	@Test
	public static void main(String[] args) {

		WebDriver driver = null;
		
		try {
			
		WebDriverManager.chromedriver().setup();
		
	    driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		String title = driver.getTitle();
		
		
		System.out.println("Title of the page:"+  title);
		
		  sendMessageToGoogleChat(" Selenium test passed successfully done by vicky! Page Title: " + title);
		
		}
		
		catch (Exception e) {
            e.printStackTrace();
            sendMessageToGoogleChat("Selenium test failed: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
		
	}

}
	
	 public static void sendMessageToGoogleChat(String messageText) {
	        try {
	            
	            String webhookUrl = "https://chat.googleapis.com/v1/spaces/AAAAwJRRBJI/messages?key=AIzaSyDdI0hCZtE6vySjMm-WEfRq3CPzqKqqsHI&token=cDZoNyo3l8l363YhlwY3_N0ZITZDABszO7nYgHdSEGM";

	            URL url = new URL(webhookUrl);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("POST");
	            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	            conn.setDoOutput(true);

	            String jsonPayload = String.format("{\"text\": \"%s\"}", messageText);

	            try (OutputStream os = conn.getOutputStream()) {
	                byte[] input = jsonPayload.getBytes(StandardCharsets.UTF_8);
	                os.write(input, 0, input.length);
	            }

	            int responseCode = conn.getResponseCode();
	            System.out.println("Google Chat Response Code: " + responseCode);

	        } catch (Exception e) {
	            System.out.println("Error sending message to Google Chat: " + e.getMessage());
	        }
	    }
	}
