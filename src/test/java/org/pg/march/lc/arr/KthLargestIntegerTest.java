package org.pg.march.lc.arr;

import org.junit.Assert;
import org.junit.Test;

public class KthLargestIntegerTest {

    KthLargestInteger kthLargestInteger = new KthLargestInteger();

    @Test
    public void kthLargestIntegerTest1() {
        Assert.assertEquals("3", kthLargestInteger.kthLargestNumber(new String[]{"3","6","7","10"}, 4));
    }

    @Test
    public void kthLargestIntegerTest2() {
        Assert.assertEquals("12", kthLargestInteger.kthLargestNumber(new String[]{"5", "2","21","12","1"}, 2));
    }

    @Test
    public void kthLargestIntegerTest3() {
        Assert.assertEquals("0", kthLargestInteger.kthLargestNumber(new String[]{"0","0"}, 2));
    }

    @Test
    public void kthLargestIntegerTest4() {
        Assert.assertEquals("38272299275037314530", kthLargestInteger.kthLargestNumber(new String[]{"683339452288515879","7846081062003424420","4805719838","4840666580043","83598933472122816064","522940572025909479","615832818268861533","65439878015","499305616484085","97704358112880133","23861207501102","919346676","60618091901581","5914766072","426842450882100996","914353682223943129","97","241413975523149135","8594929955620533","55257775478129","528","5110809","7930848872563942788","758","4","38272299275037314530","9567700","28449892665","2846386557790827231","53222591365177739","703029","3280920242869904137","87236929298425799136","3103886291279"}, 3));
    }

}
