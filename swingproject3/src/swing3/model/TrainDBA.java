package swing3.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TrainDBA {

	
	// 등록
	int insert(TrainBean t);

	// 수정
	int update(TrainBean t);

	// 삭제
	int delete(int num);

	ArrayList<TrainBean> bookView();

	
}
