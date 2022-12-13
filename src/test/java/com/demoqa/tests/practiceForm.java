package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class practiceForm extends TestBase {

    @Test
    void sucessfullTest () {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();

        $("#firstName").setValue("Maxim");
        $("#lastName").setValue("Teryokhin");
        $("#userEmail").setValue("mailtest@mail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--010:not(.react-datepicker__day--outside--month)").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");

        $("#currentAddress").setValue("Address, Street, Building");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();


        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive table").shouldHave(text("Maxim Teryokhin"),
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

    @Test
    void sucessfullTestMinimumTests () {
        open("/automation-practice-form");

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Maxim");
        $("#lastName").setValue("Teryokhin");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");


        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive table").shouldHave(text("Maxim Teryokhin"),
                text("1234567890"));


    }
}
