package alura.one.challenger.service.impl;

import alura.one.challenger.dto.CurrencyDTO;
import alura.one.challenger.dto.SymbolDTO;
import alura.one.challenger.dto.SymbolsDTO;
import alura.one.challenger.enums.Currency;
import alura.one.challenger.model.ApiResponse;
import alura.one.challenger.service.IApiResponse;
import alura.one.challenger.service.ICurrencyConverter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyConverterImpl implements ICurrencyConverter {
    private final String apiKeyValue = "TPOM0MLTXlhaXc5Dxy55T4OEz6BgSZr2";
    private final String baseUrl = "https://api.apilayer.com/exchangerates_data";
    private final RestTemplate restTemplate;
    @Autowired
    private IApiResponse iApiResponse;

    public CurrencyConverterImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public ApiResponse converterCurrency(BigDecimal value, String currencyFrom, String currencyTo) {
        String url = baseUrl + "/convert?from=" + currencyFrom + "&to=" + currencyTo + "&amount=" + value;
        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", apiKeyValue);

        ApiResponse response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), ApiResponse.class).getBody();
        if (response == null) throw new RuntimeException("Erro al convertir la moneda");
        response.getQuery().setSymbolFrom(Currency.getValueByKey(currencyFrom));
        response.getQuery().setSymbolTo(Currency.getValueByKey(currencyTo));

        return iApiResponse.save(response);
    }

    @Override
    public List<String> listCurrency() {
        return Currency.getKeys();
    }

    @Override
    public List<String> getDescriptionCurrencyBySymbols(String symbolFrom, String symbolTo) throws NoSuchFieldException, IllegalAccessException {

        String url = baseUrl + "/symbols?apikey=" + apiKeyValue;

        CurrencyDTO response = restTemplate.exchange(url, HttpMethod.GET, null, CurrencyDTO.class).getBody();
        SymbolsDTO symbolsDTO = response.getSymbols();
        Field fieldFrom = symbolsDTO.getClass().getDeclaredField(symbolFrom);
        Field fieldTo = symbolsDTO.getClass().getDeclaredField(symbolTo);
        fieldFrom.setAccessible(true);
        fieldTo.setAccessible(true);
      /*  String valueFrom = (String) fieldFrom.get(symbolsDTO);
        String valueTo = (String) fieldTo.get(symbolsDTO);*/
        return List.of((String) fieldFrom.get(symbolsDTO), (String) fieldTo.get(symbolsDTO));
    }

    @Override
    public String getSymbolByCurrencyFrom(String currency)  {
        return Currency.getValueByKey(currency);
    }

    @Override
    public String getSymbolByCurrencyTo(String currency)  {
        return Currency.getValueByKey(currency);
    }

}
