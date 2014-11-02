package classifiers.knn;

import instance.MnistVector;

import java.util.List;

import classifiers.IClassifier;

public class KNN implements IClassifier {
	protected final int k;
	protected List<MnistVector> trainingSet;

	public KNN(int k) {
		super();
		this.k = k;
	}
	
	public KNN() {
		this(1);
	}

	@Override
	public void buildClassifier(List<MnistVector> trainingSet) {
		this.trainingSet = trainingSet;
	}

}
