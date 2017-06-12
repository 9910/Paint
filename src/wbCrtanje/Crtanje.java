package wbCrtanje;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Krug;
import geometrija.Kvadrat;
import geometrija.Linija;
import geometrija.Pravougaonik;
import geometrija.Tacka;
import wbCrtanje.BirajBoju;

import java.awt.GridBagLayout;
import javax.swing.JToolBar;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JToggleButton;

public class Crtanje extends JFrame {

	private JPanel contentPane;
	public Color bojaIvice = Color.BLACK;
	public Color bojaUnutrasnjosti = Color.WHITE;
	public Color Boja;
	public ArrayList<Object> lista = new ArrayList<Object>();
	public int counter = 1;
	public int x1;
	public int y1;
	public int x2;
	public int y2;
	public IzmenaTacka it = new IzmenaTacka();
	public IzmenaLinija il = new IzmenaLinija();
	public IzmenaKvadrat ik = new IzmenaKvadrat();
	public IzmeniKrug ikr = new IzmeniKrug();
	public IzmenaPravougaonik ip = new IzmenaPravougaonik();
	public Object selektovanObjekat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crtanje frame = new Crtanje();
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
	public Crtanje() {
		setTitle("Marko Karapandzic IT45-2015");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JToggleButton tglbtnTacka = new JToggleButton("Tacka");
		JButton btnBoja = new JButton("Boja");
		btnBoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BirajBoju bb = new BirajBoju();
				bb.setVisible(true);
				if (bb.potvrda == true) {
					if (bb.bojaIvice != null)
						bojaIvice = bb.bojaIvice;
					if (bb.bojaUnutrasnjosti != null)
						bojaUnutrasnjosti = bb.bojaUnutrasnjosti;
				}
			}
		});

		JToggleButton tglbtnKrug = new JToggleButton("Krug");
		JToggleButton tglbtnIzbrisi = new JToggleButton("Izbrisi");
		GridBagConstraints gbc_tglbtnTacka = new GridBagConstraints();
		gbc_tglbtnTacka.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnTacka.gridx = 1;
		gbc_tglbtnTacka.gridy = 0;
		contentPane.add(tglbtnTacka, gbc_tglbtnTacka);

		JToggleButton tglbtnKvadrat = new JToggleButton("Kvadrat");
		GridBagConstraints gbc_tglbtnKvadrat = new GridBagConstraints();
		gbc_tglbtnKvadrat.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnKvadrat.gridx = 2;
		gbc_tglbtnKvadrat.gridy = 0;
		contentPane.add(tglbtnKvadrat, gbc_tglbtnKvadrat);

		JToggleButton tglbtnSelektuj = new JToggleButton("Selektuj");
		GridBagConstraints gbc_tglbtnSelektuj = new GridBagConstraints();
		gbc_tglbtnSelektuj.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnSelektuj.gridx = 5;
		gbc_tglbtnSelektuj.gridy = 0;
		contentPane.add(tglbtnSelektuj, gbc_tglbtnSelektuj);

		JToggleButton tglbtnLinija = new JToggleButton("Linija");
		GridBagConstraints gbc_tglbtnLinija = new GridBagConstraints();
		gbc_tglbtnLinija.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnLinija.gridx = 1;
		gbc_tglbtnLinija.gridy = 1;
		contentPane.add(tglbtnLinija, gbc_tglbtnLinija);

		JToggleButton tglbtnPravougaonik = new JToggleButton("Pravougaonik");
		GridBagConstraints gbc_tglbtnPravougaonik = new GridBagConstraints();
		gbc_tglbtnPravougaonik.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPravougaonik.gridx = 2;
		gbc_tglbtnPravougaonik.gridy = 1;
		contentPane.add(tglbtnPravougaonik, gbc_tglbtnPravougaonik);

		JToggleButton tglbtnModifikuj = new JToggleButton("Modifikuj");
		tglbtnModifikuj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		GridBagConstraints gbc_tglbtnModifikuj = new GridBagConstraints();
		gbc_tglbtnModifikuj.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnModifikuj.gridx = 5;
		gbc_tglbtnModifikuj.gridy = 1;
		contentPane.add(tglbtnModifikuj, gbc_tglbtnModifikuj);

		GridBagConstraints gbc_btnBoja = new GridBagConstraints();
		gbc_btnBoja.insets = new Insets(0, 0, 5, 0);
		gbc_btnBoja.gridx = 11;
		gbc_btnBoja.gridy = 1;
		contentPane.add(btnBoja, gbc_btnBoja);

		JPanel panelCrtanje = new JPanel();
		panelCrtanje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tglbtnSelektuj.isSelected()) {
					for (Object i : it.lista) {
						if (i instanceof Tacka) {
							it.x = e.getX();
							it.y = e.getY();
							if (((Tacka) i).sadrzi(it.x, it.y) == true) {
								if(selektovanObjekat != null)
									selektovanObjekat = null;
								((Tacka) i).selektovan(panelCrtanje.getGraphics());
								selektovanObjekat = (Tacka) i;
								return;
							}
						}
					}
					for (Object i : il.lista) {
						if (i instanceof Linija) {
							il.x1 = e.getX();
							il.y1 = e.getY();
							if (((Linija) i).sadrzi(il.x1, il.y1) == true) {
								if(selektovanObjekat != null)
									selektovanObjekat = null;
								((Linija) i).selektovan(panelCrtanje.getGraphics());
								selektovanObjekat = (Linija) i;
								return;
							}
						}
					}
					for (Object i : ik.lista) {
						if (i instanceof Kvadrat) {
							ik.x = e.getX();
							ik.y = e.getY();
							if (((Kvadrat) i).sadrzi(ik.x, ik.y) == true) {
								if(selektovanObjekat != null)
									selektovanObjekat = null;
								((Kvadrat) i).selektovan(panelCrtanje.getGraphics());
								selektovanObjekat = (Kvadrat) i;
								return;
							}
						}
					}
					for (Object i : ip.lista) {
						if (i instanceof Pravougaonik) {
							ip.x = e.getX();
							ip.y = e.getY();
							if (((Pravougaonik) i).sadrzi(ip.x, ip.y) == true) {
								if(selektovanObjekat != null)
									selektovanObjekat = null;
								((Pravougaonik) i).selektovan(panelCrtanje.getGraphics());
								selektovanObjekat = (Pravougaonik) i;
								return;
							}
						}
					}
					for (Object i : ikr.lista) {
						if (i instanceof Krug) {
							ikr.x = e.getX();
							ikr.y = e.getY();
							if (((Krug) i).sadrzi(ikr.x, ikr.y) == true) {
								if(selektovanObjekat != null)
									selektovanObjekat = null;
								((Krug) i).selektovan(panelCrtanje.getGraphics());
								selektovanObjekat = (Krug) i;
								return;
							}
						}
					}
				} else {
					if (tglbtnTacka.isSelected()) {
						int x = e.getX();
						int y = e.getY();
						Tacka t = new Tacka(x, y, bojaIvice);
						t.crtajSe(panelCrtanje.getGraphics());
						it.lista.add(t);
					} else if (tglbtnLinija.isSelected()) {
						if (counter > 0) {
							x1 = e.getX();
							y1 = e.getY();
						}
						if (counter < 0) {
							x2 = e.getX();
							y2 = e.getY();
							Linija l = new Linija(new Tacka(x1, y1), new Tacka(x2, y2), bojaIvice);
							l.crtajSe(panelCrtanje.getGraphics());
							il.lista.add(l);
						}
						counter = counter - counter * 2;

					} else if (tglbtnKvadrat.isSelected()) {
						int x = e.getX();
						int y = e.getY();
						StranicaKvadrat sk = new StranicaKvadrat();
						sk.setVisible(true);
						if (sk.potvrda) {
							int duzina = sk.duzina;
							Kvadrat kv = new Kvadrat(new Tacka(x, y), duzina, bojaIvice, bojaUnutrasnjosti);
							kv.crtajSe(panelCrtanje.getGraphics());
							kv.popuni(panelCrtanje.getGraphics());
							ik.lista.add(kv);
						}
					} else if (tglbtnPravougaonik.isSelected()) {
						int x = e.getX();
						int y = e.getY();
						StranicePravougaonik sp = new StranicePravougaonik();
						sp.setVisible(true);
						if (sp.potvrda) {
							int sirina = sp.sirina;
							int visina = sp.visina;
							Pravougaonik p = new Pravougaonik(new Tacka(x, y), sirina, visina, bojaIvice,
									bojaUnutrasnjosti);
							p.crtajSe(panelCrtanje.getGraphics());
							p.popuni(panelCrtanje.getGraphics());
							ip.lista.add(p);
						}
					} else if (tglbtnKrug.isSelected()) {
						int x = e.getX();
						int y = e.getY();
						PoluprecnikKrug pk = new PoluprecnikKrug();
						pk.setVisible(true);
						if (pk.potvrda) {
							int poluprecnik = pk.poluprecnik;
							Krug k = new Krug(new Tacka(x, y), poluprecnik, bojaIvice, bojaUnutrasnjosti);
							k.crtajSe(panelCrtanje.getGraphics());
							k.popuni(panelCrtanje.getGraphics());
							ikr.lista.add(k);
						}
					}
				}
			}
		});

		GridBagConstraints gbc_tglbtnKrug = new GridBagConstraints();
		gbc_tglbtnKrug.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnKrug.gridx = 1;
		gbc_tglbtnKrug.gridy = 2;
		contentPane.add(tglbtnKrug, gbc_tglbtnKrug);

		tglbtnTacka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnTacka.isSelected()) {
					tglbtnLinija.setSelected(false);
					tglbtnKvadrat.setSelected(false);
					tglbtnPravougaonik.setSelected(false);
					tglbtnKrug.setSelected(false);
					tglbtnModifikuj.setSelected(false);
					tglbtnIzbrisi.setSelected(false);
					tglbtnSelektuj.setSelected(false);
				}
			}
		});

		tglbtnLinija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnLinija.isSelected()) {
					tglbtnTacka.setSelected(false);
					tglbtnKvadrat.setSelected(false);
					tglbtnPravougaonik.setSelected(false);
					tglbtnKrug.setSelected(false);
					tglbtnModifikuj.setSelected(false);
					tglbtnIzbrisi.setSelected(false);
					tglbtnSelektuj.setSelected(false);
				}
			}
		});

		tglbtnKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnKvadrat.isSelected()) {
					tglbtnTacka.setSelected(false);
					tglbtnLinija.setSelected(false);
					tglbtnPravougaonik.setSelected(false);
					tglbtnKrug.setSelected(false);
					tglbtnModifikuj.setSelected(false);
					tglbtnIzbrisi.setSelected(false);
					tglbtnSelektuj.setSelected(false);
				}
			}
		});

		tglbtnPravougaonik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnPravougaonik.isSelected()) {
					tglbtnTacka.setSelected(false);
					tglbtnKvadrat.setSelected(false);
					tglbtnLinija.setSelected(false);
					tglbtnKrug.setSelected(false);
					tglbtnModifikuj.setSelected(false);
					tglbtnIzbrisi.setSelected(false);
					tglbtnSelektuj.setSelected(false);
				}
			}
		});

		tglbtnKrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnKrug.isSelected()) {
					tglbtnTacka.setSelected(false);
					tglbtnKvadrat.setSelected(false);
					tglbtnPravougaonik.setSelected(false);
					tglbtnLinija.setSelected(false);
					tglbtnModifikuj.setSelected(false);
					tglbtnIzbrisi.setSelected(false);
					tglbtnSelektuj.setSelected(false);
				}
			}
		});

		GridBagConstraints gbc_tglbtnIzbrisi = new GridBagConstraints();
		gbc_tglbtnIzbrisi.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnIzbrisi.gridx = 5;
		gbc_tglbtnIzbrisi.gridy = 2;
		contentPane.add(tglbtnIzbrisi, gbc_tglbtnIzbrisi);
		panelCrtanje.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelCrtanje = new GridBagConstraints();
		gbc_panelCrtanje.gridwidth = 12;
		gbc_panelCrtanje.fill = GridBagConstraints.BOTH;
		gbc_panelCrtanje.gridx = 0;
		gbc_panelCrtanje.gridy = 3;
		contentPane.add(panelCrtanje, gbc_panelCrtanje);

		tglbtnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnIzbrisi.isSelected()) {
					tglbtnModifikuj.setSelected(false);
					tglbtnSelektuj.setSelected(false);
					tglbtnTacka.setSelected(false);
					tglbtnKvadrat.setSelected(false);
					tglbtnLinija.setSelected(false);
					tglbtnKrug.setSelected(false);
					tglbtnPravougaonik.setSelected(false);
					
					repaint();

					for (Object i : it.lista) {
						if (i instanceof Tacka && selektovanObjekat instanceof Tacka) {
							if (((Tacka) i) == ((Tacka) selektovanObjekat)) {
								UpitBrisanje ub = new UpitBrisanje();
								ub.setVisible(true);
								if (ub.potvrda) {
									it.lista.remove(i);
									ub.setVisible(false);
									
									for (Object k : it.lista) 
										((Tacka) k).crtajSe(panelCrtanje.getGraphics());
									
									for (Object k : il.lista) 
										((Linija) k).crtajSe(panelCrtanje.getGraphics());
									
									for (Object k : ik.lista) {
										((Kvadrat) k).crtajSe(panelCrtanje.getGraphics());
										((Kvadrat) k).popuni(panelCrtanje.getGraphics());
									}
									for (Object k : ip.lista) {
										((Pravougaonik) k).crtajSe(panelCrtanje.getGraphics());
										((Pravougaonik) k).popuni(panelCrtanje.getGraphics());
									}
									for (Object k : ikr.lista) {
										((Krug) k).crtajSe(panelCrtanje.getGraphics());
										((Krug) k).popuni(panelCrtanje.getGraphics());
									}
									
									selektovanObjekat = null;
									return;
								}
							}
						}
					}
					for (Object i : il.lista) {
						if (i instanceof Linija && selektovanObjekat instanceof Linija) {
							if (((Linija) i) == ((Linija) selektovanObjekat)) {
								UpitBrisanje ub = new UpitBrisanje();
								ub.setVisible(true);
								if (ub.potvrda) {
									il.lista.remove(i);
									ub.setVisible(false);
									
									for (Object k : it.lista) 
										((Tacka) k).crtajSe(panelCrtanje.getGraphics());
									
									for (Object k : il.lista) 
										((Linija) k).crtajSe(panelCrtanje.getGraphics());
									
									for (Object k : ik.lista) {
										((Kvadrat) k).crtajSe(panelCrtanje.getGraphics());
										((Kvadrat) k).popuni(panelCrtanje.getGraphics());
									}
									for (Object k : ip.lista) {
										((Pravougaonik) k).crtajSe(panelCrtanje.getGraphics());
										((Pravougaonik) k).popuni(panelCrtanje.getGraphics());
									}
									for (Object k : ikr.lista) {
										((Krug) k).crtajSe(panelCrtanje.getGraphics());
										((Krug) k).popuni(panelCrtanje.getGraphics());
									}
									
									selektovanObjekat = null;
									return;
								}
							}
						}
					}
					for (Object i : ik.lista) {
						if (i instanceof Kvadrat && selektovanObjekat instanceof Kvadrat) {
							if (((Kvadrat) i) == ((Kvadrat) selektovanObjekat)) {
								UpitBrisanje ub = new UpitBrisanje();
								ub.setVisible(true);
								if (ub.potvrda) {
									ik.lista.remove(i);
									ub.setVisible(false);
									
									for (Object k : it.lista) 
										((Tacka) k).crtajSe(panelCrtanje.getGraphics());
									
									for (Object k : il.lista) 
										((Linija) k).crtajSe(panelCrtanje.getGraphics());
									
									for (Object k : ik.lista) {
										((Kvadrat) k).crtajSe(panelCrtanje.getGraphics());
										((Kvadrat) k).popuni(panelCrtanje.getGraphics());
									}
									for (Object k : ip.lista) {
										((Pravougaonik) k).crtajSe(panelCrtanje.getGraphics());
										((Pravougaonik) k).popuni(panelCrtanje.getGraphics());
									}
									for (Object k : ikr.lista) {
										((Krug) k).crtajSe(panelCrtanje.getGraphics());
										((Krug) k).popuni(panelCrtanje.getGraphics());
									}
									
									selektovanObjekat = null;
									return;
								}
							}
						}
					}
					for (Object i : ip.lista) {
						if (i instanceof Pravougaonik && selektovanObjekat instanceof Pravougaonik) {
							if (((Pravougaonik) i) == ((Pravougaonik) selektovanObjekat)) {
								UpitBrisanje ub = new UpitBrisanje();
								ub.setVisible(true);
								if (ub.potvrda) {
									ip.lista.remove(i);
									ub.setVisible(false);

									for (Object k : it.lista) 
										((Tacka) k).crtajSe(panelCrtanje.getGraphics());
									
									for (Object k : il.lista) 
										((Linija) k).crtajSe(panelCrtanje.getGraphics());
									
									for (Object k : ik.lista) {
										((Kvadrat) k).crtajSe(panelCrtanje.getGraphics());
										((Kvadrat) k).popuni(panelCrtanje.getGraphics());
									}
									for (Object k : ip.lista) {
										((Pravougaonik) k).crtajSe(panelCrtanje.getGraphics());
										((Pravougaonik) k).popuni(panelCrtanje.getGraphics());
									}
									for (Object k : ikr.lista) {
										((Krug) k).crtajSe(panelCrtanje.getGraphics());
										((Krug) k).popuni(panelCrtanje.getGraphics());
									}
									
									selektovanObjekat = null;
									return;
								}
							}
						}
					}
					for (Object i : ikr.lista) {
						if (i instanceof Krug && selektovanObjekat instanceof Krug) {
							if (((Krug) i) == ((Krug) selektovanObjekat)) {
								UpitBrisanje ub = new UpitBrisanje();
								ub.setVisible(true);
								if (ub.potvrda) {
									ikr.lista.remove(i);
									ub.setVisible(false);
									
									for (Object k : it.lista) 
										((Tacka) k).crtajSe(panelCrtanje.getGraphics());
									
									for (Object k : il.lista) 
										((Linija) k).crtajSe(panelCrtanje.getGraphics());
									
									for (Object k : ik.lista) {
										((Kvadrat) k).crtajSe(panelCrtanje.getGraphics());
										((Kvadrat) k).popuni(panelCrtanje.getGraphics());
									}
									for (Object k : ip.lista) {
										((Pravougaonik) k).crtajSe(panelCrtanje.getGraphics());
										((Pravougaonik) k).popuni(panelCrtanje.getGraphics());
									}
									for (Object k : ikr.lista) {
										((Krug) k).crtajSe(panelCrtanje.getGraphics());
										((Krug) k).popuni(panelCrtanje.getGraphics());
									}
									
									selektovanObjekat = null;
									return;
								}
							}
						}
					}
					for (Object k : it.lista) 
						((Tacka) k).crtajSe(panelCrtanje.getGraphics());
					
					for (Object k : il.lista) 
						((Linija) k).crtajSe(panelCrtanje.getGraphics());
					
					for (Object k : ik.lista) {
						((Kvadrat) k).crtajSe(panelCrtanje.getGraphics());
						((Kvadrat) k).popuni(panelCrtanje.getGraphics());
					}
					for (Object k : ip.lista) {
						((Pravougaonik) k).crtajSe(panelCrtanje.getGraphics());
						((Pravougaonik) k).popuni(panelCrtanje.getGraphics());
					}
					for (Object k : ikr.lista) {
						((Krug) k).crtajSe(panelCrtanje.getGraphics());
						((Krug) k).popuni(panelCrtanje.getGraphics());
					}
				}
			}
		});

		tglbtnModifikuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnModifikuj.isSelected()) {
					tglbtnIzbrisi.setSelected(false);
					tglbtnTacka.setSelected(false);
					tglbtnKvadrat.setSelected(false);
					tglbtnLinija.setSelected(false);
					tglbtnKrug.setSelected(false);
					tglbtnSelektuj.setSelected(false);
					tglbtnPravougaonik.setSelected(false);

					for (Object i : it.lista) {
						if ((i instanceof Tacka && selektovanObjekat instanceof Tacka) || (i instanceof Tacka && selektovanObjekat == null)) {
							if (((Tacka) i) == ((Tacka) selektovanObjekat)) {
								repaint();
								it.setVisible(true);
								it.stop = true;
								for (Object j : it.lista) {
									if (j instanceof Tacka) {
										((Tacka) j).crtajSe(panelCrtanje.getGraphics());
									}
								}
								for (Object j : il.lista) {
									if (j instanceof Linija) {
										((Linija) j).crtajSe(panelCrtanje.getGraphics());
									}
								}
								for (Object j : ik.lista) {
									if (j instanceof Kvadrat) {
										((Kvadrat) j).crtajSe(panelCrtanje.getGraphics());
										((Kvadrat) j).popuni(panelCrtanje.getGraphics());
									}
								}
								for (Object j : ip.lista) {
									if (j instanceof Pravougaonik) {
										((Pravougaonik) j).crtajSe(panelCrtanje.getGraphics());
										((Pravougaonik) j).popuni(panelCrtanje.getGraphics());
									}
								}
								for (Object j : ikr.lista) {
									if (j instanceof Krug) {
										((Krug) j).crtajSe(panelCrtanje.getGraphics());
										((Krug) j).popuni(panelCrtanje.getGraphics());
									}
								}
								selektovanObjekat = null;
								return;
							}
						}
					}
					for (Object i : il.lista) {
						if ((i instanceof Linija && selektovanObjekat instanceof Linija) || (i instanceof Linija && selektovanObjekat == null)) {
							if (((Linija) i) == ((Linija) selektovanObjekat)) {
								repaint();
								il.setVisible(true);
								il.stop = true;
								for (Object j : it.lista) {
									if (j instanceof Tacka) {
										((Tacka) j).crtajSe(panelCrtanje.getGraphics());
									}
								}
								for (Object j : il.lista) {
									if (j instanceof Linija) {
										((Linija) j).crtajSe(panelCrtanje.getGraphics());
									}
								}
								for (Object j : ik.lista) {
									if (j instanceof Kvadrat) {
										((Kvadrat) j).crtajSe(panelCrtanje.getGraphics());
									}
								}
								for (Object j : ip.lista) {
									if (j instanceof Pravougaonik) {
										((Pravougaonik) j).crtajSe(panelCrtanje.getGraphics());
										((Pravougaonik) j).popuni(panelCrtanje.getGraphics());
									}
								}
								for (Object j : ikr.lista) {
									if (j instanceof Krug) {
										((Krug) j).crtajSe(panelCrtanje.getGraphics());
										((Krug) j).popuni(panelCrtanje.getGraphics());
									}
								}
								selektovanObjekat = null;
								return;
							}
						}
					}
					for (Object i : ik.lista) {
						if ((i instanceof Kvadrat && selektovanObjekat instanceof Kvadrat) || (i instanceof Kvadrat && selektovanObjekat == null)) {
							if (((Kvadrat) i) == ((Kvadrat) selektovanObjekat)) {
								repaint();
								ik.setVisible(true);
								ik.stop = true;
								for (Object j : it.lista) {
									if (j instanceof Tacka) {
										((Tacka) j).crtajSe(panelCrtanje.getGraphics());
									}
								}
								for (Object j : il.lista) {
									if (j instanceof Linija) {
										((Linija) j).crtajSe(panelCrtanje.getGraphics());
									}
								}
								for (Object j : ik.lista) {
									if (j instanceof Kvadrat) {
										((Kvadrat) j).crtajSe(panelCrtanje.getGraphics());
										((Kvadrat) j).popuni(panelCrtanje.getGraphics());
									}
								}
								for (Object j : ip.lista) {
									if (j instanceof Pravougaonik) {
										((Pravougaonik) j).crtajSe(panelCrtanje.getGraphics());
										((Pravougaonik) j).popuni(panelCrtanje.getGraphics());
									}
								}
								for (Object j : ikr.lista) {
									if (j instanceof Krug) {
										((Krug) j).crtajSe(panelCrtanje.getGraphics());
										((Krug) j).popuni(panelCrtanje.getGraphics());
									}
								}
								selektovanObjekat = null;
								return;
							}
						}
					}
					for (Object i : ip.lista) {
						if ((i instanceof Pravougaonik && selektovanObjekat instanceof Pravougaonik) || (i instanceof Pravougaonik && selektovanObjekat == null)) {
							if (((Pravougaonik) i) == ((Pravougaonik) selektovanObjekat)) {
								repaint();
								ip.setVisible(true);
								ip.stop = true;
								for (Object j : it.lista) {
									if (j instanceof Tacka) {
										((Tacka) j).crtajSe(panelCrtanje.getGraphics());
									}
								}
								for (Object j : il.lista) {
									if (j instanceof Linija) {
										((Linija) j).crtajSe(panelCrtanje.getGraphics());
									}
								}
								for (Object j : ik.lista) {
									if (j instanceof Kvadrat) {
										((Kvadrat) j).crtajSe(panelCrtanje.getGraphics());
										((Kvadrat) j).popuni(panelCrtanje.getGraphics());
									}
								}
								for (Object j : ip.lista) {
									if (j instanceof Pravougaonik) {
										((Pravougaonik) j).crtajSe(panelCrtanje.getGraphics());
										((Pravougaonik) j).popuni(panelCrtanje.getGraphics());
									}
								}
								for (Object j : ikr.lista) {
									if (j instanceof Krug) {
										((Krug) j).crtajSe(panelCrtanje.getGraphics());
										((Krug) j).popuni(panelCrtanje.getGraphics());
									}
								}
								selektovanObjekat = null;
								return;
							}
						}
					}
					for (Object i : ikr.lista) {
						if ((i instanceof Krug && selektovanObjekat instanceof Krug) || (i instanceof Krug && selektovanObjekat == null)) {
							if (((Krug) i) == ((Krug) selektovanObjekat)) {
								repaint();
								ikr.setVisible(true);
								ikr.stop = true;
								for (Object j : it.lista) {
									if (j instanceof Tacka) {
										((Tacka) j).crtajSe(panelCrtanje.getGraphics());
									}
								}
								for (Object j : il.lista) {
									if (j instanceof Linija) {
										((Linija) j).crtajSe(panelCrtanje.getGraphics());
									}
								}
								for (Object j : ik.lista) {
									if (j instanceof Kvadrat) {
										((Kvadrat) j).crtajSe(panelCrtanje.getGraphics());
										((Kvadrat) j).popuni(panelCrtanje.getGraphics());
									}
								}
								for (Object j : ip.lista) {
									if (j instanceof Pravougaonik) {
										((Pravougaonik) j).crtajSe(panelCrtanje.getGraphics());
										((Pravougaonik) j).popuni(panelCrtanje.getGraphics());
									}
								}
								for (Object j : ikr.lista) {
									if (j instanceof Krug) {
										((Krug) j).crtajSe(panelCrtanje.getGraphics());
										((Krug) j).popuni(panelCrtanje.getGraphics());
									}
								}
								selektovanObjekat = null;
								return;
							}
						}
					}
				}
			}
		});

		tglbtnSelektuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnSelektuj.isSelected()) {
					tglbtnModifikuj.setSelected(false);
					tglbtnIzbrisi.setSelected(false);
					tglbtnTacka.setSelected(false);
					tglbtnKvadrat.setSelected(false);
					tglbtnLinija.setSelected(false);
					tglbtnKrug.setSelected(false);
					tglbtnPravougaonik.setSelected(false);
				}
			}
		});
	}

}
