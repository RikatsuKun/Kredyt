package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class KalorieBB {
	private String plec;
	private int wiek;
	private int waga;
	private int wzrost;	
	private String aktywnosc;
	private double bmr;
	private double kalorie;
	
	public String getPlec() {
		return plec;
	}

	public void setPlec(String plec) {
		this.plec = plec;
	}

	public int getWiek() {
		return wiek;
	}

	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	public int getWaga() {
		return waga;
	}

	public void setWaga(int waga) {
		this.waga = waga;
	}

	public int getWzrost() {
		return wzrost;
	}

	public void setWzrost(int wzrost) {
		this.wzrost = wzrost;
	}

	public String getAktywnosc() {
		return aktywnosc;
	}

	public void setAktywnosc(String aktywnosc) {
		this.aktywnosc = aktywnosc;
	}

	public double getBmr() {
		return bmr;
	}

	public void setBmr(double bmr) {
		this.bmr = bmr;
	}

	public double getKalorie() {
		return kalorie;
	}

	public void setKalorie(double kalorie) {
		this.kalorie = kalorie;
	}
	@Inject
	FacesContext ctx;

	public boolean obliczKalorie() {
		try {
			String plec=this.plec;
			int wiek=this.wiek;
			int waga=this.waga;
			int wzrost=this.wzrost;
			String aktywnosc=this.aktywnosc;						
			
			//oblicz bmr w zaleznosci od plci
			switch(plec) {
			case "m":
				bmr=66.47+(13.75*waga)+(5.003*wzrost)-(6.755*wiek);
				break;
			case "f":
				bmr=65.51+(9.563*waga)+(1.85*wzrost)-(4.676*wiek);
				break;
			}
			//oblicz kalorie w zaleznosci od aktywnosci
			switch(aktywnosc) {
			case "brak":
				kalorie=bmr;
				break;
			case "mala":
				kalorie=bmr*1.3;
				break;
			case "srednia":
				kalorie=bmr*1.5;
				break;
			case "duza":
				kalorie=bmr*1.7;
				break;
			case "bardzoduza":
				kalorie=bmr*1.9;
				break;
			}
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Blad podczas przetwarzania parametrow", null));
			return false;
		}
	}
	
	public String calc() {
		if(obliczKalorie()) {
		return "pokazWynik";
		}
		return null;
	}

	
		
}
