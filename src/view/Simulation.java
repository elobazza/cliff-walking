package view;

import controller.ControllerSimulation;
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableMap = new javax.swing.JTable();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMap;
    // End of variables declaration//GEN-END:variables
}
