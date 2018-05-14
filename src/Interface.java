import javax.swing.*;

public class Interface {

    public Interface()
    {
        //headers for the table
        String[] columns = new String[] {
                "Id", "First Name", "Last Name", "Card money", "Expiration date"
        };

        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
                {1, "John","Doe",40.0,"20-05-2019"},
                {1, "John","Doe",40.0,"20-05-2019"},
                {1, "John","Doe",40.0,"20-05-2019"},
        };

        JFrame jFrame = new JFrame();

        //create table with data
        JTable table = new JTable(data, columns);

        //add the table to the frame
        jFrame.add(new JScrollPane(table));

        jFrame.setTitle("Table Example");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interface();
            }
        });
    }
}
