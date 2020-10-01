package me.diisk.airpg.StatisticManager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.io.File;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import me.diisk.airpg.ObjectRAW;

public class MainStatisticUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MainStatisticUI instance = null;
	private static final Dimension MIN_SIZE = new Dimension(1200, 700);
	private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	
	private StatisticManager sm = null;
	
	private JPanel topPanel = new JPanel();
	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	
	//TOPPANEL COMPONENTS
	private JButton btnSelectFile = new JButton("Open Statistic");
	private JLabel lblFileName = new JLabel("Nome do Arquivo",SwingConstants.CENTER);
	private JLabel lblBattlesCount = new JLabel("Quantidade de Batalhas",SwingConstants.CENTER);
	private JLabel lblTotalDraws= new JLabel("Total de Empates",SwingConstants.CENTER);
	private JLabel lblDuration = new JLabel("Tempo Total",SwingConstants.CENTER);
	private JLabel lblNPCsCount = new JLabel("Quantidade de Variações IA",SwingConstants.CENTER);
	private JLabel lblLevel = new JLabel("Nivel dos IA",SwingConstants.CENTER);
	
	private JTextField txfFileName = new JTextField();
	private JTextField txfBattlesCount = new JTextField();
	private JTextField txfTotalDraws = new JTextField();
	private JTextField txfDuration = new JTextField();
	private JTextField txfNPCsCount = new JTextField();
	private JTextField txfLevel = new JTextField();
	
	//LEFTPANEL COMPONENTS
	private JLabel lblFilterBy = new JLabel("Filtrar por:");
	private JLabel lblOrderBy = new JLabel("Ordenar por:");
	private JLabel lblShow = new JLabel("Mostrar:");
	private JLabel lblAgroupBy = new JLabel("Agrupar por:");
	
	private JTextField txfFilterBy = new JTextField();
	private JTextField txfAgroupBy = new JTextField();
	
	private JRadioButton rbtnWin = new JRadioButton("Vitória");
	private JRadioButton rbtnLose = new JRadioButton("Derrota");
	private JRadioButton rbtnDraw = new JRadioButton("Empate");
	private JRadioButton rbtnParticipation = new JRadioButton("Participação");
	
	private JCheckBox cbWins = new JCheckBox("Vitórias");
	private JCheckBox cbLoses = new JCheckBox("Derrotas");
	private JCheckBox cbDraws = new JCheckBox("Empates");
	private JCheckBox cbParticipations = new JCheckBox("Participações");
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					instance = new MainStatisticUI(MIN_SIZE);
					instance.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static Color getRandomColor(Random random, Color...colors) {
		return colors[random.nextInt(colors.length)];
	}
	
	private static Dimension translateDim(Dimension parent, double widthP, double heightP) {
		return new Dimension((int)(widthP*parent.width), (int)(heightP*parent.height));
	}
	
	private void constructTopPanel() {
		JLabel[] lbls = new JLabel[] {lblBattlesCount,lblDuration,lblNPCsCount,lblTotalDraws,lblLevel,lblFileName};
		JTextField[] txfs = new JTextField[] {txfBattlesCount,txfDuration,txfLevel,txfNPCsCount,txfTotalDraws,txfFileName};
		topPanel.add(btnSelectFile);
		btnSelectFile.setFont(new Font("Arial", Font.BOLD, 15));
		btnSelectFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(new File("").getAbsoluteFile());
				jfc.setDialogTitle("Selecione o LOG de Estatisticas");
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
					    "Arquivos SMOS", "smos");
				jfc.setFileFilter(filter);
				int mod = jfc.showOpenDialog(instance);
				if(mod==JFileChooser.APPROVE_OPTION) {
					File selected = jfc.getSelectedFile();
					Object o = ObjectRAW.fileToObject(selected.getAbsolutePath());
					if(o instanceof StatisticManager) {
						sm = (StatisticManager) o;
						txfFileName.setText(selected.getName());
						txfBattlesCount.setText(sm.getAllBattlesCount()+"");
						txfDuration.setText(sm.getDuration().getTime());
						txfLevel.setText(sm.getLevel()+"");
						txfNPCsCount.setText(sm.getNPCsCount()+"");
						txfTotalDraws.setText(sm.getTotalDraws()+"");
					}else {
						JOptionPane.showMessageDialog(instance, "Não foi possível selecionar o arquivo, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}else if(mod==JFileChooser.ERROR_OPTION){
					JOptionPane.showMessageDialog(instance, "Não foi possível selecionar o arquivo, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		for(JLabel lbl:lbls) {
			lbl.setVerticalAlignment(SwingConstants.CENTER);
			lbl.setFont(new Font("Arial", Font.BOLD, 12));
			topPanel.add(lbl);
		}
		for(JTextField txf:txfs) {
			txf.setEditable(false);
			txf.setHorizontalAlignment(SwingConstants.CENTER);
			topPanel.add(txf);
		}
	}
	
	private void constructLeftPanel() {
		Component[] cps = new Component[] {txfFilterBy,txfAgroupBy,lblFilterBy,lblOrderBy,lblShow,lblAgroupBy,rbtnDraw,rbtnLose,rbtnParticipation,rbtnWin,cbDraws,cbLoses,cbParticipations,cbWins};
		for(Component c:cps) {
			leftPanel.add(c);
			if(c instanceof JRadioButton || c instanceof JCheckBox) {
				c.setBackground(c.getParent().getBackground());
			}else if(c instanceof JLabel) {
				JLabel jl = (JLabel) c;
				jl.setVerticalTextPosition(SwingConstants.BOTTOM);
				jl.setFont(new Font("Arial", Font.BOLD, 15));
				//jl.setBorder(new BevelBorder(BevelBorder.RAISED));
			}
		}
	}
	
	private void resize() {
		Color[] colors = new Color[] {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
		Random random = new Random();
		
		//TOP PANEL
		topPanel.setBackground(getRandomColor(random, colors));
		topPanel.setLocation(0, 0);
		topPanel.setSize(translateDim(getSize(), 1, 0.15));
		
		btnSelectFile.setSize(translateDim(topPanel.getSize(), 0.14, 0.3));
		btnSelectFile.setLocation((int) (topPanel.getWidth()*0.03), topPanel.getHeight()/2-(btnSelectFile.getHeight()/2));
		
		lblFileName.setSize(translateDim(topPanel.getSize(), 0.2, 0.2));
		lblFileName.setLocation((int)(topPanel.getWidth()*0.23), (int)(topPanel.getHeight()*0.055));
		txfFileName.setSize(translateDim(topPanel.getSize(), 0.2, 0.2));
		txfFileName.setLocation((int)(topPanel.getWidth()*0.23), (int)(topPanel.getHeight()*0.255));
		
		lblDuration.setSize(translateDim(topPanel.getSize(), 0.2, 0.2));
		lblDuration.setLocation((int)(topPanel.getWidth()*0.49), (int)(topPanel.getHeight()*0.055));
		txfDuration.setSize(translateDim(topPanel.getSize(), 0.2, 0.2));
		txfDuration.setLocation((int)(topPanel.getWidth()*0.49), (int)(topPanel.getHeight()*0.255));
		
		lblNPCsCount.setSize(translateDim(topPanel.getSize(), 0.2, 0.2));
		lblNPCsCount.setLocation((int)(topPanel.getWidth()*0.75), (int)(topPanel.getHeight()*0.055));
		txfNPCsCount.setSize(translateDim(topPanel.getSize(), 0.2, 0.2));
		txfNPCsCount.setLocation((int)(topPanel.getWidth()*0.75), (int)(topPanel.getHeight()*0.255));
		
		lblBattlesCount.setSize(translateDim(topPanel.getSize(), 0.2, 0.2));
		lblBattlesCount.setLocation((int)(topPanel.getWidth()*0.23), (int)(topPanel.getHeight()*0.495));
		txfBattlesCount.setSize(translateDim(topPanel.getSize(), 0.2, 0.2));
		txfBattlesCount.setLocation((int)(topPanel.getWidth()*0.23), (int)(topPanel.getHeight()*0.695));
		
		lblTotalDraws.setSize(translateDim(topPanel.getSize(), 0.2, 0.2));
		lblTotalDraws.setLocation((int)(topPanel.getWidth()*0.49), (int)(topPanel.getHeight()*0.495));
		txfTotalDraws.setSize(translateDim(topPanel.getSize(), 0.2, 0.2));
		txfTotalDraws.setLocation((int)(topPanel.getWidth()*0.49), (int)(topPanel.getHeight()*0.695));
		
		lblLevel.setSize(translateDim(topPanel.getSize(), 0.2, 0.2));
		lblLevel.setLocation((int)(topPanel.getWidth()*0.75), (int)(topPanel.getHeight()*0.495));
		txfLevel.setSize(translateDim(topPanel.getSize(), 0.2, 0.2));
		txfLevel.setLocation((int)(topPanel.getWidth()*0.75), (int)(topPanel.getHeight()*0.695));
		
		//LEFTPANEL
		leftPanel.setBackground(getRandomColor(random, colors));
		leftPanel.setLocation(0, topPanel.getHeight());
		leftPanel.setSize(translateDim(getSize(), 0.2, 0.85));
		
		lblFilterBy.setSize(translateDim(leftPanel.getSize(), 0.94, 0.04));
		lblFilterBy.setLocation((int)(leftPanel.getSize().width*0.03), (int)(leftPanel.getSize().height*0.08));
		txfFilterBy.setSize(translateDim(leftPanel.getSize(), 0.94, 0.04));
		txfFilterBy.setLocation((int)(leftPanel.getSize().width*0.03), (int)(leftPanel.getSize().height*0.13));
		
		lblOrderBy.setSize(translateDim(leftPanel.getSize(), 0.94, 0.04));
		lblOrderBy.setLocation((int)(leftPanel.getSize().width*0.03), (int)(leftPanel.getSize().height*0.2));
		rbtnWin.setSize(translateDim(leftPanel.getSize(), 0.45, 0.04));
		rbtnWin.setLocation((int)(leftPanel.getSize().width*0.03), (int)(leftPanel.getSize().height*0.255));
		rbtnLose.setSize(translateDim(leftPanel.getSize(), 0.45, 0.04));
		rbtnLose.setLocation((int)(leftPanel.getSize().width*0.52), (int)(leftPanel.getSize().height*0.255));
		rbtnDraw.setSize(translateDim(leftPanel.getSize(), 0.45, 0.04));
		rbtnDraw.setLocation((int)(leftPanel.getSize().width*0.03), (int)(leftPanel.getSize().height*0.31));
		rbtnParticipation.setSize(translateDim(leftPanel.getSize(), 0.45, 0.04));
		rbtnParticipation.setLocation((int)(leftPanel.getSize().width*0.52), (int)(leftPanel.getSize().height*0.31));
		
		lblShow.setSize(translateDim(leftPanel.getSize(), 0.94, 0.04));
		lblShow.setLocation((int)(leftPanel.getSize().width*0.03), (int)(leftPanel.getSize().height*0.38));
		cbWins.setSize(translateDim(leftPanel.getSize(), 0.45, 0.04));
		cbWins.setLocation((int)(leftPanel.getSize().width*0.03), (int)(leftPanel.getSize().height*0.435));
		cbLoses.setSize(translateDim(leftPanel.getSize(), 0.45, 0.04));
		cbLoses.setLocation((int)(leftPanel.getSize().width*0.52), (int)(leftPanel.getSize().height*0.435));
		cbDraws.setSize(translateDim(leftPanel.getSize(), 0.45, 0.04));
		cbDraws.setLocation((int)(leftPanel.getSize().width*0.03), (int)(leftPanel.getSize().height*0.49));
		cbParticipations.setSize(translateDim(leftPanel.getSize(), 0.45, 0.04));
		cbParticipations.setLocation((int)(leftPanel.getSize().width*0.52), (int)(leftPanel.getSize().height*0.49));
		
		lblAgroupBy.setSize(translateDim(leftPanel.getSize(), 0.94, 0.04));
		lblAgroupBy.setLocation((int)(leftPanel.getSize().width*0.03), (int)(leftPanel.getSize().height*0.56));
		txfAgroupBy.setSize(translateDim(leftPanel.getSize(), 0.94, 0.04));
		txfAgroupBy.setLocation((int)(leftPanel.getSize().width*0.03), (int)(leftPanel.getSize().height*0.61));
		
		rightPanel.setBackground(getRandomColor(random, colors));
		rightPanel.setLocation(leftPanel.getWidth(), topPanel.getHeight());
		rightPanel.setSize(translateDim(getSize(), 0.8, 0.85));
	}
	
	public MainStatisticUI(Dimension minSize){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(SCREEN_SIZE.width/2-(minSize.width/2), SCREEN_SIZE.height/2-(minSize.height/2));
		setSize(minSize);
		setMinimumSize(minSize);
		setTitle("Satistic Manager");
		getContentPane().setLayout(null);
		getContentPane().add(topPanel);
		getContentPane().add(leftPanel);
		getContentPane().add(rightPanel);
		resize();
		addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				resize();
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		constructTopPanel();
		constructLeftPanel();
	}
	
}
