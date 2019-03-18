import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import java.awt.FlowLayout;

public class CurrencyConverterWindow extends JFrame {

    private Parse currencies = new Parse();
    private String[] elementsCurrency = currencies.get_currency_tab();
    private JTextField startNb = new JTextField();
    private JTextField endNb = new JTextField();
    private JComboBox startCurrency = new JComboBox(elementsCurrency);
    private JComboBox endCurrency = new JComboBox(elementsCurrency);    

    public CurrencyConverterWindow() {
        super();
        build();
    }

    private void build(){
        setTitle("Currency Converter");
        setSize(300, 125);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(buildContentPane());
    }

    private JPanel buildContentPane() {
        JPanel panel = new JPanel();
        JButton button = new JButton(new ConvertAction("Convert"));
        
        panel.setLayout(new FlowLayout());
        startNb.setColumns(15);
        endNb.setColumns(15);
        endNb.setEditable(false);
        panel.add(startCurrency);
        panel.add(startNb);
        panel.add(endCurrency);
        panel.add(endNb);
        panel.add(button);

        return panel;
    }

    class ConvertAction extends AbstractAction {

        public ConvertAction(String text) {
            super(text);
        }
    
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand() + " clicked");
            endNb.setText(currencies.make_conversion(
                String.valueOf(startCurrency.getSelectedItem()),
                String.valueOf(endCurrency.getSelectedItem()),
                Float.valueOf(startNb.getText())).toString());
        }
    }
}