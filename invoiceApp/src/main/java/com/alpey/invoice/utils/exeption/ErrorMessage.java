package com.alpey.invoice.utils.exeption;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

	private LocalDate timestamp;
	private String message;

}
