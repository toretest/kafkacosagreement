package com.telenor.kafkacosagreement.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgreementOfferResult {
    boolean valid;
    ErrorMessage errorMessage;
}
