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
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IzmenaLinija extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX1;
	private JTextField txtY1;
	private JTextField txtX2;
	private JTextField txtY2;
	private JTextField txtBoja;
	public int x1;
	public int y1;
	public int x2;
	public int y2;
	public Color boja;
	public boolean stop = true;
	public IzmenaTacka it = new IzmenaTacka();
	public ArrayList<Object> lista = new ArrayList<Object>();
	private JFrame mainFrame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IzmenaLinija dialog = new IzmenaLinija();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IzmenaLinija() {
		
		setTitle("Selektovana linija");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(10, 0, 0, 0));
		{
			JLabel lblX = new JLabel("X1:");
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblX);
		}
		{
			txtX1 = new JTextField();
			txtX1.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(txtX1);
			txtX1.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("Y1:");
			lblY.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblY);
		}
		{
			txtY1 = new JTextField();
			txtY1.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(txtY1);
			txtY1.setColumns(10);
		}
		{
			JLabel lblX2 = new JLabel("X2:");
			lblX2.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblX2);
		}
		{
			txtX2 = new JTextField();
			txtX2.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(txtX2);
			txtX2.setColumns(10);
		}
		{
			JLabel lblY_1 = new JLabel("Y2:");
			lblY_1.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblY_1);
		}
		{
			txtY2 = new JTextField();
			txtY2.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(txtY2);
			txtY2.setColumns(10);
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
					public void actionPerformed(ActionEvent e1) {
						try{
							for (Object i : lista){
								if (i instanceof Linija){
									if (((Linija) i).sadrzi(x1, y1)){
										((Linija) i).setColor(txtBoja.getBackground());
										((Linija) i).settPocetna(new Tacka(Integer.parseInt(txtX1.getText()), Integer.parseInt(txtY1.getText())));
										((Linija) i).settKrajnja(new Tacka(Integer.parseInt(txtX2.getText()), Integer.parseInt(txtY2.getText())));
										setVisible(false);
									}
								}
							}
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Unete su pogreÅ¡ne vrednosti! Unesite ponovo!!!", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
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
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowActivated(WindowEvent e) {
					if (stop){
						for (Object i : lista){
							if (i instanceof Linija){
								if (((Linija) i).sadrzi(x1, y1)){
									txtBoja.setBackground(((Linija) i).getColor());
									i = (Linija)i;
									txtX1.setText(Integer.toString(((Linija) i).gettPocetna().getX()));
									txtY1.setText(Integer.toString(((Linija) i).gettPocetna().getY()));
									txtX2.setText(Integer.toString(((Linija) i).gettKrajnja().getX()));
									txtY2.setText(Integer.toString(((Linija) i).gettKrajnja().getY()));
									stop = false;
								}
							}
						}
					}
				}
			});
		}
	}

}
