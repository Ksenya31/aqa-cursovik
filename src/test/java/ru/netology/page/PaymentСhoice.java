package ru.netology.page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class PaymentСhoice {

    public void cardPayment() {
        $(byText("Купить")).click();
        $(withText("Оплата по карте")).shouldBe(visible);
    }
}
