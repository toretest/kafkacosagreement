package com.telenor.kafkacosagreement.models;

import lombok.*;

import java.util.Arrays;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private AgreementOffer agreementOffer;
}
