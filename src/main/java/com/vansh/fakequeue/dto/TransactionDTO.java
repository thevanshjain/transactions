package com.vansh.fakequeue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private Long accountNumber;
    private String type;
    private Long amount;
    private String currency;
    private Long accountFrom;
}
