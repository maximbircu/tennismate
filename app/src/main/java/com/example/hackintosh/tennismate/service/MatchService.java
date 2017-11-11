
package com.example.hackintosh.tennismate.service;

import com.example.hackintosh.tennismate.dto.Match;
import com.example.hackintosh.tennismate.portability.Consumer;
import com.google.firebase.auth.FirebaseAuth;

import java.util.LinkedList;
import java.util.UUID;

/**
 * Created by nicu on 11/11/17.
 */

public class MatchService {
    private final String baseNode = "/match";

    public void createMatch(int playerLimit, int locationId, int terrainNumber, Runnable onComplete, Consumer<String> onError) {
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Match match = new Match(uid, playerLimit, new LinkedList<>(), locationId, terrainNumber);
        String id = UUID.randomUUID().toString();
        FirebaseHelper.setValue(String.format("%s/%s",baseNode,id),match,onComplete,onError);

        //todo send push notiofication
    }

    public void getMatch(String id, Consumer<Match> onComplete, Consumer<String> onError){
        String node = String.format("%s/%s", baseNode, id);
        FirebaseHelper.getValue(node,Match.class,onComplete,onError);
    }
}
