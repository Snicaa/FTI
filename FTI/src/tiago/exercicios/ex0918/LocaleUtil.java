package tiago.exercicios.ex0918;

import java.text.NumberFormat;
import java.util.Locale;

public class LocaleUtil {
	
	/** Armazena o locale a ser utilizado pelo sistema.*/
	private static Locale locale; 
	
	/**
	 * Obt�m o locale utilizado pela aplica��o.
	 * 
	 * @return Locale utilizado pela aplica��o.
	 */
	public static Locale getLocale() {		
		if (locale == null) {	
			locale = new Locale("pt", "BR");	
		}
		return locale;
	}
	public static String formataValor(double vlr, boolean retornaZero) {
		String retorno = "";
		NumberFormat numFormat = NumberFormat.getInstance(LocaleUtil.getLocale()); 
		numFormat.setMinimumFractionDigits(2);
		numFormat.setMaximumFractionDigits(5);
		numFormat.setMinimumIntegerDigits(1);
		retorno = numFormat.format(vlr);
		
		if (vlr == 0 && !retornaZero) {
			retorno = "";
		}		
		
		return "R$" + retorno;
	}
}