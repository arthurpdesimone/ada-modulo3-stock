package br.tech.ada.stock.repository;

import br.tech.ada.stock.model.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
    List<Stock> findByTicker (String ticker);

    Page<Stock> findByTicker(String ticker, Pageable pageable);
}
