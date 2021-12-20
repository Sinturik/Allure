package com.github.sinturik.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepLambdaTest {
    private static final String REPOSITORY = "selenide/selenide-appium";
    private static final Integer ISSUE_NUMBER = 5;

    @Test
    @Owner("Sinturik")
    @DisplayName("Check Issue in Selenide repo")
    @Tag("Middle")
    public void checkIssuesTest() {
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Ищем репозитории Selenide", () -> {
            $("[type='text']").setValue("Selenide").pressEnter();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(byLinkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $("[id=issues-tab]").click();
        });
        step("Проверяем наличие Issue #"+ ISSUE_NUMBER, () -> {
            $("[id=issue_5_link]").shouldBe(Condition.visible);
        });
    }


}
