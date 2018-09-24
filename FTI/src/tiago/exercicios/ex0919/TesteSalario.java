package tiago.exercicios.ex0919;

import javax.swing.JOptionPane;
import tiago.exercicios.ex0918.LocaleUtil;

public class TesteSalario {

	public static void main(String[] args) {
		CalculaSalario cs = new CalculaSalario();
		Object[] op��es = { "Com comiss�o", "Sem comiss�o", "Cancelar" };
		int n = JOptionPane.showOptionDialog(null, "Calcular sal�rio com ou sem comiss�o?", "Calcular sal�rio",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, op��es, op��es[2]);
		if (n == 0) {
			double salario = Double.parseDouble(JOptionPane.showInputDialog("Insira o s�lario"));
			double comissao = Double.parseDouble(JOptionPane.showInputDialog("Insira a comiss�o"));
			JOptionPane.showMessageDialog(null, LocaleUtil.formataValor(cs.calculaSalario(salario, comissao), true), "Sal�rio do funcion�rio com comiss�o", JOptionPane.DEFAULT_OPTION);
		} else if (n == 1){
			double salario = Double.parseDouble(JOptionPane.showInputDialog("Insira o Salario"));
			JOptionPane.showMessageDialog(null, LocaleUtil.formataValor(cs.calculaSalario(salario), true), "Sal�rio do funcion�rio sem comiss�o", JOptionPane.DEFAULT_OPTION);
		}
	}
}