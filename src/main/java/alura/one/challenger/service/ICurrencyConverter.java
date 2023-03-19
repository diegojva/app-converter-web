package alura.one.challenger.service;

import alura.one.challenger.dto.SymbolDTO;
import alura.one.challenger.model.ApiResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


public interface ICurrencyConverter {
    ApiResponse converterCurrency(BigDecimal value, String currencyFrom, String currencyTo);

    List<String> listCurrency();

    List<String> getDescriptionCurrencyBySymbols(String symbolFrom, String symbolTo) throws IOException, IllegalAccessException, NoSuchFieldException;

    String getSymbolByCurrencyFrom(String currency) throws NoSuchFieldException, IllegalAccessException;

    String getSymbolByCurrencyTo(String currency) throws NoSuchFieldException, IllegalAccessException;
}
