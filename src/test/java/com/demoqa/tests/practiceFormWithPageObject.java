package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class practiceFormWithPageObjectJava  {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

        //Configuration.timeout = 10000; // 10 секунд

    }

    @Test
    void sucessfullTest () {
        registrationFormPage.openPage()
                .setFirstName("Maxim")
                .setLastName("Teryokhin")
                .setEmail("mailtest@mail.com")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setBirthDate("1","12","1992");

        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");

        $("#currentAddress").setValue("Address, Street, Building");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();


        $("#submit").click();

        registrationFormPage.checkResultsTableVisible()
                            .checkResult("Date of birth", "10 December,1992")
                            .checkResult("Student Name", "Maxim Teryokhin")
                            .checkResult("Student Email", "mailtest@mail.com");

    }

   // @Test
    //void sucessfullTestMinimumTests () {
       // registrationFormPage.openPage();

       // $("#firstName").setValue("Maxim");
       // $("#lastName").setValue("Teryokhin");
       // $("#genterWrapper").$(byText("Male")).click();
       // $("#userNumber").setValue("1234567890");


        //$("#submit").click();

        //$(".modal-dialog").should(appear);
        //$("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        //$(".table-responsive table").shouldHave(text("Maxim Teryokhin"),
        //        text("1234567890"));


    }
}
