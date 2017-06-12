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

public class StranicePravougaonik extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSirina;
	private JTextField txtVisina;
	public boolean potvrda;
	public int sirina;
	public int visina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StranicePravougaonik dialog = new StranicePravougaonik();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StranicePravougaonik() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(8, 0, 0, 0));
		{
			JLabel lblUnesiteSirinuPravougaonika = new JLabel("Unesite \u0161irinu pravougaonika:");
			lblUnesiteSirinuPravougaonika.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblUnesiteSirinuPravougaonika);
		}
		{
			txtSirina = new JTextField();
			txtSirina.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(txtSirina);
			txtSirina.setColumns(10);
		}
		{
			JLabel lblUnesiteVisinuPravougaonika = new JLabel("Unesite visinu pravougaonika:");
			lblUnesiteVisinuPravougaonika.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblUnesiteVisinuPravougaonika);
		}
		{
			txtVisina = new JTextField();
			txtVisina.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(txtVisina);
			txtVisina.setColumns(10);
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
							int num = Integer.parseInt(txtSirina.getText());
							int num1 = Integer.parseInt(txtVisina.getText());
							sirina = num;
							visina = num1;
							potvrda = true;
							setVisible(false);
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Unete su pogrešne vrednosti! Unesite ponovo!!!", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				btnPotvrdi.setActionCommand("OK");
				buttonPane.add(btnPotvrdi);
				getRootPane().setDefaultButton(btnPotvrdi);
			}
			{
				JButton btnOtkaži = new JButton("Otka\u017Ei");
				btnOtkaži.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				btnOtkaži.setActionCommand("Cancel");
				buttonPane.add(btnOtkaži);
			}
		}
	}

}
