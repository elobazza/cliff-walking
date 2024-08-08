package view;

import controller.ControllerSimulation;
import javax.swing.JOptionPane;
import observer.InterfaceViewObserver;
import view.tablemodel.TableModelMap;
import view.tablemodel.TableCellRender;

/**
 * @author Eloisa Bazzanella
 */
public class Simulation extends javax.swing.JFrame implements InterfaceViewObserver {

    private ControllerSimulation controller;
    private TableModelMap tableModel;
    
    public Simulation(ControllerSimulation controller) {
        initComponents();
        
        this.updateTableModel(new TableModelMap(controller));
        this.controller = controller;
        this.controller.addObserver(this);
        
        this.btPause.setEnabled(false);
        this.btStop.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableMap = new javax.swing.JTable();
        btStop = new javax.swing.JButton();
        btPlay = new javax.swing.JButton();
        btPause = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfLearningRate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfDiscountFactor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfEpsilon = new javax.swing.JTextField();
        tfDecay = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableMap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableMap.setAutoscrolls(false);
        tableMap.setEnabled(false);
        tableMap.setTableHeader(null);
        tableMap.setShowGrid(false);
        tableMap.setRowHeight(75);
        tableMap.setDefaultRenderer(Object.class, new TableCellRender());
        jScrollPane1.setViewportView(tableMap);

        btStop.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btStop.setText("Stop");
        btStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStopActionPerformed(evt);
            }
        });

        btPlay.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btPlay.setText("Play");
        btPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPlayActionPerformed(evt);
            }
        });

        btPause.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btPause.setText("Pause");
        btPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPauseActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        jLabel2.setText("CLIFF WALKING");

        tfLearningRate.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tfLearningRate.setText("0.1");
        tfLearningRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLearningRateActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("Learning Rate");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Discount Factor");

        tfDiscountFactor.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tfDiscountFactor.setText("0.3");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Epsilon Value");

        tfEpsilon.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tfEpsilon.setText("0.7");

        tfDecay.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tfDecay.setText("0.9995");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Epsilon Decay");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel6.setText("*Enter the values for the variables below ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btPause, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btStop, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(53, 53, 53)))
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfLearningRate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfEpsilon, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfDiscountFactor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfDecay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(100, 100, 100)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfLearningRate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDiscountFactor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfEpsilon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDecay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btStop, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btPause, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStopActionPerformed
        ControllerSimulation.getInstance().setStart(false);
        
        btPause.setEnabled(false);
        btStop.setEnabled(false);
        btPlay.setEnabled(true);
    }//GEN-LAST:event_btStopActionPerformed

    private void btPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPlayActionPerformed
        if( this.tfLearningRate.getText().equals("") ||
            this.tfDiscountFactor.getText().equals("") ||
            this.tfEpsilon.getText().equals("") ||
            this.tfDecay.getText().equals("")) {
            
            JOptionPane.showMessageDialog(this, "Please, enter the values! :D");
        } 
        else if ( Double.parseDouble(this.tfLearningRate.getText()) >= 0 && Double.parseDouble(this.tfLearningRate.getText()) <= 1 &&
                  Double.parseDouble(this.tfDiscountFactor.getText()) >= 0 && Double.parseDouble(this.tfDiscountFactor.getText()) <= 1 &&
                  Double.parseDouble(this.tfEpsilon.getText()) >= 0 && Double.parseDouble(this.tfEpsilon.getText()) <= 1 &&
                  Double.parseDouble(this.tfDecay.getText()) >= 0 && Double.parseDouble(this.tfDecay.getText()) <= 1) {
            
                    ControllerSimulation.getInstance().setLearningRate(Double.parseDouble(this.tfLearningRate.getText()));
                    ControllerSimulation.getInstance().setDiscountFactor(Double.parseDouble(this.tfDiscountFactor.getText()));
                    ControllerSimulation.getInstance().setEpsilon(Double.parseDouble(this.tfEpsilon.getText()));
                    ControllerSimulation.getInstance().setEpsilonDecay(Double.parseDouble(this.tfDecay.getText()));

                    btPause.setEnabled(true);
                    btStop.setEnabled(true);
                    btPlay.setEnabled(false);
                    
                    ControllerSimulation.getInstance().setLearningRate(Double.parseDouble(this.tfLearningRate.getText()));
                    ControllerSimulation.getInstance().setDiscountFactor(Double.parseDouble(this.tfDiscountFactor.getText()));
                    ControllerSimulation.getInstance().setEpsilon(Double.parseDouble(this.tfEpsilon.getText()));
                    ControllerSimulation.getInstance().setEpsilonDecay(Double.parseDouble(this.tfDecay.getText()));
                    
                    ControllerSimulation.getInstance().play();
                
        
        }
        else {
            JOptionPane.showMessageDialog(this, "Values must be between 0 and 1!");
        }
    }//GEN-LAST:event_btPlayActionPerformed

    private void btPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPauseActionPerformed
        ControllerSimulation.getInstance().setStart(false);
        
        btPause.setEnabled(false);
        btStop.setEnabled(false);
        btPlay.setEnabled(true);
    }//GEN-LAST:event_btPauseActionPerformed

    private void tfLearningRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLearningRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLearningRateActionPerformed

    @Override
    public void updateTableChanged() {
        this.tableModel.fireTableDataChanged();
    }

    @Override
    public void updateTableModel(TableModelMap tableModelMap) {
        this.tableModel = tableModelMap;
        this.tableMap.setModel(this.tableModel);
    }

    @Override
    public void updateShowException(Boolean exception) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPause;
    private javax.swing.JButton btPlay;
    private javax.swing.JButton btStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMap;
    private javax.swing.JTextField tfDecay;
    private javax.swing.JTextField tfDiscountFactor;
    private javax.swing.JTextField tfEpsilon;
    private javax.swing.JTextField tfLearningRate;
    // End of variables declaration//GEN-END:variables
}
