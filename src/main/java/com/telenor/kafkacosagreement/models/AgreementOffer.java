package com.telenor.kafkacosagreement.models;

import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgreementOffer {

    private Integer AgreementOfferId;
    private List<ProductOffer> productOffers;
}
