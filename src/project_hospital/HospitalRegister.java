package project_hospital;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import project_hospital.HospitalLogin.JFrameObjectEvent;

public class HospitalRegister {
	//Field
		JFrame jf;
		JTextField tid, tpass, tname, tphone;  
//		JPasswordField tpass;
		HospitalMgmUI main;
		
		//Constructor
		public HospitalRegister(HospitalMgmUI main) {	
			this.main = main;
			
			Font font = new Font("맑은 고딕", Font.BOLD, 12);
			jf = new JFrame("회원가입");	
			JPanel jp_title = new JPanel();
			JPanel jp_id = new JPanel();
			JPanel jp_pass = new JPanel();
			JPanel jp_name = new JPanel();
			JPanel jp_phone = new JPanel();
			JPanel jp_button = new JPanel();
				
			JLabel title = new JLabel("회원가입 폼");		
			JLabel id = new JLabel("아이디   ");
			JLabel pass = new JLabel("패스워드   ");
			JLabel name = new JLabel("이름	");
			JLabel phone = new JLabel("전화번호	");
			
			tid = new JTextField(15);
			tpass = new JTextField(15);
			tname = new JTextField(15);
			tphone = new JTextField(15);
			
			JButton btnRegister = new JButton("회원가입");
			JButton btnReset = new JButton("취소");
			JButton btnExit = new JButton("종료");
			
			title.setFont(font);  id.setFont(font);   pass.setFont(font);
			name.setFont(font);   phone.setFont(font);
			btnRegister.setFont(font);    btnReset.setFont(font);
			btnExit.setFont(font);
				
			jp_title.add(title);
			jp_id.add(id);     jp_id.add(tid);
			jp_pass.add(pass);  jp_pass.add(tpass);
			jp_name.add(name);  jp_name.add(tname);
			jp_phone.add(phone); jp_phone.add(tphone);
			
			jp_button.add(btnRegister);
			jp_button.add(btnReset);
			jp_button.add(btnExit);
				
			jf.setLayout(new GridLayout(6,1));
			jf.add(jp_title);		jf.add(jp_id);		jf.add(jp_pass);
			jf.add(jp_name); 		jf.add(jp_phone);
			jf.add(jp_button);
				
			jf.setSize(400,220);	
				
			Dimension fsize = jf.getSize();
			Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize(); 
			int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
			int height =(int)(scsize.getHeight()-fsize.getHeight())/2;
			
			jf.setLocation(width,height);
			jf.setVisible(true);	
			
			//이벤트 핸들러 메소드(리스너 메소드) 호출
			JFrameObjectEvent eventObject = new JFrameObjectEvent();
			jf.addWindowListener(eventObject);
			btnRegister.addActionListener(eventObject);
			btnReset.addActionListener(eventObject);
			btnExit.addActionListener(eventObject);
			tpass.addActionListener(eventObject);
		}
		//이벤트 처리 클래스
		class JFrameObjectEvent extends WindowAdapter
													implements ActionListener{
			//윈도우 이벤트 처리
			public void windowClosing(WindowEvent we) {
				//회원가입 창 종료
				jf.setVisible(false);
			}
				
			//액션 이벤트 처리
			public void actionPerformed(ActionEvent e) {
				String bname = e.getActionCommand();

				if(bname.equals("회원가입")) {	
					//회원가입 폼 (유효성 체크 !!!!)
					if(validationCheck()) {
						RegisterCheck();
					}
//						loginCheck();				
				}else if(bname.equals("취소")){
					tid.setText("");
					tpass.setText("");
					tname.setText("");
					tphone.setText("");
					jf.setVisible(true);
				}else if(bname.equals("종료")) {
					System.out.println("--  종료 버튼이 클릭되었습니다. --");
					System.exit(0);
				}
			}
				
		}
		
		//Method
		/** 데이터 유효성 체크 **/
		public boolean validationCheck() {
			boolean result = false;
			//tid, tpass, tname, tphone에 값이 없으면 메시지를 띄움
			if(tid.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "아이디를 입력해주세요");
				tid.requestFocus();
			}else if(tpass.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "패스워드를 입력해주세요");
				tpass.requestFocus();
			}else if(tname.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "이름을 입력해주세요");
				tname.requestFocus();
			}else if(tphone.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요");
				tphone.requestFocus();
			}else {
				result = true;
			}
					
			return result;
		}
		
		/** 회원가입 체크 **/
		public void RegisterCheck() {
			//데이터 중복 체크!!!! -> db list
//			String did = "test";  
//			String dpass = "1234";
			
			//TextField에서 가져온 값
			String uid = tid.getText().trim();
			String upass = tpass.getText().trim();
			String uname = tname.getText().trim();
			String uphone = tphone.getText().trim();
			
			System.out.println(uid);
			System.out.println(upass);
			System.out.println(uname);
			System.out.println(uphone);
			
//			boolean result = main.system.login(uid, upass);
			
//			if(did.equals(uid) ) {
//				
//				if(dpass.equals(upass)) {
//					//로그인성공 : id,pass 동일
//					JOptionPane.showMessageDialog(null, "로그인 성공");
//					jf.setVisible(false);
//					main.start();
//					
//				}else {
//					//로그인 실패 : id 동일, pass 다름
//						JOptionPane.showMessageDialog(null, "로그인 실패");
//				}
//			}else {
//				//System.out.println("로그인 실패");
//				JOptionPane.showMessageDialog(null, "로그인 실패, 아이디 다름");
//			}
		}
		
}
