package wbCrtanje;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StranicaKvadrat extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDuzina;
	public boolean potvrda = false;
	public int duzina;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StranicaKvadrat dialog = new StranicaKvadrat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StranicaKvadrat() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(8, 1, 0, 0));
		{
			JLabel lblUnesiteDuinuStranice = new JLabel("Unesite du\u017Einu stranice:");
			lblUnesiteDuinuStranice.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblUnesiteDuinuStranice);
		}
		{
			txtDuzina = new JTextField();
			txtDuzina.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(txtDuzina);
			txtDuzina.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e1) {
						try{
							int num = Integer.parseInt(txtDuzina.getText());
							duzina = num;
							potvrda = true;
							setVisible(false);
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Pogrešna vrednost dužine! Unesite ponovo!!!", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				btnPotvrdi.setActionCommand("OK");
				buttonPane.add(btnPotvrdi);
				getRootPane().setDefaultButton(btnPotvrdi);
			}
			{
				JButton btnOtkazi = new JButton("Otka\u017Ei");
				btnOtkazi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				buttonPane.add(btnOtkazi);
			}
		}
	}

}
