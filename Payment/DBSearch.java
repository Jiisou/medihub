package oop_kiosk_medihub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBSearch {
	private static final String URL = "jdbc:mysql://localhost:3306/medihub";
	private static final String user = "admin";
	private static final String pw = "12345678";
	
	public static DocumentItem searchRecord(String input) {
		DocumentItem searchResult = new DocumentItem();
		
		try (Connection c = DriverManager.getConnection(URL, user, pw)){
			String sql = "SELECT * FROM patients WHERE id = ?";
			try (PreparedStatement pstmt = c.prepareStatement(sql)) {
				pstmt.setString(1, input);
				try (ResultSet rs = pstmt.executeQuery()) {
					if (rs.next()) {
					/*String name = rs.getString("name");
					String number = rs.getString("number");
					String medicalReport = rs.getString("medicalreport");
					String office = rs.getString("office");
					String disease = rs.getString("disease");
					String medicine = rs.getString("medicine");
					String doses = rs.getString("doses");
					String new_column = rs.getString("new_column"); //fee 진료비
					searchresult.setName(name);*/
						searchResult.setName(rs.getString("name"));
						searchResult.setNumber(rs.getString("number"));
						searchResult.setMedicalReport(rs.getString("medicalreport"));
						searchResult.setOffice("office");
						searchResult.setDisease("disease");
						searchResult.setMedicine("medicine");
						searchResult.setDoses("doses");
						searchResult.setFee("new_column");
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return searchResult;
	}
}
