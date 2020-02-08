package org.pg.march.lc.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReorderDataLogFilesTest {

	private ReorderDataLogFiles reorderDataLogFiles;

	@Before
	public void setup() {
		reorderDataLogFiles = new ReorderDataLogFiles();
	}

	@Test
	public void testcase1() {
		String[] logs = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
		String[] sortedLogs = reorderDataLogFiles.reorderLogFiles(logs);
		String[] expected = { "let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6" };
		Assert.assertArrayEquals(expected, sortedLogs);
	}
}
