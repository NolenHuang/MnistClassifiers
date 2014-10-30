package reader;

import instance.Instance;

import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Reader {
	private static final int OFFSET_SIZE = 4; //in bytes

	private static final int NUMBER_ITEMS_OFFSET = 4;
	private static final int ITEMS_SIZE = 4;

	private static final int NUMBER_OF_ROWS_OFFSET = 8;
	private static final int ROWS_SIZE = 4;

	private static final int NUMBER_OF_COLUMNS_OFFSET = 12;
	private static final int COLUMNS_SIZE = 4;

	private static final int IMAGE_OFFSET = 16;

	protected int labelMagic, imageMagic, labelSize, imageSize, numCols, numRows;
	protected List<Instance> instances;
	
	public Reader(String imageFile, String labelFile) {
		this.init(Paths.get(imageFile), Paths.get(labelFile));
	}
	
	protected void init(Path imagePath, Path labelPath) {
		byte[] imageData = null, labelData = null;
		try {
			imageData = Files.readAllBytes(imagePath);
			labelData = Files.readAllBytes(labelPath);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		this.labelMagic = ByteBuffer.wrap( 	Arrays.copyOfRange(	labelData, 0, OFFSET_SIZE) ).getInt();
		this.imageMagic= ByteBuffer.wrap(	Arrays.copyOfRange(	imageData, 0, OFFSET_SIZE) ).getInt();
		
		this.labelSize = ByteBuffer.wrap( 	Arrays.copyOfRange(labelData, NUMBER_ITEMS_OFFSET, NUMBER_ITEMS_OFFSET+OFFSET_SIZE) ).getInt();
		this.imageSize = ByteBuffer.wrap( 	Arrays.copyOfRange(imageData, NUMBER_ITEMS_OFFSET, NUMBER_ITEMS_OFFSET+OFFSET_SIZE) ).getInt();
		
		this.numRows = ByteBuffer.wrap(		Arrays.copyOfRange(imageData, NUMBER_OF_ROWS_OFFSET, NUMBER_OF_ROWS_OFFSET + ROWS_SIZE)).getInt();
		this.numCols = ByteBuffer.wrap(		Arrays.copyOfRange(imageData, NUMBER_OF_COLUMNS_OFFSET, NUMBER_OF_COLUMNS_OFFSET + COLUMNS_SIZE)).getInt();
		int imageSize = numRows * numCols;
		
		instances = new LinkedList<>();
		instances.forEach(x -> System.out.println(x));
		for(int i = 0; i < labelSize; i++) {
			int label = labelData[OFFSET_SIZE + ITEMS_SIZE + i];
			byte[] image = Arrays.copyOfRange(imageData, (i * imageSize) + IMAGE_OFFSET, (i * imageSize) + IMAGE_OFFSET + imageSize);
			instances.add(new Instance(image, label));
		}
		
	}

	public int getImageMagic() {
		return imageMagic;
	}

	public int getLabelMagic() {
		return labelMagic;
	}

	public int getImageSize() {
		return imageSize;
	}

	public int getLabelSize() {
		return labelSize;
	}
	
	public int getNumCols() {
		return numCols;
	}
	
	public int getNumRows() {
		return numRows;
	}
	
	public List<Instance> getInstances() {
		return instances;
	}
}
