package com.google.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.google.userinterfaces.GooglePage.SERACH_BAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GoogleSearch implements Task {

    private  String search;

    public GoogleSearch(String search) {
        this.search = search;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        SERACH_BAR.waitingForNoMoreThan(Duration.ofSeconds(5)).isVisibleFor(actor);

        actor.attemptsTo(
                Enter.theValue(search).into(SERACH_BAR).thenHit(Keys.ENTER));
        System.out.println("Pausa para relizar manualmente el capchat");

    }

    public static GoogleSearch word(String search) {
        return instrumented(GoogleSearch.class, search);
    }

}
