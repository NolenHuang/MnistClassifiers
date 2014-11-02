package instance;

import instance.vectors.IVector;
import it.unimi.dsi.fastutil.ints.IntSet;

public class MnistVector extends IVector {
	protected int 		label;
	protected byte[] 	features;

	public MnistVector(byte[] data, int label) {
		this.features = data;
		this.label = label;
	}

	@Override
	public IntSet keySet() {
		return null;
	}

	@Override
	public double get(int k) {
		return 0;
	}
	
}
