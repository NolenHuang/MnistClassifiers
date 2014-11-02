package classifiers;

import instance.vectors.IVector;

import java.util.List;

public interface IClassifier {
	public void buildClassifier(List<IVector> trainingSet);
}
