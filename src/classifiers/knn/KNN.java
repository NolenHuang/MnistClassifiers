package classifiers.knn;

import instance.MnistInstance;

import java.util.List;

import classifiers.IClassifier;

public class KNN implements IClassifier {
	protected final int k;
	protected List<MnistInstance> trainingSet;

	public KNN(int k) {
		super();
		this.k = k;
	}
	
	public KNN() {
		this(1);
	}

	@Override
	public void buildClassifier(List<MnistInstance> trainingSet) {
		this.trainingSet = trainingSet;
	}

}
