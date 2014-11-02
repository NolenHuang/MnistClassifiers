package instance.metric;

import instance.vectors.IVector;

import java.util.function.BiFunction;

public abstract class Metric implements BiFunction<IVector, IVector, Double>{
	private static class EuclideanDistance extends Metric {
		@Override
		public Double apply(IVector t, IVector u) {
			double dist = 0.0;
			for(int k : t.keySet())
				dist += Math.pow( t.get(k) - u.get(k) , 2 );
			return Math.sqrt(dist);
		}
	}
	
	public static final Metric EuclideanDistance = new EuclideanDistance();
	
}
