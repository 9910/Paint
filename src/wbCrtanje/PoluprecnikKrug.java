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

public class PoluprecnikKrug extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPoluprecnik;
	public boolean potvrda;
	public int poluprecnik;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PoluprecnikKrug dialog = new PoluprecnikKrug();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PoluprecnikKrug() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(8, 0, 0, 0));
		{
			JLabel lblUnesitePoluprenikKruga = new JLabel("Unesite polupre\u010Dnik kruga:");
			lblUnesitePoluprenikKruga.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblUnesitePoluprenikKruga);
		}
		{
			txtPoluprecnik = new JTextField();
			txtPoluprecnik.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(txtPoluprecnik);
			txtPoluprecnik.setColumns(10);
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
							int num = Integer.parseInt(txtPoluprecnik.getText());
							poluprecnik = num;
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
				btnOtkazi.setActionCommand("Cancel");
				buttonPane.add(btnOtkazi);
			}
		}
	}

}
