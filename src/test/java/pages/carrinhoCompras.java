package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class carrinhoCompras extends paginaDoces {

    public carrinhoCompras(WebDriver navegador) {
        super(navegador);
    }
    // Aumentar a quantidade do produto 'Brigadeiro' em 4 unidades
    public carrinhoCompras adicionarMaisBrigadeiro () {
        for (int i = 1; i <= 4; i++) {
            navegador.findElement(By.id("add-product-4-qtd")).click();
        }
        return this;
    }
    // Clicar no botão 'Finalizar Compra'
    public carrinhoCompras finalizarCompra(){
        navegador.findElement(By.id("finish-checkout-button")).click();
        return this;
    }

    // Validar mensagem 'Pedido realizado com sucesso'
    public carrinhoCompras validarMensagem () {
        String pedidoFinalizado = navegador.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div/h2")).getText();
        Assert.assertEquals("Pedido realizado com sucesso!", pedidoFinalizado);
        return this;
    }

    // aumentar a quantidade do produto 'Risole médio' em 9 unidades
    public carrinhoCompras adicionarMaisRisole() {
        for (int i = 1; i <= 9; i++){
            navegador.findElement(By.id("add-product-3-qtd")).click();
        }
        return this;
    }

    // diminuir a quantidade do produto 'Risole médio' em 5 unidades
    public carrinhoCompras diminuirRisole() {
        int qtd = Integer.parseInt(navegador.findElement(By.id("product-3-qtd")).getText());
        for (int i = qtd; i >= 5; --i){
            navegador.findElement(By.id("remove-product-3-qtd")).click();
        }
        return this;
    }

    // validar valor total dos produtos
    public carrinhoCompras validarValor () throws InterruptedException {

        String valorTotal = navegador.findElement(By.id("price-total-checkout")).getText();

        Assert.assertEquals("R$ 30,50", valorTotal);
        return this;
    }



    // Clicar no botão 'Fechar'
    public carrinhoCompras fecharMensagem () {
        navegador.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div/button")).click();
        return this;
    }

    }