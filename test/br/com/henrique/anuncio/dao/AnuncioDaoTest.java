package br.com.henrique.anuncio.dao;

import br.com.henrique.anuncio.model.Anuncio;
import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnuncioDaoTest {
    
    /**
     * Para que o teste ocorra corretamente,
     * deve-se comentar a linha onde insere o dado na JTable
     * na classe AnuncioDao.buscarDados.
     */
    @Test
    public void testeInserirDados() {
        Anuncio anuncio = new Anuncio();
        AnuncioDao.liparTabela();
        
        anuncio.setNome("Lucas");
        anuncio.setCliente("Henrique");
        anuncio.setDataInicio(LocalDate.of(2021, 05, 14));
        anuncio.setDataFim(LocalDate.of(2021, 05, 15));
        anuncio.setInvestimentoDia(1548.47);
        
        AnuncioDao.inserirDados(anuncio);
        
        assertEquals(1, AnuncioDao.procurarDados().size());
    }
    
    /**
     * Para que o teste ocorra corretamente,
     * deve-se comentar a linha onde insere o dado na JTable
     * na classe AnuncioDao.buscarDados.
     */
    @Test
    public void testeProcurarDados(){
        Anuncio anuncio = new Anuncio();
        Anuncio anuncio2 = new Anuncio();
        AnuncioDao.liparTabela();
        
        anuncio.setNome("Lucas");
        anuncio.setCliente("Henrique");
        anuncio.setDataInicio(LocalDate.of(2021, 05, 14));
        anuncio.setDataFim(LocalDate.of(2021, 05, 15));
        anuncio.setInvestimentoDia(1548.47);
        
        anuncio2.setNome("Pedro");
        anuncio2.setCliente("Carlos");
        anuncio2.setDataInicio(LocalDate.of(2021, 05, 19));
        anuncio2.setDataFim(LocalDate.of(2021, 05, 21));
        anuncio2.setInvestimentoDia(3485.76);
        
        AnuncioDao.inserirDados(anuncio);
        AnuncioDao.inserirDados(anuncio2);
        
        assertEquals(2, AnuncioDao.procurarDados().size());
    }
    
    /**
     * Para que o teste ocorra corretamente,
     * deve-se comentar a linha onde insere o dado na JTable
     * na classe AnuncioDao.pesquisarCliente.
     */
    @Test
    public void testePesquisarCliente(){
        Anuncio anuncio = new Anuncio();
        Anuncio anuncio2 = new Anuncio();
        AnuncioDao.liparTabela();
        
        anuncio.setNome("Lucas");
        anuncio.setCliente("Carlos");
        anuncio.setDataInicio(LocalDate.of(2021, 05, 14));
        anuncio.setDataFim(LocalDate.of(2021, 05, 15));
        anuncio.setInvestimentoDia(1548.47);
        
        anuncio2.setNome("Pedro");
        anuncio2.setCliente("Carlos");
        anuncio2.setDataInicio(LocalDate.of(2021, 05, 19));
        anuncio2.setDataFim(LocalDate.of(2021, 05, 21));
        anuncio2.setInvestimentoDia(3485.76);
        
        AnuncioDao.inserirDados(anuncio);
        AnuncioDao.inserirDados(anuncio2);
        
        assertEquals(2, AnuncioDao.pesquisarCliente(anuncio2).size());     
    }
    
    /**
     * Para que o teste ocorra corretamente,
     * deve-se comentar a linha onde insere o dado na JTable
     * na classe AnuncioDao.pesquisarIntervaloEntreDatas.
     */
    @Test
    public void testePesquisarInteravaloEntreDatas(){
        Anuncio anuncio = new Anuncio();
        Anuncio anuncio2 = new Anuncio();
        AnuncioDao.liparTabela();
        
        anuncio.setNome("Lucas");
        anuncio.setCliente("Carlos");
        anuncio.setDataInicio(LocalDate.of(2021, 05, 19));
        anuncio.setDataFim(LocalDate.of(2021, 05, 21));
        anuncio.setInvestimentoDia(1548.47);
        
        anuncio2.setNome("Pedro");
        anuncio2.setCliente("Carlos");
        anuncio2.setDataInicio(LocalDate.of(2021, 05, 19));
        anuncio2.setDataFim(LocalDate.of(2021, 05, 21));
        anuncio2.setInvestimentoDia(3485.76);
        
        AnuncioDao.inserirDados(anuncio);
        AnuncioDao.inserirDados(anuncio2);
        
        assertEquals(2, AnuncioDao.pesquisarCliente(anuncio2).size());
    }
}
