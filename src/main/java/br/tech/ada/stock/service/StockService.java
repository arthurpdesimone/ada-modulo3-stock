package br.tech.ada.stock.service;

import br.tech.ada.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public void downloadStock(String ticker){

    }


}
