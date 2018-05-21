# coding=gbk
import colorsys
from PIL import Image
import k_mean_class

"""
 -------------generate_color---------------
"""
def find_main_color(file,  max_iterations=20, min_distance=0.5, k=10):
    """
    mode=0ʱ���õķ�����ʹ�þ���kֵ�������ж�ͼ��������ɫ
    :param frame: Ҫ������֡
    :param file: �ļ���
    :param image_count: ����
    :param max_iterations:������ȣ�ֵԽ�������Խ����Խ��ȷ���ٶ�Խ��
    :param min_distance:������ɫ���룬��ֵԽС������ɫ����̶�Խ��
    :param k:�����ʼ��������ͬʱҲ�������color��list�ĳ���
    """
    k_image = k_mean_class.Kmeans(max_iterations=max_iterations, min_distance=min_distance, k=k)
    im = Image.open(file)
    image = im.convert('RGB')
    try:
        color = k_image.run(image)
    except:
        print(file + '����ʧ��')
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
    print(find_main_color(file="C:\\Users\\Administrator\\Desktop\\��©ͷ��_20180424\\dist\\������_422432196303156038_������.JPG",k=2))