package com.demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class practiceForm extends TestBase {

    @Test
    void sucessfullTest () {
        open("/automation-practice-form");
        $("#firstName").setValue("Maxim");
        $("#lastName").setValue("Teryokhin");
        $("#userEmail").setValue("mailtest@mail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--010").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));

        $("#currentAddress").setValue("Address, Street, Building");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Maxim Teryokhin"),
                text("mailtest@mail.com"),
                text("Male"),
                text("1234567890"),
                text("10 December,1992"),
                text("Computer Science"),
                text("Sports"),
                text("1.png"),
                text("Address, Street, Building"),
                text("NCR Delhi"));

    }
}
