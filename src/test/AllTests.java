package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.reader.ReaderTest;

@RunWith(Suite.class)
@SuiteClasses({ ReaderTest.class })
public class AllTests {

}
