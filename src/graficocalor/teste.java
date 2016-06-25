/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficocalor;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author PC
 */
public class teste extends DefaultTableCellRenderer {

    public static final DefaultTableCellRenderer DEFAULT_RENDERER
            = new DefaultTableCellRenderer();

    private static final long serialVersionUID = 6703872492730589499L;

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

      
                float cor = Float.parseFloat(table.getValueAt(row, column).toString());
                cor = cor / 10;
                cor = 255 * cor;
                int result = Math.round(cor);
                cellComponent.setBackground(new Color(255, result, 0));
            

        

        return cellComponent;
    }
}
