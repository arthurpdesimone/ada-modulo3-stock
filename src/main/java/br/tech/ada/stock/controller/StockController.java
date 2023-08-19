package br.tech.ada.stock.controller;

import br.tech.ada.stock.dto.UserDTO;
import br.tech.ada.stock.exception.StockNotFoundException;
import br.tech.ada.stock.model.Stock;
import br.tech.ada.stock.model.User;
import br.tech.ada.stock.service.StockService;
import br.tech.ada.stock.service.UserService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/stocks")
@Slf4j
public class StockController {
    @Autowired
    private StockService stockService;
    @PostMapping("/insert/{ticker}")
    public ResponseEntity insertStock(@PathVariable String ticker) throws IOException, ParseException, StockNotFoundException {
        stockService.downloadStock(ticker);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/list/{ticker}")
    public ResponseEntity<?> listStock(@PathVariable String ticker) {
        List<Stock> stockList = stockService.listStock(ticker);
        return new ResponseEntity(stockList,HttpStatus.OK);
    }

    @GetMapping("/list/{ticker}/{page}")
    public ResponseEntity<?> listStockPageable(@PathVariable String ticker, @PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page,20);
        Page<Stock> stockList = stockService.listStockByPagination(ticker,pageable);
        return new ResponseEntity(stockList,HttpStatus.OK);
    }
}
