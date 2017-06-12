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

import geometrija.Tacka;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowStateListener;

public class IzmenaTacka extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtBoja;
	public int x;
	public int y;
	public Color boja;
	public ArrayList<Object> lista = new ArrayList<Object>();
	private JFrame mainFrame;
	public boolean stop = true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IzmenaTacka dialog = new IzmenaTacka();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IzmenaTacka() {

		setModal(true);
		setTitle("Selektovana ta\u010Dka");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(8, 3, 0, 0));
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
			JLabel lblBoja = new JLabel("Boja:");
			lblBoja.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblBoja);
		}
		{
			txtBoja = new JTextField();
			txtBoja.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					boja = JColorChooser.showDialog(mainFrame, "Izaberi boju taÄ�ke", Color.black);
					if (boja != null)
						txtBoja.setBackground(boja);
				}
			});
			txtBoja.setEditable(false);
			txtBoja.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(txtBoja);
			txtBoja.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 3, 0, 0));
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (Object i : lista){
							if (i instanceof Tacka){
								if (((Tacka) i).sadrzi(x, y)){
									i = (Tacka)i;
									((Tacka) i).setColor(txtBoja.getBackground());
									((Tacka) i).setX(Integer.parseInt(txtX.getText()));
									((Tacka) i).setY(Integer.parseInt(txtY.getText()));
									setVisible(false);
								}
							}
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				if (stop){
					for (Object i : lista){
						if (i instanceof Tacka){
							if (((Tacka) i).sadrzi(x, y)){
								txtBoja.setBackground(((Tacka) i).getColor());
								txtX.setText(Integer.toString(x));
								txtY.setText(Integer.toString(y));
								stop = false;
							}
						}
					}
				}
			}
		});
	}

}
