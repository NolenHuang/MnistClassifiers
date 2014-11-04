package instance;

import instance.vectors.IVector;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;

import java.util.stream.IntStream;

public class MnistVector extends IVector {
	protected int 		label;
	protected byte[] 	data;

	public MnistVector(byte[] data, int label) {
		this.data = data;
		this.label = label;
	}

	@Override
	public IntSet keySet() {
		return new IntOpenHashSet(this.getKeyStream().toArray());
	}
	
//	@Override
//	public IntIterable getKeyIterable() {
//		return new IntIterable() {
//			@Override
//			public IntIterator iterator() {
//				return new IntIterator() {
//					protected int current=0;
//					@Override
//					public Integer next() {
//						return current++;
//					}
//					@Override
//					public boolean hasNext() {
//						return current < data.length;
//					}
//					@Override
//					public int skip(int n) {
//						return 0;
//					}
//					@Override
//					public int nextInt() {
//						return current++;
//					}
//				};
//			}
//		};
//	}
	
	@Override
	public IntStream getKeyStream() {
		return IntStream.range(0, data.length).parallel();
	}

	@Override
	public double get(int k) {
		return data[k];
	}
	
	@Override
	public int getLabel() {
		return label;
	}
	
	@Override
	public int size() {
		return data.length;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<28; i++) {
			for(int j=0; j<28; j++) {
				sb.append( String.format("%4d ", data[28*i + j]) );
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
}
