package com.zmousa.autocomplete;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AutoCompleteUnitTest.class, BinarySearchDeluxeUnitTest.class,
		TermUnitTest.class })
public class AllTests {

}
