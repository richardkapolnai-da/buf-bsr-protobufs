package com.digitalasset.bindings;

import com.daml.ledger.api.v2.admin.PartyManagementServiceGrpc;
import com.daml.ledger.api.v2.admin.PartyManagementServiceGrpc.PartyManagementServiceBlockingStub;
import com.daml.ledger.api.v2.admin.PartyManagementServiceOuterClass.AllocatePartyRequest;
import com.daml.ledger.api.v2.admin.PartyManagementServiceOuterClass.AllocatePartyResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AllocatePartyV2Example {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 6865;

        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();

        PartyManagementServiceBlockingStub stub = PartyManagementServiceGrpc.newBlockingStub(channel);

        AllocatePartyRequest request = AllocatePartyRequest.newBuilder()
                .setPartyIdHint("alice-v2")
                .build();

        AllocatePartyResponse response = stub.allocateParty(request);

        System.out.println(response.getPartyDetails().getParty());

        channel.shutdown();
    }
}

