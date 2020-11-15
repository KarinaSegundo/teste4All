package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class docesBebidasSalgados {
    private WebDriver navegador;

    @Before
    public void  setUp ()   {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Karina\\drives\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Navegar na página do shopcart
        navegador.get("https://shopcart-challenge.4all.com/");
    }

    @Test
    public void testDoces () throws InterruptedException {

        // Clicar para selecionar categoria
        navegador.findElement(By.id("open-categories-btn")).click();

        // Selecionar categoria 'Doces'
        navegador.findElement(By.id("category-1")).click();

        // Adicionar todos os produtos ao carrinho
        navegador.findElement(By.id("add-product-4-btn")).click();
        Thread.sleep(4000);

        String brigadeiro = navegador.findElement(By.className("Toastify__toast-body")).getText();
        Thread.sleep(4000);
        assertEquals("O produto 'Brigadeiro' foi adicionado ao carrinho", brigadeiro);


        navegador.findElement(By.id("add-product-5-btn")).click();
        Thread.sleep(4000);

        String alfajor = navegador.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[1]")).getText();
        Thread.sleep(4000);
        assertEquals("O produto 'Alfajor de chocolate' foi adicionado ao carrinho", alfajor);


        // Clicar para selecionar categoria
        navegador.findElement(By.id("open-categories-btn")).click();

        // Selecionar categoria 'Todos'
        navegador.findElement(By.id("category-all")).click();

        // Acessar o carrinho
        navegador.findElement(By.id("cart-btn")).click();

        // Aumentar a quantidade do produto 'Brigadeiro' em 4 unidades
        int qdt = Integer.parseInt(navegador.findElement(By.id("product-4-qtd")).getText());
        assertEquals(1, qdt);
        for (int i = 1; i <= 4; i++) {
            navegador.findElement(By.id("add-product-4-qtd")).click();
        }
        int qdtFinal = Integer.parseInt(navegador.findElement(By.id("product-4-qtd")).getText());
        assertEquals(5, qdtFinal);

        // Clicar no botão 'Finalizar Compra'
        navegador.findElement(By.id("finish-checkout-button")).click();

        // Validar mensagem 'Pedido realizado com sucesso'
        String pedidoFinalizado = navegador.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div/h2")).getText();
        assertEquals("Pedido realizado com sucesso!", pedidoFinalizado);

        // Clicar no botão 'Fechar'
        navegador.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div/button")).click();
    }

    @Test
    public void testBebidasSalgados () throws InterruptedException {

        // clicar em 'categoria'
        navegador.findElement(By.id("open-categories-btn")).click();

        // selecionar categoria 'Bebidas'
        navegador.findElement(By.id("category-0")).click();

        // adicionar todos os produtos ao carrinho
        //coca
        navegador.findElement(By.id("add-product-0-btn")).click();

        // fanta
        navegador.findElement(By.id("add-product-1-btn")).click();


        // agua
        navegador.findElement(By.id("add-product-2-btn")).click();

        // clicar em 'categoria'
        navegador.findElement(By.id("open-categories-btn")).click();

        // selecionar categoria 'Todos'
        navegador.findElement(By.id("category-all")).click();

        // Adicionar o produto 'Risole médio' ao carrinho
        navegador.findElement(By.id("add-product-3-btn")).click();

        // validar produto
        //String risole = navegador.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[1]")).getText();
        //Thread.sleep(4000);
        //Assert.assertEquals("O produto 'Rissole médio' foi adicionado ao carrinho", risole);

        // acessar carrinho
        navegador.findElement(By.id("cart-btn")).click();

        // aumentar a quantidade do produto 'Risole médio' em 9 unidades


        int qtd = Integer.parseInt(navegador.findElement(By.xpath("//*[@id=\"add-product-3-qtd\"]/span")).getText());
        assertEquals(1, qtd);

        for (int i = 1; i <= 9; i++){
            navegador.findElement(By.xpath("//*[@id=\"add-product-3-qtd\"]/span")).click();
        }
        int qdtFinal = Integer.parseInt(navegador.findElement(By.xpath("//*[@id=\"add-product-3-qtd\"]/span")).getText());
        assertEquals(10, qdtFinal);


        // dimunuir a quantidade do produto 'Risole médio' em 5 unidades
        int qdt = Integer.parseInt(navegador.findElement(By.id("add-product-3-btn")).getText());

        for (int i = 1; 5 >= i; i--) {
            navegador.findElement(By.id("add-product-3-btn")).click();
        }


        // validar o valor total dos produtos


        // clica no botão 'Finalizar Compra'
        navegador.findElement(By.id("finish-checkout-button")).click();

        // validar mensagem 'Pedido realizado com sucesso!'
        String pedidoFinalizado = navegador.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div/h2")).getText();
        assertEquals("Pedido realizado com sucesso!", pedidoFinalizado);

        // clicar no botão 'Fechar'
        navegador.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div/button")).click();


        // fechar o browser
    }

      //  @After
        // Fechar navegador
       // public void tearDown() {
           // navegador.quit();

    }

