package alura.one.challenger.enums;


import java.util.ArrayList;
import java.util.List;

public enum Currency {

    AWG ("AWG", "ƒ"),
    AZN ("AZN", "₼"),
    BAM ("BAM", "KM"),
    BTC ("BTC", "₿"),
    BYN ("BYN", "Br"),
    BYR ("BYR", "Br"),
    BZD ("BZD", "BZ$"),
    CVE ("CVE", "$"),
    DKK ("DKK", "kr"),
    DOP ("DOP", "RD$"),
    EGP ("EGP", "£"),
    ERN ("ERN", "Nfk"),
    ETB ("ETB", "Br"),
    EUR ("EUR", "€"),
    FKP ("FKP", "£"),
    GBP ("GBP", "£"),
    GGP ("GGP", "£"),
    GHS ("GHS", "₵"),
    GIP ("GIP", "£"),
    GMD ("GMD", "D"),
    GNF ("GNF", "FG"),
    GTQ ("GTQ", "Q"),
    GYD ("GYD", "$"),
    HRK ("HRK", "kn"),
    HTG ("HTG", "G"),
    HUF ("HUF", "Ft"),
    IDR ("IDR", "Rp"),
    ISK ("ISK", "kr"),
    JEP ("JEP", "£"),
    JMD ("JMD", "J$"),
    JPY ("JPY", "¥"),
    KES ("KES", "KSh"),
    KMF ("KMF", "CF"),
    KPW ("KPW", "₩"),
    KRW ("KRW", "₩"),
    LAK ("LAK", "₭"),
    MDL ("MDL", "L"),
    MGA ("MGA", "Ar"),
    MKD ("MKD", "ден"),
    MMK ("MMK", "K"),
    MNT ("MNT", "₮"),
    MOP ("MOP", "P"),
    MRO ("MRO", "UM"),
    MUR ("MUR", "₨"),
    MVR ("MVR", "Rf"),
    MWK ("MWK", "MK"),
    MXN ("MXN", "$"),
    MYR ("MYR", "RM"),
    MZN ("MZN", "MT"),
    NAD ("NAD", "$"),
    NGN ("NGN", "₦"),
    NIO ("NIO", "C$"),
    NOK ("NOK", "kr"),
    NPR ("NPR", "₨"),
    NZD ("NZD", "$"),
    PAB ("PAB", "B/."),
    PEN ("PEN", "S/"),
    PGK ("PGK", "K"),
    PHP ("PHP", "₱"),
    RON ("RON", "lei"),
    RUB ("RUB", "₽"),
    RWF ("RWF", "R₣"),
    SCR ("SCR", "₨"),
    SEK ("SEK", "kr"),
    SZL ("SZL", "L"),
    THB ("THB", "฿"),
    TJS ("TJS", "ЅМ"),
    TWD ("TWD", "NT$"),
    TZS ("TZS", "TSh"),
    UGX ("UGX", "USh"),
    USD ("USD", "$"),
    UYU ("UYU", "$U"),
    XCD ("XCD", "$"),
    XDR ("XDR", "SDR");

    private final String key;
    private final String value;

    Currency(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static String getValueByKey(String key) {
        for (Currency symbolText : Currency.values()) {
            if (symbolText.getKey().equals(key)) {
                return symbolText.getValue();
            }
        }
        return null;
    }

    public static List<String> getKeys() {
        List<String> keys = new ArrayList<>();
        for (Currency symbolText : Currency.values()) {
            keys.add(symbolText.getKey());
        }
        return keys;
    }
}
