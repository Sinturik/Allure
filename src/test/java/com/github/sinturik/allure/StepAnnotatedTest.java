package com.github.sinturik.allure;
import com.github.sinturik.allure.steps.WebSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class StepAnnotatedTest {
    private static final String REPOSITORY = "selenide/selenide-appium";
    private static final Integer ISSUE_NUMBER = 5;

    private WebSteps steps = new WebSteps();

    @Test
    @Owner("Sinturik")
    @DisplayName("Тест с аннотациями")
    @Feature("Search")
    @Severity(SeverityLevel.BLOCKER)
    public void checkSelenideIssueInGithubTest(){
        steps.openMainPage();
        steps.searchRepository();
        steps.goToRepository(REPOSITORY);
        steps.goToIssuesTab();
        steps.checkIssueInRepository(ISSUE_NUMBER);
    }
}


