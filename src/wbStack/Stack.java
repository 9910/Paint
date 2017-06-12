package wbStack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Kvadrat;
import geometrija.Tacka;
import wbStack.DodajKvadrat;

import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stack extends JFrame {

	private JPanel contentPane;
	DefaultListModel stack = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Stack() {
		setTitle("Marko Karapandzic IT45-2015");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JButton btnSortiranje = new JButton("Sortiraj");
		btnSortiranje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int duzina = stack.getSize();
				for (int c = 0; c < (duzina - 1); c++) {
					for (int d = 0; d < duzina - c - 1; d++) {
						Kvadrat kv = (Kvadrat) stack.getElementAt(d);
						Kvadrat kv1 = (Kvadrat) stack.getElementAt(d + 1);
						if (kv.getDuzinaStranice() > kv1.getDuzinaStranice()) {
							Kvadrat t = kv;
							stack.set(d, kv1);
							stack.set(d + 1, t);
						}
					}
				}
			}
		});
		GridBagConstraints gbc_btnSortiranje = new GridBagConstraints();
		gbc_btnSortiranje.insets = new Insets(0, 0, 5, 5);
		gbc_btnSortiranje.gridx = 0;
		gbc_btnSortiranje.gridy = 0;
		contentPane.add(btnSortiranje, gbc_btnSortiranje);

		JList lstKvadrati = new JList();
		GridBagConstraints gbc_lstKvadrati = new GridBagConstraints();
		gbc_lstKvadrati.gridheight = 4;
		gbc_lstKvadrati.fill = GridBagConstraints.BOTH;
		gbc_lstKvadrati.gridx = 1;
		gbc_lstKvadrati.gridy = 0;
		contentPane.add(lstKvadrati, gbc_lstKvadrati);
		lstKvadrati.setModel(stack);

		JButton btnDodaj = new JButton("Dodaj Kvadrat");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DodajKvadrat dkv = new DodajKvadrat();
				dkv.setVisible(true);
				if (dkv.potvrdi) {
					Kvadrat kv = new Kvadrat(new Tacka(dkv.x, dkv.y), dkv.duzinaStranice, dkv.bojaIvice,
							dkv.bojaUnutrasnjosti);
					stack.addElement(kv);
					dkv.potvrdi = false;
				}
			}
		});
		GridBagConstraints gbc_btnDodaj = new GridBagConstraints();
		gbc_btnDodaj.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodaj.gridx = 0;
		gbc_btnDodaj.gridy = 1;
		contentPane.add(btnDodaj, gbc_btnDodaj);

		JButton btnIzbrisi = new JButton("Izbri\u0161i Kvadrat");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pozicija = stack.getSize();
				if (pozicija - 1 >= 0) {
					if (JOptionPane.showConfirmDialog(null, "Jeste li sigurni da želite da obrišete kvadrat?",
							"Notification", JOptionPane.YES_NO_OPTION) == 0)
						stack.removeElementAt(pozicija - 1);
				}
			}
		});
		GridBagConstraints gbc_btnIzbrisi = new GridBagConstraints();
		gbc_btnIzbrisi.insets = new Insets(0, 0, 5, 5);
		gbc_btnIzbrisi.gridx = 0;
		gbc_btnIzbrisi.gridy = 2;
		contentPane.add(btnIzbrisi, gbc_btnIzbrisi);

		JButton btnIzlaz = new JButton("Iza\u0111i");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnIzlaz = new GridBagConstraints();
		gbc_btnIzlaz.insets = new Insets(0, 0, 0, 5);
		gbc_btnIzlaz.gridx = 0;
		gbc_btnIzlaz.gridy = 3;
		contentPane.add(btnIzlaz, gbc_btnIzlaz);
	}

}
