package swing2.model;

import java.util.ArrayList;

import swing2.view.Train;

public interface TrainDBA {

	// 목록
	ArrayList<Train> list();

	// 검색 목록
	ArrayList<Train> search(String strType, String strValue);

	// 등록
	int insert(Train t);

	// 수정
	int update(Train t);

	// 삭제
	int delete(int num);

}
