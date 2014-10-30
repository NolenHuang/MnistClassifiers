package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import constants.IConstants;
import reader.MnistReader;

public class ReaderTest {
	private final int IMAGE_MAGIC = 2051, LABEL_MAGIC = 2049;
	private final int TRAIN_SIZE = 60000, TEST_SIZE = 10000;
	private final int ROW_COUNT = 28, COL_COUNT = 28;
	protected MnistReader trainReader, testReader;
	
	@Before
	public void setUp() {
		this.trainReader 	= new MnistReader(IConstants.TRAIN_IMAGE_FILE, IConstants.TRAIN_LABEL_FILE);
		this.testReader 	= new MnistReader(IConstants.TEST_IMAGE_FILE, IConstants.TEST_LABEL_FILE);
	}
	
	@Test
	public void testMagic() {
		assertEquals(IMAGE_MAGIC, trainReader.getImageMagic());
		assertEquals(IMAGE_MAGIC, testReader.getImageMagic());
		
		assertEquals(LABEL_MAGIC, trainReader.getLabelMagic());
		assertEquals(LABEL_MAGIC, testReader.getLabelMagic());
	}
	
	@Test
	public void testSize() {
		assertEquals(TRAIN_SIZE, trainReader.getImageSize());
		assertEquals(TRAIN_SIZE, trainReader.getLabelSize());
		
		assertEquals(TEST_SIZE, testReader.getImageSize());
		assertEquals(TEST_SIZE, testReader.getLabelSize());
	}
	
	@Test
	public void testRowCol() {
		assertEquals(ROW_COUNT, trainReader.getNumRows());
		assertEquals(COL_COUNT, trainReader.getNumCols());
		
		assertEquals(ROW_COUNT, testReader.getNumRows());
		assertEquals(COL_COUNT, testReader.getNumCols());
	}
	
	@Test
	public void testCount() {
		assertEquals( TRAIN_SIZE, trainReader.getInstances().size() );
		assertEquals( TEST_SIZE, testReader.getInstances().size() );
	}

}
