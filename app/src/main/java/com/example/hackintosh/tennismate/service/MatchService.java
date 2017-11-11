
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
    private static final String baseNode = "/match";

    public void createMatch(int playerLimit, int locationId, int terrainNumber, Runnable onComplete, Consumer<String> onError) {
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Match match = new Match(uid, playerLimit, new LinkedList<>(), locationId, terrainNumber);
        String id = UUID.randomUUID().toString();
        FirebaseHelper.setValue(getNode(id),match,onComplete,onError);

        //todo send push notiofication
    }

    public void getMatch(String id, Consumer<Match> onComplete, Consumer<String> onError){
        String node = getNode(id);
        FirebaseHelper.getValue(node,Match.class,onComplete,onError);
    }

    public void joinMatch(String id, Runnable onComplete, Consumer<String> onError){
        getMatch(id, (data) -> {
            if (data.hasOpenPlaces()){
                data.getJoins().add(FirebaseAuth.getInstance().getUid());
            }
            FirebaseHelper.setValue(getNode(id),data, onComplete, onError);
        }, onError);
    }

    private static String getNode(String id) {
        return String.format("%s/%s", baseNode, id);
    }
}
