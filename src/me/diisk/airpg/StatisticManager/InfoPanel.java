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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import me.diisk.airpg.CustomList.CustomList;

public class InfoPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int id;
	protected StatisticType type = StatisticType.ALL;
	protected boolean[] showing = new boolean[] {true,true,true,true};
	protected int orderBy = MainStatisticUI.VICTORY;
	protected String filter = "";
	protected String agroup = "";
	protected StatisticManager statisticManager = null;
	protected CustomList<OrdenableStatistic> osList = new CustomList<OrdenableStatistic>();
	
	private JLabel lblTitle = new JLabel("",SwingConstants.CENTER);
	private JTable table = new JTable();
	private JScrollPane sp = new JScrollPane(table);
	
	
	protected InfoPanel(){
		add(sp);
		setBorder(new LineBorder(Color.BLACK));
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
	
	private String normalize(String str) {
		String r = str.toLowerCase();
		r = r.replaceAll("[áàâã]", "a");
		r = r.replaceAll("[éèê]", "e");
		r = r.replaceAll("[íìî]", "i");
		r = r.replaceAll("[óòôõ]", "o");
		r = r.replaceAll("[úùû]", "u");
		r = r.replaceAll("[ç]", "c");
		return r;
	}
	
	private CustomList<OrdenableStatistic> filter(CustomList<OrdenableStatistic> osl){
		CustomList<OrdenableStatistic> r = new CustomList<OrdenableStatistic>();
		if(!filter.equalsIgnoreCase("")) {
			String[] filters = filter.split(",");
			for(String filter:filters) {
				String[] words = filter.split("/");
				o:
				for(int i=0;i<osl.size();i++) {
					OrdenableStatistic os = osl.get(i);
					w:
					for(String word:words) {
						for(String osw:os.getName().split("/")) {
							System.out.println(osw+" "+word);
							if(normalize(osw).matches(".*"+normalize(word)+".*")) {
								continue w;
							}
						}
						continue o;
					}
					if(!r.contains(os)) {
						r.add(os);
					}
					
				}
			}
			return r;
		}
		return osl;
	}
	
	private CustomList<OrdenableStatistic> agroup(CustomList<OrdenableStatistic> osl){
		CustomList<OrdenableStatistic> r = new CustomList<OrdenableStatistic>();
		if(!agroup.equalsIgnoreCase("")) {
			String[] groups = agroup.split(",");
			g:
			for(String group:groups) {
				String name = "GRUPO: "+normalize(group).toUpperCase()+"********************************************************************************";
				for(int i=0;i<r.size();i++) {
					OrdenableStatistic os = r.get(i);
					if(os.getName().equalsIgnoreCase(name)) {
						continue g;
					}
				}
				String[] words = group.split("/");
				int count = 0;
				int[] values = new int[3];
				int allBattlesCount = 0;
				o:
				for(int i=0;i<osl.size();i++) {
					OrdenableStatistic os = osl.get(i);
					boolean skip = true;
					w:
					for(String word:words) {
						skip = false;
						for(String osw:os.getName().split("/")) {
							if(normalize(osw).matches(".*"+normalize(word)+".*")) {
								continue w;
							}
						}
						if(!r.contains(os)) {
							r.add(os);
						}
						continue o;
					}
					if(!skip) {
						count++;
						allBattlesCount+=os.getAllBattlesCount();
						for(int i2=0;i2<values.length;i2++) {
							values[i2] += os.getValues()[i2];
						}
					}
					
				}
				if(count>0) {
					r.add(new OrdenableStatistic(name, values, allBattlesCount));
				}
			}
			return r;
		}
		return osl;
	}
	
	public void updateTable() {
		remove(lblTitle);
		lblTitle = new JLabel(type+"",SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		add(lblTitle);
		lblTitle.setText(type+"");
		
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
			CustomList<OrdenableStatistic> osl = filter(agroup(statisticManager.getOrdenableStatistic(type.getID())));
			osList = osl;
			osList.orderBy(orderBy, false, true);
			for(int i=0;i<osList.size();i++) {
				OrdenableStatistic os = osList.get(i);
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
		resize();
	}
	
	public void resize() {
		lblTitle.setSize(translateDim(getSize(), 0.94, 0.04));
		lblTitle.setLocation((int)(getSize().width*0.03), (int)(getSize().height*0.02));
		
		sp.setSize(translateDim(getSize(), 0.94, 0.83));
		sp.setLocation((int)(getSize().width*0.023), (int)(getSize().height*0.07));
		double mod = 0.7/(table.getColumnCount());
		for(int i=0;i<table.getColumnCount();i++) {
			TableColumn tc = table.getColumnModel().getColumn(i);
			if(i==0) {
				tc.setPreferredWidth((int) (sp.getWidth()*(0.3+mod)));
			}else {
				tc.setPreferredWidth((int) (sp.getWidth()*mod));
			}
			
		}
	}
	
	private static Dimension translateDim(Dimension parent, double widthP, double heightP) {
		return new Dimension((int)(widthP*parent.width), (int)(heightP*parent.height));
	}
	
}
