//import javax.swing.*;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableCellRenderer;
//
//public class Interface {
//
////    public Interface()
////    {
////        //headers for the table
////        String[] columns = new String[] {
////                "Id", "First Name", "Last Name", "Card money", "Expiration date"
////        };
////
////        //actual data for the table in a 2d array
////        Object[][] data = new Object[][] {
////                {1, "John","Doe",40.0,"20-05-2019"},
////                {1, "John","Doe",40.0,"20-05-2019"},
////                {1, "John","Doe",40.0,"20-05-2019"},
////        };
////
////        JFrame jFrame = new JFrame();
////
////        final Class[] columnClass = new Class[] {
////                Integer.class, String.class, String.class, Double.class, String.class
////        };
////
////        DefaultTableModel model = new DefaultTableModel(data, columns) {
////            @Override
////            public boolean isCellEditable(int row, int column)
////            {
////                return false;
////            }
////            @Override
////            public Class<?> getColumnClass(int columnIndex)
////            {
////                return columnClass[columnIndex];
////            }
////        };
////        //create table with data
////        JTable table = new JTable(model){
////            DefaultTableCellRenderer renderLeft = new DefaultTableCellRenderer();
////
////            { // initializer block
////                renderLeft.setHorizontalAlignment(SwingConstants.LEFT);
////            }
////
////            @Override
////            public TableCellRenderer getCellRenderer (int arg0, int arg1) {
////                return renderLeft;
////            }
////
////        };
////
////        table.getTableHeader().setReorderingAllowed(false);
////        //add the table to the frame
////        jFrame.add(new JScrollPane(table));
////
////        jFrame.setTitle("List of clients");
////        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        jFrame.pack();
////        jFrame.setVisible(true);
////    }
//
//    public static void main(String[] args)
//    {
//
////        SwingUtilities.invokeLater(new Runnable() {
////            @Override
////            public void run() {
////                new Interface();
////            }
////        });
//    }
//            }
