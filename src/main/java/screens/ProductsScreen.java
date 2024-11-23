package screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static elementutils.LocateStrategy.*;

import java.util.Comparator;
import java.util.List;

public class ProductsScreen {
	public WebDriver driver = null;

	public ProductsScreen(WebDriver driver) {
		this.driver = driver;
	}

	private static String PDT_LOGO_AN = "//*[@text='Products']";
	private static String PDT_LOGO_IOS = "//*[@text='Products']";
	private static String SORT_AN = "//*[@content-desc='sort button']";
	private static String SORT_IOS = "//*[@content-desc='sort button']";
	private static String ITEM_NAME_AN = "//*[@content-desc='store item text']";
	private static String ITEM_PRICE_AN = "//*[@content-desc='store item price']";
	private static String ITEM_NAME_IOS = "//*[@content-desc='store item text']";
	private static String ITEM_PRICE_IOS = "//*[@content-desc='store item price']";

	public boolean validateProductsScreensisVisible() {
		return getElementByXPath(driver, PDT_LOGO_AN, PDT_LOGO_IOS).isDisplayed();
	}

	public boolean validateProducts(List<String> products) {
		for (String product : products) {
			System.err.println("Found: " + product);
			if (!getElementByXPath(driver, "//*[@text='" + product + "']", "//*[@text='" + product + "']")
					.isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	public void clickSortButton() {
		getElementByXPath(driver, SORT_AN, SORT_IOS).click();
	}

	public void selectSort(String name, String type) {
		getElementByXPath(driver, "//*[@text='" + name + " - " + type + "']",
				"//*[@text='" + name + " - " + type + "']").click();
	}

	public void validateTypeSortedInExpectedOrder(String type, String order) {
		if (type.equalsIgnoreCase("price") && order.equalsIgnoreCase("asc")) {
			validateSortOrder(getElementsByXPath(driver, ITEM_PRICE_AN, ITEM_PRICE_IOS), order);
		} else if (type.equalsIgnoreCase("price") && order.equalsIgnoreCase("desc")) {
			validateSortOrder(getElementsByXPath(driver, ITEM_PRICE_AN, ITEM_PRICE_IOS), order);
		} else if (type.equalsIgnoreCase("items") && order.equalsIgnoreCase("asc")) {
			validateSortOrder(getElementsByXPath(driver, ITEM_NAME_AN, ITEM_NAME_IOS), order);
		} else if (type.equalsIgnoreCase("items") && order.equalsIgnoreCase("desc")) {
			validateSortOrder(getElementsByXPath(driver, ITEM_NAME_AN, ITEM_NAME_IOS), order);
		}

	}

	public boolean validateSortOrder(List<WebElement> elements, String order) {
		List<String> texts = elements.stream().map(WebElement::getText).toList();
		System.out.println(texts);

		Comparator<String> comparator;
		if (order.equalsIgnoreCase("asc")) {
			comparator = String::compareTo;
		} else if (order.equalsIgnoreCase("desc")) {
			comparator = Comparator.reverseOrder();
		} else {
			throw new IllegalArgumentException("Invalid order specified. Use 'asc' or 'desc'.");
		}
		for (int i = 0; i < texts.size() - 1; i++) {
			if (comparator.compare(texts.get(i), texts.get(i + 1)) > 0) {
				System.err.println("List is not sorted in " + order + " order.");
				return false;
			}
		}
		return true;
	}
	
	public void selectProduct(String product) {
		getElementByXPath(driver, "//*[@text='"+product+"']", "//*[@text='"+product+"']").click();
	}

}
