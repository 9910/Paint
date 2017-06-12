package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Tacka extends Oblik implements Pomerljiv {
	private int x;
	private int y;
	private int indeks;
	private boolean selektovan;

	public Tacka() {

	}

	public Tacka(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Tacka(int x, int y, String boja) {
		this(x, y);
		setBoja(boja);
	}

	public Tacka(int x, int y, Color boja) {
		this(x, y);
		setColor(boja);
	}

	public void pomeriNa(int novoX, int novoY) {
		x = novoX;
		setY(novoY);
	}

	public void pomeriZa(int poX, int poY) {
		x = x + poX;
		setY(getY() + poY);
	}

	public double udaljenost(Tacka t2) {
		double dx = x - t2.getX();
		double dy = y - t2.y;
		double rezultat = Math.sqrt(dx * dx + dy * dy);

		return rezultat;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tacka) {
			Tacka pomocna = (Tacka) obj;
			if (x == pomocna.x && y == pomocna.y)
				return true;
			else
				return false;
		} else
			return false;
	}

	public boolean sadrzi(int x, int y) {
		Tacka mestoKlika = new Tacka(x, y);
		if (mestoKlika.udaljenost(this) <= 2)
			return true;
		else
			return false;
	}

	public void selektovan(Graphics g) {
		g.setColor(pronadjiBoju("plava"));
		g.drawRect(x - 3, y - 3, 6, 6);
	}

	public void crtajSe(Graphics g) {
		g.setColor(getColor());
		g.drawLine(x - 2, y, x + 2, y);
		g.drawLine(x, y - 2, x, y + 2);
		if (isSelektovan())
			selektovan(g);
	}

	public int compareTo(Object o) {
		if (o instanceof Tacka) {
			Tacka pomocna = (Tacka) o;
			Tacka nula = new Tacka(0, 0);
			return (int) (this.udaljenost(nula) - pomocna.udaljenost(nula));
		} else
			return 0;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int novoX) {
		x = novoX;
	}

	public void setY(int novoY) {
		y = novoY;
	}

	public int getIndeks() {
		return indeks;
	}

	public void setIndeks(int indeks) {
		this.indeks = indeks;
	}
}
