package com.github.sinturik.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideIssueTest {

    @Test
    @Owner("Sinturik")
    @DisplayName("Check Issue in Selenide repo")
    @Tag("Middle")
    public void checkIssuesTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");

        $("[type='text']").setValue("Selenide").pressEnter();

        $(byLinkText("selenide/selenide-appium")).click();

        $("[id=issues-tab]").click();

        //сделала грамматическую ошибку при написании элемента (p вместо 5), чтобы изучить отчет по упавшему тесту
        $("[id=issue_p_link]").shouldBe(Condition.visible);
    }
}
