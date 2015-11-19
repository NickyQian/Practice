package com.practice.crawl;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import com.google.common.collect.Maps;

public class WebContentCrawler {

	static PrintWriter printer;

	static String ZEROS = "0000000000";

	static String baseUrl = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2013/";

	public static Map<String, String> provinces = Maps.newLinkedHashMap();

	public static void generateProvince() throws IOException {
		Document docLv1 = Jsoup.connect(baseUrl).get();
		Elements alinks = docLv1.select(".provincetable tr a");
		for (int i = 0; i < alinks.size(); i++) {
			Element e = alinks.get(i);
			provinces.put(e.attr("href"), ((TextNode) e.childNode(0)).text());
		}
	}

	public static void printName(String baseUrl, String pageName) throws InterruptedException {
		String currentUrl = baseUrl.substring(0, baseUrl.lastIndexOf("/")) + '/' + pageName;
		Document docLv1 = null;
		docLv1 = getConnectedToRemoteServer(currentUrl, docLv1);
		Elements tables = docLv1.select("table");
		for (Element table : tables) {
			if (isValidTable(table)) {
				int count = countIndents(table);
				Elements trs = docLv1.select("." + table.attr("class") + " tr");
				for (int i = 0; i < trs.size(); i++) {
					if (trs.get(i).attr("class").contains("tr")) {
						Element e = trs.get(i);
						Elements a = e.getElementsByTag("a");
						if (a.size() > 0) {
							printIndents(count);
							// printer.print(a.get(0).attr("href"));
							printer.print("\t");
							printer.print(a.get(0).html());
							printer.print("\t");
							printer.println(a.get(1).html());
							printName(currentUrl, a.get(0).attr("href"));
						}
					}
				}
			}
		}

	}

	public static String readHtml(String myurl) {
		StringBuffer sb = new StringBuffer("");
		URL url;
		try {
			url = new URL(myurl);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "gb2312"));
			String s = "";
			while ((s = br.readLine()) != null) {
				sb.append(s + "\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	private static Document getConnectedToRemoteServer(String currentUrl, Document docLv1) {
		docLv1 = Jsoup.parse(readHtml(currentUrl), "utf-8");
		return docLv1;
	}

	private static boolean isValidTable(Element table) {
		return table.attr("class").equals("citytable") || table.attr("class").equals("countytable")
				|| table.attr("class").equals("towntable");
	}

	private static void printIndents(int count) {
		for (int j = 0; j < count; j++) {
			printer.print("\t\t");
		}
	}

	private static int countIndents(Element table) {
		int count = 0;
		String tableClass = table.attr("class");
		if (tableClass.equals("citytable")) {
			count = 1;
		} else if (tableClass.equals("countytable")) {
			count = 2;
		} else if (tableClass.equals("towntable")) {
			count = 3;
		}
		return count;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		printer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("d://location.txt"), "UTF-8"));
		// writer = new PrintWriter(System.out);
		long startTime = System.currentTimeMillis();
		generateProvince();
		for (Entry<String, String> entry : provinces.entrySet()) {
			int index = entry.getKey().lastIndexOf(".html");
			System.out.println("正在处理 " + entry.getValue() + "....");
			long start = System.currentTimeMillis();
			printer.print(entry.getKey().substring(0, index) + ZEROS);
			printer.print("\t");
			printer.println(entry.getValue());
			printName(baseUrl, entry.getKey());
			long end = System.currentTimeMillis();

			System.out.println("正在处理 " + entry.getValue() + "结束。耗时" + ((end - start) / 1000) + "秒。");
		}
		long endTime = System.currentTimeMillis();
		System.out.println("处理完毕，耗时 " + ((endTime - startTime) / 1000) / 60 + "分钟。");
		printer.close();
	}
}
