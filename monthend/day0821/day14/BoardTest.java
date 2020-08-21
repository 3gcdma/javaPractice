
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.ssafy.day14.dao.BoardDAO;
import com.ssafy.day14.dao.BoardDAOImpl;
import com.ssafy.day14.vo.Board;

public class BoardTest extends JFrame{
	
	private JTextField tfNo, tfTitle, tfWriter, tfContent;
	private JLabel lblNo, lblTitle, lblWriter, lblContent, lblview_cnt, lblSpaces;
	private JButton btnNew, btnSave, btnRemove, btnList;
	private JTable tblBoardList;
    private DefaultTableModel model;
	
    private int selectedBoardNo;
    private char modeJob;
    
    private String[] columnNames = { "게시 번호", "제목", "글쓴이", "내용", "조회수"};
    
    public BoardTest() {
    	createUI();
    	select(); 
    	
    	selectedBoardNo = -1;
    	modeJob = 'N';
    }
	
	private void createUI() {
    	
		setUIFont(new javax.swing.plaf.FontUIResource("Sans", Font.PLAIN, 14));
    	
		
		tblBoardList = new JTable();
		model = new DefaultTableModel();
		tblBoardList.setRowHeight(25);
		
		model.setColumnIdentifiers(columnNames);  
		tblBoardList.setModel(model);
		
		add(new JScrollPane(tblBoardList), BorderLayout.CENTER);
		
		Box boardInfo = Box.createHorizontalBox();
        add(boardInfo, BorderLayout.SOUTH);
        
        tfNo = new JTextField(); tfNo.setEditable(false);
        tfTitle = new JTextField();
        tfWriter = new JTextField();
        tfContent = new JTextField();
        
        lblNo = new JLabel(" 번호 ");
        lblTitle = new JLabel(" 제목 ");
        lblWriter = new JLabel(" 글쓴이 ");
        lblContent = new JLabel(" 내용 ");
        lblview_cnt = new JLabel(" 조회수 ");
        lblSpaces = new JLabel("  ");
        
        btnNew = new JButton("New");
        btnSave = new JButton("Save");
        btnRemove = new JButton("Remove");  btnRemove.setForeground(Color.RED);      
        btnList = new JButton("List"); btnList.setForeground(Color.BLUE); 
        
        boardInfo.add(lblSpaces);
        
        boardInfo.add(lblNo);
        boardInfo.add(tfNo);
        
        boardInfo.add(lblSpaces);
        
        boardInfo.add(lblTitle);
        boardInfo.add(tfTitle);
        
        boardInfo.add(lblSpaces);
        
        boardInfo.add(lblWriter);
        boardInfo.add(tfWriter);
        
        boardInfo.add(lblSpaces);
        
        boardInfo.add(lblContent);
        boardInfo.add(tfContent);
        
        boardInfo.add(lblSpaces);
        
        boardInfo.add(btnNew);
        boardInfo.add(btnSave);
        boardInfo.add(btnRemove);
        boardInfo.add(btnList);
        
        tblBoardList.addMouseListener( new MouseAdapter() {
        	@Override
    		public void mouseReleased (MouseEvent e) {
        		int row =  tblBoardList.getSelectedRow();
        		tfNo.setText( (String) tblBoardList.getValueAt(row, 0) );
    			tfTitle.setText( (String) tblBoardList.getValueAt(row, 1) );
    			tfWriter.setText( (String) tblBoardList.getValueAt(row, 2) );
    			tfContent.setText( (String) tblBoardList.getValueAt(row, 3) );
    			
    			selectedBoardNo = Integer.parseInt(tfNo.getText());
    			modeJob = 'D';
        	}
        });
        
        btnNew.addActionListener( (e) -> {

			
			tfNo.setText("");
			tfTitle.setText("");
			tfWriter.setText("");
			tfContent.setText("");
			
			modeJob = 'N';
		} );
        
        btnSave.addActionListener( (e) -> {
			
        	switch( modeJob ) {
				case 'N' : 
					insert(); 
					select(); 
					break;
				case 'D' : 
					update(); 
					select(); 
					break;
			}
		} );
        
        btnRemove.addActionListener( (e) -> { delete(); select(); } );
		btnList.addActionListener( (e) -> {select();} );
		
	}

	private void delete() {
		BoardDAO dao = new BoardDAOImpl();
		
		try {
			dao.deleteBoard(selectedBoardNo);
			System.out.println("삭제 되었습니다.");
		} catch (Exception e) {
			System.out.println("등록시 에러발생");
			e.printStackTrace();
		}
	}

	private void update() {
		Board board = new Board();
		board.setNo(selectedBoardNo);
		board.setWriter(tfWriter.getText());
		board.setTitle(tfTitle.getText());
		BoardDAO dao = new BoardDAOImpl();
		
		try {
			dao.updateBoard(board);
			System.out.println("등록되었습니다.");
		} catch (Exception e) {
			System.out.println("등록시 에러발생");
			e.printStackTrace();
		}
	}

	private void select() {
		List<Board> list = new ArrayList<>();
		model.setRowCount(0);
		BoardDAO dao = new BoardDAOImpl();
		
		try {
			list = dao.selectBoard();
			for(Board board : list) {
				model.addRow(
						new Object[] {
							String.valueOf( board.getNo() ),  
							String.valueOf( board.getTitle() ),
							String.valueOf( board.getWriter() ), 
							String.valueOf( board.getContent() ),
							String.valueOf( board.getView_cnt() )
					});
			}
			System.out.println("검색완료");
		} catch (Exception e) {
			System.out.println("검색 결과 에러발생");
			e.printStackTrace();
		}
		
	}

	private void insert() {
		Board board = new Board();
		board.setWriter(tfWriter.getText());
		board.setTitle(tfTitle.getText());
		board.setContent(tfContent.getText());
		BoardDAO dao = new BoardDAOImpl();
		
		try {
			dao.insertBoard(board);
			System.out.println("등록되었습니다.");
		} catch (Exception e) {
			System.out.println("등록시 에러발생");
			e.printStackTrace();
		}
	}

	private void setUIFont(javax.swing.plaf.FontUIResource f) {
		java.util.Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put(key, f);
        }
	}

	public static void main(String[] args) {
//		Board board = new Board();
//		board.setNo(1);
//		board.setWriter("Hong");
//		board.setTitle("hong hong");
//		board.setContent("update Hong Hong Hong");
//		BoardDAO dao = new BoardDAOImpl();
//		
//		try {
//			dao.deleteBoard(1);
//			System.out.println("삭제 되었습니다.");
//		} catch (Exception e) {
//			System.out.println("등록시 에러발생");
//			e.printStackTrace();
//		}
//		try {
//			dao.insertBoard(board);
//			System.out.println("수정 되었습니다.");
//		} catch (Exception e) {
//			System.out.println("등록시 에러발생");
//			e.printStackTrace();
//		}
//		try {
//			dao.updateBoard(board);
//			System.out.println("등록되었습니다.");
//		} catch (Exception e) {
//			System.out.println("등록시 에러발생");
//			e.printStackTrace();
//		}
		
		BoardTest ui = new BoardTest();
		ui.setTitle("SSAFY V1 - 게시판 관리 시스템 ");
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ui.setSize(1000, 600);
		ui.setLocationRelativeTo(null);
		ui.setResizable(true);
		ui.setVisible(true);
		
		
		
	}
}
