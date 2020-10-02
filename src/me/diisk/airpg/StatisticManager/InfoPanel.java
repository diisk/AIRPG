package me.diisk.airpg.StatisticManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import me.diisk.airpg.CustomList.CustomList;

public class InfoPanel extends JPanel{

	protected int id;
	protected StatisticType type = StatisticType.ALL;
	protected boolean[] showing = new boolean[] {true,true,true,true};
	protected int orderBy = MainStatisticUI.VICTORY;
	protected String filter = "";
	protected String agroup = "";
	protected StatisticManager statisticManager = null;
	
	private JLabel lblTitle = new JLabel("",SwingConstants.CENTER);
	private JLabel lblCloseTab = new JLabel("X",SwingConstants.CENTER);
	private JLabel lblNewTab = new JLabel("+",SwingConstants.CENTER);
	private JTable table = new JTable();
	private JScrollPane sp = new JScrollPane(table);
	
	
	protected InfoPanel(){
		add(lblTitle);
		add(lblCloseTab);
		add(lblNewTab);
		add(sp);
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		
		lblCloseTab.setVerticalAlignment(SwingConstants.CENTER);
		lblCloseTab.setFont(new Font("Arial", Font.BOLD, 20));
		lblCloseTab.setBackground(Color.DARK_GRAY);
		
		lblNewTab.setVerticalAlignment(SwingConstants.CENTER);
		lblNewTab.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewTab.setForeground(Color.DARK_GRAY);
		lblNewTab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainStatisticUI.getInstance().addInfoPanel(new InfoPanel());
			}
		});
	}
	
	public void clearIP() {
		type = StatisticType.ALL;
		for(int i=0;i<showing.length;i++) {
			showing[i]=true;
		}
		orderBy=MainStatisticUI.VICTORY;
		filter="";
		agroup="";
		updateTable();
	}
	
	public String getGroupName() {
		return "";//FAZER AINDA
	}
	
	public void updateTable() {
		lblTitle.setText(type.toString()+(getGroupName().equalsIgnoreCase("")?"":" ("+getGroupName()+")"));
		Vector<String> columnNames = new Vector<String>();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		columnNames.add("Descrição");
		for(int i=0;i<showing.length;i++) {
			boolean mod = showing[i];
			if(mod) {
				switch(i) {
				case MainStatisticUI.VICTORY:
					columnNames.add("Vitórias");
					break;
				case MainStatisticUI.DEFEAT:
					columnNames.add("Derrotas");
					break;
				case MainStatisticUI.DRAW:
					columnNames.add("Empates");
					break;
				case MainStatisticUI.PARTICIPATION:
					columnNames.add("Participações");
					break;
				}
			}
		}
		
		if(statisticManager!=null) {
			CustomList<OrdenableStatistic> osl = statisticManager.getOrdenableStatistic(type.getID());
			osl.orderBy(orderBy, false, true);
			for(int i=0;i<osl.size();i++) {
				OrdenableStatistic os = osl.get(i);
				System.out.println(os.toString());
				Vector<String> row = new Vector<String>();
				row.add(os.getName());
				for(int i2=0;i2<showing.length;i2++) {
					if(showing[i2]) {
						switch(i2) {
						case MainStatisticUI.VICTORY:
							row.add(os.getVictories());
							break;
						case MainStatisticUI.DEFEAT:
							row.add(os.getDefeats());
							break;
						case MainStatisticUI.DRAW:
							row.add(os.getDraws());
							break;
						case MainStatisticUI.PARTICIPATION:
							row.add(os.getParticipations());
							break;
						}
					}
				}
				data.add(row);
			}
		}
		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		table.setModel(dtm);
		for(int i=0;i<table.getColumnCount();i++) {
			TableColumn tc = table.getColumnModel().getColumn(i);
			tc.setResizable(false);
		}
		resize();
	}
	
	public void resize() {
		lblTitle.setSize(translateDim(getSize(), 0.60, 0.04));
		lblTitle.setLocation((int)(getSize().width*0.2), (int)(getSize().height*0.02));
		
		lblCloseTab.setSize(translateDim(getSize(), 0.04, 0.04));
		lblCloseTab.setLocation((int)(getSize().width*0.94), (int)(getSize().height*0.01));
		
		lblNewTab.setSize(translateDim(getSize(), 0.04, 0.04));
		lblNewTab.setLocation((int)(getSize().width*0.9), (int)(getSize().height*0.01));
		
		sp.setSize(translateDim(getSize(), 0.94, 0.83));
		sp.setLocation((int)(getSize().width*0.023), (int)(getSize().height*0.07));
		double mod = 0.5/(table.getColumnCount());
		for(int i=0;i<table.getColumnCount();i++) {
			TableColumn tc = table.getColumnModel().getColumn(i);
			if(i==0) {
				tc.setPreferredWidth((int) (sp.getWidth()*(0.5+mod)));
			}else {
				tc.setPreferredWidth((int) (sp.getWidth()*mod));
			}
			
		}
	}
	
	private static Dimension translateDim(Dimension parent, double widthP, double heightP) {
		return new Dimension((int)(widthP*parent.width), (int)(heightP*parent.height));
	}
	
}
