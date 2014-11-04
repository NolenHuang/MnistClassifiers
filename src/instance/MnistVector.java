package instance;

import instance.vectors.IVector;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;

import java.util.stream.IntStream;

public class MnistVector extends IVector {
	protected int 		label;
	protected byte[] 	features;

	public MnistVector(byte[] data, int label) {
		this.features = data;
		this.label = label;
	}

	@Override
	public IntSet keySet() {
		return new IntOpenHashSet(IntStream.range(0, features.length).toArray());
	}

	@Override
	public double get(int k) {
		return features[k];
	}
	
}
