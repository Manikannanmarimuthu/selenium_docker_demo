package com.mvi.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.google.gson.Gson;
import com.mvi.constants.BIZOPSUIConstants;

public class ExcelReader {

	public static Map<String, Object> readExcel(String filePath, String sheetName, String testCaseID) {
		Map<String, Object> result = new HashMap<>();
		Map<String, String> dataMap = new ConcurrentHashMap<>();
		String foundTestCaseID = "";
		try (Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath))) {
			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				throw new IllegalArgumentException("Sheet '" + sheetName + "' not found.");
			}
			Row headerRow = sheet.getRow(0);
			int testCaseIDIndex = -1;
			Iterator<Cell> cellIterator = headerRow.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if (cell.getStringCellValue().equalsIgnoreCase("TestCaseID")) {
					testCaseIDIndex = cell.getColumnIndex();
					break;
				}
			}
			if (testCaseIDIndex == -1) {
				throw new IllegalArgumentException("TestCaseID column not found.");
			}
			for (Row row : sheet) {
				if (row.getRowNum() == 0) {
					continue;
				}
				Cell testCaseIDCell = row.getCell(testCaseIDIndex);
				if (testCaseIDCell != null && testCaseIDCell.getStringCellValue().equalsIgnoreCase(testCaseID)) {
					foundTestCaseID = testCaseID;
					for (Cell cell : row) {
						if (cell.getColumnIndex() != testCaseIDIndex) {
							String header = headerRow.getCell(cell.getColumnIndex()).getStringCellValue();
							String value = cell.getStringCellValue();
							value = SpecialValueProcessor.processSpecialValue(value);
							dataMap.put(header, value);
						}
					}
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		result.put("TestCaseID", foundTestCaseID);
		result.put("TestData", dataMap);
		return result;
	}

	public String generateJsonFile(String filePath, String sheetName, String testCaseID) {
		Map<String, Object> testResult = readExcel(filePath, sheetName, testCaseID);
		File theDir = new File(BIZOPSUIConstants.getUiRuntimeTestdataLoc());
		if (!theDir.exists()) {
			theDir.mkdirs();
		}
		String jsonFileName = BIZOPSUIConstants.getUiRuntimeTestdataLoc() + testResult.get("TestCaseID") + ".json";
		File file = new File(jsonFileName);
		if (file.exists()) {
			file.delete();
		}
		String jsonData = new Gson().toJson(testResult.get("TestData"));
		try (FileWriter fileWriter = new FileWriter(jsonFileName)) {
			fileWriter.write(jsonData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonFileName; // Return the path of the generated JSON file
	}
}
