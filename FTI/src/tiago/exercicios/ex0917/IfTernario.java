package tiago.exercicios.ex0917;

import javax.swing.JOptionPane;

public class IfTernario {
	public static void main(String[] args) {
		int n = Integer.parseInt(JOptionPane.showInputDialog("Insira o n�mero"));
		JOptionPane.showMessageDialog(null, (n > 5) ? n + " � maior do que 5" : 
			(n < 5)? n + " � menor que 5" : n + " � 5");
	}
}