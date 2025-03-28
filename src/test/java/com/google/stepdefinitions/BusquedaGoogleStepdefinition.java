package com.google.stepdefinitions;

import com.google.task.GoogleSearch;
import com.google.task.ScrollToElement;
import com.google.Questions.SearchElement;
import com.google.task.SelectOption;
import com.google.userinterfaces.GooglePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import net.thucydides.core.annotations.Managed;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;


public class BusquedaGoogleStepdefinition {

    private GooglePage googlePage;

    // @Managed(driver = "firefox", uniqueSession = true)
    @Managed(driver = "chrome")
    public WebDriver hisBrowser;
    private final Actor actor = Actor.named("Mariana");

    @Before
    public void actorCanBrowseTheWeb() {


        WebDriverManager.chromedriver().driverVersion("134.0.6998.165").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        hisBrowser = new ChromeDriver(options);
        actor.can(BrowseTheWeb.with(hisBrowser));
        hisBrowser.manage().window().maximize();
    }


    @Given("the user accessed Google and searched for the word {string}")
    public void theUserAccessedGoogleAndSearchedForTheWord(String search) {
        actor.wasAbleTo(Open.browserOn().the(googlePage));
        actor.attemptsTo(GoogleSearch.word(search));

    }

    @When("the user sees the results, they select the Wikipedia link")
    public void theUserSeesTheResultsTheySelectTheWikipediaLink() {
        actor.attemptsTo(SelectOption.wikipedia());
    }

    @Then("the information is verified that the year of the first automatic process was in the {string}")
    public void theInformationIsVerifiedThatTheYearOfTheFirstAutomaticProcessWasInThe(String expectedYear) {
        String[] words = expectedYear.split(" ", 2);
        String firstWord = words[0];
        String secondWord = words.length > 1 ? words[1] : "";

        actor.attemptsTo(ScrollToElement.withText(firstWord, secondWord));

        assertThat("El elemento debería estar visible",
                SearchElement.withText(firstWord, secondWord).answeredBy(actor), is(true));
    }

    @And("a screenshot of the Wikipedia page is taken")
    public void aScreenshotOfTheWikipediaPageIsTaken() {

        // Tomar la captura de pantalla
        TakesScreenshot screenshot = (TakesScreenshot) BrowseTheWeb.as(actor).getDriver();
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Guardar la captura en una carpeta específica
        try {
            File destFile = new File("target/screenshots/wikipedia_page.png");
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("📸 Captura guardada en: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
