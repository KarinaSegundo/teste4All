package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

public class paginaInicial {

    protected WebDriver navegador;

    public paginaInicial(WebDriver navegador) {
        this.navegador = navegador;
    }

    public paginaInicial() {

    }

    // Clicar para selecionar categoria
    public paginaInicial selecionarCategoria() {
        navegador.findElement(By.id("open-categories-btn")).click();
        return this;
    }

    // Selecionar categoria 'Doces'
    public paginaDoces categoriaDoces() {
        navegador.findElement(By.id("category-1")).click();
        return new paginaDoces(navegador);
    }


    // Selecionar categoria 'Todos'
    public paginaInicial todasCategorias() {
        navegador.findElement(By.id("category-all")).click();
        return this;
    }

    // Acessar o carrinho
    public carrinhoCompras verificarCarrinhoCompras() {
        navegador.findElement(By.id("cart-btn")).click();
        return new carrinhoCompras(navegador);
    }

    // selecionar categoria 'Bebidas'
    public paginaBebidaESalgados categoriaBebida() {
        navegador.findElement(By.id("category-0")).click();
        return new paginaBebidaESalgados(navegador);
    }

    // Adicionar o produto 'Risole médio' ao carrinho
    public paginaInicial adicionarRisole() {
        navegador.findElement(By.id("add-product-3-btn")).click();
        return this;
    }

    // validar produto 'Risole medio' no carrinho
    public paginaInicial validarRisole () throws InterruptedException {
        Thread.sleep(4000);
        String risole = navegador.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[1]")).getText();
        Thread.sleep(2500);
        Assert.assertEquals("O produto 'Rissole médio' foi adicionado ao carrinho",risole);
        return this;
    }

}



