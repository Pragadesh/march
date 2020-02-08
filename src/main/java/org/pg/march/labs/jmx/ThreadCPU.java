package org.pg.march.labs.jmx;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class ThreadCPU {

    private static ThreadMXBean m_threadMXBean = ManagementFactory.getThreadMXBean();
    
    public static void main(String[] args) throws Exception {
        boolean canCPUTimeBeMeasured = false;
        try {
            canCPUTimeBeMeasured = (m_threadMXBean.isThreadCpuTimeSupported() && m_threadMXBean
                    .isThreadCpuTimeEnabled());
            
        } catch (UnsupportedOperationException e) {
            canCPUTimeBeMeasured = false;
        }
        int k = 1000;
        while(true) {
            int i = k;
            while(i-- > 0) {
                
            }
            k *= 10;
            if (canCPUTimeBeMeasured) {
                // converting from nano to milli second
                
                System.out.println(String.format("CPU time for %d: ", k) + m_threadMXBean.getCurrentThreadCpuTime() / 1000000L);
            }
            Thread.sleep(3000);
        }
    }
    
}
