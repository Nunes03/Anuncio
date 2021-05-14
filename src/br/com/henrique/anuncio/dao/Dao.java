package br.com.henrique.anuncio.dao;

import br.com.henrique.anuncio.model.Anuncio;
import br.com.henrique.anuncio.view.CadastroAnuncio;
import static br.com.henrique.anuncio.view.CadastroAnuncio.tblAnuncios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;

public class Dao {
    
    static Connection conexao = conector();
    static PreparedStatement pst = null;
    static ResultSet rs = null;
    
    /***
     * <h1>Inicia a conexao com o banco MySQL</h1>
     * 
     * <p>Prepara uma conexão JDBC com o mysql,
     * informa url, user e password para que possa ser
     * iniciada a conexão com DB "henrique"</p>
     * 
     * @return conexao Connection, retorna a conexão
     * caso tenha conseguido estabelecer a conexão,
     * e null caso não tenha conseguido.
     * 
     * @author Henrique
     */
    public static Connection conector(){
        java.sql.Connection conexao = null;
        String url = "jdbc:mysql://localhost:3306/henrique";
        String user = "root";
        String password = "root";
        
        try {
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    
    /***
     * <h1>Inserir os dados no banco.</h1>
     * 
     * <p>Insere os dados do {@link Anuncio} no banco de dados</p>
     * 
     * @param anuncio Anuncio, referente ao anuncio informado
     * 
     * @author Henrique
     * 
     * @see Anuncio
     */
    public static void inserirDados(Anuncio anuncio) {
        String sql = "insert into anuncios (nome, cliente, data_inicio, data_fim, investimento_dia)"
            + " values ('" + anuncio.getNome() + "', '" + anuncio.getCliente() + "', '"
            + anuncio.getDataInicio().toString() + "', '"
            + anuncio.getDataFim().toString() + "', "
            + anuncio.getInvestimentoDia() + ")";
        try {
            pst = conexao.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /***
     * <h1>Pesquisar os dados no banco.</h1>
     * 
     * <p>Pesquisa todos os dados do {@link Anuncio} no banco de dados</p>
     * 
     * @author Henrique
     * 
     * @see Anuncio
     */
    public static void procurarDados() {
        String sql = "select nome 'Nome', cliente 'Cliente', data_inicio 'Data Início',"
                + " data_fim 'Data Fim', investimento_dia 'Valor Investimento' from anuncios";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            CadastroAnuncio.tblAnuncios.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
    
    /***
     * <h1>Pesquisar os {@link Anuncio}s de um cliente</h1>
     * 
     * <p>Recebe um {@link Anuncio} e pesquisa todos os seus dados
     * e apresenta na tabela</p>
     * 
     * @param anuncio Anuncio, referente ao anuncio informado
     * 
     * @author Henrique
     * 
     * @see Anuncio
     */
    public static void pesquisarCliente(Anuncio anuncio){
        String sql = "select nome 'Nome', cliente 'Cliente', data_inicio 'Data Início' , data_fim 'Data Fim', investimento_dia 'Investimento Dia'"
                + "from anuncios where cliente like '%" + anuncio.getCliente() + "%'";
        
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            CadastroAnuncio.tblAnuncios.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }      
    }
    
    /***
     * <h1>Pesquisar os {@link Anuncio}s em um intervalo de datas</h1>
     * 
     * <p></p>
     * 
     * @param anuncio Anuncio, referente ao {@link Anuncio} informado
     * 
     * @author Henrique
     * 
     * @see Anuncio
     */
    public static void pesquisarIntervaloEntreDatas(Anuncio anuncio){
        String sql = "select nome 'Nome', cliente 'Cliente', data_inicio 'Data Início' , data_fim 'Data Fim', investimento_dia 'Investimento Dia'"
                + "from anuncios where data_inicio between '" + anuncio.getDataInicio() 
                + "' and '" + anuncio.getDataFim() + "'";
        try{
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            CadastroAnuncio.tblAnuncios.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }   
    }
}
