import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class TareaRenderer extends DefaultTableCellRenderer {

    private ArrayList<Tarea> lista;  // ArrayList de Tareas con la información de la fecha de entrega

    // Constructor que recibe el ArrayList
    public TareaRenderer(ArrayList<Tarea> lista) {
        this.lista = lista;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Obtener el id de la tarea de la fila (suponiendo que el id está en la primera columna)
        Integer tareaId = (Integer) table.getValueAt(row, 0);  // Suponiendo que el id está en la primera columna
        
        // Buscar la tarea en el ArrayList de tareas usando el id
        Tarea tarea = obtenerTareaPorId(tareaId);

        if (tarea != null) {
            Date fechaEntrega = tarea.getFechaEntrega();  // Obtener la fecha de entrega de la tarea
            String prioridad = tarea.getPrioridad();  // Obtener la prioridad de la tarea

            // Obtener la fecha actual
            Date fechaActual = new Date();
            
            // Si la columna es la de prioridad (tercera columna, index 2), cambiar el color según la prioridad
            if (column == 2) {  // Verificar si estamos en la columna de prioridad
                switch (prioridad) {
                    case "Baja":
                        c.setBackground(new Color(245, 243, 230));  // Prioridad baja en verde
                        break;
                    case "Media":
                        c.setBackground(new Color(252, 112, 59, 200));  // Prioridad media en amarillo
                        break;
                    case "Alta":
                        c.setBackground(new Color(92, 7, 2, 200));  // Prioridad alta en rojo
                        break;
                    default:
                        c.setBackground(Color.WHITE);  // Si no se especifica, mantener el fondo blanco
                        break;
                }
            } else {
                // Para las demás columnas, revisar la fecha de vencimiento
                if (fechaEntrega.before(fechaActual)) {
                    c.setBackground(new Color(255, 99, 71));  // Si la fecha de entrega ha caducado, resaltar la fila en rojo
                } else {
                    c.setBackground(Color.WHITE);  // Si no ha caducado, mantener el fondo blanco
                }
            }
        }

        // Si la fila está seleccionada, cambiar el fondo a un color diferente
        if (isSelected) {
            c.setBackground(Color.LIGHT_GRAY);
        }

        return c;
    }

    // Método para buscar la tarea por id en el ArrayList
    private Tarea obtenerTareaPorId(int id) {
        for (Tarea tarea : lista) {
            if (tarea.getNumeroTarea() == id) {
                return tarea;
            }
        }
        return null;  // Si no se encuentra la tarea
    }
}
