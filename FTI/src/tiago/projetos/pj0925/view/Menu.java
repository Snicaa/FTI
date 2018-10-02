package tiago.projetos.pj0925.view;

import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import tiago.projetos.pj0925.controller.ControllerMenu;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Menu {

	private JFrame frame;
	private JTable table;
	private JTable tabelaFuncionario;
	private JTable tabelaProfessor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		CadastroAluno cA = new CadastroAluno();
		ControllerMenu cM = new ControllerMenu();
		cA.getFrame().setVisible(false);
		frame = new JFrame("Cadastro FTI");
		frame.setBounds(100, 100, 800, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 784, 487);
		frame.getContentPane().add(tabbedPane);
		
		JPanel abaAluno = new JPanel();
		tabbedPane.addTab("Lista de Alunos", null, abaAluno, null);
		abaAluno.setLayout(null);
		
		JScrollPane scrollTabelaAluno = new JScrollPane();
		scrollTabelaAluno.setBounds(10, 11, 445, 437);
		abaAluno.add(scrollTabelaAluno);
		
		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] {"Matr�cula", "CPF", "Nome", "Curso"});
		cM.geraListaAluno(model);
		table = new JTable();
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(109);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(135);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(258);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(121);
		scrollTabelaAluno.setViewportView(table);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setEnabled(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel containerTextAluno = new JPanel();
		containerTextAluno.setBorder(new LineBorder(new Color(0, 0, 0)));
		containerTextAluno.setBounds(465, 11, 304, 437);
		abaAluno.add(containerTextAluno);
		containerTextAluno.setLayout(null);
		
		JTextPane textPaneAluno = new JTextPane();
		textPaneAluno.setForeground(Color.black);
		textPaneAluno.setBackground(UIManager.getColor("TextPane.disabledBackground"));
		textPaneAluno.setEnabled(true);
		textPaneAluno.setMargin(new Insets(15, 15, 15, 15));
		textPaneAluno.setEditable(false);
		textPaneAluno.setBounds(10, 11, 284, 381);		
		textPaneAluno.setBorder(new LineBorder(Color.lightGray));
		containerTextAluno.add(textPaneAluno);
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				try {
					textPaneAluno.setText(cM.setTextTabela(table.getSelectedRow()));
				} catch(Exception xcp){
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				int linha = table.rowAtPoint(e.getPoint());
				table.addMouseMotionListener(new MouseMotionListener() {
					
					@Override
					public void mouseMoved(MouseEvent evt) {
						int linha2 = table.rowAtPoint(evt.getPoint());
						if (linha2 != linha) {
							textPaneAluno.setText(cM.setTextTabela(linha2));
						}
					}
					
					@Override
					public void mouseDragged(MouseEvent e) {
					}
				});
				textPaneAluno.setText(cM.setTextTabela(linha));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {	
			}
		});
		
		JButton botaoAdicionarAluno = new JButton("Adicionar");
		botaoAdicionarAluno.setBounds(10, 403, 89, 23);
		botaoAdicionarAluno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cA.getFrame().setVisible(true);
				cA.getBtnClear().doClick();
			}
		});
		containerTextAluno.add(botaoAdicionarAluno);
		
		JButton botaoRemoverAluno = new JButton("Remover");
		botaoRemoverAluno.setBounds(205, 403, 89, 23);
		botaoRemoverAluno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Object[] escolhas = {"Sim", "N�o"};
					JOptionPane.showOptionDialog(null, "Deseja remover " + ControllerMenu.getArrayAluno().get(table.getSelectedRow()).getNome() + "?", "Confirmar remo��o", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, escolhas, escolhas[1]);
				} catch (Exception xcp) {
					JOptionPane.showMessageDialog(null, "Nenhum aluno selecionado", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		containerTextAluno.add(botaoRemoverAluno);
		
		JButton botaoEditarAluno = new JButton("Editar");
		botaoEditarAluno.setBounds(107, 403, 89, 23);
		botaoEditarAluno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cA.getFrame().setVisible(true);
				try {
					ControllerMenu.getArrayAluno().get(table.getSelectedRow());
				} catch (Exception xcp) {
					JOptionPane.showMessageDialog(null, "Nenhum aluno selecionado", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		containerTextAluno.add(botaoEditarAluno);
		
		JPanel abaFuncionario = new JPanel();
		abaFuncionario.setLayout(null);
		tabbedPane.addTab("Lista de Funcion�rios", null, abaFuncionario, null);
		
		JPanel containerTextFuncionario = new JPanel();
		containerTextFuncionario.setLayout(null);
		containerTextFuncionario.setBorder(new LineBorder(new Color(0, 0, 0)));
		containerTextFuncionario.setBounds(465, 11, 304, 437);
		abaFuncionario.add(containerTextFuncionario);
		
		JTextPane textPaneFuncionario = new JTextPane();
		textPaneFuncionario.setText("TESTESTE\\nTESTE");
		textPaneFuncionario.setForeground(Color.WHITE);
		textPaneFuncionario.setEnabled(false);
		textPaneFuncionario.setEditable(false);
		textPaneFuncionario.setBackground(SystemColor.menu);
		textPaneFuncionario.setBounds(10, 11, 284, 381);
		containerTextFuncionario.add(textPaneFuncionario);
		
		JButton botaoAdicionarFuncionario = new JButton("Adicionar");
		botaoAdicionarFuncionario.setBounds(10, 403, 89, 23);
		containerTextFuncionario.add(botaoAdicionarFuncionario);
		
		JButton botaoRemoverFuncionario = new JButton("Remover");
		botaoRemoverFuncionario.setBounds(205, 403, 89, 23);
		containerTextFuncionario.add(botaoRemoverFuncionario);
		
		JButton botaoEditarFuncionario = new JButton("Editar");
		botaoEditarFuncionario.setBounds(107, 403, 89, 23);
		containerTextFuncionario.add(botaoEditarFuncionario);
		
		JScrollPane scrollTabelaFuncionario = new JScrollPane();
		scrollTabelaFuncionario.setBounds(10, 11, 445, 437);
		abaFuncionario.add(scrollTabelaFuncionario);
		
		tabelaFuncionario = new JTable();
		scrollTabelaFuncionario.setViewportView(tabelaFuncionario);
		tabelaFuncionario.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo do cadastro", "CPF", "Nome", "Cargo", "Salario"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaFuncionario.getColumnModel().getColumn(0).setResizable(false);
		tabelaFuncionario.getColumnModel().getColumn(0).setPreferredWidth(108);
		tabelaFuncionario.getColumnModel().getColumn(1).setResizable(false);
		tabelaFuncionario.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabelaFuncionario.getColumnModel().getColumn(2).setResizable(false);
		tabelaFuncionario.getColumnModel().getColumn(2).setPreferredWidth(207);
		tabelaFuncionario.getColumnModel().getColumn(3).setResizable(false);
		tabelaFuncionario.getColumnModel().getColumn(3).setPreferredWidth(111);
		tabelaFuncionario.getColumnModel().getColumn(4).setResizable(false);
		tabelaFuncionario.getColumnModel().getColumn(4).setPreferredWidth(78);
		tabelaFuncionario.setToolTipText("Lista de Funcionarios cadastrados");
		tabelaFuncionario.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabelaFuncionario.setRowSelectionAllowed(false);
		tabelaFuncionario.setEnabled(false);
		
		JPanel abaProfessor = new JPanel();
		abaProfessor.setLayout(null);
		tabbedPane.addTab("Lista de Professores", null, abaProfessor, null);
		
		JPanel containerTextProfessor = new JPanel();
		containerTextProfessor.setLayout(null);
		containerTextProfessor.setBorder(new LineBorder(new Color(0, 0, 0)));
		containerTextProfessor.setBounds(465, 11, 304, 437);
		abaProfessor.add(containerTextProfessor);
		
		JTextPane textPaneProfessor = new JTextPane();
		textPaneProfessor.setText("TESTESTE\\nTESTE");
		textPaneProfessor.setForeground(Color.WHITE);
		textPaneProfessor.setEnabled(false);
		textPaneProfessor.setEditable(false);
		textPaneProfessor.setBackground(SystemColor.menu);
		textPaneProfessor.setBounds(10, 11, 284, 381);
		containerTextProfessor.add(textPaneProfessor);
		
		JButton botaoAdicionarProfessor = new JButton("Adicionar");
		botaoAdicionarProfessor.setBounds(10, 403, 89, 23);
		containerTextProfessor.add(botaoAdicionarProfessor);
		
		JButton botaoRemoverProfessor = new JButton("Remover");
		botaoRemoverProfessor.setBounds(205, 403, 89, 23);
		containerTextProfessor.add(botaoRemoverProfessor);
		
		JButton botaoEditarProfessor = new JButton("Editar");
		botaoEditarProfessor.setBounds(107, 403, 89, 23);
		containerTextProfessor.add(botaoEditarProfessor);
		
		JScrollPane scrollTabelaProfessor = new JScrollPane();
		scrollTabelaProfessor.setBounds(10, 11, 445, 437);
		abaProfessor.add(scrollTabelaProfessor);
		
		tabelaProfessor = new JTable();
		scrollTabelaProfessor.setViewportView(tabelaProfessor);
		tabelaProfessor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo do cadastro", "CPF", "Nome", "Disciplina", "Salario"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaProfessor.getColumnModel().getColumn(0).setResizable(false);
		tabelaProfessor.getColumnModel().getColumn(0).setPreferredWidth(113);
		tabelaProfessor.getColumnModel().getColumn(1).setResizable(false);
		tabelaProfessor.getColumnModel().getColumn(1).setPreferredWidth(115);
		tabelaProfessor.getColumnModel().getColumn(2).setResizable(false);
		tabelaProfessor.getColumnModel().getColumn(2).setPreferredWidth(209);
		tabelaProfessor.getColumnModel().getColumn(3).setResizable(false);
		tabelaProfessor.getColumnModel().getColumn(3).setPreferredWidth(106);
		tabelaProfessor.getColumnModel().getColumn(4).setResizable(false);
		tabelaProfessor.getColumnModel().getColumn(4).setPreferredWidth(81);
		tabelaProfessor.setToolTipText("Lista de professores cadastrados");
		tabelaProfessor.setRowSelectionAllowed(false);
		tabelaProfessor.setEnabled(false);
		tabelaProfessor.setBorder(new LineBorder(new Color(0, 0, 0)));
	}
}