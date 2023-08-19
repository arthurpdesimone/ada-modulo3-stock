package br.tech.ada.stock.exception;

public class StockNotFoundException extends Exception{
    public StockNotFoundException(){
        super("Ação não encontrada, tente um ticker válido como PETR3.SA");
    }

}
