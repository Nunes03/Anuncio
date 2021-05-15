package br.com.henrique.anuncio.dao;

import br.com.henrique.conexao.Connector;
import br.com.henrique.anuncio.model.Anuncio;
import br.com.henrique.anuncio.view.CadastroAnuncio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import net.proteanit.sql.DbUtils;

/**
 * <h1>Classe reponsável pelo AnuncioDAO</h1>
 * 
 * <p>Executa os métodos de CRUD relacionados
 * a classe {@link Anuncio} no banco de dados</p>
 * 
 * @author Henrique
 * 
 * @see Anuncio
 */
public class AnuncioDao {

    static Connection conexao = Connector.conector();
    static PreparedStatement pst = null;
    static ResultSet rs = null;

    /**
     *
     * <h1>Inserir os dados no banco.</h1>
     *
     * <p>
     * Insere os dados do {@link Anuncio} no banco de dados</p>
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

    /**
     *
     * <h1>Pesquisar os dados no banco.</h1>
     *
     * <p>
     * Pesquisa todos os dados do {@link Anuncio} no banco de dados.</p>
     *
     * @author Henrique.
     * @return ArrayList<ResultSet>, referente aos anuncios encontrados.
     *
     * @see Anuncio
     */
    public static ArrayList<ResultSet> procurarDados() {
        ArrayList<ResultSet> listaResultados = new ArrayList<ResultSet>();
        String sql = "select nome 'Nome', cliente 'Cliente', data_inicio 'Data Início',"
                + " data_fim 'Data Fim', investimento_dia 'Valor Investimento' from anuncios";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

           //Linha a abaixo deve ser comentada para o teste
           CadastroAnuncio.tblAnuncios.setModel(DbUtils.resultSetToTableModel(rs));
            
            while(rs.next()){
                listaResultados.add(rs);
            }
            return listaResultados;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *
     * <h1>Pesquisar os {@link Anuncio}s de um cliente.</h1>
     *
     * <p>
     * Recebe um {@link Anuncio} e pesquisa todos os seus dados e apresenta na
     * tabela.</p>
     *
     * @param anuncio Anuncio, referente ao anuncio informado.
     *
     * @author Henrique.
     * @return ArrayList<ResultSet>, referente aos anuncios encontrados.
     *
     * @see Anuncio
     */
    public static ArrayList<ResultSet> pesquisarCliente(Anuncio anuncio) {
         ArrayList<ResultSet> listaResultados = new ArrayList<ResultSet>();
        String sql = "select nome 'Nome', cliente 'Cliente', data_inicio 'Data Início' , data_fim 'Data Fim', investimento_dia 'Investimento Dia'"
                + "from anuncios where cliente like '%" + anuncio.getCliente() + "%'";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            //Linha a abaixo deve ser comentada para o teste
            CadastroAnuncio.tblAnuncios.setModel(DbUtils.resultSetToTableModel(rs));
            
            while(rs.next()){
                listaResultados.add(rs);
            }
            return listaResultados;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *
     * <h1>Pesquisar os {@link Anuncio}s em um intervalo de datas.</h1>
     *
     * <p>
     * Pesquisa atraves de um {@link Anuncio} todos os anuncios em um intervalo
     * de tempo.</p>
     *
     * @param anuncio Anuncio, referente ao {@link Anuncio} informado.
     *
     * @return ArrayList<ResultSet>, referente aos resultados encontrados. 
     * 
     * @author Henrique.
     *
     * @see Anuncio
     */
    public static ArrayList<ResultSet> pesquisarIntervaloEntreDatas(Anuncio anuncio) {
        ArrayList<ResultSet> listaResultados = new ArrayList<ResultSet>();
        String sql = "select nome 'Nome', cliente 'Cliente', data_inicio 'Data Início' , data_fim 'Data Fim', investimento_dia 'Investimento Dia'"
                + "from anuncios where data_inicio between '" + anuncio.getDataInicio()
                + "' and '" + anuncio.getDataFim() + "'";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            //Linha a abaixo deve ser comentada para o teste
            CadastroAnuncio.tblAnuncios.setModel(DbUtils.resultSetToTableModel(rs));
            
            while(rs.next()){    
                listaResultados.add(rs);
            }
            return listaResultados;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /***
     * <h1>Método destinado ao uso de teste.</h1>
     * 
     * <p>Limpa todos os dados da tabela do banco.</p>
     * 
     * @author Henrique.
     */
    public static void liparTabela(){
        String sql = "delete from anuncios";
        try{
            pst = conexao.prepareStatement(sql);
            pst.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
