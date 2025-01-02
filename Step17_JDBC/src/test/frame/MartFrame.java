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

import test.dao.MartDao;
import test.dto.MartDto;
public class MartFrame extends JFrame implements ActionListener, PropertyChangeListener{
	JTextField inputCode,inputName,inputPrice,inputLoc;
	DefaultTableModel model;
	JTable table;
	//생성자
	public MartFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		JLabel label1 = new JLabel("코드");
		JLabel label2 = new JLabel("이름");
		JLabel label3 = new JLabel("가격");
		JLabel label4 = new JLabel("위치");
		
		inputCode = new JTextField(10);
		inputName = new JTextField(10);
		inputPrice = new JTextField(10);
		inputLoc = new JTextField(10);
		
		JButton addBtn = new JButton("추가");
		JButton deleteBtn = new JButton("삭제");
		JButton searchBtn = new JButton("검색");
		
		
		//UI 를 배치할 패널 준비
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(inputCode);
		panel.add(searchBtn);
		panel.add(label2);
		panel.add(inputName);
		panel.add(label3);
		panel.add(inputPrice);
		panel.add(label4);
		panel.add(inputLoc);
		panel.add(addBtn);
		panel.add(deleteBtn);
		
		
		//패널의 배경색 설정
		panel.setBackground(Color.green);
		
		//패널을 프레임의 위 쪽에 배치
		add(panel,BorderLayout.NORTH);
		
		addBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		addBtn.setActionCommand("add");
		deleteBtn.setActionCommand("delete");
		searchBtn.setActionCommand("search");
		
		//음식목록을 출력할 테이블
		table = new JTable();
		String[] colNames = {"상품 코드","이름","가격","위치"};
		model = new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				System.out.println(row+" | "+column);
				
				if(column==0) { // 0번째 칼럼은 
					return false; //수정 불가하게 false 를 리턴해 준다.
				}else { //다른 경우는 
					return true; //모두 수정 가능하게 true 를 리턴해 준다. 
				}
			}
		};
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		add(scroll,BorderLayout.CENTER);
		
		//테이블에 값이 바뀌었는지 감시할 리스너 등록
		table.addPropertyChangeListener(this);
		
		PrintMart();
		
		table.getTableHeader().setFont(new Font("Sans-serif",Font.BOLD,18));
		table.setFont(new Font("Sans-serif",Font.PLAIN, 16));
		table.setRowHeight(25);
		
	}
	//테이블에 목록을 보여줄 메소드
	public void PrintMart() {
		model.setRowCount(0);
		List<MartDto> list = new MartDao().getList();
		for (MartDto tmp : list) {
		    Object[] row = {tmp.getCode(),tmp.getName(),tmp.getPrice(),tmp.getLoc()};
		    model.addRow(row);
		}
	}
	//main 메소드
	public static void main(String[] args) {
		var m = new MartFrame("마트 관리 프로그램");
		m.setDefaultCloseOperation(EXIT_ON_CLOSE);
		m.setBounds(100, 100, 800, 500);
		m.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("add")) {
			String name=inputName.getText();
			int price = Integer.parseInt(inputPrice.getText());
			String loc=inputLoc.getText();
			//2. 읽어온 이름과 주소를 MemberDto 객체를 생성해서 담는다.
			MartDto dto=new MartDto();
			dto.setName(name);
			dto.setPrice(price);
			dto.setLoc(loc);
			
			//3. MemberDao 객체를 이용해서 DB 에 저장을 한다. 
			MartDao dao=new MartDao();
			dao.insert(dto);
			
			//4. refresh ! 
			PrintMart();
		}else if(command.equals("delete")) {
			//1. 선택한 row 가 있는지 , 있다면 어떤 row 를 선택했는지 알아내기
			//int selectedIndex=table.getSelectedRow();
			int[] rows=table.getSelectedRows();
			if(rows.length == 0) {
				//선택된 row 가 없다고 알려준다.
				JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요.s");
				//프레임아 밑에 코드는 실행하지마!
				return; 
			}
			for(int tmp:rows) {
				//2.선택한 row 의 가장 첫번째 칼럼에 있는 숫자를 읽어내기
				int num=(int)model.getValueAt(tmp, 0);
				//3. FoodsDao 객체를 이용해서 DB 에서 삭제
				MartDao dao=new MartDao();
				dao.delete(num);
			}
			
			//4. refresh
			PrintMart();
		}else if(command.equals("search")){
			int code = Integer.parseInt(inputCode.getText());
			MartDao dao=new MartDao();
			MartDto dto = dao.getData(code);
			if(dto != null) {
				model.setRowCount(0); 
				Object[] row = {dto.getCode(), dto.getName(), dto.getPrice(), dto.getLoc()};
	            model.addRow(row);
			}else if(dto == null){
				JOptionPane.showMessageDialog(this, "코드를 입력하세요~!");
			}
			}else {
				JOptionPane.showMessageDialog(this, "코드랑 부합하는 책이 없어요!");
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
					int code=(int)model.getValueAt(selectedIndex, 0);
					String name=(String)model.getValueAt(selectedIndex, 1);
					int price = (int)model.getValueAt(selectedIndex, 2);
					String loc=(String)model.getValueAt(selectedIndex, 3);
					//수정할 회원의 정보를 MemberDto 객체에 담고 
					MartDto dto=new MartDto(code, name, price, loc);
					//DB에 저장하기 
					new MartDao().update(dto);
					//선택된 포커스 clear
					table.clearSelection();
				}
	}
}
