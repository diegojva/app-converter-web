package alura.one.challenger.controller;

import alura.one.challenger.dto.CurrencyDTO;
import alura.one.challenger.dto.SymbolDTO;
import alura.one.challenger.model.ApiResponse;
import alura.one.challenger.service.IApiResponse;
import alura.one.challenger.service.ICurrencyConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private ICurrencyConverter currencyConverter;
    @Autowired
    private IApiResponse apiResponse;
    Map<String, Object> response = new HashMap<>();

    @PostMapping("/converter")
    public ResponseEntity<?> converterCurrency(@RequestParam(value="value") BigDecimal value,
                                                         @RequestParam(value="currencyFrom") String currencyFrom,
                                                         @RequestParam(value="currencyTo") String currencyTo) {
        try {
            ApiResponse apiResponse = currencyConverter.converterCurrency(value, currencyFrom, currencyTo);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }catch (Exception e) {
            response.put("message", "Error to convert currency");
            response.put("details", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/list-currency")
    public ResponseEntity<List<String>> listCurrency() {
        return new ResponseEntity<>(currencyConverter.listCurrency(), HttpStatus.OK);
    }

    @GetMapping("/description-currency")
    public ResponseEntity<List<String>> getDescriptionCurrencyBySymbols(@RequestParam(value="symbolFrom") String symbolFrom,
                                                                      @RequestParam(value="symbolTo") String symbolTo) throws IOException, IllegalAccessException, NoSuchFieldException {
        return new ResponseEntity<>(currencyConverter.getDescriptionCurrencyBySymbols(symbolFrom, symbolTo), HttpStatus.OK);
    }

    @GetMapping("/symbolFrom-currency")
    public ResponseEntity<SymbolDTO> getSymbolByCurrencyFrom(@RequestParam(value="currencyFrom") String currency) throws NoSuchFieldException, IllegalAccessException, JsonProcessingException {
        SymbolDTO symbolDTO = SymbolDTO
                .builder()
                .symbol(currencyConverter.getSymbolByCurrencyTo(currency))
                .build();
        return new ResponseEntity<>(symbolDTO, HttpStatus.OK);
    }

    @GetMapping("/symbolTo-currency")
    public ResponseEntity<SymbolDTO> getSymbolByCurrencyTo(@RequestParam(value="currencyTo") String currency) throws NoSuchFieldException, IllegalAccessException {
        SymbolDTO symbolDTO = SymbolDTO
                .builder()
                .symbol(currencyConverter.getSymbolByCurrencyTo(currency))
                .build();
        return new ResponseEntity<>(symbolDTO, HttpStatus.OK);
    }

    @GetMapping("/list-history-converter")
    public ResponseEntity<List<ApiResponse>> list() {
        return new ResponseEntity<>(apiResponse.findAll(), HttpStatus.OK);
    }

    @GetMapping("/converter/findBy/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(apiResponse.findById(id), HttpStatus.OK);
    }
}
