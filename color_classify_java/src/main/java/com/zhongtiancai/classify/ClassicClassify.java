package com.zhongtiancai.classify;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ClassicClassify implements Classify {
	private List<Color> colors;
	private List<Color> testColors;
	private List<Cluster> clusters = new ArrayList<>();

	// 百分比
	private double rate;

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	public List<Color> getTestColors() {
		return testColors;
	}

	public void setTestColors(List<Color> testColors) {
		this.testColors = testColors;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public ClassicClassify(List<Color> colors, List<Color> testColors,double rate) {
		super();
		this.colors = colors;
		this.testColors = testColors;
		this.rate = rate;
		for (int i = 0; i < testColors.size(); i++) {
			Cluster cluster = new Cluster();
			cluster.setCenter(testColors.get(i));
			clusters.add(cluster);
		}
	}

	public List<Color> getMainColor() {
		for (Color color : this.colors) {
			assignClusters(color);
		}
		clusters.sort(new Comparator<Cluster>() {
			@Override
			public int compare(Cluster o1, Cluster o2) {
				if (o1.getColors().size() > o2.getColors().size()) {
					return -1;
				} else if (o1.getColors().size() < o2.getColors().size()) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		List<Color> color = new ArrayList<>();
		for (Cluster cluster : clusters) {
			System.out.println(cluster.getCenter().toString() + cluster.getColors().size());
			if (colors.size() * rate <= cluster.getColors().size()) {
				color.add(cluster.getCenter());
			}
		}
		return color;
	}

	/**
	 * 按照距离分簇
	 */
	public void assignClusters(Color pixel) {
		double shortest = Float.MAX_VALUE;
		Cluster nearest = null;
		for (Cluster cluster : this.clusters) {
			double distance = new Distance(cluster.getCenter(), pixel).getDistance();
			if (distance < shortest) {
				shortest = distance;
				nearest = cluster;
			}
		}
		nearest.addPoint(pixel);
	}

}
