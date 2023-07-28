package br.tech.ada.stock.controller;

import br.tech.ada.stock.dto.UserDTO;
import br.tech.ada.stock.model.User;
import br.tech.ada.stock.service.StockService;
import br.tech.ada.stock.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.text.ParseException;

@Controller
@RequestMapping("/stocks")
@Slf4j
public class StockController {
    @Autowired
    private StockService stockService;
    @PostMapping("/insert/{ticker}")
    public ResponseEntity insertStock(@PathVariable String ticker) throws IOException, ParseException {
        stockService.downloadStock(ticker);
        return ResponseEntity.ok().build();
    }
}
