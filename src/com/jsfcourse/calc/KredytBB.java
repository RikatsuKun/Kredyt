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
public class KredytBB {
	private String x;
	private String y;
	private Double result;

	@Inject
	FacesContext ctx;

	
	public String calc() {
		
		return null;
	}

	// Put result in messages on AJAX call
	public String calc_AJAX() {
		
		return null;
	}

}
