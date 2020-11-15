package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static org.junit.Assert.assertEquals;

public class paginaDoces extends paginaInicial{


    public paginaDoces (WebDriver navegador) {
        super(navegador);
    }

    // adicionar brigadeiro ao carrinho
    public paginaDoces adicionarBrigadeiro () throws InterruptedException {
        navegador.findElement(By.id("add-product-4-btn")).click();
        return this;
    }

    // validar se brigadeiro foi adicionado ao carrinho
    public paginaDoces validarBrigadeiro() throws InterruptedException {
        Thread.sleep(4000);
        String mensagemBrigadeiro = navegador.findElement(By.className("Toastify__toast-body")).getText();
        Assert.assertEquals("O produto 'Brigadeiro' foi adicionado ao carrinho",  mensagemBrigadeiro);
        return this;
    }

    // adicionar alfajor ao carrinho
    public paginaDoces adicionarAlfajor () throws InterruptedException {
        Thread.sleep(4000);
        navegador.findElement(By.id("add-product-5-btn")).click();
        return this;
    }

    // validar se alfajor foi adicionado ao carrinho
    public paginaDoces validarAlfajor () throws InterruptedException {
        Thread.sleep(4000);
        String alfajor = navegador.findElement(By.className("Toastify__toast-body")).getText();
        Assert.assertEquals("O produto 'Alfajor de chocolate' foi adicionado ao carrinho", alfajor);
        return this;
    }
}
