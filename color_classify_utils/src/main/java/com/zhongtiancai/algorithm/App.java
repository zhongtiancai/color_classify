package com.zhongtiancai.algorithm;

import java.util.Collection;
import java.util.List;

import org.apache.commons.math3.ml.clustering.CentroidCluster;
import org.apache.commons.math3.ml.clustering.KMeansPlusPlusClusterer;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			Collection<Color> list = ImageUtils.getImagePixel(
					"C:\\Users\\zhongtiancai\\Desktop\\a\\obama.jpg");
			KMeansPlusPlusClusterer<Color> kClusterer = new KMeansPlusPlusClusterer<Color>(3, 15);
			List<CentroidCluster<Color>> results = kClusterer.cluster(list);
			for(CentroidCluster<Color> result :results){
				System.out.println(new Color(result.getCenter().getPoint()).getColor());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
