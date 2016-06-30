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

        try {

            Double cor = Double.parseDouble(table.getValueAt(row, column).toString());
            Double nome = cor;
            int result = porcento(cor);

            System.out.println("" + result);
            if (result >= 255) {
                result -= 510;
                result *= -1;
                cellComponent.setForeground(new Color(255, result, 0));
                cellComponent.setBackground(new Color(255, result, 0));
            } else {
                cellComponent.setForeground(new Color(result, 255, 0));
                cellComponent.setBackground(new Color(result, 255, 0));
            }

        } catch (Exception e) {
            cellComponent.setForeground(Color.BLACK);
            cellComponent.setBackground(Color.WHITE);
        }

        return cellComponent;
    }

    public static int porcento(Double cor) {

        if (cor < 1) {
            cor = valor(cor);

            cor = cor * 20;
            cor = 100 - cor;
            cor = cor / 100;
            cor = cor * 510;
        } else {
            cor = 510.0;
        }

        int result = (int) Math.round(cor);

        return result;
    }

    public static double valor(Double n) {
        int v = 0;

        while (n < 0.1) {
            v++;
            n = n * 10;
        }
        if (v == 0) {
            n = 1 - n;
        } else if (v == 1) {
            n = n * 12;
        } else if (v == 2) {
            n = n * 24;
        } else if (v >= 3) {
            n = n * 36;
        }

        return n;
    }
}
