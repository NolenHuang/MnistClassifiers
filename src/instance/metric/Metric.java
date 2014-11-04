package instance.metric;

import instance.vectors.IVector;

import java.util.function.BiFunction;

public abstract class Metric implements BiFunction<IVector, IVector, Double>{
	private static class EuclideanDistance extends Metric {
		@Override
		public Double apply(IVector t, IVector u) {
			double dist = 0.0;
//			for(int k : t.getKeyIterable())
//				if(t.get(k) != 0 && u.get(k) != 0)
//					dist += Math.pow( t.get(k) - u.get(k) , 2 );
			dist = t.getKeyStream().filter(k -> t.get(k) != 0).mapToDouble(k -> Math.pow( t.get(k) - u.get(k) , 2 ) ).reduce( (x,y) -> x+y).getAsDouble();
//			double dist = t.keySet().parallelStream().map( k -> Math.pow( t.get(k) - u.get(k), 2 ) ).collect(Collectors.summingDouble(x -> x) );
			return Math.sqrt(dist);
		}
	}
	
	private static class JaccardSimilarity extends Metric {
		@Override
		public Double apply(IVector t, IVector u) {
			long intersection = t.getKeyStream().filter(k -> t.get(k) == u.get(k)).count();
			double union = t.size();
			return intersection / union;
		}
	}
	
	public static final Metric EuclideanDistance = new EuclideanDistance();
	public static final Metric JaccardSimilarity = new JaccardSimilarity();
	
}
