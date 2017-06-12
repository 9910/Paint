package wbStack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodajKvadrat extends JDialog {

	private final JPanel centralniPanel = new JPanel();
	private JTextField txtXkoordinata;
	private JTextField txtYkoordinata;
	private JTextField txtDuzinaStranice;
	private JComboBox cbxBojaIvice;
	private JComboBox cbxBojaUnutrasnjosti;
	
	public int x;
	public int y;
	public int duzinaStranice;
	public String bojaIvice;
	public String bojaUnutrasnjosti;
	public boolean potvrdi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DodajKvadrat dialog = new DodajKvadrat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DodajKvadrat() {
		setTitle("Dodaj kvadrat");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		centralniPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(centralniPanel, BorderLayout.CENTER);
		GridBagLayout gbl_centralniPanel = new GridBagLayout();
		gbl_centralniPanel.columnWidths = new int[]{0, 0, 0};
		gbl_centralniPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_centralniPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_centralniPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		centralniPanel.setLayout(gbl_centralniPanel);
		{
			JLabel lblUnesiteXKoordinatu = new JLabel("Unesite x koordinatu:");
			GridBagConstraints gbc_lblUnesiteXKoordinatu = new GridBagConstraints();
			gbc_lblUnesiteXKoordinatu.anchor = GridBagConstraints.EAST;
			gbc_lblUnesiteXKoordinatu.insets = new Insets(0, 0, 5, 5);
			gbc_lblUnesiteXKoordinatu.gridx = 0;
			gbc_lblUnesiteXKoordinatu.gridy = 0;
			centralniPanel.add(lblUnesiteXKoordinatu, gbc_lblUnesiteXKoordinatu);
		}
		{
			txtXkoordinata = new JTextField();
			GridBagConstraints gbc_txtXkoordinata = new GridBagConstraints();
			gbc_txtXkoordinata.insets = new Insets(0, 0, 5, 0);
			gbc_txtXkoordinata.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXkoordinata.gridx = 1;
			gbc_txtXkoordinata.gridy = 0;
			centralniPanel.add(txtXkoordinata, gbc_txtXkoordinata);
			txtXkoordinata.setColumns(10);
		}
		{
			JLabel lblUnesiteYKoordinatu = new JLabel("Unesite y koordinatu:");
			GridBagConstraints gbc_lblUnesiteYKoordinatu = new GridBagConstraints();
			gbc_lblUnesiteYKoordinatu.anchor = GridBagConstraints.EAST;
			gbc_lblUnesiteYKoordinatu.insets = new Insets(0, 0, 5, 5);
			gbc_lblUnesiteYKoordinatu.gridx = 0;
			gbc_lblUnesiteYKoordinatu.gridy = 1;
			centralniPanel.add(lblUnesiteYKoordinatu, gbc_lblUnesiteYKoordinatu);
		}
		{
			txtYkoordinata = new JTextField();
			GridBagConstraints gbc_txtYkoordinata = new GridBagConstraints();
			gbc_txtYkoordinata.insets = new Insets(0, 0, 5, 0);
			gbc_txtYkoordinata.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYkoordinata.gridx = 1;
			gbc_txtYkoordinata.gridy = 1;
			centralniPanel.add(txtYkoordinata, gbc_txtYkoordinata);
			txtYkoordinata.setColumns(10);
		}
		{
			JLabel lblDuzinaStranice = new JLabel("Du\u017Eina stranice:");
			GridBagConstraints gbc_lblDuzinaStranice = new GridBagConstraints();
			gbc_lblDuzinaStranice.anchor = GridBagConstraints.WEST;
			gbc_lblDuzinaStranice.insets = new Insets(0, 0, 5, 5);
			gbc_lblDuzinaStranice.gridx = 0;
			gbc_lblDuzinaStranice.gridy = 2;
			centralniPanel.add(lblDuzinaStranice, gbc_lblDuzinaStranice);
		}
		{
			txtDuzinaStranice = new JTextField();
			GridBagConstraints gbc_txtDuzinaStranice = new GridBagConstraints();
			gbc_txtDuzinaStranice.insets = new Insets(0, 0, 5, 0);
			gbc_txtDuzinaStranice.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtDuzinaStranice.gridx = 1;
			gbc_txtDuzinaStranice.gridy = 2;
			centralniPanel.add(txtDuzinaStranice, gbc_txtDuzinaStranice);
			txtDuzinaStranice.setColumns(10);
		}
		{
			JLabel lblBojaIvice = new JLabel("Boja ivice:");
			GridBagConstraints gbc_lblBojaIvice = new GridBagConstraints();
			gbc_lblBojaIvice.anchor = GridBagConstraints.WEST;
			gbc_lblBojaIvice.insets = new Insets(0, 0, 5, 5);
			gbc_lblBojaIvice.gridx = 0;
			gbc_lblBojaIvice.gridy = 3;
			centralniPanel.add(lblBojaIvice, gbc_lblBojaIvice);
		}
		{
			cbxBojaIvice = new JComboBox();
			cbxBojaIvice.setModel(new DefaultComboBoxModel(new String[] {"Crna", "Bela", "Plava", "Crvena", "Zelena", "Zuta", "Pink"}));
			cbxBojaIvice.setSelectedIndex(0);
			GridBagConstraints gbc_cbxBojaIvice = new GridBagConstraints();
			gbc_cbxBojaIvice.insets = new Insets(0, 0, 5, 0);
			gbc_cbxBojaIvice.fill = GridBagConstraints.HORIZONTAL;
			gbc_cbxBojaIvice.gridx = 1;
			gbc_cbxBojaIvice.gridy = 3;
			centralniPanel.add(cbxBojaIvice, gbc_cbxBojaIvice);
		}
		{
			JLabel lblBojaUnutranjosti = new JLabel("Boja unutra\u0161njosti:");
			GridBagConstraints gbc_lblBojaUnutranjosti = new GridBagConstraints();
			gbc_lblBojaUnutranjosti.insets = new Insets(0, 0, 0, 5);
			gbc_lblBojaUnutranjosti.anchor = GridBagConstraints.WEST;
			gbc_lblBojaUnutranjosti.gridx = 0;
			gbc_lblBojaUnutranjosti.gridy = 4;
			centralniPanel.add(lblBojaUnutranjosti, gbc_lblBojaUnutranjosti);
		}
		{
			cbxBojaUnutrasnjosti = new JComboBox();
			cbxBojaUnutrasnjosti.setModel(new DefaultComboBoxModel(new String[] {"Bela", "Crna", "Plava", "Crvena", "Zelena", "Zuta", "Pink"}));
			cbxBojaUnutrasnjosti.setSelectedIndex(0);
			GridBagConstraints gbc_cbxBojaUnutrasnjosti = new GridBagConstraints();
			gbc_cbxBojaUnutrasnjosti.fill = GridBagConstraints.HORIZONTAL;
			gbc_cbxBojaUnutrasnjosti.gridx = 1;
			gbc_cbxBojaUnutrasnjosti.gridy = 4;
			centralniPanel.add(cbxBojaUnutrasnjosti, gbc_cbxBojaUnutrasnjosti);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
							x = Integer.parseInt(txtXkoordinata.getText());
							y = Integer.parseInt(txtYkoordinata.getText());
							duzinaStranice = Integer.parseInt(txtDuzinaStranice.getText());
							bojaIvice = cbxBojaIvice.getSelectedItem().toString();
							bojaUnutrasnjosti = cbxBojaUnutrasnjosti.getSelectedItem().toString();
							potvrdi = true;
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
				JButton btnOtkazi = new JButton("Otka\u017Ei");
				btnOtkazi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				btnOtkazi.setActionCommand("Cancel");
				buttonPane.add(btnOtkazi);
			}
		}
	}

}
