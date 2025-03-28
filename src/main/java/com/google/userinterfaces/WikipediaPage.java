package com.google.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class WikipediaPage extends PageObject {
   public static final Target WIKIPEDIA_TITLE = Target.the("wikipedia url").located(By.className("mw-logo-wordmark"));



}
