import javax.swing.SwingUtilities;

public class CurrencyConverter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CurrencyConverterWindow window = new CurrencyConverterWindow();
                window.setVisible(true);
            }
        });
    }
}