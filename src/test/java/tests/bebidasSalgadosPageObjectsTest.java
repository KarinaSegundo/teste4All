package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.paginaInicial;
import suport.Web;

public class bebidasSalgadosPageObjectsTest {
    private WebDriver navegador;

    @Before
    public void setUp () {
        navegador = Web.createBrowserStack();
    }

    @Test
    public void comprarProdutosDaCategoriaBebidaESalgado () throws InterruptedException {
        new paginaInicial(navegador)
                .selecionarCategoria()
                .categoriaBebida()
                .adicionarCoca()
                .validarCoca()
                .adicionarFanta()
                .validarFanta()
                .adicionarAgua()
                .validarAgua()
                .selecionarCategoria()
                .todasCategorias()
                .adicionarRisole()
                .validarRisole()
                .verificarCarrinhoCompras()
                .adicionarMaisRisole()
                .diminuirRisole()
                .validarValor()
                .finalizarCompra()
                .validarMensagem()
                .fecharMensagem();

    }

    @After
    public void tearDown () {
        navegador.quit();
    }
}
