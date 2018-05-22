package com.zhongtiancai.classify;

import java.util.List;

public interface Classify {

	List<Color> getMainColor();

	void assignClusters(Color pixel);
}
