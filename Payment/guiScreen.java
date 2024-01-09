package oop_kiosk_medihub;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class guiScreen {

	private JFrame frame;
	private DocumentItem searchResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiScreen window = new guiScreen();
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
	public guiScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);
      // 첫 번째 패널(첫 번째 화면)
        JPanel panel1 = new JPanel();
        panel1.setForeground(new Color(192, 192, 192));
        panel1.setLayout(null);
        JLabel lb1 = new JLabel("본인 확인");
        lb1.setBounds(100, 100, 111, 43);
        lb1.setFont(new Font("나눔스퀘어 ExtraBold", Font.PLAIN, 28));
        panel1.add(lb1);
      // 두 번째 패널
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        JLabel lb2 = new JLabel("영수증 확인");
        lb2.setBounds(100, 100, 163, 43);
        lb2.setFont(new Font("나눔스퀘어 ExtraBold", Font.PLAIN, 28));
        panel2.add(lb2);
      // 세 번째 패널
        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        JLabel lb3 = new JLabel("결제 방법");
        lb3.setFont(new Font("나눔스퀘어 ExtraBold", Font.PLAIN, 28));
        lb3.setBounds(100, 100, 163, 43);
        panel3.add(lb3);
      // 네 번째
        JPanel panel4 = new JPanel();
        panel4.setLayout(null);
        JLabel lb4 = new JLabel("처방전 확인");
        lb4.setBounds(100, 100, 135, 32);
        lb4.setFont(new Font("나눔스퀘어 ExtraBold", Font.PLAIN, 28));
        panel4.add(lb4);
      // 카드레이아웃에 패널(각 페이지의 화면) 추가
        cardPanel.add(panel1, "panel1");
        cardPanel.add(panel2, "panel2");
        cardPanel.add(panel3, "panel3");        
        cardPanel.add(panel4, "panel4");
        
        frame.getContentPane().add(cardPanel, BorderLayout.CENTER);
		
      //1
		JButton btnBack = new JButton("뒤로");
		btnBack.setBounds(100, 400, 100, 85);
		btnBack.setBackground(new Color(192, 192, 192));
		btnBack.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 25));
		// 뒤로가기 버튼에 대한 이벤트 리스너 추가 : 버튼 클릭시 실행될 코드
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//back to home Screen.
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("접수자 등록번호를 입력해주세요");      
		lblNewLabel_1.setBounds(100, 150, 423, 43);
		lblNewLabel_1.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 25));
		panel1.add(lblNewLabel_1);
		
		JButton btnNext = new JButton("다음");
		btnNext.setBounds(211, 400, 155, 85);
		btnNext.setBackground(new Color(27, 188, 155));
		btnNext.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 25));
		JTextField textField = new JTextField();
		textField.setBounds(100, 220, 266, 43);
		textField.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 22));
		
		
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userInput = textField.getText().trim(); // textField에 입력된 값 가져오기
				searchResult = DBSearch.searchRecord(userInput); // DBSearch 클래스의 메서드 호출
//**문제있음.
				if (searchResult != null) {
				    // DB에서 레코드를 찾았을 경우: 다음 화면(panel2)으로 이동
					System.out.println("name : "+searchResult.getName());
				    cardLayout.show(cardPanel, "panel2");
				} else {
				    // DB에서 레코드를 찾지 못했을 경우: 팝업 띄우기
				    JOptionPane.showMessageDialog(frame, "입력한 값이 존재하지 않습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		panel1.add(textField);
		textField.setColumns(10);
		panel1.add(btnBack);	
		panel1.add(btnNext);
		
		
	//2
		Object[][] data = { //receiptItem
				{"진료비", "10000원"},
				{"진단서", "20000원"}, //searchResult.getFee()
				{"총 금액", "30000원"}
		};
		String[] columns = {"항목","비용"};
		DefaultTableModel model = new DefaultTableModel(data, columns);		
		JTable table = new JTable(model);
		table.setRowHeight(45);
		table.setFont(new Font("나눔스퀘어 Light", Font.PLAIN, 24));
		table.setBounds(100, 150, 464, 135);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setSurrendersFocusOnKeystroke(true);
        panel2.add(table);
        
        JButton btnPayNow = new JButton("결제하기");
        btnPayNow.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 25));
        btnPayNow.setBounds(100, 350, 151, 85);
        btnPayNow.setBackground(new Color(27, 188, 155));
        btnPayNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "panel3");
			}
		});
        panel2.add(btnPayNow);
        
        
      //3
        JLabel lb_selection = new JLabel("결제 수단을 선택하세요.");
        lb_selection.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 28));
        lb_selection.setBounds(100, 150, 423, 43);
        panel3.add(lb_selection);
        JButton btnCard = new JButton("카드 결제");        
        btnCard.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 24));
        btnCard.setBounds(100, 250, 137, 120);
        btnCard.setBackground(new Color(27, 188, 155));
        JButton btnEPay = new JButton("간편 결제");
        btnEPay.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 24));
        btnEPay.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnEPay.setBounds(250, 250, 129, 120);
        btnEPay.setEnabled(false);
        
        JProgressBar pgBar = new JProgressBar();
        pgBar.setForeground(new Color(27, 188, 155));
        pgBar.setLocation(100, 391);
        pgBar.setSize(279, 17);
        pgBar.setStringPainted(true); //문자열로 퍼센트 표시
        JLabel lb_completion = new JLabel("결제가 완료되었습니다 !");
        lb_completion.setForeground(new Color(0, 0, 0));
        lb_completion.setFont(new Font("나눔스퀘어 Light", Font.PLAIN, 21));
        lb_completion.setBounds(100, 418, 272, 32);
        JButton btnPrescription = new JButton("처방전 확인");
        btnPrescription.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 24));
        btnPrescription.setBounds(100, 471, 181, 96);
        pgBar.setVisible(false);  //초기 상태 = 안보이게
        lb_completion.setVisible(false); 
        btnPrescription.setVisible(false);
        
        btnCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	pgBar.setVisible(true);
                pgBar.setStringPainted(true); // 퍼센트 보이게

                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        for (int i = 0; i <= 10; i++) {
                            int progressValue = i * 10; // progressValue 선언 및 초기화
                            pgBar.setValue(progressValue);
                            pgBar.setString(progressValue + "%");
                            Thread.sleep(160); // 200ms(=2초) 대기
                        }
                        return null;
                    }
                    @Override
                    protected void done() {
                        lb_completion.setVisible(true);
                        btnPrescription.setVisible(true);
                    }
                };
                worker.execute();            }
        });        
        panel3.add(btnCard);
        panel3.add(btnEPay);
        panel3.add(pgBar);
        panel3.add(lb_completion);
        panel3.add(btnPrescription);
        btnPrescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "panel4");
			}
		});
        
        
      //4
        JButton btnClose = new JButton("확인");
        btnClose.setBounds(100, 500, 100, 85);
        btnClose.setBackground(new Color(192, 192, 192));
        btnClose.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 25));
        btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//back to home Screen.
			}
		});
		JButton btnPharmacy = new JButton("주변 약국 보기");
		btnPharmacy.setBounds(220, 500, 201, 85);
		btnPharmacy.setBackground(new Color(27, 188, 155));
		btnPharmacy.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 25));
		btnPharmacy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//주변 약국보기 페이지로 넘어가기
			}
		});
		panel4.add(btnClose);
		panel4.add(btnPharmacy);
        
        
	}
}
