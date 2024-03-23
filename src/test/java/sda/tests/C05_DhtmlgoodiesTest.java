package sda.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sda.pages.DhtmlgoodiesTest;
import sda.utilities.Driver;

public class C05_DhtmlgoodiesTest {

    @Test
    public void Test() {

        DhtmlgoodiesTest dhtmlgoodiesTest = new DhtmlgoodiesTest();

        //Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html

        String url = "http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html";
        Driver.getDriver().get(url);

        //Fill in capitals by country.

        dhtmlgoodiesTest.dragCapitolInCountryBox("Madrid", "Spain");
        dhtmlgoodiesTest.dragCapitolInCountryBox("Washington", "United States");
        dhtmlgoodiesTest.dragCapitolInCountryBox("Rome", "Italy");
        dhtmlgoodiesTest.dragCapitolInCountryBox("Seoul", "South Korea");
        dhtmlgoodiesTest.dragCapitolInCountryBox("Copenhagen", "Denmark");
        dhtmlgoodiesTest.dragCapitolInCountryBox("Oslo", "Norway");
        dhtmlgoodiesTest.dragCapitolInCountryBox("Stockholm", "Sweden");

    }

}
