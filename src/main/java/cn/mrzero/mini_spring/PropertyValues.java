package cn.mrzero.mini_spring;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {

	private List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();
	
	public void addPropertyValue(PropertyValue pv) {
		this.propertyValueList.add(pv);
	}
	
	public List<PropertyValue> getPropertyValues() {
		return this.propertyValueList;
	}
}
