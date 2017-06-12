package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class PovrsinskiOblik extends Oblik {
	private String bojaUnutrasnjosti = "bela";
	private Color colorUnutrasnjosti;
	
	public abstract void popuni(Graphics g);

	public String getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public void setBojaUnutrasnjosti(String bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}
	
	public Color getColorUnutrasnjosti() {
		return colorUnutrasnjosti;
	}

	public void setColorUnutrasnjosti(Color colorUnutrasnjosti) {
		this.colorUnutrasnjosti = colorUnutrasnjosti;
	}
}
