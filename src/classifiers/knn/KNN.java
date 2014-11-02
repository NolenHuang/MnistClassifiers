package classifiers.knn;

import instance.vectors.IVector;

import java.util.List;

import classifiers.IClassifier;

public class KNN implements IClassifier {
	protected final int k;
	protected List<IVector> trainingSet;

	public KNN(int k) {
		super();
		this.k = k;
	}
	
	public KNN() {
		this(1);
	}

	@Override
	public void buildClassifier(List<IVector> trainingSet) {
		this.trainingSet = trainingSet;
	}

}
