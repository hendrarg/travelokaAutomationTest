package Appium.Traveloka;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
 class carRent {

    public AndroidDriver driver;

    @BeforeClass
    public void ConfigureAppium () throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "14");
        caps.setCapability("deviceName", "HendraPhone");
        caps.setCapability("appPackage", "com.traveloka.android");
        caps.setCapability("appWaitActivity", "*");
        caps.setCapability("app", System.getProperty("user.dir")+"/apps/traveloka-5-0-0.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        Thread.sleep(5000);
        //Open App
    }
    @Test
    public void test() throws InterruptedException {
        driver.findElement(AppiumBy.id("com.traveloka.android:id/on_board_button_continue")).click();
        driver.findElement(AppiumBy.id("com.traveloka.android:id/button_skip")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.traveloka.android:id/imageClose"))).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.id("com.traveloka.android:id/button_tooltip")).click();
        //Select Cars Product
        driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.traveloka.android:id/container\"])[10]")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.id("com.traveloka.android:id/button_tooltip")).click();
        Thread.sleep(3000);
        //Select tab Without Driver
        driver.findElement(AppiumBy.xpath("(//android.view.View[@resource-id=\"com.traveloka.android.rental_impl:id/background\"])[2]")).click();
        //Select Pick-up Location (e.g.: Jakarta)
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.traveloka.android:id/edit_text_field\"]")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.traveloka.android.rental_impl:id/text_view_sub_type\"])[6]")).click();  
        Thread.sleep(3000);
        //Select Pick-up Date & Time (e.g.: today+2d 09:00)
        //Select Drop-off Date & Time (e.g.: today+5d 11:00)
        LocalDate today = LocalDate.now();
        LocalDate pickUpDate = today.plusDays(2);
        LocalDate dropOffDate = today.plusDays(5);
        LocalTime pickUpTime = LocalTime.of(9, 0); // 9:00 AM
        LocalTime dropOffTime = LocalTime.of(11, 0); // 11:00 AM
        // Combine dates with respective times
        LocalDateTime pickUpDateTime = LocalDateTime.of(pickUpDate, pickUpTime);
        LocalDateTime dropOffDateTime = LocalDateTime.of(dropOffDate, dropOffTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedPickUpDateTime = pickUpDateTime.format(formatter);
        String formattedDropOffDateTime = dropOffDateTime.format(formatter);
        //needed set element manual
        WebElement pickUpDatePickerInput = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.traveloka.android:id/edit_text_field\" and @text=\"Sel, 9 Jul 2024 - 09:00\"]")); //element do not dinamis today
        pickUpDatePickerInput.sendKeys(formattedPickUpDateTime);
        WebElement dropOffDatePickerInput = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.traveloka.android:id/edit_text_field\" and @text=\"Rab, 10 Jul 2024 - 09:00\"]")); //element do not dinamis today
        dropOffDatePickerInput.sendKeys(formattedDropOffDateTime);
        //Click button Search Car
        driver.findElement(AppiumBy.id("com.traveloka.android.rental_impl:id/button_rental_search")).click();
        Thread.sleep(5000);
        //Select Car
        driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.traveloka.android.rental_impl:id/layout_main\"])[1]")).click();
        Thread.sleep(3000);
        //Select Car Provider
        driver.findElement(AppiumBy.xpath("(//androidx.cardview.widget.CardView[@resource-id=\"com.traveloka.android.rental_impl:id/layout_rental_item\"])[1]/android.view.ViewGroup")).click();
        Thread.sleep(5000);
        //Click button Continue in Product Detail
        driver.findElement(AppiumBy.id("com.traveloka.android.rental_impl:id/button_action")).click();
        Thread.sleep(3000);
        //Select Pick-up Location in “Rental Office”
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.traveloka.android.rental_impl:id/text_title\" and @text=\"Kantor Rental\"]")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.traveloka.android.rental_impl:id/container\"])[1]")).click();
        driver.findElement(AppiumBy.id("com.traveloka.android.rental_impl:id/button_action")).click();
        Thread.sleep(3000);
        //Click button Book Now
        driver.findElement(AppiumBy.id("com.traveloka.android.rental_impl:id/button_select")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.traveloka.android.rental_impl:id/text_title\"])[3]")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.id("com.traveloka.android.rental_impl:id/button_action")).click();
        Thread.sleep(5000);
        //Fill Contact Details
        driver.findElement(AppiumBy.accessibilityId("trip_booking_view_contactemptycontainer")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.traveloka.android.trip_impl:id/layout_view_description\"]/android.widget.LinearLayout/android.widget.EditText[1]")).sendKeys("hendra");
        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.traveloka.android.trip_impl:id/layout_view_description\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[2]")).sendKeys("81223292457");
        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.traveloka.android.trip_impl:id/layout_view_description\"]/android.widget.LinearLayout/android.widget.EditText[2]")).sendKeys("hendra@example.com");
        driver.findElement(AppiumBy.id("com.traveloka.android.trip_impl:id/button_save")).click();
        Thread.sleep(3000);
        //Fill Driver Details
        driver.findElement(AppiumBy.accessibilityId("trip_booking_view_traveleremptycontainer")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.Spinner")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Tuan\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.traveloka.android.trip_impl:id/layout_view_description\"]/android.widget.LinearLayout/android.widget.EditText")).sendKeys("sapjo");
        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.traveloka.android.trip_impl:id/layout_view_description\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[2]")).sendKeys("82343455678");
        driver.findElement(AppiumBy.id("com.traveloka.android.trip_impl:id/button_save")).click();
        Thread.sleep(3000);
        //Click Continue
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"LANJUTKAN\"));")).click();
        //Add a special request is optional
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Ketuk untuk centang syarat rental.*\"]")).click();
        Thread.sleep(3000);
        //Check all rental requirements
        driver.findElement(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id=\"com.traveloka.android.rental_impl:id/check_box\"])[1]")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Selesai\"));"));
        driver.findElement(AppiumBy.id("com.traveloka.android.rental_impl:id/button_save")).click();
        Thread.sleep(3000);
        //Click Continue
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Lanjutkan\"));")).click();
        Thread.sleep(5000);
        //Select payment method and proceed payment
//        driver.findElement(AppiumBy.id("com.traveloka.android:id/widget_button_blue")).click();
//        Thread.sleep(10000);
//        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.traveloka.android:id/text_view_choose_payment_method\"]")).click();
//        Thread.sleep(3000);
//        driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.traveloka.android:id/image_gpo_option_logo\"])[1]")).click();
//        Thread.sleep(3000);
//        driver.findElement(AppiumBy.id("com.traveloka.android:id/button_pay_now")).click();
//        Thread.sleep(3000);
    }
    @AfterClass
    public void TearDown() {
        driver.quit();
    }

}
