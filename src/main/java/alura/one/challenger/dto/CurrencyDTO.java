package alura.one.challenger.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CurrencyDTO {

    private boolean success;
    private SymbolsDTO symbols;
}
