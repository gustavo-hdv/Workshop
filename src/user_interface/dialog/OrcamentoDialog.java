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
package user_interface.dialog;

import java.awt.Color;
import java.awt.HeadlessException;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import model.bean.Orcamento;
import model.dao.OrcamentoDAO;
import user_interface.MainFrame;
import user_interface.table_manager.TableManager;

/**
 *
 * @author Gustavo H. D. Ventura
 */
public final class OrcamentoDialog extends javax.swing.JDialog {

    private Orcamento orcamento;
    private MainFrame mainFrame;
    private boolean updateMode;
    private int userId;
    
    /**
     * Creates new form OrcamentoDialog
     * @param parent
     * @param modal
     */
    public OrcamentoDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        configure();
    }
    
    public OrcamentoDialog(int userId, MainFrame mainFrame, Orcamento orcamento, boolean updateMode, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.userId = userId;
        this.mainFrame = mainFrame;
        this.orcamento = orcamento;
        this.updateMode = updateMode;
        configure();
        
        setAttributes();
    }
    
    private void setAttributes() {
        if (orcamento.getCliente() != null) {
            this.clientNameTextLabel.setText(orcamento.getCliente().getNome());
            
            this.clientNamePanel.setBackground(new Color(0,100,0));
            this.clientNameTextLabel.setForeground(new Color(50,205,50));
        }
        
        if (orcamento.getVeiculo() != null) {
            if (orcamento.getVeiculo().getPlaca() != null && !orcamento.getVeiculo().getPlaca().trim().equals("")) {
                this.vehicleIdentificationLabel.setText(orcamento.getVeiculo().getPlaca());
                this.vehicleIdentificationPanel.setBackground(new Color(0,100,0));
                this.vehicleIdentificationLabel.setForeground(new Color(50,205,50));
            } else {
                this.vehicleIdentificationLabel.setText(orcamento.getVeiculo().getDescricao());
                this.vehicleIdentificationPanel.setBackground(new Color(0,100,0));
                this.vehicleIdentificationLabel.setForeground(new Color(50,205,50));
            }  
        }
        NumberFormat moeda = NumberFormat.getCurrencyInstance(Locale.getDefault());
        if (orcamento.getFuncionario() != null) {
            this.employeeNameTextLabel.setText(orcamento.getFuncionario().getNome());
            
            this.employeeNamePanel.setBackground(new Color(0,100,0));
            this.employeeNameTextLabel.setForeground(new Color(50,205,50));
        }
        
        if (!orcamento.getServicos().isEmpty()) {
            this.servicesTotalPriceTextLabel.setText(moeda.format(orcamento.getValorTotalServicos()));
            
            this.servicesTotalPricePanel.setBackground(new Color(0,100,0));
            this.servicesTotalPriceTextLabel.setForeground(new Color(50,205,50));
        }
        
        if (!orcamento.getProdutos().isEmpty()) {
            this.productsTotalPriceTextLabel.setText(moeda.format(orcamento.getValorTotalProdutos()));
            
            this.productsTotalPricePanel.setBackground(new Color(0,100,0));
            this.productsTotalPriceTextLabel.setForeground(new Color(50,205,50));
        }
        
        if (orcamento.getDefeitosApontados() != null && !orcamento.getDefeitosApontados().trim().equals("")) {
            this.defeitosApontadosTextField.setText(orcamento.getDefeitosApontados());
        }
        
        if (orcamento.getObservacoes() != null && !orcamento.getObservacoes().trim().equals("")) {
            this.observacoesTextField.setText(orcamento.getObservacoes());
        }
        
        if (orcamento.getFormaPagamento() != null && !orcamento.getFormaPagamento().trim().equals("")) {
            this.formaPagamentoTextField.setText(orcamento.getFormaPagamento());
        }
    }
    
    //DOF means DefeitosApontados, Observações and FormaPagamento
    public void setOrcamentoDOF() {
        this.orcamento.setDefeitosApontados(this.defeitosApontadosTextField.getText());
        this.orcamento.setObservacoes(this.observacoesTextField.getText());
        this.orcamento.setFormaPagamento(this.formaPagamentoTextField.getText());
    }
    
    public void configure() {
        dispose();
        setUndecorated(true);
        setDefaultCloseOperation(0);
        getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        
        pack();
        setLocationRelativeTo(this.mainFrame);
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
        titleBar = new javax.swing.JPanel();
        titleTextLabel = new javax.swing.JLabel();
        clientPanel = new javax.swing.JPanel();
        clientTitlePanel = new javax.swing.JPanel();
        clientTitleTextLabel = new javax.swing.JLabel();
        clientNamePanel = new javax.swing.JPanel();
        clientNameTextLabel = new javax.swing.JLabel();
        selectClientPanel = new javax.swing.JPanel();
        selectClientTextLabel = new javax.swing.JLabel();
        vehiclePanel = new javax.swing.JPanel();
        vehicleTitlePanel = new javax.swing.JPanel();
        vehicleTitleTextLabel = new javax.swing.JLabel();
        vehicleIdentificationPanel = new javax.swing.JPanel();
        vehicleIdentificationLabel = new javax.swing.JLabel();
        selectVehiclePanel = new javax.swing.JPanel();
        selectVehicleTextLabel = new javax.swing.JLabel();
        employeePanel = new javax.swing.JPanel();
        employeeTitlePanel = new javax.swing.JPanel();
        employeeTitleTextLabel = new javax.swing.JLabel();
        employeeNamePanel = new javax.swing.JPanel();
        employeeNameTextLabel = new javax.swing.JLabel();
        selectEmployeePanel = new javax.swing.JPanel();
        selectEmployeeTextLabel = new javax.swing.JLabel();
        servicesPanel = new javax.swing.JPanel();
        servicesTitlePanel = new javax.swing.JPanel();
        servicesTitleTextLabel = new javax.swing.JLabel();
        servicesTotalPricePanel = new javax.swing.JPanel();
        servicesTotalPriceTextLabel = new javax.swing.JLabel();
        selectedServicesPanel = new javax.swing.JPanel();
        selectedServicesTextLabel = new javax.swing.JLabel();
        selectServicePanel = new javax.swing.JPanel();
        selectServiceTextLabel = new javax.swing.JLabel();
        productsPanel = new javax.swing.JPanel();
        productsTitlePanel = new javax.swing.JPanel();
        productsTitleTextLabel = new javax.swing.JLabel();
        productsTotalPricePanel = new javax.swing.JPanel();
        productsTotalPriceTextLabel = new javax.swing.JLabel();
        selectedProductsPanel = new javax.swing.JPanel();
        selectedProductsTextLabel = new javax.swing.JLabel();
        selectProductPanel = new javax.swing.JPanel();
        selectProductTextLabel = new javax.swing.JLabel();
        midPanel = new javax.swing.JPanel();
        defeitosApontadosPanel = new javax.swing.JPanel();
        defeitosApontadosTextField = new javax.swing.JTextField();
        defeitosApontadosTitleLabel = new javax.swing.JLabel();
        observacoesPanel = new javax.swing.JPanel();
        observacoesTextField = new javax.swing.JTextField();
        observacoesTitleLabel = new javax.swing.JLabel();
        formaPagamentoPanel = new javax.swing.JPanel();
        formaPagamentoTextField = new javax.swing.JTextField();
        formaPagamentoTitleLabel = new javax.swing.JLabel();
        cancelPanel = new javax.swing.JPanel();
        cancelTextLabel = new javax.swing.JLabel();
        confirmPanel = new javax.swing.JPanel();
        confirmTextLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerando orçamento");
        setBackground(new java.awt.Color(211, 211, 211));
        setMaximumSize(new java.awt.Dimension(858, 680));
        setMinimumSize(new java.awt.Dimension(858, 680));
        setResizable(false);

        sideBar.setBackground(new java.awt.Color(255, 140, 0));
        sideBar.setForeground(new java.awt.Color(255, 140, 0));
        sideBar.setPreferredSize(new java.awt.Dimension(100, 700));

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

        titleBar.setBackground(new java.awt.Color(211, 211, 211));
        titleBar.setForeground(new java.awt.Color(255, 69, 0));

        titleTextLabel.setBackground(new java.awt.Color(211, 211, 211));
        titleTextLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleTextLabel.setForeground(new java.awt.Color(255, 69, 0));
        titleTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleTextLabel.setText("Gerando Orçamento");

        javax.swing.GroupLayout titleBarLayout = new javax.swing.GroupLayout(titleBar);
        titleBar.setLayout(titleBarLayout);
        titleBarLayout.setHorizontalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        titleBarLayout.setVerticalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addContainerGap())
        );

        clientPanel.setBackground(new java.awt.Color(176, 196, 222));

        clientTitlePanel.setBackground(new java.awt.Color(255, 140, 0));
        clientTitlePanel.setForeground(new java.awt.Color(255, 140, 0));
        clientTitlePanel.setPreferredSize(new java.awt.Dimension(176, 30));

        clientTitleTextLabel.setBackground(new java.awt.Color(255, 140, 0));
        clientTitleTextLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clientTitleTextLabel.setForeground(new java.awt.Color(0, 0, 0));
        clientTitleTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clientTitleTextLabel.setText("Cliente");

        javax.swing.GroupLayout clientTitlePanelLayout = new javax.swing.GroupLayout(clientTitlePanel);
        clientTitlePanel.setLayout(clientTitlePanelLayout);
        clientTitlePanelLayout.setHorizontalGroup(
            clientTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clientTitleTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        clientTitlePanelLayout.setVerticalGroup(
            clientTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clientTitleTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        clientNamePanel.setBackground(new java.awt.Color(139, 0, 0));
        clientNamePanel.setPreferredSize(new java.awt.Dimension(176, 30));

        clientNameTextLabel.setBackground(new java.awt.Color(139, 0, 0));
        clientNameTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clientNameTextLabel.setForeground(new java.awt.Color(255, 255, 255));
        clientNameTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clientNameTextLabel.setText("Não selecionado");

        javax.swing.GroupLayout clientNamePanelLayout = new javax.swing.GroupLayout(clientNamePanel);
        clientNamePanel.setLayout(clientNamePanelLayout);
        clientNamePanelLayout.setHorizontalGroup(
            clientNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clientNameTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        clientNamePanelLayout.setVerticalGroup(
            clientNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clientNameTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        selectClientPanel.setBackground(new java.awt.Color(211, 211, 211));
        selectClientPanel.setPreferredSize(new java.awt.Dimension(176, 30));
        selectClientPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectClientPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectClientPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selectClientPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectClientPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                selectClientPanelMouseReleased(evt);
            }
        });

        selectClientTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectClientTextLabel.setForeground(new java.awt.Color(0, 0, 0));
        selectClientTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectClientTextLabel.setText("Selecionar");

        javax.swing.GroupLayout selectClientPanelLayout = new javax.swing.GroupLayout(selectClientPanel);
        selectClientPanel.setLayout(selectClientPanelLayout);
        selectClientPanelLayout.setHorizontalGroup(
            selectClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectClientTextLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        selectClientPanelLayout.setVerticalGroup(
            selectClientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectClientTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout clientPanelLayout = new javax.swing.GroupLayout(clientPanel);
        clientPanel.setLayout(clientPanelLayout);
        clientPanelLayout.setHorizontalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clientNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(clientPanelLayout.createSequentialGroup()
                        .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clientTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectClientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        clientPanelLayout.setVerticalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clientTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clientNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(selectClientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        vehiclePanel.setBackground(new java.awt.Color(176, 196, 222));

        vehicleTitlePanel.setBackground(new java.awt.Color(255, 140, 0));
        vehicleTitlePanel.setForeground(new java.awt.Color(255, 140, 0));
        vehicleTitlePanel.setPreferredSize(new java.awt.Dimension(176, 30));

        vehicleTitleTextLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        vehicleTitleTextLabel.setForeground(new java.awt.Color(0, 0, 0));
        vehicleTitleTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vehicleTitleTextLabel.setText("Veículo");

        javax.swing.GroupLayout vehicleTitlePanelLayout = new javax.swing.GroupLayout(vehicleTitlePanel);
        vehicleTitlePanel.setLayout(vehicleTitlePanelLayout);
        vehicleTitlePanelLayout.setHorizontalGroup(
            vehicleTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vehicleTitleTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        vehicleTitlePanelLayout.setVerticalGroup(
            vehicleTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vehicleTitleTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        vehicleIdentificationPanel.setBackground(new java.awt.Color(139, 0, 0));
        vehicleIdentificationPanel.setPreferredSize(new java.awt.Dimension(176, 30));

        vehicleIdentificationLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        vehicleIdentificationLabel.setForeground(new java.awt.Color(255, 255, 255));
        vehicleIdentificationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vehicleIdentificationLabel.setText("Não selecionado");
        vehicleIdentificationLabel.setPreferredSize(new java.awt.Dimension(176, 30));

        javax.swing.GroupLayout vehicleIdentificationPanelLayout = new javax.swing.GroupLayout(vehicleIdentificationPanel);
        vehicleIdentificationPanel.setLayout(vehicleIdentificationPanelLayout);
        vehicleIdentificationPanelLayout.setHorizontalGroup(
            vehicleIdentificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vehicleIdentificationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        vehicleIdentificationPanelLayout.setVerticalGroup(
            vehicleIdentificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vehicleIdentificationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        selectVehiclePanel.setBackground(new java.awt.Color(211, 211, 211));
        selectVehiclePanel.setPreferredSize(new java.awt.Dimension(176, 30));
        selectVehiclePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectVehiclePanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectVehiclePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selectVehiclePanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectVehiclePanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                selectVehiclePanelMouseReleased(evt);
            }
        });

        selectVehicleTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectVehicleTextLabel.setForeground(new java.awt.Color(0, 0, 0));
        selectVehicleTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectVehicleTextLabel.setText("Selecionar");

        javax.swing.GroupLayout selectVehiclePanelLayout = new javax.swing.GroupLayout(selectVehiclePanel);
        selectVehiclePanel.setLayout(selectVehiclePanelLayout);
        selectVehiclePanelLayout.setHorizontalGroup(
            selectVehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectVehicleTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        selectVehiclePanelLayout.setVerticalGroup(
            selectVehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectVehicleTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout vehiclePanelLayout = new javax.swing.GroupLayout(vehiclePanel);
        vehiclePanel.setLayout(vehiclePanelLayout);
        vehiclePanelLayout.setHorizontalGroup(
            vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vehiclePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vehiclePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(vehicleIdentificationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(vehiclePanelLayout.createSequentialGroup()
                        .addGroup(vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vehicleTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectVehiclePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        vehiclePanelLayout.setVerticalGroup(
            vehiclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vehiclePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vehicleTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vehicleIdentificationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectVehiclePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        employeePanel.setBackground(new java.awt.Color(176, 196, 222));

        employeeTitlePanel.setBackground(new java.awt.Color(255, 140, 0));
        employeeTitlePanel.setForeground(new java.awt.Color(255, 140, 0));
        employeeTitlePanel.setPreferredSize(new java.awt.Dimension(176, 30));

        employeeTitleTextLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeTitleTextLabel.setForeground(new java.awt.Color(0, 0, 0));
        employeeTitleTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        employeeTitleTextLabel.setText("Funcionário");

        javax.swing.GroupLayout employeeTitlePanelLayout = new javax.swing.GroupLayout(employeeTitlePanel);
        employeeTitlePanel.setLayout(employeeTitlePanelLayout);
        employeeTitlePanelLayout.setHorizontalGroup(
            employeeTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(employeeTitleTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        employeeTitlePanelLayout.setVerticalGroup(
            employeeTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(employeeTitleTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        employeeNamePanel.setBackground(new java.awt.Color(139, 0, 0));
        employeeNamePanel.setPreferredSize(new java.awt.Dimension(176, 30));

        employeeNameTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        employeeNameTextLabel.setForeground(new java.awt.Color(255, 255, 255));
        employeeNameTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        employeeNameTextLabel.setText("Não selecionado");

        javax.swing.GroupLayout employeeNamePanelLayout = new javax.swing.GroupLayout(employeeNamePanel);
        employeeNamePanel.setLayout(employeeNamePanelLayout);
        employeeNamePanelLayout.setHorizontalGroup(
            employeeNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(employeeNameTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        employeeNamePanelLayout.setVerticalGroup(
            employeeNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(employeeNameTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        selectEmployeePanel.setBackground(new java.awt.Color(211, 211, 211));
        selectEmployeePanel.setPreferredSize(new java.awt.Dimension(176, 30));
        selectEmployeePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectEmployeePanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectEmployeePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selectEmployeePanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectEmployeePanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                selectEmployeePanelMouseReleased(evt);
            }
        });

        selectEmployeeTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectEmployeeTextLabel.setForeground(new java.awt.Color(0, 0, 0));
        selectEmployeeTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectEmployeeTextLabel.setText("Selecionar");

        javax.swing.GroupLayout selectEmployeePanelLayout = new javax.swing.GroupLayout(selectEmployeePanel);
        selectEmployeePanel.setLayout(selectEmployeePanelLayout);
        selectEmployeePanelLayout.setHorizontalGroup(
            selectEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectEmployeeTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        selectEmployeePanelLayout.setVerticalGroup(
            selectEmployeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectEmployeeTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout employeePanelLayout = new javax.swing.GroupLayout(employeePanel);
        employeePanel.setLayout(employeePanelLayout);
        employeePanelLayout.setHorizontalGroup(
            employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(employeeNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(employeePanelLayout.createSequentialGroup()
                        .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeeTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectEmployeePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        employeePanelLayout.setVerticalGroup(
            employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(employeeTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(employeeNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectEmployeePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        servicesPanel.setBackground(new java.awt.Color(176, 196, 222));

        servicesTitlePanel.setBackground(new java.awt.Color(255, 140, 0));
        servicesTitlePanel.setForeground(new java.awt.Color(255, 140, 0));
        servicesTitlePanel.setPreferredSize(new java.awt.Dimension(176, 30));

        servicesTitleTextLabel.setBackground(new java.awt.Color(255, 140, 0));
        servicesTitleTextLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        servicesTitleTextLabel.setForeground(new java.awt.Color(0, 0, 0));
        servicesTitleTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        servicesTitleTextLabel.setText("Serviços");

        javax.swing.GroupLayout servicesTitlePanelLayout = new javax.swing.GroupLayout(servicesTitlePanel);
        servicesTitlePanel.setLayout(servicesTitlePanelLayout);
        servicesTitlePanelLayout.setHorizontalGroup(
            servicesTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(servicesTitleTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        servicesTitlePanelLayout.setVerticalGroup(
            servicesTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(servicesTitleTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        servicesTotalPricePanel.setBackground(new java.awt.Color(139, 0, 0));
        servicesTotalPricePanel.setPreferredSize(new java.awt.Dimension(176, 30));

        servicesTotalPriceTextLabel.setBackground(new java.awt.Color(139, 0, 0));
        servicesTotalPriceTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        servicesTotalPriceTextLabel.setForeground(new java.awt.Color(255, 255, 255));
        servicesTotalPriceTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        servicesTotalPriceTextLabel.setText("Não selecionado");

        javax.swing.GroupLayout servicesTotalPricePanelLayout = new javax.swing.GroupLayout(servicesTotalPricePanel);
        servicesTotalPricePanel.setLayout(servicesTotalPricePanelLayout);
        servicesTotalPricePanelLayout.setHorizontalGroup(
            servicesTotalPricePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(servicesTotalPriceTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        servicesTotalPricePanelLayout.setVerticalGroup(
            servicesTotalPricePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(servicesTotalPriceTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        selectedServicesPanel.setBackground(new java.awt.Color(211, 211, 211));
        selectedServicesPanel.setPreferredSize(new java.awt.Dimension(176, 30));
        selectedServicesPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedServicesPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectedServicesPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selectedServicesPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectedServicesPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                selectedServicesPanelMouseReleased(evt);
            }
        });

        selectedServicesTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectedServicesTextLabel.setForeground(new java.awt.Color(0, 0, 0));
        selectedServicesTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectedServicesTextLabel.setText("Ver selecionados");

        javax.swing.GroupLayout selectedServicesPanelLayout = new javax.swing.GroupLayout(selectedServicesPanel);
        selectedServicesPanel.setLayout(selectedServicesPanelLayout);
        selectedServicesPanelLayout.setHorizontalGroup(
            selectedServicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectedServicesTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        selectedServicesPanelLayout.setVerticalGroup(
            selectedServicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectedServicesTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        selectServicePanel.setBackground(new java.awt.Color(211, 211, 211));
        selectServicePanel.setPreferredSize(new java.awt.Dimension(176, 30));
        selectServicePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectServicePanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectServicePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selectServicePanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectServicePanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                selectServicePanelMouseReleased(evt);
            }
        });

        selectServiceTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectServiceTextLabel.setForeground(new java.awt.Color(0, 0, 0));
        selectServiceTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectServiceTextLabel.setText("Selecionar");

        javax.swing.GroupLayout selectServicePanelLayout = new javax.swing.GroupLayout(selectServicePanel);
        selectServicePanel.setLayout(selectServicePanelLayout);
        selectServicePanelLayout.setHorizontalGroup(
            selectServicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectServiceTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        selectServicePanelLayout.setVerticalGroup(
            selectServicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectServiceTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout servicesPanelLayout = new javax.swing.GroupLayout(servicesPanel);
        servicesPanel.setLayout(servicesPanelLayout);
        servicesPanelLayout.setHorizontalGroup(
            servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(servicesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(servicesPanelLayout.createSequentialGroup()
                        .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(servicesTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectedServicesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, servicesPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(servicesTotalPricePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectServicePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        servicesPanelLayout.setVerticalGroup(
            servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(servicesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(servicesTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(servicesTotalPricePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectServicePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectedServicesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        productsPanel.setBackground(new java.awt.Color(176, 196, 222));

        productsTitlePanel.setBackground(new java.awt.Color(255, 140, 0));
        productsTitlePanel.setForeground(new java.awt.Color(255, 140, 0));
        productsTitlePanel.setPreferredSize(new java.awt.Dimension(176, 30));

        productsTitleTextLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        productsTitleTextLabel.setForeground(new java.awt.Color(0, 0, 0));
        productsTitleTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productsTitleTextLabel.setText("Produtos");

        javax.swing.GroupLayout productsTitlePanelLayout = new javax.swing.GroupLayout(productsTitlePanel);
        productsTitlePanel.setLayout(productsTitlePanelLayout);
        productsTitlePanelLayout.setHorizontalGroup(
            productsTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productsTitleTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        productsTitlePanelLayout.setVerticalGroup(
            productsTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productsTitleTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        productsTotalPricePanel.setBackground(new java.awt.Color(139, 0, 0));
        productsTotalPricePanel.setPreferredSize(new java.awt.Dimension(176, 30));

        productsTotalPriceTextLabel.setBackground(new java.awt.Color(139, 0, 0));
        productsTotalPriceTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        productsTotalPriceTextLabel.setForeground(new java.awt.Color(255, 255, 255));
        productsTotalPriceTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productsTotalPriceTextLabel.setText("Não selecionado");

        javax.swing.GroupLayout productsTotalPricePanelLayout = new javax.swing.GroupLayout(productsTotalPricePanel);
        productsTotalPricePanel.setLayout(productsTotalPricePanelLayout);
        productsTotalPricePanelLayout.setHorizontalGroup(
            productsTotalPricePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productsTotalPriceTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        productsTotalPricePanelLayout.setVerticalGroup(
            productsTotalPricePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productsTotalPriceTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        selectedProductsPanel.setBackground(new java.awt.Color(211, 211, 211));
        selectedProductsPanel.setPreferredSize(new java.awt.Dimension(176, 30));
        selectedProductsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedProductsPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectedProductsPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selectedProductsPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectedProductsPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                selectedProductsPanelMouseReleased(evt);
            }
        });

        selectedProductsTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectedProductsTextLabel.setForeground(new java.awt.Color(0, 0, 0));
        selectedProductsTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectedProductsTextLabel.setText("Ver selecionados");

        javax.swing.GroupLayout selectedProductsPanelLayout = new javax.swing.GroupLayout(selectedProductsPanel);
        selectedProductsPanel.setLayout(selectedProductsPanelLayout);
        selectedProductsPanelLayout.setHorizontalGroup(
            selectedProductsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectedProductsTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        selectedProductsPanelLayout.setVerticalGroup(
            selectedProductsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectedProductsTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        selectProductPanel.setBackground(new java.awt.Color(211, 211, 211));
        selectProductPanel.setPreferredSize(new java.awt.Dimension(176, 30));
        selectProductPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectProductPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectProductPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selectProductPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectProductPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                selectProductPanelMouseReleased(evt);
            }
        });

        selectProductTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectProductTextLabel.setForeground(new java.awt.Color(0, 0, 0));
        selectProductTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectProductTextLabel.setText("Selecionar");

        javax.swing.GroupLayout selectProductPanelLayout = new javax.swing.GroupLayout(selectProductPanel);
        selectProductPanel.setLayout(selectProductPanelLayout);
        selectProductPanelLayout.setHorizontalGroup(
            selectProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectProductTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );
        selectProductPanelLayout.setVerticalGroup(
            selectProductPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectProductTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout productsPanelLayout = new javax.swing.GroupLayout(productsPanel);
        productsPanel.setLayout(productsPanelLayout);
        productsPanelLayout.setHorizontalGroup(
            productsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productsTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productsPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(productsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productsTotalPricePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectedProductsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectProductPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        productsPanelLayout.setVerticalGroup(
            productsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productsTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(productsTotalPricePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectProductPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectedProductsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        midPanel.setBackground(new java.awt.Color(176, 196, 222));

        defeitosApontadosPanel.setBackground(new java.awt.Color(211, 211, 211));
        defeitosApontadosPanel.setForeground(new java.awt.Color(0, 0, 0));
        defeitosApontadosPanel.setPreferredSize(new java.awt.Dimension(176, 30));

        defeitosApontadosTextField.setBackground(new java.awt.Color(211, 211, 211));
        defeitosApontadosTextField.setForeground(new java.awt.Color(0, 0, 0));

        defeitosApontadosTitleLabel.setBackground(new java.awt.Color(211, 211, 211));
        defeitosApontadosTitleLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        defeitosApontadosTitleLabel.setForeground(new java.awt.Color(0, 0, 0));
        defeitosApontadosTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        defeitosApontadosTitleLabel.setText("Defeitos Apontados");

        javax.swing.GroupLayout defeitosApontadosPanelLayout = new javax.swing.GroupLayout(defeitosApontadosPanel);
        defeitosApontadosPanel.setLayout(defeitosApontadosPanelLayout);
        defeitosApontadosPanelLayout.setHorizontalGroup(
            defeitosApontadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defeitosApontadosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(defeitosApontadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(defeitosApontadosTextField)
                    .addComponent(defeitosApontadosTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                .addContainerGap())
        );
        defeitosApontadosPanelLayout.setVerticalGroup(
            defeitosApontadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, defeitosApontadosPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(defeitosApontadosTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(defeitosApontadosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        observacoesPanel.setBackground(new java.awt.Color(211, 211, 211));
        observacoesPanel.setForeground(new java.awt.Color(0, 0, 0));
        observacoesPanel.setPreferredSize(new java.awt.Dimension(176, 30));

        observacoesTextField.setBackground(new java.awt.Color(211, 211, 211));
        observacoesTextField.setForeground(new java.awt.Color(0, 0, 0));

        observacoesTitleLabel.setBackground(new java.awt.Color(211, 211, 211));
        observacoesTitleLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        observacoesTitleLabel.setForeground(new java.awt.Color(0, 0, 0));
        observacoesTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        observacoesTitleLabel.setText("Observações");

        javax.swing.GroupLayout observacoesPanelLayout = new javax.swing.GroupLayout(observacoesPanel);
        observacoesPanel.setLayout(observacoesPanelLayout);
        observacoesPanelLayout.setHorizontalGroup(
            observacoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(observacoesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(observacoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(observacoesTextField)
                    .addComponent(observacoesTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                .addContainerGap())
        );
        observacoesPanelLayout.setVerticalGroup(
            observacoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, observacoesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(observacoesTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(observacoesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        formaPagamentoPanel.setBackground(new java.awt.Color(211, 211, 211));
        formaPagamentoPanel.setForeground(new java.awt.Color(0, 0, 0));
        formaPagamentoPanel.setPreferredSize(new java.awt.Dimension(176, 30));

        formaPagamentoTextField.setBackground(new java.awt.Color(211, 211, 211));
        formaPagamentoTextField.setForeground(new java.awt.Color(0, 0, 0));

        formaPagamentoTitleLabel.setBackground(new java.awt.Color(211, 211, 211));
        formaPagamentoTitleLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        formaPagamentoTitleLabel.setForeground(new java.awt.Color(0, 0, 0));
        formaPagamentoTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        formaPagamentoTitleLabel.setText("Forma de Pagamento");

        javax.swing.GroupLayout formaPagamentoPanelLayout = new javax.swing.GroupLayout(formaPagamentoPanel);
        formaPagamentoPanel.setLayout(formaPagamentoPanelLayout);
        formaPagamentoPanelLayout.setHorizontalGroup(
            formaPagamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formaPagamentoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formaPagamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formaPagamentoTextField)
                    .addComponent(formaPagamentoTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                .addContainerGap())
        );
        formaPagamentoPanelLayout.setVerticalGroup(
            formaPagamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formaPagamentoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(formaPagamentoTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formaPagamentoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout midPanelLayout = new javax.swing.GroupLayout(midPanel);
        midPanel.setLayout(midPanelLayout);
        midPanelLayout.setHorizontalGroup(
            midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(midPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(defeitosApontadosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(observacoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formaPagamentoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        midPanelLayout.setVerticalGroup(
            midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(midPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(defeitosApontadosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(observacoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(formaPagamentoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cancelPanel.setBackground(new java.awt.Color(192, 192, 192));
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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelPanelMouseReleased(evt);
            }
        });

        cancelTextLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelTextLabel.setForeground(new java.awt.Color(255, 69, 0));
        cancelTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelTextLabel.setText("Voltar");

        javax.swing.GroupLayout cancelPanelLayout = new javax.swing.GroupLayout(cancelPanel);
        cancelPanel.setLayout(cancelPanelLayout);
        cancelPanelLayout.setHorizontalGroup(
            cancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cancelTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cancelPanelLayout.setVerticalGroup(
            cancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cancelTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        confirmPanel.setBackground(new java.awt.Color(192, 192, 192));
        confirmPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                confirmPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                confirmPanelMouseReleased(evt);
            }
        });

        confirmTextLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmTextLabel.setForeground(new java.awt.Color(255, 69, 0));
        confirmTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        confirmTextLabel.setText("Confirmar");

        javax.swing.GroupLayout confirmPanelLayout = new javax.swing.GroupLayout(confirmPanel);
        confirmPanel.setLayout(confirmPanelLayout);
        confirmPanelLayout.setHorizontalGroup(
            confirmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confirmTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        confirmPanelLayout.setVerticalGroup(
            confirmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confirmTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(clientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(servicesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(vehiclePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(midPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(employeePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(confirmPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(clientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vehiclePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(midPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(servicesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confirmPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectClientPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectClientPanelMouseEntered
        this.selectClientPanel.setBackground(new Color(70,130,180));
    }//GEN-LAST:event_selectClientPanelMouseEntered

    private void selectClientPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectClientPanelMouseExited
        this.selectClientPanel.setBackground(new Color(211,211,211));
    }//GEN-LAST:event_selectClientPanelMouseExited

    private void selectClientPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectClientPanelMousePressed
        this.selectClientPanel.setBackground(new Color(112,128,144));
    }//GEN-LAST:event_selectClientPanelMousePressed

    private void selectClientPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectClientPanelMouseReleased
        this.selectClientPanel.setBackground(new Color(70,130,180));
    }//GEN-LAST:event_selectClientPanelMouseReleased

    private void selectVehiclePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectVehiclePanelMouseEntered
        this.selectVehiclePanel.setBackground(new Color(70,130,180));
    }//GEN-LAST:event_selectVehiclePanelMouseEntered

    private void selectVehiclePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectVehiclePanelMouseExited
        this.selectVehiclePanel.setBackground(new Color(211,211,211));
    }//GEN-LAST:event_selectVehiclePanelMouseExited

    private void selectVehiclePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectVehiclePanelMousePressed
        this.selectVehiclePanel.setBackground(new Color(112,128,144));
    }//GEN-LAST:event_selectVehiclePanelMousePressed

    private void selectVehiclePanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectVehiclePanelMouseReleased
        this.selectVehiclePanel.setBackground(new Color(70,130,180));
    }//GEN-LAST:event_selectVehiclePanelMouseReleased

    private void selectEmployeePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectEmployeePanelMouseEntered
        this.selectEmployeePanel.setBackground(new Color(70,130,180));
    }//GEN-LAST:event_selectEmployeePanelMouseEntered

    private void selectEmployeePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectEmployeePanelMouseExited
        this.selectEmployeePanel.setBackground(new Color(211,211,211));
    }//GEN-LAST:event_selectEmployeePanelMouseExited

    private void selectEmployeePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectEmployeePanelMousePressed
        this.selectEmployeePanel.setBackground(new Color(112,128,144));
    }//GEN-LAST:event_selectEmployeePanelMousePressed

    private void selectEmployeePanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectEmployeePanelMouseReleased
        this.selectEmployeePanel.setBackground(new Color(70,130,180));
    }//GEN-LAST:event_selectEmployeePanelMouseReleased

    private void selectedServicesPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedServicesPanelMouseEntered
        this.selectedServicesPanel.setBackground(new Color(70,130,180));
    }//GEN-LAST:event_selectedServicesPanelMouseEntered

    private void selectedServicesPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedServicesPanelMouseExited
        this.selectedServicesPanel.setBackground(new Color(211,211,211));
    }//GEN-LAST:event_selectedServicesPanelMouseExited

    private void selectedServicesPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedServicesPanelMousePressed
        this.selectedServicesPanel.setBackground(new Color(112,128,144));
    }//GEN-LAST:event_selectedServicesPanelMousePressed

    private void selectedServicesPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedServicesPanelMouseReleased
        this.selectedServicesPanel.setBackground(new Color(70,130,180));
    }//GEN-LAST:event_selectedServicesPanelMouseReleased

    private void selectServicePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectServicePanelMouseEntered
        this.selectServicePanel.setBackground(new Color(70,130,180));
    }//GEN-LAST:event_selectServicePanelMouseEntered

    private void selectServicePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectServicePanelMouseExited
        this.selectServicePanel.setBackground(new Color(211,211,211));
    }//GEN-LAST:event_selectServicePanelMouseExited

    private void selectServicePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectServicePanelMousePressed
        this.selectServicePanel.setBackground(new Color(112,128,144));
    }//GEN-LAST:event_selectServicePanelMousePressed

    private void selectServicePanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectServicePanelMouseReleased
        this.selectServicePanel.setBackground(new Color(70,130,180));
    }//GEN-LAST:event_selectServicePanelMouseReleased

    private void selectedProductsPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedProductsPanelMouseEntered
        this.selectedProductsPanel.setBackground(new Color(70,130,180));
    }//GEN-LAST:event_selectedProductsPanelMouseEntered

    private void selectedProductsPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedProductsPanelMouseExited
        this.selectedProductsPanel.setBackground(new Color(211,211,211));
    }//GEN-LAST:event_selectedProductsPanelMouseExited

    private void selectedProductsPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedProductsPanelMousePressed
        this.selectedProductsPanel.setBackground(new Color(112,128,144));
    }//GEN-LAST:event_selectedProductsPanelMousePressed

    private void selectedProductsPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedProductsPanelMouseReleased
        this.selectedProductsPanel.setBackground(new Color(70,130,180));
    }//GEN-LAST:event_selectedProductsPanelMouseReleased

    private void selectProductPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectProductPanelMouseEntered
        this.selectProductPanel.setBackground(new Color(70,130,180));
    }//GEN-LAST:event_selectProductPanelMouseEntered

    private void selectProductPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectProductPanelMouseExited
        this.selectProductPanel.setBackground(new Color(211,211,211));
    }//GEN-LAST:event_selectProductPanelMouseExited

    private void selectProductPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectProductPanelMousePressed
        this.selectProductPanel.setBackground(new Color(112,128,144));
    }//GEN-LAST:event_selectProductPanelMousePressed

    private void selectProductPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectProductPanelMouseReleased
        this.selectProductPanel.setBackground(new Color(70,130,180));
    }//GEN-LAST:event_selectProductPanelMouseReleased

    private void cancelPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelPanelMouseEntered
        this.cancelPanel.setBackground(new Color(139,0,0));
    }//GEN-LAST:event_cancelPanelMouseEntered

    private void cancelPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelPanelMouseExited
        this.cancelPanel.setBackground(new Color(192,192,192));
    }//GEN-LAST:event_cancelPanelMouseExited

    private void cancelPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelPanelMousePressed
        this.cancelPanel.setBackground(new Color(255,99,71));
    }//GEN-LAST:event_cancelPanelMousePressed

    private void cancelPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelPanelMouseReleased
        this.cancelPanel.setBackground(new Color(139,0,0));
    }//GEN-LAST:event_cancelPanelMouseReleased

    private void confirmPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmPanelMouseEntered
        this.confirmPanel.setBackground(new Color(0,128,0));
        this.confirmTextLabel.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_confirmPanelMouseEntered

    private void confirmPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmPanelMouseExited
        this.confirmPanel.setBackground(new Color(192,192,192));
        this.confirmTextLabel.setForeground(new Color(255,69,0));
    }//GEN-LAST:event_confirmPanelMouseExited

    private void confirmPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmPanelMousePressed
        this.confirmPanel.setBackground(new Color(70,139,70));
    }//GEN-LAST:event_confirmPanelMousePressed

    private void confirmPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmPanelMouseReleased
        this.confirmPanel.setBackground(new Color(0,128,0));
    }//GEN-LAST:event_confirmPanelMouseReleased

    private void cancelPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelPanelMouseClicked
        setVisible(false);
        dispose();
    }//GEN-LAST:event_cancelPanelMouseClicked

    private void selectClientPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectClientPanelMouseClicked
        setOrcamentoDOF();
        TableManager tableManager = new TableManager(this.userId, this.mainFrame, this.orcamento, new javax.swing.JFrame(), true);
        tableManager.setOrcamentoUpdateMode(this.updateMode);
        tableManager.refreshViewClients(this.mainFrame, tableManager.getTable());
        tableManager.pack();
        tableManager.setLocationRelativeTo(this.mainFrame);
        
        dispose();
        
        tableManager.setVisible(true);
    }//GEN-LAST:event_selectClientPanelMouseClicked

    private void selectVehiclePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectVehiclePanelMouseClicked
        setOrcamentoDOF();
        TableManager tableManager = new TableManager(this.userId, this.mainFrame, this.orcamento, new javax.swing.JFrame(), true);
        tableManager.setOrcamentoUpdateMode(this.updateMode);
        tableManager.refreshViewVehicles(this.mainFrame, tableManager.getTable());
        tableManager.pack();
        tableManager.setLocationRelativeTo(this.mainFrame);
        
        dispose();
        
        tableManager.setVisible(true);
    }//GEN-LAST:event_selectVehiclePanelMouseClicked

    private void selectEmployeePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectEmployeePanelMouseClicked
        setOrcamentoDOF();
        TableManager tableManager = new TableManager(this.userId, this.mainFrame, this.orcamento, new javax.swing.JFrame(), true);
        tableManager.setOrcamentoUpdateMode(this.updateMode);
        tableManager.refreshViewEmployees(this.mainFrame, tableManager.getTable());
        tableManager.pack();
        tableManager.setLocationRelativeTo(this.mainFrame);
        
        dispose();
        
        tableManager.setVisible(true);
    }//GEN-LAST:event_selectEmployeePanelMouseClicked

    private void selectServicePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectServicePanelMouseClicked
        setOrcamentoDOF();
        TableManager tableManager = new TableManager(this.userId, this.mainFrame, this.orcamento, new javax.swing.JFrame(), true);
        tableManager.setOrcamentoUpdateMode(this.updateMode);
        tableManager.refreshViewServices(this.mainFrame, tableManager.getTable());
        tableManager.pack();
        tableManager.setLocationRelativeTo(this.mainFrame);
        
        dispose();
        
        tableManager.setVisible(true);
    }//GEN-LAST:event_selectServicePanelMouseClicked

    private void selectProductPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectProductPanelMouseClicked
        setOrcamentoDOF();    
        TableManager tableManager = new TableManager(this.userId, this.mainFrame, this.orcamento, new javax.swing.JFrame(), true);
        tableManager.setOrcamentoUpdateMode(this.updateMode);
        tableManager.refreshViewProducts(this.mainFrame, tableManager.getTable());
        tableManager.pack();
        tableManager.setLocationRelativeTo(this.mainFrame);
        
        dispose();
        
        tableManager.setVisible(true);
    }//GEN-LAST:event_selectProductPanelMouseClicked

    private void selectedServicesPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedServicesPanelMouseClicked
        setOrcamentoDOF();    
        TableManager tableManager = new TableManager(this.userId, this.mainFrame, this.orcamento, new javax.swing.JFrame(), true);
        tableManager.setOrcamentoUpdateMode(this.updateMode);
        tableManager.refreshCurrentServicesView(this.mainFrame, tableManager.getTable(), this.orcamento.getServicos());
        tableManager.pack();
        tableManager.setLocationRelativeTo(this.mainFrame);
        
        dispose();
        
        tableManager.setVisible(true);
    }//GEN-LAST:event_selectedServicesPanelMouseClicked

    private void selectedProductsPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedProductsPanelMouseClicked
        setOrcamentoDOF();    
        TableManager tableManager = new TableManager(this.userId, this.mainFrame, this.orcamento, new javax.swing.JFrame(), true);
        tableManager.setOrcamentoUpdateMode(this.updateMode);
        tableManager.refreshCurrentProductsView(this.mainFrame, tableManager.getTable(), this.orcamento.getProdutos());
        tableManager.pack();
        tableManager.setLocationRelativeTo(this.mainFrame);
        
        dispose();
        
        tableManager.setVisible(true);
    }//GEN-LAST:event_selectedProductsPanelMouseClicked

    private void confirmPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmPanelMouseClicked
        setOrcamentoDOF();
        try {
            if (this.updateMode) {
                new OrcamentoDAO().update(this.orcamento);
            } else {
                new OrcamentoDAO().create(this.orcamento);
            }

            this.mainFrame.refreshView("Orçamentos", null);
            dispose(); 
        } catch (HeadlessException ex) {
            System.err.println(ex);
        } catch (NullPointerException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(OrcamentoDialog.this, "É preciso selecionar: Cliente, Veículo e Funcionário.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_confirmPanelMouseClicked

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
            java.util.logging.Logger.getLogger(OrcamentoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrcamentoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrcamentoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrcamentoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OrcamentoDialog dialog = new OrcamentoDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel cancelPanel;
    private javax.swing.JLabel cancelTextLabel;
    private javax.swing.JPanel clientNamePanel;
    private javax.swing.JLabel clientNameTextLabel;
    private javax.swing.JPanel clientPanel;
    private javax.swing.JPanel clientTitlePanel;
    private javax.swing.JLabel clientTitleTextLabel;
    private javax.swing.JPanel confirmPanel;
    private javax.swing.JLabel confirmTextLabel;
    private javax.swing.JPanel defeitosApontadosPanel;
    private javax.swing.JTextField defeitosApontadosTextField;
    private javax.swing.JLabel defeitosApontadosTitleLabel;
    private javax.swing.JPanel employeeNamePanel;
    private javax.swing.JLabel employeeNameTextLabel;
    private javax.swing.JPanel employeePanel;
    private javax.swing.JPanel employeeTitlePanel;
    private javax.swing.JLabel employeeTitleTextLabel;
    private javax.swing.JPanel formaPagamentoPanel;
    private javax.swing.JTextField formaPagamentoTextField;
    private javax.swing.JLabel formaPagamentoTitleLabel;
    private javax.swing.JPanel midPanel;
    private javax.swing.JPanel observacoesPanel;
    private javax.swing.JTextField observacoesTextField;
    private javax.swing.JLabel observacoesTitleLabel;
    private javax.swing.JPanel productsPanel;
    private javax.swing.JPanel productsTitlePanel;
    private javax.swing.JLabel productsTitleTextLabel;
    private javax.swing.JPanel productsTotalPricePanel;
    private javax.swing.JLabel productsTotalPriceTextLabel;
    private javax.swing.JPanel selectClientPanel;
    private javax.swing.JLabel selectClientTextLabel;
    private javax.swing.JPanel selectEmployeePanel;
    private javax.swing.JLabel selectEmployeeTextLabel;
    private javax.swing.JPanel selectProductPanel;
    private javax.swing.JLabel selectProductTextLabel;
    private javax.swing.JPanel selectServicePanel;
    private javax.swing.JLabel selectServiceTextLabel;
    private javax.swing.JPanel selectVehiclePanel;
    private javax.swing.JLabel selectVehicleTextLabel;
    private javax.swing.JPanel selectedProductsPanel;
    private javax.swing.JLabel selectedProductsTextLabel;
    private javax.swing.JPanel selectedServicesPanel;
    private javax.swing.JLabel selectedServicesTextLabel;
    private javax.swing.JPanel servicesPanel;
    private javax.swing.JPanel servicesTitlePanel;
    private javax.swing.JLabel servicesTitleTextLabel;
    private javax.swing.JPanel servicesTotalPricePanel;
    private javax.swing.JLabel servicesTotalPriceTextLabel;
    private javax.swing.JPanel sideBar;
    private javax.swing.JPanel titleBar;
    private javax.swing.JLabel titleTextLabel;
    private javax.swing.JLabel vehicleIdentificationLabel;
    private javax.swing.JPanel vehicleIdentificationPanel;
    private javax.swing.JPanel vehiclePanel;
    private javax.swing.JPanel vehicleTitlePanel;
    private javax.swing.JLabel vehicleTitleTextLabel;
    // End of variables declaration//GEN-END:variables
}
