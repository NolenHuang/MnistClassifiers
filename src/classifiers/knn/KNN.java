package classifiers.knn;

import instance.metric.Metric;
import instance.vectors.IVector;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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

	@Override
	public int classify(IVector v) {
		Map<Double, Long> neighbours = 
			trainingSet
				.parallelStream()
				.map(other -> {
//					double d = v.getEuclideanDistance(other);
					double d = v.getDistance(other, Metric.JaccardSimilarity);
					return new double[]{ other.getLabel(), d };
				})
				.sorted(new Comparator<double[]>() {
					@Override
					public int compare(double[] o1, double[] o2) {
						return Double.compare(o1[1], o2[1]);
					}
				})
				.limit(this.k)
				.collect( Collectors.groupingBy( KNN::getFirst, HashMap::new, Collectors.counting()) );
		
//		System.out.println(v);
//		neighbours.forEach( (k, value) -> System.out.println(k+" -> "+value));
		
		int maxLabel = -1;
		long maxCount = -1;
		for(Entry<Double, Long> e : neighbours.entrySet()) {
			if(e.getValue()>maxCount) {
				maxLabel = e.getKey().intValue();
				maxCount = e.getValue();
			}
		}
		return maxLabel;
	}
	
	protected static double getFirst(double[] d) { return d[0]; };
	protected static double getSecond(double[] d) { return d[1]; };
	
}
