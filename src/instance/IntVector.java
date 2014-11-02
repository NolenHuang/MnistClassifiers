package instance;

import instance.vectors.IVector;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntSet;

public class IntVector extends IVector {
	protected Int2IntMap data;

	public IntVector(int[] data) {
		this.data = new Int2IntOpenHashMap();
		this.data.defaultReturnValue(0);
		
		int k = 0;
		for( int v : data )
			this.data.put(k++, v);
	}

	@Override
	public IntSet keySet() {
		return data.keySet();
	}

	@Override
	public double get(int k) {
		return data.get(k);
	}
	
}
