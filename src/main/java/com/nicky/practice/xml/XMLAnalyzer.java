package com.nicky.practice.xml;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * analyze xml for location(Country/Pro/City)
 */
public class XMLAnalyzer {

	private static final String INDENT = "    ";
	private static final String NODE_NAME = "Name";
	private static final String LOC_XML_LOCATION = "src/config/locList.xml";

	public void setUpDBConnection(List<Integer> code, List<String> locationNames, List<String> types,
			List<Integer> parentCode) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		con.setAutoCommit(false);
		Statement statement = con.createStatement();
		statement.execute("delete from sys_location");

		PreparedStatement perstmt = con
				.prepareStatement("insert into sys_location (code, name, type, parent_code) values (?,?,?,?)");

		for (int i = 0; i < locationNames.size(); i++) {
			try {
				perstmt.setInt(1, code.get(i));
				perstmt.setString(2, locationNames.get(i));
				perstmt.setString(3, types.get(i));
				perstmt.setInt(4, parentCode.get(i));
				perstmt.addBatch();
			} catch (SQLException e) {
				e.printStackTrace();
				continue;
			}
		}
		perstmt.executeBatch();
		con.commit();
		con.close();

	}

	private List<String> MUNICIPALITY = Lists.newArrayList("北京", "上海", "天津", "重庆");

	// prov, citi, town
	List<Integer> codes = Lists.newArrayList();
	List<String> locationNames = Lists.newArrayList();
	List<String> types = Lists.newArrayList();
	List<Integer> parentCodes = Lists.newArrayList();

	@Test
	public void analyse() throws JDOMException, IOException, ClassNotFoundException, SQLException {
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(new File(LOC_XML_LOCATION));
		Element element = doc.getRootElement();
		Integer code = 1;
		Integer parentCode = 0;
		List<Element> countries = element.getChildren();
		for (Element country : countries) {
			String countryName = country.getAttributeValue(NODE_NAME);
			System.out.println(countryName);
			if ("中国".equals(countryName)) {
				List<Element> states = country.getChildren();
				for (Element state : states) {
					String stateName = state.getAttributeValue(NODE_NAME);
					parentCode = code;

					code = formLocations(code, 0, stateName, "prov");

					printElement(state, 1);

					List<Element> cities = state.getChildren();
					if (MUNICIPALITY.contains(stateName)) {
						int cityCode = code;
						
						code = formLocations(code, parentCode, stateName, "city");
						
						for (Element city : cities) {
							printElement(city, 2);
							String townName = city.getAttributeValue(NODE_NAME);
							code = formLocations(code, cityCode, townName, "town");
						}
					} else {
						for (Element city : cities) {
							printElement(city, 2);
							String cityName = city.getAttributeValue(NODE_NAME);
							int cityCode = code;
							code = formLocations(code, parentCode, cityName, "city");

							List<Element> regions = city.getChildren();
							for (Element region : regions) {
								printElement(region, 3);
								String regionName = region.getAttributeValue(NODE_NAME);
								code = formLocations(code, cityCode, regionName, "town");
							}
						}
					}
				}
				break;
			}
		}
		setUpDBConnection(codes, locationNames, types, parentCodes);

	}

	private Integer formLocations(Integer code, int parentCode, String townName, String type) {
		codes.add(code++);
		locationNames.add(townName);
		parentCodes.add(parentCode);
		types.add(type);
		return code;
	}

	private void printElement(Element state, int indentCount) {
		System.out.println(state.getAttributeValue(NODE_NAME) == null ? printIndents(indentCount)
				: printIndents(indentCount) + state.getAttributeValue(NODE_NAME));
	}

	private String printIndents(int count) {
		StringBuilder result = new StringBuilder();
		while (count > 0) {
			result.append(INDENT);
			count--;
		}
		return result.toString();
	}
}
