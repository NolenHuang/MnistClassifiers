package main;

import instance.Instance;

import java.util.List;

import reader.Reader;
import constants.IConstants;


public class ClassifierMain {
	public static void main(String[] args) {
		List<Instance> trainingSet = new Reader(IConstants.TRAIN_IMAGE_FILE, IConstants.TRAIN_LABEL_FILE).getInstances();
		
	}
}
