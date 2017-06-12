package wbCrtanje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Kvadrat;
import geometrija.Linija;
import geometrija.Tacka;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IzmenaKvadrat extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public int x;
	public int y;
	public int duzina;
	public Color bojaIvice;
	public Color bojaUnutrasnjosti;
	public ArrayList<Object> lista = new ArrayList<Object>();
	private JFrame mainFrame;
	public boolean stop = true;
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtDuzina;
	private JTextField txtBojaIvice;
	private JTextField txtBojaUnutrasnjosti;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IzmenaKvadrat dialog = new IzmenaKvadrat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IzmenaKvadrat() {
		setModal(true);

		setTitle("Selektovani kvadrat");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(10, 0, 0, 0));
		{
			JLabel lblX = new JLabel("X:");
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblX);
		}
		{
			txtX = new JTextField();
			txtX.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(txtX);
			txtX.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("Y:");
			lblY.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblY);
		}
		{
			txtY = new JTextField();
			txtY.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(txtY);
			txtY.setColumns(10);
		}
		{
			JLabel lblDuzinaStranice = new JLabel("Du\u017Eina stranice:");
			lblDuzinaStranice.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblDuzinaStranice);
		}
		{
			txtDuzina = new JTextField();
			txtDuzina.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(txtDuzina);
			txtDuzina.setColumns(10);
		}
		{
			JLabel lblBojaIvice = new JLabel("Boja ivice:");
			lblBojaIvice.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblBojaIvice);
		}
		{
			txtBojaIvice = new JTextField();
			txtBojaIvice.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					bojaIvice = JColorChooser.showDialog(mainFrame, "Izaberi boju ivice", Color.black);
					if (bojaIvice != null)
						txtBojaIvice.setBackground(bojaIvice);
				}
			});
			txtBojaIvice.setEditable(false);
			txtBojaIvice.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(txtBojaIvice);
			txtBojaIvice.setColumns(10);
		}
		{
			JLabel lblBojaUnutranjosti = new JLabel("Boja unutra\u0161njosti:");
			lblBojaUnutranjosti.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblBojaUnutranjosti);
		}
		{
			txtBojaUnutrasnjosti = new JTextField();
			txtBojaUnutrasnjosti.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					bojaUnutrasnjosti = JColorChooser.showDialog(mainFrame, "Izaberi boju unutrašnjosti", Color.white);
					if (bojaUnutrasnjosti != null)
						txtBojaUnutrasnjosti.setBackground(bojaUnutrasnjosti);
				}
			});
			txtBojaUnutrasnjosti.setEditable(false);
			contentPanel.add(txtBojaUnutrasnjosti);
			txtBojaUnutrasnjosti.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 3, 0, 0));
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e1) {
						try {
							for (Object i : lista) {
								if (i instanceof Kvadrat) {
									if (((Kvadrat) i).sadrzi(x, y)) {
										((Kvadrat) i).setColor(txtBojaIvice.getBackground());
										((Kvadrat) i).setColorUnutrasnjosti(txtBojaUnutrasnjosti.getBackground());
										((Kvadrat) i).setGoreLevo(new Tacka(Integer.parseInt(txtX.getText()),
												Integer.parseInt(txtY.getText())));
										((Kvadrat) i).setDuzinaStranice(Integer.parseInt(txtDuzina.getText()));
										setVisible(false);
									}
								}
							}
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Unete su pogrešne vrednosti! Unesite ponovo!!!",
									"Upozorenje", JOptionPane.INFORMATION_MESSAGE);
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				if (stop) {
					for (Object i : lista) {
						if (i instanceof Kvadrat) {
							if (((Kvadrat) i).sadrzi(x, y)) {
								txtBojaIvice.setBackground(((Kvadrat) i).getColor());
								txtBojaUnutrasnjosti.setBackground(((Kvadrat) i).getColorUnutrasnjosti());
								txtX.setText(Integer.toString(((Kvadrat) i).getGoreLevo().getX()));
								txtY.setText(Integer.toString(((Kvadrat) i).getGoreLevo().getY()));
								txtDuzina.setText(Integer.toString(((Kvadrat) i).getDuzinaStranice()));
								stop = false;
							}
						}
					}
				}
			}
		});
	}

}
