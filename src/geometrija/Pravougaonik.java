package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Pravougaonik extends Kvadrat{
	private int visina;
	
	public Pravougaonik(){

	}
	public Pravougaonik(Tacka goreLevo, int sirina, int visina){
		super(goreLevo, sirina);
		this.visina = visina;
	}
	public Pravougaonik(Tacka goreLevo, int sirina, int visina,String boja){
		this(goreLevo,sirina,visina);
		setBoja(boja);
	}
	public Pravougaonik(Tacka goreLevo, int sirina, int visina,Color bojaIvice, Color bojaUnutrasnjosti){
		this(goreLevo,sirina,visina);
		setColor(bojaIvice);
		setColorUnutrasnjosti(bojaUnutrasnjosti);
	}
	
	// Tacka gore levo=(xGoreLevo,yGoreLevo), sirina=sirina, visina=visina
	public String toString(){
		return "Tacka gore levo="+goreLevo+", sirina="+duzinaStranice+", visina="+visina;
	}
	public boolean equals(Object obj){
		if(obj instanceof Pravougaonik){
			Pravougaonik pomocni = (Pravougaonik) obj;
			if(goreLevo.equals(pomocni.goreLevo) && duzinaStranice == pomocni.duzinaStranice && visina == pomocni.visina)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public Linija dijagonala(){
		return new Linija(goreLevo, new Tacka(goreLevo.getX() + duzinaStranice,goreLevo.getY() + visina));
	}
	public Tacka centar(){
		return dijagonala().sredinaLinije();
	}
	
	public int obim(){
		return 2 * (duzinaStranice + visina);
	}
	public int povrsina(){
		return duzinaStranice * visina;
	}
	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + duzinaStranice)
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + visina))
			return true;
		else 
			return false;

	}
	public void selektovan(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(pronadjiBoju("plava"));
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+visina)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY()), dijagonala().gettKrajnja()).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+visina), dijagonala().gettKrajnja()).selektovan(g);
	}
	public void crtajSe(Graphics g){
		g.setColor(getColor());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), duzinaStranice, visina);
		if(isSelektovan())
			selektovan(g);
	}
	public void popuni(Graphics g) {
		g.setColor(getColorUnutrasnjosti());
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, duzinaStranice-1, visina-1);
		
	}
	public int getVisina() {
		return visina;
	}
	public void setVisina(int visina) {
		this.visina = visina;
	}
	
}
