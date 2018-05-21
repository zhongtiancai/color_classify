package com.zhongtiancai.classify;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class ImageUtils {
	
	public static List<Color> getImagePixel(String image) throws Exception {
		File file = new File(image);
		BufferedImage bi = ImageIO.read(file);
		List<Color> colors = new ArrayList<>();
		for (int i = bi.getMinX(); i < bi.getWidth(); i++) {
			for (int j = bi.getMinY(); j < bi.getHeight(); j++) {
				int pixel = bi.getRGB(i, j);
				Color color = new Color((pixel & 0xff0000) >> 16, (pixel & 0xff00) >> 8, pixel & 0xff);
				colors.add(color);
			}
		}
		return colors;
	}
}
