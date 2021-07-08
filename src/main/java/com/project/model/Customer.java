package com.project.model;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.project.constants.AerospikeConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AerospikeRecord(namespace = AerospikeConstants.NAMESPACE, set = AerospikeConstants.CUSTOMER_SET)
public class Customer {
    @AerospikeKey
    private Long customerId;

    @AerospikeBin(name = AerospikeConstants.CUSTOMER_NAME)
    private String name;

    @AerospikeBin(name = AerospikeConstants.PHONE_NUMBER)
    private String phoneNo;
}
