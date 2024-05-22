package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.model.MedicalCheckUp;
import com.serice.MedicalService;

@Controller
public class PDFController {

	@Autowired
	private MedicalService service;

	@GetMapping("/getpdf")
	public void downloadPDF(HttpServletResponse response) {
		// Setting the response content type as PDF
		response.setContentType("application/pdf");
		// Setting the response header for file download
		response.setHeader("Content-Disposition", "attachment; filename=Medical-CheckUp-Booking.pdf");

		try {
			// Creating an object of Document to represent PDF
			Document document = new Document();
			// Obtaining a PdfWriter object in connection with HttpServletResponse's
			// OutputStream
			PdfWriter.getInstance(document, response.getOutputStream());
			// Opening the document
			document.open();

			// Defining font style, size, color for the title
			Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.RED);
			// creating paragrapgh for the title
			Paragraph title = new Paragraph("Booked List", titleFont);
			// setting title alignment to center of ODF
			title.setAlignment(Element.ALIGN_CENTER);
			// Adding title to the document(PDF)
			document.add(title);

			// Adding a new line after title
			document.add(Chunk.NEWLINE);

			// getting all employees from DB
			List<MedicalCheckUp> bookings = service.getAllBooking();

			if (!bookings.isEmpty()) {
				// Creating a Table with 5 columns
				PdfPTable table = new PdfPTable(6);
				// Defining column widths
				float[] columnWidths = { 3f, 8f, 4f, 4f, 6f, 6f };
				table.setWidths(columnWidths);

				// Adding header cells to the table(headings row)
				table.addCell(createHeaderCell("ID"));
				table.addCell(createHeaderCell("Name"));
				table.addCell(createHeaderCell("Age"));
				table.addCell(createHeaderCell("Gender"));
				table.addCell(createHeaderCell("Disease"));
				table.addCell(createHeaderCell("BookingDate"));

				// setting employee data to the table cells
				for (MedicalCheckUp book : bookings) {
					table.addCell(createCell(String.valueOf(book.getPatient_id())));
					table.addCell(createCell(book.getPatient_name()));
					table.addCell(createCell(String.valueOf(book.getAge())));
					table.addCell(createCell(book.getGender()));
					table.addCell(createCell(book.getDisease()));
					table.addCell(createCell(String.valueOf(book.getDate())));
				}

				// Adding the table to the document(PDF)
				document.add(table);
			} else {
				// Adding a message for no records found
				document.add(new Paragraph("No Employee records found."));
			}

			// Closing the document
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method to create a header cell with specified content
	private PdfPCell createHeaderCell(String content) {
		// creates a table cell with given content/data
		PdfPCell cell = new PdfPCell(new Phrase(content));
		// aligning to center
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		// setting background color
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		return cell;
	}

	// Method to create a cell with specified content
	private PdfPCell createCell(String content) {
		// creates a table cell with given content/data
		PdfPCell cell = new PdfPCell(new Phrase(content));
		// aligning to left
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		return cell;
	}
}