/**
 * 
 */
package com.sist.d_dolive.reservation.imple;

import com.sist.d_dolive.reservation.ReservVO;

/**
 * @author sist
 *
 */
public class ReservUpdateCancel {
	static ReservDaoImple dao = new ReservDaoImple();

	/**
	 * 자르 파일용
	 * @param args
	 */
	public static void main(String[] args) {
		ReservVO reservVO = new ReservVO();
		reservVO.setSearchDiv("20");
		dao.doUpdate(reservVO);
	}

}
