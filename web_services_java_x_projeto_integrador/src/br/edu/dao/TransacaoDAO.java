package br.edu.dao;

import br.edu.modelo.Transacao;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class TransacaoDAO {
    
    private Document bancoDados;
    private File arquivoBancoDados;
    
    public TransacaoDAO() 
            throws ParserConfigurationException, SAXException, IOException {
        arquivoBancoDados = new File("banco_dados.xml");

        if (arquivoBancoDados.exists()) 
            bancoDados = carregarArquivo(arquivoBancoDados);
        else
            bancoDados = criarArquivo();
    }
    
    private Document criarArquivo() throws ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document bd = dBuilder.newDocument();        
        
        Element transacoes = bd.createElement("transacoes");
        
        bd.appendChild(transacoes);
        
        return bd;
    }            
    
    private Document carregarArquivo(File arquivoXml) 
            throws ParserConfigurationException, SAXException, IOException {
        
        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();        
        DocumentBuilder construtor = fabrica.newDocumentBuilder();
        return construtor.parse(arquivoXml);
    }
    
    public List<Transacao> get() throws ParseException {
        Node transacoes = bancoDados.getElementsByTagName("transacoes").item(0);
        List<Transacao> lista = new ArrayList<>();
        
        for (int i = 0; i < transacoes.getChildNodes().getLength(); i++) {
            Node noTransacao = transacoes.getChildNodes().item(i);
            Transacao transacao = new Transacao();
            
            for (int j = 0; j < noTransacao.getChildNodes().getLength(); j++) {
                Node no = noTransacao.getChildNodes().item(j);
                
                if      (no.getNodeName().equalsIgnoreCase("conta"))
                    transacao.setConta(Long.parseLong(no.getTextContent()));
                else if (no.getNodeName().equalsIgnoreCase("tipo_transacao"))
                    transacao.setTipoTransacao(no.getTextContent());
                else if (no.getNodeName().equalsIgnoreCase("descricao"))
                    transacao.setDescricao(no.getTextContent());
                else if (no.getNodeName().equalsIgnoreCase("data")) {
                    SimpleDateFormat format = 
                                            new SimpleDateFormat("dd/MM/yyyy");  
                    transacao.setData(format.parse(no.getTextContent()));
                }                    
            }
            
            lista.add(transacao);
        }
        
        return lista;
    }
    
    public List<Transacao> get(Long numeroConta) throws ParseException {
        List<Transacao> todas = get();
        List<Transacao> retornos = new ArrayList<>();
        
        for (Transacao transacao : todas) {
            if (transacao.getConta().equals(numeroConta))
                retornos.add(transacao);
        }
        
        if (retornos.isEmpty())
            return null;
        else                   
            return retornos;
    }
    
    public void salvar(Transacao transacao) throws TransformerException {        
        Node transacoes = bancoDados.getElementsByTagName("transacoes").item(0);
        Element trans = bancoDados.createElement("transacao");    
        
        transacoes.appendChild(trans);
        
        Element conta = bancoDados.createElement("conta");
        conta.setTextContent(transacao.getConta().toString());        
        trans.appendChild(conta);
        
        Element tipo = bancoDados.createElement("tipo_transacao");
        tipo.setTextContent(transacao.getTipoTransacao());        
        trans.appendChild(tipo);
        
        Element descricao = bancoDados.createElement("descricao");
        descricao.setTextContent(transacao.getDescricao());        
        trans.appendChild(descricao);

        Element data = bancoDados.createElement("data");
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");          
        
        data.setTextContent(formatador.format(transacao.getData()));        
        trans.appendChild(data);
        
        salvarBancoDados();
    }
    
    private void salvarBancoDados() throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domsource = new DOMSource(bancoDados);
        StreamResult streamResult = new StreamResult(arquivoBancoDados);        
        transformer.transform(domsource, streamResult);        
    }
}
