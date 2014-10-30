package classifiers;

import instance.Instance;

import java.util.List;

public interface IClassifier {
	public void buildClassifier(List<Instance> trainingSet);
}
