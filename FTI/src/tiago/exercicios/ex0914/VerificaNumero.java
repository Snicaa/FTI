package tiago.exercicios.ex0914;

import javax.swing.JOptionPane;

public class VerificaNumero {

	public static void main(String[] args) {
		int n = Integer.parseInt(JOptionPane.showInputDialog("Insira o n�mero"));
		if (n > 5) {
			JOptionPane.showMessageDialog(null, n + " � maior do que 5");
		} else {
			if (n < 5) {
				JOptionPane.showMessageDialog(null, n + " � menor do que 5");
			} else {
				JOptionPane.showMessageDialog(null, n + " � igual a 5");
			}
		}
	}
}