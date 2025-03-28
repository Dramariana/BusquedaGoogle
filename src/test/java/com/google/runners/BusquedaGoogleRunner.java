package com.google.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/BusquedaGoogle.feature",
        glue = "com.google.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE

)

public class BusquedaGoogleRunner {
}
