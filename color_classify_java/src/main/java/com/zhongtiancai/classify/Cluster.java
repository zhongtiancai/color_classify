package com.zhongtiancai.classify;

import java.util.ArrayList;
import java.util.List;

public class Cluster {
    //中间的color
	private Color center;
	private List<Color> colors = new ArrayList<>();

	

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	public Color getCenter() {
		return center;
	}

	public void setCenter(Color center) {
		this.center = center;
	}
	
	public void addPoint(Color color) {
		this.colors.add(color);
	}

	public void setNewCentroid() {
		int r = 0;
		int g = 0;
		int b = 0;

		for (Color color : this.colors) {
			r += color.getR();
			g += color.getG();
			b += color.getB();
		}
		if (colors.size() == 0) {
			this.center = new Color(0, 0, 0);
		} else {
			this.center = new Color(r / colors.size(), g / colors.size(), b / colors.size());
		}
		this.colors.clear();

	}

}
