package hamBurGer.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hamBurGer.common.connectDAO;
import hamBurGer.vo.hamVO;

public class hamDAO extends connectDAO{
	public List<Map<String, Object>> hamList(){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		conn();
		try {
			psmt = conn.prepareStatement("select * from hamburger");
			rs = psmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("고유번호", rs.getInt("ham_no"));
				map.put("메뉴이름", rs.getString("ham_name"));
				map.put("출시날짜", rs.getString("ham_Hire_Date"));
				map.put("칼로리", rs.getInt("ham_kcal"));
				map.put("가격", rs.getInt("ham_price"));
				map.put("재료", rs.getString("ham_Stuff"));
				
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disCon();
		}
		return list;
	} // end of hamList
	
	public List<hamVO> selectHam(){
		List<hamVO> list = new ArrayList<>();
		conn();
		try {
			psmt = conn.prepareStatement("select * from hamburger");
			rs = psmt.executeQuery();
			while(rs.next()) {
				hamVO ham = new hamVO();
				ham.setHam_No(rs.getInt("ham_No"));
				ham.setHam_Name(rs.getString("ham_Name"));
				ham.setHam_Kcal(rs.getInt("ham_Kcal"));
				ham.setHam_Hire_Date(rs.getString("ham_Hire_Date"));
				ham.setHam_Price(rs.getInt("ham_Price"));
				ham.setHam_Stuff(rs.getString("ham_Stuff"));
				
				list.add(ham);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disCon();
		}
		return list;
	}
}
