package instance;

import instance.metrics.Metric;
import it.unimi.dsi.fastutil.objects.ObjectSet;

public abstract class IVector {
	public double getDistance(IVector other) {
		return this.getDistance(other, Metric.EuclideanDistance);
	}
	
	public double getDistance(IVector other, Metric metric) {
		return metric.getDistance(this, other);
	}
	
	
	protected abstract ObjectSet<?> keySet();
	protected abstract Object getFeatureValue(int index);
}
