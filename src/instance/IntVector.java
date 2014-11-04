package instance;

import instance.vectors.IVector;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;

import java.util.stream.IntStream;

public class IntVector extends IVector {
	protected int[] data;

	public IntVector(int[] data) {
		this.data = data;
	}

	@Override
	public IntSet keySet() {
		return new IntOpenHashSet( data );
	}

	@Override
	public double get(int k) {
		return data[k];
	}
	
	@Override
	public int getLabel() {
		return 0;
	}

//	@Override
//	public IntIterable getKeyIterable() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public IntStream getKeyStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
