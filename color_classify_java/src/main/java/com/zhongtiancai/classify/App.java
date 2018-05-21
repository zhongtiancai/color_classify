package com.zhongtiancai.classify;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
