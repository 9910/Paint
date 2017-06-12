package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Kvadrat extends PovrsinskiOblik implements Pomerljiv {
	protected Tacka goreLevo;
	protected int duzinaStranice;
	protected int indeks;

	public Kvadrat() {

	}

	public Kvadrat(Tacka goreLevo, int duzinaStranice) {
		this.goreLevo = goreLevo;
		this.duzinaStranice = duzinaStranice;
	}

	public Kvadrat(Tacka goreLevo, int duzinaStranice, String boja) {
		this(goreLevo, duzinaStranice);
		setBoja(boja);
	}

	public Kvadrat(Tacka goreLevo, int duzinaStranice, String bojaIvice, String bojaUnutrasnjosti) {
		this(goreLevo, duzinaStranice);
		setBoja(bojaIvice);
		setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}

	public Kvadrat(Tacka goreLevo, int duzinaStranice, Color bojaIvice, Color bojaUnutrasnjosti) {
		this(goreLevo, duzinaStranice);
		setColor(bojaIvice);
		setColorUnutrasnjosti(bojaUnutrasnjosti);
	}

	public void pomeriNa(int x, int y) {
		goreLevo.setX(x);
		goreLevo.setY(y);
	}

	public void pomeriZa(int x, int y) {
		goreLevo.setX(goreLevo.getX() + x);
		goreLevo.setY(goreLevo.getY() + y);
	}

	public int obim() {
		return 4 * duzinaStranice;
	}

	public int povrsina() {
		return duzinaStranice * duzinaStranice;
	}

	public String toString() {
		return "Tacka gore levo=" + goreLevo + ", duzina stranice=" + duzinaStranice;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Kvadrat) {
			Kvadrat pomocni = (Kvadrat) obj;
			if (goreLevo.equals(pomocni.goreLevo) && duzinaStranice == pomocni.duzinaStranice)
				return true;
			else
				return false;
		} else
			return false;
	}

	public Linija dijagonala() {
		return new Linija(goreLevo, new Tacka(goreLevo.getX() + duzinaStranice, goreLevo.getY() + duzinaStranice));
	}

	public Tacka centar() {
		return dijagonala().sredinaLinije();
	}

	public boolean sadrzi(int x, int y) {
		if (this.getGoreLevo().getX() <= x && x <= (this.getGoreLevo().getX() + duzinaStranice)
				&& this.getGoreLevo().getY() <= y && y <= (this.getGoreLevo().getY() + duzinaStranice))
			return true;
		else
			return false;

	}

	public void selektovan(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(pronadjiBoju("plava"));
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX() + duzinaStranice, getGoreLevo().getY())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY() + duzinaStranice)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX() + duzinaStranice, getGoreLevo().getY()), dijagonala().gettKrajnja())
				.selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY() + duzinaStranice), dijagonala().gettKrajnja())
				.selektovan(g);

	}

	public void crtajSe(Graphics g) {
		g.setColor(getColor());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), duzinaStranice, duzinaStranice);
		if (isSelektovan())
			selektovan(g);
	}

	public void popuni(Graphics g) {
		g.setColor(getColorUnutrasnjosti());
		g.fillRect(goreLevo.getX() + 1, goreLevo.getY() + 1, duzinaStranice - 1, duzinaStranice - 1);
	}

	public int compareTo(Object o) {
		if (o instanceof Kvadrat) {
			Kvadrat pomocni = (Kvadrat) o;
			return (int) (this.povrsina() - pomocni.povrsina());
		} else
			return 0;
	}

	public Tacka getGoreLevo() {
		return goreLevo;
	}

	public int getDuzinaStranice() {
		return duzinaStranice;
	}

	public void setGoreLevo(Tacka goreLevo) {
		this.goreLevo = goreLevo;
	}

	public void setDuzinaStranice(int duzinaStranica) {
		this.duzinaStranice = duzinaStranica;
	}

	public int getIndeks() {
		return indeks;
	}

	public void setIndeks(int indeks) {
		this.indeks = indeks;
	}
}
