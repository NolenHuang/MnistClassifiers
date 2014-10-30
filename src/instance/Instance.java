package instance;

public class Instance {
	protected int 		label;
	protected byte[] 	features;

	public Instance(byte[] data, int label) {
		this.features = data;
		this.label = label;
	}
	
}
