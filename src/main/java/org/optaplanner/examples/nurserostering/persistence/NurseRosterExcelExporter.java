package org.optaplanner.examples.nurserostering.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.optaplanner.examples.common.persistence.AbstractXlsxSolutionExporter;

import org.optaplanner.examples.nurserostering.domain.Employee;
import org.optaplanner.examples.nurserostering.domain.NurseRoster;

import org.optaplanner.examples.nurserostering.domain.ShiftAssignment;
import org.optaplanner.examples.nurserostering.domain.ShiftDate;

public class NurseRosterExcelExporter
		extends
			AbstractXlsxSolutionExporter<NurseRoster> {

	@Override
	public XlxsOutputBuilder<NurseRoster> createXlxsOutputBuilder() {
		return new NurseRosteringOutputBuilder();
	}

	public static class NurseRosteringOutputBuilder
			extends
				XlxsOutputBuilder<NurseRoster> {

		private NurseRoster nurseRoster;

		public void setSolution(NurseRoster solution) {
			nurseRoster = solution;
		}

		public void writeSolution(File outputFile) {

			final List<ShiftAssignment> assignment = (List<ShiftAssignment>) nurseRoster
					.getShiftAssignmentList();
			List<ShiftDate> shiftDateList = (List<ShiftDate>) nurseRoster
					.getShiftDateList();

			// Turn the list into a map
			Map<Employee, List<ShiftAssignment>> assignmentMap = assignment
					.stream().collect(Collectors
							.groupingBy(ShiftAssignment::getEmployee));

			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("ShiftAssignments");

			CellStyle style = workbook.createCellStyle();
			Set<Employee> keyset = assignmentMap.keySet();

			DataFormatter formatter = new DataFormatter();
			// set up date header which is what I want with shift types under

			Row header = sheet.createRow(1);
			Sheet sheet1 = workbook.getSheetAt(0);
			int cellPlus = 1;

			for (ShiftDate datekey : shiftDateList) {
				header.createCell(cellPlus++)
						.setCellValue(datekey.getDate().toString());
				// TODO add style for header

				int rowNum = 2;
				int cellIndex = 0;
				for (Employee key : keyset) {
					// doesn't move the cell but increments the row later

					Row row = sheet.createRow(rowNum++);
					row.createCell(cellIndex).setCellValue(key.getName());
					sheet.autoSizeColumn(cellIndex);
					// Places the each employees details into list
					List<ShiftAssignment> objArr = assignmentMap.get(key);

					for (ShiftAssignment obj : objArr) {

						for (Row row1 : sheet1) {
							for (Cell cellelement : row1) {

								String text = formatter
										.formatCellValue(cellelement);
								// places the value against the right date

								if (obj.getShiftDate().getDate().toString()
										.equals(text)) {
									int cellvalue = cellelement
											.getColumnIndex();
									Cell cell = row.createCell(cellvalue++);

									cell.setCellValue(
											obj.getShiftType().getCode());

									if (obj.getShiftType().getCode()
											.equalsIgnoreCase("D")) {
										style = workbook.createCellStyle();
										style.setFillForegroundColor(
												IndexedColors.BLUE.getIndex());
										style.setFillPattern(
												FillPatternType.SOLID_FOREGROUND);
										cell.setCellStyle(style);
									}
									if (obj.getShiftType().getCode()
											.equalsIgnoreCase("E")) {
										style = workbook.createCellStyle();
										style.setFillForegroundColor(
												IndexedColors.RED.getIndex());
										style.setFillPattern(
												FillPatternType.SOLID_FOREGROUND);
										cell.setCellStyle(style);
									}

									if (obj.getShiftType().getCode()
											.equalsIgnoreCase("L")) {
										style = workbook.createCellStyle();
										style.setFillForegroundColor(
												IndexedColors.GREEN.getIndex());
										style.setFillPattern(
												FillPatternType.SOLID_FOREGROUND);
										cell.setCellStyle(style);
									}
									if (obj.getShiftType().getCode()
											.equalsIgnoreCase("N")) {
										style = workbook.createCellStyle();
										style.setFillForegroundColor(
												IndexedColors.YELLOW
														.getIndex());
										style.setFillPattern(
												FillPatternType.SOLID_FOREGROUND);
										cell.setCellStyle(style);
									}

								}
							}
						}
					}
				}

			}

			try {

				// Output to selected file
				FileOutputStream fos = new FileOutputStream(outputFile);
				workbook.write(fos);
				fos.flush();
				workbook.close();

			} catch (FileNotFoundException e) {

				e.printStackTrace();

				System.out.println("Invalid directory or file not found");

			} catch (IOException e) {

				e.printStackTrace();

				System.out.println(
						"Error occurred while writting excel file to directory");

			}

		}

	}

}
