package views;

import models.QueryModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class QueryView {
    private QueryModel model;
    private Object[] columns;
    private Object[][] data;
    private JTable table;

    private final JFrame frame;

    private static final Integer WIDTH = 700;
    private static final Integer HEIGHT = 550;

    public QueryView(@NotNull QueryModel queryModel) {
        this.frame = new JFrame();
        this.model = queryModel;

        frame.setSize(WIDTH, HEIGHT);
        frame.setTitle("Library Manager");

        extractData();
        addComponents();


        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void updateTable(QueryModel queryModel) {
        updateModel(model);
        extractData();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setColumnCount(0);
        tableModel.setRowCount(0);
        for (Object column : columns) {
            tableModel.addColumn(column);
        }
        for (Object[] row : data) {
            tableModel.addRow(row);
        }
        tableModel.fireTableDataChanged();
    }
    private void extractData() {
        columns = new Object[model.getNumberOfColumns()];
        data = new Object[model.getNumberOfRows()][model.getNumberOfColumns()];

        for (int i = 0 ; i < columns.length ; ++i) {
            columns[i] = model.getColumns().get(i);
        }

        for (int i = 0 ; i < data.length ; ++i) {
            for (int j = 0 ; j < columns.length ; ++j) {
                data[i][j] = model.getRows().get(i).get(j);
            }
        }
    }

    private void addComponents() {
        frame.setLayout(null);
        table = new JTable();
        updateTable(model);
        table.setBounds(0, 0, 600, 350);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 50, 600, 375);

        frame.add(scrollPane);
    }

    private void updateModel(QueryModel newModel) {
        this.model = newModel;
    }
}
