package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        //Configuration.timeout = 10000; // 10 секунд

    }

    @Test
    void fillFormTest () {
        open("/text-box");
        $("[id=userName]").setValue("Maxim");
        $("[id=userEmail]").setValue("mmm@mail.com");
        $("[id=currentAddress]").setValue("same street");
        $("[id=permanentAddress]").setValue("same street2");
        $("[id=submit]").click();

        $("[id=output]").$("#name").shouldHave(text("Maxim"));
        $("[id=output]").$("#email").shouldHave(text("mmm@mail.com"));
        $("[id=output]").$("#currentAddress").shouldHave(text("same street"));
        $("[id=output]").$("#permanentAddress").shouldHave(text("same street2"));
    }
}
