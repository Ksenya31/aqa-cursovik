package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {

    private DataHelper() {
    }

    @Value
    public static class CardDetails {
        private String number;
        private String month;
        private String year;
        private String owner;
        private String cvc;

        public static CardDetails getApprovedCard() {
            return new CardDetails("1111 2222 3333 4444", getCurrentMonth(), getCurrentYear(),
                    generateOwner("en"), generateCvc());
        }

        public static CardDetails getDeclinedCard() {
            return new CardDetails("5555 6666 7777 8888", getCurrentMonth(), getCurrentYear(),
                    generateOwner("en"), generateCvc());
        }

        // Данные для поля Номер карты
        public static CardDetails getAnotherCard() {
            return new CardDetails("9999 5555 4433 9874", getCurrentMonth(), getCurrentYear(),
                    generateOwner("en"), generateCvc());
        }

        public static CardDetails getInvalidCardNumberEmpty() {
            return new CardDetails("", getCurrentMonth(), getCurrentYear(),
                    generateOwner("en"), generateCvc());
        }

        public static CardDetails getInvalidCardNumber() {
            return new CardDetails("1111 2222 3333 444", getCurrentMonth(), getCurrentYear(),
                    generateOwner("en"), generateCvc());
        }

        // Данные для поля Месяц
        public static CardDetails getApprovedCardInvalidMonth00() {
            return new CardDetails("1111 2222 3333 4444", "00", "24",
                    generateOwner("en"), generateCvc());
        }

        public static CardDetails getApprovedCardInvalidMonth13() {
            return new CardDetails("1111 2222 3333 4444", "13", getCurrentYear(),
                    generateOwner("en"), generateCvc());
        }

        public static CardDetails getApprovedCardInvalidMonthEmpty() {
            return new CardDetails("1111 2222 3333 4444", "", getCurrentYear(),
                    generateOwner("en"), generateCvc());
        }

        public static CardDetails getApprovedCardInvalidMonth1Symbol() {
            return new CardDetails("1111 2222 3333 4444", "9", getCurrentYear(),
                    generateOwner("en"), generateCvc());
        }

        //Данные для поля Год
        public static CardDetails getApprovedCardInvalidLastYear() {
            return new CardDetails("1111 2222 3333 4444", getCurrentMonth(), getLastYear(),
                    generateOwner("en"), generateCvc());
        }

        private static String getLastYear() {
            String lastYear = String.valueOf(LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy")));
            ;
            return lastYear;
        }

        //Данные для поля Владелец
        public static CardDetails getApprovedCardInvalidOwnerRu() {
            return new CardDetails("1111 2222 3333 4444", getCurrentMonth(), getCurrentYear(),
                    generateOwner("ru"), generateCvc());
        }

        public static CardDetails getApprovedCardInvalidOwnerEn() {
            return new CardDetails("1111 2222 3333 4444", getCurrentMonth(), getCurrentYear(),
                    "r", generateCvc());
        }
        public static CardDetails getApprovedCardInvalidOwnerSpcSymbolNmb() {
            return new CardDetails("1111 2222 3333 4444", getCurrentMonth(), getCurrentYear(),
                    "%$^*1123.//.)@#", generateCvc());
        }

        public static CardDetails getApprovedCardInvalidOwnerSpcEmpty() {
            return new CardDetails("1111 2222 3333 4444", getCurrentMonth(), getCurrentYear(),
                    "", generateCvc());
        }

        //Данные для поля CVC
        public static CardDetails getApprovedCardInvalidCVC1Symbol() {
            return new CardDetails("1111 2222 3333 4444", getCurrentMonth(), getCurrentYear(),
                    generateOwner("en"), "1");
        }

        public static CardDetails getApprovedCardInvalidCVCSpcSymbolLetter() {
            return new CardDetails("1111 2222 3333 4444", getCurrentMonth(), getCurrentYear(),
                    generateOwner("en"), "000");
        }

        public static CardDetails getApprovedCardInvalidCVCEmpty() {
            return new CardDetails("1111 2222 3333 4444", getCurrentMonth(), getCurrentYear(),
                    generateOwner("en"), "");
        }


        public static String getCurrentMonth() {
            String currentMonth = (LocalDate.now().format(DateTimeFormatter.ofPattern("MM")));
            return currentMonth;
        }

        public static String getCurrentYear() {
            String currentYear = (LocalDate.now().format(DateTimeFormatter.ofPattern("yy")));
            return currentYear;
        }

        public static String generateOwner(String locale) {
            Faker faker = new Faker(new Locale(locale));
            String owner = faker.name().firstName() + " " + faker.name().lastName();
            return owner;
        }

        public static String generateCvc() {
            String cvc = RandomStringUtils.randomNumeric(3);
            return cvc;
        }
    }
}
