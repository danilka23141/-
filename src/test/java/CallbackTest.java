package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class CallbackTest {
    @Test
    void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $("[data-test-id=callback-form]");
        form.$("[data-test-id=name] input").setValue("Даниил");
        form.$("[data-test-id=surname] input").setValue("Михалев");
        form.$("[data-test-id=phone] input").setValue("+79507234567");
        form.$("[data-test-id=agreement]").click();
        form.$("[data-test-id=submit]").click();
        $(".alert-success").shouldHave(exactText("Ваша заявка успешно отправлена!"));
    }
}
}
