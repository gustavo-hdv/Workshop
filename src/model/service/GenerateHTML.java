/*
    This file is part of Workshop.

    Workshop is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Workshop is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Workshop. If not, see <https://www.gnu.org/licenses/>

    Contact me:
        Email:   gustavohenrique0008@gmail.com
        Discord: TwoSouls#3428
*/
package model.service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import model.bean.Config;
import model.bean.Orcamento;
import model.dao.ConfigDAO;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class GenerateHTML {
    private final String htmlTag;
    private final String htmlTagSlash;
    private final String headTag;
    private final String headTagSlash;
    private final String charSet;
    private final String titleTag;
    private final String titleTagSlash;
    private final String styleTag;
    private final String styleTagSlash;
    private final String styleContent;
    private final String bodyTag;
    private final String bodyTagSlash;
    private final String preTag;
    private final String preTagSlash;
    private final String strongTag;
    private final String strongTagSlash;
    private final String centerTag;
    private final String centerTagSlash;
    private final String breakTag;
    private final String emTag;
    private final String emTagSlash;
    
    private final String tab1Tag;
    private final String tab1TagSlash;
    private final String tab2Tag;
    private final String tab2TagSlash;
    private final String tab3Tag;
    private final String tab3TagSlash;
    private final String tab30Tag;
    private final String tab30TagSlash;
    
    private final String divTagOriginal;
    private final String divTagSlash;
    private final String initDivTagClass;
    private final String divTagId;
    private final String endDivTag;

    
    private String logoSource;
    
    private String quebraLinha;
    private String empty;
    private String space;
    private String doubleIndent;
    private String quadrupleIndent;
    private String sextupleIndent;
    private String octupleIndent;
    
    public GenerateHTML() {
        this.htmlTag = "<html>";
        this.htmlTagSlash = "</html>";
        this.headTag = "<head>";
        this.headTagSlash = "</head>";
        this.titleTag = "<title>";
        this.titleTagSlash = "</title>";
        this.styleTag = "<style>";
        this.styleTagSlash = "</style>";
        this.bodyTag = "<body onload=\"window.print()\">";
        this.bodyTagSlash = "</body>";
        this.preTag = "<pre>";
        this.preTagSlash = "</pre>";
        this.strongTag = "<strong>";
        this.strongTagSlash = "</strong>";
        this.centerTag = "<center>";
        this.centerTagSlash = "</center>";
        this.breakTag = "<br />";
        this.emTag = "<em>";
        this.emTagSlash = "</em>";
        
        this.tab1Tag = "<tab1>";
        this.tab1TagSlash = "</tab1>";
        this.tab2Tag = "<tab2>";
        this.tab2TagSlash = "</tab2>";
        this.tab3Tag = "<tab3>";
        this.tab3TagSlash = "</tab3>";
        this.tab30Tag = "<tab30>";
        this.tab30TagSlash = "</tab30>";
        
        this.divTagOriginal = "<div>";
        this.divTagSlash = "</div>";
        this.initDivTagClass = "<div class=";
        this.divTagId = " id=";
        this.endDivTag = ">";    
        
        this.charSet = "<meta charset=\"utf-8\">";
        this.logoSource = "<img src=\"" + System.getProperty("user.dir") + "\\LOGO\\logo.png\">";
        
        this.space = "&nbsp";
        this.empty = "";
        this.doubleIndent = "  ";
        this.quadrupleIndent = "    ";
        this.sextupleIndent = "      ";
        this.octupleIndent = "        ";
        this.quebraLinha = "\n";      
        
        this.styleContent = ""
      + sextupleIndent + "img {"                                   + quebraLinha
      + octupleIndent  +   "width: 640px;"                         + quebraLinha
      + octupleIndent  +   "height: 120px;"                        + quebraLinha
      + octupleIndent  +   "object-fit: contain;"                  + quebraLinha
      + sextupleIndent + "}"                                       + quebraLinha
      + quebraLinha
      + sextupleIndent + "#border {"                               + quebraLinha
      + octupleIndent  +     "border: 2px solid grey;"             + quebraLinha
      + octupleIndent  +     "padding: 10px 10px 10px 10px;"       + quebraLinha
      + octupleIndent  +     "border-radius: 25px 25px;"           + quebraLinha
      + sextupleIndent +   "}"                                     + quebraLinha
      + quebraLinha
      + sextupleIndent +  "#bordersquare {"                        + quebraLinha
      + octupleIndent  +     "border: 1px solid grey;"             + quebraLinha
      + sextupleIndent +   "}"                                     + quebraLinha
      + quebraLinha
      + sextupleIndent +   "tab1 { padding-left: 1em; }"           + quebraLinha
      + sextupleIndent +   "tab2 { padding-left: 2em; }"           + quebraLinha
      + sextupleIndent +   "tab3 { padding-left: 3em; }"           + quebraLinha         
      + sextupleIndent +   "tab30 { padding-left: 30em; }"         + quebraLinha
      + quebraLinha
      + sextupleIndent +   "pre {"                                 + quebraLinha
      + octupleIndent  +     "margin:0;"                           + quebraLinha
      + octupleIndent  +     "padding:0;"                          + quebraLinha
      + sextupleIndent +   "}"                                     + quebraLinha
      + quebraLinha
      + sextupleIndent +   "body {"                                + quebraLinha
      + octupleIndent  +     "margin-left: auto;"                  + quebraLinha
      + octupleIndent  +     "margin-right: auto;"                 + quebraLinha
      + octupleIndent  +     "width: 720px;"                       + quebraLinha
      + sextupleIndent +   "}"                                     + quebraLinha
      + quebraLinha
      + sextupleIndent +   "div.primeiro {"                        + quebraLinha
      + octupleIndent  +     "padding: 50px 0px 10px 0px;"         + quebraLinha
      + octupleIndent  +     "text-indent: 15px each-line;"        + quebraLinha
      + octupleIndent  +     "text-align: justify;"                + quebraLinha
      + octupleIndent  +     "font-size: 14px;"                    + quebraLinha
      + sextupleIndent +   "}"                                     + quebraLinha
      + quebraLinha
      + sextupleIndent +   "div.insidesquare {"                    + quebraLinha
      + octupleIndent  +     "padding: 1px 1px 1px 1px;"           + quebraLinha
      + octupleIndent  +     "text-indent: 5px;"                   + quebraLinha
      + octupleIndent  +     "text-align: justify;"                + quebraLinha
      + octupleIndent  +     "font-size: 12px;"                    + quebraLinha
      + sextupleIndent +   "}"                                     + quebraLinha
      + quebraLinha
      + sextupleIndent +   "div.pequeno {"                         + quebraLinha
      + octupleIndent  +     "padding: 0px 0px 1px 0px;"           + quebraLinha
      + octupleIndent  +     "text-indent: 15px each-line;"        + quebraLinha
      + octupleIndent  +     "text-align: justify;"                + quebraLinha
      + octupleIndent  +     "font-size: 12px;"                    + quebraLinha
      + sextupleIndent +   "}"                                     + quebraLinha
      + quebraLinha
      + sextupleIndent +   "div.medio {"                           + quebraLinha
      + octupleIndent  +     "padding: 0px 0px 17px 0px;"          + quebraLinha
      + octupleIndent  +     "text-indent: 15px each-line;"        + quebraLinha
      + octupleIndent  +     "text-align: justify;"                + quebraLinha
      + octupleIndent  +     "font-size: 14px;"                    + quebraLinha
      + sextupleIndent +   "}"                                     + quebraLinha
      + quebraLinha
      + sextupleIndent +   "div.title {"                           + quebraLinha
      + octupleIndent  +     "padding: 0px 0px 9px 0px;"           + quebraLinha
      + octupleIndent  +     "text-indent: 5px;"                   + quebraLinha
      + octupleIndent  +     "text-align: justify;"                + quebraLinha
      + octupleIndent  +     "font-size: 16px;"                    + quebraLinha
      + sextupleIndent +   "}"                                     + quebraLinha
      + quebraLinha
      + sextupleIndent +   "div.separarBorda {"                    + quebraLinha
      + octupleIndent  +     "padding: 10px 0px 10px 0px;"         + quebraLinha
      + octupleIndent  +     "text-align: justify;"                + quebraLinha
      + sextupleIndent +   "}"                                     + quebraLinha
      + quebraLinha
      + sextupleIndent +   "div.titlePS {"                         + quebraLinha
      + octupleIndent  +     "padding: 1px 1px 1px 1px;"           + quebraLinha
      + octupleIndent  +     "text-indent: 5px;"                   + quebraLinha
      + octupleIndent  +     "text-align: justify;"                + quebraLinha
      + octupleIndent  +     "font-size: 16px;"                    + quebraLinha
      + sextupleIndent +   "}"                                     + quebraLinha
      + quebraLinha
      + sextupleIndent +   "div.pagamento {"                       + quebraLinha
      + octupleIndent  +     "padding: 8px;"                       + quebraLinha
      + octupleIndent  +     "text-indent: 5px;"                   + quebraLinha
      + octupleIndent  +     "text-align: right;"                  + quebraLinha
      + octupleIndent  +     "font-size: 16px;"                    + quebraLinha
      + sextupleIndent +   "}";
    }
    
    public String getHTML(Orcamento orcamento) {
        String orcamentoHTML = ""
        + htmlTag                                                  + quebraLinha
        + getHeadHTML(orcamento.getCodigo())                       + quebraLinha
        + getBodyHTML(orcamento)                                   + quebraLinha       
        + htmlTagSlash;
        
        return orcamentoHTML;
    }
    
    private String getHeadHTML(int codigoOrcamento) {
        String head = empty
       + doubleIndent    + headTag                                 + quebraLinha
       + quadrupleIndent + charSet                                 + quebraLinha
       + quadrupleIndent + titleTag
       + "Orçamento_" + codigoOrcamento
                         + titleTagSlash                           + quebraLinha
       + quadrupleIndent + styleTag                                + quebraLinha
                         + styleContent                            + quebraLinha
       + quadrupleIndent + styleTagSlash                           + quebraLinha
       + doubleIndent    + headTagSlash;      
 
        return head;
    }
    
    private String getBodyHTML(Orcamento orcamento) {
        
        Config config = new ConfigDAO().read();
        
        NumberFormat moeda = NumberFormat.getCurrencyInstance(Locale.getDefault());
        
        BigDecimal totalValorProdutos = orcamento.getValorTotalProdutos();

        String valorTotalProdutos = moeda.format(totalValorProdutos);
        String listaProdutos = orcamento.listaProdutos();
        
        BigDecimal totalValorServicos = orcamento.getValorTotalServicos();

        String valorTotalServicos = moeda.format(totalValorServicos);
        String listaServicos = orcamento.listaServicos();

        String valorTotalOrcamento = moeda.format(totalValorProdutos.add(totalValorServicos));
        
        String body = ""
       + doubleIndent    + bodyTag                                 + quebraLinha
       + quadrupleIndent + divTagOriginal                          + quebraLinha
       + sextupleIndent  + centerTag + logoSource + centerTagSlash + quebraLinha
       + quadrupleIndent + divTagSlash                             + quebraLinha
                                                                   + quebraLinha
       + quadrupleIndent + initDivTagClass + "\"primeiro\"" + endDivTag + quebraLinha         
       + sextupleIndent + strongTag + "Endereço:" + strongTagSlash + tab1Tag + config.getAddress() + tab1TagSlash + breakTag + quebraLinha
       + sextupleIndent + strongTag + "Telefone(s):" + strongTagSlash + space + config.getCellphone() + space + space + space + space
       + strongTag + "Email:" + strongTagSlash + space + config.getEmail() + quebraLinha
       + quadrupleIndent + divTagSlash + quebraLinha         
                                                                   + quebraLinha
       + quadrupleIndent + initDivTagClass + "\"medio\"" + divTagId + "\"border\"" + endDivTag + quebraLinha
       + sextupleIndent + strongTag + "Número do Orçamento:" + strongTagSlash + space + space + space + space + space + space + space + space + orcamento.getCodigo() + breakTag + quebraLinha         
       + sextupleIndent + strongTag + "Data/Hora(Abertura):" + strongTagSlash + space + space + space + space + space + space + space + tab1Tag + orcamento.getDataHora() + tab1TagSlash + breakTag + quebraLinha
       + sextupleIndent + strongTag + "Vendedor(es) Responsável(eis):" + strongTagSlash + space + space + space + orcamento.getFuncionario().getCodigo() + " - " + orcamento.getFuncionario().getNome() + breakTag + quebraLinha      
       + quadrupleIndent + divTagSlash + quebraLinha
                                                                   + quebraLinha
       + quadrupleIndent + initDivTagClass + "\"separarBorda\"" + endDivTag + divTagSlash + quebraLinha
                                                                   + quebraLinha
       + quadrupleIndent + initDivTagClass + "\"medio\"" + divTagId + "\"border\"" + endDivTag + quebraLinha
       + sextupleIndent + strongTag + "Cliente:" + space + strongTagSlash + tab1Tag + orcamento.getCliente().getCodigo() + " - " + orcamento.getCliente().getNome() + tab1TagSlash + breakTag + quebraLinha
       + sextupleIndent + strongTag + "Telefone:" + space + space + space + strongTagSlash + orcamento.getCliente().getTelefone() + space + tab1Tag
       + strongTag + "Email: " + strongTagSlash + tab1TagSlash + space + orcamento.getCliente().getEmail() + breakTag + quebraLinha
       + sextupleIndent + strongTag + "Endereço: " + strongTagSlash + space + orcamento.getCliente().getEndereco() + quebraLinha
       + quadrupleIndent + divTagSlash + quebraLinha         
                                                                   + quebraLinha
       + quadrupleIndent + initDivTagClass + "\"separarBorda\"" + endDivTag + divTagSlash + quebraLinha
                                                                   + quebraLinha         
       + quadrupleIndent + initDivTagClass + "\"medio\"" + divTagId + "\"border\"" + endDivTag + quebraLinha         
       + sextupleIndent + strongTag + "Placa:" + strongTagSlash + tab1Tag + orcamento.getVeiculo().getPlaca() + tab1TagSlash + breakTag + quebraLinha     
       + sextupleIndent + strongTag + "Veículo:" + strongTagSlash + space + orcamento.getVeiculo().getDescricao() + breakTag + quebraLinha
       + sextupleIndent + strongTag + "KM:" + space + space + strongTagSlash + space + tab1Tag + orcamento.getVeiculo().getQuilometragem() + tab1TagSlash + space
       + tab1Tag + strongTag + "Combustível:" + strongTagSlash + tab1TagSlash + space + orcamento.getVeiculo().getCombustivel() + space
       + tab1Tag + strongTag + "Marcador:" + strongTagSlash + tab1TagSlash + space + orcamento.getVeiculo().getMarcador() + space
       + tab1Tag + strongTag + "Cor:" + strongTagSlash + tab1TagSlash + space + orcamento.getVeiculo().getCor() + quebraLinha
       + quadrupleIndent + divTagSlash + quebraLinha
                                                                   + quebraLinha
       + quadrupleIndent + initDivTagClass + "\"separarBorda\"" + endDivTag + divTagSlash + quebraLinha
                                                                   + quebraLinha          
       + quadrupleIndent + initDivTagClass + "\"title\"" + endDivTag + space         
       + strongTag + "Defeitos Apontados" + strongTagSlash + divTagSlash + quebraLinha
       + quadrupleIndent + initDivTagClass + "\"medio\"" + endDivTag
       + orcamento.getDefeitosApontados() + divTagSlash + quebraLinha         
                                                                   + quebraLinha
       + quadrupleIndent + initDivTagClass + "\"title\"" + endDivTag + space         
       + strongTag + "Observações" + strongTagSlash + divTagSlash + quebraLinha
       + quadrupleIndent + initDivTagClass + "\"medio\"" + endDivTag
       + orcamento.getObservacoes() + divTagSlash + quebraLinha         
                                                                   + quebraLinha         
       + quadrupleIndent + initDivTagClass + "\"titlePS\"" + divTagId + "\"bordersquare\"" + endDivTag + emTag + "Produtos" + emTagSlash + divTagSlash + quebraLinha
       + quadrupleIndent + initDivTagClass + "\"insidesquare\"" + divTagId + "\"bordersquare\"" + endDivTag + quebraLinha      
       + sextupleIndent + strongTag + "Código " + tab3Tag + "Descrição" + tab3TagSlash + space + tab30Tag + "Quantidade" + tab30TagSlash + tab2Tag + "Unidade" + tab2TagSlash + tab3Tag + "Total" + tab3TagSlash + strongTagSlash + quebraLinha       
       + quadrupleIndent + divTagSlash + quebraLinha
                                                                   + quebraLinha
       + quadrupleIndent + initDivTagClass + "\"pequeno\"" + endDivTag + quebraLinha
       + sextupleIndent + preTag + space + listaProdutos + preTagSlash + quebraLinha       
       + quadrupleIndent + divTagSlash + quebraLinha
                                                                   + quebraLinha
       + quadrupleIndent + initDivTagClass + "\"pagamento\"" + endDivTag + quebraLinha
       + sextupleIndent + strongTag + "Valor total dos produtos: " + valorTotalProdutos + strongTagSlash + quebraLinha         
       + quadrupleIndent + divTagSlash + quebraLinha         
                                                                   + quebraLinha
       + quadrupleIndent + initDivTagClass + "\"titlePS\"" + divTagId + "\"bordersquare\"" + endDivTag + emTag + "Serviços" + emTagSlash + divTagSlash + quebraLinha
       + quadrupleIndent + initDivTagClass + "\"insidesquare\"" + divTagId + "\"bordersquare\"" + endDivTag       
       + sextupleIndent + strongTag + "Código " + tab3Tag + "Descrição" + tab3TagSlash + space + tab30Tag + "Quantidade" + tab30TagSlash + tab2Tag + "Unidade" + tab2TagSlash + tab3Tag + "Total" + tab3TagSlash + strongTagSlash + quebraLinha       
       + quadrupleIndent + divTagSlash + quebraLinha                                                     
                                                                   + quebraLinha
       + quadrupleIndent + initDivTagClass + "\"pequeno\"" + endDivTag + quebraLinha
       + sextupleIndent + preTag + space + listaServicos + preTagSlash + quebraLinha       
       + quadrupleIndent + divTagSlash + quebraLinha         
                                                                   + quebraLinha
       + quadrupleIndent + initDivTagClass + "\"pagamento\"" + endDivTag + quebraLinha
       + sextupleIndent + strongTag + "Valor total dos servicos: " + valorTotalServicos + strongTagSlash + quebraLinha         
       + quadrupleIndent + divTagSlash + quebraLinha         
                                                                   + quebraLinha         
       + quadrupleIndent + initDivTagClass + "\"pagamento\"" + endDivTag + quebraLinha
       + sextupleIndent + strongTag + "Forma de pagamento: " + orcamento.getFormaPagamento() + strongTagSlash + breakTag + quebraLinha
       + sextupleIndent + strongTag + "Valor total do orçamento: " + valorTotalOrcamento + strongTagSlash + quebraLinha
       + quadrupleIndent + divTagSlash + quebraLinha         
                                                                   + quebraLinha
       + quadrupleIndent + initDivTagClass + "\"separarBorda\"" + endDivTag + divTagSlash + quebraLinha
                                                                   + quebraLinha
       + quadrupleIndent + initDivTagClass + "\"pagamento\"" + endDivTag + quebraLinha
       + sextupleIndent + "Assinatura do Cliente: __________________________" + quebraLinha        
       + quadrupleIndent + divTagSlash + quebraLinha
        
       + doubleIndent + bodyTagSlash;
        return body;
    }
}
