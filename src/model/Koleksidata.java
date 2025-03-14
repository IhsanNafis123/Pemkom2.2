package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Koleksidata extends AbstractTableModel {
    private final List<inventory> dataList;
    private final String[] columnNames = {"ID", "Nama", "Kategori", "Stock"};

    public Koleksidata() {
        dataList = new ArrayList<>();
    }

    public void add(inventory item) {
        dataList.add(item);
        fireTableRowsInserted(dataList.size() - 1, dataList.size() - 1);
    }

    public void clear() {
        dataList.clear();
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return dataList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        inventory item = dataList.get(rowIndex);
        switch (columnIndex) {
            case 0: return item.getId();
            case 1: return item.getNama();
            case 2: return item.getKategori();
            case 3: return item.getStok();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}
