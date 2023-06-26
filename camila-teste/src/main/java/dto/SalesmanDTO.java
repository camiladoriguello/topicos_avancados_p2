package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesmanDTO {
	
	private long registry;
	private String name;
	private String whatsApp;
	private String lastSaleDate;
	private int performanceRate;

}