package instance;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;


public class MnistInstance extends IVector {
	protected int 		label;
	protected byte[] 	features;

	public MnistInstance(byte[] data, int label) {
		this.features = data;
		this.label = label;
	}
	
	@Override
	protected ObjectSet<?> keySet() {
		return new ObjectOpenHashSet<>();
	}
	@Override
	protected Byte getFeatureValue(int index) {
		return features[index];
	}

}
