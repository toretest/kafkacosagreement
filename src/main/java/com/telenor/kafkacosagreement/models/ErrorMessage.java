package com.telenor.kafkacosagreement.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage
{
    Integer ErrorCode;
    String ErrorMessage;
}
