package com.google.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.google.userinterfaces.GooglePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectOption implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(WIKIPEDIA_URL));

    }

    public static SelectOption wikipedia() {
        return instrumented(SelectOption.class);
    }
}
