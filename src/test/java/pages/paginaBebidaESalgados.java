package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class paginaBebidaESalgados extends paginaInicial{
    public paginaBebidaESalgados (WebDriver navegador)  {
        super(navegador);
    }


    // adicionar coca ao carrinho
    public paginaBebidaESalgados adicionarCoca () throws InterruptedException {
        navegador.findElement(By.id("add-product-0-btn")).click();
        return this;
    }

    // validar coca

    public paginaBebidaESalgados validarCoca () throws InterruptedException {
        Thread.sleep(4000);
        String coca = navegador.findElement(By.className("Toastify__toast-body")).getText();
        Thread.sleep(3000);
        Assert.assertEquals("O produto 'Coca-cola lata' foi adicionado ao carrinho", coca);
        return this;
    }

    // adicionar fanta ao carrinho
    public paginaBebidaESalgados adicionarFanta () throws InterruptedException {
        navegador.findElement(By.id("add-product-1-btn")).click();
        return this;
    }

        // validar fanta

        public paginaBebidaESalgados validarFanta () throws InterruptedException {
            Thread.sleep(4000);
            String fanta = navegador.findElement(By.className("Toastify__toast-body")).getText();
            Thread.sleep(2500);
            Assert.assertEquals("O produto 'Fanta uva lata' foi adicionado ao carrinho",fanta);
            return this;
    }

    // adicionar agua ao carrinho
    public paginaBebidaESalgados adicionarAgua () throws InterruptedException {
        navegador.findElement(By.id("add-product-2-btn")).click();
        return this;
    }

    // validar água

        public paginaBebidaESalgados validarAgua () throws InterruptedException {
            Thread.sleep(4000);
            String agua = navegador.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[1]")).getText();
            Thread.sleep(2500);
            Assert.assertEquals("O produto 'Água mineral sem gás' foi adicionado ao carrinho", agua);
            return this;
        }
}
