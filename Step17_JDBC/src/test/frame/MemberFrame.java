package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MemberFrame extends JFrame 
					implements ActionListener, PropertyChangeListener{
	//필요한 필드 정의하기
	JTextField inputName,inputAddr;
	DefaultTableModel model;
	JTable table;
	
	//생성자
	public MemberFrame(String title) {
		super(title);
		//레리아웃 설정
		setLayout(new BorderLayout());
		//JLable 2개
		JLabel label1 = new JLabel("이름");
		JLabel label2 = new JLabel("주소");
		//JTextField 2개
		inputName = new JTextField(10);
		inputAddr = new JTextField(10);
		//JButton추가
		JButton addBtn = new JButton("추가");
		JButton deleteBtn = new JButton("삭제");
		
		//UI 를 배치할 패널 준비
		//add는 
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputAddr);
		panel.add(addBtn);
		panel.add(deleteBtn);
		
		//패널의 배경색 설정
		panel.setBackground(Color.orange);
		
		//패널을 프레임의 위 쪽에 배치
		add(panel,BorderLayout.NORTH);
		
		//버튼에 앳션 리스터 등록
		//멤버 프레임이 액션을 받아줄려면 implements 해야한다
		addBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		//버튼에 액션 command 설정
		addBtn.setActionCommand("add");
		deleteBtn.setActionCommand("delete");
		
		//회원목록을 출력할 테이블
		table = new JTable();
		//케이블의 칼럼영을 배열로 미리 준비
		String[] colNames= {"번호","이름","주소"};
		//테이블에 연결할 모델 객체
		//생성자에서 생성된 이 객체의 참조값이 다른 메소드에도 필요
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column == 0) {
					//0번 째 칼럼은 커짓을 리턴해서 수정 불가능하게 만들고
					return false;
				}else {
					//그 외의 칼럼은 트루를 리턴해서 수정 가능하게 만든다
					return true;
				}
			}
		};
		model.setColumnIdentifiers(colNames);
		model.setRowCount(0);
		//모델을 테이블에 연결
		table.setModel(model);
		//스크롤 추가 테이블을 JScrollPane 에 감싼다
		JScrollPane scroll = new JScrollPane(table);
		//JScrollPane 을 프레임의 가운데 배치하기
		add(scroll,BorderLayout.CENTER);
		
		printMember();
		
		//칼럼의 제목 글자 조정
		table.getTableHeader().setFont(new Font("Sans-serif",Font.BOLD,18));
		table.setFont(new Font("Sans-serif",Font.PLAIN, 16));
		table.setRowHeight(25);
		/*
			//jTable 에 출력할 sample row 데이터
			Object[] row = {1, "김구라", "노량진"};
			//테이블에 연결된 모델에 row 추가
			model.addRow(row);
			
			Object[] row2 = {1, "김구라2", "노량진2"};
			model.addRow(row2);
		*/
		
		//테이블에 값이 바뀌었는지 감시할 리스너 등록
		table.addPropertyChangeListener(this);
	}
	
	public static void main(String[] args) {
		MemberFrame f = new MemberFrame("회원 정보 관리");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100,100,800,500);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼의 action command 을 읽어온다
		String command = e.getActionCommand();
		if(command.equals("add")) {//java 에서는 문자열 비교를 .equal() 메소드를 이용해서 비교
			//입력한 이름과 주소를 읽어온다
			//JTextField의 참조값이 필드에 저장되어있어서 this.input..생략되어 있다
			String name = inputName.getText();
			String addr = inputAddr.getText();
			//입력한 이름과 주소를 MemberDto 객체에 담는다
			MemberDto dto = new MemberDto();
			dto.setName(name);
			dto.setAddr(addr);
			//MemberDao 객체 생성해서
			MemberDao dao = new MemberDao();
			//insert() 메소드를 이용해사 회원 정보를 DB에 저장한다
			dao.insert(dto);
		}else if(command.equals("delete")){
			//선택된 JTable Row 가 있다면 몇번째 row 가 선택되었는디 읽어와서
			int selectedRow = table.getSelectedRow();
			if(selectedRow == -1) {
				//this 알림을 띄울 컴포넌트(프레임)의 참조값
				JOptionPane.showMessageDialog(this, "삭제할 row 를 선택하세요!");
				return;//메소드를 여기서 끝내기
			}
			//삭제할 회원의 번호를 읽어온다
			int num = (int)model.getValueAt(selectedRow, 0);
			new MemberDao().delete(num);
		}
		
		printMember();
		
		
	}
	//회원목록을 JTable 에 출력하는 메소드
	public void printMember() {
		//기존에 출력된 내용은 초기화
		model.setRowCount(0);
		
		List<MemberDto>list = new MemberDao().getList();
		for(MemberDto mem: list) {
			Object[] row = {mem.getNum(), mem.getName(), mem.getAddr()};
			model.addRow(row);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("property change!");
		System.out.println("property name:"+evt.getPropertyName());
		
		System.out.println("isEditing:"+table.isEditing());
		/*
		 *  property name 이 "tableCellEditor" 이고
		 *  table 이 수정중이 아닐때 
		 *  현재 포커스가 있는 곳의 정보를 모두 읽어와서 DB 에 수정반영하기 
		 */
		if(evt.getPropertyName().equals("tableCellEditor") && !table.isEditing()) {
			//현재 포커스가 있는 row 의 정보를 DB 에 수정 반영 한다. 
			//변화된 값을 읽어와서 DB 에 반영한다. 
			//수정된 칼럼에 있는 row  전체의 값을 읽어온다. 
			int selectedIndex=table.getSelectedRow();
			int num=(int)model.getValueAt(selectedIndex, 0);
			String name=(String)model.getValueAt(selectedIndex, 1);
			String addr=(String)model.getValueAt(selectedIndex, 2);
			//수정할 회원의 정보를 MemberDto 객체에 담고 
			MemberDto dto=new MemberDto(num, name, addr);
			//DB에 저장하기 
			//MmeberDao 객체를 이용해서 수정을 반영한다
			new MemberDao().update(dto);
			//선택된 포커스 clear
			table.clearSelection();
		}
	
	}
}
