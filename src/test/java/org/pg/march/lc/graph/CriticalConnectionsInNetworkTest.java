package org.pg.march.lc.graph;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class CriticalConnectionsInNetworkTest {

	private CriticalConnectionsInNetwork criticalConnectionsInNetwork;

	@Before
	public void setup() {
		criticalConnectionsInNetwork = new CriticalConnectionsInNetwork();
	}

	@Test
	public void testcase1() {
		List<List<Integer>> connections = new ArrayList<List<Integer>>();
		connections.add(Lists.newArrayList(0, 1));
		connections.add(Lists.newArrayList(1, 2));
		connections.add(Lists.newArrayList(2, 0));
		connections.add(Lists.newArrayList(1, 3));
		List<List<Integer>> criticalConnections = criticalConnectionsInNetwork.criticalConnections(4, connections);
		System.out.println(criticalConnections);
	}
}
