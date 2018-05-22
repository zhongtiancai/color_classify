package com.zhongtiancai.classify;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //kmeans();
    	classic();
    }

	private static void classic() {
		try {
			List<Color> a = ImageUtils.getImagePixel(
					"C:\\Users\\Administrator\\Desktop\\遗漏头像_20180424\\dist\\陈梦英_422201199102152020_辅导班.JPG");
			List<Color> testColor = Color.defaultColors;
			Classify k = new ClassicClassify(a, testColor, 0.05);
			List<Color> color = k.getMainColor();
			System.out.println(color);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void kmeans() {
		try {
			List<Color> a = ImageUtils.getImagePixel("C:\\Users\\Administrator\\Desktop\\遗漏头像_20180424\\dist\\王友新_422432196303156038_辅导班.JPG");
			KMean k = new KMean(2, 5, 5, 5, a);
			List<Color> color = k.getMainColor();
			System.out.println(color);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
