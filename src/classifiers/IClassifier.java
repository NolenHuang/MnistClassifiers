package classifiers;

import instance.MnistInstance;

import java.util.List;

public interface IClassifier {
	public void buildClassifier(List<MnistInstance> trainingSet);
}
