package com.telenor.kafkacosagreement.models;

import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOffer {
    private Integer id;
    private Integer value;

}
