package classifiers;

import instance.MnistVector;

import java.util.List;

public interface IClassifier {
	public void buildClassifier(List<MnistVector> trainingSet);
}
