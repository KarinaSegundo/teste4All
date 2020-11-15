package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.paginaDoces;
import pages.paginaInicial;
import suport.Web;


public class docesPageObjectsTest {
    private WebDriver navegador;

    @Before
    public void setUp () {
        navegador = Web.createBrowserStack();
    }

    @Test
    public void comprarProdutosDaCategoriaDoces () throws InterruptedException {
        new paginaInicial(navegador)
                .selecionarCategoria()
                .categoriaDoces()
                .adicionarBrigadeiro()
                .validarBrigadeiro()
                .adicionarAlfajor()
                .validarAlfajor()
                .selecionarCategoria()
                .todasCategorias()
                .verificarCarrinhoCompras()
                .adicionarMaisBrigadeiro()
                .finalizarCompra()
                .validarMensagem()
                .fecharMensagem();

    }

    @After
    public void tearDown () {
        navegador.quit();
    }
}
