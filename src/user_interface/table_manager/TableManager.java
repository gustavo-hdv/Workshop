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

package user_interface.table_manager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableCellRenderer;
import model.bean.Cliente;
import model.bean.Funcionario;
import model.bean.Orcamento;
import model.bean.Produto;
import model.bean.Servico;
import model.bean.Veiculo;
import user_interface.MainFrame;
import user_interface.dialog.ClienteDialog;
import user_interface.dialog.FuncionarioDialog;
import user_interface.dialog.OrcamentoDialog;
import user_interface.dialog.ProdutoDialog;
import user_interface.dialog.ServicoDialog;
import user_interface.dialog.VeiculoDialog;
import user_interface.table_model.ClienteTableModel;
import user_interface.table_model.FuncionarioTableModel;
import user_interface.table_model.ProdutoTableModel;
import user_interface.table_model.ServicoTableModel;
import user_interface.table_model.VeiculoTableModel;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public class TableManager extends javax.swing.JDialog {

    private int userId;
    private Orcamento orcamento;
    private MainFrame mainFrame;
    private boolean orcamentoUpdateMode;
    
    /**
     * Creates new form TableManager
     * @param parent
     * @param modal
     */
    public TableManager(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        configure();
    }
    
    /**
     * Creates new form TableManager
     * @param userId
     * @param mainFrame
     * @param orcamento
     * @param parent
     * @param modal
     */
    public TableManager(int userId, MainFrame mainFrame, Orcamento orcamento, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.mainFrame = mainFrame;
        this.userId = userId;
        this.orcamento = orcamento;
        this.orcamentoUpdateMode = false;
        
        configure();
    }
    
    public void setOrcamentoUpdateMode(boolean orcamentoUpdateMode) {
        this.orcamentoUpdateMode = orcamentoUpdateMode;
    }
    
    private void configure() {
        dispose();
        setUndecorated(true);
        setDefaultCloseOperation(0);
        getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
    }
    
    public JTable getTable() {
        return table;
    }
    
    public void refreshViewClients(MainFrame mainFrame, JTable table) { 
        this.title.setText("Clientes");
        
        new TableView().refreshViewClients(mainFrame, table);
    }
    
    public void refreshViewEmployees(MainFrame mainFrame, JTable table) { 
        this.title.setText("Funcionários");
        
        new TableView().refreshViewEmployees(mainFrame, table);
    }
    
    public void refreshViewServices(MainFrame mainFrame, JTable table) { 
        this.title.setText("Serviços");
        
        new TableView().refreshViewServices(mainFrame, table);
    }
    
    public void refreshViewProducts(MainFrame mainFrame, JTable table) { 
        this.title.setText("Produtos");
        
        new TableView().refreshViewProducts(mainFrame, table);
    }
    
    public void refreshViewVehicles(MainFrame mainFrame, JTable table) { 
        this.title.setText("Veículos");
        
        new TableView().refreshViewVehicles(mainFrame, table);
    }
    
    // SP means services and products
    private void configureButtonsForCurrentSP() {
        this.createPanel.setVisible(false);
        this.searchPanel.setVisible(false);
        this.searchTextField.setVisible(false);
        
        this.selectPanel.setPreferredSize(new Dimension(100, 20));
        
        this.selectTextLabel.setText("REMOVER");
    }
    
    public void refreshCurrentServicesView(MainFrame mainFrame, JTable table, List<Servico> servicos) {
        this.title.setText("Serviços selecionados");
        configureButtonsForCurrentSP();
        
        ServicoTableModel model = new ServicoTableModel(servicos);
        table.setModel(model);
    }
    
    public void refreshCurrentProductsView(MainFrame mainFrame, JTable table, List<Produto> produtos) {
        this.title.setText("Produtos selecionados");
        configureButtonsForCurrentSP();
        
        ProdutoTableModel model = new ProdutoTableModel(produtos);
        table.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideBar = new javax.swing.JPanel();
        TopBar = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        searchTextLabel = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        createPanel = new javax.swing.JPanel();
        createTextLabel = new javax.swing.JLabel();
        cancelPanel = new javax.swing.JPanel();
        cancelTextLabel = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        blackBar = new javax.swing.JPanel();
        selectPanel = new javax.swing.JPanel();
        selectTextLabel = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(824, 600));
        setMinimumSize(new java.awt.Dimension(824, 600));
        setResizable(false);

        sideBar.setBackground(new java.awt.Color(255, 165, 0));
        sideBar.setForeground(new java.awt.Color(255, 165, 0));

        javax.swing.GroupLayout sideBarLayout = new javax.swing.GroupLayout(sideBar);
        sideBar.setLayout(sideBarLayout);
        sideBarLayout.setHorizontalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        sideBarLayout.setVerticalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        TopBar.setBackground(new java.awt.Color(211, 211, 211));
        TopBar.setForeground(new java.awt.Color(255, 165, 0));

        searchPanel.setBackground(new java.awt.Color(192, 192, 192));
        searchPanel.setForeground(new java.awt.Color(255, 165, 0));
        searchPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        searchPanel.setMinimumSize(new java.awt.Dimension(100, 30));
        searchPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                searchPanelMouseReleased(evt);
            }
        });

        searchTextLabel.setBackground(new java.awt.Color(192, 192, 192));
        searchTextLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchTextLabel.setForeground(new java.awt.Color(255, 140, 0));
        searchTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchTextLabel.setText("Buscar");
        searchTextLabel.setMaximumSize(new java.awt.Dimension(100, 30));
        searchTextLabel.setMinimumSize(new java.awt.Dimension(100, 30));
        searchTextLabel.setPreferredSize(new java.awt.Dimension(100, 30));

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchTextLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        searchTextField.setBackground(new java.awt.Color(255, 255, 255));
        searchTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchTextField.setForeground(new java.awt.Color(0, 0, 0));
        searchTextField.setMinimumSize(new java.awt.Dimension(100, 30));
        searchTextField.setPreferredSize(new java.awt.Dimension(100, 30));

        createPanel.setBackground(new java.awt.Color(192, 192, 192));
        createPanel.setForeground(new java.awt.Color(255, 165, 0));
        createPanel.setMinimumSize(new java.awt.Dimension(100, 30));
        createPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                createPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                createPanelMouseReleased(evt);
            }
        });

        createTextLabel.setBackground(new java.awt.Color(192, 192, 192));
        createTextLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        createTextLabel.setForeground(new java.awt.Color(255, 140, 0));
        createTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        createTextLabel.setText("Novo");
        createTextLabel.setMaximumSize(new java.awt.Dimension(100, 30));
        createTextLabel.setMinimumSize(new java.awt.Dimension(100, 30));
        createTextLabel.setPreferredSize(new java.awt.Dimension(100, 30));

        javax.swing.GroupLayout createPanelLayout = new javax.swing.GroupLayout(createPanel);
        createPanel.setLayout(createPanelLayout);
        createPanelLayout.setHorizontalGroup(
            createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(createTextLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        createPanelLayout.setVerticalGroup(
            createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(createTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        cancelPanel.setBackground(new java.awt.Color(192, 192, 192));
        cancelPanel.setForeground(new java.awt.Color(255, 165, 0));
        cancelPanel.setMinimumSize(new java.awt.Dimension(125, 30));
        cancelPanel.setPreferredSize(new java.awt.Dimension(125, 30));
        cancelPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelPanelMousePressed(evt);
            }
        });

        cancelTextLabel.setBackground(new java.awt.Color(192, 192, 192));
        cancelTextLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelTextLabel.setForeground(new java.awt.Color(255, 140, 0));
        cancelTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelTextLabel.setText("Voltar");

        javax.swing.GroupLayout cancelPanelLayout = new javax.swing.GroupLayout(cancelPanel);
        cancelPanel.setLayout(cancelPanelLayout);
        cancelPanelLayout.setHorizontalGroup(
            cancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cancelTextLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
        );
        cancelPanelLayout.setVerticalGroup(
            cancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cancelTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        title.setBackground(new java.awt.Color(211, 211, 211));
        title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 140, 0));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Table Name");

        blackBar.setBackground(new java.awt.Color(0, 0, 0));
        blackBar.setForeground(new java.awt.Color(0, 0, 0));
        blackBar.setMaximumSize(new java.awt.Dimension(600, 1));
        blackBar.setMinimumSize(new java.awt.Dimension(600, 1));

        javax.swing.GroupLayout blackBarLayout = new javax.swing.GroupLayout(blackBar);
        blackBar.setLayout(blackBarLayout);
        blackBarLayout.setHorizontalGroup(
            blackBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        blackBarLayout.setVerticalGroup(
            blackBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        selectPanel.setBackground(new java.awt.Color(192, 192, 192));
        selectPanel.setForeground(new java.awt.Color(255, 165, 0));
        selectPanel.setMinimumSize(new java.awt.Dimension(125, 30));
        selectPanel.setPreferredSize(new java.awt.Dimension(125, 30));
        selectPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selectPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                selectPanelMouseReleased(evt);
            }
        });

        selectTextLabel.setBackground(new java.awt.Color(192, 192, 192));
        selectTextLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        selectTextLabel.setForeground(new java.awt.Color(255, 140, 0));
        selectTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectTextLabel.setText("SELECIONAR");
        selectTextLabel.setMaximumSize(new java.awt.Dimension(125, 30));
        selectTextLabel.setMinimumSize(new java.awt.Dimension(125, 30));
        selectTextLabel.setPreferredSize(new java.awt.Dimension(125, 30));

        javax.swing.GroupLayout selectPanelLayout = new javax.swing.GroupLayout(selectPanel);
        selectPanel.setLayout(selectPanelLayout);
        selectPanelLayout.setHorizontalGroup(
            selectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectTextLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
        );
        selectPanelLayout.setVerticalGroup(
            selectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout TopBarLayout = new javax.swing.GroupLayout(TopBar);
        TopBar.setLayout(TopBarLayout);
        TopBarLayout.setHorizontalGroup(
            TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopBarLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(TopBarLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(createPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selectPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                        .addGap(96, 96, 96)
                        .addComponent(cancelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addComponent(blackBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        TopBarLayout.setVerticalGroup(
            TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopBarLayout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(blackBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane.setMinimumSize(new java.awt.Dimension(100, 502));
        jScrollPane.setPreferredSize(new java.awt.Dimension(100, 502));

        table.setBackground(new java.awt.Color(222, 222, 222));
        table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(192, 192, 192), 1, true));
        table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table.setForeground(new java.awt.Color(0, 0, 0));
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setRowHeight(25);
        table.setShowVerticalLines(false);
        table.setFont(new Font("Segoe UI", Font.TRUETYPE_FONT, 14));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        table.getTableHeader().setForeground(new Color(255,100,0));
        table.setSelectionBackground(new Color(211,211,211));
        table.setSelectionBackground(new Color(255,100,0));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.LEFT );
        table.setDefaultRenderer(Integer.class, centerRenderer);
        table.setDefaultRenderer(Double.class, centerRenderer);
        table.setDefaultRenderer(Float.class, centerRenderer);
        table.setDefaultRenderer(BigDecimal.class, centerRenderer);
        table.setModel(new javax.swing.table.DefaultTableModel(
        ));
        jScrollPane.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TopBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TopBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void back() {
        OrcamentoDialog dialog = new OrcamentoDialog(this.userId, this.mainFrame, this.orcamento, this.orcamentoUpdateMode, new javax.swing.JFrame(), true);
        pack();
        setLocationRelativeTo(this.mainFrame);
        
        dispose();
        
        dialog.setVisible(true);
    }
    
    private void cancelPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelPanelMouseClicked
        back();
    }//GEN-LAST:event_cancelPanelMouseClicked

    private void createPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createPanelMouseClicked
        switch (this.title.getText()) {
            case "Clientes":
                dispose();
                ClienteDialog clientDialog = new ClienteDialog(this.userId, this.mainFrame, null, false);
                clientDialog.setFromTableManager(true);
                clientDialog.setOrcamentoHolder(this.orcamento);
                clientDialog.setOrcamentoUpdateMode(this.orcamentoUpdateMode);
                break;
            case "Funcionários":
                dispose();
                FuncionarioDialog employeeDialog = new FuncionarioDialog(this.userId, this.mainFrame, null, false);
                employeeDialog.setFromTableManager(true);
                employeeDialog.setOrcamentoHolder(this.orcamento);
                employeeDialog.setOrcamentoUpdateMode(this.orcamentoUpdateMode);
                break;
            case "Serviços":
                dispose();
                ServicoDialog serviceDialog = new ServicoDialog(this.userId, this.mainFrame, null, false);
                serviceDialog.setFromTableManager(true);
                serviceDialog.setOrcamentoHolder(this.orcamento);
                serviceDialog.setOrcamentoUpdateMode(this.orcamentoUpdateMode);
                break;
            case "Produtos":
                dispose();
                ProdutoDialog productDialog = new ProdutoDialog(this.userId, this.mainFrame, null, false);
                productDialog.setFromTableManager(true);
                productDialog.setOrcamentoHolder(this.orcamento);
                productDialog.setOrcamentoUpdateMode(this.orcamentoUpdateMode);
                break;
            case "Veículos":
                dispose();
                VeiculoDialog vehicleDialog = new VeiculoDialog(this.userId, this.mainFrame, null, false);
                vehicleDialog.setFromTableManager(true);
                vehicleDialog.setOrcamentoHolder(this.orcamento);
                vehicleDialog.setOrcamentoUpdateMode(this.orcamentoUpdateMode);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_createPanelMouseClicked

    private void searchPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchPanelMouseClicked
        refreshGeneralView(this.title.getText(), this.searchTextField.getText());
    }//GEN-LAST:event_searchPanelMouseClicked

    private void searchPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchPanelMouseEntered
        searchPanel.setBackground(new Color(255,69,0));
        searchTextLabel.setForeground(new Color(255,160,122));
    }//GEN-LAST:event_searchPanelMouseEntered

    private void searchPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchPanelMouseExited
        searchPanel.setBackground(new Color(192,192,192));
        searchTextLabel.setForeground(new Color(255,140,0));
    }//GEN-LAST:event_searchPanelMouseExited

    private void searchPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchPanelMousePressed
        searchPanel.setBackground(Color.BLACK);
        searchTextLabel.setForeground(new Color(255,140,0));
    }//GEN-LAST:event_searchPanelMousePressed

    private void searchPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchPanelMouseReleased
        searchPanel.setBackground(new Color(255,69,0));
        searchTextLabel.setForeground(new Color(255,160,122));
    }//GEN-LAST:event_searchPanelMouseReleased

    private void createPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createPanelMouseEntered
        createPanel.setBackground(new Color(255,69,0));
        createTextLabel.setForeground(new Color(255,160,122));
    }//GEN-LAST:event_createPanelMouseEntered

    private void createPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createPanelMouseExited
        createPanel.setBackground(new Color(192,192,192));
        createTextLabel.setForeground(new Color(255,140,0));
    }//GEN-LAST:event_createPanelMouseExited

    private void createPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createPanelMousePressed
        createPanel.setBackground(Color.BLACK);
        createTextLabel.setForeground(new Color(255,140,0));
    }//GEN-LAST:event_createPanelMousePressed

    private void createPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createPanelMouseReleased
        createPanel.setBackground(new Color(255,69,0));
        createTextLabel.setForeground(new Color(255,160,122));
    }//GEN-LAST:event_createPanelMouseReleased

    private void cancelPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelPanelMouseEntered
        cancelPanel.setBackground(new Color(255,69,0));
        cancelTextLabel.setForeground(new Color(255,160,122));
    }//GEN-LAST:event_cancelPanelMouseEntered

    private void cancelPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelPanelMouseExited
        cancelPanel.setBackground(new Color(192,192,192));
        cancelTextLabel.setForeground(new Color(255,140,0));
    }//GEN-LAST:event_cancelPanelMouseExited

    private void cancelPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelPanelMousePressed
        cancelPanel.setBackground(Color.BLACK);
        cancelTextLabel.setForeground(new Color(255,140,0));
    }//GEN-LAST:event_cancelPanelMousePressed

    private void cancelPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelPanelMouseReleased
        cancelPanel.setBackground(new Color(255,69,0));
        cancelTextLabel.setForeground(new Color(255,160,122));
    }//GEN-LAST:event_cancelPanelMouseReleased

    private void selectPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectPanelMouseClicked
    switch (this.title.getText()) {
            case "Clientes":
                int clientRow = table.getSelectedRow();
                
                if (clientRow < 0) {
                    JOptionPane.showMessageDialog(TableManager.this, "Cliente não selecionado", "Error", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Cliente não selecionado");
                    return;
                }

                Cliente tempCliente = (Cliente) table.getValueAt(clientRow, ClienteTableModel.OBJECT_COL);

                this.orcamento.setCliente(tempCliente);
                back();
                break;
            case "Produtos":
                int productRow = table.getSelectedRow();
                
                if (productRow < 0) {
                    JOptionPane.showMessageDialog(TableManager.this, "Produto não selecionado", "Error", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Produto não selecionado");
                    return;
                }

                Produto tempProduto = (Produto) table.getValueAt(productRow, ProdutoTableModel.OBJECT_COL);
                this.orcamento.adicionaProduto(tempProduto);
                back();
                break;
            case "Produtos selecionados":
                int currentProductRow = table.getSelectedRow();
                
                if (currentProductRow < 0) {
                    JOptionPane.showMessageDialog(TableManager.this, "Produto não selecionado", "Error", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Produto não selecionado");
                    return;
                }

                Produto currentProduct = (Produto) table.getValueAt(currentProductRow, ProdutoTableModel.OBJECT_COL);
                this.orcamento.getProdutos().remove(currentProduct);
                back();
                break;
            case "Serviços":
                int serviceRow = table.getSelectedRow();
                
                if (serviceRow < 0) {
                    JOptionPane.showMessageDialog(TableManager.this, "Serviço não selecionado", "Error", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Serviço não selecionado");
                    return;
                }

                Servico tempService = (Servico) table.getValueAt(serviceRow, ServicoTableModel.OBJECT_COL);
                this.orcamento.adicionaServico(tempService);
                back();
                break;
            case "Serviços selecionados":
                int currentServiceRow = table.getSelectedRow();
                
                if (currentServiceRow < 0) {
                    JOptionPane.showMessageDialog(TableManager.this, "Serviço não selecionado", "Error", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Serviço não selecionado");
                    return;
                }

                Servico currentService = (Servico) table.getValueAt(currentServiceRow, ServicoTableModel.OBJECT_COL);
                this.orcamento.getServicos().remove(currentService);
                back();
                break;
            case "Veículos":
                int vehicleRow = table.getSelectedRow();
                
                if (vehicleRow < 0) {
                    JOptionPane.showMessageDialog(TableManager.this, "Veículo não selecionado", "Error", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Veículo não selecionado");
                    return;
                }

                Veiculo tempVehicle = (Veiculo) table.getValueAt(vehicleRow, VeiculoTableModel.OBJECT_COL);
                this.orcamento.setVeiculo(tempVehicle);
                back();
                break;
            case "Funcionários":
                int employeeRow = table.getSelectedRow();
                
                if (employeeRow < 0) {
                    JOptionPane.showMessageDialog(TableManager.this, "Funcionário não selecionado", "Error", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Funcionário não selecionado");
                    return;
                }

                Funcionario tempEmployee = (Funcionario) table.getValueAt(employeeRow, FuncionarioTableModel.OBJECT_COL);
                this.orcamento.setFuncionario(tempEmployee);
                back();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_selectPanelMouseClicked

    private void selectPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectPanelMouseEntered
        selectPanel.setBackground(new Color(255,69,0));
        selectTextLabel.setForeground(new Color(255,160,122));
    }//GEN-LAST:event_selectPanelMouseEntered

    private void selectPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectPanelMouseExited
        selectPanel.setBackground(new Color(192,192,192));
        selectTextLabel.setForeground(new Color(255,140,0));
    }//GEN-LAST:event_selectPanelMouseExited

    private void selectPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectPanelMousePressed
        selectPanel.setBackground(Color.BLACK);
        selectTextLabel.setForeground(new Color(255,140,0));
    }//GEN-LAST:event_selectPanelMousePressed

    private void selectPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectPanelMouseReleased
        selectPanel.setBackground(new Color(255,69,0));
        selectTextLabel.setForeground(new Color(255,160,122));
    }//GEN-LAST:event_selectPanelMouseReleased

    public void refreshGeneralView(String object, String like) {
        TableView tableView = new TableView();
        switch (object) {
            case "Clientes":
                tableView.searchViewClients(this, table, like);
                break;
            case "Funcionários":
                tableView.searchViewEmployees(this, table, like);
                break;
            case "Serviços":
                tableView.searchViewServices(this, table, like);
                break;
            case "Produtos":
                tableView.searchViewProducts(this, table, like);
                break;
            case "Veículos":
                tableView.searchViewVehicles(this, table, like);
                break;
            default:
                break;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TableManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TableManager dialog = new TableManager(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TopBar;
    private javax.swing.JPanel blackBar;
    private javax.swing.JPanel cancelPanel;
    private javax.swing.JLabel cancelTextLabel;
    private javax.swing.JPanel createPanel;
    private javax.swing.JLabel createTextLabel;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JLabel searchTextLabel;
    private javax.swing.JPanel selectPanel;
    private javax.swing.JLabel selectTextLabel;
    private javax.swing.JPanel sideBar;
    private javax.swing.JTable table;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
