package instance.vectors;

import instance.metric.Metric;
import it.unimi.dsi.fastutil.ints.IntSet;

public abstract class IVector {
	public double getEuclideanDistance(IVector other) {
		return this.getDistance(other, Metric.EuclideanDistance);
	}
	
	public double getDistance(IVector other, Metric metric) {
		return metric.apply(this, other);
	}
	
	
	public abstract IntSet keySet();
	public abstract double get(int k);
	
}
