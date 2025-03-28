package com.google.task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ScrollToElement implements Task {
    private final String firstWord;
    private final String secondWord;

    public ScrollToElement(String firstWord, String secondWord) {
        this.firstWord = firstWord;
        this.secondWord = secondWord;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String dynamicXpath = "//p[contains(., '" + firstWord + "') and .//span[contains(., '" + secondWord + "')]]";
        Target elemento = Target.the("Element with specific text").located(By.xpath(dynamicXpath));

        actor.attemptsTo(Scroll.to(elemento));


        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath(dynamicXpath)));


    }

    public static ScrollToElement withText(String firstWord, String secondWord) {
        return instrumented(ScrollToElement.class, firstWord, secondWord);
    }
}
