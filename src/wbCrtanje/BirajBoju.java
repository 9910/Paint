package wbCrtanje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BirajBoju extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public Color bojaIvice = Color.BLACK;
	public Color bojaUnutrasnjosti = Color.WHITE;
	private JFrame mainFrame;
	public boolean potvrda;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BirajBoju dialog = new BirajBoju();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BirajBoju() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JButton btnBojaIvica = new JButton("Boja ivice");
			btnBojaIvica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color boja = JColorChooser.showDialog(mainFrame, "Izaberi boju ivice", Color.black);
					if (boja != null)
						bojaIvice = boja;
				}
			});
			contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
			contentPanel.add(btnBojaIvica);
		}
		{
			JButton btnBojaUnutrasnjosti = new JButton("Boja unutra\u0161njosti");
			btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color boja = JColorChooser.showDialog(mainFrame, "Izaberi boju unutrasnjosti", Color.white);
					if (boja != null)
						bojaUnutrasnjosti = boja;
				}
			});
			{
				JLabel label = new JLabel("");
				contentPanel.add(label);
			}
			{
				JLabel label = new JLabel("");
				contentPanel.add(label);
			}
			contentPanel.add(btnBojaUnutrasnjosti);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						potvrda = true;
						setVisible(false);
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
