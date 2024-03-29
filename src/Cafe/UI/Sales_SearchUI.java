package Cafe.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Sales_SearchUI {

	private JFrame frame;
	private static JTextField StartDay;
	private static JTextField EndDay;
	String headers[]={"주문일시", "주문횟수", "합계"};
	DefaultTableModel model = new DefaultTableModel (headers, 0);
	private JTable table;
	
	public Sales_SearchUI() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setTitle("매출조회");
		frame.setBounds(220, 130, 544, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		StartDay = new JTextField();
		StartDay.setBounds(85, 50, 60, 21);
		frame.getContentPane().add(StartDay);
		StartDay.setColumns(10);
		StartDay.setForeground(Color.black);
		StartDay.setEditable(false);
		
		EndDay = new JTextField();
		EndDay.setBounds(232, 50, 60, 21);
		frame.getContentPane().add(EndDay);
		EndDay.setColumns(10);
		EndDay.setForeground(Color.black);
		EndDay.setEditable(false);
		
		JLabel StartDay_lbl = new JLabel("기간");
		StartDay_lbl.setFont(new Font("굴림", Font.BOLD, 15));
		StartDay_lbl.setBounds(46, 53, 38, 18);
		StartDay_lbl.setForeground(Color.WHITE);
		StartDay_lbl.setBackground(Color.WHITE);
		frame.getContentPane().add(StartDay_lbl);
		
		JLabel EndDay_lbl = new JLabel("~");
		EndDay_lbl.setBounds(207, 53, 21, 15);
		EndDay_lbl.setFont(new Font("굴림", Font.BOLD, 15));
		EndDay_lbl.setForeground(Color.WHITE);
		EndDay_lbl.setBackground(Color.WHITE);
		frame.getContentPane().add(EndDay_lbl);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\OBJ\\PROJECT\\Cafe_Kiosk\\image\\calendar.png");
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(28, 25, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JButton Open_Cal = new JButton(changeIcon);
		Open_Cal.setForeground(Color.BLACK);
		Open_Cal.setBackground(Color.WHITE);
		Open_Cal.setBounds(157, 49, 38, 23);
		frame.getContentPane().add(Open_Cal);

		JButton Open_Cal2 = new JButton(changeIcon);
		Open_Cal2.setForeground(Color.BLACK);
		Open_Cal2.setBackground(Color.WHITE);
		Open_Cal2.setBounds(304, 49, 38, 23);
		frame.getContentPane().add(Open_Cal2);
		
		table = new JTable(model);
		table.setBounds(60, 140, 463, 215);
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		table.setRowHeight(45);		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(48, 95, 403, 193);
		frame.getContentPane().add(scrollPane);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(60);  //JTable 의 컬럼 길이 조절
		table.getColumnModel().getColumn(1).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
	    dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
	     
	    TableColumnModel tcm = table.getColumnModel() ; // 정렬할 테이블의 컬럼모델을 가져옴
	    for(int i = 0 ; i < tcm.getColumnCount() ; i++){
	    	tcm.getColumn(i).setCellRenderer(dtcr);  
	    }
		
		JButton SearchButton = new JButton("검색");
		SearchButton.setBounds(362, 42, 66, 36);
		SearchButton.setBackground(Color.WHITE);
		SearchButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		frame.getContentPane().add(SearchButton);
		
		JLabel lblNewLabel = new JLabel("전체 합계 :");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(279, 311, 86, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel Total = new JLabel("");
		Total.setFont(new Font("굴림", Font.BOLD, 15));
		Total.setForeground(Color.WHITE);
		Total.setBounds(365, 311, 66, 22);
		frame.getContentPane().add(Total);
		
		ImageIcon icon2 = new ImageIcon("C:\\Users\\OBJ\\PROJECT\\Cafe_Kiosk\\image\\back.png");
		Image img2 = icon2.getImage();
		Image changeImg2 = img2.getScaledInstance(45, 44, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImg2);
		
		JButton Back_Button = new JButton(changeIcon2);
		Back_Button.setBounds(46, 307, 67, 45);
		Back_Button.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		Back_Button.setForeground(Color.BLACK);
		Back_Button.setBackground(Color.WHITE);
		frame.getContentPane().add(Back_Button);
		
		Open_Cal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = "Start_Sale";
				Calendar_SearchUI Calendar_Search = new Calendar_SearchUI(type);
				Calendar_Search.setVisible(true);
			}		
		});
		
		Open_Cal2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = "End_Sale";
				Calendar_SearchUI Calendar_Search = new Calendar_SearchUI(type);
				Calendar_Search.setVisible(true);
			}		
		});
		
		Back_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JFrame AdminUI = new AdminUI();
				AdminUI.setVisible(true);
			}		
		});
		
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setNumRows(0);
				String Start = StartDay.getText();
				String End = EndDay.getText();
				String Total_Price = Record_show(Start, End);
				Total.setText(Total_Price);
			}		
		});
	}
	
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
	
	public static void setStartDay(String Start) {
		StartDay.setText(Start);
	}
	
	public static void setEndDay(String End) {
		EndDay.setText(End);
	}
	
	protected String Record_show(String Start, String End) {
		
		Record_DAO dao = new Record_DAO();
		ArrayList<Record_DTO> result = dao.Menu_search(Start, End);
		String row[] = new String[3];
		SimpleDateFormat fmt=new SimpleDateFormat("yy-MM-dd");
		int Total = 0;
		String result_Total = "";
		
		for (Record_DTO i : result) {
			Date temp_date = i.getRecord_Date();
			int temp_count = i.getCount();
			int temp_total = i.getTotal();
			
			Total += temp_total;
			
			row[0] = fmt.format(temp_date);
	    	row[1] = Integer.toString(temp_count);
	    	row[2] = Integer.toString(temp_total);
	    	
	    	model.addRow(row);
	    }
		
		result_Total = Integer.toString(Total);
		return result_Total;
	}
}
	

