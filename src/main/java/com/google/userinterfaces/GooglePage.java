package com.google.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.google.com/")
public class GooglePage extends PageObject {
    public static final Target SERACH_BAR = Target.the("search bar").located(By.id("APjFqb"));
    public static final Target WIKIPEDIA_URL = Target.the("wikipedia url").located(By.xpath("//*[contains(text(),'Wikipedia')]"));



}
