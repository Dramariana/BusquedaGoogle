package com.google.Questions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;


public class SearchElement implements Question<Boolean> {

    private final String firstWord;
    private final String secondWord;

    public SearchElement(String firstWord, String secondWord) {
        this.firstWord = firstWord;
        this.secondWord = secondWord;
    }



    @Override
    public Boolean answeredBy(Actor actor) {
        String dynamicXpath = "//p[contains(., '" + firstWord + "') and .//span[contains(., '" + secondWord + "')]]";
        Target element = Target.the("Element with specific text").located(By.xpath(dynamicXpath));
        return element.resolveFor(actor).isVisible();
    }

    public static SearchElement withText(String firstWord, String secondWord) {
        return new SearchElement(firstWord, secondWord);
    }
}