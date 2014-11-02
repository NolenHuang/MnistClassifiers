package main;

import instance.IntVector;
import instance.vectors.IVector;

import java.util.List;

import reader.MnistReader;
import classifiers.IClassifier;
import classifiers.knn.KNN;
import constants.IConstants;


public class ClassifierMain {
	public static void main(String[] args) {
		List<IVector> trainingSet = new MnistReader(IConstants.TRAIN_IMAGE_FILE, IConstants.TRAIN_LABEL_FILE).getInstances();
		IClassifier knn = new KNN();
		knn.buildClassifier(trainingSet);
		
		IntVector ii = new IntVector(new int[]{1,2,3});
		ii.keySet().stream().forEach( x -> System.out.println(x));
		
	}
}
