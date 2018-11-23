package swing2.model;

import java.util.ArrayList;

import swing2.view.Train;

public interface TrainDBA {
	
	//삽입
	
	//조회
	
	public void trainInsert1(Train t);
	public ArrayList<Train> TrainView();
	public ArrayList<Train> TrainSearch(String str);
	void trainInsert(Train t);

}
