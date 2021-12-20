package com.github.sinturik.allure.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозитории Selenide")
    public void searchRepository() {
        $("[type='text']").setValue("Selenide").pressEnter();
    }

    @Step("Переходим в репозиторий {repo}")
    public void goToRepository(String repo) {
        $(byLinkText(repo)).click();
    }

    @Step
    public void goToIssuesTab() {
        $("[id=issues-tab]").click();
    }

    @Step("Проверяем, что существует Issue с номером {number}")
    public void checkIssueInRepository(int number) {
        $("[id=issue_5_link]").shouldBe(Condition.visible);
    }
}
