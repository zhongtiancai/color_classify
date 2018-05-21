# coding=gbk
import colorsys
from PIL import Image
import k_mean_class

"""
 -------------generate_color---------------
"""
def find_main_color(file,  max_iterations=20, min_distance=0.5, k=10):
    """
    mode=0时调用的方法，使用聚类k值分析来判断图像主题颜色
    :param frame: 要分析的帧
    :param file: 文件名
    :param image_count: 计数
    :param max_iterations:计算深度，值越高则深度越深，结果越精确，速度越慢
    :param min_distance:相似颜色距离，此值越小，则颜色分离程度越大，
    :param k:聚类初始点数量，同时也代表输出color的list的长度
    """
    k_image = k_mean_class.Kmeans(max_iterations=max_iterations, min_distance=min_distance, k=k)
    im = Image.open(file)
    image = im.convert('RGB')
    try:
        color = k_image.run(image)
    except:
        print(file + '分析失败')
        return None
    hsv_color = []
    for i in color:
        hsv_color.append(list(colorsys.rgb_to_hsv(i[0], i[1], i[2])))
    hsv_color = sorted(hsv_color, key=lambda x: x[2], reverse=True)
    # print(hsv_color)
    for i in range(0, len(hsv_color)):
        r, g, b = colorsys.hsv_to_rgb(hsv_color[i][0], hsv_color[i][1], hsv_color[i][2])
        color[i] = (b, g, r)
        # print(color[i])
    return color



if __name__ == "__main__":
    print(find_main_color(file="C:\\Users\\Administrator\\Desktop\\遗漏头像_20180424\\dist\\王友新_422432196303156038_辅导班.JPG",k=2))