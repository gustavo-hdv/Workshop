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

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import model.bean.Orcamento;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class HTMLtoPRINT {
 
    private Orcamento orcamento;
    private String currentPath;
    
    public HTMLtoPRINT(Orcamento orcamento) {
        this.orcamento = orcamento;
        this.currentPath = System.getProperty("user.dir");
    }
    
    public void generateHTML() {
        File file = new File(currentPath + "\\HTMLs");
        file.mkdir();
        file = new File(currentPath + "\\LOGO");
        file.mkdir();
        file = new File(currentPath + "\\PDFs");
        file.mkdir();
        try {
            File orcamentoHTML = new File(currentPath + "\\HTMLs\\Orçamento_" + orcamento.getCodigo() + ".html");
            if (orcamentoHTML.createNewFile()) {
                System.out.println("File created: " + orcamentoHTML.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
        
        try {
            Writer writer = new OutputStreamWriter(new FileOutputStream(currentPath + "\\HTMLs\\Orçamento_" + orcamento.getCodigo() + ".html"), StandardCharsets.UTF_8);
            writer.write(new GenerateHTML().getHTML(orcamento));
            writer.close();
            System.out.println("Successfully wrote to the file.");
            
            File orcamentoHTML = new File(currentPath + "\\HTMLs\\Orçamento_" + orcamento.getCodigo() + ".html");
            
             Desktop desktop = Desktop.getDesktop();
            
            if (desktop.isSupported(Desktop.Action.OPEN) && orcamentoHTML.exists()) {
                desktop.open(orcamentoHTML);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
