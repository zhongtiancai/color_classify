package com.zhongtiancai.classify;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KMean implements Classify {
	private int k = 5;
	private int max_iterations = 20;
	private int min_distance = 5;
	private int size = 200;
	private List<Color> colors = new ArrayList<>();
	private List<Cluster> clusters = new ArrayList<>();
	private List<Color> oldClusterCenters = new ArrayList<>();

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getMax_iterations() {
		return max_iterations;
	}

	public void setMax_iterations(int max_iterations) {
		this.max_iterations = max_iterations;
	}

	public int getMin_distance() {
		return min_distance;
	}

	public void setMin_distance(int min_distance) {
		this.min_distance = min_distance;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public KMean(int k, int max_iterations, int min_distance, int size, List<Color> colors) {
		super();
		this.k = k;
		this.max_iterations = max_iterations;
		this.min_distance = min_distance;
		this.size = size;
		this.colors = colors;
		List<Integer> randomList = RandomArray.genRandomArray(colors.size(), k);
		for (int i = 0; i < k; i++) {
			Cluster cluster = new Cluster();
			cluster.setCenter(colors.get(randomList.get(i)));
			clusters.add(cluster);
		}
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

	public List<Color> getMainColor() {
		int i = 0;
		while (!shouldExit(i)) {
			this.oldClusterCenters = this.clusters.stream().map(cluster -> cluster.getCenter())
					.collect(Collectors.toList());
			for (Color color : this.colors) {
				assignClusters(color);
			}
			for (Cluster cluster : this.clusters) {
				cluster.setNewCentroid();
			}
			i += 1;
		}
		return this.clusters.stream().map(c -> c.getCenter()).collect(Collectors.toList());
	}

	public boolean shouldExit(int iterations) {
		if (this.oldClusterCenters == null || this.oldClusterCenters.size() <= 0) {
			return false;
		}
		for (int i = 0; i < this.k; i++) {
			if (new Distance(this.getClusters().get(i).getCenter(),
					this.getOldClusterCenters().get(i)).getDistance() < this.min_distance) {
				return true;
			}
		}
		if (iterations <= this.max_iterations) {
			return false;
		}
		return true;
	}

	

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	public List<Cluster> getClusters() {
		return clusters;
	}

	public List<Color> getOldClusterCenters() {
		return oldClusterCenters;
	}

	public void setOldClusterCenters(List<Color> oldClusterCenters) {
		this.oldClusterCenters = oldClusterCenters;
	}

}
