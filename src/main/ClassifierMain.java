package main;

import instance.MnistVector;
import instance.vectors.IVector;

import java.util.LinkedList;
import java.util.List;

import reader.MnistReader;
import classifiers.IClassifier;
import classifiers.knn.KNN;
import constants.IConstants;


public class ClassifierMain {
	public static void main(String[] args) throws Exception {
		List<MnistVector> dataset = new MnistReader(IConstants.TRAIN_IMAGE_FILE, IConstants.TRAIN_LABEL_FILE).getInstances();
		List<MnistVector> trainingSet = dataset.subList(0, 7*dataset.size()/8);
		List<MnistVector> testSet = dataset.subList(7*dataset.size()/8, dataset.size());
		
		System.out.println("Training set size: "+trainingSet.size());
		System.out.println("Test set size: "+testSet.size());
		
		IClassifier knn = new KNN(1);
		knn.buildClassifier(new LinkedList<IVector>(trainingSet));
		
		int correct, predicted, totRight=0, totWrong=0;
		int count = 0;
		for(MnistVector mv : testSet) {
			if( ++count % 10 == 0 )
				System.out.println(count+" out of "+testSet.size());
			
			correct = mv.getLabel();
			predicted = knn.classify(mv);
//			System.out.println("Input: "+correct+". Prediction: "+predicted);
			if(correct == predicted)
				totRight++;
			else
				totWrong++;
		}
		System.out.println("Correct predictions: "+totRight);
		System.out.println("Wrong predictions: "+totWrong);
		
//		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
//		forkJoinPool.submit( () -> {
//			trainingSet
//			.stream()
//			.forEach(mv -> {
//				System.out.println("Input: "+mv.getLabel()+". Prediction: "+knn.classify(mv));
//			});
//		}).get();
		
//		trainingSet
//			.parallelStream()
//			.forEach(mv -> {
//				System.out.println("Input: "+mv.getLabel()+". Prediction: "+knn.classify(mv));
//			});
		
	}
}
