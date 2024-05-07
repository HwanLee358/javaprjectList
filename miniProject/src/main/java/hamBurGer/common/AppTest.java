package hamBurGer.common;

import java.util.List;

import hamBurGer.dao.hamDAO;
import hamBurGer.vo.hamVO;

public class AppTest {
	public static void main(String[] args) {
		hamDAO hdao = new hamDAO();
		List<hamVO> hlist = hdao.selectHam();
		for(hamVO e : hlist) {
			System.out.println(e.toString());
		}
	}
}
