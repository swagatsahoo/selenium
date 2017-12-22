package org.test.utility;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownOptionSelector{
	
	
	public void dropdownValue(WebElement dropdownObjectProperty,String valueToSelect) {
		
		
		Select select = new Select(dropdownObjectProperty);
		List<WebElement> options = select.getOptions();
		int count = options.size();
		
		if (count >  0) {
			
			for (WebElement option : options) {
				
				try
				{
					option.getText().equals(valueToSelect); 
					select.selectByVisibleText(valueToSelect);
				}
				catch (Exception e) {
					e.printStackTrace();
					break;
				}
				
			}
		}
		
		else {
			
			System.out.println("No value to select in the dropdown");
		}
	}
}
