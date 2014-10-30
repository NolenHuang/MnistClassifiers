package main;

import instance.MnistInstance;

import java.util.List;

import classifiers.IClassifier;
import classifiers.knn.KNN;
import reader.MnistReader;
import constants.IConstants;


public class ClassifierMain {
	public static void main(String[] args) {
		List<MnistInstance> trainingSet = new MnistReader(IConstants.TRAIN_IMAGE_FILE, IConstants.TRAIN_LABEL_FILE).getInstances();
		IClassifier knn = new KNN();
		knn.buildClassifier(trainingSet);
	}
}
