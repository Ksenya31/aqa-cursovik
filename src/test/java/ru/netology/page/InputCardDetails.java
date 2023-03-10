package ru.netology.page;

import org.openqa.selenium.Keys;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InputCardDetails {

    public InputCardDetails fillingInFields(DataHelper.CardDetails info) {

        $(byText("Номер карты")).parent().$(".input__control")
                .setValue(info.getNumber());
        $(byText("Месяц")).parent().$(".input__control")
                .setValue(info.getMonth());
        $(byText("Год")).parent().$(".input__control")
                .setValue(info.getYear());
        $(byText("Владелец")).parent().$(".input__control")
                .setValue(info.getOwner());
        $(byText("CVC/CVV")).parent().$(".input__control")
                .setValue(info.getCvc());
        $(byText("Продолжить")).click();

        return new InputCardDetails();
    }


    public void clearFields() {
        $(byText("Номер карты")).parent().$(".input__control")
                .sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
        $(byText("Месяц")).parent().$(".input__control")
                .sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $(byText("Год")).parent().$(".input__control")
                .sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $(byText("Владелец")).parent().$(".input__control")
                .sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
        $(byText("CVC/CVV")).parent().$(".input__control")
                .sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE, Keys.BACK_SPACE);
        if ($(".notification").isDisplayed()) {
            $(".notification").$(".notification__closer").click();
        }
    }

    public void successMessageVisible() {
        $$(".notification").first().shouldBe(visible, Duration.ofSeconds(20))
                .shouldHave(text("Операция одобрена Банком."))
                .$(".notification__closer").click();
    }

    public void successMessageNotVisible() {
        $$(".notification").first().shouldNotBe(visible);
    }

    public void errorMessageVisible() {
        $$(".notification").last().shouldBe(visible, Duration.ofSeconds(25))
                .shouldHave(text("Ошибка! Банк отказал в проведении операции."))
                .$(".notification__closer").click();
    }

    public void errorMessageNotVisible() {
        $$(".notification").last().shouldNotBe(visible);
    }

    //CardNumber
    public void errorMessageCardNumberEmpty() {
        $(byText("Номер карты")).parent().$(".input__sub")
                .shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text("Поле обязательно для заполнения"));
    }

    public void errorMessageInvalidCardNumber() {
        $(byText("Номер карты")).parent().$(".input__sub")
                .shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text("Неверный формат"));
    }

    // месяц
    public void errorMessageInvalidMonth() {
        $(byText("Месяц")).parent().$(".input__sub")
                .shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text("Неверно указан срок действия карты"));
    }

    public void errorMessageInvalidMonthEmpty() {
        $(byText("Месяц")).parent().$(".input__sub")
                .shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text("Поле обязательно для заполнения"));
    }

    public void errorMessageInvalidMonth1Symbol() {
        $(byText("Месяц")).parent().$(".input__sub")
                .shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text("Неверный формат"));
    }

    // год
    public void errorMessageInvalidLastYear() {
        $(byText("Год")).parent().$(".input__sub")
                .shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text("Истёк срок действия карты"));
    }

    // владелец
    public void errorMessageInvalidOwner() {
        $(byText("Владелец")).parent().$(".input__sub")
                .shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text("Неверный формат"));
    }

    public void errorMessageInvalidOwnerEmpty() {
        $(byText("Владелец")).parent().$(".input__sub")
                .shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text("Поле обязательно для заполнения"));
    }

    // CVC
    public void errorMessageInvalidCVC() {
        $(byText("CVC/CVV")).parent().$(".input__sub")
                .shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text("Неверный формат"));
    }

    public void errorMessageInvalidCVCEmpty() {
        $(byText("CVC/CVV")).parent().$(".input__sub")
                .shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text("Поле обязательно для заполнения"));
    }

}