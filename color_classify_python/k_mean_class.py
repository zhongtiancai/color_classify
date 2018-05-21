# -*- coding: utf-8 -*-
import random
import numpy

"""
 -------------k_mean_class---------------
功能：使用k值估计计算传入图片的主题颜色
"""

class Cluster(object):

    def __init__(self):
        self.pixels = []
        self.centroid = None

    def addPoint(self, pixel):
        self.pixels.append(pixel)

    def setNewCentroid(self):

        R = [colour[0] for colour in self.pixels]
        G = [colour[1] for colour in self.pixels]
        B = [colour[2] for colour in self.pixels]

        # print(sum(R),len(R))
        # print(sum(G), len(G))
        # print(sum(B), len(B))

        # 画面不含有某个通道的颜色（比如画面颜色较纯等等）
        # 对其进行+1防止被0除
        if len(R)>0:
            R = sum(R) / len(R)
        else:
            R=sum(R)/(len(R)+1)
        if len(G)>0:
            G = sum(G) / len(G)
        else:
            G = sum(G) / (len(G)+1)
        if len(B)>0:
            B = sum(B) / len(B)
        else:
            B = sum(B) / (len(B)+1)

        self.centroid = (R, G, B)
        self.pixels = []

        return self.centroid


class Kmeans(object):

    def __init__(self, k=3, max_iterations=5, min_distance=5.0):
        self.k = k
        self.max_iterations = max_iterations
        self.min_distance = min_distance

    def run(self, pixels):

        self.pixels = pixels
        self.clusters = [None for i in range(self.k)]
        self.oldClusters = None

        randomPixels = random.sample(list(self.pixels), self.k)

        for idx in range(self.k):
            self.clusters[idx] = Cluster()
            self.clusters[idx].centroid = randomPixels[idx]

        iterations = 0

        while self.shouldExit(iterations) is False:

            self.oldClusters = [cluster.centroid for cluster in self.clusters]

            # print(iterations)

            for pixel in self.pixels:
                self.assignClusters(pixel)

            for cluster in self.clusters:
                cluster.setNewCentroid()

            iterations += 1

        return [cluster.centroid for cluster in self.clusters]

    def assignClusters(self, pixel):
        shortest = float('Inf')
        for cluster in self.clusters:
            distance = self.calcDistance(cluster.centroid, pixel)
            if distance < shortest:
                shortest = distance
                nearest = cluster

        nearest.addPoint(pixel)

    def calcDistance(self, a, b):

        result = numpy.sqrt(sum((a - b) ** 2))
        return result

    def shouldExit(self, iterations):

        if self.oldClusters is None:
            return False

        for idx in range(self.k):
            dist = self.calcDistance(
                numpy.array(self.clusters[idx].centroid),
                numpy.array(self.oldClusters[idx])
            )
            if dist < self.min_distance:
                return True

        if iterations <= self.max_iterations:
            return False

        return True


if __name__ == "__main__":
    import os
