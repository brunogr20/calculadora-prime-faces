package controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.script.*;

@ManagedBean(name = "CalculadoraBean")
@SessionScoped
public class CalculadoraBean implements Serializable{
	
	//private static final long serialVersionUID = 1L;
	private String display = "";
	
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		 this.display=display;
	}
	
	
	public void add1() {
		this.addDigito(1);
	}
	public void add2() {
		this.addDigito(2);
	}
	public void add3() {
		this.addDigito(3);
	}
	public void add4() {
		this.addDigito(4);
	}
	public void add5() {
		this.addDigito(5);
	}
	public void add6() {
		this.addDigito(6);
	}
	public void add7() {
		this.addDigito(7);
	}
	public void add8() {
		this.addDigito(8);
	}
	public void add9() {
		this.addDigito(9);
	}
	public void add0() {
		this.addDigito(0);
	}
	public void addPonto() {
		this.addSimbolo(".");
	}
	public void addSoma() {
		this.addSimbolo("+");
	}
	public void addSubtracao() {
		this.addSimbolo("-");
	}
	public void addDivisao() {
		this.addSimbolo("/");
	}
	public void addMultiplicacao() {
		this.addSimbolo("*");
	}
	public void addParentese() {}
	public void addPencentual() {}
	
	public void corrigir() {
		if (display.length() > 0) {
			display = display.substring (0, display.length() - 1);
		}
	}
	
	public void addDigito(int digito) {
		System.out.println(display);
		/*if(display.equals("0")) {
			System.out.println("d111: "+digito);
		}else {*/
			display = display + digito;
		//}
	}
	public void addSimbolo(String s) {
		if(!display.equals("")){
		    String ultimoCaracter =	display.substring (display.length() - 1);
			if(!ultimoCaracter.equals("/")&&!ultimoCaracter.equals("*")&&!ultimoCaracter.equals("-")&&!ultimoCaracter.equals("+")){
				display = display + s;
			}
		}
	}
	
	public void addC() {
		display ="";
	}
	
	public void calcular(){
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        // evaluate JavaScript code from String
        try {
			Object obj = engine.eval(display);
			display = obj.toString();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	

}
