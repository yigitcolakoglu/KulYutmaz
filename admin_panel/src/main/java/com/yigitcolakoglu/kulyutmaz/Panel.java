package com.yigitcolakoglu.kulyutmaz;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jfree.data.general.DefaultPieDataset;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import org.json.*;
import java.awt.*;
import java.io.*;
import java.sql.Date;
import java.util.*;
import java.sql.*;

/**
 *
 * @author YigitColakoglu    
 */
public class Panel extends javax.swing.JFrame {

	public static final Color BACKGROUND_COLOR = new Color(41, 42, 50);
	public static final Color FOREGROUND_COLOR = new Color(238, 238, 238);
	public Connection mysql_conn;
	private ChartPanel hourlyMailChartPanel;
	private JFreeChart hourlyMailJFreeChart;
	private String config_file_loc = null;
	private JSONObject config;
	private Process python_proc = null;
	private BufferedWriter python_out = null;
	private JFreeChart lineChart;
	private JFreeChart pieChart;
	private ChartPanel lineChartPanel;
	private ChartPanel pieChartPanel;
	private int latestMailNum = 0;
	public Panel() {
		initComponents();
	}
	
	@SuppressWarnings("unchecked")
	private void initComponents() {

		jMenuItem1 = new javax.swing.JMenuItem();
		jLabel10 = new javax.swing.JLabel();
		jTextField5 = new javax.swing.JTextField();
		jLabel15 = new javax.swing.JLabel();
		jTextField7 = new javax.swing.JTextField();
		jTextField9 = new javax.swing.JTextField();
		jSplitPane1 = new javax.swing.JSplitPane();
		sidePanel = new javax.swing.JPanel();
		title_lbl = new javax.swing.JLabel();
		subtitle_lbl = new javax.swing.JLabel();
		dashboardLabel = new javax.swing.JLabel();
		settingsLabel = new javax.swing.JLabel();
		managementLabel = new javax.swing.JLabel();
		addPhisherLabel = new javax.swing.JLabel();
		cardLayout = new javax.swing.JPanel();
		dashoardPanel = new javax.swing.JPanel();
		hourlyMailChart = new javax.swing.JPanel();
		mailPieChart = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		senderTable = new javax.swing.JTable();
		jPanel1 = new javax.swing.JPanel();
		receivedCard1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		safe_mail_card1 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		unknownCard = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		suspicious_mail_card = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		receivedCard2 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		malicious_mail_card = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		settingsPanel = new javax.swing.JPanel();
		start_python_button = new javax.swing.JToggleButton();
		spam_sensitivity_slider = new javax.swing.JSlider();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		mysql_passwd_field = new javax.swing.JTextField();
		mysql_uname_field = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();
		mysql_host_field = new javax.swing.JTextField();
		jLabel14 = new javax.swing.JLabel();
		mysql_db_field = new javax.swing.JTextField();
		jLabel16 = new javax.swing.JLabel();
		managementPanel = new javax.swing.JPanel();
		jPanel3 = new javax.swing.JPanel();
		jPanel7 = new javax.swing.JPanel();
		jLabel9 = new javax.swing.JLabel();
		maliciousMailsJList = new javax.swing.JList<>();
		maliciousMailsAddTextBox = new javax.swing.JTextField();
		maliciousMailsAddButton = new javax.swing.JButton();
		jPanel5 = new javax.swing.JPanel();
		jLabel7 = new javax.swing.JLabel();
		maliciousDomainsJList = new javax.swing.JList<>();
		maliciousDomainsAddTextBox = new javax.swing.JTextField();
		maliciousDomainsAddButton = new javax.swing.JButton();
		jPanel6 = new javax.swing.JPanel();
		jLabel8 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		accounts_list = new javax.swing.JList<>();
		imap_user = new javax.swing.JTextField();
		change_button = new javax.swing.JButton();
		imap_port = new javax.swing.JTextField();
		imap_pass = new javax.swing.JTextField();
		imap_server = new javax.swing.JTextField();
		add_button = new javax.swing.JButton();
		newPhisherPanel = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		newPhisherTable = new javax.swing.JTable();

		jMenuItem1.setText("jMenuItem1");

		jLabel10.setText("jLabel10");

		jTextField5.setBackground(new java.awt.Color(41, 71, 139));
		jTextField5.setText("jTextField1");
		jTextField5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField5ActionPerformed(evt);
			}
		});

		jLabel15.setBackground(BACKGROUND_COLOR);
		jLabel15.setText("MySQL Host");

		jTextField7.setBackground(new java.awt.Color(41, 68, 79));
		jTextField7.setForeground(FOREGROUND_COLOR);

		jTextField9.setBackground(new java.awt.Color(41, 68, 79));
		jTextField9.setForeground(FOREGROUND_COLOR);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jSplitPane1.setDividerLocation(400);

		sidePanel.setBackground(new java.awt.Color(38, 96, 164));

		title_lbl.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
		title_lbl.setForeground(new java.awt.Color(237, 247, 246));
		title_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		title_lbl.setText("KülYutmaz");

		subtitle_lbl.setForeground(new java.awt.Color(237, 247, 246));
		subtitle_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		subtitle_lbl.setText("Control Panel v1.0");

		dashboardLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
		dashboardLabel.setForeground(new java.awt.Color(237, 247, 246));
		dashboardLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_white.png"))); // NOI18N
		dashboardLabel.setText("Kontrol Paneli");
		dashboardLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				dashboardLabelMouseClicked(evt);
			}
		});

		settingsLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
		settingsLabel.setForeground(new java.awt.Color(237, 247, 246));
		settingsLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/settings_white.png"))); // NOI18N
		settingsLabel.setText("Ayarlar");
		settingsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				settingsLabelMouseClicked(evt);
			}
		});

		managementLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
		managementLabel.setForeground(new java.awt.Color(237, 247, 246));
		managementLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/avatar_white.png"))); // NOI18N
		managementLabel.setText("Yönetim");
		managementLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				managementLabelMouseClicked(evt);
			}
		});

		addPhisherLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
		addPhisherLabel.setForeground(new java.awt.Color(237, 247, 246));
		addPhisherLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plus-small.png"))); // NOI18N
		addPhisherLabel.setText("Yeni Oltalar");
		addPhisherLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				addPhisherLabelMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
		sidePanel.setLayout(sidePanelLayout);
		sidePanelLayout.setHorizontalGroup(
				sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(subtitle_lbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(title_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
						.addGroup(sidePanelLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(dashboardLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(settingsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(managementLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
												.addComponent(addPhisherLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addContainerGap())))
		);
		sidePanelLayout.setVerticalGroup(
				sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(sidePanelLayout.createSequentialGroup()
								.addGap(24, 24, 24)
								.addComponent(title_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(subtitle_lbl)
								.addGap(18, 18, 18)
								.addComponent(dashboardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(managementLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(settingsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(addPhisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(351, Short.MAX_VALUE))
		);

		jSplitPane1.setLeftComponent(sidePanel);

		cardLayout.setLayout(new java.awt.CardLayout());

		dashoardPanel.setBackground(new java.awt.Color(41, 42, 50));

		hourlyMailChart.setBackground(new java.awt.Color(41, 42, 50));

		javax.swing.GroupLayout hourlyMailChartLayout = new javax.swing.GroupLayout(hourlyMailChart);
		hourlyMailChart.setLayout(hourlyMailChartLayout);
		hourlyMailChartLayout.setHorizontalGroup(
				hourlyMailChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 0, Short.MAX_VALUE)
		);
		hourlyMailChartLayout.setVerticalGroup(
				hourlyMailChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 319, Short.MAX_VALUE)
		);

		mailPieChart.setBackground(new java.awt.Color(41, 42, 50));

		javax.swing.GroupLayout mailPieChartLayout = new javax.swing.GroupLayout(mailPieChart);
		mailPieChart.setLayout(mailPieChartLayout);
		mailPieChartLayout.setHorizontalGroup(
				mailPieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 0, Short.MAX_VALUE)
		);
		mailPieChartLayout.setVerticalGroup(
				mailPieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 0, Short.MAX_VALUE)
		);

		senderTable.setBackground(new java.awt.Color(41, 42, 50));
		senderTable.setForeground(new java.awt.Color(238, 238, 238));
		senderTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"Sender Domain", "Received"
				}
		) {
			Class[] types = new Class [] {
					java.lang.String.class, java.lang.Object.class
			};
			boolean[] canEdit = new boolean [] {
					true, false
			};

			public Class getColumnClass(int columnIndex) {
				return types [columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});
		jScrollPane1.setViewportView(senderTable);
		if (senderTable.getColumnModel().getColumnCount() > 0) {
			senderTable.getColumnModel().getColumn(0).setResizable(false);
			senderTable.getColumnModel().getColumn(1).setResizable(false);
		}

		jPanel1.setBackground(new java.awt.Color(41, 42, 50));
		jPanel1.setLayout(new java.awt.GridLayout(1, 0, 300, 0));

		receivedCard1.setBackground(new java.awt.Color(44, 234, 146));

		jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/check-mark.png"))); // NOI18N

		safe_mail_card1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
		safe_mail_card1.setForeground(new java.awt.Color(237, 247, 246));
		safe_mail_card1.setText("222");

		jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(237, 247, 246));
		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel4.setText("Güvenli Postalar");

		javax.swing.GroupLayout receivedCard1Layout = new javax.swing.GroupLayout(receivedCard1);
		receivedCard1.setLayout(receivedCard1Layout);
		receivedCard1Layout.setHorizontalGroup(
				receivedCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(receivedCard1Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel2)
								.addGap(18, 18, 18)
								.addGroup(receivedCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(safe_mail_card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		receivedCard1Layout.setVerticalGroup(
				receivedCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receivedCard1Layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(receivedCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(receivedCard1Layout.createSequentialGroup()
												.addGap(8, 8, 8)
												.addComponent(safe_mail_card1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jLabel4)
												.addGap(0, 14, Short.MAX_VALUE)))
								.addContainerGap())
		);

		jPanel1.add(receivedCard1);

		unknownCard.setBackground(new java.awt.Color(249, 220, 92));

		jLabel1.setBackground(new java.awt.Color(249, 220, 92));
		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/question-mark.png"))); // NOI18N

		suspicious_mail_card.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
		suspicious_mail_card.setForeground(new java.awt.Color(237, 247, 246));
		suspicious_mail_card.setText("222");

		jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(237, 247, 246));
		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setText("Bilinmeyen Postalar");

		javax.swing.GroupLayout unknownCardLayout = new javax.swing.GroupLayout(unknownCard);
		unknownCard.setLayout(unknownCardLayout);
		unknownCardLayout.setHorizontalGroup(
				unknownCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(unknownCardLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(unknownCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel3)
										.addComponent(suspicious_mail_card, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		unknownCardLayout.setVerticalGroup(
				unknownCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, unknownCardLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(unknownCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(unknownCardLayout.createSequentialGroup()
												.addGap(8, 8, 8)
												.addComponent(suspicious_mail_card, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jLabel3)
												.addGap(0, 14, Short.MAX_VALUE)))
								.addContainerGap())
		);

		jPanel1.add(unknownCard);

		receivedCard2.setBackground(new java.awt.Color(237, 37, 78));

		jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warning-sign.png"))); // NOI18N

		malicious_mail_card.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
		malicious_mail_card.setForeground(new java.awt.Color(237, 247, 246));
		malicious_mail_card.setText("222");

		jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		jLabel6.setForeground(new java.awt.Color(237, 247, 246));
		jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel6.setText("Zararlı Postalar");

		javax.swing.GroupLayout receivedCard2Layout = new javax.swing.GroupLayout(receivedCard2);
		receivedCard2.setLayout(receivedCard2Layout);
		receivedCard2Layout.setHorizontalGroup(
				receivedCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(receivedCard2Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel5)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(receivedCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(malicious_mail_card, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel6))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		receivedCard2Layout.setVerticalGroup(
				receivedCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receivedCard2Layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(receivedCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(receivedCard2Layout.createSequentialGroup()
												.addGap(8, 8, 8)
												.addComponent(malicious_mail_card, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jLabel6)
												.addGap(0, 14, Short.MAX_VALUE)))
								.addContainerGap())
		);

		jPanel1.add(receivedCard2);

		javax.swing.GroupLayout dashoardPanelLayout = new javax.swing.GroupLayout(dashoardPanel);
		dashoardPanel.setLayout(dashoardPanelLayout);
		dashoardPanelLayout.setHorizontalGroup(
				dashoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(dashoardPanelLayout.createSequentialGroup()
								.addGap(60, 60, 60)
								.addGroup(dashoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(dashoardPanelLayout.createSequentialGroup()
												.addComponent(mailPieChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(145, 145, 145)
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(hourlyMailChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(55, 55, 55))
						.addGroup(dashoardPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1235, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		dashoardPanelLayout.setVerticalGroup(
				dashoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(dashoardPanelLayout.createSequentialGroup()
								.addGap(22, 22, 22)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(hourlyMailChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(38, 38, 38)
								.addGroup(dashoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
										.addComponent(mailPieChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap())
		);

		cardLayout.add(dashoardPanel, "card2");

		settingsPanel.setBackground(new java.awt.Color(41, 42, 50));

		start_python_button.setBackground(BACKGROUND_COLOR);
		start_python_button.setForeground(new java.awt.Color(237, 247, 246));
		start_python_button.setText("Start Kulyutmaz");
		start_python_button.setToolTipText("");
		start_python_button.setHideActionText(true);
		start_python_button.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				start_python_buttonActionPerformed(evt);
			}
		});

		spam_sensitivity_slider.setForeground(new java.awt.Color(237, 247, 246));

		jLabel11.setBackground(BACKGROUND_COLOR);
		jLabel11.setForeground(new java.awt.Color(237, 247, 246));
		jLabel11.setText("Set Spam Sensitivity");

		jLabel12.setBackground(BACKGROUND_COLOR);
		jLabel12.setForeground(new java.awt.Color(237, 247, 246));
		jLabel12.setText("MySQL Password");

		mysql_uname_field.setBackground(new java.awt.Color(41, 71, 139));
		mysql_uname_field.setForeground(new java.awt.Color(237, 247, 246));
		mysql_uname_field.setText("jTextField1");

		mysql_passwd_field.setBackground(new java.awt.Color(41, 71, 139));
		mysql_passwd_field.setForeground(new java.awt.Color(237, 247, 246));
		mysql_passwd_field.setText("jTextField1");


		jLabel13.setBackground(BACKGROUND_COLOR);
		jLabel13.setForeground(new java.awt.Color(237, 247, 246));
		jLabel13.setText("MySQL Username");

		mysql_host_field.setBackground(new java.awt.Color(41, 71, 139));
		mysql_host_field.setForeground(new java.awt.Color(237, 247, 246));
		mysql_host_field.setText("jTextField1");

		jLabel14.setBackground(BACKGROUND_COLOR);
		jLabel14.setForeground(new java.awt.Color(237, 247, 246));
		jLabel14.setText("MySQL Host");

		mysql_db_field.setBackground(new java.awt.Color(41, 71, 139));
		mysql_db_field.setForeground(new java.awt.Color(237, 247, 246));
		mysql_db_field.setText("jTextField1");

		jLabel16.setBackground(BACKGROUND_COLOR);
		jLabel16.setForeground(new java.awt.Color(237, 247, 246));
		jLabel16.setText("MySQL Database");

		javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
		settingsPanel.setLayout(settingsPanelLayout);
		settingsPanelLayout.setHorizontalGroup(
				settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(settingsPanelLayout.createSequentialGroup()
								.addGap(428, 428, 428)
								.addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(mysql_db_field, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(mysql_host_field, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(settingsPanelLayout.createSequentialGroup()
																.addGap(37, 37, 37)
																.addComponent(start_python_button, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(settingsPanelLayout.createSequentialGroup()
																.addGap(72, 72, 72)
																.addComponent(jLabel11))
														.addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																.addComponent(spam_sensitivity_slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(mysql_passwd_field)
																.addComponent(mysql_uname_field, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGroup(settingsPanelLayout.createSequentialGroup()
																		.addGap(90, 90, 90)
																		.addComponent(jLabel13))
																.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsPanelLayout.createSequentialGroup()
																		.addComponent(jLabel14)
																		.addGap(96, 96, 96)))
														.addGroup(settingsPanelLayout.createSequentialGroup()
																.addGap(90, 90, 90)
																.addComponent(jLabel12))))
										.addGroup(settingsPanelLayout.createSequentialGroup()
												.addGap(85, 85, 85)
												.addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addContainerGap(448, Short.MAX_VALUE))
		);
		settingsPanelLayout.setVerticalGroup(
				settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(settingsPanelLayout.createSequentialGroup()
								.addGap(16, 16, 16)
								.addComponent(jLabel16)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(mysql_db_field, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jLabel14)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(mysql_host_field, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(31, 31, 31)
								.addComponent(jLabel13)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(mysql_uname_field, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(jLabel12)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(mysql_passwd_field, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(20, 20, 20)
								.addComponent(jLabel11)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(spam_sensitivity_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(start_python_button, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(363, Short.MAX_VALUE))
		);

		cardLayout.add(settingsPanel, "card4");

		managementPanel.setBackground(BACKGROUND_COLOR);

		jPanel3.setBackground(new java.awt.Color(41, 42, 50));
		jPanel3.setLayout(new java.awt.GridLayout(1, 0, 100, 0));

		jPanel7.setBackground(new java.awt.Color(41, 42, 50));

		jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
		jLabel9.setForeground(FOREGROUND_COLOR);
		jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel9.setText("Güvenli Göndericiler");

		maliciousMailsJList.setBackground(new java.awt.Color(41, 42, 50));
		maliciousMailsJList.setForeground(FOREGROUND_COLOR);
		maliciousMailsJList.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
			public int getSize() { return strings.length; }
			public String getElementAt(int i) { return strings[i]; }
		});

		maliciousMailsAddTextBox.setBackground(new java.awt.Color(41, 68, 79));
		maliciousMailsAddTextBox.setForeground(FOREGROUND_COLOR);

		maliciousMailsAddButton.setBackground(BACKGROUND_COLOR);
		maliciousMailsAddButton.setForeground(FOREGROUND_COLOR);
		maliciousMailsAddButton.setText("ADD");
		maliciousMailsAddButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				maliciousMailsAddButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(
				jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel7Layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel7Layout.createSequentialGroup()
												.addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(jPanel7Layout.createSequentialGroup()
																.addGap(6, 6, 6)
																.addComponent(maliciousMailsJList, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(jPanel7Layout.createSequentialGroup()
												.addGap(0, 0, Short.MAX_VALUE)
												.addComponent(maliciousMailsAddTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(maliciousMailsAddButton)
												.addGap(29, 29, 29))))
		);
		jPanel7Layout.setVerticalGroup(
				jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel7Layout.createSequentialGroup()
								.addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(maliciousMailsJList, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(maliciousMailsAddTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(maliciousMailsAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(33, Short.MAX_VALUE))
		);

		jPanel3.add(jPanel7);

		jPanel5.setBackground(new java.awt.Color(41, 42, 50));

		jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
		jLabel7.setForeground(FOREGROUND_COLOR);
		jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel7.setText("Güvenli Alan Adları");

		maliciousDomainsJList.setBackground(new java.awt.Color(41, 42, 50));
		maliciousDomainsJList.setForeground(FOREGROUND_COLOR);
		maliciousDomainsJList.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
			public int getSize() { return strings.length; }
			public String getElementAt(int i) { return strings[i]; }
		});

		maliciousDomainsAddTextBox.setBackground(new java.awt.Color(41, 68, 79));
		maliciousDomainsAddTextBox.setForeground(FOREGROUND_COLOR);

		maliciousDomainsAddButton.setBackground(BACKGROUND_COLOR);
		maliciousDomainsAddButton.setForeground(FOREGROUND_COLOR);
		maliciousDomainsAddButton.setText("ADD");
		maliciousDomainsAddButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				maliciousDomainsAddButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(
				jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel5Layout.createSequentialGroup()
								.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(maliciousDomainsJList, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(jPanel5Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(maliciousDomainsAddTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(maliciousDomainsAddButton)
								.addGap(20, 20, 20))
		);
		jPanel5Layout.setVerticalGroup(
				jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel5Layout.createSequentialGroup()
								.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(maliciousDomainsJList, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(maliciousDomainsAddTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(maliciousDomainsAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(28, Short.MAX_VALUE))
		);

		jPanel3.add(jPanel5);

		jPanel6.setBackground(new java.awt.Color(41, 42, 50));

		jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
		jLabel8.setForeground(FOREGROUND_COLOR);
		jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel8.setText("Mail Accounts");

		jScrollPane2.setBackground(new java.awt.Color(41, 42, 50));

		accounts_list.setBackground(new java.awt.Color(41, 42, 50));
		accounts_list.setForeground(FOREGROUND_COLOR);
		accounts_list.setModel(new javax.swing.AbstractListModel<String>() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
			public int getSize() { return strings.length; }
			public String getElementAt(int i) { return strings[i]; }
		});
		jScrollPane2.setViewportView(accounts_list);

		imap_user.setBackground(new java.awt.Color(41, 68, 79));
		imap_user.setForeground(FOREGROUND_COLOR);

		change_button.setBackground(BACKGROUND_COLOR);
		change_button.setForeground(FOREGROUND_COLOR);
		change_button.setText("CHANGE");
		change_button.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				change_buttonActionPerformed(evt);
			}
		});

		imap_port.setBackground(new java.awt.Color(41, 68, 79));
		imap_port.setForeground(FOREGROUND_COLOR);

		imap_pass.setBackground(new java.awt.Color(41, 68, 79));
		imap_pass.setForeground(FOREGROUND_COLOR);

		imap_server.setBackground(new java.awt.Color(41, 68, 79));
		imap_server.setForeground(FOREGROUND_COLOR);

		add_button.setBackground(BACKGROUND_COLOR);
		add_button.setForeground(FOREGROUND_COLOR);
		add_button.setText("ADD");
		add_button.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				add_buttonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(
				jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel6Layout.createSequentialGroup()
								.addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane2)
										.addGroup(jPanel6Layout.createSequentialGroup()
												.addComponent(imap_server, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(imap_port, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(0, 0, Short.MAX_VALUE)))
								.addContainerGap())
						.addGroup(jPanel6Layout.createSequentialGroup()
								.addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(imap_user, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
								.addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(jPanel6Layout.createSequentialGroup()
												.addContainerGap()
												.addComponent(change_button, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(add_button, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(imap_pass))
								.addGap(13, 13, 13))
		);
		jPanel6Layout.setVerticalGroup(
				jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel6Layout.createSequentialGroup()
								.addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(imap_server, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(imap_port, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(imap_user, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(4, 4, 4)
								.addComponent(imap_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(change_button, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(add_button, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
		);

		change_button.getAccessibleContext().setAccessibleName("Change");
		change_button.getAccessibleContext().setAccessibleDescription("");

		jPanel3.add(jPanel6);

		javax.swing.GroupLayout managementPanelLayout = new javax.swing.GroupLayout(managementPanel);
		managementPanel.setLayout(managementPanelLayout);
		managementPanelLayout.setHorizontalGroup(
				managementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1247, Short.MAX_VALUE)
		);
		managementPanelLayout.setVerticalGroup(
				managementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);

		cardLayout.add(managementPanel, "card3");

		newPhisherTable.setBackground(new java.awt.Color(41, 42, 50));
		newPhisherTable.setForeground(new java.awt.Color(238, 238, 238));
		newPhisherTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"#", "Timestamp", "Domain"
				}
		) {
			Class[] types = new Class [] {
					java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
			};
			boolean[] canEdit = new boolean [] {
					false, false, true, false, false
			};

			public Class getColumnClass(int columnIndex) {
				return types [columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});
		jScrollPane3.setViewportView(newPhisherTable);
		if (newPhisherTable.getColumnModel().getColumnCount() > 0) {
			newPhisherTable.getColumnModel().getColumn(0).setResizable(false);
			newPhisherTable.getColumnModel().getColumn(1).setResizable(false);
		}

		javax.swing.GroupLayout newPhisherPanelLayout = new javax.swing.GroupLayout(newPhisherPanel);
		newPhisherPanel.setLayout(newPhisherPanelLayout);
		newPhisherPanel.setBackground(new java.awt.Color(41, 42, 50));
		newPhisherPanelLayout.setHorizontalGroup(
				newPhisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(newPhisherPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
								.addContainerGap())
		);
		newPhisherPanelLayout.setVerticalGroup(
				newPhisherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(newPhisherPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
								.addContainerGap())
		);

		cardLayout.add(newPhisherPanel, "card5");

		jSplitPane1.setRightComponent(cardLayout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1573, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jSplitPane1)
		);

		pack();
	}

	private void managementLabelMouseClicked(java.awt.event.MouseEvent evt) {
		CardLayout layout = (CardLayout)this.cardLayout.getLayout();
		layout.show(cardLayout, "managementPanel");
	}

	private void dashboardLabelMouseClicked(java.awt.event.MouseEvent evt) {
		CardLayout layout = (CardLayout)this.cardLayout.getLayout();
		layout.show(cardLayout, "dashboardPanel");
	}

	private void settingsLabelMouseClicked(java.awt.event.MouseEvent evt) {
		CardLayout layout = (CardLayout)this.cardLayout.getLayout();
		layout.show(cardLayout, "settingsPanel");
	}
	private void addPhisherLabelMouseClicked(java.awt.event.MouseEvent evt) {
		CardLayout layout = (CardLayout)this.cardLayout.getLayout();
		layout.show(cardLayout, "newPhisherPanel");
	}
	private void maliciousMailsAddButtonActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			Statement stmt = mysql_conn.createStatement();
			String query = String.format("INSERT INTO mail_whitelist (mail) VALUES ('%s')",this.maliciousMailsAddTextBox.getText());
			stmt.executeUpdate(query);
			this.maliciousMailsAddTextBox.setText("");
			this.setManagementJlists(stmt);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	private void maliciousDomainsAddButtonActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			Statement stmt = mysql_conn.createStatement();
			String query = String.format("INSERT INTO domain_whitelist (domain) VALUES ('%s')",this.maliciousDomainsAddTextBox.getText());
			stmt.executeUpdate(query);
			this.maliciousDomainsAddTextBox.setText("");
			this.setManagementJlists(stmt);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	private void change_buttonActionPerformed(java.awt.event.ActionEvent evt) {
		JSONObject account = this.config.getJSONArray("accounts").getJSONObject(this.accounts_list.getSelectedIndex());
		account.put("uname",this.imap_user.getText());
		account.put("password",this.imap_pass.getText());
		account.put("server",this.imap_server.getText());
		account.put("port",Integer.valueOf(this.imap_port.getText()));
		try{
			this.saveConfig();
			this.setManagementJlists(this.mysql_conn.createStatement());
		}catch (IOException e){
			System.err.println("IOException occured");
			e.printStackTrace();
		}catch (SQLException e){
			System.err.println("SQL Exception occured");
			e.printStackTrace();
		}
	}

	private void start_python_buttonActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			if(python_proc == null) {
				this.start_python_button.setText("Stop Kulyutmaz");
				python_proc = Runtime.getRuntime().exec(String.format("python3 %s ", System.getProperty("user.home") + "/.kulyutmaz/kulyutmaz.py"));
				python_out = new BufferedWriter(new OutputStreamWriter(python_proc.getOutputStream()));
				this.python_out.write(config.toString() + "\n");
				this.python_out.write(System.getProperty("user.home") + "/.kulyutmaz\n");
				this.python_out.flush();
			}else{
				this.start_python_button.setText("Start Kulyutmaz");
				python_proc = null;
				this.python_out.write("0");
				this.python_out.flush();
				this.python_out.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	private void accounts_listValueChanged(javax.swing.event.ListSelectionEvent evt) {
		if(this.accounts_list.getSelectedIndex() == -1){
			return;
		}
		JSONObject account = this.config.getJSONArray("accounts").getJSONObject(this.accounts_list.getSelectedIndex());
		this.imap_user.setText(account.getString("uname"));
		this.imap_pass.setText(account.getString("password"));
		this.imap_server.setText(account.getString("server"));
		this.imap_port.setText(String.valueOf(account.getInt("port")));
	}

	private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {
		JSONObject account = new JSONObject();
		account.put("uname",this.imap_user.getText());
		account.put("password",this.imap_pass.getText());
		account.put("server",this.imap_server.getText());
		account.put("port",Integer.valueOf(this.imap_port.getText()));
		this.config.getJSONArray("accounts").put(account);
		try{
			this.saveConfig();
			this.setManagementJlists(this.mysql_conn.createStatement());
		}catch (IOException e){
			System.err.println("IOException occured");
			e.printStackTrace();
		}catch (SQLException e){
			System.err.println("SQL Exception occured");
			e.printStackTrace();
		}
	}
	private void saveConfig()
			throws IOException{
			String str = this.config.toString(4);
			BufferedWriter writer = new BufferedWriter(new FileWriter(this.config_file_loc));
			writer.write(str);
			writer.close();
	}

	private void setManagementJlists(Statement stmt) throws SQLException{
		String query = "SELECT domain FROM domain_whitelist";
		ResultSet rs = stmt.executeQuery(query);
		DefaultListModel domainModel = new DefaultListModel();
		domainModel.clear();
		while(rs.next()){
			domainModel.addElement(rs.getString("domain"));
		}
		this.maliciousDomainsJList.setModel(domainModel);
		query = "SELECT mail FROM mail_whitelist";
		rs = stmt.executeQuery(query);
		DefaultListModel mailModel = new DefaultListModel();
		mailModel.clear();
		while(rs.next()){
			mailModel.addElement(rs.getString("mail"));
		}
		this.maliciousMailsJList.setModel(mailModel);
		stmt.close();
		DefaultListModel accountModel = new DefaultListModel();
		for(Object i : this.config.getJSONArray("accounts")){
			JSONObject account = (JSONObject)i;
			accountModel.addElement(account.getString("uname"));
		}
		this.accounts_list.setModel(accountModel);
	}
	public void updateHourlyMailChart(Statement stmt) throws SQLException{
		DateTimeFormatter pattern =  DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss");
		LocalDateTime start = LocalDateTime.now().minusHours(17);
		String query = String.format("SELECT COUNT(*)" +
						"  FROM logs" +
						" WHERE timestamp>='%s'" +
						"   AND timestamp< '%s';",
				pattern.print(start.minusHours(1)),
				pattern.print(start.minusHours(0)));
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		int mail_num = rs.getInt("COUNT(*)");
		if(mail_num != this.latestMailNum){
			System.out.println("test");
			this.setHourlyMailChart(stmt);
			return;
		}
		stmt.close();
	}
	private void setHourlyMailChart(Statement stmt) throws SQLException{
		DateTimeFormatter pattern =  DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss");
		LocalDateTime start = LocalDateTime.now().minusHours(17);
		XYSeries series = new XYSeries("");
		for(int i = 1; i<=24; i++) {
			String query = String.format("SELECT COUNT(*)" +
							"  FROM logs" +
							" WHERE timestamp>='%s'" +
							"   AND timestamp< '%s';",
					pattern.print(start.minusHours(i)),
					pattern.print(start.minusHours(i - 1)));
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			int mail_num = rs.getInt("COUNT(*)");
			if(i == 1){
				this.latestMailNum = mail_num;
			}
			series.add(25-i, mail_num);
		}
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		String query_base = "SELECT COUNT(*) as count" +
				" FROM logs" +
				" WHERE timestamp>='%s'" +
				" AND timestamp< '%s'" +
				" AND result = %s;";
		ResultSet rs = stmt.executeQuery(String.format(query_base,pattern.print(start.minusHours(24)),pattern.print(start),1));
		rs.next();
		this.malicious_mail_card.setText(String.valueOf(rs.getInt("count")));
		pieDataset.setValue("Zararlı Postalar", rs.getInt("count"));
		rs = stmt.executeQuery(String.format(query_base,pattern.print(start.minusHours(24)),pattern.print(start),0));
		rs.next();
		this.suspicious_mail_card.setText(String.valueOf(rs.getInt("count")));
		pieDataset.setValue("Bilinmeyen Postalar", rs.getInt("count"));
		rs = stmt.executeQuery(String.format(query_base,pattern.print(start.minusHours(24)),pattern.print(start),-1));
		rs.next();
		this.safe_mail_card1.setText(String.valueOf(rs.getInt("count")));
		pieDataset.setValue("Zararsız Postalar", rs.getInt("count"));

		stmt.close();
		XYSeriesCollection dataset = new XYSeriesCollection(series);
		lineChart = ChartFactory.createXYLineChart(null, null, null, dataset, PlotOrientation.VERTICAL, false, false, false);
		lineChartPanel = new ChartPanel(lineChart);
		lineChartPanel.setPreferredSize(new java.awt.Dimension(this.hourlyMailChart.getWidth(), this.hourlyMailChart.getHeight()));
		lineChartPanel.setDomainZoomable(true);
		lineChartPanel.setBackground(BACKGROUND_COLOR);
		lineChart.getXYPlot().setDomainGridlinesVisible(false);
		lineChart.getXYPlot().setRangeGridlinesVisible(false);
		lineChart.getXYPlot().getDomainAxis().setTickLabelPaint(FOREGROUND_COLOR);
		lineChart.getXYPlot().getDomainAxis().setAxisLinePaint(FOREGROUND_COLOR);
		lineChart.getXYPlot().getRangeAxis().setTickLabelPaint(FOREGROUND_COLOR);
		lineChart.getXYPlot().getRangeAxis().setAxisLinePaint(FOREGROUND_COLOR);
		lineChart.setBackgroundPaint(new Color(0,0,0,0));
		lineChart.getPlot().setBackgroundPaint(BACKGROUND_COLOR);
		pieChart = ChartFactory.createPieChart(null, pieDataset);
		pieChartPanel = new ChartPanel(pieChart,false,false,false,false,false);
		pieChart.removeLegend();
		pieChartPanel.setPreferredSize(new java.awt.Dimension(this.mailPieChart.getWidth(), this.mailPieChart.getHeight()));
		pieChartPanel.setDomainZoomable(true);
		pieChart.setBackgroundPaint(new Color(0,0,0,0));
		pieChart.getPlot().setBackgroundPaint(BACKGROUND_COLOR);
		pieChartPanel.setBackground(BACKGROUND_COLOR);
		this.mailPieChart.setLayout(new BorderLayout());
		this.mailPieChart.add(pieChartPanel, BorderLayout.NORTH);
		this.hourlyMailChart.setLayout(new BorderLayout());
		this.hourlyMailChart.add(lineChartPanel,BorderLayout.NORTH);
	}

	public void setSenderTable(Statement stmt) throws SQLException{
		DateTimeFormatter pattern =  DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss");
		LocalDateTime start = LocalDateTime.now().minusHours(17);
		XYSeries series = new XYSeries("");
		HashMap<String,Integer> mailData = new HashMap<>();
		String query = String.format("SELECT DISTINCT(sender_domain) as domain, count(sender_domain) AS count" +
						" FROM logs WHERE timestamp>='%s' AND timestamp<'%s'" +
						" GROUP BY sender_domain HAVING count > 1;",
				pattern.print(start.minusHours(24)),
				pattern.print(start));
		ResultSet rs = stmt.executeQuery(query);
		DefaultTableModel model =new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"Sender Domain", "Received"
				});
		int rows = 0;
		while(rs.next()){
			Object[] row = {rs.getString("domain"), String.valueOf(rs.getInt("count"))};
			model.addRow(row);
			rows ++;
		}
		for(int i = 0; i< 16-rows;i++){
			Object[] row = {"", ""};
			model.addRow(row);
		}
		this.senderTable.setModel(model);

		query = String.format("SELECT *" +
						" FROM new_blacklists WHERE time>='%s' AND time<'%s'",
				pattern.print(start.minusHours(168)),
				pattern.print(start));
		rs = stmt.executeQuery(query);
		model =new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"#", "Timestamp", "Domain"
				});
		rows = 0;
		while(rs.next()){
			Object[] row = {rs.getString("id"), rs.getString("time"), rs.getString("domain")};
			model.addRow(row);
			rows ++;
		}
		for(int i = 0; i< 63-rows;i++){
			Object[] row = {"", "",""};
			model.addRow(row);
		}
		this.newPhisherTable.setModel(model);
		stmt.close();
	}

	private java.util.Date timeSub(java.util.Date d1, long diff){
		long millis = d1.getTime();
		return new Date( millis - diff);
	}

	private void initGui(){
		try {
			this.mysql_conn =
					DriverManager.getConnection(String.format("jdbc:mysql://%s/%s?" +
									"user=%s&password=%s",
							this.config.getString("mysql_host"),
							this.config.getString("mysql_database"),
							this.config.getString("mysql_username"),
							this.config.getString("mysql_password")
					));
			this.setHourlyMailChart(mysql_conn.createStatement());
			Thread chartUpdaterObject = new Thread(new ChartUpdater(this));
			chartUpdaterObject.start();
			this.setSenderTable(mysql_conn.createStatement());
			this.setManagementJlists(mysql_conn.createStatement());
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		this.cardLayout.add("dashboardPanel",this.dashoardPanel);
		this.cardLayout.add("managementPanel",this.managementPanel);
		this.cardLayout.add("newPhisherPanel",this.newPhisherPanel);
		this.cardLayout.add("settingsPanel",this.settingsPanel);
	}

	private void setConfig(){
		this.config_file_loc = System.getProperty("user.home") + "/.kulyutmaz/config.json";
		try (FileReader reader = new FileReader(this.config_file_loc))
		{
			String data = "";
			int i;
			while ((i=reader.read()) != -1){
				data += (char) i;
			}
			this.config = new JSONObject(data);
			this.mysql_db_field.setText(this.config.getString("mysql_database"));
			this.mysql_host_field.setText(this.config.getString("mysql_host"));
			this.mysql_passwd_field.setText(this.config.getString("mysql_password"));
			this.mysql_uname_field.setText(this.config.getString("mysql_username"));
			this.spam_sensitivity_slider.setMinimum(0);
			this.spam_sensitivity_slider.setMaximum(100);
			this.spam_sensitivity_slider.setValue(config.getInt("sensitivity"));
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}

	}
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					UIManager.put("nimbusBlueGrey", BACKGROUND_COLOR);
					break;
				}
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				Panel controlPanel = new Panel();
				controlPanel.setConfig();
				controlPanel.initGui();
				controlPanel.setVisible(true);
			}
		});
	}


	private javax.swing.JList<String> accounts_list;
	private javax.swing.JLabel addPhisherLabel;
	private javax.swing.JButton add_button;
	private javax.swing.JPanel cardLayout;
	private javax.swing.JButton change_button;
	private javax.swing.JLabel dashboardLabel;
	private javax.swing.JPanel dashoardPanel;
	private javax.swing.JPanel hourlyMailChart;
	private javax.swing.JTextField imap_pass;
	private javax.swing.JTextField imap_port;
	private javax.swing.JTextField imap_server;
	private javax.swing.JTextField imap_user;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JSplitPane jSplitPane1;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField7;
	private javax.swing.JTextField jTextField9;
	private javax.swing.JPanel mailPieChart;
	private javax.swing.JButton maliciousDomainsAddButton;
	private javax.swing.JTextField maliciousDomainsAddTextBox;
	private javax.swing.JList<String> maliciousDomainsJList;
	private javax.swing.JButton maliciousMailsAddButton;
	private javax.swing.JTextField maliciousMailsAddTextBox;
	private javax.swing.JList<String> maliciousMailsJList;
	private javax.swing.JLabel malicious_mail_card;
	private javax.swing.JLabel managementLabel;
	private javax.swing.JPanel managementPanel;
	private javax.swing.JTextField mysql_db_field;
	private javax.swing.JTextField mysql_host_field;
	private javax.swing.JTextField mysql_passwd_field;
	private javax.swing.JTextField mysql_uname_field;
	private javax.swing.JPanel newPhisherPanel;
	private javax.swing.JTable newPhisherTable;
	private javax.swing.JPanel receivedCard1;
	private javax.swing.JPanel receivedCard2;
	private javax.swing.JLabel safe_mail_card1;
	private javax.swing.JTable senderTable;
	private javax.swing.JLabel settingsLabel;
	private javax.swing.JPanel settingsPanel;
	private javax.swing.JPanel sidePanel;
	private javax.swing.JSlider spam_sensitivity_slider;
	private javax.swing.JToggleButton start_python_button;
	private javax.swing.JLabel subtitle_lbl;
	private javax.swing.JLabel suspicious_mail_card;
	private javax.swing.JLabel title_lbl;
	private javax.swing.JPanel unknownCard;

}

class ChartUpdater extends Thread {
	Panel panelObject;  
	public ChartUpdater(Panel panelObject){
		this.panelObject = panelObject;
	}
	public void run(){
		try {
			while(true) {
				//panelObject.updateHourlyMailChart(panelObject.mysql_conn.createStatement());
				//panelObject.setSenderTable(panelObject.mysql_conn.createStatement());
				//Thread.sleep(5000);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
