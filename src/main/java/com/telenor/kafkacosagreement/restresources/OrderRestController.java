package com.telenor.kafkacosagreement.restresources;

import com.telenor.kafkacosagreement.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/api/")
public class OrderRestController {
    private KafkaTemplate<String, Hallo> kafkaTemplate;

    @Autowired
    public OrderRestController(KafkaTemplate<String, Hallo> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping(value = "placeagreementorder",
            produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<AgreementOfferResult> orderAgreement(@RequestBody OrderRequest orderRequest) {
        try {
            AgreementOfferResult agreementOfferResult = AgreementOfferResult.builder().valid(true).build();

            ProductOffer productOffer = ProductOffer
                    .builder()
                    .id(222)
                    .value(222)
                    .build();

            Hallo hallo = new Hallo("aaaaaaaaaaaaa","ssssssssssss");


            kafkaTemplate.send("agreementOrderTopic", hallo);
            return ResponseEntity.ok(AgreementOfferResult.builder().valid(true).build());
        } catch (Exception e) {
            System.out.println("***************"+e.getMessage());
            ErrorMessage errorMessage=ErrorMessage.builder().ErrorCode(400).ErrorMessage(e.getMessage()).build();
            return ResponseEntity.status(400)
                    .body(AgreementOfferResult
                            .builder()
                            .valid(false)
                            .errorMessage(errorMessage)
                            .build());
        }

    }
}
